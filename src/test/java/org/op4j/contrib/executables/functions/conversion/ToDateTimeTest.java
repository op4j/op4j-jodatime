package org.op4j.contrib.executables.functions.conversion;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;

public class ToDateTimeTest extends TestCase {

	@Test
	public void testFromStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).parseDateTime(asStr));
	}

	@Test
	public void testFromStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				DateTimeZone.UTC)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.UTC)
				.parseDateTime(asStr));	
	}

	@Test
	public void testFromStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr));
	}

	@Test
	public void testFromStringStringLocale() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				Locale.CANADA)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr));
	}

	@Test
	public void testFromStringStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				Locale.CANADA.toString())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr));
	}

	@Test
	public void testFromStringStringLocaleDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				Locale.CANADA, DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr));
	}

	@Test
	public void testFromStringStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-23:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				Locale.CANADA.toString(), DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr));
	}

	@Test
	public void testFromStringStringLocaleChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				Locale.CANADA, BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr));
		
		try {
			Op.on(asStr).exec(FnToDateTime.fromString("",
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
		DateTime result = Op.on(asStr).exec(FnToDateTime.fromString(pattern,
				Locale.CANADA.toString(), BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr));
	}

	@Test
	public void testFromDate() {
		Date date = new Date();
		DateTime result = Op.on(date).exec(FnToDateTime.fromDate()).get();
		
		assertEquals(result, new DateTime(date));
	}

	@Test
	public void testFromDateDateTimeZone() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		DateTime result = Op.on(date).exec(FnToDateTime.fromDate(DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateTime(date, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateChronology() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		DateTime result = Op.on(date).exec(FnToDateTime.fromDate(BuddhistChronology.getInstance())).get();
		
		assertEquals(result, new DateTime(date, BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromTimestamp() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		DateTime result = Op.on(timestamp).exec(FnToDateTime.fromTimestamp()).get();
		
		assertEquals(result, new DateTime(timestamp));	
	}

	@Test
	public void testFromTimestampDateTimeZone() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		DateTime result = Op.on(timestamp).exec(FnToDateTime.fromTimestamp(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateTime(timestamp, DateTimeZone.getDefault()));	
	}

	@Test
	public void testFromTimestampChronology() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		DateTime result = Op.on(timestamp).exec(FnToDateTime.fromTimestamp(CopticChronology.getInstance())).get();
		
		assertEquals(result, new DateTime(timestamp, CopticChronology.getInstance()));	
	}

	@Test
	public void testFromLong() {
		long dateAsLong = new Date().getTime();
		DateTime result = Op.on(Long.valueOf(dateAsLong)).exec(FnToDateTime.fromLong()).get();
		
		assertEquals(result, new DateTime(dateAsLong));
	}

	@Test
	public void testFromLongDateTimeZone() {
		long dateAsLong = new Date().getTime();
		DateTime result = Op.on(Long.valueOf(dateAsLong)).exec(FnToDateTime.fromLong(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateTime(dateAsLong, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongChronology() {
		long dateAsLong = new Date().getTime();
		DateTime result = Op.on(Long.valueOf(dateAsLong)).exec(FnToDateTime.fromLong(
				CopticChronology.getInstance())).get();
		
		assertEquals(result, new DateTime(dateAsLong, CopticChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Integer year = Integer.valueOf(2008);
		Integer month = Integer.valueOf(12);
		Integer day = Integer.valueOf(8);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		
		DateTime result = Op.on(Arrays.asList(year, month, day, hour, minute))
			.exec(FnToDateTime.fromIntegerFieldList())
			.get();
	
		assertEquals(result,
				new DateTime(year.intValue(), month.intValue(), day.intValue(),
						hour.intValue(), minute.intValue(), 0, 0));
	}

	@Test
	public void testFromIntegerFieldListChronology() {
		Integer year = Integer.valueOf(1985);
		Integer month = Integer.valueOf(1);
		Integer day = Integer.valueOf(25);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		
		DateTime result = Op.on(Arrays.asList(year, month, day, hour, minute))
			.exec(FnToDateTime.fromIntegerFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateTime(year.intValue(), month.intValue(), day.intValue(),
						hour.intValue(), minute.intValue(), 0, 0,
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldArray() {
		Integer year = Integer.valueOf(16);
		Integer month = Integer.valueOf(3);
		Integer day = Integer.valueOf(16);
		Integer hour = Integer.valueOf(18);
		Integer minute = Integer.valueOf(23);
		Integer second = Integer.valueOf(53);
		
		DateTime result = Op.on(new Integer[] {year, month, day, hour, minute, second})
			.exec(FnToDateTime.fromIntegerFieldArray())
			.get();
	
		assertEquals(result,
				new DateTime(year.intValue(), month.intValue(), day.intValue(),
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
		
		DateTime result = Op.on(new Integer[] {year, month, day, hour, minute, second})
			.exec(FnToDateTime.fromIntegerFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateTime(year.intValue(), month.intValue(), day.intValue(),
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
		
		DateTime result = Op.on(Arrays.asList(year, month, day, hour, minute, second))
			.exec(FnToDateTime.fromStringFieldList())
			.get();
	
		assertEquals(result,
				new DateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
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
		
		DateTime result = Op.on(Arrays.asList(year, month, day, hour, minute, second))
			.exec(FnToDateTime.fromStringFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
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
		
		DateTime result = Op.on(new String[] {year, month, day, hour, minute, second, milli})
			.exec(FnToDateTime.fromStringFieldArray())
			.get();
	
		assertEquals(result,
				new DateTime(Integer.parseInt(year), Integer.parseInt(month),
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
		
		DateTime result = Op.on(new String[] {year, month, day, hour, minute, second, milli})
			.exec(FnToDateTime.fromStringFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateTime(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day), Integer.parseInt(hour),
						Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendar() {
		Calendar calendar = Calendar.getInstance();
		DateTime result = Op.on(calendar).exec(FnToDateTime.fromCalendar()).get();
		
		assertEquals(result, new DateTime(calendar));
	}

	@Test
	public void testFromCalendarDateTimeZone() {
		Calendar calendar = Calendar.getInstance();
		DateTime result = Op.on(calendar).exec(FnToDateTime.fromCalendar(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateTime(calendar, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromCalendarChronology() {
		Calendar calendar = Calendar.getInstance();
		DateTime result = Op.on(calendar).exec(FnToDateTime.fromCalendar(
				GJChronology.getInstance())).get();
		
		assertEquals(result, new DateTime(calendar, GJChronology.getInstance()));
	}

}
