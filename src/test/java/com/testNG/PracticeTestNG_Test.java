package com.testNG;

import org.testng.annotations.Test;

public class PracticeTestNG_Test {
	
	@Test(priority=-5, invocationCount=2, enabled =false)
	
	public void createTest()
	{
		System.out.println("-- create test--");
	}
	
	@Test (priority=0,dependsOnMethods="createTest")
	public void editTest()
	{
		System.out.println("-- edit test--");
	}
	
	@Test (priority=0 )
	public void deleteTest()
	{
		System.out.println("-- delete test--");
	}
	
	

}
