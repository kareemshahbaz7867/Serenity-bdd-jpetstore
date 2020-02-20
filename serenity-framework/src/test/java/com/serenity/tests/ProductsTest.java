package com.serenity.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.pages.ProductsPage;
import com.serenity.steps.PetStoreSteps;
import com.serenity.util.PetCategories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class ProductsTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps steps;
	
	
	

	
	/*@Test
	@Title("This test is to navigate to the products page")
	public void navigateToProductsPage()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		steps._selectProductFromTheSideBar(PetCategories.FISH);
		steps._selectPetByName(PetCategories.FISH, "Angelfish");
			
	}*/
	
	/*@Test
	@Title("Add the pet to cart")
	public void selectPetByDescriptionAndAddToCart()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		steps._selectProductFromTheSideBar(PetCategories.FISH);
		steps.selectPetByName(PetCategories.FISH, "Angelfish");
		steps._addToCartSpecificProduct("Large Angelfish");
			
	}*/
	
	/*@Test
	@Title("This test is to add pet to cart by viewing details")
	public void selectPetByDescriptionAndAddToCartByViewDetails()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		steps._selectProductFromTheSideBar(PetCategories.FISH);
		steps.selectPetByName(PetCategories.FISH, "Angelfish");
		
		steps._addToCartByViewingDetails("Large Angelfish", "Angelfish","Salt Water fish from Australia"," EST-1 ");
			
	}*/
	
	/*@Test
	@Title("Add to cart by searching")
	public void selectProductFromSearchAndAddToCart()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		System.out.println(PetCategories.FISH.getValue());
		steps._search(PetCategories.FISH.getValue());
		steps._selectProductFromSearchTable("Goldfish");
		steps._addToCartByViewingDetails("Adult Male Goldfish", "Goldfish","Fresh Water fish from China","EST-20");
			
	}*/
	
	
	/*@Test
	@Title("update quantity on the shopping cart page")
	public void updateCartQuanity()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		System.out.println(PetCategories.FISH.getValue());
		steps._search(PetCategories.FISH.getValue());
		steps._selectProductFromSearchTable("Goldfish");
		steps._addToCartByViewingDetails("Adult Male Goldfish", "Goldfish","Fresh Water fish from China","EST-20");
	    assertTrue(steps._updateCartWithQuantity("6"));
	}*/
	
	@Test
	@Title("Proceed to checkout , arrive at orders and shipping page")
	public void proceedToOrdersAndShipping()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		System.out.println(PetCategories.FISH.getValue());
		steps._search(PetCategories.FISH.getValue());
		steps._selectProductFromSearchTable("Goldfish");
		steps._addToCartByViewingDetails("Adult Male Goldfish", "Goldfish","Fresh Water fish from China","EST-20");
	    assertTrue(steps._updateCartWithQuantity("6"));
	    steps._proceedToCheckout();
		
	}
	
	
	
	
	
	

}
