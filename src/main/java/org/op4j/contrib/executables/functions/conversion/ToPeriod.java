/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */

package org.op4j.contrib.executables.functions.conversion;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToPeriod {

	private static final FromDateFieldList FROM_DATE_FIELD_LIST = new FromDateFieldList();
	private static final FromDateFieldArray FROM_DATE_FIELD_ARRAY = new FromDateFieldArray();
	
	private static final FromTimestampFieldList FROM_TIMESTAMP_FIELD_LIST = new FromTimestampFieldList();
	private static final FromTimestampFieldArray FROM_TIMESTAMP_FIELD_ARRAY = new FromTimestampFieldArray();
	
	private static final FromLong FROM_LONG = new FromLong();
	
	private static final FromLongFieldList FROM_LONG_FIELD_LIST = new FromLongFieldList();
	private static final FromLongFieldArray FROM_LONG_FIELD_ARRAY = new FromLongFieldArray();
	
	private static final FromCalendarFieldList FROM_CALENDAR_FIELD_LIST = new FromCalendarFieldList();
	private static final FromCalendarFieldArray FROM_CALENDAR_FIELD_ARRAY = new FromCalendarFieldArray();
	
	private static final FromDateTimeFieldList FROM_DATETIME_FIELD_LIST = new FromDateTimeFieldList();
	private static final FromDateTimeFieldArray FROM_DATETIME_FIELD_ARRAY = new FromDateTimeFieldArray();
	
	private static final FromIntegerFieldList FROM_INTEGER_FIELD_LIST = new FromIntegerFieldList();
	private static final FromIntegerFieldArray FROM_INTEGER_FIELD_ARRAY = new FromIntegerFieldArray();
	
	private static final FromStringFieldList FROM_STRING_FIELD_LIST = new FromStringFieldList();
	private static final FromStringFieldArray FROM_STRING_FIELD_ARRAY = new FromStringFieldArray();
	
	
	private ToPeriod() {
		super();
	}
	
	// Conversion from two date objects
	public static final FromDateFieldList fromDateFieldList() {
		return FROM_DATE_FIELD_LIST;
	}	
	public static final FromDateFieldList fromDateFieldList(final Chronology chronology) {
		return new FromDateFieldList(chronology);
	}	
	public static final FromDateFieldList fromDateFieldList(final PeriodType periodType) {
		return new FromDateFieldList(periodType);
	}
	public static final FromDateFieldArray fromDateFieldArray() {
		return FROM_DATE_FIELD_ARRAY;
	}	
	public static final FromDateFieldArray fromDateFieldArray(final Chronology chronology) {
		return new FromDateFieldArray(chronology);
	}	
	public static final FromDateFieldArray fromDateFieldArray(final PeriodType periodType) {
		return new FromDateFieldArray(periodType);
	}
	//
	
	// Conversion from two timestamp objects
	public static final FromTimestampFieldList fromTimestampFieldList() {
		return FROM_TIMESTAMP_FIELD_LIST;
	}	
	public static final FromTimestampFieldList fromTimestampFieldList(final Chronology chronology) {
		return new FromTimestampFieldList(chronology);
	}	
	public static final FromTimestampFieldList fromTimestampFieldList(final PeriodType periodType) {
		return new FromTimestampFieldList(periodType);
	}
	public static final FromTimestampFieldArray fromTimestampFieldArray() {
		return FROM_TIMESTAMP_FIELD_ARRAY;
	}	
	public static final FromTimestampFieldArray fromTimestampFieldArray(final Chronology chronology) {
		return new FromTimestampFieldArray(chronology);
	}	
	public static final FromTimestampFieldArray fromTimestampFieldArray(final PeriodType periodType) {
		return new FromTimestampFieldArray(periodType);
	}
	//
	
	// Conversion from Long
	public static final FromLong fromLong() {
		return FROM_LONG;
	}
	public static final FromLong fromLong(final Chronology chronology) {
		return new FromLong(chronology);
	}
	public static final FromLong fromLong(final PeriodType periodType) {
		return new FromLong(periodType);
	}
	public static final FromLong fromLong(final PeriodType periodType, final Chronology chronology) {
		return new FromLong(periodType, chronology);
	}
	//
	
	// Conversion from two long objects
	public static final FromLongFieldList fromLongFieldList() {
		return FROM_LONG_FIELD_LIST;
	}	
	public static final FromLongFieldList fromLongFieldList(final Chronology chronology) {
		return new FromLongFieldList(chronology);
	}	
	public static final FromLongFieldList fromLongFieldList(final PeriodType periodType) {
		return new FromLongFieldList(periodType);
	}
	public static final FromLongFieldList fromLongFieldList(final PeriodType periodType, final Chronology chronology) {
		return new FromLongFieldList(periodType, chronology);
	}
	public static final FromLongFieldArray fromLongFieldArray() {
		return FROM_LONG_FIELD_ARRAY;
	}	
	public static final FromLongFieldArray fromLongFieldArray(final Chronology chronology) {
		return new FromLongFieldArray(chronology);
	}	
	public static final FromLongFieldArray fromLongFieldArray(final PeriodType periodType) {
		return new FromLongFieldArray(periodType);
	}
	public static final FromLongFieldArray fromLongFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new FromLongFieldArray(periodType, chronology);
	}
	//
	
	// Conversion from two calendar objects
	public static final FromCalendarFieldList fromCalendarFieldList() {
		return FROM_CALENDAR_FIELD_LIST;
	}	
	public static final FromCalendarFieldList fromCalendarFieldList(final Chronology chronology) {
		return new FromCalendarFieldList(chronology);
	}	
	public static final FromCalendarFieldList fromCalendarFieldList(final PeriodType periodType) {
		return new FromCalendarFieldList(periodType);
	}
	public static final FromCalendarFieldArray fromCalendarFieldArray() {
		return FROM_CALENDAR_FIELD_ARRAY;
	}	
	public static final FromCalendarFieldArray fromCalendarFieldArray(final Chronology chronology) {
		return new FromCalendarFieldArray(chronology);
	}	
	public static final FromCalendarFieldArray fromCalendarFieldArray(final PeriodType periodType) {
		return new FromCalendarFieldArray(periodType);
	}
	//
	
	// Conversion from two datetime objects
	public static final FromDateTimeFieldList fromDateTimeFieldList() {
		return FROM_DATETIME_FIELD_LIST;
	}	
	public static final FromDateTimeFieldList fromDateTimeFieldList(final Chronology chronology) {
		return new FromDateTimeFieldList(chronology);
	}	
	public static final FromDateTimeFieldList fromDateTimeFieldList(final PeriodType periodType) {
		return new FromDateTimeFieldList(periodType);
	}
	public static final FromDateTimeFieldArray fromDateTimeFieldArray() {
		return FROM_DATETIME_FIELD_ARRAY;
	}	
	public static final FromDateTimeFieldArray fromDateTimeFieldArray(final Chronology chronology) {
		return new FromDateTimeFieldArray(chronology);
	}	
	public static final FromDateTimeFieldArray fromDateTimeFieldArray(final PeriodType periodType) {
		return new FromDateTimeFieldArray(periodType);
	}
	//
	
	public static final FromIntegerFieldList fromIntegerFieldList() {
		return FROM_INTEGER_FIELD_LIST;
	}
	public static final FromIntegerFieldList fromIntegerFieldList(PeriodType periodType) {
		return new FromIntegerFieldList(periodType);
	}
	public static final FromIntegerFieldArray fromIntegerFieldArray() {
		return FROM_INTEGER_FIELD_ARRAY;
	}
	public static final FromIntegerFieldArray fromIntegerFieldArray(PeriodType periodType) {
		return new FromIntegerFieldArray(periodType);
	}
	
	
	public static final FromStringFieldList fromStringFieldList() {
		return FROM_STRING_FIELD_LIST;
	}
	public static final FromStringFieldList fromStringFieldList(PeriodType periodType) {
		return new FromStringFieldList(periodType);
	}
	public static final FromStringFieldArray fromStringFieldArray() {
		return FROM_STRING_FIELD_ARRAY;
	}
	public static final FromStringFieldArray fromStringFieldArray(PeriodType periodType) {
		return new FromStringFieldArray(periodType);
	}
	
	
	
	public static final class FromDateFieldList implements IFunc<Period, List<Date>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromDateFieldList() {
			super();			
		}		
		
		public FromDateFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromDateFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Date> dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromDateFieldArray implements IFunc<Period, Date[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromDateFieldArray() {
			super();			
		}		
		
		public FromDateFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromDateFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Date[] dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromTimestampFieldList implements IFunc<Period, List<Timestamp>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromTimestampFieldList() {
			super();			
		}		
		
		public FromTimestampFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromTimestampFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Timestamp> dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromTimestampFieldArray implements IFunc<Period, Timestamp[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromTimestampFieldArray() {
			super();			
		}		
		
		public FromTimestampFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromTimestampFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Timestamp[] dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromLong implements IFunc<Period, Long> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromLong() {
			super();			
		}		
		
		public FromLong(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromLong(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public FromLong(PeriodType periodType, Chronology chronology) {
			super();	
			this.periodType = periodType;
			this.chronology = chronology;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Long theLong) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromLongFieldList implements IFunc<Period, List<Long>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromLongFieldList() {
			super();			
		}		
		
		public FromLongFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromLongFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public FromLongFieldList(PeriodType periodType, Chronology chronology) {
			super();		
			this.periodType = periodType;
			this.chronology = chronology;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Long> longs) throws Exception {
			if (longs.size() != 2 ) {
				throw new FunctionExecutionException(
						"Long arguments list for Period conversion should of sizes " +
						"2. Size " + longs.size() + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(longs.get(0).longValue(), longs.get(1).longValue(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(longs.get(0).longValue(), longs.get(1).longValue(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(longs.get(0).longValue(), longs.get(1).longValue(), this.chronology);
			}
			return new Period(longs.get(0).longValue(), longs.get(1).longValue());
		}		
	}	
	
	public static final class FromLongFieldArray implements IFunc<Period, Long[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromLongFieldArray() {
			super();			
		}		
		
		public FromLongFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromLongFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public FromLongFieldArray(PeriodType periodType, Chronology chronology) {
			super();		
			this.periodType = periodType;
			this.chronology = chronology;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Long[] longs) throws Exception {
			if (longs.length != 2 ) {
				throw new FunctionExecutionException(
						"Long arguments array for Period conversion should of sizes " +
						"2. Size " + longs.length + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(longs[0].longValue(), longs[1].longValue(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(longs[0].longValue(), longs[1].longValue(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(longs[0].longValue(), longs[1].longValue(), this.chronology);
			}
			return new Period(longs[0].longValue(), longs[1].longValue());
		}		
	}	
	 
	public static final class FromCalendarFieldList implements IFunc<Period, List<Calendar>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromCalendarFieldList() {
			super();			
		}		
		
		public FromCalendarFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromCalendarFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Calendar> calendars) throws Exception {
			if (calendars.size() != 2 ) {
				throw new FunctionExecutionException(
						"Calendar arguments list for Period conversion should of sizes " +
						"2. Size " + calendars.size() + " is not valid.");
			}
			if (this.periodType != null) {
				return new Period(calendars.get(0).getTimeInMillis(), calendars.get(1).getTimeInMillis(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(calendars.get(0).getTimeInMillis(), calendars.get(1).getTimeInMillis(), this.chronology);
			}
			return new Period(calendars.get(0).getTimeInMillis(), calendars.get(1).getTimeInMillis());
		}		
	}	
	
	public static final class FromCalendarFieldArray implements IFunc<Period, Calendar[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromCalendarFieldArray() {
			super();			
		}		
		
		public FromCalendarFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromCalendarFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Calendar[] calendars) throws Exception {
			if (calendars.length != 2 ) {
				throw new FunctionExecutionException(
						"Calendar arguments array for Period conversion should of sizes " +
						"2. Size " + calendars.length + " is not valid.");
			}
			if (this.periodType != null) {
				return new Period(calendars[0].getTimeInMillis(), calendars[1].getTimeInMillis(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(calendars[0].getTimeInMillis(), calendars[1].getTimeInMillis(), this.chronology);
			}
			return new Period(calendars[0].getTimeInMillis(), calendars[1].getTimeInMillis());
		}		
	}	
	
	public static final class FromDateTimeFieldList implements IFunc<Period, List<DateTime>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromDateTimeFieldList() {
			super();			
		}		
		
		public FromDateTimeFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromDateTimeFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<DateTime> dateTimes) throws Exception {
			if (dateTimes.size() != 2 ) {
				throw new FunctionExecutionException(
						"DateTime arguments list for Period conversion should of sizes " +
						"2. Size " + dateTimes.size() + " is not valid.");
			}
			if (this.periodType != null) {
				return new Period(dateTimes.get(0), dateTimes.get(1), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(dateTimes.get(0).getMillis(), dateTimes.get(1).getMillis(), this.chronology);
			}
			return new Period(dateTimes.get(0), dateTimes.get(1));
		}		
	}	
	
	public static final class FromDateTimeFieldArray implements IFunc<Period, DateTime[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromDateTimeFieldArray() {
			super();			
		}		
		
		public FromDateTimeFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromDateTimeFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final DateTime[] dateTimes) throws Exception {
			if (dateTimes.length != 2 ) {
				throw new FunctionExecutionException(
						"DateTime arguments array for Period conversion should of sizes " +
						"2. Size " + dateTimes.length + " is not valid.");
			}
			if (this.periodType != null) {
				return new Period(dateTimes[0], dateTimes[1], this.periodType);
			}
			if (this.chronology != null) {
				return new Period(dateTimes[0].getMillis(), dateTimes[1].getMillis(), this.chronology);
			}
			return new Period(dateTimes[0], dateTimes[1]);
		}		
	}	
	
	public static final class FromIntegerFieldList implements IFunc<Period, List<Integer>> {

		private PeriodType periodType = null;
		
		public FromIntegerFieldList() {
			super();			
		}	
		
		public FromIntegerFieldList(PeriodType periodType) {
			super();			
			this.periodType = periodType;
		}	
		
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Integer> integers) throws Exception {
			if (integers.size() != 4 && // hours, minutes, seconds, milliseconds
					integers.size() != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new FunctionExecutionException(
						"Integer arguments list for Period conversion should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + integers.size() + " is not valid.");
			}
			
			if (integers.size() == 4) {
				return new Period(integers.get(0).intValue(), integers.get(1).intValue(), 
						integers.get(2).intValue(), integers.get(3).intValue());
			} 
			if (this.periodType != null) {
				return new Period(integers.get(0).intValue(), integers.get(1).intValue(), 
						integers.get(2).intValue(), integers.get(3).intValue(),
						integers.get(4).intValue(), integers.get(5).intValue(),
						integers.get(6).intValue(), integers.get(7).intValue(), this.periodType);
			}
			return new Period(integers.get(0).intValue(), integers.get(1).intValue(), 
					integers.get(2).intValue(), integers.get(3).intValue(),
					integers.get(4).intValue(), integers.get(5).intValue(),
					integers.get(6).intValue(), integers.get(7).intValue());	
		}		
	}	
	
	public static final class FromIntegerFieldArray implements IFunc<Period, Integer[]> {

		private PeriodType periodType = null;
		
		public FromIntegerFieldArray() {
			super();			
		}		
		
		public FromIntegerFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}	
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Integer[] integers) throws Exception {
			if (integers.length != 4 && // hours, minutes, seconds, milliseconds
					integers.length != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new FunctionExecutionException(
						"Integer arguments array for Period conversion should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + integers.length + " is not valid.");
	        }
			
			if (integers.length == 4) {
				return new Period(integers[0].intValue(), integers[1].intValue(), 
						integers[2].intValue(), integers[3].intValue());
			} 
			if (this.periodType != null) {
				return new Period(integers[0].intValue(), integers[1].intValue(), 
						integers[2].intValue(), integers[3].intValue(),
						integers[4].intValue(), integers[5].intValue(),
						integers[6].intValue(), integers[7].intValue(), this.periodType);
			}
			return new Period(integers[0].intValue(), integers[1].intValue(), 
					integers[2].intValue(), integers[3].intValue(),
					integers[4].intValue(), integers[5].intValue(),
					integers[6].intValue(), integers[7].intValue());
		}		
	}	
	
	public static final class FromStringFieldList implements IFunc<Period, List<String>> {

		private PeriodType periodType = null;
		
		public FromStringFieldList() {
			super();			
		}	
		
		public FromStringFieldList(PeriodType periodType) {
			super();			
			this.periodType = periodType;
		}	
		
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<String> strings) throws Exception {
			if (strings.size() != 4 && // hours, minutes, seconds, milliseconds
					strings.size() != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new FunctionExecutionException(
						"String arguments list for Period conversion should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + strings.size() + " is not valid.");
			}
			
			if (strings.size() == 4) {
				return new Period(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), 
						Integer.parseInt(strings.get(2)), Integer.parseInt(strings.get(3)));
			} 
			if (this.periodType != null) {
				return new Period(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), 
						Integer.parseInt(strings.get(2)), Integer.parseInt(strings.get(3)),
						Integer.parseInt(strings.get(4)), Integer.parseInt(strings.get(5)),
						Integer.parseInt(strings.get(6)), Integer.parseInt(strings.get(7)), this.periodType);
			}
			return new Period(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), 
					Integer.parseInt(strings.get(2)), Integer.parseInt(strings.get(3)),
					Integer.parseInt(strings.get(4)), Integer.parseInt(strings.get(5)),
					Integer.parseInt(strings.get(6)), Integer.parseInt(strings.get(7)));	
		}		
	}	
	
	public static final class FromStringFieldArray implements IFunc<Period, String[]> {

		private PeriodType periodType = null;
		
		public FromStringFieldArray() {
			super();			
		}		
		
		public FromStringFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}	
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final String[] strings) throws Exception {
			if (strings.length != 4 && // hours, minutes, seconds, milliseconds
					strings.length != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new FunctionExecutionException(
						"String arguments array for Period conversion should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + strings.length + " is not valid.");
	        }
			
			if (strings.length == 4) {
				return new Period(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 
						Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
			} 
			if (this.periodType != null) {
				return new Period(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 
						Integer.parseInt(strings[2]), Integer.parseInt(strings[3]),
						Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
						Integer.parseInt(strings[6]), Integer.parseInt(strings[7]), this.periodType);
			}
			return new Period(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 
					Integer.parseInt(strings[2]), Integer.parseInt(strings[3]),
					Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
					Integer.parseInt(strings[6]), Integer.parseInt(strings[7]));			
		}		
	}	
}
