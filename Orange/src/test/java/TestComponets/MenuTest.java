package TestComponets;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrgScreens.Login;
import utility.Listners;

public class MenuTest extends Listners {

	@BeforeMethod
	public void login() throws InterruptedException {
		log.Login_user_passowrd(Login.username(), Login.Password());
		test.info("Login Succesfully");
	}

	@Test
	public void hitAdmin() throws IOException {
		ot.Menu("Admin");
		test.info("Admin Menu Hit");
	}

	@Test
	public void hitPerformance() throws IOException, InterruptedException {
		ot.Menu("Performance");
		test.info("Performance Menu Hit");

	}

	@AfterMethod
	public void logoff() {
		Login.userlogout();
	}
}
