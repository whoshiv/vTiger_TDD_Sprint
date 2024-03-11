package vtiger.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String fetchDataFromPropertyFile(String Key) throws IOException
	{
	FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILE_PATH); // AISE KAISE INTERFACE LIKH KARKE CALL KAR SAKTE HAI
	Properties prop  = new Properties();
	prop.load(fis);
	return prop.getProperty(Key);
	
	}
}
