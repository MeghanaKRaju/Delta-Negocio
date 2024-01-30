package com.testNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtils.ExcelUtils;

public class DataProvider_ExecutionTest {
	//way2 -executing data provider :executing in different class using method name or data provider name

	@Test(dataProviderClass= DataProviderTest.class,dataProvider = "product")

	public void execTest(String prodName, String price)
	{
		System.out.println("from---> "+prodName+" to----->"+ price);
	}

	
	@Test(dataProviderClass= DataProviderTest.class,dataProvider = "login")

	public void execLogin(String un, String pwd)
	{
		System.out.println("user---> "+un+" password----->"+ pwd);
	}
	
	//-------------------------------------------------------------------------------------
	//excel utils
	
	@DataProvider
	public Object[][] genericTest() throws Throwable, IOException
	{
		ExcelUtils eLib = new ExcelUtils();
		Object[][] value = eLib.readMultipleData("Sheet1");
		return value;
	}
	
	@Test(dataProvider = "genericTest")
	public void executeTest(String a, String b)
	{
		System.out.println(a+" -------> "+b);
	}
	
	
	

}
