package com.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage{
	
	@FindBy(how=How.NAME,using="username")
	WebElementFacade username;
	
	@FindBy(how=How.NAME,using="password")
	WebElementFacade password;
	
	@FindBy(how=How.XPATH,using="//a[text()='Register Now!']")
	WebElementFacade registerNow;
	
	@FindBy(how=How.CSS,using=".messages > li")
	WebElementFacade invalidSigninMsg;
	
	public BasePage _Login(String usernameValue , String passwordValue)
	{
		waitForTitleToAppear("JPetStore Demo");
		
		waitForTextToAppear("Please enter your username and password.");
		
		waitFor(username).typeAndTab(usernameValue);
		
		waitFor(password).typeAndEnter(passwordValue);
        
		waitForTitleToAppear("JPetStore Demo");
		
		if(invalidSigninMsg.isVisible())
		return this.switchToPage(LoginPage.class);
		else
		return this.switchToPage(DashBoardPage.class);
		
	}
	
	public String _validateInValidCredsMsg()
	{
		
		waitForTextToAppear("Please enter your username and password.");
		
		 return waitFor(invalidSigninMsg).getText();
		
	}
	
	
	public AccountsPage _clickOnregisterNow()
	{
		waitForTextToAppear("Please enter your username and password.");
		
		waitFor(registerNow).click();
		
		return this.switchToPage(AccountsPage.class);
		
	}
	
	

}
