import java.util.HashMap;

public class VCPMode {

    //Map Elevation -> AZRate
    //For Reflectivity
    protected HashMap<Double, Double> AZRate;
    //For Velocity and Spectrum Width, only small difference between them
    protected HashMap<Double, Double> AZRate2;

    //Waveform CS is used for reflectivity product and Waveform CD is used for velocity and spectrum-width products
    public static enum Waveform {CS, CD, Other}

    private String ScanMode;

    public VCPMode(String scanMode) {
        this.ScanMode = scanMode;
        switch (this.ScanMode) {
            case "12":
                initVCP12();
                break;
            default:
                throw new IllegalArgumentException("Unknown VCP Codes.");
        }

    }

    public double getAZRate(double subType, Waveform scan) {
        return scan == Waveform.CS ? AZRate.get(subType) : AZRate2.get(subType);
    }

    private void initVCP12() {
        HashMap<Double, Double> m1 = new HashMap<>();
        m1.put(0.500000, 1 / 17.020000);
        m1.put(0.900000, 1 / 17.020000);
        m1.put(1.300000, 1 / 17.020000);
        m1.put(1.800000, 1 / 14.610000);
        m1.put(2.400000, 1 / 13.640000);
        m1.put(3.100000, 1 / 13.640000);
        m1.put(4.000000, 1 / 13.640000);
        m1.put(5.100000, 1 / 12.860000);
        m1.put(6.400000, 1 / 12.860000);
        m1.put(8.000000, 1 / 12.680000);
        m1.put(10.000000, 1 / 12.460000);
        m1.put(12.500000, 1 / 12.530000);
        m1.put(15.600000, 1 / 12.530000);
        m1.put(19.500000, 1 / 12.530000);
        HashMap<Double, Double> m2 = (HashMap<Double, Double>) m1.clone();
        m2.put(0.500000, 1 / 14.400000);
        m2.put(0.900000, 1 / 14.400000);
        m2.put(1.300000, 1 / 14.400000);
        this.AZRate = m1;
        this.AZRate2 = m2;
    }

}
