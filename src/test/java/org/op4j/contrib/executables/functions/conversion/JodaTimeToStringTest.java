package org.op4j.contrib.executables.functions.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.op4j.Op;
import org.op4j.contrib.executables.functions.conversion.JodaTimeToString.FormatType;

public class JodaTimeToStringTest {

	@Test
	public void testFromBaseDateTimeFormatTypeString() {
		// Convert DateTime
		List<DateTime> targets = new ArrayList<DateTime>();
		targets.add(new DateTime());
		List<String> result = Op.onList(targets).forEach().exec(JodaTimeToString.fromBaseDateTime(FormatType.PATTERN, 
				"yyyy-MM-DD_HH:mm:ss:SS")).get();
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS"),
				result.get(0));
	}

	@Test
	public void testFromBaseDateTimeFormatTypeStringLocale() {
		// Convert DateMidnight
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(JodaTimeToString
				.fromBaseDateTime(FormatType.PATTERN, "yyyy-MM-DD_HH:mm:ss:SS", Locale.UK)).get();	
		
		assertEquals(targets.get(0).toString("yyyy-MM-DD_HH:mm:ss:SS", Locale.UK),
				result.get(0));
	}

	@Test
	public void testFromBaseDateTimeFormatTypeStringChronology() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(JodaTimeToString
				.fromBaseDateTime(FormatType.STYLE, "MM", BuddhistChronology.getInstance())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.forStyle("MM").withChronology(BuddhistChronology.getInstance())),
				result.get(0));
		assertFalse(StringUtils.equals(
				targets.get(0).toString(DateTimeFormat.forStyle("MM").withChronology(GregorianChronology.getInstance())),
				result.get(0)));
	}

	@Test
	public void testFromBaseDateTimeFormatTypeStringString() {
		// Convert DateMidnight 
		List<DateMidnight> targets = new ArrayList<DateMidnight>();
		targets.add(new DateMidnight());
		List<String> result = Op.onList(targets).forEach().exec(JodaTimeToString
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
		List<String> result = Op.onList(targets).forEach().exec(JodaTimeToString
				.fromBaseDateTime(DateTimeFormat.fullDateTime())).get();	
		
		assertEquals(targets.get(0).toString(
				DateTimeFormat.fullDateTime()),
				result.get(0));		
	}
}
