/**
 * Created with IntelliJ IDEA.
 * User: sugar
 * Date: 7/15/13
 * Time: 2:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class SuperResolutionBeamRecord extends BeamRecord {

    public SuperResolutionBeamRecord(long beamTime, Radar radar, VCPMode vcp, double elevation, double azimuth) {
        //Super-resolution is 250m x 0.5deg
        super(beamTime, radar, vcp, elevation, azimuth, 250, 0.5);


    }


}
