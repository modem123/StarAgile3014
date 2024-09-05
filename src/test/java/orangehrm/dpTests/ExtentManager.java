package orangehrm.dpTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
//6. Generate Extent Report for the same..........
	
	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {
			extent = createInstance();
			return extent;
		} else {
			return extent;
		}

	}

	public static ExtentReports createInstance() {

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Report/OHRMAutomation.html");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("TEstReport");
		sparkReporter.config().setDocumentTitle("Sprint Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer name", "Dell");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Modem Mounika");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser Name", "Chrome");

		return extent;
	}

}
