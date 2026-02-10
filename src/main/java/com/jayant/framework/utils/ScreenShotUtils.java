package com.jayant.framework.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {
public static String takeScreenShot(WebDriver driver , String testName) {
	String fPath = System.getProperty("user.dir")+"/ScreenShots/"+"BstackSS_"+testName+"_"+(System.currentTimeMillis()%10000)+".png"; 
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File(fPath);
	if(!dest.getParentFile().exists()) {
		dest.getParentFile().mkdirs();
	}
	try {
	FileHandler.copy(src, dest);
	}catch(IOException e) {
		e.printStackTrace();
	}
	return fPath;
	
}
}
