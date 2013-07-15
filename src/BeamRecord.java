import java.util.ArrayList;
import java.util.Date;

/**
 *
 */

/**
 * @author sugar
 */
public abstract class BeamRecord implements IBeamRecord {

    protected Radar radar;
    protected double elevation;
    protected VCPMode vcp;
    protected Date startTime;
    protected ArrayList<Double> binValues;
    protected int binIndex = 0;
    protected double gateWidth = 1;
    protected double beamWidth = 1;

    public BeamRecord(Radar radar, VCPMode vcp, double elevation, Date startTime, double gatesWidth, double beamWidth) {
        this.radar = radar;
        this.vcp = vcp;
        this.elevation = elevation;
        this.startTime = startTime;
        this.binValues = new ArrayList<Double>(460);
        this.gateWidth = gatesWidth;
        this.beamWidth = beamWidth;
    }

    public void addBin(Double value) {
        binValues.add(value);
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getBinCount()
     */
    @Override
    public int getBinCount() {
        // TODO Auto-generated method stub
        return binValues.size();
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getBinValue(int)
     */
    @Override
    public double getBinValue(int index) {
        // TODO Auto-generated method stub
        return binValues.get(index).doubleValue();
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getBeamTime()
     */
    @Override
    public Date getBeamTime() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getRadar()
     */
    @Override
    public Radar getRadar() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getVCPMode()
     */
    @Override
    public VCPMode getVCPMode() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getNextValue()
     */
    @Override
    public double getNextValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getElevation() {
        // TODO Auto-generated method stub
        return 0;
    }

}
