package com.serenity.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.serenity.util.PetCategories;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject {
	

	@FindBy(how=How.XPATH,using="//a[text()='Enter the Store']")
	WebElementFacade enterStoreLink;
	
	@FindBy(how=How.XPATH,using="//a[text()='Sign In']")
	WebElementFacade signInLink;
	
	
	@FindBy(how=How.NAME,using="signon")
	WebElementFacade signon;
	
	@FindBy(how=How.NAME,using="img_cart")
	WebElementFacade shoppingCartImg;
	
	@FindBy(how=How.XPATH,using="//a[text()='?']")
	WebElementFacade helpImg;
	
	@FindBy(how=How.NAME,using="keyword")
	WebElementFacade searchInput;
	
	@FindBy(how=How.NAME,using="searchProducts")
	WebElementFacade searchBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='QuickLinks']//img[@src='../images/sm_fish.gif']")
	WebElementFacade fishImg;
	
	@FindBy(how=How.XPATH,using="//div[@id='QuickLinks']//a[contains(@href,'DOGS')]/img")
	WebElementFacade dogImg;
	
	@FindBy(how=How.XPATH,using="//div[@id='QuickLinks']//a[contains(@href,'REPTILES')]/img")
	WebElementFacade reptilesImg;
	
	@FindBy(how=How.XPATH,using="//div[@id='QuickLinks']//a[contains(@href,'CATS')]/img")
	WebElementFacade catsImg;
	
	@FindBy(how=How.XPATH,using="//div[@id='QuickLinks']//a[contains(@href,'BIRDS')]")
	WebElementFacade birdsImg;
	
	@FindBy(how=How.XPATH,using="img[@href='../images/logo-topbar.gif']")
	WebElementFacade jpetStoreDemoImg;
	
	@FindBy(how=How.XPATH,using="//a[text()='Sign Out']")
	WebElementFacade signOut;
	
	@FindBy(how=How.XPATH,using="//a[text()='My Account']")
    WebElementFacade myAccount;	
	
	public LoginPage navigateToLoginPage()
	{
		open();
		
		waitForTitleToAppear("JPetStore Demo").waitFor(enterStoreLink).click();
		
		return this.switchToPage(LoginPage.class);
		
		
	}
	
	public LoginPage clickOnSignIn()
	{
		waitForTitleToAppear("JPetStore Demo").waitFor(signInLink).click();
		
		return this.switchToPage(LoginPage.class);
		
	}
	
	
	public DashBoardPage navigateToDashboard()
	{
		waitForTitleToAppear("JPetStore Demo").waitFor(jpetStoreDemoImg).click();
	    	
		return this.switchToPage(DashBoardPage.class);
		
	}
	
	
	public DashBoardPage signOut()
	{
		waitForTitleToAppear("JPetStore Demo").waitFor(signOut).click();
		
		waitForTextToDisappear("Welcome");
		
		return this.switchToPage(DashBoardPage.class);
		
	}
	
	public AccountsPage clickOnMyAccount()
	{
		
		waitForTitleToAppear("JPetStore Demo").waitFor(myAccount).click();
		
		return this.switchToPage(AccountsPage.class);
		
	}
	
	public ProductsPage search(String searchValue)
	{
		waitForTitleToAppear("JPetStore Demo").waitFor(searchInput).sendKeys(searchValue);
		
		waitFor(searchBtn).click();
		
		return this.switchToPage(ProductsPage.class);
	}
	
	
	
	public HelpPage navigateToHelpPage()
	{
		waitForTitleToAppear("JPetStore Demo").waitFor(helpImg).click();
		
		return this.switchToPage(HelpPage.class);
		
	}
	
	public ProductsPage navigateToProductPage()
	{
		waitForTitleToAppear("JPetStore Demo").waitFor(helpImg).click();
		
		return this.switchToPage(ProductsPage.class);
	}
	
	public ProductsPage navigateToProductsCategory(PetCategories productCategory)
	{
		waitForTitleToAppear("JPetStore Demo");
		
		switch(productCategory)
		{
		case FISH:
			waitFor(fishImg).click();
			break;
			
		case CATS:
			waitFor(catsImg).click();
			break;
			
		case DOGS:
			waitFor(dogImg).click();
			break;
		case REPTILES:
			waitFor(reptilesImg).click();
			break;
		case BIRDS:
			waitFor(birdsImg).click();
			break;
		default:
			break;
				
			
		}

		
		return this.switchToPage(ProductsPage.class);
		
	}

	
	
}
