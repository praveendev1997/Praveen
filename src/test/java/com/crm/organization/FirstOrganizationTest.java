package com.crm.organization;
	import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Home_Page;
import com.crm.ObjectRepository.Organizations_Page;
import com.crm.ObjectRepository.VerificationAndValidationClass;
import com.crm.generic_Utility.BaseClass;
import com.crm.generic_Utility.Excel_Utility;
import com.crm.generic_Utility.Java_Utility;
import com.crm.generic_Utility.Webdriver_Utility;
	
	public class FirstOrganizationTest extends BaseClass{
		@Test(retryAnalyzer  = com.crm.generic_Utility.RetryAnalyzer.class)
		
		public void createOrganizationTest()  throws Throwable {
																		//String key="webdriver.chrome.driver";
																		//String value="./chromedriver.exe";
																		//System.setProperty(key, value);
			Java_Utility ju=new Java_Utility();
			Excel_Utility eu=new Excel_Utility();
			Webdriver_Utility wu=new Webdriver_Utility();
																			//driver.manage().window().maximize();
			wu.maximizeBrowser(driver);
																			//driver.findElement(By.name("user_name")).sendKeys(un);
																			//driver.findElement(By.name("user_password")).sendKeys(pwd);
																			//driver.findElement(By.id("submitButton")).click();
			int rnum = ju.getRandomNum();
			String data = eu.getExcelData("Organization", 0, 0)+rnum;
			System.out.println("data ="+data);
			Home_Page hp=new Home_Page(driver);
			hp.getOrganizationLink().click();
																			//driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
			Organizations_Page op=new Organizations_Page(driver);
			op.getCreateOrganizationButton().click();
																			//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			op.getAccountNameTextField().sendKeys(data);
			Assert.assertEquals(true, false);																//driver.findElement(By.name("accountname")).sendKeys(data);
			op.getSaveButton().click();																
			VerificationAndValidationClass vv=new VerificationAndValidationClass(driver);
			vv.organizationValidation(data);
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			/*WebElement headerText = op.getOrganizationConfirmationText();
			wu.waitForElement(driver,headerText);
			String title=headerText.getText();
																			//String title=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(title.contains(data))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}*/
			wu.mouseOverAction(driver,hp.getUserImage());
			hp.setSignOut();
																			//driver.findElement(By.linkText("Sign Out")).click();
																			//driver.close();
			wu.closeBrowser(driver);
			
		}
		@Test
		public void modifyOrganization()
		{
			System.out.println("organization modified");
		}


}
