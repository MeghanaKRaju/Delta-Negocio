package productlistpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtils.DatabaseUtils;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;
import com.ObjectRepo.HomePage;

public class ProductListPageTest_HC {

	@Test


	public void productListPageTest() throws IOException
	{

		Fileutils fLib= new Fileutils();
		ExcelUtils eLib= new ExcelUtils();
		DatabaseUtils dLib= new DatabaseUtils();
		JavaUtils jLib= new JavaUtils();
		WebdriverUtils wLib= new WebdriverUtils();
		// get common data from property file

		String url = fLib.readData("url");
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");

		//launch the browser
		ChromeDriver driver= new ChromeDriver();
		
		// maximize the browser
		wLib.maximizeWindow(driver);

		//enter url
		driver.get(url);

		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		//login to appl
		driver.findElement(By.name("user")).sendKeys(adminUsername);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		driver.findElement(By.name("btnlogin")).click();

		//handle alert pop up
		wLib.alertAccept(driver);

		//click on product major tab
		driver.findElement(By.xpath("//span[text()='Product']")).click();

		String prodUrl = driver.getCurrentUrl();
		System.out.println(prodUrl);

		if(prodUrl.contains("product"))
		{
			System.out.println("--product list page is displayed--");
		}

		else {
			System.out.println("--product list page is not displayed--");
		}
		
		HomePage hp= new HomePage(driver);
		hp.logout(driver);
		System.out.println("--logout--");

	}

}
