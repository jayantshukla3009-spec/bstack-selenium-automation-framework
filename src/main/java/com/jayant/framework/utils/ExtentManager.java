package com.jayant.framework.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest>test = new ThreadLocal<>();
public static ExtentReports getReport() {
	if(extent==null) {
	File f1 = new File(System.getProperty("user.dir")+"/ExtentReports/Bstack_Auto_"+(System.currentTimeMillis()%10000)+".html");
	
	if(!f1.getParentFile().exists()) {
		f1.getParentFile().mkdirs();
	}
	ExtentSparkReporter spark = new ExtentSparkReporter(f1);
	spark.config().setDocumentTitle("Bstack Automation Test Report");
	spark.config().setReportName("Bstack Demo – Selenium Test Execution Report");
	spark.config().setTheme(Theme.DARK);
	extent = new ExtentReports();
	extent.attachReporter(spark);
	extent.setSystemInfo("OS", System.getProperty("os.name"));
	extent.setSystemInfo("UserName", System.getProperty("user.name"));
	extent.setSystemInfo("Browser", ConfigReader.prop.getProperty("browser"));
	}
	return extent;
}
public static void createTest(String testName) {
	ExtentTest extentTest = getReport().createTest(testName);
	 test.set(extentTest);
}
public static ExtentTest getTest() {
	return test.get();
}
public static void flush() {
	getReport().flush();
	
}
public static void removeTest() {
	test.remove();
}


}
