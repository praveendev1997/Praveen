package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	public void test()
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement opt = driver.findElement(By.xpath("//select"));
		Select s=new Select(opt);
		List<WebElement> allOp = s.getOptions();
		for(WebElement op:allOp)
		{
			System.out.println(op.getText());
		}
	}
}
