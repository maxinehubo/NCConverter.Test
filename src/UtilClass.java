import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sugar
 * Date: 7/17/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class UtilClass {

    public static int[] ShortArrayToIntArray(short[] input) {
        int[] p = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            p[i] = input[i];
        }
        return p;
    }

    public static double[] FloatArrayToDoubleArray(float[] input) {
        double[] p = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            p[i] = input[i];
        }
        return p;
    }

    public static Date ExtractDateFromFilePath(String input_path) throws ParseException{
        File f = new File(input_path);
        if(!f.exists()) {
            System.out.println(input_path + " is not found. It may cause problems afterwards.");
        }
        String filename = f.getName();
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD-HHmmss");
        return format.parse(filename);

    }
}
