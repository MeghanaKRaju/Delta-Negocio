package com.annotations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtils.BaseClass;
import com.GenericUtils.BaseClass_Trial;

public class AC extends BaseClass_Trial {
	@Test

	public void A()
	{
		System.out.println("A");
	}


	@Test
	public void B()
	{
		System.out.println("B");
	}
	
	@Test
	public void C()
	{
		System.out.println("C");
	}
	
	SoftAssert s= new SoftAssert();
	
	
	
	
}


