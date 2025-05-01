package OrgScreens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ORGResue.Resuse_Code;

public class Login extends Resuse_Code {

	static String getUserName = "//p[@class='oxd-text oxd-text--p'][1]";
	static String getPassword = "//p[@class='oxd-text oxd-text--p'][2]";
	static String loginUsername = "//*[@name='username']";
	static String loginPassword = "//*[@name='password']";
	static String loginButton = "//*[@type='submit']";

	// Dashboard Tab
	String Dashboard = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Dashboard']";

	static WebDriver driver;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p'][1]")
	static WebElement Login_us;

	public Login(WebDriver driver) {
		super(driver);
		Login.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String username() {

		WebElement Login_us = driver.findElement(By.xpath(getUserName));
		WaitForElementToAppear(By.xpath(getUserName));
		String Log_username = Login_us.getText();
		String[] User = Log_username.split(":");
		System.out.println("User Name :" + User[1].trim());
		return User[1].trim();
	}

	public static String Password() {

		WaitForElementToAppear(By.xpath(getPassword));
		String Login_pass = driver.findElement(By.xpath(getPassword)).getText();
		String[] User = Login_pass.split(":");
		System.out.println("Password :" + User[1].trim());
		return User[1].trim();
	}

	public void Login_user_passowrd(String username, String password) {

		WebElement loginusername = driver.findElement(By.xpath(loginUsername));
		WebElement loginpassword = driver.findElement(By.xpath(loginPassword));
		WebElement loginsubmitbutton = driver.findElement(By.xpath(loginButton));
		if (username == null && password == null) {
			loginusername.sendKeys(username);
			loginpassword.sendKeys(password);
			System.err.println("Username & Password Required");

		} else if (username != null & password == null) {
			loginusername.sendKeys(username);
			loginpassword.sendKeys(password);
			System.err.println("Password Required");

		} else if (username == null & password != null) {
			loginusername.sendKeys(username);
			loginpassword.sendKeys(password);
			System.err.println("Username Required");

		} else if (username != null & password != null) {
			loginusername.sendKeys(username);
			loginpassword.sendKeys(password);

		}
		loginsubmitbutton.click();

		if (driver.getCurrentUrl().contains("dashboard")) {
			System.out.println("Login Succesfully");
		}

		else {

			System.out.println(driver.getCurrentUrl().toString());
			if (username == null && password == null) {
				System.err.println("Required Field");

			} else {
				System.err.println("Invalid credentials");
			}
		}

	}

	public static void userlogout() {
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[@class='oxd-userdropdown-link' and text()='Logout']")).click();
		try {
			Thread.sleep(Duration.ofSeconds(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
