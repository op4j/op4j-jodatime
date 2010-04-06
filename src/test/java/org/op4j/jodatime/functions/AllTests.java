package org.op4j.jodatime.functions;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.op4j.jodatime.functions");
		//$JUnit-BEGIN$
		suite.addTestSuite(JodaToStringTest.class);
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
