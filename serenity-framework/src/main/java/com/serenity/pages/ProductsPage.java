package com.serenity.pages;

//static imports for working on the table
import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.serenity.util.PetCategories;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;


public class ProductsPage extends BasePage {
	
	@FindBy(how=How.XPATH,using="//div[@id='Catalog']/table")
	private WebElementFacade productTable;
	public static final String ANCHOR = "//div[@id='Catalog']//tr/td[normalize-space()='";
	
	@FindBy(how=How.NAME,using="updateCartQuantities")
	private WebElement updateCard;
	
	@FindBy(how=How.XPATH,using="//div[@id='Catalog']//tr/td[5]/input")
	private WebElement quantityXpath;
	
	@FindBy(how=How.XPATH,using="//a[text()='Proceed to Checkout']")
	private WebElementFacade proceedToCheckout;
	/*
	 * select the pet by providing a name
	 * @param petcategory
	 * @param petName
	 * 
	 */
	public ProductsPage _selectPetByName(PetCategories petCategories , String petName)
	{
		waitForTextToAppear(petCategories.getValue());
		List<WebElement> rows = inTable(productTable).filterRows(the("Name",equalTo(petName)));
		rows.get(0).findElement(By.tagName("a")).click();;
		return this.switchToPage(ProductsPage.class);
		
	}

	
	public ProductsPage addToCartSpecificProduct(String specificProductName)
	{
		String element = "']/parent::tr/child::td/a[text()='Add to Cart']";
		
		String addToCart = ANCHOR+specificProductName+element;
		
		waitFor(addToCart).$(addToCart).click();
		
		return this;
	}
	
	public ProductsPage addToCartByViewingDetails(String specificProductName , String ...details)
	{
		String element = "']/parent::tr/td/a[contains(@href,'viewItem')]";
		
		String itemId = ANCHOR+specificProductName+element;
		
		waitFor(itemId).$(itemId).click();
		
		waitForTitleToAppear("JPetStore Demo");
		
		
		
		waitForAnyTextToAppear(details[0],details[1],details[2]);
		
		$("//a[text()='Add to Cart']").click();
		
		return this;
	}
	
	public ProductsPage selectProductFromSearchTable(String productName)
	{
		
		String element = "']/parent::tr/td/a";
		
		String xpath = ANCHOR+productName+element;
		
		waitForTitleToAppear("JPetStore Demo").waitFor(xpath).$(xpath).click();
		
	
		return this;
	}
	
	public Boolean updateCartWithQuantity(String quantity)
	{
		
		waitForTitleToAppear("JPetStore Demo");
		
		waitForTextToAppear("Shopping Cart");
		
		waitFor(quantityXpath).type(quantity);
		waitFor(updateCard).click();
		
		String listPrice ="//div[@id='Catalog']//tr/td[6]";
		Float pricePerUnit = Float.valueOf(waitFor(listPrice).$(listPrice).getText().substring(1));
		Float quantityFloat = Float.valueOf(quantity);
		
		Float total = pricePerUnit*quantityFloat;
		System.out.println(total);
		
		String totalCost ="//div[@id='Catalog']//tr/td[7]";
		
		Float actualCost = Float.valueOf($(totalCost).getText().substring(1));
		System.out.println("actual cost"+actualCost);
		
		if(Float.compare(total,actualCost)==0)
			return true;
		else return false;
	
	}
	
	public OrdersPage proceedToCheckout()
	{
		waitFor(proceedToCheckout).click();
		
		return this.switchToPage(OrdersPage.class);
		
	}
	
}
