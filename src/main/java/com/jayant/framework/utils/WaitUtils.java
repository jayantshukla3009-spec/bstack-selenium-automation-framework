package com.jayant.framework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
public static void waitForVisibility(WebDriver driver ,WebElement element, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public static void waitForClickable(WebDriver driver , WebElement element,int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
}
