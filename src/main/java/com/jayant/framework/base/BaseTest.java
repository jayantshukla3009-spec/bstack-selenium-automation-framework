package com.jayant.framework.base;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jayant.framework.utils.ConfigReader;
import com.jayant.framework.utils.WebDriverFactory;



public class BaseTest {

@BeforeMethod
protected void setUp() {
     WebDriverFactory.createDriver();	
	 WebDriverFactory.getDriver().get(ConfigReader.get("url"));
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
