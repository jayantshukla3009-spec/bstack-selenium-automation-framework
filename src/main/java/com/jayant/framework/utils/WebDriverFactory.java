package com.jayant.framework.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
public static WebDriver createDriver(String browser) {
	WebDriver driver;
	
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();// download the matching browser version
		String projectPath = System.getProperty("user.dir");
		String downloadPath = projectPath+"\\Receipts";
		File folder = new File(downloadPath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		 Map<String, Object> prefs = new HashMap<>();
         prefs.put("download.default_directory", downloadPath);
         prefs.put("download.prompt_for_download", false);
         prefs.put("safebrowsing.enabled", true);

         ChromeOptions options = new ChromeOptions();
         options.setExperimentalOption("prefs", prefs);

         driver = new ChromeDriver(options);
	}else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}else {
		throw new RuntimeException("Browser not supported:"+browser);
	}
		return driver;
}
}
