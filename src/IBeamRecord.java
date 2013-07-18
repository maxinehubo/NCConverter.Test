import java.util.Date;

/**
 * 
 */

/**
 * @author sugar
 *
 */
public interface IBeamRecord {
	
	public int getBinCount();
	
	public double getBinValue(int index);
	
	public long getBeamTime();
	
	public Radar getRadar();
	
	public VCPMode getVCPMode();
	
	public double getElevation();
	
	public double getNextValue();

    public double getAzimuth();

}
