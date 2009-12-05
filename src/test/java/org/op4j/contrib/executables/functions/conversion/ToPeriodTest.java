package org.op4j.contrib.executables.functions.conversion;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.MutableDateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;
import org.op4j.Op;

public class ToPeriodTest extends TestCase {

	@Test
	public void testFromDateFieldList() {
		Date from = new Date();
		Date to = new Date();
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromDateFieldList())
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromDateFieldListChronology() {
		java.sql.Date from = new java.sql.Date(1000);
		java.sql.Date to = new java.sql.Date(100000);	
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromDateFieldList(
					BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromDateFieldListPeriodType() {
		Date from = new Date(1000);
		Date to = new Date(100000);	
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromDateFieldList(
					PeriodType.millis()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.millis()));
		assertFalse(period.equals(
				new Period(from.getTime(), to.getTime(), PeriodType.hours())));
	}

	@Test
	public void testFromDateFieldListPeriodTypeChronology() {
		java.sql.Date from = new java.sql.Date(1000);
		java.sql.Date to = new java.sql.Date(100000);	
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromDateFieldList(PeriodType.weeks(),
					BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.weeks(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromDateFieldArray() {
		Date from = new Date();
		Date to = new Date();
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(new Date[] {from, to})
			.exec(ToPeriod.fromDateFieldArray())
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromDateFieldArrayChronology() {
		java.sql.Date from = new java.sql.Date(1000);
		java.sql.Date to = new java.sql.Date(100000);	
		Period period = Op.on(new java.sql.Date[] {from, to})
			.exec(ToPeriod.fromDateFieldArray(
					GregorianChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromDateFieldArrayPeriodType() {
		Date from = new Date(1000);
		Date to = new Date(100000);	
		Period period = Op.on(new Date[] {from, to})
			.exec(ToPeriod.fromDateFieldArray(
					PeriodType.millis()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.millis()));
		assertFalse(period.equals(
				new Period(from.getTime(), to.getTime(), PeriodType.hours())));
	}

	@Test
	public void testFromDateFieldArrayPeriodTypeChronology() {
		java.sql.Date from = new java.sql.Date(1000);
		java.sql.Date to = new java.sql.Date(100000);	
		Period period = Op.on(new java.sql.Date[] {from, to})
			.exec(ToPeriod.fromDateFieldArray(PeriodType.weeks(),
					BuddhistChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.weeks(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromTimestampFieldList() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromTimestampFieldList())
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromTimestampFieldListChronology() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromTimestampFieldList(CopticChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), CopticChronology.getInstance()));
	}

	@Test
	public void testFromTimestampFieldListPeriodType() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromTimestampFieldList(PeriodType.time()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.time()));
	}

	@Test
	public void testFromTimestampFieldListPeriodTypeChronology() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(Arrays.asList(from, to))
			.exec(ToPeriod.fromTimestampFieldList(PeriodType.time(), CopticChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.time(), CopticChronology.getInstance()));
	}

	@Test
	public void testFromTimestampFieldArray() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(new Timestamp[] {from, to})
			.exec(ToPeriod.fromTimestampFieldArray())
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime()));
	}

	@Test
	public void testFromTimestampFieldArrayChronology() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(new Timestamp[] {from, to})
			.exec(ToPeriod.fromTimestampFieldArray(CopticChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), CopticChronology.getInstance()));
	}

	@Test
	public void testFromTimestampFieldArrayPeriodType() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(new Timestamp[] {from, to})
			.exec(ToPeriod.fromTimestampFieldArray(PeriodType.time()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.time()));
	}

	@Test
	public void testFromTimestampFieldArrayPeriodTypeChronology() {
		Timestamp from = new Timestamp(new Date().getTime());
		Timestamp to = new Timestamp(new Date().getTime());
		to.setTime(from.getTime() + 10000);
		Period period = Op.on(new Timestamp[] {from, to})
			.exec(ToPeriod.fromTimestampFieldArray(PeriodType.time(), CopticChronology.getInstance()))
			.get();
		
		assertEquals(period,
				new Period(from.getTime(), to.getTime(), PeriodType.time(), CopticChronology.getInstance()));
	}
	
	@Test
	public void testFromLong() {
		Long theLong = Long.valueOf(100000);
		Period period = Op.on(theLong)
			.exec(ToPeriod.fromLong())
			.get();
	
		assertEquals(period,
				new Period(theLong.longValue()));
	}

	@Test
	public void testFromLongChronology() {
		Long theLong = Long.valueOf(100000);
		Period period = Op.on(theLong)
			.exec(ToPeriod.fromLong(CopticChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(theLong.longValue(), CopticChronology.getInstance()));
	}

	@Test
	public void testFromLongPeriodType() {
		Long theLong = Long.valueOf(100000);
		Period period = Op.on(theLong)
			.exec(ToPeriod.fromLong(PeriodType.days()))
			.get();
	
		assertEquals(period,
				new Period(theLong.longValue(), PeriodType.days()));
	}

	@Test
	public void testFromLongPeriodTypeChronology() {
		Long theLong = Long.valueOf(100000);
		Period period = Op.on(theLong)
			.exec(ToPeriod.fromLong(PeriodType.days(), CopticChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(theLong.longValue(), PeriodType.days(), CopticChronology.getInstance()));
	}

	@Test
	public void testFromLongFieldList() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(Arrays.asList(theLong1, theLong2))
			.exec(ToPeriod.fromLongFieldList())
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue()));
	}

	@Test
	public void testFromLongFieldListChronology() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(Arrays.asList(theLong1, theLong2))
			.exec(ToPeriod.fromLongFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromLongFieldListPeriodType() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(Arrays.asList(theLong1, theLong2))
			.exec(ToPeriod.fromLongFieldList(PeriodType.minutes()))
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue(), PeriodType.minutes()));
	}

	@Test
	public void testFromLongFieldListPeriodTypeChronology() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(Arrays.asList(theLong1, theLong2))
			.exec(ToPeriod.fromLongFieldList(PeriodType.minutes(), BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue(), PeriodType.minutes(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromLongFieldArray() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(new Long[] {theLong1, theLong2})
			.exec(ToPeriod.fromLongFieldArray())
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue()));
	}

	@Test
	public void testFromLongFieldArrayChronology() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(new Long[] {theLong1, theLong2})
			.exec(ToPeriod.fromLongFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromLongFieldArrayPeriodType() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(new Long[] {theLong1, theLong2})
			.exec(ToPeriod.fromLongFieldArray(PeriodType.minutes()))
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue(), PeriodType.minutes()));
	}

	@Test
	public void testFromLongFieldArrayPeriodTypeChronology() {
		Long theLong1 = Long.valueOf(100000);
		Long theLong2 = Long.valueOf(300000);
		Period period = Op.on(new Long[] {theLong1, theLong2})
			.exec(ToPeriod.fromLongFieldArray(PeriodType.minutes(), BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(theLong1.longValue(), theLong2.longValue(), PeriodType.minutes(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendarFieldList() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(Arrays.asList(cal1, cal2))
			.exec(ToPeriod.fromCalendarFieldList())
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis()));
	}

	@Test 
	public void testFromCalendarFieldListChronology() {
		GregorianCalendar cal1 = (GregorianCalendar)Calendar.getInstance();
		GregorianCalendar cal2 = (GregorianCalendar)Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(Arrays.asList(cal1, cal2))
			.exec(ToPeriod.fromCalendarFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendarFieldListPeriodType() {
		GregorianCalendar cal1 = (GregorianCalendar)Calendar.getInstance();
		GregorianCalendar cal2 = (GregorianCalendar)Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(Arrays.asList(cal1, cal2))
			.exec(ToPeriod.fromCalendarFieldList(PeriodType.dayTime()))
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis(), PeriodType.dayTime()));
	}

	@Test
	public void testFromCalendarFieldListPeriodTypeChronology() {
		GregorianCalendar cal1 = (GregorianCalendar)Calendar.getInstance();
		GregorianCalendar cal2 = (GregorianCalendar)Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(Arrays.asList(cal1, cal2))
			.exec(ToPeriod.fromCalendarFieldList(PeriodType.dayTime(), BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis(), PeriodType.dayTime(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendarFieldArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(new Calendar[] {cal1, cal2})
			.exec(ToPeriod.fromCalendarFieldArray())
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis()));
	}

	@Test
	public void testFromCalendarFieldArrayChronology() {
		GregorianCalendar cal1 = (GregorianCalendar)Calendar.getInstance();
		GregorianCalendar cal2 = (GregorianCalendar)Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(new GregorianCalendar[] {cal1, cal2})
			.exec(ToPeriod.fromCalendarFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromCalendarFieldArrayPeriodType() {
		GregorianCalendar cal1 = (GregorianCalendar)Calendar.getInstance();
		GregorianCalendar cal2 = (GregorianCalendar)Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(new GregorianCalendar[] {cal1, cal2})
			.exec(ToPeriod.fromCalendarFieldArray(PeriodType.dayTime()))
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis(), PeriodType.dayTime()));
	}

	@Test
	public void testFromCalendarFieldArrayPeriodTypeChronology() {
		GregorianCalendar cal1 = (GregorianCalendar)Calendar.getInstance();
		GregorianCalendar cal2 = (GregorianCalendar)Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_YEAR, 20);
		Period period = Op.on(new Calendar[] {cal1, cal2})
			.exec(ToPeriod.fromCalendarFieldArray(PeriodType.dayTime(), BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(cal1.getTimeInMillis(), cal2.getTimeInMillis(), PeriodType.dayTime(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromBaseDateTimeFieldList() {
		DateTime first = new DateTime();
		DateTime second = new DateTime();
		second.plusWeeks(10);
		Period period = Op.on(Arrays.asList(first, second))
			.exec(ToPeriod.fromBaseDateTimeFieldList())
			.get();
	
		assertEquals(period,
				new Period(first, second));
	}

	@Test
	public void testFromBaseDateTimeFieldListChronology() {
		DateMidnight first = new DateMidnight();
		DateMidnight second = new DateMidnight();
		second.plusWeeks(10);
		Period period = Op.on(Arrays.asList(first, second))
			.exec(ToPeriod.fromBaseDateTimeFieldList(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(first.getMillis(), second.getMillis(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromBaseDateTimeFieldListPeriodType() {
		DateMidnight first = new DateMidnight();
		DateMidnight second = new DateMidnight();
		second.plusWeeks(10);
		Period period = Op.on(Arrays.asList(first, second))
			.exec(ToPeriod.fromBaseDateTimeFieldList(PeriodType.minutes()))
			.get();
	
		assertEquals(period,
				new Period(first.getMillis(), second.getMillis(), PeriodType.minutes()));
	}

	@Test
	public void testFromBaseDateTimeFieldListPeriodTypeChronology() {
		MutableDateTime first = new MutableDateTime();
		MutableDateTime second = new MutableDateTime();
		second.addWeeks(10);
		Period period = Op.on(Arrays.asList(first, second))
			.exec(ToPeriod.fromBaseDateTimeFieldList(PeriodType.minutes(), BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(first.getMillis(), second.getMillis(), PeriodType.minutes(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromBaseDateTimeFieldArray() {
		DateTime first = new DateTime();
		DateTime second = new DateTime();
		second.plusWeeks(10);
		Period period = Op.on(new DateTime[] {first, second})
			.exec(ToPeriod.fromBaseDateTimeFieldArray())
			.get();
	
		assertEquals(period,
				new Period(first, second));
	}

	@Test
	public void testFromBaseDateTimeFieldArrayChronology() {
		DateMidnight first = new DateMidnight();
		DateMidnight second = new DateMidnight();
		second.plusWeeks(10);
		Period period = Op.on(new DateMidnight[] {first, second})
			.exec(ToPeriod.fromBaseDateTimeFieldArray(BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(first.getMillis(), second.getMillis(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromBaseDateTimeFieldArrayPeriodType() {
		DateMidnight first = new DateMidnight();
		DateMidnight second = new DateMidnight();
		second.plusWeeks(10);
		Period period = Op.on(new DateMidnight[] {first, second})
			.exec(ToPeriod.fromBaseDateTimeFieldArray(PeriodType.minutes()))
			.get();
	
		assertEquals(period,
				new Period(first.getMillis(), second.getMillis(), PeriodType.minutes()));
	}

	@Test
	public void testFromBaseDateTimeFieldArrayPeriodTypeChronology() {
		MutableDateTime first = new MutableDateTime();
		MutableDateTime second = new MutableDateTime();
		second.addWeeks(10);
		Period period = Op.on(new MutableDateTime[] {first, second})
			.exec(ToPeriod.fromBaseDateTimeFieldArray(PeriodType.minutes(), BuddhistChronology.getInstance()))
			.get();
	
		assertEquals(period,
				new Period(first.getMillis(), second.getMillis(), PeriodType.minutes(), BuddhistChronology.getInstance()));
	}

	@Test
	public void testFromIntegerFieldList() {
		Integer hours = Integer.valueOf(3);
		Integer minutes = Integer.valueOf(30);
		Integer secs = Integer.valueOf(13);
		Integer millis = Integer.valueOf(22);
		
		Period period = Op.on(Arrays.asList(hours, minutes, secs, millis))
			.exec(ToPeriod.fromIntegerFieldList())
			.get();
	
		assertEquals(period,
				new Period(hours.intValue(), minutes.intValue(), secs.intValue(), millis.intValue()));
	}

	@Test
	public void testFromIntegerFieldListPeriodType() {
		Integer hours = Integer.valueOf(3);
		Integer minutes = Integer.valueOf(30);
		
		Period period = Op.on(Arrays.asList(hours, minutes, Integer.valueOf(0), Integer.valueOf(0)))
			.exec(ToPeriod.fromIntegerFieldList(PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
					DurationFieldType.minutes()})))
			.get();
	
		assertEquals(period,
				new Period(0, 0, 0, 0, hours.intValue(), minutes.intValue(), 0, 0,
						PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
								DurationFieldType.minutes()})));
	}

	@Test
	public void testFromIntegerFieldArray() {
		Integer hours = Integer.valueOf(3);
		Integer minutes = Integer.valueOf(30);
		Integer secs = Integer.valueOf(13);
		Integer millis = Integer.valueOf(22);
		
		Period period = Op.on(new Integer[] {hours, minutes, secs, millis})
			.exec(ToPeriod.fromIntegerFieldArray())
			.get();
	
		assertEquals(period,
				new Period(hours.intValue(), minutes.intValue(), secs.intValue(), millis.intValue()));
	}

	@Test
	public void testFromIntegerFieldArrayPeriodType() {
		Integer hours = Integer.valueOf(3);
		Integer minutes = Integer.valueOf(30);
		
		Period period = Op.on(new Integer[] {hours, minutes, Integer.valueOf(0), Integer.valueOf(0)})
			.exec(ToPeriod.fromIntegerFieldArray(PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
					DurationFieldType.minutes()})))
			.get();
	
		assertEquals(period,
				new Period(0, 0, 0, 0, hours.intValue(), minutes.intValue(), 0, 0,
						PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
								DurationFieldType.minutes()})));
	}

	@Test
	public void testFromStringFieldList() {
		String hours = "3";
		String minutes = "30";
		String secs = "13";
		String millis = "22";
		
		Period period = Op.on(Arrays.asList(hours, minutes, secs, millis))
			.exec(ToPeriod.fromStringFieldList())
			.get();
	
		assertEquals(period,
				new Period(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(secs), Integer.parseInt(millis)));
	}

	@Test
	public void testFromStringFieldListPeriodType() {
		String hours = "3";
		String minutes = "30";
		
		Period period = Op.on(Arrays.asList(hours, minutes, "0", "0"))
			.exec(ToPeriod.fromStringFieldList(PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
					DurationFieldType.minutes()})))
			.get();
	
		assertEquals(period,
				new Period(0, 0, 0, 0, Integer.parseInt(hours), Integer.parseInt(minutes), 0, 0,
						PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
								DurationFieldType.minutes()})));
	}

	@Test
	public void testFromStringFieldArray() {
		String hours = "3";
		String minutes = "30";
		String secs = "13";
		String millis = "22";
		
		Period period = Op.on(new String[] {hours, minutes, secs, millis})
			.exec(ToPeriod.fromStringFieldArray())
			.get();
	
		assertEquals(period,
				new Period(Integer.parseInt(hours), Integer.parseInt(minutes),
						Integer.parseInt(secs), Integer.parseInt(millis)));
	}

	@Test
	public void testFromStringFieldArrayPeriodType() {
		String hours = "3";
		String minutes = "30";
		
		Period period = Op.on(new String[] {hours, minutes, "0", "0"})
			.exec(ToPeriod.fromStringFieldArray(PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
					DurationFieldType.minutes()})))
			.get();
	
		assertEquals(period,
				new Period(0, 0, 0, 0, Integer.parseInt(hours), Integer.parseInt(minutes), 0, 0,
						PeriodType.forFields(new DurationFieldType[] {DurationFieldType.hours(),
								DurationFieldType.minutes()})));
	}

}
