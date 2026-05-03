package com.jayant.framework.base;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jayant.framework.utils.ConfigReader;
import com.jayant.framework.utils.WebDriverFactory;



public class BaseTest {

@BeforeMethod
protected void setUp() {
     WebDriverFactory.createDriver();//This creates driver and stores it in ThreadLocal.	
	 WebDriverFactory.getDriver().get(ConfigReader.get("url")); //getDriver() retrieves the thread-specific WebDriver
	 WebDriverFactory.getDriver().manage().window().maximize();
	
}
public static WebDriver getDriverFromThread() {
	return WebDriverFactory.getDriver();
}
@AfterMethod
protected static void tearDown() {
	WebDriverFactory.quitDriver();
}

}
