package org.op4j.contrib.executables.functions.conversion;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.op4j.contrib.executables.functions.conversion");
		//$JUnit-BEGIN$
		suite.addTestSuite(JodaTimeToStringTest.class);
		suite.addTestSuite(ToDateMidnightTest.class);
		suite.addTestSuite(ToDateTimeTest.class);
		suite.addTestSuite(ToIntervalTest.class);
		suite.addTestSuite(ToLocalDateTest.class);
		suite.addTestSuite(ToLocalTimeTest.class);
		suite.addTestSuite(ToPeriodTest.class);		
		//$JUnit-END$
		return suite;
	}

}
