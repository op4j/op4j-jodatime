package org.op4j.contrib.executables.functions.conversion;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.op4j.Op;
import org.op4j.exceptions.ExecutionException;
import org.op4j.jodatime.functions.FnJodaTimeUtils;
import org.op4j.jodatime.functions.FnToInterval;

public class ToIntervalTest extends TestCase {

	@Test
	public void testFromStringFieldList() {
		Interval result = Op.on(Arrays.asList("1977", "5", "2", "23", "12", "2", "34",
				"1980", "8", "5", "12", "12", "12", "4"))
			.exec(FnToInterval.fromStringFieldCollection())
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 23, 12, 2, 34), 
					new DateTime(1980, 8, 5, 12, 12, 12, 4)));
	}

	@Test
	public void testFromStringFieldListDateTimeZone() {
		Interval result = Op.on(Arrays.asList("1977", "5", "2", "23", "12", "2", "34",
				"1980", "8", "5", "12", "12", "12", "4"))
			.exec(FnToInterval.fromStringFieldCollection(DateTimeZone.getDefault()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 23, 12, 2, 34, DateTimeZone.getDefault()).getMillis(), 
					new DateTime(1980, 8, 5, 12, 12, 12, 4, DateTimeZone.getDefault()).getMillis(), 
					DateTimeZone.getDefault()));
	}

	@Test
	public void testFromStringFieldListChronology() {
		Interval result = Op.on(Arrays.asList("1977", "5", "2", "23", "12", "2", "34",
				"1980", "8", "5", "12", "12", "12", "4"))
			.exec(FnToInterval.fromStringFieldCollection(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 23, 12, 2, 34, BuddhistChronology.getInstance()).getMillis(), 
					new DateTime(1980, 8, 5, 12, 12, 12, 4, BuddhistChronology.getInstance()).getMillis(), 
					BuddhistChronology.getInstance()));
		
		try {
			Op.on(Arrays.asList("1977", "5", "2", "23", "12", "2", "34",
					"1980", "8", "5", "12", "12", "12"))
				.exec(FnToInterval.fromStringFieldCollection(BuddhistChronology.getInstance())).get();
			fail("fromStringFieldList should not accept list of size 13");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListString() {
		Interval result = Op.on(Arrays.asList("09/02/2000", "05/09/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/mm/yyyy")).get();
		
		DateTimeFormatter f = DateTimeFormat.forPattern("dd/mm/yyyy");
		assertEquals(result, new Interval(f.parseDateTime("09/02/2000"), f.parseDateTime("05/09/2001")));
		
		try {
			Op.on(Arrays.asList("09/02/2000", "05/09/2001", "05/09/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/mm/yyyy")).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringDateTimeZone() {
		Interval result = Op.on(Arrays.asList("09/02/2000", "05/09/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/mm/yyyy", DateTimeZone.getDefault())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/mm/yyyy")
			.withZone(DateTimeZone.getDefault());
		assertEquals(result, new Interval(f.parseDateTime("09/02/2000").getMillis(), 
				f.parseDateTime("05/09/2001").getMillis(), DateTimeZone.getDefault()));

		try {
			Op.on(Arrays.asList("09/02/2000", "05/09/2001", "05/09/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/mm/yyyy", DateTimeZone.getDefault())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringChronology() {
		Interval result = Op.on(Arrays.asList("09/02/2000", "05/09/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/mm/yyyy", BuddhistChronology.getInstance())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/mm/yyyy")
			.withChronology(BuddhistChronology.getInstance());
		assertEquals(result, new Interval(f.parseDateTime("09/02/2000").getMillis(),
				f.parseDateTime("05/09/2001").getMillis(), BuddhistChronology.getInstance()));

		try {
			Op.on(Arrays.asList("09/02/2000", "05/09/2001", "05/09/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/mm/yyyy", BuddhistChronology.getInstance())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringLocale() {
		Interval result = Op.on(Arrays.asList("09/February/2000", "05/March/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK)).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK);
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis()));

		try {
			Op.on(Arrays.asList("09/February/2000", "05/March/2001", "05/December/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK)).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringString() {
		Interval result = Op.on(Arrays.asList("09/February/2000", "05/March/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK.toString())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK);
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis()));

		try {
			Op.on(Arrays.asList("09/February/2000", "05/March/2001", "05/December/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK.toString())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringLocaleDateTimeZone() {
		Interval result = Op.on(Arrays.asList("09/February/2000", "05/March/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK, DateTimeZone.getDefault())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withZone(DateTimeZone.getDefault());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis(), DateTimeZone.getDefault()));

		try {
			Op.on(Arrays.asList("09/February/2000", "05/March/2001", "05/December/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK, DateTimeZone.getDefault())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringStringDateTimeZone() {
		Interval result = Op.on(Arrays.asList("09/February/2000", "05/March/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK.toString(), DateTimeZone.getDefault())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withZone(DateTimeZone.getDefault());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis(), DateTimeZone.getDefault()));

		try {
			Op.on(Arrays.asList("09/February/2000", "05/March/2001", "05/December/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK.toString(), DateTimeZone.getDefault())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringLocaleChronology() {
		Interval result = Op.on(Arrays.asList("09/February/2000", "05/March/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK, JulianChronology.getInstance())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withChronology(JulianChronology.getInstance());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis(), JulianChronology.getInstance()));

		try {
			Op.on(Arrays.asList("09/February/2000", "05/March/2001", "05/December/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK, JulianChronology.getInstance())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldListStringStringChronology() {
		Interval result = Op.on(Arrays.asList("09/February/2000", "05/March/2001"))
			.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK.toString(), JulianChronology.getInstance())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withChronology(JulianChronology.getInstance());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis(), JulianChronology.getInstance()));

		try {
			Op.on(Arrays.asList("09/February/2000", "05/March/2001", "05/December/2001"))
				.exec(FnToInterval.fromStringFieldCollection("dd/MMMM/yyyy", Locale.UK.toString(), JulianChronology.getInstance())).get();
			fail("fromStringFieldList should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArray() {
		Interval result = Op.on(new String[] {"1977", "5", "2", "23", "12", "2", "34",
				"1980", "8", "5", "12", "12", "12", "4"})
			.exec(FnToInterval.fromStringFieldArray())
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 23, 12, 2, 34), 
					new DateTime(1980, 8, 5, 12, 12, 12, 4)));
	}

	@Test
	public void testFromStringFieldArrayDateTimeZone() {
		Interval result = Op.on(new String[] {"1977", "5", "2", "23", "12", "2", "34",
				"1980", "8", "5", "12", "12", "12", "4"})
			.exec(FnToInterval.fromStringFieldArray(DateTimeZone.getDefault()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 23, 12, 2, 34, DateTimeZone.getDefault()).getMillis(), 
					new DateTime(1980, 8, 5, 12, 12, 12, 4, DateTimeZone.getDefault()).getMillis(), 
					DateTimeZone.getDefault()));
	}

	@Test
	public void testFromStringFieldArrayChronology() {
		Interval result = Op.on(new String[] {"1977", "5", "2", "23", "12", "2", "34",
				"1980", "8", "5", "12", "12", "12", "4"})
			.exec(FnToInterval.fromStringFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 23, 12, 2, 34, BuddhistChronology.getInstance()).getMillis(), 
					new DateTime(1980, 8, 5, 12, 12, 12, 4, BuddhistChronology.getInstance()).getMillis(), 
					BuddhistChronology.getInstance()));
		
		try {
			Op.on(new String[] {"1977", "5", "2", "23", "12", "2", "34",
					"1980", "8", "5", "12", "12", "12"})
				.exec(FnToInterval.fromStringFieldArray(BuddhistChronology.getInstance())).get();
			fail("fromStringFieldArray should not accept list of size 13");
		} catch (ExecutionException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromStringFieldArrayString() {
		Interval result = Op.on(new String[] {"09/02/2000", "05/09/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/mm/yyyy")).get();
	
		DateTimeFormatter f = DateTimeFormat.forPattern("dd/mm/yyyy");
		assertEquals(result, new Interval(f.parseDateTime("09/02/2000"), f.parseDateTime("05/09/2001")));

		try {
			Op.on(new String[] {"09/02/2000", "05/09/2001", "05/09/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/mm/yyyy")).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringDateTimeZone() {
		Interval result = Op.on(new String[] {"09/02/2000", "05/09/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/mm/yyyy", DateTimeZone.getDefault())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/mm/yyyy")
			.withZone(DateTimeZone.getDefault());
		assertEquals(result, new Interval(f.parseDateTime("09/02/2000").getMillis(), 
				f.parseDateTime("05/09/2001").getMillis(), DateTimeZone.getDefault()));

		try {
			Op.on(new String[] {"09/02/2000", "05/09/2001", "05/09/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/mm/yyyy", DateTimeZone.getDefault())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringChronology() {
		Interval result = Op.on(new String[] {"09/02/2000", "05/09/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/mm/yyyy", BuddhistChronology.getInstance())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/mm/yyyy")
			.withChronology(BuddhistChronology.getInstance());
		assertEquals(result, new Interval(f.parseDateTime("09/02/2000").getMillis(), 
				f.parseDateTime("05/09/2001").getMillis(), BuddhistChronology.getInstance()));

		try {
			Op.on(new String[] {"09/02/2000", "05/09/2001", "05/09/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/mm/yyyy", BuddhistChronology.getInstance())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringLocale() {
		Interval result = Op.on(new String[] {"09/February/2000", "05/March/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK)).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK);
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis()));

		try {
			Op.on(new String[] {"09/February/2000", "05/March/2001", "05/December/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK)).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringString() {
		Interval result = Op.on(new String[] {"09/February/2000", "05/March/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK.toString())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK);
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis()));

		try {
			Op.on(new String[] {"09/February/2000", "05/March/2001", "05/December/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK.toString())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringLocaleDateTimeZone() {
		Interval result = Op.on(new String[] {"09/February/2000", "05/March/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK, DateTimeZone.getDefault())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withZone(DateTimeZone.getDefault());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis()));

		try {
			Op.on(new String[] {"09/February/2000", "05/March/2001", "05/December/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK, DateTimeZone.getDefault())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringStringDateTimeZone() {
		Interval result = Op.on(new String[] {"09/February/2000", "05/March/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK.toString(), DateTimeZone.getDefault())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withZone(DateTimeZone.getDefault());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis()));

		try {
			Op.on(new String[] {"09/February/2000", "05/March/2001", "05/December/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK.toString(), DateTimeZone.getDefault())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringLocaleChronology() {
		Interval result = Op.on(new String[] {"09/February/2000", "05/March/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK, JulianChronology.getInstance())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withChronology(JulianChronology.getInstance());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis(), JulianChronology.getInstance()));

		try {
			Op.on(new String[] {"09/February/2000", "05/March/2001", "05/December/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK, JulianChronology.getInstance())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromStringFieldArrayStringStringChronology() {
		Interval result = Op.on(new String[] {"09/February/2000", "05/March/2001"})
			.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK.toString(), JulianChronology.getInstance())).get();

		DateTimeFormatter f = DateTimeFormat.forPattern("dd/MMMM/yyyy")
			.withLocale(Locale.UK).withChronology(JulianChronology.getInstance());
		assertEquals(result, new Interval(f.parseDateTime("09/February/2000").getMillis(), 
				f.parseDateTime("05/March/2001").getMillis(), JulianChronology.getInstance()));

		try {
			Op.on(new String[] {"09/February/2000", "05/March/2001", "05/December/2001"})
				.exec(FnToInterval.fromStringFieldArray("dd/MMMM/yyyy", Locale.UK.toString(), JulianChronology.getInstance())).get();
			fail("fromStringFieldArray should not accept a pattern and list of size 3");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromDateFieldList() {
		Date start = new Date();
		Date end = new Date();
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromDateFieldCollection())
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime()));
	}

	@Test
	public void testFromDateFieldListDateTimeZone() {
		Date start = new Date();
		Date end = new Date();
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromDateFieldCollection(
					DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateFieldListChronology() {
		java.sql.Date start = new java.sql.Date(new Date(12233).getTime());
		java.sql.Date end = new java.sql.Date(new Date(99233).getTime());
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromDateFieldCollection(
					BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromDateFieldArray() {
		Date start = new Date();
		Date end = new Date();
		
		Interval result = Op.on(new Date[] {start, end})
			.exec(FnToInterval.fromDateFieldArray())
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime()));
	}

	@Test
	public void testFromDateFieldArrayDateTimeZone() {
		Date start = new Date();
		Date end = new Date();
		
		Interval result = Op.on(new Date[] {start, end})
			.exec(FnToInterval.fromDateFieldArray(
					DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromDateFieldArrayChronology() {
		java.sql.Date start = new java.sql.Date(new Date(12233).getTime());
		java.sql.Date end = new java.sql.Date(new Date(99233).getTime());
		
		Interval result = Op.on(new java.sql.Date[] {start, end})
			.exec(FnToInterval.fromDateFieldArray(
					BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(),
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromTimestampFieldList() {
		Timestamp start = new Timestamp(1000);
		Timestamp end = new Timestamp(1000000);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromTimestampFieldCollection())
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime()));
	}

	@Test
	public void testFromTimestampFieldListDateTimeZone() {
		Timestamp start = new Timestamp(1000);
		Timestamp end = new Timestamp(1000000);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromTimestampFieldCollection(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromTimestampFieldListChronology() {
		Timestamp start = new Timestamp(1000);
		Timestamp end = new Timestamp(1000000);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromTimestampFieldCollection(GJChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(), GJChronology.getInstance()));
	}

	@Test
	public void testFromTimestampFieldArray() {
		Timestamp start = new Timestamp(1000);
		Timestamp end = new Timestamp(1000000);
		
		Interval result = Op.on(new Timestamp[] {start, end})
			.exec(FnToInterval.fromTimestampFieldArray())
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime()));
	}

	@Test
	public void testFromTimestampFieldArrayDateTimeZone() {
		Timestamp start = new Timestamp(1000);
		Timestamp end = new Timestamp(1000000);
		
		Interval result = Op.on(new Timestamp[] {start, end})
			.exec(FnToInterval.fromTimestampFieldArray(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromTimestampFieldArrayChronology() {
		Timestamp start = new Timestamp(1000);
		Timestamp end = new Timestamp(1000000);
		
		Interval result = Op.on(new Timestamp[] {start, end})
			.exec(FnToInterval.fromTimestampFieldArray(GJChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTime(), end.getTime(), GJChronology.getInstance()));
	}

	@Test
	public void testFromLongFieldList() {
		Long start = Long.valueOf(1000);
		Long end = Long.valueOf(1000000);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromLongFieldCollection())
			.get();
		
		assertEquals(result,
				new Interval(start.longValue(), end.longValue()));
	}

	@Test
	public void testFromLongFieldListDateTimeZone() {
		Long start = Long.valueOf(1000);
		Long end = Long.valueOf(1000000);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromLongFieldCollection(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.longValue(), end.longValue(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongFieldListChronology() {
		Long start = Long.valueOf(1000);
		Long end = Long.valueOf(1000000);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromLongFieldCollection(GJChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.longValue(), end.longValue(),
						GJChronology.getInstance()));
	}

	@Test
	public void testFromLongFieldArray() {
		Long start = Long.valueOf(1000);
		Long end = Long.valueOf(1000000);
		
		Interval result = Op.on(new Long[] {start, end})
			.exec(FnToInterval.fromLongFieldArray())
			.get();
		
		assertEquals(result,
				new Interval(start.longValue(), end.longValue()));
	}

	@Test
	public void testFromLongFieldArrayDateTimeZone() {
		Long start = Long.valueOf(1000);
		Long end = Long.valueOf(1000000);
		
		Interval result = Op.on(new Long[] {start, end})
			.exec(FnToInterval.fromLongFieldArray(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.longValue(), end.longValue(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromLongFieldArrayChronology() {
		Long start = Long.valueOf(1000);
		Long end = Long.valueOf(1000000);
		
		Interval result = Op.on(new Long[] {start, end})
			.exec(FnToInterval.fromLongFieldArray(GJChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.longValue(), end.longValue(),
						GJChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Interval result = Op.on(Arrays.asList(Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
				Integer.valueOf(1980), Integer.valueOf(8), Integer.valueOf(5)))
			.exec(FnToInterval.fromIntegerFieldCollection())
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 0, 0, 0, 0), 
					new DateTime(1980, 8, 5, 0, 0, 0, 0)));
	}

	@Test
	public void testFromIntegerFieldListDateTimeZone() {
		Interval result = Op.on(Arrays.asList(Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
				Integer.valueOf(1980), Integer.valueOf(8), Integer.valueOf(5)))
			.exec(FnToInterval.fromIntegerFieldCollection(DateTimeZone.getDefault()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 0, 0, 0, 0, DateTimeZone.getDefault()).getMillis(), 
					new DateTime(1980, 8, 5, 0, 0, 0, 0, DateTimeZone.getDefault()).getMillis(), DateTimeZone.getDefault()));
	}

	@Test
	public void testFromIntegerFieldListChronology() {
		Interval result = Op.on(Arrays.asList(Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
				Integer.valueOf(1980), Integer.valueOf(8), Integer.valueOf(5)))
			.exec(FnToInterval.fromIntegerFieldCollection(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 0, 0, 0, 0, BuddhistChronology.getInstance()).getMillis(), 
					new DateTime(1980, 8, 5, 0, 0, 0, 0, BuddhistChronology.getInstance()).getMillis(), 
					BuddhistChronology.getInstance()));
		
		try {
			Op.on(Arrays.asList(Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
					Integer.valueOf(1980), Integer.valueOf(8)))
				.exec(FnToInterval.fromIntegerFieldCollection(BuddhistChronology.getInstance())).get();
			fail("fromIntegerFieldList should not work with a list of 5 elements");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromIntegerFieldArray() {
		Interval result = Op.on(new Integer[] {Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
				Integer.valueOf(1980), Integer.valueOf(8), Integer.valueOf(5)})
			.exec(FnToInterval.fromIntegerFieldArray())
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 0, 0, 0, 0), 
					new DateTime(1980, 8, 5, 0, 0, 0, 0)));
	}

	@Test
	public void testFromIntegerFieldArrayDateTimeZone() {
		Interval result = Op.on(new Integer[] {Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
				Integer.valueOf(1980), Integer.valueOf(8), Integer.valueOf(5)})
			.exec(FnToInterval.fromIntegerFieldArray(DateTimeZone.getDefault()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 0, 0, 0, 0, DateTimeZone.getDefault()).getMillis(), 
					new DateTime(1980, 8, 5, 0, 0, 0, 0, DateTimeZone.getDefault()).getMillis(), DateTimeZone.getDefault()));
	}

	@Test
	public void testFromIntegerFieldArrayChronology() {
		Interval result = Op.on(new Integer[] {Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2),
				Integer.valueOf(17), Integer.valueOf(35),
				Integer.valueOf(1980), Integer.valueOf(8), Integer.valueOf(5),
				Integer.valueOf(18), Integer.valueOf(20)})
			.exec(FnToInterval.fromIntegerFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(result,
			new Interval(new DateTime(1977, 5, 2, 17, 35, 0, 0, BuddhistChronology.getInstance()).getMillis(), 
					new DateTime(1980, 8, 5, 18, 20, 0, 0, BuddhistChronology.getInstance()).getMillis(), 
					BuddhistChronology.getInstance()));
		
		try {
			Op.on(new Integer[] {Integer.valueOf(1977), Integer.valueOf(5), Integer.valueOf(2), 
					Integer.valueOf(1980), Integer.valueOf(8)})
				.exec(FnToInterval.fromIntegerFieldArray(BuddhistChronology.getInstance())).get();
			fail("fromIntegerFieldList should not work with a list of 5 elements");
		} catch (ExecutionException e) {
			// Do nothing
		}		
	}

	@Test
	public void testFromCalendarFieldList() {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 63);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromCalendarFieldCollection())
			.get();
		
		assertEquals(result,
				new Interval(start.getTimeInMillis(), end.getTimeInMillis()));
	}

	@Test
	public void testFromCalendarFieldListDateTimeZone() {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 63);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromCalendarFieldCollection(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTimeInMillis(), end.getTimeInMillis(),
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromCalendarFieldListChronology() {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 63);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromCalendarFieldCollection(GJChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTimeInMillis(), end.getTimeInMillis(),
						GJChronology.getInstance()));
	}

	@Test
	public void testFromCalendarFieldArray() {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 63);
		
		Interval result = Op.on(new Calendar[] {start, end})
			.exec(FnToInterval.fromCalendarFieldArray())
			.get();
		
		assertEquals(result,
				new Interval(start.getTimeInMillis(), end.getTimeInMillis()));
	}

	@Test
	public void testFromCalendarFieldArrayDateTimeZone() {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 3);
		
		Interval result = Op.on(new Calendar[] {start, end})
			.exec(FnToInterval.fromCalendarFieldArray(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTimeInMillis(), end.getTimeInMillis(),  
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromCalendarFieldArrayChronology() {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 3);
		
		Interval result = Op.on(new Calendar[] {start, end})
			.exec(FnToInterval.fromCalendarFieldArray(BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getTimeInMillis(), end.getTimeInMillis(), 
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromBaseDateTimeFieldList() {
		DateMidnight start = new DateMidnight();
		DateMidnight end = new DateMidnight();
		end.plusDays(3);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromBaseDateTimeFieldCollection())
			.get();
		
		assertEquals(result,
				new Interval(start, end));
	}

	@Test
	public void testFromBaseDateTimeFieldListDateTimeZone() {
		DateTime start = new DateTime();
		DateTime end = new DateTime();
		end.plusHours(3);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromBaseDateTimeFieldCollection(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getMillis(), end.getMillis(), 
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromBaseDateTimeFieldListChronology() {
		DateTime start = new DateTime();
		DateTime end = new DateTime();
		end.plusHours(3);
		
		Interval result = Op.on(Arrays.asList(start, end))
			.exec(FnToInterval.fromBaseDateTimeFieldCollection(BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getMillis(), end.getMillis(), 
						BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromBaseDateTimeFieldArray() {
		DateMidnight start = new DateMidnight();
		DateMidnight end = new DateMidnight();
		end.plusDays(3);
		
		Interval result = Op.on(new DateMidnight[] {start, end})
			.exec(FnToInterval.fromBaseDateTimeFieldArray())
			.get();
		
		assertEquals(result,
				new Interval(start, end));
		
		assertEquals(result,
				Op.on(new DateMidnight[] {start, end})
					.exec(FnJodaTimeUtils.baseDateTimeFieldArrayToInterval())
					.get());
	}

	@Test
	public void testFromBaseDateTimeFieldArrayDateTimeZone() {
		DateTime start = new DateTime();
		DateTime end = new DateTime();
		end.plusHours(3);
		
		Interval result = Op.on(new DateTime[] {start, end})
			.exec(FnToInterval.fromBaseDateTimeFieldArray(DateTimeZone.getDefault()))
			.get();
		
		assertEquals(result,
				new Interval(start.getMillis(), end.getMillis(), 
						DateTimeZone.getDefault()));
	}

	@Test
	public void testFromBaseDateTimeFieldArrayChronology() {
		DateTime start = new DateTime();
		DateTime end = new DateTime();
		end.plusHours(3);
		
		Interval result = Op.on(new DateTime[] {start, end})
			.exec(FnToInterval.fromBaseDateTimeFieldArray(BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(result,
				new Interval(start.getMillis(), end.getMillis(), 
						BuddhistChronology.getInstance()));
		
		assertEquals(result,
				Op.on(new DateTime[] {start, end})
					.exec(FnJodaTimeUtils.baseDateTimeFieldArrayToInterval(BuddhistChronology.getInstance()))
					.get());
		
	}

}
