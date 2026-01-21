package revise.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import revise.driver.driverTest;
import revise.resources.extentReport;

public class listener extends driverTest implements ITestListener {

	ExtentReports extent = extentReport.reports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

//		driver = getDriver();
		String filePaths = null;
		try {
			filePaths = takeScreen(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	System.out.println(filePaths);
		extentTest.get().addScreenCaptureFromPath(filePaths, result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
