package com.serenity.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.steps.PetStoreSteps;
import com.serenity.util.PetCategories;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/order-products/orders.csv")
public class OrdersDataDrivenTest {
	
	//same name as in the .csv file
	private String userName;
	private String password;
	private String productCategory;
	private String productName;
	private String specificProductName;
	private String cardType;
	private String cardNumber;
	private String expiryDate;
	private String firstName;
	private String lastName;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private String country;
	




	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setSpecificProductName(String specificProductName) {
		this.specificProductName = specificProductName;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public void setCountry(String country) {
		this.country = country;
	}



	@Managed
	WebDriver driver;

	@Steps
	PetStoreSteps steps;
	

	@Test
	@Title("Place an order data driven test")
	public void proceedToOrdersAndShipping() {
		

		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login(userName, password);
		steps._getGreetingMsg();
		steps._selectProductFromTheSideBar(PetCategories.valueOf(productCategory));
		steps._navigateToProductsCategory(PetCategories.valueOf(productCategory));
		steps._selectPetByName(PetCategories.valueOf(productCategory), productName);
		steps._addToCartSpecificProduct(specificProductName);
		steps._proceedToCheckout();
		steps._enterPaymentDetailsAndBillingAddress(cardType, cardNumber, expiryDate, firstName, lastName, addr1, addr2, city, state, zip, country);
		steps._clickContinue();
		steps.log(steps._orderDetails());

	}

}
