package productlistpage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.WebdriverUtils;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.ProductPage;

public class ProductListPageTest extends BaseClass {
	@Test ()

	public void productPage() throws IOException
	{
		//admin login
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(driver,adminUsername, adminPassword);
		System.out.println("--logged in--");

		ProductPage pp= new ProductPage(driver);
		pp.productList(driver);

		String expectedUrl = "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/product.php";
		String actualUrl = driver.getCurrentUrl();

		//		if(actualUrl.contains("product"))
		//		{
		//			System.out.println("Product list page is displayed");
		//			System.out.println("--logout--");
		//		}
		//	
		//		else
		//		{
		//			System.out.println("Product list page is not displayed");
		//
		//		}

		Assert.assertEquals(actualUrl, expectedUrl, "Expected condition is not matching");

		System.out.println("Product list page is displayed");
		
		HomePage hp= new HomePage(driver);
		hp.getLogout().click();
		
		System.out.println("--logout--");
	}

}
