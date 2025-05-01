package TestComponets;

import org.testng.annotations.Test;
import utility.Listners;

public class AdminJob_JobTitles extends Listners {

	@Test
	public void CreateNewJobTitle() {
		amj.AdminJob("Job Titles");
		amj.JobTitles("Quality Testing 007");
		amj.DeleteJobTitles("Quality Testing 007");
		amj.JobTitles("Quality Testing 008");
		amj.DeleteJobTitles("Quality Testing 008");
		amj.JobTitles("Quality Testing 009");
		amj.DeleteJobTitles("Quality Testing 009");
		amj.JobTitles("Quality Testing 010");
		amj.DeleteJobTitles("Quality Testing 010");
		amj.JobTitles("Quality Testing 011");
		amj.DeleteJobTitles("Quality Testing 011");
		amj.JobTitles("Quality Testing 012");
		amj.DeleteJobTitles("Quality Testing 012");

	}

	@Test(dependsOnMethods = "CreateNewJobTitle")
	public void PayGrades() {
		amj.AdminJob("Pay Grades");
		amj.PayGrades("Grade A");
		amj.PayGradeCurrecy("ZWD", 10000, 200000);
//		amj.PayGradeCurrecy("USD", 11000, 210000);
		
		
		

	}

	@Test(dependsOnMethods = "PayGrades")
	public void EmpStatus() {
		amj.AdminJob("Employment Status");
		amj.EmploymentStatus(null);

	}
}
