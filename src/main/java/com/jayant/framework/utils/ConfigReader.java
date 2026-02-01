package com.jayant.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;
	public static Properties reader() throws IOException {
		File f1 = new File("src/main/resources/config.properties");
		FileInputStream fis = new FileInputStream(f1);
		
		if (prop==null) {
		prop.load(fis);
		}
		prop = new Properties();
		fis.close();
		return prop; 
	}

}
