package org.op4j.jodatime.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;
import org.op4j.jodatime.functions.FnJodaToString;
import org.op4j.jodatime.functions.FnJodaToString.FormatType;

public class JodaToStringTest extends TestCase {

    @Test
    public void testFromBaseDateTime() {
        // Convert DateTime
        List<DateTime> targets = new ArrayList<DateTime>();
        targets.add(new DateTime());
        List<String> result = Op.onList(targets).forEach().exec(FnJodaToString.fromBaseDateTime()).get();
        
        assertEquals(targets.get(0).toString(),
                result.get(0));
    }
    
	@Test
	public void testFromBaseDateTimeFormatTypeString() {
		// Convert DateTime
		List<DateTime> targets = new ArrayList<DateTime>();
		targets.add(new DateTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString.fromBaseDateTime(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
	}

	@Test
	public void testFromBaseDateTimeFormatTypeStringLocale() {
		// Convert DateMidnight
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromBaseDateTime(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
	}

	@Test
	public void testFromBaseDateTimeFormatTypeStringChronology() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromBaseDateTime(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("MM").withChronology(GregorianChronology.getInstance())),
				result.get(0)));
		
		try {
			Op.onList(targets).forEach().exec(FnJodaToString
				.fromBaseDateTime(null, "MM", BuddhistChronology.getInstance()));
			fail("conversion can't be done if formatType is null");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromBaseDateTimeFormatTypeStringString() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromBaseDateTime(FormatType.STYLE, "MM", Locale.UK.toString())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withLocale(Locale.UK)),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("ML").withLocale(Locale.UK)),
				result.get(0)));
	}

	@Test
	public void testFromBaseDateTimeDateTimeFormatter() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromBaseDateTime(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));		
	}
	
	@Test
    public void testFromLocalTime() {
        List<LocalTime> targets = new ArrayList<LocalTime>();
        targets.add(new LocalTime());
        List<String> result = Op.onList(targets).forEach().exec(FnJodaToString.fromLocalTime()).get();
        
        assertEquals(targets.get(0).toString(),
                result.get(0));
    }
	
	@Test
	public void testFromLocalTimeFormatTypeString() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString.fromLocalTime(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
	}

	@Test
	public void testFromLocalTimeFormatTypeStringLocale() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalTime(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
		
		try {
			Op.onList(targets).forEach().exec(FnJodaToString
					.fromLocalTime(FormatType.PATTERN, null, Locale.UK));
			fail("conversion can't be done if pattern is null");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromLocalTimeFormatTypeStringChronology() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalTime(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
	}

	@Test
	public void testFromLocalTimeFormatTypeStringString() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalTime(FormatType.STYLE, "MM", Locale.UK.toString())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withLocale(Locale.UK)),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("ML").withLocale(Locale.UK)),
				result.get(0)));
		
		try {
			Op.onList(targets).forEach().exec(FnJodaToString
					.fromLocalTime(FormatType.STYLE, "MM", ""));
			fail("conversion can't be done if locale is empty");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testFromLocalTimeDateTimeFormatter() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalTime(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));		
	}
	
	@Test
    public void testFromLocalDate() {
        List<LocalDate> targets = new ArrayList<LocalDate>();
        targets.add(new LocalDate());
        List<String> result = Op.onList(targets).forEach().exec(FnJodaToString.fromLocalDate()).get();
        
        assertEquals(targets.get(0).toString(),
                result.get(0));
    }
	
	@Test
	public void testFromLocalDateFormatTypeString() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString.fromLocalDate(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
	}

	@Test
	public void testFromLocalDateFormatTypeStringLocale() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalDate(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
	}

	@Test
	public void testFromLocalDateFormatTypeStringChronology() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalDate(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
	}

	@Test
	public void testFromLocalDateFormatTypeStringString() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalDate(FormatType.STYLE, "MM", Locale.UK.toString())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withLocale(Locale.UK)),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("ML").withLocale(Locale.UK)),
				result.get(0)));
	}

	@Test
	public void testFromLocalDateDateTimeFormatter() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaToString
				.fromLocalDate(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));		
	}
}
