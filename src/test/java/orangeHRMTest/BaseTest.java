package orangeHRMTest;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import orangeHRMPages.AdminPage;
import orangeHRMPages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage lp;
	public AdminPage ap;


	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		ap = new AdminPage(driver);
	}

	


	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

}