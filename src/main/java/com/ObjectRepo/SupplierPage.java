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
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;

public class SupplierPage extends WebdriverUtils {
	
	@FindBy(xpath="//a[@data-target='#supplierModal']")
	private WebElement addSupplierBtn;

	@FindBy(id="province")
	private WebElement provinceList;

	@FindBy(id="city")
	private WebElement cityList;

	@FindBy(xpath="//h5[text()='Add Supplier']/../..//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath="//h5[text()='Add Supplier']/../..//button[@type='reset']")
	private WebElement resetBtn;

	@FindBy(xpath="//h5[text()='Add Supplier']/../..//button[text()='Cancel']")
	private WebElement cancelBtn;

	@FindBy(name="dataTable_length")
	private WebElement entriesDropdown;

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextbox;

	@FindBy(xpath="//a[text()='Previous']")
	private WebElement previousBtn;

	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextBtn;

	@FindBy(linkText = " Details")
	private WebElement detailsBtn;

	@FindBy(linkText = "...")
	private WebElement ellipsisBtn;

	//initialization
	public SupplierPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddSupplierBtn() {
		return addSupplierBtn;
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

	public WebElement getDetailsBtn() {
		return detailsBtn;
	}

	public WebElement getEllipsisBtn() {
		return ellipsisBtn;
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


	//business logic

	public void createSupplier( WebDriver driver, int random, String province, String city) throws EncryptedDocumentException, IOException
	{
		
		HomePage hp= new HomePage(driver);
		hp.getSupplier().click();
		
		addSupplierBtn.click();
		
		JavaUtils jLib= new JavaUtils();
		random=jLib.getRandom(2);
		
		ExcelUtils eLib= new ExcelUtils();
		
		HashMap<String, String> map = eLib.hashMapData("Supplier",0);


		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("phonenumber"))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			else {

				driver.findElement(By.name("companyname")).sendKeys(set.getValue()+random);
			}
		}

		select(province, provinceList);

		select(city, cityList);

		saveBtn.click();

	}









}
