package com.testful.framework.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.testful.framework.testng.IncludesTestName;

@Listeners({ com.testful.framework.testng.CustomListener.class,
		com.testful.framework.testng.CustomInvokedMethodListener.class,
		com.testful.framework.testng.CustomTestListener.class})
public class SimpleTestBase {
	protected static Logger logger = LogManager.getLogger();

	private static String testName = "";
	protected Level step = Level.valueOf("STEP");

	protected void step(String msg) {
		if (logger == null)
			logger = LogManager.getLogger();
		logger.log(step, msg);
	}

	private void setClassLevelLogger(Class<?> c) {
		if (logger.getClass() != c)
			logger = LogManager.getLogger(c);
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		step("This is a before suite !!!!");
		logger.warn("A wraning messgae");
		logger.debug("A wraning messgae");

		try {
			step("This is a before suite test step in try catch !!!!");

			// throw new Exception("... before suite hit exceptione.....");
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "
					+ e.getMessage());
		}
		
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		step("This is a before class !!!! ");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method, Object[] parameters)
			throws Exception {
		setClassLevelLogger(method.getDeclaringClass());

		step("This is a before method !!!!");
		String testCaseName = method.getName();
		IncludesTestName useAsTestName = method
				.getAnnotation(IncludesTestName.class);
		if (useAsTestName != null && parameters.length > 0) {
			testCaseName += "-" + (String) parameters[useAsTestName.idx()];
		}
		setTestName(testCaseName);
		step("Method - " + testCaseName);
	}

	public static String getTestName() {
		return testName;
	}

	public static void setTestName(String test) {
		testName = test;
	}

}
