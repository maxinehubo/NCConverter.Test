import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 *
 */

/**
 * @author sugar
 */
public abstract class BeamRecord implements IBeamRecord {

    protected Radar radar;
    protected VCPMode vcp;
    protected long beamTime;
    protected double Azimuth;
    protected ArrayList<Double> binValues;
    protected int binIndex = 0;
    protected double azimuthSpacing;

    protected double gateWidth = 1;
    protected double beamWidth = 1;
    protected double elevation;


    public BeamRecord(long beamTime, Radar radar, VCPMode vcp, double elevation, double Azimuth, double gatesWidth, double beamWidth) {
        this.radar = radar;
        this.vcp = vcp;
        this.elevation = elevation;
        this.beamTime = beamTime;
        this.Azimuth = Azimuth;
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
        return binValues.size();
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getBinValue(int)
     */
    @Override
    public double getBinValue(int index) {
        return binValues.get(index).doubleValue();
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getBeamTime()
     */
    @Override
    public long getBeamTime() {
        return this.beamTime;
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getRadar()
     */
    @Override
    public Radar getRadar() {
        return this.radar;
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getVCPMode()
     */
    @Override
    public VCPMode getVCPMode() {
        return this.vcp;
    }

    /* (non-Javadoc)
     * @see IBeamRecord#getNextValue()
     */
    @Override
    public double getNextValue() {
        throw new NotImplementedException();
    }

    @Override
    public double getAzimuth() {
        return this.Azimuth;
    }

    @Override
    public double getElevation() {
        return this.elevation;
    }

}
