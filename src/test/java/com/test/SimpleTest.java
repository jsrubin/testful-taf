package com.test;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTest extends SimpleTestBase {

	@DataProvider(name = "dp")
	public Object[][] simpleDp() {
		return new Object[][] { { "Fail", false }, { "Pass", true } };
	}

//	@IncludesTestName
	@Test(dataProvider = "dp", groups = {"RUNME"} )
	public void simpleTest(String testName, boolean expected) {
		logger = LogManager.getLogger(SimpleTest.class);
		step("Start a simple test");
		// try {
		Assert.assertEquals(true, expected);
		// throw new Exception("exception thrown from simpleTestPass!");
		// } catch (Exception e) {
		// System.out.println("assert failed... threw exception!");
		// }
	}

	@Test(groups = {"DONOTRUNME"} )
	public void simpleTestFail() throws Exception {
		step("Start a simple test that fails");
		// try {
		// Assert.assertEquals(true, false);
		throw new Exception("exception thrown from simpleTestFail!");
		// } catch (Exception e) {
		// System.out.println("assert failed... threw exception!");
		// }
	}

}
