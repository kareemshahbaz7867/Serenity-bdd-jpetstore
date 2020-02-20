package com.serenity.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.serenity.steps.PetStoreSteps;
import com.serenity.util.PetCategories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class OrdersTest {

	@Managed
	WebDriver driver;

	@Steps
	PetStoreSteps steps;

	@Test
	@Title("Place an order")
	public void proceedToOrdersAndShipping() {
		Faker faker = new Faker();
		String cardTypeValue = "Visa";
		String cardNumberValue = faker.finance().creditCard(CreditCardType.VISA);
		String expiryDateValue = "12/2026";
		String firstNameValue = faker.name().firstName();
		String lastNameValue = faker.name().lastName();
		String address1Value = faker.address().buildingNumber();
		String address2Value = faker.address().streetAddress();
		String cityValue = faker.address().city();
		String stateValue = faker.address().state();
		String zipValue = faker.address().zipCode();
		String countryValue = faker.address().country();

		String shipFirstNameValue = faker.address().firstName();
		String shipLastNameValue = faker.address().lastName();
		String shipAddress1Value = faker.address().buildingNumber();
		String shipCityValue = faker.address().city();
		String shipStateValue = faker.address().state();
		String shipZipValue = faker.address().zipCode();
		String shipCountryValue = faker.address().country();

		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		steps._getGreetingMsg();
		System.out.println(PetCategories.FISH.getValue());
		steps._search(PetCategories.FISH.getValue());
		steps._selectProductFromSearchTable("Goldfish");
		steps._addToCartByViewingDetails("Adult Male Goldfish", "Goldfish", "Fresh Water fish from China", "EST-20");
		assertTrue(steps._updateCartWithQuantity("6"));
		steps._proceedToCheckout();

		steps._enterPaymentDetailsAndBillingAddress(cardTypeValue, cardNumberValue, expiryDateValue, firstNameValue,
				lastNameValue, address1Value, address2Value, cityValue, stateValue, zipValue, countryValue);
		steps._selectShipToDifferentAddress();
		steps._clickContinue();
		steps._enterShippingAddress(shipFirstNameValue, shipLastNameValue, shipAddress1Value, shipCityValue,
				shipStateValue, shipZipValue, shipCountryValue);
		steps._clickContinue();
		steps.log(steps._orderDetails());

	}

}
