package org.op4j.contrib.executables.functions.conversion;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;

public class ToLocalDateTest extends TestCase {

	@Test
	public void testFromStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				DateTimeZone.UTC)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.UTC)
				.parseDateTime(asStr).toLocalDate());	
	}

	@Test
	public void testFromStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toLocalDate());
		
		assertEquals(result, Op.on(asStr).exec(FnJodaTimeUtils
				.strToLocalDate(pattern,
				BuddhistChronology.getInstance())).get());
	}

	@Test
	public void testFromStringStringLocale() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				Locale.CANADA)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromStringStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				Locale.CANADA.toString())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromStringStringLocaleDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				Locale.CANADA, DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromStringStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-23:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				Locale.CANADA.toString(), DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromStringStringLocaleChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				Locale.CANADA, BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromStringStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm:ss";
		String asStr = "24/12/2000-00:03:33";
		LocalDate result = Op.on(asStr).exec(FnToLocalDate.fromString(pattern,
				Locale.CANADA.toString(), BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toLocalDate());
	}

	@Test
	public void testFromDate() {
		Date date = new Date();
		LocalDate result = Op.on(date).exec(FnToLocalDate.fromDate()).get();
		
		assertEquals(result, new LocalDate(date));
	}

	@Test
	public void testFromDateDateTimeZone() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		LocalDate result = Op.on(date).exec(FnToLocalDate.fromDate(DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalDate(date, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateChronology() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		LocalDate result = Op.on(date).exec(FnToLocalDate.fromDate(BuddhistChronology.getInstance())).get();
		
		assertEquals(result, new LocalDate(date, BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromTimestamp() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		LocalDate result = Op.on(timestamp).exec(FnToLocalDate.fromTimestamp()).get();
		
		assertEquals(result, new LocalDate(timestamp));	
	}

	@Test
	public void testFromTimestampDateTimeZone() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		LocalDate result = Op.on(timestamp).exec(FnToLocalDate.fromTimestamp(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalDate(timestamp, DateTimeZone.getDefault()));	
	}

	@Test
	public void testFromTimestampChronology() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		LocalDate result = Op.on(timestamp).exec(FnToLocalDate.fromTimestamp(CopticChronology.getInstance())).get();
		
		assertEquals(result, new LocalDate(timestamp, CopticChronology.getInstance()));	
	}

	@Test
	public void testFromLong() {
		long dateAsLong = new Date().getTime();
		LocalDate result = Op.on(Long.valueOf(dateAsLong)).exec(FnToLocalDate.fromLong()).get();
		
		assertEquals(result, new LocalDate(dateAsLong));
	}

	@Test
	public void testFromLongDateTimeZone() {
		long dateAsLong = new Date().getTime();
		LocalDate result = Op.on(Long.valueOf(dateAsLong)).exec(FnToLocalDate.fromLong(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalDate(dateAsLong, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongChronology() {
		long dateAsLong = new Date().getTime();
		LocalDate result = Op.on(Long.valueOf(dateAsLong)).exec(FnToLocalDate.fromLong(
				CopticChronology.getInstance())).get();
		
		assertEquals(result, new LocalDate(dateAsLong, CopticChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Integer year = Integer.valueOf(2008);
		Integer month = Integer.valueOf(12);
		
		LocalDate result = Op.on(Arrays.asList(year, month))
			.exec(FnToLocalDate.fromIntegerFieldCollection())
			.get();
	
		assertEquals(result,
				new LocalDate(year.intValue(), month.intValue(), 1));
	}

	@Test
	public void testFromIntegerFieldListChronology() {
		Integer year = Integer.valueOf(1985);
		Integer month = Integer.valueOf(1);
		Integer day = Integer.valueOf(25);
		
		LocalDate result = Op.on(Arrays.asList(year, month, day))
			.exec(FnToLocalDate.fromIntegerFieldCollection(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalDate(year.intValue(), month.intValue(), day.intValue(),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldArray() {
		Integer year = Integer.valueOf(16);
		Integer month = Integer.valueOf(3);
		Integer day = Integer.valueOf(16);
		
		LocalDate result = Op.on(new Integer[] {year, month, day})
			.exec(FnToLocalDate.fromIntegerFieldArray())
			.get();
	
		assertEquals(result,
				new LocalDate(year.intValue(), month.intValue(), day.intValue()));
	}

	@Test
	public void testFromIntegerFieldArrayChronology() {
		Integer year = Integer.valueOf(16);
		
		LocalDate result = Op.on(new Integer[] {year})
			.exec(FnToLocalDate.fromIntegerFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalDate(year.intValue(), 1, 1, BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldList() {
		String year = String.valueOf(1);
		String month = String.valueOf(3);
		
		LocalDate result = Op.on(Arrays.asList(year, month))
			.exec(FnToLocalDate.fromStringFieldCollection())
			.get();
	
		assertEquals(result,
				new LocalDate(Integer.parseInt(year), Integer.parseInt(month), 1));
	}

	@Test
	public void testFromStringFieldListChronology() {
		String year = String.valueOf(16);
		String month = String.valueOf(8);
		
		LocalDate result = Op.on(Arrays.asList(year, month))
			.exec(FnToLocalDate.fromStringFieldCollection(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalDate(Integer.parseInt(year), Integer.parseInt(month), 1, 
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldArray() {
		String year = String.valueOf(16);
		String month = String.valueOf(4);
		String day = String.valueOf(30);
		
		LocalDate result = Op.on(new String[] {year, month, day})
			.exec(FnToLocalDate.fromStringFieldArray())
			.get();
	
		assertEquals(result,
				new LocalDate(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day)));
	}

	@Test
	public void testFromStringFieldArrayChronology() {
		String year = String.valueOf(16);
		String month = String.valueOf(9);
		String day = String.valueOf(16);
		
		LocalDate result = Op.on(new String[] {year, month, day})
			.exec(FnToLocalDate.fromStringFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new LocalDate(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendar() {
		Calendar calendar = Calendar.getInstance();
		LocalDate result = Op.on(calendar).exec(FnToLocalDate.fromCalendar()).get();
		
		assertEquals(result, new LocalDate(calendar));
	}

	@Test
	public void testFromCalendarDateTimeZone() {
		Calendar calendar = Calendar.getInstance();
		LocalDate result = Op.on(calendar).exec(FnToLocalDate.fromCalendar(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new LocalDate(calendar, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromCalendarChronology() {
		Calendar calendar = Calendar.getInstance();
		LocalDate result = Op.on(calendar).exec(FnToLocalDate.fromCalendar(
				GJChronology.getInstance())).get();
		
		assertEquals(result, new LocalDate(calendar, GJChronology.getInstance()));
	}

}
