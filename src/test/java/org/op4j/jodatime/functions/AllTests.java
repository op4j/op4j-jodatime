package org.op4j.jodatime.functions;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.op4j.jodatime.functions");
		//$JUnit-BEGIN$
		suite.addTestSuite(JodaStringTest.class);
		suite.addTestSuite(DateMidnightTest.class);
		suite.addTestSuite(DateTimeTest.class);
		suite.addTestSuite(IntervalTest.class);
		suite.addTestSuite(LocalDateTest.class);
		suite.addTestSuite(LocalTimeTest.class);
		suite.addTestSuite(PeriodTest.class);		
		//$JUnit-END$
		return suite;
	}

}
