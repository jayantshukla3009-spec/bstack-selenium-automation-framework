package com.jayant.framework.utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private static Properties time = ConfigReader.reader();
	private static int waitTime = Integer.parseInt(time.getProperty("explicitWait"));
    
	public static WebElement waitForVisibility(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static boolean waitForTextChange(WebDriver driver, By locator, String oldText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, oldText)));
	}
}
