package com.testful.framework.suite;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testful.framework.base.SimpleTestBase;

public class SimpleTest extends SimpleTestBase {

//	@DataProvider(name = "csvDataProvider")
//    public static  String[][] csvProvider()  throws Exception{
//    	return DataProviderHelper.getStringArrayOfArray("csvTestData.csv");
//    }
	
//	@Test(dataProvider = "csvDataProvider" )
	public void testCsvData(boolean expected) {
		Assert.assertEquals(true, expected);
	}

//	@DataProvider(name = "jsonDataProvider")
//  public static  String[][] jsonProvider()  throws Exception{
//  	return DataProviderHelper.getMapOfJson("jsonTestData.json");
//  }
	
	@DataProvider(name = "inMethodDataProvider")
	public Object[][] inMethodProvider() {
		return new Object[][] { { "Fail", false }, { "Pass", true } };
	}

//	@IncludesTestName
//	@Test(dataProvider = "inMethodDataProvider", groups = {"RUNME"} )
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

//	@Test //(retryAnalyzer=CustomRetryAnalyzer.class)//, groups = {"DONOTRUNME"} )
	public void simpleTestFail() throws Exception {
		System.out.println(">>>>>> tests is me!");
//		step("Start a simple test that fails");
		// try {
		// Assert.assertEquals(true, false);
//		throw new Exception("exception thrown from simpleTestFail!");
		// } catch (Exception e) {
		// System.out.println("assert failed... threw exception!");
		// }
	}
	
	
	@Test ( groups = {"SkipDb"} )
	public void simpleTestDatabase() throws Exception {
		System.out.println(">>>>>> test assert!");
		Assert.assertEquals(true, false);

		System.out.println(">>>>>> validate internationalization via database!");
		Assert.assertEquals(true, false);
	}

}
