package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationAndValidationClass {
	public VerificationAndValidationClass(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement actualOrganizationText;
	
	public WebElement getActualOrganizationText() {
		return actualOrganizationText;
	}
	public void organizationValidation(String data )
	{
		String actData=actualOrganizationText.getText();
		if(actData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
	
}
