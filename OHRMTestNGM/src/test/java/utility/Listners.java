package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import TestComponets.BaseTest;

public class Listners extends BaseTest implements ITestListener {
	ExtentReports extent = Reports.extentReportGenerator();
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		System.out.println(result.getName() + " Started ");
		test = extent.createTest(result.getName());
		try {
			test.addScreenCaptureFromPath(ScreenShot.TakeSS(driver, result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println(result.getName() + " Success ");
		test.log(Status.PASS, "Test Case Passed ");
		try {
			test.addScreenCaptureFromPath(ScreenShot.TakeSS(driver, result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println(result.getName() + " Failed ");
		test.log(Status.FAIL, "Test Case Failed ");
		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(ScreenShot.TakeSS(driver, result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);

		System.out.println(result.getName() + " Skipped");
		extent.createTest(result.getName()).skip("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		System.err.println("Test Failed But Within Success Percentage------->>>>>>");
		extent.createTest(result.getName()).fail("Test Failed But Within Success Percentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
		System.err.println("Test Failed With Timeout------->>>>>>");
		extent.createTest(result.getName()).fail("Test Failed With Timeout");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		String Contextname = context.getName();
		System.err.println(Contextname + "Test on Start------->>>>>>");
		extent.createTest(Contextname);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		String Contextname = context.getName();
		System.err.println(Contextname + " on Finish------->>>>>>");
		extent.createTest(Contextname);
		extent.flush();

	}
}
