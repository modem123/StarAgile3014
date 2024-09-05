package orangeHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	// Encapsulation=Private data +public function

	private WebDriver driver;
 
	// initialize
	public LoginPage(WebDriver driver) // From base class
	{
		this.driver = driver;
	}

	// Locators
	private By usern = By.xpath("//input[@placeholder=\"Username\"]");
	private By passw = By.name("password");
	private By btn = By.xpath("//button[@type='submit']");
	// Actions

	public void doLogin(String un, String pasw) {
		driver.findElement(usern).sendKeys(un);
		driver.findElement(passw).sendKeys(pasw);
		driver.findElement(btn).click();
	}

	public String verifyAppTitle() {
		return driver.getTitle();

	}

	public String verifyAppUrl() {
		return driver.getCurrentUrl();

	}

}
