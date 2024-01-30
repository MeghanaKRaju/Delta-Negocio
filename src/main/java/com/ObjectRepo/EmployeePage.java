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

public class EmployeePage extends WebdriverUtils {
	@FindBy(xpath="//a[@data-target='#employeeModal']")
	private WebElement addEmployeerBtn;
	
	@FindBy(id="FromDate")
	private WebElement hiredDate;
	
	@FindBy(name="gender")
	private WebElement genderList;

	@FindBy(name="jobs")
	private WebElement jobList;
	
	@FindBy(name="province")
	private WebElement provinceList;
	
	@FindBy(name="city")
	private WebElement cityList;
	
	@FindBy(xpath="//h5[text()='Add Employee']/../..//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//h5[text()='Add Employee']/../..//button[@type='reset']")
	private WebElement resetBtn;
	
	@FindBy(xpath="//h5[text()='Add Employee']/../..//button[text()='Cancel']")
	private WebElement cancelBtn;
	
	@FindBy(name="dataTable_length")
	private WebElement entriesDropdown;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextbox;
	
	@FindBy(xpath="//a[text()='Previous']")
	private WebElement previousBtn;
	
	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextBtn;
	
	
	public EmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddEmployeerBtn() {
		return addEmployeerBtn;
	}
	
	public WebElement getHiredDate() {
		return hiredDate;
	}
	
	public WebElement getGenderList() {
		return genderList;
	}

	public WebElement getJobList() {
		return jobList;
	}

	public WebElement getProvinceList() {
		return provinceList;
	}

	public WebElement getCityList() {
		return cityList;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getEntriesDropdown() {
		return entriesDropdown;
	}

	public WebElement getSearchTextbox() {
		return searchTextbox;
	}

	public WebElement getPreviousBtn() {
		return previousBtn;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	public void createEmployee(WebDriver driver,String ddmmyyyy, String gender, String job, String province, String city) throws EncryptedDocumentException, IOException
	{
		
		HomePage hp= new HomePage(driver);
		hp.getEmployee().click();
		
		addEmployeerBtn.click();
		hiredDate.click();
		
		hiredDate.sendKeys(ddmmyyyy);
		
		ExcelUtils eLib= new ExcelUtils();
		
		HashMap<String, String> map = eLib.hashMapData("Employee", 0);

		for(Entry<String, String> set:map.entrySet())
		{
			String key= set.getKey();
			String value= set.getValue();
			
				driver.findElement(By.xpath(key)).sendKeys(value);
		}
		select(gender, genderList);
		
		select(job, jobList);
		
		select(province, provinceList);
		
		select(city, cityList);
		
		saveBtn.click();
		
	}
	
	
	
	
}
