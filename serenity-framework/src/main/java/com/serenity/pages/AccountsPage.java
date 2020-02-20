package com.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountsPage extends BasePage {
	
	@FindBy(how=How.NAME,using="username")
	WebElementFacade username;
	
	@FindBy(how=How.NAME ,using="password")
	WebElementFacade password;
	
	@FindBy(how=How.NAME ,using="repeatedPassword")
	WebElementFacade repeatedPassword;
	
	@FindBy(how=How.NAME,using="account.firstName")
	WebElementFacade firstName;
	
	@FindBy(how=How.NAME ,using="account.lastName")
	WebElementFacade lastName;
	
	@FindBy(how=How.NAME ,using="account.email")
	WebElementFacade email;
	
	
	@FindBy(how=How.NAME,using="account.phone")
	WebElementFacade phone;
	
	@FindBy(how=How.NAME ,using="account.address1")
	WebElementFacade address1;
	
	@FindBy(how=How.NAME ,using="account.address2")
	WebElementFacade address2;
	
	
	@FindBy(how=How.NAME ,using="account.city")
	WebElementFacade city;
	
	
	@FindBy(how=How.NAME,using="account.state")
	WebElementFacade state;
	
	@FindBy(how=How.NAME ,using="account.zip")
	WebElementFacade zip;
	
	@FindBy(how=How.NAME ,using="account.country")
	WebElementFacade country;
	
	@FindBy(how=How.NAME, using="account.languagePreference")
	WebElementFacade langPreference;
	
	@FindBy(how=How.NAME, using="account.favouriteCategoryId")
	WebElementFacade favouriteCat;
	
	@FindBy(how=How.NAME , using="account.listOption")
	WebElementFacade myList;
	
	@FindBy(how=How.NAME , using="account.bannerOption")
	WebElementFacade myBanner;
	
	@FindBy(how=How.NAME,using="newAccount")
	WebElementFacade saveAccountInfo;
	
	
	
	
	public AccountsPage enterUserInformation(String usernameValue , String passwordValue , String repeatedPasswordValue)
	{
		waitForTextToAppear("User Information").waitFor(username).typeAndTab(usernameValue);
		
		waitFor(password).typeAndTab(passwordValue);
		
		waitFor(repeatedPassword).type(repeatedPasswordValue);
		
		return this.switchToPage(AccountsPage.class);
		
	}
	
	
	public AccountsPage enterAccountInformation(String firstNameValue , String lastNameValue , String emailValue , String phoneValue , String address1Value , String address2Value , String cityValue , String stateValue , String zipValue , String countryValue)
	{
		waitForTextToAppear("Account Information");
		
		waitFor(firstName).typeAndTab(firstNameValue);
		
		waitFor(lastName).typeAndTab(lastNameValue);
		
		waitFor(email).typeAndTab(emailValue);
		
		waitFor(phone).typeAndTab(phoneValue);
		
		
		waitFor(address1).typeAndTab(address1Value);
		waitFor(address2).typeAndTab(address2Value);
		
		waitFor(city).typeAndTab(cityValue);
		waitFor(state).typeAndTab(stateValue);
		waitFor(zip).typeAndTab(zipValue);
		waitFor(country).type(countryValue);
		
		
		return this.switchToPage(AccountsPage.class);
	}
	
	
	public AccountsPage enterProfileInformation(String languagePrefValue , String favoriteCatValue , boolean enableMyList , boolean enableMyBanner)
	{
		
		waitForTextToAppear("Profile Information");
		
		waitFor(langPreference).selectByValue(languagePrefValue);
		
		waitFor(favouriteCat).selectByValue(favoriteCatValue);
		
		waitFor(myList);
		
		setCheckbox(myList, enableMyList);
		
		setCheckbox(myBanner, enableMyBanner);
		
		return this.switchToPage(AccountsPage.class);
	}
	
	
	public DashBoardPage saveAccountInformation()
	{
		
		waitFor(saveAccountInfo).click();
		
		return this.switchToPage(DashBoardPage.class);
	}
	

}
