package com.jayant.testdata;

import org.testng.annotations.DataProvider;

public class LoginTestData {
@DataProvider
public static Object[][]loginCredentials(){
	return new Object[][] {
		new Object[] {"demouser","testingisfun99","Valid"},
		new Object[] {"locked_user","testingisfun99","Invalid"},
	    new Object [] {"","","Blank" }
	};

	}
}
