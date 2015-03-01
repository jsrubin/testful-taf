/**
 * 
 */
package com.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
	private static String testName = "";

	private void setLocalTestName() {
		testName = SimpleTest.testName;
	}

	@Override
	public void onTestStart(ITestResult result) {
		setLocalTestName();
		System.out.println("onTestStart:::: " + testName);

		System.out.println("onTestStart:::: " + result.getParameters()[0]);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess:::: " + testName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// System.out.println("CustomTestListern::onTestFailure.... could handle failure here! ..."
		// + result.getName());
		System.out.println("onTestFailure:::: " + testName);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "
				+ result.getThrowable().getMessage());
		result.setThrowable(null);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped:::: " + testName);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		// System.out.println("CustomTestListern::onStart.... could initialize Retry here! ..."
		// + context.getName());
		System.out.println("onStart::::: ");

	}

	@Override
	public void onFinish(ITestContext context) {
		// System.out.println("CustomTestListern::onFinish.... could handle failures here!... "
		// + context.getName());
		System.out.println("onFinish::::: ");

	}

}
