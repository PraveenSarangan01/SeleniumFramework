package com.Magento_Base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class MagentoListeners extends MagentoBase implements ITestListener {
	private ExtentTest test;

	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Passed:"+ result.getMethod().getMethodName());
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			takescreenShot(driver, "./snaps/"+result.getName()+".png");
			test.log(Status.FAIL,"Test Failed:"+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath("./snaps/"+result.getName()+".png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		

	public void onStart(ITestContext context) {
		extentReport();
	}

	public void onFinish(ITestContext context) {
		flushReport();
		
	}

}
