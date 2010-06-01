package org.op4j.jodatime.functions;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;
import org.op4j.exceptions.ExecutionException;

public class DateMidnightTest extends TestCase {

	@Test
	public void testFromStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testFromStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				DateTimeZone.UTC)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.UTC)
				.parseDateTime(asStr).toDateMidnight());	
	}

	@Test
	public void testFromStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testFromStringStringLocale() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				Locale.CANADA)).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr).toDateMidnight());
		
		try {
			Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(null,
					Locale.CANADA));
			fail("conversion can't be done if pattern is empty");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromStringStringString() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				Locale.CANADA.toString())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testFromStringStringLocaleDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				Locale.CANADA, DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testFromStringStringStringDateTimeZone() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-23:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				Locale.CANADA.toString(), DateTimeZone.getDefault())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withZone(DateTimeZone.getDefault())
				.parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testFromStringStringLocaleChronology() {
		String pattern = "dd/mm/yyyy-HH:mm";
		String asStr = "24/12/2000-15:03";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				Locale.CANADA, BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testFromStringStringStringChronology() {
		String pattern = "dd/mm/yyyy-HH:mm:ss";
		String asStr = "24/12/2000-00:03:33";
		DateMidnight result = Op.on(asStr).exec(FnDateMidnight.strToDateMidnight(pattern,
				Locale.CANADA.toString(), BuddhistChronology.getInstance())).get();
		
		assertEquals(result, DateTimeFormat.forPattern(pattern).withLocale(Locale.CANADA)
				.withChronology(BuddhistChronology.getInstance())
				.parseDateTime(asStr).toDateMidnight());
	}

	@Test
	public void testdateToDateMidnight() {
		Date date = new Date();
		DateMidnight result = Op.on(date).exec(FnDateMidnight.dateToDateMidnight()).get();
		
		assertEquals(result, new DateMidnight(date));
	}

	@Test
	public void testFromDateDateTimeZone() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		DateMidnight result = Op.on(date).exec(FnDateMidnight.dateToDateMidnight(DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateMidnight(date, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateChronology() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		DateMidnight result = Op.on(date).exec(FnDateMidnight.dateToDateMidnight(BuddhistChronology.getInstance())).get();
		
		assertEquals(result, new DateMidnight(date, BuddhistChronology.getInstance()));
	}

	@Test
	public void testtimestampToDateMidnight() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		DateMidnight result = Op.on(timestamp).exec(FnDateMidnight.timestampToDateMidnight()).get();
		
		assertEquals(result, new DateMidnight(timestamp));	
	}

	@Test
	public void testFromTimestampDateTimeZone() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		DateMidnight result = Op.on(timestamp).exec(FnDateMidnight.timestampToDateMidnight(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateMidnight(timestamp, DateTimeZone.getDefault()));	
	}

	@Test
	public void testFromTimestampChronology() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		DateMidnight result = Op.on(timestamp).exec(FnDateMidnight.timestampToDateMidnight(CopticChronology.getInstance())).get();
		
		assertEquals(result, new DateMidnight(timestamp, CopticChronology.getInstance()));	
	}

	@Test
	public void testFromLong() {
		long dateAsLong = new Date().getTime();
		DateMidnight result = Op.on(Long.valueOf(dateAsLong)).exec(FnDateMidnight.longToDateMidnight()).get();
		
		assertEquals(result, new DateMidnight(dateAsLong));
	}

	@Test
	public void testFromLongDateTimeZone() {
		long dateAsLong = new Date().getTime();
		DateMidnight result = Op.on(Long.valueOf(dateAsLong)).exec(FnDateMidnight.longToDateMidnight(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateMidnight(dateAsLong, DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongChronology() {
		long dateAsLong = new Date().getTime();
		DateMidnight result = Op.on(Long.valueOf(dateAsLong)).exec(FnDateMidnight.longToDateMidnight(
				CopticChronology.getInstance())).get();
		
		assertEquals(result, new DateMidnight(dateAsLong, CopticChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Integer year = Integer.valueOf(2008);
		Integer month = Integer.valueOf(12);
		Integer day = Integer.valueOf(8);
		
		DateMidnight result = Op.on(Arrays.asList(year, month, day))
			.exec(FnDateMidnight.integerFieldCollectionToDateMidnight())
			.get();
	
		assertEquals(result,
				new DateMidnight(year.intValue(), month.intValue(), day.intValue()));
	}

	@Test
	public void testFromIntegerFieldListChronology() {
		Integer year = Integer.valueOf(1985);
		Integer month = Integer.valueOf(1);
		Integer day = Integer.valueOf(25);
		
		DateMidnight result = Op.on(Arrays.asList(year, month, day))
			.exec(FnDateMidnight.integerFieldCollectionToDateMidnight(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateMidnight(year.intValue(), month.intValue(), day.intValue(),
						BuddhistChronology.getInstance()));
		
		try {
			Op.on(Arrays.asList(year, month, day, Integer.valueOf(4)))
				.exec(FnDateMidnight.integerFieldCollectionToDateMidnight(BuddhistChronology.getInstance()))
				.get();
			fail("fromIntegerFieldList should not accept an integer list with more than three elements");
		} catch (ExecutionException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromIntegerFieldArray() {
		Integer year = Integer.valueOf(16);
		Integer month = Integer.valueOf(3);
		Integer day = Integer.valueOf(16);
		
		DateMidnight result = Op.on(new Integer[] {year, month, day})
			.exec(FnDateMidnight.integerFieldArrayToDateMidnight())
			.get();
	
		assertEquals(result,
				new DateMidnight(year.intValue(), month.intValue(), day.intValue()));		
	}

	@Test
	public void testFromIntegerFieldArrayChronology() {
		Integer year = Integer.valueOf(16);
		Integer month = Integer.valueOf(3);
		Integer day = Integer.valueOf(16);
		
		DateMidnight result = Op.on(new Integer[] {year, month, day})
			.exec(FnDateMidnight.integerFieldArrayToDateMidnight(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateMidnight(year.intValue(), month.intValue(), day.intValue(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromStringFieldList() {
		String year = String.valueOf(1);
		String month = String.valueOf(3);
		String day = String.valueOf(16);
		
		DateMidnight result = Op.on(Arrays.asList(year, month, day))
			.exec(FnDateMidnight.strFieldCollectionToDateMidnight())
			.get();
	
		assertEquals(result,
				new DateMidnight(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
	}

	@Test
	public void testFromStringFieldListChronology() {
		String year = String.valueOf(16);
		String month = String.valueOf(8);
		String day = String.valueOf(16);
		
		DateMidnight result = Op.on(Arrays.asList(year, month, day))
			.exec(FnDateMidnight.strFieldCollectionToDateMidnight(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateMidnight(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void teststrFieldArrayToDateMidnight() {
		String year = String.valueOf(16);
		String month = String.valueOf(4);
		String day = String.valueOf(30);
		
		DateMidnight result = Op.on(new String[] {year, month, day})
			.exec(FnDateMidnight.strFieldArrayToDateMidnight())
			.get();
	
		assertEquals(result,
				new DateMidnight(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day)));
	}

	@Test
	public void teststrFieldArrayToDateMidnightChronology() {
		String year = String.valueOf(16);
		String month = String.valueOf(9);
		String day = String.valueOf(16);
		
		DateMidnight result = Op.on(new String[] {year, month, day})
			.exec(FnDateMidnight.strFieldArrayToDateMidnight(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
				new DateMidnight(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testcalendarToDateMidnight() {
		Calendar calendar = Calendar.getInstance();
		DateMidnight result = Op.on(calendar).exec(FnDateMidnight.calendarToDateMidnight()).get();
		
		assertEquals(result, new DateMidnight(calendar));
	}

	@Test
	public void testcalendarToDateMidnightDateTimeZone() {
		Calendar calendar = Calendar.getInstance();
		DateMidnight result = Op.on(calendar).exec(FnDateMidnight.calendarToDateMidnight(
				DateTimeZone.getDefault())).get();
		
		assertEquals(result, new DateMidnight(calendar, DateTimeZone.getDefault()));
	}

	@Test
	public void testcalendarToDateMidnightChronology() {
		Calendar calendar = Calendar.getInstance();
		DateMidnight result = Op.on(calendar).exec(FnDateMidnight.calendarToDateMidnight(
				GJChronology.getInstance())).get();
		
		assertEquals(result, new DateMidnight(calendar, GJChronology.getInstance()));
	}
}
