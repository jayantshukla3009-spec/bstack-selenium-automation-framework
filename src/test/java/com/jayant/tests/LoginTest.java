package com.jayant.tests;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.jayant.framework.base.BaseTest;
import com.jayant.pages.LoginPage;
import com.jayant.testdata.LoginTestData;

public class LoginTest extends BaseTest{
	
	
	
	@Test(dataProviderClass = LoginTestData.class ,dataProvider = "loginCredentials")
	public void loginTest(String username , String password , String output) {
		LoginPage login =  new LoginPage(driver);
		if(output.equalsIgnoreCase("blank")) {
			login.openSignIn();
			login.login();
		}else {
			login.performLogin(username, password);
		}
		if(output.equalsIgnoreCase("valid")) {
			Assert.assertTrue(login.userProfileIsDisplayed(),"User profile is not displayed");
		}else if(output.equalsIgnoreCase("invalid")||output.equalsIgnoreCase("blank")) {
			Assert.assertTrue(login.errorMessageIsDisplayed(),"error message is not displayed");
		}
		
	}

}
