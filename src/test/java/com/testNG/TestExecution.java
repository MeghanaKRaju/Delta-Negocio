package com.testNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.WebdriverUtils;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.ProductPage;

public class TestExecution {
	
	Fileutils fLib= new Fileutils();
	ExcelUtils eLib= new ExcelUtils();
	WebdriverUtils wLib= new WebdriverUtils();
	WebDriver driver;

	@BeforeSuite
	public void DbConnection()
	{
		System.out.println("Open DB Connection");
	}
	
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		driver= new ChromeDriver();

		wLib.maximizeWindow(driver);

		String url = fLib.readData("url");
		driver.get(url);
		wLib.waitForPageLoad(driver, 20);
		System.out.println("-- before class executed --");
	}
	
	@BeforeMethod
	public void login() throws IOException, Throwable
	{
		System.out.println("-- login to app --");
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(driver,adminUsername, adminPassword);
		Thread.sleep(4000);
		wLib.alertAccept(driver);
		System.out.println("-- Logged in to app --");
	}
	
	@Test

	public void productPage() throws IOException, Throwable
	{

		ProductPage pp= new ProductPage(driver);
		pp.productList(driver);

		String actualUrl = driver.getCurrentUrl();
		Thread.sleep(4000);
		if(actualUrl.contains("product"))
		{
			System.out.println("Product list page is displayed");
		}

		else
		{
			System.out.println("Product list page is not displayed");

		}

	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logged out");
	}
	
	@AfterClass
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(4000);
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterSuite
	public void closeDb()
	{
		System.out.println("Close DB Connection");
	}

}
