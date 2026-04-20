package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader 
{
	public static String readPropertyData(String value)
	{
		Properties prop= new Properties();
		FileInputStream fis;
		String path= System.getProperty("user.dir");
		
		  try 
		  {
			 fis= new FileInputStream(path+"/src/test/resources/Settings.properties");
			 prop.load(fis);
		  } 
		  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
	
		  String data= prop.getProperty(value);
		  System.out.println(data);	
		  
		  return data;
		  
	}
	
	/*public static void main(String[] args) 
	{
		PropertiesReader.readPropertyData();
		
	}
	*/

}
/* prop.setProperty("username", "Admin"); //use for import the data in file nd update chrome to firefox like this
		  try 
		  {
			FileOutputStream fos= new FileOutputStream(path+"/src/test/resources/Settings.properties");
			prop.store(fos, "Updated value");
			fos.close();
		  } 
		  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
