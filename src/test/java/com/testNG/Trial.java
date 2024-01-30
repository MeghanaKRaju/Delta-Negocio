package com.testNG;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;

public class Trial extends BaseClass {
	@Test
	public void trial()
	{
		System.out.println("--- Retry ---");
		Assert.fail();
		System.out.println("--- Retry 2---");
	}

}
