package com.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	//create objects of utility classes
//	public DatabaseUtils dLib= new DatabaseUtils();
	public Fileutils fLib= new Fileutils();
	public WebdriverUtils wLib= new WebdriverUtils();
	public JavaUtils jLib= new JavaUtils();
	public DatabaseUtils dLib= new DatabaseUtils();
	public ExcelUtils eLib= new ExcelUtils();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite (alwaysRun = true)
	public void config_BS() throws Throwable
	{
		dLib.connectDb();
		System.out.println("--connect to db--");
	}

	//not using before and after method here because of multiple users-(admin and user)
	// if one credential is there, then we can have before and after method
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException
	{
		
		String browser=fLib.readData("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		
		//reinitialising driver for screenshot
		sdriver=driver;
		
		wLib.maximizeWindow(driver);
		String url = fLib.readData("url");
		driver.get(url);
		wLib.waitForPageLoad(driver, 20);
		System.out.println("--open browser and enter url--");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC() throws IOException
	{
		driver.quit();
		System.out.println("--close browser");
		
	}
	
	@AfterSuite (alwaysRun = true)
	public void config_AS() throws IOException, SQLException
	{
		dLib.closeConnection();
		Reporter.log("--close db connection--",true);
		
	}
	

}
