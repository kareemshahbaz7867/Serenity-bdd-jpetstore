package com.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrdersPage extends BasePage{
	
	@FindBy(how=How.NAME,using="order.cardType")
	WebElementFacade cardType;
	
	@FindBy(how=How.NAME,using="order.creditCard")
	WebElementFacade creditCard;
	
	@FindBy(how=How.NAME,using="order.expiryDate")
	WebElementFacade expiryDate;
	
	@FindBy(how=How.NAME,using="order.billToFirstName")
	WebElementFacade billToFirstName;
	
	@FindBy(how=How.NAME,using="order.billToLastName")
	WebElementFacade billToLastName;
	
	
	@FindBy(how=How.NAME,using="order.billAddress1")
	WebElementFacade billAddress1;
	@FindBy(how=How.NAME,using="order.billAddress2")
	WebElementFacade billAddress2;
	@FindBy(how=How.NAME,using="order.billCity")
	WebElementFacade billCity;
	@FindBy(how=How.NAME,using="order.billState")
	WebElementFacade billState;
	@FindBy(how=How.NAME,using="order.billZip")
	WebElementFacade billZip;
	@FindBy(how=How.NAME,using="order.billCountry")
	WebElementFacade billCountry;
	@FindBy(how=How.NAME,using="shippingAddressRequired")
	WebElementFacade shippingAddressRequired;
	
	
	@FindBy(how=How.NAME,using="order.shipToFirstName")
	WebElementFacade shipToFirstName;
	@FindBy(how=How.NAME,using="order.shipToLastName")
	WebElementFacade shipToLastName;
	@FindBy(how=How.NAME,using="order.shipAddress1")
	WebElementFacade shipAddress1;
	
	@FindBy(how=How.NAME,using="order.shipCity")
	WebElementFacade shipCity;
	@FindBy(how=How.NAME,using="order.shipState")
	WebElementFacade shipState;
	@FindBy(how=How.NAME,using="order.shipZip")
	WebElementFacade shipZip;
	@FindBy(how=How.NAME,using="order.shipCountry")
	WebElementFacade shipCountry;
	
	@FindBy(how=How.NAME,using="newOrder")
	WebElementFacade continueBtn;
	
	@FindBy(how=How.XPATH,using="//a[text()='Confirm']")
	WebElementFacade confirmBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='Catalog']//tr/th[contains(text(),'Order')]")
	WebElementFacade orderNumber;
	
	
	public OrdersPage enterPaymentDetailsAndBillingAddress(String cardTypeValue , String cardNumberValue ,String expiryDateValue , String firstNameValue , String lastNameValue , String address1Value , String address2Value , String cityValue , String stateValue, String zipValue , String countryValue )
	{
		waitForTextToAppear("Payment Details");
		
		waitFor(cardType).selectByValue(cardTypeValue);
		waitFor(creditCard).type(cardNumberValue);
		waitFor(expiryDate).type(expiryDateValue);
		waitFor(billToFirstName).type(firstNameValue);
		waitFor(billToLastName).type(lastNameValue);
		waitFor(billAddress1).type(address1Value);
		waitFor(billAddress2).type(address2Value);
		waitFor(billCity).type(cityValue);
		waitFor(billState).type(stateValue);
		waitFor(billZip).type(zipValue);
		waitFor(billCountry).type(countryValue);
		return this;
		
	}
	
	public OrdersPage selectShipToDifferentAddress()
	{
		waitFor(shippingAddressRequired).click();
		
		return this;
	}
	
	public OrdersPage enterShippingAddress(String shipFirstNameValue , String shipLastNameValue , String shipAddress1Value , String shipCityValue , String shipStateValue ,String shipZipValue, String shipCountryValue)
	{
		
		waitForTextToAppear("Shipping Address");
		waitFor(shipToFirstName).type(shipFirstNameValue);
		waitFor(shipToLastName).type(shipLastNameValue);
		waitFor(shipAddress1).type(shipAddress1Value);
		waitFor(shipCity).type(shipCityValue);
		waitFor(shipState).type(shipStateValue);
		waitFor(shipZip).type(shipZipValue);
		waitFor(shipCountry).type(shipCountryValue);
		
		return this;
	}
	
	public OrdersPage clickContinue()
	{
		waitFor(continueBtn).click();
		
		return this;
	}
	
	public String orderDetails()
	{
		waitForTextToAppear("Please confirm the information below and then press continue...");
		waitFor(confirmBtn).click();
		waitForTextToAppear("Thank you, your order has been submitted.");
		return waitFor(orderNumber).getText();
		
	}
	

	

}
