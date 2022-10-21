package practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidrTest {
	@Test(dataProvider ="dataProvider_test" )
	public void companyDetails(String name,String PhNum, String email) throws InterruptedException
	{
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(PhNum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.quit();
		Thread.sleep(1000);
		
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] ob=new Object[3][3];
		ob[0][0]="AAA";
		ob[0][1]="8236293248";
		ob[0][2]="jgabsd@gmail.com";
		
		ob[1][0]="BBB";
		ob[1][1]="818613248";
		ob[1][2]="yegnsd@gmail.com";
		
		ob[2][0]="CCC";
		ob[2][1]="1973173178";
		ob[2][2]="idhsfsd@gmail.com";
		return ob;
	}
}
