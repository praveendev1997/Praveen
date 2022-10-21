package com.crm.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts_Page {
	public Contacts_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactButton;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement addOrganizationButton;
	
	@FindBy(id = "search_txt")
	private WebElement searchTextField;
	
	@FindBy(id = "1")
	private WebElement firstOrganization;

	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getFirstOrganization() {
		return firstOrganization;
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getAddOrganizationButton() {
		return addOrganizationButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void clickAddOrganizationButton()
	{
		addOrganizationButton.click();
	}
	public void searchOrganization(String productName)
	{
		searchTextField.sendKeys(productName+Keys.ENTER);
	}
	public void clickFirstOrganization()
	{
		firstOrganization.click();
	}
	
	
	
}
