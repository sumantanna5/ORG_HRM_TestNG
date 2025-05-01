package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	public static ExtentReports extent;

	public static ExtentReports extentReportGenerator() {
		String path = System.getProperty("user.dir") + "//reports//OHRM.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("ORANGE HRM WEB AUTOMATION RESULTS");
		reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("Tester", "Sumant");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Selenium Version", "3.141.59");
		extent.setSystemInfo("Maven Version", "3.6.3");
		extent.setSystemInfo("Java Version", "1.8.0_231");
		extent.setSystemInfo("Extent Version", "4.0.9");
		extent.setSystemInfo("Project Name", "OrangeHRM");
		extent.setSystemInfo("Project Version", "1.0");

		return extent;
	}

}
