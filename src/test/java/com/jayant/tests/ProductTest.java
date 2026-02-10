package com.jayant.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.jayant.framework.base.BaseTest;
import com.jayant.pages.ProductPage;


public class ProductTest extends BaseTest{
@Test
public void pageVerification()  {
	ProductPage page = new ProductPage(driver);
	page.filters("OnePlus");
	Assert.assertTrue(page.itemsList(),"List is not displayed");// verify filtered product list is displayed
	
}
}
