package com.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass_Trial {

	@BeforeSuite (alwaysRun = true)
	public void config_BS() throws Throwable
	{
		System.out.println("--connect to db--");
	}
	
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException
	{
		System.out.println("--Browser opened--");
	}

	
	@AfterClass(alwaysRun = true)
	public void config_AC() throws IOException
	{
		System.out.println("--close browser");
	}
	
	@AfterSuite (alwaysRun = true)
	public void config_AS() throws IOException, SQLException
	{
		
		System.out.println("--connect to db--");
		
	}
	
}
