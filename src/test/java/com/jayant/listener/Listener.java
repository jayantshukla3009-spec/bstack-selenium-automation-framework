package com.jayant.listener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jayant.framework.base.BaseTest;
import com.jayant.framework.utils.ExtentManager;
import com.jayant.framework.utils.ScreenShotUtils;

public class Listener implements ITestListener{
	
	@Override
public void onTestStart(ITestResult result) {
	ExtentManager.createTest(result.getMethod().getMethodName());
}
	@Override
public void onTestSuccess(ITestResult result) {
	ExtentManager.getTest().pass(MarkupHelper.createLabel(result.getMethod().getMethodName()+"  - Test Passed", ExtentColor.GREEN));
	ExtentManager.removeTest();
	}
	@Override
public void onTestFailure(ITestResult result) {
		
		ExtentManager.getTest().fail(MarkupHelper.createLabel(result.getMethod().getMethodName()+"  - Test Failed", ExtentColor.RED));
		ExtentManager.getTest().fail(result.getThrowable());
		String screenShot = ScreenShotUtils.takeScreenShot(BaseTest.getDriver(), result.getMethod().getMethodName());
		ExtentManager.getTest().addScreenCaptureFromPath(screenShot);
		ExtentManager.removeTest();
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentManager.getTest().skip(MarkupHelper.createLabel(result.getMethod().getMethodName()+" - Test Skipped", ExtentColor.ORANGE));
		if(result.getThrowable()!=null){
		    ExtentManager.getTest().skip(result.getThrowable());
		}
		ExtentManager.removeTest();
	}
	@Override
public void onFinish(ITestContext context) {
		ExtentManager.flush();
		
	}
}
