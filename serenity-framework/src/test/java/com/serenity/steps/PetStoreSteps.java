package com.serenity.steps;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.serenity.pages.AccountsPage;
import com.serenity.pages.BasePage;
import com.serenity.pages.DashBoardPage;
import com.serenity.pages.HelpPage;
import com.serenity.pages.LoginPage;
import com.serenity.pages.OrdersPage;
import com.serenity.pages.ProductsPage;
import com.serenity.util.PetCategories;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PetStoreSteps extends ScenarioSteps {
	

	BasePage basePage;
	
	LoginPage loginPage;
	
	AccountsPage accountPage;
	
	DashBoardPage dashboardPage;
	
	ProductsPage productsPage;
	
	OrdersPage ordersPage;
	
	/*
	 * 
	 * Base Class methods
	 * 
	 */
	
	@Step("click on sign out")
	public DashBoardPage _signOut()
	{
		return basePage.signOut();
	}
	
	@Step("Navigating to the login page")
	public LoginPage _navigateToLoginPage()
	{

		return basePage.navigateToLoginPage();
			
	}
	
	@Step("click on the sign in")
	public LoginPage _clickOnSignIn()
	{
		
		return basePage.clickOnSignIn();
		
	}
	
	@Step("navigate to the dashboard page")
	public DashBoardPage _navigateToDashboard()
	{
	    	
		return basePage.navigateToDashboard();
		
	}
	
	

	@Step("click on Myaccounts link")
	public AccountsPage _clickOnMyAccount()
	{
		
		return basePage.clickOnMyAccount();
		
	}
	
	@Step("Searching for :{0}")
	public ProductsPage _search(String searchValue)
	{
		
		return basePage.search(searchValue);
	}
	
	@Step("Navigating to the Help page")
	public HelpPage _navigateToHelpPage()
	{
		
		return basePage.navigateToHelpPage();
		
	}
	
	@Step("Navigate to the products page")
	public ProductsPage _navigateToProductPage()
	{
		
		return basePage.navigateToProductPage();
	}
	
	@Step("Navigating to the products category : {0}")
	public ProductsPage _navigateToProductsCategory(PetCategories productCategory)
	{
		
		return basePage.navigateToProductsCategory(productCategory);
		
	}
	
	/*
	 * Login Page methods
	 * 
	 */
	
	@Step("logging in using {0} & {1}")
	public BasePage _Login(String usernameValue , String passwordValue)
	{
		return loginPage._Login(usernameValue, passwordValue);
		
	}
	
	@Step("Getting the invalid login message")
	public String _inValidSignIn()
	{
		
		return loginPage._validateInValidCredsMsg();
		
	}
	
	@Step("clicked on register now")
	public AccountsPage _clickOnRegisterNow()
	{
	return loginPage._clickOnregisterNow();
		
	}

	
	/*
	 * Steps for Accountspage
	 * 
	 */
	@Step("enter the userInformation {0} , {1} , {2}")
	public AccountsPage _enterUserInformation(String usernameValue , String passwordValue , String repeatedPasswordValue)
	{
		
		return accountPage.enterUserInformation(usernameValue, passwordValue, repeatedPasswordValue);
		
	}
	
	@Step("enter account information {0},{1},{3},{4},{5},{6},{7},{8} and {9}")
	public AccountsPage _enterAccountInformation(String firstNameValue , String lastNameValue , String emailValue , String phoneValue , String address1Value , String address2Value , String cityValue , String stateValue , String zipValue , String countryValue)
	{
		
		return accountPage.enterAccountInformation(firstNameValue, lastNameValue, emailValue, phoneValue, address1Value, address2Value, cityValue, stateValue, zipValue, countryValue);
	}
	
	@Step("enter profile information details {0},{1},{2} and {3}")
	public AccountsPage _enterProfileInformation(String languagePrefValue , String favoriteCatValue , boolean enableMyList , boolean enableMyBanner)
	{
		
		return accountPage.enterProfileInformation(languagePrefValue, favoriteCatValue, enableMyList, enableMyBanner);
	}
	
	@Step("click on the Save account information")
	public DashBoardPage _saveAccountInformation()
	{
		
		return accountPage.saveAccountInformation();
	}
	
	/*
	 *DashBoard page steps 
	 * 
	 */

	@Step("Getting the greeting message")
	public String _getGreetingMsg()
	{
		return dashboardPage.getGreetingMsg();
	}
	
	@Step("Clicking on the categories {0}")
	public ProductsPage _selectProductFromTheSideBar(PetCategories categories)
	{
		return dashboardPage.selectProductFromTheSideBar(categories);
	}
	
	/*
	 * 
	 * products page
	 * 
	 */
	@Step("selecting pets by category : {0} and petname : {1}")
	public ProductsPage _selectPetByName(PetCategories petCategories , String petName)
	{
		return productsPage._selectPetByName(petCategories, petName);
	}
	
	@Step("Selecting the pet by description {0}")
	public ProductsPage _addToCartSpecificProduct(String specificProductName)
	{
		return productsPage.addToCartSpecificProduct(specificProductName);
	}
	
	@Step("Selecting the pet by description {0} by linking on the ItemId")
	public ProductsPage _addToCartByViewingDetails(String specificProductName , String ...details)
	{
		return productsPage.addToCartByViewingDetails(specificProductName, details);
	}
	
	@Step("Selecting the pet by search results of {0}")
	
	public ProductsPage _selectProductFromSearchTable(String productName)
	{
		return productsPage.selectProductFromSearchTable(productName);
	}
	
	
	@Step("Update the quantity to {0}")
	public Boolean _updateCartWithQuantity(String quantity)
	{
		return productsPage.updateCartWithQuantity(quantity);
	}
	
	@Step("Proceed to checkout")
	public OrdersPage _proceedToCheckout()
	{
		return productsPage.proceedToCheckout();
		
	}
	
	/*
	 * 
	 * Order Page method
	 */
	@Step("Enter the payment details {0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}")
	public OrdersPage _enterPaymentDetailsAndBillingAddress(String cardTypeValue , String cardNumberValue ,String expiryDateValue , String firstNameValue , String lastNameValue , String address1Value , String address2Value , String cityValue , String stateValue, String zipValue , String countryValue )
	{
	
		return ordersPage.enterPaymentDetailsAndBillingAddress(cardTypeValue, cardNumberValue, expiryDateValue, firstNameValue, lastNameValue, address1Value, address2Value, cityValue, stateValue, zipValue, countryValue);
		
	}
	
	@Step("Ship to different address")
	public OrdersPage _selectShipToDifferentAddress()
	{
		
		return ordersPage.selectShipToDifferentAddress();
	}
	
	@Step("Enter shipping address : {0},{1},{2},{3},{4},{5},{6}")
	public OrdersPage _enterShippingAddress(String shipFirstNameValue , String shipLastNameValue , String shipAddress1Value , String shipCityValue , String shipStateValue ,String shipZipValue, String shipCountryValue)
	{
		
		
		return ordersPage.enterShippingAddress(shipFirstNameValue, shipLastNameValue, shipAddress1Value, shipCityValue, shipStateValue, shipZipValue, shipCountryValue);
	}
	
	@Step("click on continue")
	public OrdersPage _clickContinue()
	{
		return ordersPage.clickContinue();
	}
	@Step("Verify the order details")
	public String _orderDetails()
	{
	return ordersPage.orderDetails();
		
	}
	
//generic method
	@Step("Logged the value {0}")
	public void log(String message) {}
	
}
