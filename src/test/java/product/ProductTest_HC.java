package product;

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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtils.DatabaseUtils;
import com.GenericUtils.ExcelUtils;
import com.GenericUtils.Fileutils;
import com.GenericUtils.IPathConstants;
import com.GenericUtils.JavaUtils;
import com.GenericUtils.WebdriverUtils;

public class ProductTest_HC {

	@Test
	public void updateProductTest() throws IOException, InterruptedException
	{
		Fileutils fLib = new Fileutils();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		DatabaseUtils dLIb = new DatabaseUtils();
		WebdriverUtils wLib= new WebdriverUtils();

		//generating random number
		int random = jLib.getRandom(3);	
		String search=null;

		//get common data from property file

		String URL = fLib.readData("url");
		String adminUsername= fLib.readData("username1");
		String adminPassword= fLib.readData("password1");
		//		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//		Properties p= new Properties();
		//		p.load(fis);
		//		String BROWSER = p.getProperty("browser");
		//		String URL = p.getProperty("url");
		//		String USERNAME = p.getProperty("username");
		//		String PASSWORD = p.getProperty("password");


		//launch browser
		WebDriver driver= new ChromeDriver();

		//maximize browser
		wLib.maximizeWindow(driver);

		//enter URL
		driver.get(URL);

		//wait for page load
		wLib.waitForPageLoad(driver, 10);

		//login to application
		driver.findElement(By.name("user")).sendKeys(adminUsername);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		driver.findElement(By.name("btnlogin")).click();

		//handling alert pop up
		//WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
		//Alert a = wait1.until(ExpectedConditions.alertIsPresent());
		//driver.switchTo().alert().accept();

		wLib.waituntilalertIsPresent(driver, 20);
		wLib.alertAccept(driver);


		//click on product major tab
		driver.findElement(By.xpath("//span[text()='Product']")).click();

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement w = driver.findElement(By.xpath("//h4[text()='Product ']"));
		//	wait.until(ExpectedConditions.textToBePresentInElement(w, "Product"));
		wLib.waituntilTextPresent(driver, 10, w, "Product");

		System.out.println("--producttext in webelement is displayed--");

		//click on create product
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();


		//get Testdata from Excel file
		//		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//		Workbook wb = WorkbookFactory.create(fi);
		//		Sheet sh = wb.getSheet("Product");
		//		int rowcount = sh.getLastRowNum();


		//HashMap<String, String> map= new HashMap<String, String>();


		//		for(int i=0;i<=rowcount; i++)
		//		{
		//			String key = sh.getRow(i).getCell(0).getStringCellValue();
		//			String value = sh.getRow(i).getCell(1).getStringCellValue();
		//			map.put(key, value);
		//
		//		}

		HashMap<String, String> map = eLib.hashMapData("product", 0);

		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains("//h5[text()='Add Product']/../..//input[@name='prodcode']"))
			{


				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+random);
				search="prodcode"+random;
				System.out.println("R"+random);

			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}

		//product category list
		WebElement prodCategoryList = driver.findElement(By.name("category"));
		//		Select s= new Select(prodCategoryList);
		//		s.selectByVisibleText("Keyboard");

		//supplier list box
		WebElement supplierList = driver.findElement(By.name("supplier"));
		//		Select s1= new Select(supplierList);
		//		s1.selectByVisibleText("Hardware Exports");

		wLib.select("Hardware Exports", supplierList);



		//click on date on stock 
		driver.findElement(By.name("datestock")).click();

		//enter the date of stock value
		driver.switchTo().activeElement().sendKeys("20022023");
		Thread.sleep(3000);

		WebElement saveButton = driver.findElement(By.xpath("//h5[text()='Add Product']/../../..//button[text()='Save']"));
		wLib.scrollToElement(driver, saveButton);
		//click on save

		saveButton.click();
		System.out.println("--product is added--");

		Thread.sleep(5000);
		//type in search box
		WebElement searchBox = driver.findElement(By.xpath("//label[contains(text(),'Search')]/..//input[@type='search']"));
		searchBox.sendKeys(search);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("dell");
		wLib.waituntilTextPresent(driver, 10, searchBox, "search");

		//click on ellipsis
		driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\" and @style=\"color:white;\"]")).click();

		//click on edit button
		driver.findElement(By.linkText("Edit")).click();

		WebElement editProductText = driver.findElement(By.xpath("//h4[text()='Edit Product']"));
		//WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait1.until(ExpectedConditions.);
		wLib.waituntilTextPresent(driver, 10, editProductText, "Edit Product");

		//clear description
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).clear();

		//edit the description
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys("Silver colour");


		//handling product category list box
		WebElement categoryList = driver.findElement(By.name("category"));
		//Select s2= new Select(categoryList);
		//s2.selectByVisibleText("Keyboard");
		wLib.select("keyboard", categoryList);

		driver.findElement(By.xpath("//button[text()='Update']")).click();

		//String text = driver.switchTo().alert().getText();
		String text = wLib.alertGet(driver);
		System.out.println(text);
		//handling alert pop up
		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.alertIsPresent());
		wLib.waituntilalertIsPresent(driver, 10);

		//driver.switchTo().alert().accept();
		String updateText = wLib.alertGet(driver);
		System.out.println(updateText);
		wLib.alertAccept(driver);

		System.out.println("---product is updated--");



	}


}
