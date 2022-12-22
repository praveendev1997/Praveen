package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Grid {
	@Test
	public void  selenium_grid() throws MalformedURLException
	{
		URL url=new URL("http://192.168.253.1:4444/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		
	}
}
