package comm.crm.Genericlibary;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
/**
 * its used to read the data from commonData.properties File based on Key which you pass as an argument
 * @author SHARU
 *
 */

public class FileUtility {

	public String getPropertykeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties po=new Properties();
		po.load(fis);
		String value = po.getProperty(key);
		return value;
		
	
		
	}
}
