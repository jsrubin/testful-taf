package com.testful.framework.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer {
	private int maxRetryCount = 1;
	private int retryCount = 0;
	
	@Override
	public boolean retry(ITestResult result) {
	try {
		System.out.println("REtry::: ");
	    if (result.getThrowable().toString()
	        .contains("NoSuchElementException")) // Checking for specific reasons of failure
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true;
	        }
	    return false;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
//	if (!TestCommonMethodBase.getTestName().equals(currentTestName)) {
//		this.currentCount = 0;
//		this.currentTestName = TestCommonMethodBase.getTestName();
//	}
//
//	if (!testPassed && this.currentCount < maxRetryCount) {
//		this.currentCount++;
//		return true;
//	}
//	return false;
	

}
