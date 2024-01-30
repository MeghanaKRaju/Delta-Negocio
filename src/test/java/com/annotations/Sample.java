package com.annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;

@Listeners(com.GenericUtils.ListImplClass.class)
public class Sample extends BaseClass{

	@Test(groups = "regression")
	public void test1()
	{
		WebDriver driver= new ChromeDriver();
		Assert.fail();
		System.out.println("---test1--");
	}
	
	@Test(groups="smoke")
	public void test2()
	{
		System.out.println("---test2--");
	}
	
	
}
