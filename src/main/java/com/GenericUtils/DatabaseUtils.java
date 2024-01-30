package com.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {

	Connection conn=null;

	/**
	 * This method is used to register the driver and build the connection
	 * 
	 */
	public void connectDb() throws Throwable
	{
		//1.Register  and connect to the driver/database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);



		//2.connect to the database
		conn = DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUsername,IPathConstants.DBPassword);
	}

	/**
	 * This method will verify whether the data is present in the database or not
	 * @param query
	 * @param colIndex
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public String executeQuery(String query, int colIndex, String expectedData) throws SQLException
	{
		//3.create statement
		Statement state = conn.createStatement();

		//4. execute statement
		//if required make a method for update as well
		ResultSet res = state.executeQuery(query);
		String actual = "";
		boolean flag= false;
		while(res.next())
		{
			actual=res.getString(colIndex);
			if(actual.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			return actual;
		}

		else {
			return "";
		}

	}

	/**
	 * This method is used to close the connection
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		//5. close database connection
		conn.close();
	}
}
