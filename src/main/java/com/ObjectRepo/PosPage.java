package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.GenericUtils.WebdriverUtils;

public class PosPage {

	@FindBy(linkText = "Keyboard")
	private WebElement keyboardBtn;
	
	@FindBy(linkText = "Mouse")
	private WebElement mouseBtn;
	
	@FindBy(linkText = "Headset")
	private WebElement headsetBtn;	
	
	@FindBy(linkText = "CPU")
	private WebElement cpuBtn;
	
	@FindBy(linkText = "Monitor")
	private WebElement monitorBtn;
	
	@FindBy(linkText = "Motherboard")
	private WebElement motherboardBtn;
	
	@FindBy(linkText = "Processor")
	private WebElement processorBtn;
	
	@FindBy(linkText = "Power Supply")
	private WebElement powerSupplyBtn;
	
	@FindBy(linkText = "Others")
	private WebElement othersBtn;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitBtn;
	
	@FindBy(name="customer")
	private WebElement cutomerList;
	
	@FindBy(name="cash")
	private WebElement cashTxb;
	
	@FindBy(name="addpos")
	private WebElement addBtn;
	
	@FindBy(xpath="//button[text()='PROCEED TO PAYMENT']")
	private WebElement submitPaymentBtn;

	public WebElement getSubmitPaymentBtn() {
		return submitPaymentBtn;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getCashTxb() {
		return cashTxb;
	}

	public PosPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getKeyboardBtn() {
		return keyboardBtn;
	}

	public WebElement getMouseBtn() {
		return mouseBtn;
	}

	public WebElement getHeadsetBtn() {
		return headsetBtn;
	}

	public WebElement getCpuBtn() {
		return cpuBtn;
	}

	public WebElement getMonitorBtn() {
		return monitorBtn;
	}

	public WebElement getMotherboardBtn() {
		return motherboardBtn;
	}

	public WebElement getProcessorBtn() {
		return processorBtn;
	}

	public WebElement getPowerSupplyBtn() {
		return powerSupplyBtn;
	}

	public WebElement getOthersBtn() {
		return othersBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCutomerList() {
		return cutomerList;
	}
	
	
	//business logic
	public void pos(WebDriver driver,String pName,String quantity, String customer, double amount)
	{
		keyboardBtn.click();
		//WebElement pN = driver.findElement(By.xpath("//h6[text()='"+pName+"']"));
		driver.findElement(By.xpath("//h6[text()='"+pName+"']/..//input[@name='quantity']")).sendKeys(quantity);
		addBtn.click();
		
		WebdriverUtils wLib= new WebdriverUtils();
		wLib.select(customer, cutomerList);
		
		submitBtn.click();
		
		cashTxb.sendKeys(""+amount+"");
		submitPaymentBtn.click();
		
	}
	
	
}
