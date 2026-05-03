package com.jayant.pages;



import org.openqa.selenium.By;


import com.jayant.framework.utils.WaitUtils;

public class ProductPage {
	
	private final By productPageList = By.xpath("//div[@class='shelf-item']");//locator wrapper wrapping image price and names of the product
	
public void filters(String brandFilter) {
	WaitUtils.waitForClickable(By.xpath("//span[normalize-space()='"+brandFilter+"']")).click();
}


public boolean itemsList() {
	return WaitUtils.waitForVisibility(productPageList).isDisplayed();
}
}
