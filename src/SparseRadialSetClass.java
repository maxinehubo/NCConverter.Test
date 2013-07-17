import java.util.HashMap;


public class SparseRadialSetClass {

	protected int sizeX;
	protected int sizeY;
	protected int pixels;
	
	protected double[] encodedValues;
	protected double[][] decodedValues;
	
	protected HashMap<Double, BeamRecord> BeamsMap = new HashMap<Double, BeamRecord>();
	
	private int[] pixel_x;
	private int[] pixel_y;
	private int[] pixel_count;
	
	public void setPixelX(int[] pixel_x) {
		this.pixel_x = pixel_x;
	}
	
	public void setPixelY(int[] pixel_y) {
		this.pixel_y = pixel_y;
	}
	
	public void setPixelCount(int[] pixel_count) {
		this.pixel_count = pixel_count;
	}
	
	public void setEncodedValues(double[] values) {
		this.encodedValues = values;
	}
	
	public void setSize(int X, int Y)
	{
		this.sizeX = X;
		this.sizeY = Y;
		//Initialize array to hold decoded values
		this.decodedValues = new double[X][Y];
	}
	
	public boolean decodeSet() {
		try {
			for(int i = 0; i < this.encodedValues.length; i++)
			{
				int c = this.pixel_count[i];
				int X = this.pixel_x[i];
				int Y = this.pixel_y[i];
				for(int j = 0; j < c; j++) {
                    this.decodedValues[X][Y] = this.encodedValues[i];
                    Y += 1;
                    if (Y >= sizeY) {
                        Y = 0;
                        X += 1;
                    }
				}
			}
			//Decode succeed!
			return true;
		} catch (Exception ex) {
		    System.out.println(ex.toString());
            ex.printStackTrace();
		}
		//Decode failed
		return false;
	}
}
