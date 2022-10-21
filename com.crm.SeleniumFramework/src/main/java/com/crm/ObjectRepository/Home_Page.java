package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy (name = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement userImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getUserImage() {
		return userImage;
	}
	public void setSignOut() {
		signOutLink.click();
	}
	
	
}
