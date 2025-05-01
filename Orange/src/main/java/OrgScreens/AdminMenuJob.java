package OrgScreens;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ORGResue.Resuse_Code;

public class AdminMenuJob {

	static WebDriver driver;
	String AddedCurrencyName;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	WebElement PageTitle;

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

	@FindBy(xpath = "//textarea[@placeholder='Add note']")
	static WebElement JTAddNote;

	@FindBy(xpath = "//button[text()=' Save ']")
	static WebElement JTSaveButton;

	/*
	 * Pay Grade Elements
	 */

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement PGAddButton;

	@FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//following-sibling::div/input")
	WebElement PGAddNewPayGrade;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement PGSavePayGrade;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement AddCurrency;

	@FindBy(xpath = "//label[text()='Minimum Salary']/parent::div/following-sibling::div/input")
	WebElement PGMiniSalary;

	@FindBy(xpath = "//label[text()='Maximum Salary']/parent::div/following-sibling::div/input")
	WebElement PGMaxSalary;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Add Currency']/following-sibling::form/div/following-sibling::div/following-sibling::div/button[@type='submit']")
	WebElement AddCurrencySave;

	/*
	 * Employment Status
	 */
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement ESAddButton;

	public AdminMenuJob(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AdminJob(String JobName) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.getCurrentUrl().contains("/auth/login")) {
			Login log = new Login(driver);
			log.Login_user_passowrd(Login.username(), Login.Password());
			System.out.println("User Logged In Successfully");
		} else {
			System.out.println("User Already Logged In");
		}
		if (driver.getCurrentUrl().contains("/admin/viewSystemUsers")) {
			System.out.println("Already System Users is displayed");
			System.out.println("Already in Admin Tab");

		} else {
			OrgTabs ot = new OrgTabs(driver);
			try {
				OrgTabs orgTabs = new OrgTabs(driver);
				orgTabs.Menu("Admin");
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
				System.out.println("Admin->Job->" + JobName + " (Clicked)");
				String TitleName = PageTitle.getText();
				assertEquals(JobName, TitleName);
				break;
			}
		}

		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void WorkShifts(String jobName) {
		// TODO Auto-generated method stub

	}

	private void JobCategories(String jobName) {
		// TODO Auto-generated method stub

	}

	public String JobTitles(String JobTitleName) {

		driver.navigate().refresh();
		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JTAddButton.click();
		System.out.println("Clicked on Add Button");
		JTJobTitle.sendKeys(JobTitleName);
		System.out.println("Job Title Entered");
		JTJobDescription.sendKeys("QA Automation Testing Engineer with Selenium and Java");
		System.out.println("Job Description Entered");
		JTAddNote.sendKeys("QA Automation Testing Engineer with Selenium and Java");
		System.out.println("Quality Assurance Testing Engineer with Selenium and Java");
		JTSaveButton.click();
		return JobTitleName;
	}

	public void DeleteJobTitles(String TitleName) {
		List<WebElement> jttitles = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"));

		for (int i = 0; i < jttitles.size(); i++) {

			if (jttitles.get(i).getText().contains(TitleName)) {
				System.out.println(jttitles.get(i).getText());
				--i;
				jttitles.get(i).click();
				break;

			}

		}

		WebElement element = driver.findElement(By.xpath("//div[text()='" + TitleName
				+ "']/parent::div/following-sibling::div/following-sibling::div/div/button/i[@class='oxd-icon bi-trash']"));
		element.click();
		driver.findElement(By.xpath("//*[text()=' Yes, Delete ']")).click();

		System.out.println("Job Title Deleted");

	}

	public void PayGrades(String GradeName) {

		DeletePayGrade(GradeName);
		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PGAddButton.click();
		System.out.println("New Pay Grade Add Button Clicked");

		String TitleName = "//*[@class='oxd-text oxd-text--h6 orangehrm-main-title']";
		WebElement PGMainTitle = driver.findElement(By.xpath(TitleName));
		Resuse_Code.WaitForElementToAppear(By.xpath(TitleName));
		Assert.assertEquals(PGMainTitle.getText(), "Add Pay Grade");
		PGAddNewPayGrade.sendKeys(GradeName);
		PGSavePayGrade.click();
		System.out.println("Pay Grade " + GradeName + " Added");

	}

	public void PayGradeCurrecy(String CurrencyName, int MinimumSalary, int MaximumSalary) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String CurrencyTitleNme = "//*[text()='Currencies']";
		Resuse_Code.WaitForElementToAppear(By.xpath(CurrencyTitleNme));
		Assert.assertEquals(driver.findElement(By.xpath(CurrencyTitleNme)).getText(), "Currencies");
//		String CurrencyNoRecordsFound = "//*[text()='No Records Found']";
//		Resuse_Code.WaitForElementToAppear(By.xpath(CurrencyNoRecordsFound));
//		Assert.assertEquals(driver.findElement(By.xpath(CurrencyNoRecordsFound)).getText(), "No Records Found");

		AddCurrency.click();
		System.out.println("Adding New Currency");
		String AddCurrencyTitleNme = "//*[text()='Add Currency']";
		Resuse_Code.WaitForElementToAppear(By.xpath(AddCurrencyTitleNme));
		Assert.assertEquals(driver.findElement(By.xpath(AddCurrencyTitleNme)).getText(), "Add Currency");

		Actions act = new Actions(driver);

		String CurrencySelect = "//div[@class='oxd-select-text-input']";
		Resuse_Code.WaitForElementToAppear(By.xpath(CurrencySelect));
		driver.findElement(By.xpath(CurrencySelect)).click(); // Clicking on Select Currency DropDown

		Resuse_Code.WaitForElementToAppear(By.xpath("//div[@role='listbox']/div"));
		List<WebElement> CurrencyList = driver.findElements(By.xpath("//div[@role='listbox']/div"));
		int count = 1;
		System.out.println("Currency List ---------------- ");

		for (WebElement CountryCurrency : CurrencyList) {
			System.err.println(count + ". " + CountryCurrency.getText());
			count++;
		}
		System.out.println("------------------------------ ");

		for (int i = 0; i < CurrencyList.size(); i++) {
			if (CurrencyList.get(i).getText().contains(CurrencyName)) {
				System.out.println(CurrencyList.get(i).getText() + " Selected");
				act.sendKeys(Keys.ENTER).build().perform();
				break;
			} else {
				act.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

		}

		PGMiniSalary.sendKeys(String.valueOf(MinimumSalary));
		System.out.println("Minimum Salary Entered :" + MinimumSalary);

		PGMaxSalary.sendKeys(String.valueOf(MaximumSalary));
		System.out.println("Maximum Salary Entered :" + MaximumSalary);

		AddCurrencySave.click();
		System.out.println("Currency Added Successfully ->" + CurrencyName);

		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		List<WebElement> CurrencyAddedList = driver
//				.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"));
//
//		for (WebElement CurrencyAdded : CurrencyAddedList) {
//			if (CurrencyAdded.getText().contains(AddedCurrencyName)) {
//				System.out.println("Currency Added Successfully");
//				break;
//			}
//		}
	}

	public void DeletePayGrade(String DeletePayGradeName) {
		List<WebElement> PGList = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"));

		for (int i = 0; i < PGList.size(); i++) {
			if (PGList.get(i).getText().equalsIgnoreCase(DeletePayGradeName)) {
				System.out.println("Pay Grade Name: " + PGList.get(i).getText());
				--i;
				PGList.get(i).click();
				WebElement element = driver.findElement(By.xpath("//div[text()='" + DeletePayGradeName
						+ "']/parent::div/following-sibling::div/following-sibling::div/div/button/i[@class='oxd-icon bi-trash']"));
				element.click();
				driver.findElement(By.xpath("//*[text()=' Yes, Delete ']")).click();

				System.out.println("Pay Grade ----->>>>>" + DeletePayGradeName + " Deleted");
				break;
			}
		}

		System.err.println(DeletePayGradeName + " Not In List");

	}
	
	public void EmploymentStatus(String jobName) {
		ESAddButton.click();
		System.out.println("Clicked on Add Button (Emplyment Status)");
		}
}
