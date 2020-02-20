package com.serenity.pages;

import com.serenity.util.PetCategories;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashBoardPage extends BasePage{
	
	@FindBy(how=How.ID,using="WelcomeContent")
	WebElementFacade greetingMsg;
	
	@FindBy(how=How.XPATH,using="//img[@src='../images/fish_icon.gif']")
	WebElementFacade fishLink;
	
	@FindBy(how=How.XPATH,using="//img[@src='../images/dog_icon.gif']")
	WebElementFacade dogLink;
	
	@FindBy(how=How.XPATH,using="//img[@src='../images/cat_icon.gif']")
	WebElementFacade catLink;
	
	@FindBy(how=How.XPATH,using="//img[@src='../images/reptile_icon.gif']")
	WebElementFacade reptileLink;
	
	@FindBy(how=How.XPATH,using="//img[@src='../images/birds_icon.gif']")
	WebElementFacade birdsLink;
	
	public String getGreetingMsg()
	{
		waitForTitleToAppear("JPetStore Demo");
		return waitFor(greetingMsg).getText();
		
	}
	
	public ProductsPage selectProductFromTheSideBar(PetCategories categories)
	{
		waitForTitleToAppear("JPetStore Demo");
		switch(categories)
		{
		case FISH:
			waitFor(fishLink).click();
			break;
		case CATS:
			waitFor(catLink).click();
		break;
		case DOGS:
			waitFor(dogLink).click();
			break;
		case REPTILES:
			waitFor(reptileLink).click();
			break;
		case BIRDS:
			waitFor(birdsLink).click();
			break;
		
		}
		return this.switchToPage(ProductsPage.class);
	}
	

}
