package orangeHRMTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	@Test(priority = 1)
	public void verifyTitle() {
		String title = lp.verifyAppTitle();
		Assert.assertTrue(title.contains("HRM"));
		Reporter.log("Title matched!", true);
	}

	@Test(priority = 2)
	public void verifyLogin() {

		lp.doLogin("Admin","admin123");

	}

	@Test(priority = 3)
	public void verifyUrl() {
		Reporter.log("Title is: " + lp.verifyAppUrl(), true);

	}
}
