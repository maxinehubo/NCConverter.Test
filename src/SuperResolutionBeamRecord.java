import opendap.servlet.www.wwwArray;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sugar
 * Date: 7/15/13
 * Time: 2:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class SuperResolutionBeamRecord extends BeamRecord {

    public SuperResolutionBeamRecord(Radar radar, VCPMode vcp, double elevation, Date startTime) {
        //Super-resolution is 250m x 0.5deg
        super(radar, vcp, elevation, startTime, 250, 0.5);


    }


}
