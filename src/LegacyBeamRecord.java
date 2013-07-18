/**
 * Created with IntelliJ IDEA.
 * User: sugar
 * Date: 7/15/13
 * Time: 3:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class LegacyBeamRecord extends BeamRecord {

    public LegacyBeamRecord(long beamTime, Radar radar, VCPMode vcp, double azimuth, double elevation) {
        //Legacy resolution is 1000m x 1deg
        super(beamTime, radar, vcp, elevation, azimuth, 1000, 1.0);

    }
}
