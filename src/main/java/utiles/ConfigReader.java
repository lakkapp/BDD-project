package utiles;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static final Properties prop = new Properties();
	static {
		String proFile = "config.properties";
		try (InputStream input = Thread.currentThread().getContextClassLoader().
				getResourceAsStream(proFile)){
			if (input==null) {
				throw new RuntimeException("Unable to find" + proFile+ "classpath");
				
			}
			prop.load(input);
			prop.forEach((K,v)->{
				String sys	= System.getProperty(K.toString());
				if (sys !=null) {
					prop.setProperty(K.toString(), sys);
				}
			});
		}catch(IOException e) {
			throw new RuntimeException("failed to load config.properties",e);
		}
	}
	public static String get(String Key) {
		return prop.getProperty(Key);
	}
	public static boolean getBoolean(String Key) {
		return Boolean.parseBoolean(prop.getProperty(Key));
	}
}
