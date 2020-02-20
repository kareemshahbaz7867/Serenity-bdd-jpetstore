package com.serenity.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.steps.PetStoreSteps;
import com.serenity.util.PetCategories;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class DashBoardTest {

	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps steps;
	
	@Test
	@Title("Click on links on Dashboard page & arrive at the products page")
	public void navigateToProductsPage()
	{
		steps._navigateToLoginPage();
		steps._clickOnSignIn();
		steps._Login("test123","test123");
		steps._selectProductFromTheSideBar(PetCategories.FISH);
		
	}
}
