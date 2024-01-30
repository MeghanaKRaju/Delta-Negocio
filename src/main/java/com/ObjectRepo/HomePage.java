package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtils.WebdriverUtils;

public class HomePage {

	//Declaration
	@FindBy(xpath="//i[@class='fas fa-laugh-wink']")
	private WebElement logo;

	@FindBy(xpath="//div[text()='Sales and Inventory System']")
	private WebElement appName;

	@FindBy(xpath="//span[text()='POS']")
	private WebElement pos;

	@FindBy(id="userDropdown")
	private WebElement ProfileDropdown;

	@FindBy(xpath="//span[text()='Home']")
	private WebElement home;

	@FindBy(xpath="//span[text()='Customer']")
	private WebElement customer;

	@FindBy(xpath="//span[text()='Employee']")
	private WebElement employee;

	@FindBy(xpath="//span[text()='Product']")
	private WebElement product;

	@FindBy(xpath="//span[text()='Inventory']")
	private WebElement inventory;

	@FindBy(xpath="//span[text()='Transaction']")
	private WebElement transaction;

	@FindBy (xpath="//span[text()='Supplier']")
	private WebElement supplier;

	@FindBy(xpath="//span[text()='Accounts']")
	private WebElement accounts;

	@FindBy(id="sidebarToggle")
	private WebElement sideToggleBtn;
	
	@FindBy(xpath="//div[text()='Customers']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement customersRecords;

	@FindBy(xpath="//div[text()='Employees']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement employeesRecords;

	@FindBy(xpath="//div[text()='Product']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement productRecords;

	@FindBy(xpath="//div[text()='Supplier']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement supplierRecords;

	@FindBy(xpath="//div[text()='Registered Account']/../..//div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement registeredAccountRecords;

	@FindBy(xpath="//div[contains(text(),' Recent Products')]")
	private WebElement recentProducts;

	@FindBy(xpath="//a[text()='View All Products']")
	private WebElement viewAllProducts;

	@FindBy(xpath="//div[@aria-labelledby='userDropdown']/button")
	private WebElement profile;

	@FindBy(xpath="//i[@class='fas fa-cogs fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement settings;

	@FindBy(xpath="//a[@data-target='#logoutModal']")
	private WebElement logout;
	
	@FindBy(xpath="//h5[text()='Ready to Leave?']/../..//a[text()='Logout']")
	private WebElement logout2;
	
	

	//initialisation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}

	
	public WebElement getAppName() {
		return appName;
	}

		public WebElement getPos() {
		return pos;
	}

	public WebElement getAdminProfileDropdown() {
		return ProfileDropdown;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getCustomer() {
		return customer;
	}

	public WebElement getEmployee() {
		return employee;
	}

	public WebElement productTab() {
		return product;
	}

	public WebElement inventoryTab() {
		return inventory;
	}

	public WebElement transactionTab() {
		return transaction;
	}

	public WebElement getSupplier() {
		return supplier;
	}

	public WebElement accountsTab() {
		return accounts;
	}

	public WebElement sideToggleBtn() {
		return sideToggleBtn;
	}

	public WebElement getCustomersRecords() {
		return customersRecords;
	}

	public WebElement getEmployeesRecords() {
		return employeesRecords;
	}

	public WebElement getProductRecords() {
		return productRecords;
	}

	public WebElement getSupplierRecords() {
		return supplierRecords;
	}

	public WebElement getRegisteredAccountRecords() {
		return registeredAccountRecords;
	}

	public WebElement getRecentProducts() {
		return recentProducts;
	}

	public WebElement getViewAllProducts() {
		return viewAllProducts;
	}


	public WebElement getProfile() {
		return profile;
	}

	
	public WebElement getLogout() {
		return logout;
	}
	
	public WebElement getSideToggleBtn() {
		return sideToggleBtn;
	}
	
	public WebElement getLogout2() {
		return logout2;
	}
	
	public void logout(WebDriver driver)
	{
		ProfileDropdown.click();
		logout.click();
		logout2.click();
	}
	

}
