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
import org.op4j.jodatime.functions.FnJodaString.FormatType;


public class JodaStringTest extends TestCase {

    @Test
    public void testFromBaseDateTime() {
        // Convert DateTime
        List<DateTime> targets = new ArrayList<DateTime>();
        targets.add(new DateTime());
        List<String> result = Op.onList(targets).forEach().exec(FnJodaString.baseDateTimeToStr()).get();
        
        assertEquals(targets.get(0).toString(),
                result.get(0));
    }
    
	@Test
	public void testbaseDateTimeToStrFormatTypeString() {
		// Convert DateTime
		List<DateTime> targets = new ArrayList<DateTime>();
		targets.add(new DateTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString.baseDateTimeToStr(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
		
		result = Op.onList(targets).forEach().exec(FnJodaString.baseDateTimeToStr(FormatType.STYLE, 
		        "L-")).get();
		assertEquals(targets.get(0).toString(DateTimeFormat.forStyle("L-")),
                result.get(0));
	}

	@Test
	public void testbaseDateTimeToStrFormatTypeStringLocale() {
		// Convert DateMidnight
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.baseDateTimeToStr(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
	}

	@Test
	public void testbaseDateTimeToStrFormatTypeStringChronology() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.baseDateTimeToStr(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("MM").withChronology(GregorianChronology.getInstance())),
				result.get(0)));
		
		try {
			Op.onList(targets).forEach().exec(FnJodaString
				.baseDateTimeToStr(null, "MM", BuddhistChronology.getInstance()));
			fail("conversion can't be done if formatType is null");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testbaseDateTimeToStrFormatTypeStringString() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.baseDateTimeToStr(FormatType.STYLE, "MM", Locale.UK.toString())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withLocale(Locale.UK)),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("ML").withLocale(Locale.UK)),
				result.get(0)));
	}

	@Test
	public void testbaseDateTimeToStrDateTimeFormatter() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.baseDateTimeToStr(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));	
		
		result = Op.onList(targets).forEach().exec(FnJodaString
                .baseDateTimeToStr(DateTimeFormat.mediumDate())).get();
		assertEquals(targets.get(0).toString(
                DateTimeFormat.mediumDate()),
                result.get(0));     
	}
	
	@Test
    public void testFromLocalTime() {
        List<LocalTime> targets = new ArrayList<LocalTime>();
        targets.add(new LocalTime());
        List<String> result = Op.onList(targets).forEach().exec(FnJodaString.localTimeToStr()).get();
        
        assertEquals(targets.get(0).toString(),
                result.get(0));
    }
	
	@Test
	public void testlocalTimeToStrFormatTypeString() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString.localTimeToStr(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
	}

	@Test
	public void testlocalTimeToStrFormatTypeStringLocale() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localTimeToStr(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
		
		try {
			Op.onList(targets).forEach().exec(FnJodaString
					.localTimeToStr(FormatType.PATTERN, null, Locale.UK));
			fail("conversion can't be done if pattern is null");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testlocalTimeToStrFormatTypeStringChronology() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localTimeToStr(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
	}

	@Test
	public void testlocalTimeToStrFormatTypeStringString() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localTimeToStr(FormatType.STYLE, "MM", Locale.UK.toString())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withLocale(Locale.UK)),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("ML").withLocale(Locale.UK)),
				result.get(0)));
		
		try {
			Op.onList(targets).forEach().exec(FnJodaString
					.localTimeToStr(FormatType.STYLE, "MM", ""));
			fail("conversion can't be done if locale is empty");
		} catch (IllegalArgumentException e) {
			// Do nothing
		}
	}

	@Test
	public void testlocalTimeToStrDateTimeFormatter() {
		List<LocalTime> targets = new ArrayList<LocalTime>();
		targets.add(new LocalTime());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localTimeToStr(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));		
	}
	
	@Test
    public void testlocalDateToStr() {
        List<LocalDate> targets = new ArrayList<LocalDate>();
        targets.add(new LocalDate());
        List<String> result = Op.onList(targets).forEach().exec(FnJodaString.localDateToStr()).get();
        
        assertEquals(targets.get(0).toString(),
                result.get(0));
    }
	
	@Test
	public void testlocalDateToStrFormatTypeString() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString.localDateToStr(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
	}

	@Test
	public void testlocalDateToStrFormatTypeStringLocale() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localDateToStr(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
	}

	@Test
	public void testlocalDateToStrFormatTypeStringChronology() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localDateToStr(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
	}

	@Test
	public void testlocalDateToStrFormatTypeStringString() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localDateToStr(FormatType.STYLE, "MM", Locale.UK.toString())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withLocale(Locale.UK)),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("ML").withLocale(Locale.UK)),
				result.get(0)));
	}

	@Test
	public void testlocalDateToStrDateTimeFormatter() {
		List<LocalDate> targets = new ArrayList<LocalDate>();
		targets.add(new LocalDate());
		List<String> result = Op.onList(targets).forEach().exec(FnJodaString
				.localDateToStr(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));		
	}
}
