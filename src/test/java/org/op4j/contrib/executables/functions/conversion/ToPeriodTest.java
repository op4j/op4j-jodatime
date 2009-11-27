package org.op4j.contrib.executables.functions.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Date;

import org.joda.time.Period;
import org.joda.time.chrono.BuddhistChronology;
import org.junit.Test;
import org.op4j.Op;

public class ToPeriodTest {

	@Test
	public void testFromDateFieldList() {
		Date from = new Date();
		Date to = new Date();
		to.setTime(from.getTime() + 10000);
		Period period = Op.onList(Arrays.asList(from, to))
			.generic().exec(ToPeriod.fromDateFieldList())
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromDateFieldListChronology() {
		java.sql.Date from = new java.sql.Date(1000);
		java.sql.Date to = new java.sql.Date(100000);	
		Period period = Op.onList(Arrays.asList(from, to))
			.generic().exec(ToPeriod.fromDateFieldList(
					BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromDateFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateFieldListPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateFieldArrayChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateFieldArrayPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldListChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldListPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldArrayChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromTimestampFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldListChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldListPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldArrayChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromLongFieldArrayPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldListChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldListPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldArrayChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromCalendarFieldArrayPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldListChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldListPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldArrayChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromDateTimeFieldArrayPeriodTypeChronology() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromIntegerFieldList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromIntegerFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromIntegerFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromIntegerFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromStringFieldList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromStringFieldListPeriodType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromStringFieldArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFromStringFieldArrayPeriodType() {
		fail("Not yet implemented");
	}

}
