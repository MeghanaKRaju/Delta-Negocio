package pos;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtils.DatabaseUtils;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;

public class UserPosTest_HC {
	@Test
	public void userPosDisplayTest() throws IOException
	{
		
		Fileutils fLib= new Fileutils();
		ExcelUtils eLib= new ExcelUtils();
		JavaUtils jLib= new JavaUtils();
		DatabaseUtils dLib= new DatabaseUtils();
		WebdriverUtils wLib= new WebdriverUtils();
		
		
		
		
		//get common data from property file
		String url = fLib.readData("url");
		String adminUsername = fLib.readData("username2");
		String adminPassword = fLib.readData("password2");
		

		//launch browser
		WebDriver driver= new ChromeDriver();

		//maximize browser
		wLib.maximizeWindow(driver);

		//enter URL
		driver.get(url);

		//wait for page load
		wLib.waitForPageLoad(driver, 10);

		//login to application
		driver.findElement(By.name("user")).sendKeys(adminUsername);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		driver.findElement(By.name("btnlogin")).click();

		//handling alert pop up
		wLib.alertAccept(driver);
		
		
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		if(actualUrl.contains("pos"))
		{
			System.out.println("--pos page is displayed--");
		}
		
		else {
			System.out.println("--pos page is not displayed--");
		}
		
		


	}

}
