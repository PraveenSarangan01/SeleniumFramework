package com.TestNg;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{

	int failedCount=0;
	int limit=3;

	@Override
	public boolean retry(ITestResult result) {
		
		if(failedCount<limit) {
			failedCount++;
			return true;
		}
		return false;
	}

}
