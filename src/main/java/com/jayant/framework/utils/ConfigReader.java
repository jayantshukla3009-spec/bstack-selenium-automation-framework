package com.jayant.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;

	public static Properties reader()  {
		if (prop == null) {
			try {
		File f1 = new File("src/main/resources/config.properties");
		FileInputStream fis = new FileInputStream(f1);
		prop = new Properties();
		prop.load(fis);
		fis.close();
		}catch(IOException e) {
			throw new RuntimeException("Unable to load config.properties", e);
		}
		}
			return prop;

	}
}
			
		 
		
		
		
	


