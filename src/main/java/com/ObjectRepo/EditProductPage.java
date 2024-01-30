package com.ObjectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtils.ExcelUtils;
import com.GenericUtils.WebdriverUtils;

public class EditProductPage {
	
	@FindBy(linkText = "Back")
	private WebElement backBtn;
	
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	
	public EditProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBackBtn() {
		return backBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	//business logic
	public void editProduct(WebDriver driver,String sheetName, int cell,ExcelUtils eLib, WebdriverUtils wLib, String partText) throws EncryptedDocumentException, IOException
	{
	
		HashMap<String, String> map = eLib.hashMapData("product", 0);

		for(Entry<String, String> set:map.entrySet())
		{
			String key= set.getKey();
			String value= set.getValue();
			
			if(set.getKey().contains("//h5[text()='Add Product']/../..//input[@name='price']"))
			{
				driver.findElement(By.xpath(key)).sendKeys(value);
			}
			
		}
		
		WebElement categoryList = driver.findElement(By.name("category"));
		wLib.select(partText, categoryList);
			
	
	}
	
}
