package supplier;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtils.BaseClass;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.SupplierPage;

public class SupplierFinalTest extends BaseClass {

	@Test

	public void supplierAddition() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String adminUsername= fLib.readData("username1");
		String adminPassword= fLib.readData("password1");
		lp.loginToApp(driver, adminUsername, adminPassword);
		
		System.out.println("-- logged in--");
		
		SupplierPage sp= new SupplierPage(driver);
		sp.createSupplier(driver, 10, "Abra", "Bucay");
		
		System.out.println("-- supplier is creted--");
		
		HomePage hp= new HomePage(driver);
		hp.logout(driver);
		System.out.println("--logout--");
		
		

	}
}
