import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sugar
 * Date: 7/15/13
 * Time: 3:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class LegacyBeamRecord extends BeamRecord {

    public LegacyBeamRecord(Radar radar, VCPMode vcp, double elevation, Date startTime) {
        super(radar, vcp, elevation, startTime, 1000, 1.0);
    }
}