package com.jayant.framework.base;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jayant.framework.utils.ConfigReader;
import com.jayant.framework.utils.WebDriverFactory;



public class BaseTest {
protected static WebDriver driver;
@BeforeMethod
protected void setUp() throws IOException {
	Properties pro = ConfigReader.reader();
	 driver = WebDriverFactory.createDriver(pro.getProperty("browser"));// driver initialization by loading configs
	 driver.get(pro.getProperty("url"));
	 driver.manage().window().maximize();
	
}
public static WebDriver getDriver() {
	return driver;
}
@AfterMethod
protected void tearDown() {
	if(driver!=null) {
		driver.quit();
	}
}

}
