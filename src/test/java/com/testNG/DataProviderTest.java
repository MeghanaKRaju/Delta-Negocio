package com.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider
	public Object[][] data()
	{
		Object [][] obj= new Object[3][2];

		obj[0][0]="Bangalore";
		obj[0][1]="Mysore";

		obj[1][0]="Pune";
		obj[1][1]="Mumbai";

		obj[2][0]="Delhi";
		obj[2][1]="Bangalore";
		return obj;

	}
		
	//1st way, executing in same class using method name or dataprovider name
	//2nd way, executing in different class using method name or dataprovider name
	//3rd way, from excel
	
	//1st way
	
	@Test (dataProvider = "data")
	
	public void getData(String src, String dest)
	{
		System.out.println("from---> "+src+" to----->"+ dest);
	}
	
	
	//eg:2
		@DataProvider (name="product")
		public Object[][] product()
		{
		Object [][] prod= new Object[2][2];

		prod[0][0]="Samsung";
		prod[0][1]="30000";

		prod[1][0]="Nokia";
		prod[1][1]="9000";
			
		return prod;
		}
		
		
		//eg3
		@DataProvider (name="login")
		public Object[][] loginPage()
		{
		Object [][] log= new Object[2][2];

		log[0][0]="unguardable";
		log[0][1]="admin";

		log[1][0]="test";
		log[1][1]="test";
			
		return log;
		}


}
