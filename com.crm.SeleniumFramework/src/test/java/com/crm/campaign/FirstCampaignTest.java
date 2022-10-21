package com.crm.campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.Campaigns_Page;
import com.crm.ObjectRepository.Home_Page;
import com.crm.ObjectRepository.Login_Page;
import com.crm.ObjectRepository.VerificationAndValidationClass;
import com.crm.generic_Utility.BaseClass;
import com.crm.generic_Utility.Excel_Utility;
import com.crm.generic_Utility.File_Utility;
import com.crm.generic_Utility.Java_Utility;
import com.crm.generic_Utility.Webdriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstCampaignTest extends BaseClass {
	@Test(groups = {"smokeTest","regressionTest"})
	public void createCampaignTest() throws Throwable {
		File_Utility fu=new File_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		Webdriver_Utility wu=new Webdriver_Utility();
																												/*String url = fu.getPropertyKeyValue("url");
																												String un = fu.getPropertyKeyValue("username");
																												String pwd=fu.getPropertyKeyValue("password");
																												WebDriver driver;
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
																												wu.maximizeBrowser(driver);
																												driver.get(url);*/
																												//Login_Page lp=new Login_Page(driver);
		Home_Page hp=new Home_Page(driver);
		Campaigns_Page cp=new Campaigns_Page(driver);
																												//lp.login(un, pwd);
		int rnum = ju.getRandomNum();
		String data = eu.getExcelData("Campaign", 0, 0)+rnum;
		System.out.println("data ="+data);
		WebElement target = hp.getMoreLink();
		wu.mouseOverAction(driver, target);
		hp.getCampaignLink().click();
		cp.getCreateCampaignButton().click();
		cp.getCampaignNameTextField().sendKeys(data);
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals("A","B");
		cp.getSaveButton().click();
		VerificationAndValidationClass vv=new VerificationAndValidationClass(driver);
		vv.organizationValidation(data);
		/*String title=cp.getConfirmCampaignText().getText();
		if(title.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		*/
		WebElement target1 = hp.getUserImage();
		wu.mouseOverAction(driver, target1);
		
		hp.setSignOut();
		
		wu.closeBrowser(driver);
		//soft.assertAll();
	}
}
