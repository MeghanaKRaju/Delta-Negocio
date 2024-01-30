package employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.GenericUtils.DatabaseUtils;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;

public class EmployeeTest_HC {

	@Test

	public void addEmployee() throws EncryptedDocumentException, IOException, InterruptedException
	{

		Fileutils fLib= new Fileutils();
		ExcelUtils eLib= new ExcelUtils();
		DatabaseUtils dLib= new DatabaseUtils();
		JavaUtils jLib= new JavaUtils();
		WebdriverUtils wLib= new WebdriverUtils();

		String url = fLib.readData("url");
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");


		int random = jLib.getRandom(999);
		//long phRandom = ran.nextLong(999999999);

		//launch browser
		WebDriver driver= new ChromeDriver();

		//maximize browser
		wLib.maximizeWindow(driver);

		//enter URL
		driver.get(url);

		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		//login to application
		driver.findElement(By.name("user")).sendKeys(adminUsername);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		driver.findElement(By.name("btnlogin")).click();

		//handling alert pop up
		driver.switchTo().alert().accept();


		//click on employee tab
		driver.findElement(By.xpath("//span[text()='Employee']")).click();

		//adding employee
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

		//gender list box
		WebElement genderList = driver.findElement(By.name("gender"));
		wLib.select("Male", genderList);

		//job list box
		WebElement jobList = driver.findElement(By.name("jobs"));
		//	Select s1= new Select(jobList);
		//	s1.selectByVisibleText("Manager");
		wLib.select("Manager", jobList);

		//province list box
		WebElement provinceList = driver.findElement(By.name("province"));
		//	Select s2= new Select(provinceList);
		//	s2.selectByVisibleText("Abra");
		wLib.select("Abra", provinceList);

		//city List Box
		WebElement cityList = driver.findElement(By.id("city"));
		//	Select s3= new Select(cityList);
		//	s3.selectByVisibleText("Bucay");
		wLib.select("Bucay", cityList);

		//Hired date
		driver.findElement(By.id("FromDate")).click();
		driver.switchTo().activeElement().sendKeys("02122023");


		//get Testdata from Excel file
		//driver.findElement(By.name("firstname")).sendKeys("Anurag");
		HashMap<String, String> map = eLib.hashMapData("Employee", 0);

		for(Entry<String, String> set:map.entrySet())
		{
			//			
			String key= set.getKey();
			String value= set.getValue();
			driver.findElement(By.xpath(key)).sendKeys(value);

			//if(set.getKey().contains("//h5[text()='Add Employee']/../..//input[@placeholder='Last Name']"))
			//			{
			//				//here we are creating random for last name
			//				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+random);
			//
			//				//to create random number for phone, in excel, enter 1 digits
			//				//and using random it'll generate 9digits after 1st digit
			//				//then we can use if(last name), else if(ph), else(rest to remaining)
			//			}
			//			else
			//			{
			//				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			//			}
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[text()='Add Employee']/../..//button[@type='submit']")).click();
;
		System.out.println("---Employee generated---");

	}

}
