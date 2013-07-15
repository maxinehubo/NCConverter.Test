import java.io.IOException;

import com.bbn.openmap.proj.coords.LatLonPoint;

import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;


public class MainClass {

	
	public int vcpValue = 0;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MainClass app = new MainClass();
		app.test();
	}
	
	public void test() throws IOException {
		NetcdfFile ncfile = NetcdfFile.open("/home/sugar/workspaces/projects/20040814-001428.netcdf");
		for(Variable var : ncfile.getVariables())
		{
			System.out.println(var.getNameAndDimensions());
		}
		System.out.println("----------");
		for(Dimension dim : ncfile.getDimensions())
		{
			System.out.println(dim.getFullName() + ":" + dim.getLength());
		}
		System.out.println("----------");
		for(Attribute attr : ncfile.getGlobalAttributes())
		{
			System.out.print(attr.getFullName() + ":");
			System.out.println(attr.getValues());
		}
		System.out.println("----------");
		int vcpModeNumber = Integer.parseInt(ncfile.findGlobalAttribute("vcp-value").getStringValue());
		String radarName = ncfile.findGlobalAttribute("radarName-value").getStringValue();
		LatLonPoint radarPos = new LatLonPoint.Double(
				(double) ncfile.findGlobalAttribute("Latitude").getValue(0),
				(double) ncfile.findGlobalAttribute("Longitude").getValue(0));
		double height = (double) ncfile.findGlobalAttribute("Height").getValue(0);
		String productName = ncfile.findGlobalAttribute("TypeName").getStringValue();
		double elevation = (double) ncfile.findGlobalAttribute("Elevation").getValue(0);
		String dataType = ncfile.findGlobalAttribute("DataType").getStringValue();
		
		if (dataType == "SparseRadialSet") {
			SparseRadialSetClass product = new SparseRadialSetClass();
			
		} else {
			
		}
		
	}
	
}
