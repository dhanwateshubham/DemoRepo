package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	ExtentSparkReporter sparkReporter;
	ExtentReports report;
	ExtentTest test;
	
	String reportName;
	
	public void onStart(ITestContext context)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS");

        // Get current timestamp
        LocalDateTime now = LocalDateTime.now();

        // Format timestamp
        String timestamp = now.format(formatter);
        reportName = "Test_Report"+timestamp;
        
		sparkReporter = new ExtentSparkReporter("./reports/"+reportName+".html");
		sparkReporter.config().setDocumentTitle("OpenCart Automation Testing");
		sparkReporter.config().setReportName("OpenCart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		
		report.setSystemInfo("Application","Opencart");
		report.setSystemInfo("User Name",System.getProperty("user.name"));
		
		
		
		String browserName = context.getCurrentXmlTest().getParameter("browser");
		report.setSystemInfo("Browser",browserName);
		report.setSystemInfo("OS","Windows 10");
		report.setSystemInfo("Environment","QA");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = report.createTest(result.getTestClass().getName());
		test.log(Status.PASS,"Test is passed : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = report.createTest(result.getName());
		test.log(Status.FAIL,"Test is Fail : "+result.getName());
		test.log(Status.INFO,"Test Failure Cause: "+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = report.createTest(result.getName());
		test.log(Status.SKIP,"Test is skip : "+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}
	
	
	
	
	
	
}
