package com.jayant.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jayant.framework.utils.WaitUtils;

public class CheckOutPage {
	private final WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	private final By checkOutButton = By.xpath("//div[contains(text(),'Checkout')]");
	private final By orderSummaryTitle = By.xpath("//h3[normalize-space()='Order Summary']");
	private final By enterFirstName = By.id("firstNameInput");
	private final By enterLastName = By.id("lastNameInput");
	private final By enterAddress = By.id("addressLine1Input");
	private final By enterState = By.id("provinceInput");
	private final By enterPostalCode = By.id("postCodeInput");
	private final By submitButton = By.id("checkout-shipping-continue");
	private final By orderSummaryitems = By.cssSelector("h5[class*='product-title']");
	private final By summaryTotalPrice = By.cssSelector("span[class='cart-priceItem-value']");
	private final By orderSuccessful = By.id("confirmation-message");
	private final By downloadReceipt = By.id("downloadpdf");
	private final By continueShoppingButton = By.xpath("//button[normalize-space()='Continue Shopping »']");
	private final By openEmptyCart = By.cssSelector("span[class*='bag--float-cart-closed']");
	private final By continueShoppingCart = By.xpath("//div[contains(text(),'Continue Shopping')]");
	public boolean isOrderSummaryDisplayed() {
		return WaitUtils.waitForVisibility(driver, orderSummaryTitle).isDisplayed();
	}

	public void clickCheckOut() {
		WaitUtils.waitForClickable(driver, checkOutButton).click();
	}
	public boolean checkOutButtonIsDisplayed() {
		List<WebElement> elements = driver.findElements(checkOutButton);
		return elements.size() > 0; 
	}

	public void firstName(String firstName) {
		WaitUtils.waitForClickable(driver, enterFirstName).sendKeys(firstName);
	}

	public void lastName(String lastName) {
		WaitUtils.waitForClickable(driver, enterLastName).sendKeys(lastName);
	}

	public void address(String address) {
	WaitUtils.waitForClickable(driver, enterAddress).sendKeys(address);
	}

	public void state(String state) {
		WaitUtils.waitForClickable(driver, enterState).sendKeys(state);
	}

	public void postalCode(String postalCode) {
		WaitUtils.waitForClickable(driver, enterPostalCode).sendKeys(postalCode);
	}

	public void submitButton() {
		WaitUtils.waitForClickable(driver, submitButton).click();
	}

	public List<String> getOrderSummaryItem() {
		List<String> summaryItem = new ArrayList<>();
		List<WebElement> orderSummaryItem = driver.findElements(orderSummaryitems);
		for (WebElement item : orderSummaryItem) {
			summaryItem.add(item.getText());
		}
		return summaryItem;
	}

	public double getOrderSummaryTotal() {
		String total = WaitUtils.waitForVisibility(driver, summaryTotalPrice).getText();
		total = total.replaceAll("[^0-9.]", "").trim();
		double orderSummaryTotal = Double.parseDouble(total);
		return orderSummaryTotal;
	}
	
	public boolean orderConfirmationMessage() {
		return WaitUtils.waitForVisibility(driver, orderSuccessful).isDisplayed();
	}
	
	public void downloadOrderReceipt() {
		WaitUtils.waitForClickable(driver, downloadReceipt).click();
	}
	public void continueShopping() {
		WaitUtils.waitForClickable(driver, continueShoppingButton).click();
	}
	public void openCart() {
		WaitUtils.waitForClickable(driver, openEmptyCart).click();
	}
	public void cartContinueShopping() {
		WaitUtils.waitForClickable(driver, continueShoppingCart).click();
	}
}


















