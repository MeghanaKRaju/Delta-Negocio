package com.testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtils.IPathConstants;

public class ExcelDataToDataProvider {

	@DataProvider
	public Object[][] readData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();

		//or[lastRow+1]-->, then need not give +1 in sh.getLastRowNum()+1
		Object[][] obj = new Object[lastRow][lastCell];
		
			//or i<=lastRow, then need not give +1 in sh.getLastRowNum()+1
		for(int i=0; i<lastRow; i++)

		{
			for(int j=0; j<lastCell; j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;

	}
	
	
	@Test(dataProvider = "readData")
	public void excelExec(String phone, String price)
	{
		System.out.println(phone+"-->"+price);
	}

}


