package org.op4j.contrib.executables.functions.conversion;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;

public class ToLocalTimeTest extends TestCase {

	@Test
	public void testFromStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).parseDateTime(asStr).toLocalTime());	
	}
	
	@Test
	public void testFromStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				DateTimeZone.UTC)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.UTC)
				.parseDateTime(asStr).toLocalTime());	
	}

	@Test
	public void testFromStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromStringStringLocale() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				Locale.CANADA)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromStringStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				Locale.CANADA.toString())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromStringStringLocaleDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				Locale.CANADA, DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromStringStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-23:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				Locale.CANADA.toString(), DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromStringStringLocaleChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				Locale.CANADA, BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromStringStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm:ss";
		String asStr = "24/12/2000-00:03:33";
		LocalTime result = Op.on(asStr).exec(ToLocalTime.fromString(pattern,
				Locale.CANADA.toString(), BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toLocalTime());
	}

	@Test
	public void testFromDate() {
		Date date = new Date();
		LocalTime result = Op.on(date).exec(ToLocalTime.fromDate()).get();
		
		assertEquals(result, new LocalTime(date));
	}

	@Test
	public void testFromDateDateTimeZone() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		LocalTime result = Op.on(date).exec(ToLocalTime.fromDate(DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalTime(date, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateChronology() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		LocalTime result = Op.on(date).exec(ToLocalTime.fromDate(BuddhistChronology.getInstance())).get();
		
		assertEquals(result, new LocalTime(date, BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromTimestamp() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		LocalTime result = Op.on(timestamp).exec(ToLocalTime.fromTimestamp()).get();
		
		assertEquals(result, new LocalTime(timestamp));	
	}

	@Test
	public void testFromTimestampDateTimeZone() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		LocalTime result = Op.on(timestamp).exec(ToLocalTime.fromTimestamp(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalTime(timestamp, DateTimeZone.getDefault()));	
	}

	@Test
	public void testFromTimestampChronology() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		LocalTime result = Op.on(timestamp).exec(ToLocalTime.fromTimestamp(CopticChronology.getInstance())).get();
		
		assertEquals(result, new LocalTime(timestamp, CopticChronology.getInstance()));	
	}

	@Test
	public void testFromLong() {
		long dateAsLong = new Date().getTime();
		LocalTime result = Op.on(Long.valueOf(dateAsLong)).exec(ToLocalTime.fromLong()).get();
		
		assertEquals(result, new LocalTime(dateAsLong));
	}

	@Test
	public void testFromLongDateTimeZone() {
		long dateAsLong = new Date().getTime();
		LocalTime result = Op.on(Long.valueOf(dateAsLong)).exec(ToLocalTime.fromLong(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalTime(dateAsLong, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongChronology() {
		long dateAsLong = new Date().getTime();
		LocalTime result = Op.on(Long.valueOf(dateAsLong)).exec(ToLocalTime.fromLong(
				CopticChronology.getInstance())).get();
		
		assertEquals(result, new LocalTime(dateAsLong, CopticChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Integer hour = Integer.valueOf(16);
		Integer minute = Integer.valueOf(30);
		
		LocalTime result = Op.on(Arrays.asList(hour, minute))
			.exec(ToLocalTime.fromIntegerFieldList())
			.get();
	
		assertEquals(result,
				new LocalTime(hour.intValue(), minute.intValue()));
	}

	@Test
	public void testFromIntegerFieldListChronology() {
		Integer hour = Integer.valueOf(16);
		Integer minute = Integer.valueOf(30);
		Integer sec = Integer.valueOf(45);
		
		LocalTime result = Op.on(Arrays.asList(hour, minute, sec))
			.exec(ToLocalTime.fromIntegerFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalTime(hour.intValue(), minute.intValue(), sec.intValue(), 0,
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldArray() {
		Integer hour = Integer.valueOf(16);
		Integer minute = Integer.valueOf(30);
		Integer sec = Integer.valueOf(16);
		Integer milli = Integer.valueOf(78);
		
		LocalTime result = Op.on(new Integer[] {hour, minute, sec, milli})
			.exec(ToLocalTime.fromIntegerFieldArray())
			.get();
	
		assertEquals(result,
				new LocalTime(hour.intValue(), minute.intValue(), sec.intValue(), milli.intValue()));
	}

	@Test
	public void testFromIntegerFieldArrayChronology() {
		Integer hour = Integer.valueOf(16);
		
		LocalTime result = Op.on(new Integer[] {hour})
			.exec(ToLocalTime.fromIntegerFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalTime(hour.intValue(), 0, 0, 0, BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldList() {
		String hour = String.valueOf(16);
		String minute = String.valueOf(30);
		
		LocalTime result = Op.on(Arrays.asList(hour, minute))
			.exec(ToLocalTime.fromStringFieldList())
			.get();
	
		assertEquals(result,
				new LocalTime(Integer.parseInt(hour), Integer.parseInt(minute)));
	}

	@Test
	public void testFromStringFieldListChronology() {
		String hour = String.valueOf(16);
		String minute = String.valueOf(30);
		
		LocalTime result = Op.on(Arrays.asList(hour, minute))
			.exec(ToLocalTime.fromStringFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalTime(Integer.parseInt(hour), Integer.parseInt(minute), 0, 0, 
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldArray() {
		String hour = String.valueOf(16);
		String minute = String.valueOf(30);
		String sec = String.valueOf(16);
		String milli = String.valueOf(78);
		
		LocalTime result = Op.on(new String[] {hour, minute, sec, milli})
			.exec(ToLocalTime.fromStringFieldArray())
			.get();
	
		assertEquals(result,
				new LocalTime(Integer.parseInt(hour), Integer.parseInt(minute),
						Integer.parseInt(sec), Integer.parseInt(milli)));
	}

	@Test
	public void testFromStringFieldArrayChronology() {
		String hour = String.valueOf(16);
		String minute = String.valueOf(30);
		String sec = String.valueOf(16);
		String milli = String.valueOf(78);
		
		LocalTime result = Op.on(new String[] {hour, minute, sec, milli})
			.exec(ToLocalTime.fromStringFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalTime(Integer.parseInt(hour), Integer.parseInt(minute),
						Integer.parseInt(sec), Integer.parseInt(milli), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendar() {
		Calendar calendar = Calendar.getInstance();
		LocalTime result = Op.on(calendar).exec(ToLocalTime.fromCalendar()).get();
		
		assertEquals(result, new LocalTime(calendar));
	}

	@Test
	public void testFromCalendarDateTimeZone() {
		Calendar calendar = Calendar.getInstance();
		LocalTime result = Op.on(calendar).exec(ToLocalTime.fromCalendar(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalTime(calendar, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromCalendarChronology() {
		Calendar calendar = Calendar.getInstance();
		LocalTime result = Op.on(calendar).exec(ToLocalTime.fromCalendar(
				GJChronology.getInstance())).get();
		
		assertEquals(result, new LocalTime(calendar, GJChronology.getInstance()));
	}

}
