import java.awt.geom.Point2D;
import java.util.HashMap;

import com.bbn.openmap.proj.coords.LatLonPoint;

public class Radar {

    //double[Lat,Lon,X,Y] -> Don't forget that Y is latitude and X is longitude
    protected static HashMap<String, double[]> Radars = new HashMap<String, double[]>();

    protected String radarName;

    private Radar()
    {
        //If it is empty, do initialize the radars
        if(Radars.isEmpty())
        {

        }
    }

    public Radar(String radarName) {
        this();
        this.radarName = radarName;
    }

    public Point2D getXYCoordinates() {
        return new Point2D.Double(Radars.get(radarName)[2], Radars.get(radarName)[3]);
    }

    public LatLonPoint getLatLon() {
        return new LatLonPoint.Double(Radars.get(radarName)[0],Radars.get(radarName)[1]);
    }

    /*
    Use static subclasses to describe all radars. Might be more logical. KOKX is a test.
     */
    public static class KOKX extends Radar {
        public KOKX() {
            super("KOKX");
        }
    }
}
