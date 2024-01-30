package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation_Multiple_BM {

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
	public void login1()
	{
		System.out.println("Login to app1");
	}
	
	@BeforeMethod
	public void login2()
	{
		System.out.println("Login to app2");
	}
	@BeforeMethod
	public void login3()
	{
		System.out.println("Login to app3");
	}
	
	@Test
	public void execute()
	{
		System.out.println("Script executed");
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
