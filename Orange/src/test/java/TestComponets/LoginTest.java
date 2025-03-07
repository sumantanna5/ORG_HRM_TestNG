package TestComponets;

import java.time.Duration;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import OrgScreens.Login;
import utility.Listners;

public class LoginTest extends Listners {

	@Test
	public void LoginWithCorrectUsernamPassword() throws InterruptedException {
		test.info("Entering Credentials");
		log.Login_user_passowrd(Login.username(), Login.Password());
		test.info("Login with Valid UserName & Password");
		Login.userlogout();
		test.info("Log out Succesflly");
	}

	@Test
	public void LoginWithinCorrectUsernamePassword() throws InterruptedException {
		test.info("Entering Credentials");
		log.Login_user_passowrd("Sumant", "Test");
		test.info("Login with InValid UserName & Password");
		driver.navigate().refresh();
		test.info("Screen Refresh");
		Thread.sleep(Duration.ofSeconds(5));
	}

	@Test
	public void LoginWithinCorrectUsernameAndCorrectPassword() throws InterruptedException {
		test.info("Entering Credentials");
		log.Login_user_passowrd("", Login.Password());
		test.info("Login with Password but UserName is Null");
	}

}
