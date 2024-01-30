package com.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait for page to load
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}

	/**
	 * This method is used to wait until element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to wait until element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait until element is selected
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waituntilelementToBeSelected(WebDriver driver , int sec , WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**This method is used to wait until alert is present
	 * @param driver
	 * @param sec
	 */
	public void waituntilalertIsPresent(WebDriver driver , int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * This method is used to wait until a certain attribute contains
	 * @param driver
	 * @param sec
	 * @param element
	 * @param attribute
	 * @param value
	 */
	public void waituntilattributeContains(WebDriver driver , int sec,WebElement element,String attribute , String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.attributeContains(element,attribute,value));
	}

	/**
	 * This method is used to wait until text is present in an element
	 * @param driver
	 * @param sec
	 * @param element
	 * @param text
	 */
	public void waituntilTextPresent(WebDriver driver , int sec, WebElement element, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * This method is used to wait until an attribute contains
	 * @param driver
	 * @param sec
	 * @param attribute
	 */
	public void waituntilattributeContains(WebDriver driver , int sec,String attribute)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(attribute));
	}

	/**
	 * This method is used to select an element in list using index from 0
	 * @param element
	 * @param index
	 * @return 
	 */

	public Select selectObj(WebElement element)
	{
		Select s= new Select(element);
		return s;

	}
	public void select(WebElement element, int index)
	{
		selectObj(element).selectByIndex(index);
	}

	/**
	 * This method is used to select an element in list using the value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value)
	{
		selectObj(element).selectByValue(value);
	}
	
	/**
	 * This method is used to select an element in list by visible text
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		selectObj(element).selectByVisibleText(text);
	}

	/**
	 * This method is used to check if the list is of single or multiple
	 * @param element
	 * @return
	 */
	public boolean select(WebElement element)
	{
		boolean res = selectObj(element).isMultiple();
		return res;
	}

	/**
	 * This method is used to retrive all the options in the listbox
	 * @param element
	 * @return
	 */
	public List<WebElement> selectGetAll(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> allOptions = sel.getOptions();
		return allOptions;
	}
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param Element
	 */
	public void mousehover(WebDriver driver, WebElement Element)
	{
		Actions Act = new Actions(driver);
		Act.moveToElement(Element).perform();
	}

	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
	{
		Actions Act = new Actions(driver);
		Act.dragAndDrop(src, target).perform();
	}

	/**
	 * This method will double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickElement(WebDriver driver, WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.doubleClick(element).perform();
	}

	/**
	 * This method will double click
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.doubleClick().perform();
	}

	/**
	 * This method will perform right click action
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.contextClick().perform();
	}

	/**
	 * This method will perform right click action on element
	 * @param driver
	 * @param element
	 */
	public void rightClickElement(WebDriver driver, WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.contextClick(element).perform();
	}

	/**
	 * This method will send data into text box
	 * @param driver
	 */
	public void sendKeysAction(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method will press enter key virtually
	 * @throws AWTException
	 */
	public void keyPressEnter() throws AWTException
	{
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will press control key virtually
	 * @throws AWTException
	 */
	public void keyPressControl( ) throws AWTException
	{
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
	}

	/**
	 * This method will release control key virtually
	 * @throws AWTException
	 */
	public void keyReleaseControl( ) throws AWTException
	{
		Robot r= new Robot();
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	/**
	 * This method will press tab key virtually
	 * @throws AWTException
	 */
	public void keyPressTab( ) throws AWTException
	{
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
	}

	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will cancel alert popup
	 * @param driver
	 */
	public void alertCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will send data to alert popup
	 * @param driver
	 * @param data
	 */
	public void alertSend(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}

	/**
	 * This method is used to get data in alert popup
	 * @param driver
	 * @return
	 */
	public String alertGet(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void frameIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param nameorid
	 */
	public void frameNameOrId(WebDriver driver, String nameorid )
	{
		driver.switchTo().frame(nameorid);
	}

	/**
	 * This method will switch the frame to initial webpage
	 * @param driver
	 */
	public void frameDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}



	/**
	 * This method will switch between windows
	 * @param driver
	 * @param partialWinTitle
	 */

	/**
	 * This method is used to switch to the windows
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();

		//step2: iterate thru the windows
		Iterator<String> it = windows.iterator();

		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();

			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();

			//step6: check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}

	/**
	 * This method is used to open new tab
	 * @param driver
	 */
	public void newTab(WebDriver driver )
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}

	/**
	 * This method is used to open new window
	 * @param driver
	 */
	public void newWindow(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @throws IOException 
	 */
	public void takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\test\\resources\\Screenshot.png");
		FileHandler.copy(src, dest);
	}

	/**
	 * This method is used to scroll to bottom of the page
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollToBottom(WebDriver driver)
	{
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * This method is used to scroll to top of the page
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollToTop(WebDriver driver)
	{
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0)");
	}

	/**
	 * This method is used to scroll the page
	 * @param driver
	 * @param x
	 */
	public void scrollHorizontally(WebDriver driver, int x, int y)
	{
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(x,y)");
	}

	/**
	 * This method is used to scroll to element present in the page vertically
	 * @param driver
	 * @param element
	 * @param x
	 */
	public void scrollToElement(WebDriver driver,WebElement element )
	{
		JavascriptExecutor j= (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		j.executeScript("window.scrollTo(0,"+y+")");
	}

	public static String getScreenShot(WebDriver driver, String screenShot) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		JavaUtils jLib= new JavaUtils();
		String path = "./screenshot/"+screenShot+jLib.getSystemDateInFormat()+".png";
		File dest = new File(path);
		
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}


}
