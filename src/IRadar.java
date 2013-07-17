import com.bbn.openmap.proj.coords.LatLonPoint;

import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: sugar
 * Date: 7/15/13
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRadar {

    public Point2D getXYCoordinates();

    public LatLonPoint getLatLon();

    public double getRadarHeight();
}
