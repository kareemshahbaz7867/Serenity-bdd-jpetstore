package com.serenity.tests;

import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.serenity.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AccountsTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps steps;
	
	@Test
	@Title("Register a new user & verify if the new user can login")
	public void registerNewUserandValidateLogin()
	{
		Faker fake = new Faker();
		
		String usernameValue = "test"+fake.number().randomNumber(100,false);
		String passwordValue = fake.internet().password();
		String repeatedPasswordValue = passwordValue;
		
		String firstName = fake.name().firstName();
		String lastName = fake.name().lastName();
		String email = fake.internet().emailAddress();
		String phone = fake.phoneNumber().cellPhone();
		String address1 = fake.address().buildingNumber();
		String address2 = fake.address().streetName();
		String city = fake.address().cityName();
		String state = fake.address().stateAbbr();
		String zip=fake.address().zipCodeByState(state);
		String country=fake.address().country();
		
		
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._clickOnRegisterNow();
		steps._enterUserInformation(usernameValue, passwordValue, repeatedPasswordValue);
		steps._enterAccountInformation(firstName,lastName, email, phone, address1, address2, city, state, zip, country);
		steps._enterProfileInformation("english", "FISH",true, true);
		steps._saveAccountInformation();
		steps._clickOnSignIn();
		steps._Login(usernameValue, passwordValue);
		assertThat(steps._getGreetingMsg(),startsWith("Welcome"));
		
	}
}
