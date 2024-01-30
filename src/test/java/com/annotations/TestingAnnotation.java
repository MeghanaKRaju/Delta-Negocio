package com.annotations;

import org.testng.annotations.Test;

public class TestingAnnotation extends Annotations {

	@Test(groups ="smoke")
	public void test3()
	{
		System.out.println("---test3--");
	}
	
	@Test(groups="regression")
	public void test4()
	{
		System.out.println("---test4--");
	}
	
}
