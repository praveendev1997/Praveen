package com.crm.campaign;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Campaigns_Page;
import com.crm.ObjectRepository.Home_Page;
import com.crm.generic_Utility.BaseClass;
import com.crm.generic_Utility.Excel_Utility;
import com.crm.generic_Utility.File_Utility;
import com.crm.generic_Utility.Java_Utility;
import com.crm.generic_Utility.Webdriver_Utility;


public class CampaignWithProductTest extends BaseClass {
	@Test(groups = {"smokeTest"})
	public void createCampaignWithProductTest() throws Throwable{
		File_Utility fu=new File_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		Webdriver_Utility wu=new Webdriver_Utility();
																									/*WebDriver driver;
																									String BROWSER=fu.getPropertyKeyValue("browser");
																									if(BROWSER.equalsIgnoreCase("chrome"))
																									{
																										WebDriverManager.chromedriver().setup();
																										driver=new ChromeDriver();
																									}
																									else if(BROWSER.equalsIgnoreCase("firefox"))
																									{
																										WebDriverManager.firefoxdriver().setup();
																										driver=new FirefoxDriver();
																									}
																									else if(BROWSER.equalsIgnoreCase("edge"))
																									{
																										WebDriverManager.edgedriver().setup();
																										driver=new EdgeDriver();
																									}
																									else
																									{
																										driver=new ChromeDriver();
																									}
																									String url = fu.getPropertyKeyValue("url");
																									String un = fu.getPropertyKeyValue("username");
																									String pwd=fu.getPropertyKeyValue("password");
																									wu.maximizeBrowser(driver);
																									wu.implicitWait(driver);
																									driver.get(url);
																									Login_Page lp=new Login_Page(driver);*/
		Home_Page hp=new Home_Page(driver);
																									//lp.login(un, pwd);
		int rnum = ju.getRandomNum();
		String data = eu.getExcelData("Campaign", 0, 0)+rnum;
		System.out.println("data ="+data);
		String product = eu.getExcelData("Product", 0, 0);
		Campaigns_Page cp=new Campaigns_Page(driver);
		WebElement target = hp.getMoreLink();
		wu.mouseOverAction(driver, target);
		hp.getCampaignLink().click();
		cp.getCreateCampaignButton().click();
		cp.getCampaignNameTextField().sendKeys(data);
		cp.getAddProductButton().click();
		String p_win = driver.getWindowHandle();																				
		wu.switchToWindow(driver,"Products&action");
		cp.searchProduct(product);
		cp.clickFirstProduct();
		wu.switchToWindow(driver, p_win);
		cp.getSaveButton().click();
		String title = cp.getConfirmCampaignText().getText();
		if(title.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement target1 =hp.getUserImage();
		wu.mouseOverAction(driver, target1);
		hp.setSignOut();
		wu.closeBrowser(driver);
	}


}
