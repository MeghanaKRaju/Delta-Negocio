package com.annotations;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtils.WebdriverUtils;

public class IRCTC {

	@Test

	public void book() throws InterruptedException
	{

		WebdriverUtils wLib= new WebdriverUtils();
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");

		WebDriver driver= new ChromeDriver(option);
		wLib.maximizeWindow(driver);
		driver.get("https://www.irctc.co.in/nget/train-search");
		wLib.waitForPageLoad(driver, 60);
		driver.findElement(By.xpath("//a[contains(text(),'BUSES')]")).click();
		Thread.sleep(3000);
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh)
		{
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			System.out.println(title);

			if(title.equalsIgnoreCase("IRCTC Bus - Online Bus Ticket Booking | Bus Reservation"))
			{
				driver.findElement(By.id("departFrom")).sendKeys("Bangalore");


				Thread.sleep(3000);

				WebElement departEle = driver.findElement(By.xpath("//div[text()='Bangalore']"));

				//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				//			wait.until(ExpectedConditions.visibilityOf(departEle));

				departEle.click();

				driver.findElement(By.id("goingTo")).sendKeys("Delhi");

				Thread.sleep(3000);

				driver.findElement(By.xpath("//div[text()='Delhi']")).click();

				driver.findElement(By.id("departDate")).click();

				int	date=26;
				driver.findElement(By.xpath("//a[text()='"+date+"']")).click();

				driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();

				Thread.sleep(5000);

				//click on departure tiome-after 6pm
				driver.findElement(By.xpath("//h4[text()='Departure Time']/..//label[text()='After 6 pm']")).click();

				//select a travels and click on select seat
				String travels = "Kanak Travels";
				driver.findElement(By.xpath("//label[contains(text(),'"+travels+"')]/../..//"
						+ "button[text()='Select Seat']")).click();

				Thread.sleep(3000);

				//clicking on required seat

				String deck="Upper Deck";
				String seatNo = "S4";
				driver.findElement(By.xpath("//h5[text()='"+deck+"']/.."
						+ "//span[contains(@title,'Seat No. : "+seatNo+"')]")).click();

				//click on boarding time radio button based on address
				//				driver.findElement(By.xpath("//th[text()='Boarding Time']/../../.."
				//						+ "//td[text()=' Anand Rao Circle ']/..//input[@name='bordTime']")).click();


				//click on boarding time radio button based on time
				String time="18:10";
				driver.findElement(By.xpath("//th[text()='Boarding Time']/../../.."
						+ "//td[text()='"+time+"']/..//input[@name='bordTime']")).click();


				driver.findElement(By.xpath("//button[text()='Proceed to Book']")).click();

				//click on guest user login button
				driver.findElement(By.id("profile-tab")).click();

				//enter email id
				driver.findElement(By.id("emailLogin")).sendKeys("meghanakraju95@gmail.com");

				//enter mobile number
				driver.findElement(By.id("phoneLogin")).sendKeys("9876543210");

				//login button-click
				driver.findElement(By.xpath("//div[@id='profile']//button[text()='Login']")).click();

				Thread.sleep(5000);

				//entering text field details
				driver.findElement(By.name("mobileno")).sendKeys("9876543210");
				
				driver.findElement(By.name("address")).sendKeys("NS Iyengar street");

				WebElement countryList = driver.findElement(By.name("country"));
				wLib.select("India", countryList);

				WebElement stateList = driver.findElement(By.name("state"));
				wLib.select("KARNATAKA", stateList);

				driver.findElement(By.name("pincode")).sendKeys("560020");

				driver.findElement(By.xpath("//input[@placeholder='Traveller Name']")).sendKeys("Meghana");
				driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("29");
				
				WebElement genderList = driver.findElement(By.name("select"));
				wLib.select("Female", genderList);

				driver.findElement(By.id("agree")).click();

				driver.findElement(By.xpath("//button[text()='Continue to Book ']")).click();



			}

		}


	}

}
