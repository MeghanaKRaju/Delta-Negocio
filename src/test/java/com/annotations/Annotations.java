package com.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void connectDb()
	{
		System.out.println("Open DB Connection");
	}
	
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("Browser opened");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("Login to app");
	}
	
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logged out");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Browser closed");
	}
	
	@AfterSuite
	public void closeDb()
	{
		System.out.println("Close DB Connection");
	}

}
