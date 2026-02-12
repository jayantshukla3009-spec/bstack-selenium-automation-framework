package com.jayant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jayant.framework.utils.WaitUtils;

public class LoginPage {

	private final WebDriver driver;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	

	private final By SignIn = By.xpath("//span[normalize-space()='Sign In']");
	private final By Username_svgDropdown = By.xpath("(//*[name()='svg'])[2]");
	private final By password_svgDropdown = By.xpath("(//*[name()='svg'])[3]");
	private final By loginButton = By.id("login-btn");
	private final By loginModal = By.id("username");

    private final By userProfileName =  By.className("username");
    private final By errorMessage =  By.className("api-error");
	public void openSignIn() {
		WaitUtils.waitForClickable(SignIn).click();
		WaitUtils.waitForVisibility(loginModal);// added wait for login modal to be visible 
		
	}

	public void selectUsername(String username) {
		WaitUtils.waitForClickable(Username_svgDropdown).click();
		By userOptions =  By.xpath("//div[@id='username']//div[text()='"+username+"']");
		WaitUtils.waitForVisibility(userOptions);
		WaitUtils.waitForClickable(By.xpath("//div[@id='username']//div[text()='"+username+"']")).click();
	}
	public void selectPassword(String password) {	
		WaitUtils.waitForClickable(password_svgDropdown).click();
		By passOptions = By.xpath("(//div[normalize-space()='"+password+"'])[2]");
		WaitUtils.waitForVisibility(passOptions);
		WaitUtils.waitForClickable(By.xpath("(//div[normalize-space()='"+password+"'])[2]")).click();
				
	}

	public void login() {
		WaitUtils.waitForClickable(loginButton).click();
	}
	
	public boolean userProfileIsDisplayed() {
		return WaitUtils.waitForVisibility(userProfileName).isDisplayed();
	}
	public boolean errorMessageIsDisplayed() {
		return WaitUtils.waitForVisibility(errorMessage).isDisplayed();
	}
	
	public void performLogin(String username , String password) {
		openSignIn();
		selectUsername(username);
		selectPassword(password);
		login();
		
	}
	
	

}
