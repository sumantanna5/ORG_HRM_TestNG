package TestComponets;

import org.testng.annotations.Test;

import OrgScreens.AdminMenuJob;
import utility.Listners;

public class AdminTabTest extends Listners {

	@Test(priority = 1)
	public void CreateNewUserwithAdminRole() {
		at.AddUser("Admin", "Disabled", "A", "Test_User111");
		test.info("User Role: Admin");
		test.info("User Status: Disabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User111");
		at.DeleteUser();
		test.info("User Deleted Successfully");
	}

	@Test(dependsOnMethods = "CreateNewUserwithAdminRole")
	public void CreateNewUserwithESSRole() {
		at.AddUser("ESS", "Disabled", "A", "Test_User222");
		test.info("User Role: ESS");
		test.info("User Status: Disabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User_222");
		at.DeleteUser();
		test.info("User Deleted Successfully");

	}

	@Test(dependsOnMethods = "CreateNewUserwithESSRole")
	public void CreateNewUserwithAdminRoleAndUserStatusEnable() {
		at.AddUser("Admin", "Enabled", "A", "Test_User333");
		test.info("User Role: Admin");
		test.info("User Status: Enabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User_333");
		at.DeleteUser();
		test.info("User Deleted Successfully");
	}

	@Test(dependsOnMethods = "CreateNewUserwithAdminRoleAndUserStatusEnable")
	public void CreateNewUserwithESSRoleAndUserStatusEnable() {
		at.AddUser("ESS", "Enabled", "A", "Test_User444");
		test.info("User Role: ESS");
		test.info("User Status: Enabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User_444");
		at.DeleteUser();
		test.info("User Deleted Successfully");

	}


}
