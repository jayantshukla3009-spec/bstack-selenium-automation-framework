package com.jayant.tests;


import org.testng.Assert;

import org.testng.annotations.Test;

import com.jayant.framework.base.BaseTest;
import com.jayant.pages.CartPage;
import com.jayant.pages.CheckOutPage;
import com.jayant.pages.LoginPage;
import com.jayant.pages.ProductPage;


public class CheckOutTest extends BaseTest {
@Test
public void validCheckOutFlow() {
	LoginPage login = new LoginPage(driver);
	login.performLogin("demouser","testingisfun99");
	CartPage cart = new CartPage(driver);
	Assert.assertTrue(cart.isCartCountDisplayed());
	String oldText = cart.getSubTotal();
	cart.addMultipleItems();
	cart.waitForSubTotalchange(oldText);
	CheckOutPage checkOut = new CheckOutPage(driver);
	checkOut.clickCheckOut();
	Assert.assertTrue(checkOut.isOrderSummaryDisplayed());// verify order summary page is displayed
	checkOut.firstName("tester");
	checkOut.lastName("user");
	checkOut.address("Test address data");
	checkOut.state("test State");
	checkOut.postalCode("554691");
	checkOut.submitButton();
	Assert.assertTrue(checkOut.orderConfirmationMessage()); // verify order confirmation message is displayed
	checkOut.downloadOrderReceipt();
	checkOut.continueShopping();
	Assert.assertTrue(login.userProfileIsDisplayed());
	
	
	
}

@Test
public void InvalidCheckOutFlow() {
	LoginPage login = new LoginPage(driver);
	login.performLogin("demouser","testingisfun99");
	CartPage cart = new CartPage(driver);
	CheckOutPage checkOut = new CheckOutPage(driver);
	checkOut.openCart();
	Assert.assertEquals(cart.cartCount(), "0"); // verify cart is empty 
	Assert.assertFalse(checkOut.checkOutButtonIsDisplayed()); // checkout button is not displayed
	checkOut.cartContinueShopping();// click continue shopping button in cart
	ProductPage product = new ProductPage(driver);
	Assert.assertTrue(product.itemsList(),"Items list not displayed");// confirm user is back to the shopping page
	
}
}
