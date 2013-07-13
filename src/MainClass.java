import java.io.IOException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NetcdfFile ncfile = NetcdfFile.open("/home/sugar/workspaces/projects/20040814-001428.netcdf");
		for(Variable var : ncfile.getVariables())
		{
			System.out.println(var.getNameAndDimensions());
		}
		for(Dimension dim : ncfile.getDimensions())
		{
			System.out.println(dim.getFullName());
		}
		for(Attribute attr : ncfile.getGlobalAttributes())
		{
			System.out.print(attr.getFullName() + ":");
			System.out.println(attr.getStringValue());
		}
		
	}

	

}
