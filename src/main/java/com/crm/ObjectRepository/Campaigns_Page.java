package com.crm.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns_Page {
	public Campaigns_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignButton;
	
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addProductButton;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement confirmCampaignText;
	
	@FindBy(id = "1")
	private WebElement firstProduct;
	
	@FindBy(id="search_txt")
	private WebElement searchProduct;
	
	
	public WebElement getSearchProduct() {
		return searchProduct;
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

	public WebElement getConfirmCampaignText() {
		return confirmCampaignText;
	}

	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}
	public void clickFirstProduct()
	{
		firstProduct.click();
	}
	public void searchProduct(String productName)
	{
		searchProduct.sendKeys(productName+Keys.ENTER);
	}
	
}
