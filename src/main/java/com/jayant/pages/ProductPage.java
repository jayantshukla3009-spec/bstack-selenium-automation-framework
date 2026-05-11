package com.jayant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.jayant.framework.utils.WaitUtils;
import java.util.List;

public class ProductPage {
	
    private final By productPageList = By.xpath("//div[@class='shelf-item']");
	
    public void filters(String brandFilter) {
        WaitUtils.waitForClickable(By.xpath("//span[normalize-space()='"+brandFilter+"']")).click();
    }

    public boolean itemsList() {
        List<WebElement> items = WaitUtils.waitForVisibilityOfAll(productPageList);
        for (int i = 0; i < items.size(); i++) {
            items = WaitUtils.waitForVisibilityOfAll(productPageList);
            if (!items.get(i).isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}