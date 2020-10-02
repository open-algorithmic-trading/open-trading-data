package dev.opentrading.data.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppUtil {
	
	public static Properties getAppConfigProps() throws IOException {
		Properties prop = new Properties();
		String fileName = "config.properties";
		InputStream is = new FileInputStream(fileName);
		prop.load(is);
		
		return prop;
	}

}
