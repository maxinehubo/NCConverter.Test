/**
 * NOAA's National Climatic Data Center
 * NOAA/NESDIS/NCDC
 * 151 Patton Ave, Asheville, NC  28801
 *
 * THIS SOFTWARE AND ITS DOCUMENTATION ARE CONSIDERED TO BE IN THE 
 * PUBLIC DOMAIN AND THUS ARE AVAILABLE FOR UNRESTRICTED PUBLIC USE.  
 * THEY ARE FURNISHED "AS IS." THE AUTHORS, THE UNITED STATES GOVERNMENT, ITS
 * INSTRUMENTALITIES, OFFICERS, EMPLOYEES, AND AGENTS MAKE NO WARRANTY,
 * EXPRESS OR IMPLIED, AS TO THE USEFULNESS OF THE SOFTWARE AND
 * DOCUMENTATION FOR ANY PURPOSE. THEY ASSUME NO RESPONSIBILITY (1)
 * FOR THE USE OF THE SOFTWARE AND DOCUMENTATION; OR (2) TO PROVIDE
 * TECHNICAL SUPPORT TO USERS.
 */

public class NexradEquation {

    public static double getAltitudeFromPressureInMeters(double pressureInPa) {
        double pressure_hPa = pressureInPa * 0.01;
        double standardPressure_hPa = 1013.25;

        double a = Math.log10(pressure_hPa/standardPressure_hPa);
        double b = Math.pow(10, a/5.2558797) - 1;
        double c = b / (-6.8755856 * Math.pow(10, -6));

        // convert from feet to meters
        return c * 0.3048;
    }



    /**
     * Uses WSR-88D Range-Height equation on: http://www.wdtb.noaa.gov/courses/dloc/topic3/lesson1/Section5/Section5-4.html
     * with default index of refraction of 1.21 .
     * @param elevAngleInDegrees
     * @param range
     * @return
     */
    public static double getRelativeBeamHeight(double elevAngleInDegrees, double range) {
        return (getRelativeBeamHeight(Math.cos(Math.toRadians(elevAngleInDegrees)),
                Math.sin(Math.toRadians(elevAngleInDegrees)), range));
    }


    /**
     * Uses WSR-88D Range-Height equation on: http://www.wdtb.noaa.gov/courses/dloc/topic3/lesson1/Section5/Section5-4.html
     * with default index of refraction of 1.21 .
     * @param elevAngleRadiansCos
     * @param elevAngleRadiansSin
     * @param range
     * @return
     */
    public static double getRelativeBeamHeight(double elevAngleRadiansCos, double elevAngleRadiansSin, double range) {
        return getRelativeBeamHeight(elevAngleRadiansCos, elevAngleRadiansSin, range, 1.21);
    }
    /**
     * Uses WSR-88D Range-Height equation on: http://www.wdtb.noaa.gov/courses/dloc/topic3/lesson1/Section5/Section5-4.html
     * with custom index of refraction.
     * @param elevAngleRadiansCos
     * @param elevAngleRadiansSin
     * @param range
     * @param refractiveIndex
     * @return
     */
    public static double getRelativeBeamHeight(double elevAngleRadiansCos, double elevAngleRadiansSin, double range,
                                               double refractiveIndex) {
        // 1. convert surface range to slant range
        double slantRange = range/elevAngleRadiansCos;
        slantRange = range;

        // 2. use radar beam propagation equation
        // http://www.wdtb.noaa.gov/courses/dloc/topic3/lesson1/Section5/Section5-4.html
//        double refractionCoef = 1.21;
        double earthRadius = 6371000;
        double height = slantRange*elevAngleRadiansSin +
                (Math.pow(slantRange, 2) / (2*refractiveIndex*earthRadius))
                + 0; // 50 is average height of radar above ground


//        sr*sin + sr^2/x = h
//        h/sr^2 = sin/sr + x



        //height += nexradHeader.getAlt(); // Add height of radar site -- DON'T DO THIS FOR CURSOR - ATMS PEOPLE LIKE RELATIVE ELEV.
        //       height *= 0.3048;  // convert to meters from feet                     
        return height;
    }


    public static double getRelativeBeamHeight_old(double elevAngleCos, double elevAngleSin, double range) {

        double range_in_nmi = range*0.000539957;
        // below returns relative elevation in feet
        double height = ( (Math.pow(range_in_nmi, 2) * Math.pow(elevAngleCos, 2))/9168.66 + range_in_nmi*elevAngleSin ) * 6076.115;
        //height += nexradHeader.getAlt(); // Add height of radar site -- DON'T DO THIS FOR CURSOR - ATMS PEOPLE LIKE RELATIVE ELEV.
        height *= 0.3048;  // convert to meters from feet                     
        return height;
    }

    public static double getRelativeBeamHeight2(double elevAngleCos, double elevAngleSin, double range) {
        // 1. convert surface range to slant range
        double slantRange = range/elevAngleCos;

        // 2. use radar beam propagation equation
        // http://en.wikipedia.org/wiki/File:Radar-height.PNG
        double refractionCoef = (4.0/3.0);
        double earthRadius = 6371000;
        double height = Math.sqrt( Math.pow(slantRange, 2) +
                Math.pow(refractionCoef*earthRadius, 2) +
                2*slantRange*refractionCoef*earthRadius*elevAngleSin
        ) - (refractionCoef*earthRadius) + 0; // 50 is average height of radar above ground

        //height += nexradHeader.getAlt(); // Add height of radar site -- DON'T DO THIS FOR CURSOR - ATMS PEOPLE LIKE RELATIVE ELEV.
        //       height *= 0.3048;  // convert to meters from feet                     
        return height;
    }
}
