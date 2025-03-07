package TestComponets;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ORGResue.DataRetrive;
import OrgScreens.AdminMenuJob;
import OrgScreens.AdminTab;
import OrgScreens.Login;
import OrgScreens.OrgTabs;


public class BaseTest {

	public static WebDriver driver;
	public AdminTab at;
	public Login log;
	public OrgTabs ot;
	public AdminMenuJob amj;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeSuite
	public void initializedriver() throws IOException {

		if (DataRetrive.getDataGlobal("Browser").equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (DataRetrive.getDataGlobal("Browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	@BeforeClass
	public void createObject() {
		at = new AdminTab(driver);
		log = new Login(driver);
		ot = new OrgTabs(driver);
		amj = new AdminMenuJob(driver);

	}

	@BeforeTest
	public void launchApplication() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("HIT URL :" + url);
	}

	@AfterSuite
	public void closebroswer() {
		driver.quit();

	}

	public static WebDriver getdriver() {
		return driver;
	}

}
