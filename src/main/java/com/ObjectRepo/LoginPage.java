package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtils.WebdriverUtils;

public class LoginPage {

	//Declaration
	@FindBy(name="user")
	private WebElement AdminUsername;
	
	@FindBy (name="password")
	private WebElement AdminPassword;
	
	@FindBy (name="btnlogin")
	private WebElement loginBtn;
	
	//initialisation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAdminUsername()
	{
		return AdminUsername;
	}
	
	public WebElement getAdminPassword()
	{
		return AdminPassword;
	}
	
	public WebElement getloginBtn()
	{
		return loginBtn;
	}
	
	//business logic
	public void loginToApp(WebDriver driver,String adminUsername, String adminPassword){
		
		AdminUsername.sendKeys(adminUsername);
		AdminPassword.sendKeys(adminPassword);
		loginBtn.click();
		WebdriverUtils wLib= new WebdriverUtils();
		wLib.alertAccept(driver);
		
		
	}
	
	
	
	
	
}
