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

public class ProductPage {


	@FindBy(xpath="//a[@data-target='#aModal']")
	private WebElement addProductBtn;

	@FindBy(name="category")
	private WebElement categoryList;

	@FindBy(name="supplier")
	private WebElement supplierList;

	@FindBy(name="datestock")
	private WebElement dateTxtBox;
	
	@FindBy(xpath="//h5[text()='Add Product']/../..//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath="//h5[text()='Add Product']/../..//button[@type='reset']")
	private WebElement resetBtn;

	@FindBy(xpath="//h5[text()='Add Product']/../..//button[text()='Cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateBtn;

	@FindBy(xpath="//a[text()='Back']")
	private WebElement backBtn;

	
	@FindBy(name="dataTable_length")
	private WebElement entriesDropdown;

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextbox;

	@FindBy(xpath="//a[text()='Previous']")
	private WebElement previousBtn;

	@FindBy(xpath="//a[text()='Next']")
	private WebElement nextBtn;
	
	@FindBy(xpath="//textarea[@placeholder='Description']")
	private WebElement description;

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getCategoryList() {
		return categoryList;
	}

	public WebElement getSupplierList() {
		return supplierList;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getBackBtn() {
		return backBtn;
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
	
	public WebElement getDateTxtBox() {
		return dateTxtBox;
	}

	public WebElement getPreviousBtn() {
		return previousBtn;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getDescription() {
		return description;
	}
	
	//initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//check for dynamic element details
	public void createProduct(WebDriver driver,String prCat, String supplier, String ddmmyyyy) throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.productTab().click();
		addProductBtn.click();

		ExcelUtils eLib= new ExcelUtils();
		
		HashMap<String, String> hm = eLib.hashMapData("Product", 0);

		for(Entry<String, String> set:hm.entrySet())
		{

			String key = set.getKey();
			String value = set.getValue();
			
			JavaUtils jLib= new JavaUtils();
			int random = jLib.getRandom(20);

			if(key.contains("//h5[text()='Add Product']/../..//input[@name='prodcode']"))
			{
				driver.findElement(By.xpath(key)).sendKeys(value+random);
			}
			else
			{
				driver.findElement(By.xpath(key)).sendKeys(value);
			}
		}

		//listbox
		WebdriverUtils wLib= new WebdriverUtils();
		wLib.select(prCat, categoryList);

		wLib.select(supplier, supplierList);

		//dateTextbox
		dateTxtBox.sendKeys(ddmmyyyy);
		
		saveBtn.click();

	}


	public void editProductDetails(WebDriver driver,String pCode, String desc, String category )
	{
		HomePage hp=new HomePage(driver);
		hp.productTab().click();

		searchTextbox.sendKeys(pCode);

		//driver.findElement(By.xpath("//td[text()='"+pCode+"']/..//a[text()=' Details']"));

		WebElement ellipsisBtn = driver.findElement(By.xpath("//td[text()='"+pCode+"']/..//a[contains(text(),'... ')]"));
		ellipsisBtn.click();
		
		driver.findElement(By.xpath("//td[text()='"+pCode+"']/..//ul[@role='menu']")).click();
		
		description.sendKeys(desc);
		
		WebdriverUtils wLib= new WebdriverUtils();
		wLib.select(category, categoryList);

		updateBtn.click();
		
		String text = wLib.alertGet(driver);
		System.out.println(text);
		wLib.alertAccept(driver);

	}

	public void productDetails(WebDriver driver,String pCode, WebElement prodDetailsBtn )
	{
		HomePage hp=new HomePage(driver);
		hp.productTab().click();

		searchTextbox.sendKeys(pCode);
		prodDetailsBtn = driver.findElement(By.xpath("//td[text()='"+pCode+"']/..//a[text()=' Details']"));
		prodDetailsBtn.click();

	}

	public void productList(WebDriver driver)
	{
		HomePage hp=new HomePage(driver);
		hp.productTab().click();

	}


}
