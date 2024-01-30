package product;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.ProductPage;

public class ProductTest extends BaseClass {

	@Test
	
	public void editProduct() throws IOException
	{
		Fileutils fLib= new Fileutils();
		ExcelUtils eLib= new ExcelUtils();
		JavaUtils jLib= new JavaUtils();
		WebdriverUtils wLib= new WebdriverUtils();
		WebDriver driver= new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		
		String url = fLib.readData("url");
		driver.get(url);
		
		wLib.waitForPageLoad(driver, 20);
		
		LoginPage lp= new LoginPage(driver);
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");
		lp.loginToApp(driver,adminUsername, adminPassword);
		System.out.println("--login--");
		
		ProductPage pp= new ProductPage(driver);
		//pp.createProduct(driver, eLib, jLib, "Keyboard", "Hardware exports", "12022023");
		pp.editProductDetails(driver, "1", "1000 mAh", "Power Supply");
		
		System.out.println("-- Product is updated--");
		
		HomePage hp= new HomePage(driver);
		hp.logout(driver);
	
		System.out.println("--logout--");
		
	}
	
}
