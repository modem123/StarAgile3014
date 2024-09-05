package orangeHRMTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {

	@BeforeClass
	public void pageSetup() {
		System.out.println("Login Test");
		lp.doLogin("Admin", "admin123");

	}

	@Test(priority = 1)
	public void getAllMenu() {
		ap.getMenu();
	}

	@Test(priority = 2)
	public void VerifySearchWithUsername() {
		ap.searchEmpByUsername("Admin");
	}

	@Test(priority = 3)
	public void VerifySerchWithUserRole() {
		ap.searchEmpByUserRole("Admin");
	}

	@Test(priority = 4)
	public void VerifySerchWithUserStatus() {
		ap.searchEmpByStatus("Enabled");
	}

}
