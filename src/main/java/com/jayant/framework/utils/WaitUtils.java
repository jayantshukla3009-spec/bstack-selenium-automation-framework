package com.jayant.framework.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private static String time = ConfigReader.get("explicitWait");
	private static int waitTime = Integer.parseInt(time);
    
	public static WebElement waitForVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickable( By locator) {
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static boolean waitForTextChange( By locator, String oldText) {
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, oldText)));
	}
}
