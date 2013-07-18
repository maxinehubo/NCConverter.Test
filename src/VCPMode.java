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
        double unit = scan == Waveform.CS ? AZRate.get(subType) : AZRate2.get(subType);
        return unit * 1000.0;
    }

    private void initVCP12() {
        HashMap<Double, Double> m1 = new HashMap<>();
        m1.put(0.500000,1/21.150000);
        m1.put(0.900000,1/21.150000);
        m1.put(1.300000,1/21.150000);
        m1.put(1.800000,1/26.640000);
        m1.put(2.400000,1/26.400000);
        m1.put(3.100000,1/26.400000);
        m1.put(4.000000,1/26.400000);
        m1.put(5.100000,1/28.010000);
        m1.put(6.400000,1/28.010000);
        m1.put(8.000000,1/28.400000);
        m1.put(10.000000,1/28.884000);
        m1.put(12.500000,1/28.741000);
        m1.put(15.600000,1/28.741000);
        m1.put(19.500000,1/28.741000);
        HashMap<Double, Double> m2 = (HashMap<Double, Double>) m1.clone();
        m2.put(0.500000,1/25.000000);
        m2.put(0.900000,1/25.000000);
        m2.put(1.300000,1/25.000000);
        this.AZRate = m1;
        this.AZRate2 = m2;
    }

}
