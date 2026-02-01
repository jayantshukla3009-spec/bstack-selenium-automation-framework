package com.jayant.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
public static WebDriver createDriver(String browser) {
	WebDriver driver;
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();// download the matching browser version
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}else {
		throw new RuntimeException("Browser not supported:"+browser);
	}
		return driver;
}
}
