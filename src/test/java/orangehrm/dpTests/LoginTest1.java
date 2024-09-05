package orangehrm.dpTests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NewITestListener.class)
class LoginTest1 {
	// 3. Prepare script for Login and logout..........

	public static WebDriver driver;
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(testName = "loginTest", dataProvider = "loginData", dataProviderClass = ExcelData.class)

	public void loginTest(String userName, String password) throws Exception {

		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		/*
		 * 4. Perform assertion for valid data set (use Username: Admin and
		 * Password:admin123) test case should be pass and invalid data set (other than
		 * given data) test case should be fail......
		 */

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Fail");
		System.out.println("Login Successfull");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout Succesfull");

	}

	@AfterTest
	public void teardown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	// 5. Capture Screenshot for every login functionality...........

	public void captureScreenshot(Object filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\screenshot\\" + filename);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}
		Reporter.log("ScreenShot successfully captured!", true);
	}

}
