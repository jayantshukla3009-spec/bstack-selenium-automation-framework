package com.jayant.framework.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jayant.framework.utils.ConfigReader;
import com.jayant.framework.utils.WebDriverFactory;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;



public class BaseTest {
protected WebDriver driver;
@BeforeMethod
protected void setUp() throws IOException {
	Properties pro = ConfigReader.reader();
	 driver = WebDriverFactory.createDriver(pro.getProperty("browser"));
	
}
@AfterMethod
protected void tearDown() {
	if(driver!=null) {
		driver.quit();
	}
}

}
