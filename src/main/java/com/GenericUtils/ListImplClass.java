package com.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		// configure report
		JavaUtils jLib= new JavaUtils();
		ExtentSparkReporter htmlreport= new ExtentSparkReporter(".\\extentReport\\report\\"+jLib.getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("SDET-53");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("DeltaNegocio");

		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BasePlatform", "OS");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		report.setSystemInfo("Reporter", "Meghana K Raju");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		//Testscript execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+" Execution started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"Passed");
		Reporter.log(methodName+" Executed successfully", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		try {

			String path1 = WebdriverUtils.getScreenShot(BaseClass.sdriver,methodName);
			test.addScreenCaptureFromPath(path1);
			test.log(Status.FAIL, methodName+"Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(methodName+" Failed");
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"Skipped");
	}



	@Override
	public void onFinish(ITestContext context) {
		//to refresh
		report.flush();
	}

}
