package com.annotations;

import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;
import com.GenericUtils.BaseClass_Trial;

public class GI extends BaseClass_Trial{
	@Test

	public void G()
	{
		System.out.println("G");
	}


	@Test
	public void H()
	{
		System.out.println("H");
	}
	
	@Test
	public void I()
	{
		System.out.println("I");
	}


}
