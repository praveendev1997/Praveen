package com.crm.generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {
	/**
	 * this method is used to wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 * @author Praveen
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * used to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * after every action it will wait for next operation to perform
	 * @param driver
	 */
	public void scriptTimeout(WebDriver driver,int sec)
	{
		driver.manage().timeouts().setScriptTimeout(sec,TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait until element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToPresence(WebDriver driver,WebElement element)    //
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	
	public void waitforTitleContains(WebDriver driver,String partialTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	
	public void waitForTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void waitForAlert(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForUrlContains(WebDriver driver,String PartUrl)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains(PartUrl));
	}
	
	public void waitForUrlMatch(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlMatches(url));
	}
	
	/**
	 * used for mouseOver action On the element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on the element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * used to right click
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * used to double click
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * used for drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void DragAndDropAction(WebDriver driver,WebElement src,WebElement target)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}
	/**
	 * used to switch the frame
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	
	/**
	 * used to switch to default frame
	 * @param driver
	 */
	public void switchToDefaultframe(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * used to switch to Parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
		
	}
	/**
	 * used to handle alert
	 * @param driver
	 */
	public void alertHandleAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertHandleDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to handle listBox or dropdown 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void select(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * custom timeout/wait
	 * @param driver
	 * @param element
	 * @param pollingTime
	 */
	public void waitForElementWithCustomTimeout(WebDriver driver,WebElement element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to switch the browser using partial window title
	 * @param driver
	 * @param partWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partWinTitle)
	{
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> it=allwindow.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			if(driver.getTitle().contains(partWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}

	
}
