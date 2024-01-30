package employee;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;
import com.ObjectRepo.EmployeePage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

public class CreateEmployeeTest extends BaseClass {

	@Test

	public void addEmployee() throws EncryptedDocumentException, IOException, InterruptedException
	{

		int random = jLib.getRandom(999);
		//long phRandom = ran.nextLong(999999999);

		
		//login to application
		LoginPage lp= new LoginPage(driver);
		
		String adminUsername = fLib.readData("username1");
		String adminPassword = fLib.readData("password1");
		lp.loginToApp(driver,adminUsername, adminPassword);

		System.out.println("--login--");
		
		//create employee
		EmployeePage ep= new EmployeePage(driver);
		ep.createEmployee(driver, "12022022","Male", "Cashier", "Abra", "Bucay");
		System.out.println("--Employee created--");
		
		HomePage hp= new HomePage(driver);
		hp.logout(driver);
		System.out.println("--logout--");
		
		
	}
}
