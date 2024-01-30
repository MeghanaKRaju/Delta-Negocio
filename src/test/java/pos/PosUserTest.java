package pos;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;
import com.GenericUtils.Fileutils;
import com.GenericUtils.WebdriverUtils;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.PosPage;

@Listeners(com.GenericUtils.ListImplClass.class)
public class PosUserTest extends BaseClass {
	
	@Test
	
	public void loginAdmin() throws Throwable
	{
		
		
		LoginPage lp=new LoginPage(driver);
		String adminUsername = fLib.readData("username2");
		String adminPassword = fLib.readData("password2");
		lp.loginToApp(driver,adminUsername, adminPassword);
	
		System.out.println("--login--");
		
		
		
		
		System.out.println("--POS page is displayed--");
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		
		
//		if(actualUrl.contains("pos"))
//		{
//			System.out.println("--pos page is displayed--");
//			System.out.println("--logout--");
//		}
//		
//		else {
//			System.out.println("--pos page is not displayed--");
//			
//		}
		
		String exptedtedUrl = "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/pos.php";
		
		Assert.assertEquals(actualUrl, exptedtedUrl, "Expected condition is not matching");
		
		HomePage hp= new HomePage(driver);
		hp.logout(driver);
		
		
		System.out.println("--logout--");
		
		
	}

}
