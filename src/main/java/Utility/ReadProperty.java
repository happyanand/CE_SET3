package Utility;
//NEW PACKAGE
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadProperty {

	String configFileName = "config.properties";

	public String loadProperty(String propertyKey) {
		//System.out.println("Property Key "+propertyKey);
		Properties config = new Properties();

		try {
			
			File file = new File("./Screenshots");
			file.mkdirs();
			
			Properties p = System.getProperties();
			String projDir = p.getProperty("user.dir");
			String projDir1 = p.getProperty("Inshura_automation_home");
			String automation_home = projDir+"\\src\\test\\resources";
			//String automation_home = "C:\\Automation_home";
			/*
			 * if (automation_home == null) {
			 * System.out.println("No Common VM argument is provided"); System.exit(0); }
			 * else { String configFilePath = automation_home + "\\" + configFileName;
			 * config.load(new FileInputStream(configFilePath)); }
			 */
			 String configFilePath = automation_home + "\\" + configFileName;
			config.load(new FileInputStream(configFilePath));
		} catch (IOException e) {
		}

		//System.out.println(config.getProperty(propertyKey));
		return config.getProperty(propertyKey);
	}

}
