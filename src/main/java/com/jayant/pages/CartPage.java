package com.jayant.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jayant.framework.utils.WaitUtils;

public class CartPage {
	private final WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private final By Item_1 = By.xpath("//div[@id='1']//div[4]");
	private final By Item_2 = By.xpath("//div[@id='2']//div[4]");
	private final By Item_3 = By.xpath("//div[@id='5']//div[4]");
	private final By ItemCount = By.cssSelector("span[class*='bag__quantity']");
	private final By removeItem = By.xpath("(//div[@class='shelf-item__del'])[1]");
	private final By itemPrices = By
			.xpath("//div[contains(@class,'float-cart__shelf-container')]//div[contains(@class,'shelf-item__price')]");
	private final By cartSubTotal = By.cssSelector("p[class='sub-price__val']");
	By itemNames = By.cssSelector("p[class='title']");

	public void addSingleItem() {
		WaitUtils.waitForClickable(driver, Item_1).click();
	}

	public void addMultipleItems() {
		WaitUtils.waitForClickable(driver, Item_1).click();
		WaitUtils.waitForClickable(driver, Item_2).click();
		WebElement item3 = WaitUtils.waitForClickable(driver, Item_3);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item3);

	}

	public String cartCount() {
		return WaitUtils.waitForVisibility(driver, ItemCount).getText();
	}
    public boolean isCartCountDisplayed() {
    	return WaitUtils.waitForVisibility(driver, ItemCount).isDisplayed();
    }
	public void removeCartItems() {
		WaitUtils.waitForClickable(driver, removeItem).click();
	}

	public double PriceVarifiction() {

		List<WebElement> priceList = driver.findElements(itemPrices);
		double ItemTotal;
		double Total = 0;// start totaling from 0 each time method runs
		for (int i = 0; i < priceList.size(); i++) {

			String price = priceList.get(i).getText();
			price = price.replaceAll("[^0-9.]", "").trim();
			ItemTotal = Double.parseDouble(price);
			Total += ItemTotal;

		}
		return Total;

	}

	public String getSubTotal() {//returns string to compare with older one
		return driver.findElement(cartSubTotal).getText();
		 

	}

	public double cartSubTotalAmount() { // returns the cart sub total to verify

		String subTotalAmount = driver.findElement(cartSubTotal).getText();
		subTotalAmount = subTotalAmount.replaceAll("[^0-9.]", "").trim();
		return Double.parseDouble(subTotalAmount);

	}
	
	public void waitForSubTotalchange(String oldSubTotal) {
		
		WaitUtils.waitForTextChange(driver, cartSubTotal, oldSubTotal);
	}
	
	public List<String> verifyCartItems(){
		List<String> cartItems = new ArrayList<>();
		List<WebElement> itemList = driver.findElements(itemNames);
		for(WebElement item : itemList) {
			cartItems.add(item.getText());
		}
		return cartItems;
	}

}
