package com.testful.framework.testng;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation used as an indicator that the Test Method should use the indexed
 * parameter as the test instance name
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface IncludesTestName {

	/**
	 * Index of the parameter to use as the Test Case ID.
	 */

	int idx() default 0;

}
