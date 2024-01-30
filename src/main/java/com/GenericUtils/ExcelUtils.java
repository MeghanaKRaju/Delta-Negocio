package com.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtils {
/**
 * this method is used to read single data from excel file
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;

	}

/**
 * This method is used to get the last row of the data entered in excel file
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}

	/**
	 * This method is used to read multiple data from excel file
	 * @param sheetName
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String,String> hashMapData(String sheetName, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();


		HashMap<String, String> map= new HashMap<String, String>();

		for(int i=0; i<=lastRow; i++)
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * This method is used to write single data into excel
	 * @author Meghana
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int row, int cell, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	
	
	/**
	 * This method is used to read multiple data from excel using 2d arrays
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
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
}
