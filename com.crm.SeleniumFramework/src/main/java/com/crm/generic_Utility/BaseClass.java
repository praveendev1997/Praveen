package com.crm.generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	//public static WebDriver sDriver;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("Data Base connection");
	}
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Excecute in parallel mode");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void BC(/*String BROWSER*/) throws Throwable
	{
		File_Utility fu=new File_Utility();
		Webdriver_Utility wu=new Webdriver_Utility();
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
		//sDriver=driver;
		System.out.println("launching the browser");
		wu.implicitWait(driver);
		wu.maximizeBrowser(driver);
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		File_Utility fu=new File_Utility();
		String url = fu.getPropertyKeyValue("url");
		String un = fu.getPropertyKeyValue("username");
		String pwd=fu.getPropertyKeyValue("password");
		driver.get(url);
		Login_Page lp=new Login_Page(driver);
		lp.login(un, pwd);
		System.out.println("login to application");
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM()
	{
		System.out.println("close the browser");
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC()
	{
		System.out.println("Excecuted sucessfully");
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("close the data base");
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("");
	}
}
