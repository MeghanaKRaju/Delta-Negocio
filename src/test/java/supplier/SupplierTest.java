package supplier;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtils.DatabaseUtils;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.SupplierPage;

public class SupplierTest {
	
	@Test
	public void addSuppliers() throws IOException
	{
		Fileutils fLib= new Fileutils();
		ExcelUtils eLib= new ExcelUtils();
		DatabaseUtils dLib= new DatabaseUtils();
		JavaUtils jLib= new JavaUtils();
		WebdriverUtils wLib= new WebdriverUtils();
	
		
		
		WebDriver driver= new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		
		String url = fLib.readData("url");
		driver.get(url);
		
		//wait for page load
		wLib.waitForPageLoad(driver, 10);
		
		LoginPage lp= new LoginPage(driver);
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");
	
		lp.loginToApp(driver, adminUsername, adminPassword);
		
		wLib.alertAccept(driver);
		
		SupplierPage sp= new SupplierPage(driver);
		sp.createSupplier(driver, 10, "Abra", "Bucay");
		
		
		
	}

}
