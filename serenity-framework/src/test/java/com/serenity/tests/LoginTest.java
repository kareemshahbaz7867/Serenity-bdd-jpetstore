package com.serenity.tests;

import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class LoginTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps steps;
	
	@Test
	@Title("Verify if the user is logged in successfuly with valid credentials")
	public void navigateToSignInPage()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123", "test123");
		assertThat(steps._getGreetingMsg(), startsWith("Welcome"));
		
	}
	
	@Test
	@Title("Verify if the user can successfully logout")
	public void verifyIfTheUserCanLogout()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123","test123");
		steps._signOut();
		
	}
	
	@Test
	@Title("Validate the error message when trying to login with invalid credentials")
	public void verifyErrMsgInValidCredentials()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test13", "test123");
		String errorMsg = steps._inValidSignIn();
		assertThat(errorMsg,startsWith("Invalid username or password"));
		
	}
	

}
