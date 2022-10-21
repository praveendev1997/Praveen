package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_Page {
	public Products_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductButton;
	
	@FindBy(name = "productname")
	private WebElement productNameTesxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productConfirmText;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteProductButton;
	

	public WebElement getDeleteProductButton() {
		return deleteProductButton;
	}

	public WebElement getCreateProductButton() {
		return createProductButton;
	}

	public WebElement getProductNameTesxtField() {
		return productNameTesxtField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProductConfirmText() {
		return productConfirmText;
	}
	
	
}
