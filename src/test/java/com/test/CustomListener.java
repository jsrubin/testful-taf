package com.test;

import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener extends CustomInvokedMethodListener {
	// private static Logger log =
	// Logger.getLogger(CustomTestListener.class.getName());

	/**
	 * This method is invoked after the execution of each test case is complete.
	 * This method checks if there are any assert failures in the test method
	 * and accordingly fails the test case and appends all the failures in
	 * reporting.
	 * 
	 */
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		// System.out.println("CustomListener::afterInvocation..... could add retry logic and set test failure points here!");
		Reporter.setCurrentTestResult(result);
		if (method.isTestMethod()) {
			System.out.println("afterInvocation:::: "
					+ method.getTestMethod().getMethodName());

		}
	}

}
