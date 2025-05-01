package TestComponets;

import org.testng.annotations.Test;
import OrgScreens.AdminMenuJob;
import utility.Listners;

public class AdminTabTest extends Listners {

	@Test(priority = 1)
	public void CreateNewUserwithAdminRole() {
		at.AddUser("Admin", "Disabled", "A", "Test_User01");
		test.info("User Role: Admin");
		test.info("User Status: Disabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User01");
		at.DeleteUser();
		test.info("User Deleted Successfully");
	}

	@Test(dependsOnMethods = "CreateNewUserwithAdminRole")
	public void CreateNewUserwithESSRole() {
		at.AddUser("ESS", "Disabled", "A", "Test_User_02");
		test.info("User Role: ESS");
		test.info("User Status: Disabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User_02");
		at.DeleteUser();
		test.info("User Deleted Successfully");

	}

	@Test(dependsOnMethods = "CreateNewUserwithESSRole")
	public void CreateNewUserwithAdminRoleAndUserStatusEnable() {
		at.AddUser("Admin", "Enabled", "A", "Test_User_03");
		test.info("User Role: Admin");
		test.info("User Status: Enabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User_03");
		at.DeleteUser();
		test.info("User Deleted Successfully");
	}

	@Test(dependsOnMethods = "CreateNewUserwithAdminRoleAndUserStatusEnable")
	public void CreateNewUserwithESSRoleAndUserStatusEnable() {
		at.AddUser("ESS", "Enabled", "A", "Test_User_04");
		test.info("User Role: ESS");
		test.info("User Status: Enabled");
		test.info("Employee Name: A");
		test.info("User Name: Test_User_04");
		at.DeleteUser();
		test.info("User Deleted Successfully");

	}

//	@Test // (dependsOnMethods = "CreateNewUserwithESSRoleAndUserStatusEnable")
	public void CreateNewJobTitle() {
		AdminMenuJob adminjob = new AdminMenuJob(BaseTest.getdriver());
		AdminMenuJob.AdminJob("Job Titles");
	}
}
