package practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Contacts_Page;
import com.crm.ObjectRepository.Home_Page;
import com.crm.ObjectRepository.Login_Page;
import com.crm.generic_Utility.Excel_Utility;
import com.crm.generic_Utility.File_Utility;
import com.crm.generic_Utility.Java_Utility;
import com.crm.generic_Utility.Webdriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactModuleTest {
	@Test
	public void createContactWithOrganization() throws Throwable {
		File_Utility fu=new File_Utility();
		Java_Utility ju=new Java_Utility();
		Excel_Utility eu=new Excel_Utility();
		Webdriver_Utility wu=new Webdriver_Utility();
		String url = fu.getPropertyKeyValue("url");
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
		wu.implicitWait(driver);
		driver.get(url);
		Login_Page lp=new Login_Page(driver);
		Home_Page hp=new Home_Page(driver);
		Contacts_Page cp=new Contacts_Page(driver);
		lp.login(un, pwd);
		hp.getContactsLink().click();
		cp.getCreateContactButton().click();
		String first = eu.getExcelData("Contacts", 0, 0);
		String last =eu.getExcelData("Contacts", 0, 1);
		String orgName=eu.getExcelData("Organization", 0, 0);
		System.out.println("data ="+first+" "+last);
		cp.getFirstNameTextField().sendKeys(first);
		cp.getLastNameTextField().sendKeys(last);
		cp.clickAddOrganizationButton();
		String pw = driver.getWindowHandle();
		wu.switchToWindow(driver,"Accounts&action");
		cp.searchOrganization(orgName);
		cp.clickFirstOrganization();
		wu.switchToWindow(driver, pw);
		WebElement target1 = hp.getUserImage();
		wu.mouseOverAction(driver, target1);
		hp.setSignOut();
		wu.closeBrowser(driver);
	}

}
