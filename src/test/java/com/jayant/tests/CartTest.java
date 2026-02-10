package com.jayant.tests;


import org.testng.Assert;


import org.testng.annotations.Test;

import com.jayant.framework.base.BaseTest;
import com.jayant.pages.CartPage;



public class CartTest extends BaseTest {

@Test
public void addItem() {
	CartPage cart = new CartPage(driver);
	cart.addSingleItem();
	String itemCount = cart.cartCount();
	Assert.assertEquals(itemCount, "1");
	}
@Test
public void addMultipleItems()  {
	CartPage cart = new CartPage(driver);
	cart.addMultipleItems();
	String itemCount = cart.cartCount();
	Assert.assertEquals(itemCount, "3");
	
}
@Test
public void removeItemAndVerifyPrice() {
	// add items before removal
	CartPage cart = new CartPage(driver);
	String oldText = cart.getSubTotal();
	cart.addMultipleItems();
	cart.waitForSubTotalchange(oldText);
	String itemCount = cart.cartCount();
	Assert.assertEquals(itemCount, "3");// verify items are added
	double totalItemprice = cart.PriceVarifiction(); // total price of individual cart items
	double cartSubTotal = cart.cartSubTotalAmount(); // subTotal price of cart 
	Assert.assertEquals(cartSubTotal, totalItemprice);// verify individual items total is equal to cart subTotal 
	
	// Item removal
	String subTotalOld = cart.getSubTotal();
	cart.removeCartItems();// remove 1 item 
	cart.waitForSubTotalchange(subTotalOld);
	String itemRemoveCount = cart.cartCount();
	Assert.assertEquals(itemRemoveCount, "2");// verify item is removed successfully
	double totalCartprice = cart.PriceVarifiction(); // total price of individual cart items
	double cartSubTotalPrice = cart.cartSubTotalAmount(); // subTotal price of cart 
	Assert.assertEquals(totalCartprice, cartSubTotalPrice);// verify individual items total is equal to cart subTotal 
	
}

}
