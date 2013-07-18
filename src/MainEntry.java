import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import com.bbn.openmap.proj.coords.LatLonPoint;

import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;


public class MainEntry {


    public int vcpValue = 0;

    public HashMap<Long, BeamRecord> BeamSet = new HashMap<>();
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, ParseException {
        MainEntry app = new MainEntry();
        app.test("/home/sugar/workspaces/projects/20040814-001428.netcdf");
    }

    public void test(String input_data) throws IOException {
        NetcdfFile ncfile = NetcdfFile.open(input_data);

        //For development and debug use. Print all information.
        for (Variable var : ncfile.getVariables()) {
            System.out.println(var.getNameAndDimensions());
        }
        System.out.println("----------");
        for (Dimension dim : ncfile.getDimensions()) {
            System.out.println(dim.getFullName() + ":" + dim.getLength());
        }
        System.out.println("----------");
        for (Attribute attr : ncfile.getGlobalAttributes()) {
            System.out.print(attr.getFullName() + ":");
            System.out.println(attr.getValues());
        }
        System.out.println("----------");

        //Get attributes
        String vcpModeString = ncfile.findGlobalAttribute("vcp-value").getStringValue();
        String radarName = ncfile.findGlobalAttribute("radarName-value").getStringValue();
        LatLonPoint radarPos = new LatLonPoint.Double(
                (double) ncfile.findGlobalAttribute("Latitude").getValue(0),
                (double) ncfile.findGlobalAttribute("Longitude").getValue(0));
        double height = (double) ncfile.findGlobalAttribute("Height").getValue(0);
        String productName = ncfile.findGlobalAttribute("TypeName").getStringValue();
        double elevation = (double) ncfile.findGlobalAttribute("Elevation").getValue(0);
        double subType = Double.parseDouble(ncfile.findGlobalAttribute("SubType-value").getStringValue());
        String dataType = ncfile.findGlobalAttribute("DataType").getStringValue();
        //Works until to year about 2030, Large enough.
        long startTime = ((Integer) ncfile.findGlobalAttribute("Time").getValue(0)) * 1000l;

        //Get GateWidth to determine legacy or super-resolution (dual-polarize incl.)
        boolean legacy = (ncfile.findVariable("GateWidth").read().getInt(0) == 1000);

        //Get dimension size.
        int sizeAzimuth = ncfile.findDimension("Azimuth").getLength();
        int sizeGate = ncfile.findDimension("Gate").getLength();

        //Get variables.
        Variable var_pixel_x = ncfile.findVariable("pixel_x");
        int[] pixel_x = UtilClass.ShortArrayToIntArray((short[]) var_pixel_x.read().copyTo1DJavaArray());
        Variable var_pixel_y = ncfile.findVariable("pixel_y");
        int[] pixel_y = UtilClass.ShortArrayToIntArray((short[]) var_pixel_y.read().copyTo1DJavaArray());
        Variable var_pixel_c = ncfile.findVariable("pixel_count");
        int[] pixel_c = (int[]) var_pixel_c.read().copyTo1DJavaArray();
        Variable varReflectivity = ncfile.findVariable("ReflectivityQC");
        double[] reflectivity = UtilClass.FloatArrayToDoubleArray((float[]) varReflectivity.read().copyTo1DJavaArray());
        Variable varAzimuth = ncfile.findVariable("Azimuth");
        double[] azimuth = UtilClass.FloatArrayToDoubleArray((float[]) varAzimuth.read().copyTo1DJavaArray());
        Variable varAzimuthSp = ncfile.findVariable("AzimuthalSpacing");
        double[] azimuthSp = UtilClass.FloatArrayToDoubleArray((float[]) varAzimuthSp.read().copyTo1DJavaArray());

        if (dataType.equals("SparseRadialSet")) {
            SparseRadialSetClass product = new SparseRadialSetClass();
            product.setPixelX(pixel_x);
            product.setPixelY(pixel_y);
            product.setPixelCount(pixel_c);
            product.setSize(sizeAzimuth, sizeGate);
            product.setEncodedValues(reflectivity);
            if (product.decodeSet()) {
                //Generate beams based on records for each Azimuths
                VCPMode VCP = new VCPMode(vcpModeString);
                double unitTime = productName.equals("ReflectivityQC") ? VCP.getAZRate(subType, VCPMode.Waveform.CS) : VCP.getAZRate(subType, VCPMode.Waveform.CD);
                //Get radar
                Radar radar = new Radar(radarName);
                for (int i = 0; i < product.decodedValues.length; i++)
                {
                    double[] p = product.decodedValues[i];
                    long currentTime = startTime + (long)((azimuth[i] - azimuth[0]) * unitTime);
                    BeamRecord beam;
                    if(legacy){
                        beam = new LegacyBeamRecord(radar, VCP, elevation, currentTime);
                    } else {
                        beam = new SuperResolutionBeamRecord(radar, VCP, elevation, currentTime);
                    }
                    beam.azimuthSpacing = azimuthSp[i];
                    //Each gate in beam
                    for (double q: p)
                    {
                        beam.addBin(q);
                    }
                    this.BeamSet.put(currentTime, beam);
                }
                System.out.println(this.BeamSet.size());
            } else {
                System.out.println("Decode failed on " + input_data);
            }
        } else {
            System.out.println("Type error: not a SparseRadialSet");
        }

    }


}
