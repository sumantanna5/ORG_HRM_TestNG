package OrgScreens;

import java.io.IOException;
import java.time.Duration;

import javax.imageio.IIOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminTab {
	static WebDriver driver;

	@FindBy(xpath = "//button[@type='button']//following-sibling::i")
	WebElement AdminAddUserButton;

	@FindBy(xpath = "//*[text()='Add User']")
	WebElement AddUserHearderText;

	@FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required' and text()='User Role']//parent::div//following-sibling::div/div[@class='oxd-select-wrapper']")
	static WebElement UserRoleDrop;

	@FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required' and text()='Status']//parent::div//following-sibling::div/div[@class='oxd-select-wrapper']")
	static WebElement UserStatusDrop;

	@FindBy(xpath = "//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
	static WebElement EmployeeName;

	@FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required' and text()='Username']//parent::div//following-sibling::div/input")
	static WebElement UserName;

	@FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required' and text()='Password']//parent::div//following-sibling::div/input")
	static WebElement Password;

	@FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required' and text()='Confirm Password']//parent::div//following-sibling::div/input")
	static WebElement ConfirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	static WebElement NewUserSaveButton;

	@FindBy(xpath = "//label[text()='Username']//parent::div//following-sibling::div//input[@class='oxd-input oxd-input--active']")
	static WebElement SearchSU;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SearchButton;

	@FindBy(xpath = "//*[@class='oxd-icon bi-trash']")
	static WebElement DeleteRecord;

	@FindBy(xpath = "//*[@class='oxd-icon bi-trash oxd-button-icon']")
	static WebElement DeleteRecordYes;

	public AdminTab(WebDriver driver) {
		AdminTab.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddUser(String UserRole, String UserStatus, String EmpName, String Username) {

		if (driver.getCurrentUrl().contains("/auth/login")) {
			Login log = new Login(driver);
			log.Login_user_passowrd(Login.username(), Login.Password());
			System.out.println("User Logged In Successfully");
		} else {
			System.out.println("User Already Logged In");
		}

		if (driver.getCurrentUrl().contains("/admin/viewSystemUsers")) {
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

		AdminAddUserButton.click(); // clicking Add Button
		System.out.println("Clicking Add User Button ");
		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		Assert.assertEquals(AddUserHearderText.getText(), "Add User");

		S_UserRole(UserRole); // User Role Selecting
		S_Status(UserStatus); // User Status Selecting
		S_EmpName(EmpName); // Entering Employee Name

		UserName.sendKeys(Username); // Entering User Name
		System.out.println("User Name :" + Username);

		Password.sendKeys(Username); // Entering Password
		System.err.println("Password :" + Username);

		ConfirmPassword.sendKeys(Username); // Entering Password
		System.err.println("Confirm Password :" + Username);

		NewUserSaveButton.click(); // Saving Newly Added User

		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SearchSU.sendKeys(Username); // Entering User Name in Search Fields
		SearchButton.click();
	}

	public static void S_UserRole(String AdUserRole) {

		UserRoleDrop.click();
		Actions act = new Actions(driver);
		if (AdUserRole.contains("Admin")) {
			for (int i = 0; i < 1; i++) {
				act.sendKeys(Keys.ARROW_DOWN).perform();
			}
		} else if (AdUserRole.contains("ESS")) {
			for (int i = 0; i < 2; i++) {
				act.sendKeys(Keys.ARROW_DOWN).perform();

			}
		}
		System.out.println("User Role :" + AdUserRole);
		act.sendKeys(Keys.ENTER).perform();

		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void S_Status(String AdStatus) {
		UserStatusDrop.click();
		Actions act = new Actions(driver);
		if (AdStatus.contains("Enabled")) {
			for (int i = 0; i < 1; i++) {
				act.sendKeys(Keys.ARROW_DOWN).perform();
			}
		} else if (AdStatus.contains("Disabled")) {
			for (int i = 0; i < 2; i++) {
				act.sendKeys(Keys.ARROW_DOWN).perform();

			}
		}
		System.out.println("User Status :" + AdStatus);
		act.sendKeys(Keys.ENTER).perform();

		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void S_EmpName(String AdEmpName) {
		EmployeeName.click();
		Actions act = new Actions(driver);
		act.sendKeys(AdEmpName).perform();// Entering Emp Name
		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Employee Name :" + AdEmpName);
	}

	public void DeleteUser() {
		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DeleteRecord.click();
		DeleteRecordYes.click();
	}
}
