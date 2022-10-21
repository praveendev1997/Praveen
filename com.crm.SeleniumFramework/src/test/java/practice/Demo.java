package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException {
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		
		FileInputStream fis=new FileInputStream("./common_data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String pwd=pro.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		FileInputStream fis1=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		System.out.println("data ="+data);
		
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(data);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save' ])[1]")).click();
		Thread.sleep(2000);
		
		String title=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		/*if(!title.isEmpty())
		{
			System.out.println("title found--> "+title);
		}
		else
		{
			System.out.println("title not found");
		}*/
		if(title.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.findElement(By.xpath("(//td[@valign='bottom']/img)[1]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(1000);
		driver.close();
		
		
	}

}
