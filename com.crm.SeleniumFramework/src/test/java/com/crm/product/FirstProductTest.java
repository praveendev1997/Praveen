package com.crm.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Home_Page;
import com.crm.ObjectRepository.Login_Page;
import com.crm.ObjectRepository.Products_Page;
import com.crm.generic_Utility.BaseClass;
import com.crm.generic_Utility.Excel_Utility;
import com.crm.generic_Utility.File_Utility;
import com.crm.generic_Utility.Java_Utility;
import com.crm.generic_Utility.Webdriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstProductTest extends BaseClass {
	@Test(groups = {"smokeTest","regressionTest"})
	public void createProductTest() throws Throwable {
																												/*String key="webdriver.chrome.driver";
																												String value="./chromedriver.exe";
																												System.setProperty(key, value);*/
		File_Utility fu=new File_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		Webdriver_Utility wu=new Webdriver_Utility();
		//String url = fu.getPropertyKeyValue("url");
		//String un = fu.getPropertyKeyValue("username");
		//String pwd=fu.getPropertyKeyValue("password");
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
																												//driver.manage().window().maximize();
		wu.maximizeBrowser(driver);
																												//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wu.implicitWait(driver);
		driver.get(url);
		Login_Page lp=new Login_Page(driver);
		lp.login(un, pwd);*/																						/*driver.findElement(By.name("user_name")).sendKeys(un);
																												driver.findElement(By.name("user_password")).sendKeys(pwd);
																												driver.findElement(By.id("submitButton")).click();*/
																												//Thread.sleep(1000);
		int rnum = ju.getRandomNum();
		String data = eu.getExcelData("Product", 0, 0)+rnum;
		System.out.println("data ="+data);
		Home_Page hp=new Home_Page(driver);
		Products_Page pp=new Products_Page(driver);
		hp.getProductLink().click();
		pp.getCreateProductButton().click();
																												//driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
       //Assert.assertEquals(false,true);																								//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		pp.getProductNameTesxtField().sendKeys(data);
		pp.getSaveButton().click();																				//driver.findElement(By.name("productname")).sendKeys(data);
																												//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String name = pp.getProductConfirmText().getText();
		if(name.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		WebElement target =hp.getUserImage();
																												/*Actions act=new Actions(driver);
																												act.moveToElement(target).perform();*/
		wu.mouseOverAction(driver, target);
		
		hp.setSignOut();
		
		wu.closeBrowser(driver);
		
	}

}
