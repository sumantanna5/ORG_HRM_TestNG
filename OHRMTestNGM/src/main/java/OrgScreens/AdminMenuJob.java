package OrgScreens;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class AdminMenuJob {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest test;

	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Job ']")
	static WebElement ADMJobMenu;

	@FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title' and text()='System Users']")
	static WebElement SystemUserstext;

	@FindBys(@FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link']"))
	static WebElement AdminJobList;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	static WebElement JTAddButton;

	@FindBy(xpath = "//*[text()='Job Title']//parent::div//following-sibling::div/input[@class='oxd-input oxd-input--active']")
	static WebElement JTJobTitle;

	@FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' and @placeholder='Type description here']")
	static WebElement JTJobDescription;

	public AdminMenuJob(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void AdminJob(String JobName) {

		if (driver.getCurrentUrl().contains("/auth/login")) {
			Login log = new Login(driver);
			log.Login_user_passowrd(Login.username(), Login.Password());
			System.out.println("User Logged In Successfully");
			test.log(Status.INFO, "Login Succesfully");
		} else {
			System.out.println("User Already Logged In");
		}
		if (driver.getCurrentUrl().contains("/admin/viewSystemUsers")) {
			System.out.println("Already System Users is displayed");
			System.out.println("Already in Admin Tab");

		} else {
			OrgTabs ot = new OrgTabs(driver);
			try {
				OrgTabs.Menu("Admin");
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Succesfully Navigated to Admin Tab");

		}

		ADMJobMenu.click();

		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> AdminJobList = (List<WebElement>) driver
				.findElements(By.xpath("//a[@class='oxd-topbar-body-nav-tab-link']"));
		int i = 1;
		System.out.println("Admin Job List-------------------");

		// Print the Admin Job List
		for (WebElement list_names : AdminJobList) {

			System.out.println(i + "." + list_names.getText());
			i++;
		}

		// Click on Job Titles
		for (WebElement list_names : AdminJobList) {
			if (list_names.getText().equalsIgnoreCase(JobName)) {
				list_names.click();
				break;
			}
		}

		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (JobName.equalsIgnoreCase("Job Titles")) {
			JobTitles(JobName);
		} else if (JobName.equalsIgnoreCase("Pay Grades")) {
			PayGrades(JobName);
		} else if (JobName.equalsIgnoreCase("Employment Status")) {
			EmploymentStatus(JobName);
		} else if (JobName.equalsIgnoreCase("Job Categories")) {
			JobCategories(JobName);
		} else if (JobName.equalsIgnoreCase("Work Shifts")) {
			WorkShifts(JobName);
		} else {
			System.out.println("Invalid Job Name");
		}
	}

	private static void WorkShifts(String jobName) {
		// TODO Auto-generated method stub

	}

	private static void JobCategories(String jobName) {
		// TODO Auto-generated method stub

	}

	private static void EmploymentStatus(String jobName) {
		// TODO Auto-generated method stub

	}

	private static void PayGrades(String jobName) {
		// TODO Auto-generated method stub

	}

	public static void JobTitles(String jobName) {

		JTAddButton.click();
		System.out.println("Clicked on Add Button");
		JTJobTitle.sendKeys("QA Testing");
		System.out.println("Job Title Entered");
		JTJobDescription.sendKeys("QA Automation Testing Engineer with Selenium and Java");
		System.out.println("Job Description Entered");
	}
}
