package org.op4j.jodatime.functions;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;

public class MutableDateTimeTest extends TestCase {

	@Test
	public void testFromStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).parseMutableDateTime(asStr));
	}

	@Test
	public void testFromStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				DateTimeZone.UTC)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.UTC)
				.parseMutableDateTime(asStr));	
		
	}

	@Test
	public void testFromStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withChronology(BuddhistChronology.getInstance())
				.parseMutableDateTime(asStr));
		//TODO Enable
//		assertEquals(result, Op.on(asStr).exec(FnJodaTimeUtils.strToMutableDateTime(pattern,
//				BuddhistChronology.getInstance())).get());
	}

	@Test
	public void testFromStringStringLocale() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				Locale.CANADA)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseMutableDateTime(asStr));
	}

	@Test
	public void testFromStringStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				Locale.CANADA.toString())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseMutableDateTime(asStr));
	}

	@Test
	public void testFromStringStringLocaleDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				Locale.CANADA, DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseMutableDateTime(asStr));
	}

	@Test
	public void testFromStringStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-23:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				Locale.CANADA.toString(), DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseMutableDateTime(asStr));
	}

	@Test
	public void testFromStringStringLocaleChronology() {
	    
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				Locale.CANADA, BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseMutableDateTime(asStr));
		//TODO Enable
//		assertEquals(result, Op.on(asStr).exec(FnJodaTimeUtils.strToMutableDateTime(pattern,
//				Locale.CANADA, BuddhistChronology.getInstance())).get());
		
		try {
			Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime("",
					Locale.CANADA, BuddhistChronology.getInstance()));
			fail("conversion can't be done if pattern is empty");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromStringStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm:ss";
		String asStr = "24/12/2000-00:03:33";
		MutableDateTime result = Op.on(asStr).exec(FnMutableDateTime.strToMutableDateTime(pattern,
				Locale.CANADA.toString(), BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseMutableDateTime(asStr));
	}

	@Test
	public void testdateToMutableDateTime() {
		Date date = new Date();
		MutableDateTime result = Op.on(date).exec(FnMutableDateTime.dateToMutableDateTime()).get();
		
		assertEquals(result, new MutableDateTime(date));
	}

	@Test
	public void testFromDateDateTimeZone() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		MutableDateTime result = Op.on(date).exec(FnMutableDateTime.dateToMutableDateTime(DateTimeZone.getDefault())).get();
		
		assertEquals(result, new MutableDateTime(date, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateChronology() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		MutableDateTime result = Op.on(date).exec(FnMutableDateTime.dateToMutableDateTime(BuddhistChronology.getInstance())).get();
		
		assertEquals(result, new MutableDateTime(date, BuddhistChronology.getInstance()));
	}

	@Test
	public void testtimestampToMutableDateTime() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		MutableDateTime result = Op.on(timestamp).exec(FnMutableDateTime.timestampToMutableDateTime()).get();
		
		assertEquals(result, new MutableDateTime(timestamp));	
	}

	@Test
	public void testFromTimestampDateTimeZone() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		MutableDateTime result = Op.on(timestamp).exec(FnMutableDateTime.timestampToMutableDateTime(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new MutableDateTime(timestamp, DateTimeZone.getDefault()));	
	}

	@Test
	public void testFromTimestampChronology() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		MutableDateTime result = Op.on(timestamp).exec(FnMutableDateTime.timestampToMutableDateTime(CopticChronology.getInstance())).get();
		
		assertEquals(result, new MutableDateTime(timestamp, CopticChronology.getInstance()));	
	}

	@Test
	public void testFromLong() {
		long dateAsLong = new Date().getTime();
		MutableDateTime result = Op.on(Long.valueOf(dateAsLong)).exec(FnMutableDateTime.longToMutableDateTime()).get();
		
		assertEquals(result, new MutableDateTime(dateAsLong));
	}

	@Test
	public void testFromLongDateTimeZone() {
		long dateAsLong = new Date().getTime();
		MutableDateTime result = Op.on(Long.valueOf(dateAsLong)).exec(FnMutableDateTime.longToMutableDateTime(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new MutableDateTime(dateAsLong, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongChronology() {
		long dateAsLong = new Date().getTime();
		MutableDateTime result = Op.on(Long.valueOf(dateAsLong)).exec(FnMutableDateTime.longToMutableDateTime(
				CopticChronology.getInstance())).get();
		
		assertEquals(result, new MutableDateTime(dateAsLong, CopticChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Integer year = Integer.valueOf(2008);
		Integer month = Integer.valueOf(12);
		Integer day = Integer.valueOf(8);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		
		MutableDateTime result = Op.on(Arrays.asList(year, month, day, hour, minute))
			.exec(FnMutableDateTime.integerFieldCollectionToMutableDateTime())
			.get();
	
		assertEquals(result,
				new MutableDateTime(year.intValue(), month.intValue(), day.intValue(),
						hour.intValue(), minute.intValue(), 0, 0));
	}

	@Test
	public void testFromIntegerFieldListChronology() {
		Integer year = Integer.valueOf(1985);
		Integer month = Integer.valueOf(1);
		Integer day = Integer.valueOf(25);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		
		MutableDateTime result = Op.on(Arrays.asList(year, month, day, hour, minute))
			.exec(FnMutableDateTime.integerFieldCollectionToMutableDateTime(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new MutableDateTime(year.intValue(), month.intValue(), day.intValue(),
						hour.intValue(), minute.intValue(), 0, 0,
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testintegerFieldArrayToMutableDateTime() {
		Integer year = Integer.valueOf(16);
		Integer month = Integer.valueOf(3);
		Integer day = Integer.valueOf(16);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		Integer second = Integer.valueOf(53);
		
		MutableDateTime result = Op.on(new Integer[] {year, month, day, hour, minute, second})
			.exec(FnMutableDateTime.integerFieldArrayToMutableDateTime())
			.get();
	
		assertEquals(result,
				new MutableDateTime(year.intValue(), month.intValue(), day.intValue(),
						hour.intValue(), minute.intValue(), second.intValue(), 0));
	}

	@Test
	public void testFromIntegerFieldArrayChronology() {
		Integer year = Integer.valueOf(16);
		Integer month = Integer.valueOf(3);
		Integer day = Integer.valueOf(16);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		Integer second = Integer.valueOf(53);
		
		MutableDateTime result = Op.on(new Integer[] {year, month, day, hour, minute, second})
			.exec(FnMutableDateTime.integerFieldArrayToMutableDateTime(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new MutableDateTime(year.intValue(), month.intValue(), day.intValue(),
						hour.intValue(), minute.intValue(), second.intValue(), 0, BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldList() {
		String year = String.valueOf(1);
		String month = String.valueOf(3);
		String day = String.valueOf(16);
		String hour = String.valueOf(18);
		String minute = String.valueOf(23);
		String second = String.valueOf(53);
		
		MutableDateTime result = Op.on(Arrays.asList(year, month, day, hour, minute, second))
			.exec(FnMutableDateTime.strFieldCollectionToMutableDateTime())
			.get();
	
		assertEquals(result,
				new MutableDateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
						Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), 0));
	}

	@Test
	public void testFromStringFieldListChronology() {
		String year = String.valueOf(16);
		String month = String.valueOf(8);
		String day = String.valueOf(16);
		String hour = String.valueOf(18);
		String minute = String.valueOf(23);
		String second = String.valueOf(53);
		
		MutableDateTime result = Op.on(Arrays.asList(year, month, day, hour, minute, second))
			.exec(FnMutableDateTime.strFieldCollectionToMutableDateTime(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new MutableDateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
						Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), 0,
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldArray() {
		String year = String.valueOf(16);
		String month = String.valueOf(4);
		String day = String.valueOf(30);
		String hour = String.valueOf(18);
		String minute = String.valueOf(23);
		String second = String.valueOf(53);
		String milli = String.valueOf(33);
		
		MutableDateTime result = Op.on(new String[] {year, month, day, hour, minute, second, milli})
			.exec(FnMutableDateTime.strFieldArrayToMutableDateTime())
			.get();
	
		assertEquals(result,
				new MutableDateTime(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day), Integer.parseInt(hour),
						Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli)));
	}

	@Test
	public void testFromStringFieldArrayChronology() {
		String year = String.valueOf(16);
		String month = String.valueOf(9);
		String day = String.valueOf(16);
		String hour = String.valueOf(18);
		String minute = String.valueOf(23);
		String second = String.valueOf(53);
		String milli = String.valueOf(33);
		
		MutableDateTime result = Op.on(new String[] {year, month, day, hour, minute, second, milli})
			.exec(FnMutableDateTime.strFieldArrayToMutableDateTime(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new MutableDateTime(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day), Integer.parseInt(hour),
						Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testcalendarToMutableDateTime() {
		Calendar calendar = Calendar.getInstance();
		MutableDateTime result = Op.on(calendar).exec(FnMutableDateTime.calendarToMutableDateTime()).get();
		
		assertEquals(result, new MutableDateTime(calendar));
	}

	@Test
	public void testFromCalendarDateTimeZone() {
		Calendar calendar = Calendar.getInstance();
		MutableDateTime result = Op.on(calendar).exec(FnMutableDateTime.calendarToMutableDateTime(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new MutableDateTime(calendar, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromCalendarChronology() {
		Calendar calendar = Calendar.getInstance();
		MutableDateTime result = Op.on(calendar).exec(FnMutableDateTime.calendarToMutableDateTime(
				GJChronology.getInstance())).get();
		
		assertEquals(result, new MutableDateTime(calendar, GJChronology.getInstance()));
	}

}
