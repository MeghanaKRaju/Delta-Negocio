package supplier;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

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

public class SupplierTest_HC {

	@Test
	
	public void addSupplierTest() throws IOException, InterruptedException
	{

		
		Fileutils fLib= new Fileutils();
		ExcelUtils eLib= new ExcelUtils();
		DatabaseUtils dLib= new DatabaseUtils();
		JavaUtils jLib = new JavaUtils();
		WebdriverUtils wLib= new WebdriverUtils();
		
		
		
		int random = jLib.getRandom(999);

		//get common data from property file
		String url = fLib.readData("url");
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");


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
		
		//click on supplier tab
		driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		//adding supplier
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();


		//get Testdata from Excel file
//		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet("Supplier");
//		int rowcount = sh.getLastRowNum();
		
		HashMap<String, String> map = eLib.hashMapData("Supplier",0);


		//driver.findElement(By.name("companyname")).sendKeys("Hardware Export1");

		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("phonenumber"))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			else {

				driver.findElement(By.name("companyname")).sendKeys(set.getValue()+random);
			}
		}


		WebElement provinceList = driver.findElement(By.name("province"));
		wLib.select("Sulu", provinceList);

		
		WebElement cityList = driver.findElement(By.id("city"));
		wLib.select("Omar", cityList);

		//the next text field of ph no will get executed from else block  to take respective key and values
		//driver.findElement(By.name("phonenumber")).sendKeys("9876543211");

		driver.findElement(By.xpath("//h5[text()='Add Supplier']/../..//button[text()='Save']")).click();

		System.out.println("----Supplier is created----");

	}

}
