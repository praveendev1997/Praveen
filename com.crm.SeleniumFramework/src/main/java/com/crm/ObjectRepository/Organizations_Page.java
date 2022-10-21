package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations_Page {
	public Organizations_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationButton;
	
	@FindBy(name = "accountname")
	private WebElement accountNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrganizationConfirmationText;
	
	

	public WebElement getOrganizationConfirmationText() {
		return OrganizationConfirmationText;
	}

	public WebElement getCreateOrganizationButton() {
		return createOrganizationButton;
	}

	public WebElement getAccountNameTextField() {
		return accountNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
	
	
}
