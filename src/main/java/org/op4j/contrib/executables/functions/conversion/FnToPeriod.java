/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.base.BaseDateTime;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.AbstractNullAsNullFunction;
import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnToPeriod {

	private static final DateFieldListToPeriod FROM_DATE_FIELD_LIST = new DateFieldListToPeriod();
	
	private static final TimestampFieldListToPeriod FROM_TIMESTAMP_FIELD_LIST = new TimestampFieldListToPeriod();
	private static final TimestampFieldArrayToPeriod FROM_TIMESTAMP_FIELD_ARRAY = new TimestampFieldArrayToPeriod();
	
	private static final LongToPeriod FROM_LONG = new LongToPeriod();
	
	private static final LongFieldListToPeriod FROM_LONG_FIELD_LIST = new LongFieldListToPeriod();
	private static final LongFieldArrayToPeriod FROM_LONG_FIELD_ARRAY = new LongFieldArrayToPeriod();
	
	private static final CalendarFieldListToPeriod FROM_CALENDAR_FIELD_LIST = new CalendarFieldListToPeriod();
	
	private static final BaseDateTimeFieldListToPeriod FROM_BASEDATETIME_FIELD_LIST = new BaseDateTimeFieldListToPeriod();
	
	private static final IntegerFieldListToPeriod FROM_INTEGER_FIELD_LIST = new IntegerFieldListToPeriod();
	private static final IntegerFieldArrayToPeriod FROM_INTEGER_FIELD_ARRAY = new IntegerFieldArrayToPeriod();
	
	private static final StringFieldListToPeriod FROM_STRING_FIELD_LIST = new StringFieldListToPeriod();
	private static final StringFieldArrayToPeriod FROM_STRING_FIELD_ARRAY = new StringFieldArrayToPeriod();
	
	
	private FnToPeriod() {
		super();
	}
	
	// Conversion from two date objects
	/**
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final DateFieldListToPeriod fromDateFieldList() {
		return FROM_DATE_FIELD_LIST;
	}	
	/**
	 * @param chronology {@link Chronology} the {@link Period} is being created with
	 * 
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final DateFieldListToPeriod fromDateFieldList(final Chronology chronology) {
		return new DateFieldListToPeriod(chronology);
	}	
	public static final DateFieldListToPeriod fromDateFieldList(final PeriodType periodType) {
		return new DateFieldListToPeriod(periodType);
	}
	public static final DateFieldListToPeriod fromDateFieldList(final PeriodType periodType, final Chronology chronology) {
		return new DateFieldListToPeriod(periodType, chronology);
	}
	public static final <T extends Date> DateFieldArrayToPeriod<T> fromDateFieldArray() {
		return new DateFieldArrayToPeriod<T>();
	}	
	public static final <T extends Date> DateFieldArrayToPeriod<T> fromDateFieldArray(final Chronology chronology) {
		return new DateFieldArrayToPeriod<T>(chronology);
	}	
	public static final <T extends Date> DateFieldArrayToPeriod<T> fromDateFieldArray(final PeriodType periodType) {
		return new DateFieldArrayToPeriod<T>(periodType);
	}
	public static final <T extends Date> DateFieldArrayToPeriod<T> fromDateFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new DateFieldArrayToPeriod<T>(periodType, chronology);
	}
	//
	
	// Conversion from two timestamp objects
	public static final TimestampFieldListToPeriod fromTimestampFieldList() {
		return FROM_TIMESTAMP_FIELD_LIST;
	}	
	public static final TimestampFieldListToPeriod fromTimestampFieldList(final Chronology chronology) {
		return new TimestampFieldListToPeriod(chronology);
	}	
	public static final TimestampFieldListToPeriod fromTimestampFieldList(final PeriodType periodType) {
		return new TimestampFieldListToPeriod(periodType);
	}
	public static final TimestampFieldListToPeriod fromTimestampFieldList(final PeriodType periodType, final Chronology chronology) {
		return new TimestampFieldListToPeriod(periodType, chronology);
	}
	public static final TimestampFieldArrayToPeriod fromTimestampFieldArray() {
		return FROM_TIMESTAMP_FIELD_ARRAY;
	}	
	public static final TimestampFieldArrayToPeriod fromTimestampFieldArray(final Chronology chronology) {
		return new TimestampFieldArrayToPeriod(chronology);
	}	
	public static final TimestampFieldArrayToPeriod fromTimestampFieldArray(final PeriodType periodType) {
		return new TimestampFieldArrayToPeriod(periodType);
	}
	public static final TimestampFieldArrayToPeriod fromTimestampFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new TimestampFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from Long
	/**
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final LongToPeriod fromLong() {
		return FROM_LONG;
	}
	/**
	 * @param chronology the {@link Chronology} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final LongToPeriod fromLong(final Chronology chronology) {
		return new LongToPeriod(chronology);
	}
	/**
	 * @param periodType the {@link PeriodType} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final LongToPeriod fromLong(final PeriodType periodType) {
		return new LongToPeriod(periodType);
	}
	/**
	 * @param periodType the {@link PeriodType} the returned {@link Period} will
	 * be created with
	 * @param chronology the {@link Chronology} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final LongToPeriod fromLong(final PeriodType periodType, final Chronology chronology) {
		return new LongToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from two long objects
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldListToPeriod fromLongFieldList() {
		return FROM_LONG_FIELD_LIST;
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldListToPeriod fromLongFieldList(final Chronology chronology) {
		return new LongFieldListToPeriod(chronology);
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldListToPeriod fromLongFieldList(final PeriodType periodType) {
		return new LongFieldListToPeriod(periodType);
	}
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldListToPeriod fromLongFieldList(final PeriodType periodType, final Chronology chronology) {
		return new LongFieldListToPeriod(periodType, chronology);
	}
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldArrayToPeriod fromLongFieldArray() {
		return FROM_LONG_FIELD_ARRAY;
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldArrayToPeriod fromLongFieldArray(final Chronology chronology) {
		return new LongFieldArrayToPeriod(chronology);
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldArrayToPeriod fromLongFieldArray(final PeriodType periodType) {
		return new LongFieldArrayToPeriod(periodType);
	}
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldArrayToPeriod fromLongFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new LongFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from two calendar objects
	/**
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final CalendarFieldListToPeriod fromCalendarFieldList() {
		return FROM_CALENDAR_FIELD_LIST;
	}	
	public static final CalendarFieldListToPeriod fromCalendarFieldList(final Chronology chronology) {
		return new CalendarFieldListToPeriod(chronology);
	}	
	public static final CalendarFieldListToPeriod fromCalendarFieldList(final PeriodType periodType) {
		return new CalendarFieldListToPeriod(periodType);
	}
	public static final CalendarFieldListToPeriod fromCalendarFieldList(final PeriodType periodType, final Chronology chronology) {
		return new CalendarFieldListToPeriod(periodType, chronology);
	}
	/**
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final <T extends Calendar> CalendarFieldArrayToPeriod<T> fromCalendarFieldArray() {
		return new CalendarFieldArrayToPeriod<T>();
	}	
	public static final <T extends Calendar> CalendarFieldArrayToPeriod<T> fromCalendarFieldArray(final Chronology chronology) {
		return new CalendarFieldArrayToPeriod<T>(chronology);
	}	
	public static final <T extends Calendar> CalendarFieldArrayToPeriod<T> fromCalendarFieldArray(final PeriodType periodType) {
		return new CalendarFieldArrayToPeriod<T>(periodType);
	}
	public static final <T extends Calendar> CalendarFieldArrayToPeriod<T> fromCalendarFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new CalendarFieldArrayToPeriod<T>(periodType, chronology);
	}
	//
	
	// Conversion from two datetime objects
	/**
	 * @return the {@link Period} represented by the given start and end 
	 * {@link BaseDateTime} elements
	 */
	public static final BaseDateTimeFieldListToPeriod fromBaseDateTimeFieldList() {
		return FROM_BASEDATETIME_FIELD_LIST;
	}	
	public static final BaseDateTimeFieldListToPeriod fromBaseDateTimeFieldList(final Chronology chronology) {
		return new BaseDateTimeFieldListToPeriod(chronology);
	}	
	public static final BaseDateTimeFieldListToPeriod fromBaseDateTimeFieldList(final PeriodType periodType) {
		return new BaseDateTimeFieldListToPeriod(periodType);
	}
	public static final BaseDateTimeFieldListToPeriod fromBaseDateTimeFieldList(final PeriodType periodType, final Chronology chronology) {
		return new BaseDateTimeFieldListToPeriod(periodType, chronology);
	}
	/**
	 * @return the {@link Period} represented by the given start and end 
	 * {@link BaseDateTime} elements
	 */
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToPeriod<T> fromBaseDateTimeFieldArray() {
		return new BaseDateTimeFieldArrayToPeriod<T>();
	}	
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToPeriod<T> fromBaseDateTimeFieldArray(final Chronology chronology) {
		return new BaseDateTimeFieldArrayToPeriod<T>(chronology);
	}	
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToPeriod<T> fromBaseDateTimeFieldArray(final PeriodType periodType) {
		return new BaseDateTimeFieldArrayToPeriod<T>(periodType);
	}
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToPeriod<T> fromBaseDateTimeFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new BaseDateTimeFieldArrayToPeriod<T>(periodType, chronology);
	}
	//
	
	/**
	 * A Period is created either:
	 * <ul>	  
	 * <li>From a set of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
	 * <li>From a set of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
	 * </ul>
	 * 
	 * @return the {@link Period}
	 */
	public static final IntegerFieldListToPeriod fromIntegerFieldList() {
		return FROM_INTEGER_FIELD_LIST;
	}
	public static final IntegerFieldListToPeriod fromIntegerFieldList(PeriodType periodType) {
		return new IntegerFieldListToPeriod(periodType);
	}
	public static final IntegerFieldArrayToPeriod fromIntegerFieldArray() {
		return FROM_INTEGER_FIELD_ARRAY;
	}
	public static final IntegerFieldArrayToPeriod fromIntegerFieldArray(PeriodType periodType) {
		return new IntegerFieldArrayToPeriod(periodType);
	}
	
	/**
	 * A Period is created either:
	 * <ul>	  
	 * <li>From a set of {@link String} representing the hours, minutes, seconds and milliseconds</li>
	 * <li>From a set of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
	 * </ul>
	 * 
	 * @return the {@link Period}
	 */
	public static final StringFieldListToPeriod fromStringFieldList() {
		return FROM_STRING_FIELD_LIST;
	}
	public static final StringFieldListToPeriod fromStringFieldList(PeriodType periodType) {
		return new StringFieldListToPeriod(periodType);
	}
	public static final StringFieldArrayToPeriod fromStringFieldArray() {
		return FROM_STRING_FIELD_ARRAY;
	}
	public static final StringFieldArrayToPeriod fromStringFieldArray(PeriodType periodType) {
		return new StringFieldArrayToPeriod(periodType);
	}
	
	
	private static abstract class BaseToPeriod<T> extends AbstractNullAsNullFunction<T, Period> {

		Chronology chronology = null;
		PeriodType periodType = null;
		
		public BaseToPeriod() {
			super();			
		}

		public BaseToPeriod(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
		}

		public BaseToPeriod(PeriodType periodType) {
			super();
			
			Validate.notNull(periodType, "periodType can't be null");
			
			this.periodType = periodType;
		}

		public BaseToPeriod(PeriodType periodType, Chronology chronology) {
			super();
			
			Validate.notNull(periodType, "periodType can't be null");
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
			this.periodType = periodType;
		}
	}
	
	static final class DateFieldListToPeriod extends BaseToPeriod<List<? extends Date>> {

		public DateFieldListToPeriod() {
			super();			
		}		
		
		public DateFieldListToPeriod(Chronology chronology) {
			super(chronology);					
		}
		
		public DateFieldListToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public DateFieldListToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * The given java.util.Date targets will be used as the start and end instants of the Period
		 * returned
		 *  
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<? extends Date> dates, ExecCtx ctx) throws Exception {
			if (dates.size() != 2 ) {
				throw new ExecutionException(
						"Date arguments list for Period conversion should have size " +
						"2. Size " + dates.size() + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(dates.get(0).getTime(), dates.get(1).getTime(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(dates.get(0).getTime(), dates.get(1).getTime(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(dates.get(0).getTime(), dates.get(1).getTime(), this.chronology);
			}
			return new Period(dates.get(0).getTime(), dates.get(1).getTime());
		}		
	}	
	
	static final class DateFieldArrayToPeriod<T extends Date> extends BaseToPeriod<T[]> {

		public DateFieldArrayToPeriod() {
			super();			
		}		
		
		public DateFieldArrayToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public DateFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public DateFieldArrayToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * The given java.util.Date targets will be used as the start and end instants of the Period
		 * returned
		 *  
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final T[] dates, ExecCtx ctx) throws Exception {
			if (dates.length != 2 ) {
				throw new ExecutionException(
						"Date arguments array for Period conversion should have size " +
						"2. Size " + dates.length + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(dates[0].getTime(), dates[1].getTime(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(dates[0].getTime(), dates[1].getTime(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(dates[0].getTime(), dates[1].getTime(), this.chronology);
			}
			return new Period(dates[0].getTime(), dates[1].getTime());
		}		
	}	
	
	static final class TimestampFieldListToPeriod extends BaseToPeriod<List<Timestamp>> {

		public TimestampFieldListToPeriod() {
			super();			
		}		
		
		public TimestampFieldListToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public TimestampFieldListToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public TimestampFieldListToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * The given java.sql.Timestamp target elements will be used as the start and end
		 * instants of the Period returned
		 *                 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<Timestamp> timestamps, ExecCtx ctx) throws Exception {
			if (timestamps.size() != 2 ) {
				throw new ExecutionException(
						"Timestamp arguments list for Period conversion should of sizes " +
						"2. Size " + timestamps.size() + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(timestamps.get(0).getTime(), timestamps.get(1).getTime(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(timestamps.get(0).getTime(), timestamps.get(1).getTime(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(timestamps.get(0).getTime(), timestamps.get(1).getTime(), this.chronology);
			}
			return new Period(timestamps.get(0).getTime(), timestamps.get(1).getTime());
		}		
	}	
	
	static final class TimestampFieldArrayToPeriod extends BaseToPeriod<Timestamp[]> {

		public TimestampFieldArrayToPeriod() {
			super();			
		}		
		
		public TimestampFieldArrayToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public TimestampFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public TimestampFieldArrayToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * The given java.sql.Timestamp target elements will be used as the start and end
		 * instants of the Period returned
		 *                 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final Timestamp[] timestamps, ExecCtx ctx) throws Exception {
			if (timestamps.length != 2 ) {
				throw new ExecutionException(
						"Timestamp arguments array for Period conversion should of sizes " +
						"2. Size " + timestamps.length + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(timestamps[0].getTime(), timestamps[1].getTime(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(timestamps[0].getTime(), timestamps[1].getTime(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(timestamps[0].getTime(), timestamps[1].getTime(), this.chronology);
			}
			return new Period(timestamps[0].getTime(), timestamps[1].getTime());
		}		
	}	
	
	static final class LongToPeriod extends BaseToPeriod<Long> {

		public LongToPeriod() {
			super();			
		}		
		
		public LongToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public LongToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public LongToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * It returns a Period with the given Duration in milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final Long theLong, ExecCtx ctx) throws Exception {
			if (this.periodType != null && this.chronology != null) {
				return new Period(theLong.longValue(), this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(theLong.longValue(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(theLong.longValue(), this.chronology);
			}
			return new Period(theLong.longValue());
		}		
	}	
	
	static final class LongFieldListToPeriod extends BaseToPeriod<List<Long>> {

		public LongFieldListToPeriod() {
			super();			
		}		
		
		public LongFieldListToPeriod(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public LongFieldListToPeriod(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public LongFieldListToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * The given long targets representing the time in millis will be used as the start
		 * and end instants of the Period returned
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<Long> longs, ExecCtx ctx) throws Exception {
			if (longs.size() != 2 ) {
				throw new ExecutionException(
						"Long arguments list for Period conversion should have size " +
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
	
	static final class LongFieldArrayToPeriod extends BaseToPeriod<Long[]> {

		public LongFieldArrayToPeriod() {
			super();			
		}		
		
		public LongFieldArrayToPeriod(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public LongFieldArrayToPeriod(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public LongFieldArrayToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * The given long targets representing the time in millis will be used as the start
		 * and end instants of the Period returned
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final Long[] longs, ExecCtx ctx) throws Exception {
			if (longs.length != 2 ) {
				throw new ExecutionException(
						"Long arguments array for Period conversion should have size " +
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
	 
	static final class CalendarFieldListToPeriod extends BaseToPeriod<List<? extends Calendar>> {

		public CalendarFieldListToPeriod() {
			super();			
		}		
		
		public CalendarFieldListToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public CalendarFieldListToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public CalendarFieldListToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * It creates a Period with the given Calendar targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<? extends Calendar> calendars, ExecCtx ctx) throws Exception {
			if (calendars.size() != 2 ) {
				throw new ExecutionException(
						"Calendar arguments list for Period conversion should have size " +
						"2. Size " + calendars.size() + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(calendars.get(0).getTimeInMillis(), calendars.get(1).getTimeInMillis(), 
						this.periodType, this.chronology);
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
	
	static final class CalendarFieldArrayToPeriod<T extends Calendar> extends BaseToPeriod<T[]> {

		public CalendarFieldArrayToPeriod() {
			super();			
		}		
		
		public CalendarFieldArrayToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public CalendarFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public CalendarFieldArrayToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * It creates a Period with the given Calendar targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final T[] calendars, ExecCtx ctx) throws Exception {
			if (calendars.length != 2 ) {
				throw new ExecutionException(
						"Calendar arguments array for Period conversion should have size " +
						"2. Size " + calendars.length + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(calendars[0].getTimeInMillis(), calendars[1].getTimeInMillis(), 
						this.periodType, this.chronology);
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
	
	static final class BaseDateTimeFieldListToPeriod extends BaseToPeriod<List<? extends BaseDateTime>> {

		public BaseDateTimeFieldListToPeriod() {
			super();			
		}		
		
		public BaseDateTimeFieldListToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public BaseDateTimeFieldListToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public BaseDateTimeFieldListToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * It creates a Period with the given DateTime targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<? extends BaseDateTime> dateTimes, ExecCtx ctx) throws Exception {
			if (dateTimes.size() != 2 ) {
				throw new ExecutionException(
						"DateTime arguments list for Period conversion should have size " +
						"2. Size " + dateTimes.size() + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(dateTimes.get(0).getMillis(), dateTimes.get(1).getMillis(), 
						this.periodType, this.chronology);
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
	
	static final class BaseDateTimeFieldArrayToPeriod<T extends BaseDateTime> extends BaseToPeriod<T[]> {

		public BaseDateTimeFieldArrayToPeriod() {
			super();			
		}		
		
		public BaseDateTimeFieldArrayToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public BaseDateTimeFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public BaseDateTimeFieldArrayToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* 
		 * It creates a Period with the given DateTime targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final T[] dateTimes, ExecCtx ctx) throws Exception {
			if (dateTimes.length != 2 ) {
				throw new ExecutionException(
						"DateTime arguments array for Period conversion should have size " +
						"2. Size " + dateTimes.length + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(dateTimes[0].getMillis(), dateTimes[1].getMillis(), this.periodType, this.chronology);
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
	
	static final class IntegerFieldListToPeriod extends BaseToPeriod<List<Integer>> {

		public IntegerFieldListToPeriod() {
			super();			
		}	
		
		public IntegerFieldListToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<Integer> integers, ExecCtx ctx) throws Exception {
			
			if (this.periodType != null) {
				// Check list size is consistent with periodType
				if (integers.size() != this.periodType.size()) { 
					throw new ExecutionException(
							"Integer arguments list for Period conversion with the periodType " +
							this.periodType.getName() + " should have size " + this.periodType.size() +
							". Size " + integers.size() + " is not valid.");
				}				
				
				int currentIndex = 0;
				int years = 0;
				int months = 0;
				int weeks = 0;
				int days = 0;
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				int millis = 0;
				if (this.periodType.isSupported(DurationFieldType.years())) {
					years = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.months())) {
					months = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.weeks())) {
					weeks = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.days())) {
					days = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.hours())) {
					hours = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.minutes())) {
					minutes = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.seconds())) {
					seconds = integers.get(currentIndex++).intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.millis())) {
					millis = integers.get(currentIndex++).intValue();					
				}				
				
				return new Period(years, months, weeks, days, hours, minutes, seconds, millis, this.periodType);
			} 			
			
			// When periodType is null, only two types of data are allowed: 
			// (hours, minutes, seconds, milliseconds)
			// (years, months, weeks, days, hours, minutes, seconds and milliseconds)
			if (integers.size() != 4 && // hours, minutes, seconds, milliseconds
					integers.size() != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new ExecutionException(
						"Integer arguments list for Period conversion without a PeriodType should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + integers.size() + " is not valid.");
			}

			// hours, minutes, seconds, milliseconds
			if (integers.size() == 4) {
				return new Period(integers.get(0).intValue(), integers.get(1).intValue(), 
						integers.get(2).intValue(), integers.get(3).intValue());
			} 
			
			// years, months, weeks, days, hours, minutes, seconds and milliseconds
			return new Period(integers.get(0).intValue(), integers.get(1).intValue(), 
					integers.get(2).intValue(), integers.get(3).intValue(),
					integers.get(4).intValue(), integers.get(5).intValue(),
					integers.get(6).intValue(), integers.get(7).intValue());
		}		
	}	
	
	static final class IntegerFieldArrayToPeriod extends BaseToPeriod<Integer[]> {

		public IntegerFieldArrayToPeriod() {
			super();			
		}		
		
		public IntegerFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final Integer[] integers, ExecCtx ctx) throws Exception {
			if (this.periodType != null) {
				// Check list size is consistent with periodType
				if (integers.length != this.periodType.size()) { 
					throw new ExecutionException(
							"Integer arguments array for Period conversion with the periodType " +
							this.periodType.getName() + " should have size " + this.periodType.size() +
							". Size " + integers.length + " is not valid.");
				}				
				
				int currentIndex = 0;
				int years = 0;
				int months = 0;
				int weeks = 0;
				int days = 0;
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				int millis = 0;
				if (this.periodType.isSupported(DurationFieldType.years())) {
					years = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.months())) {
					months = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.weeks())) {
					weeks = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.days())) {
					days = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.hours())) {
					hours = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.minutes())) {
					minutes = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.seconds())) {
					seconds = integers[currentIndex++].intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.millis())) {
					millis = integers[currentIndex++].intValue();					
				}				
				
				return new Period(years, months, weeks, days, hours, minutes, seconds, millis, this.periodType);
			} 			
			
			// When periodType is null, only two types of data are allowed: 
			// (hours, minutes, seconds, milliseconds)
			// (years, months, weeks, days, hours, minutes, seconds and milliseconds)
			if (integers.length != 4 && // hours, minutes, seconds, milliseconds
					integers.length != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new ExecutionException(
						"Integer arguments array for Period conversion without a PeriodType should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + integers.length + " is not valid.");
			}

			// hours, minutes, seconds, milliseconds
			if (integers.length == 4) {
				return new Period(integers[0].intValue(), integers[1].intValue(), 
						integers[2].intValue(), integers[3].intValue());
			} 
			
			// years, months, weeks, days, hours, minutes, seconds and milliseconds
			return new Period(integers[0].intValue(), integers[1].intValue(), 
					integers[2].intValue(), integers[3].intValue(),
					integers[4].intValue(), integers[5].intValue(),
					integers[6].intValue(), integers[7].intValue());
		}		
	}	
	
	static final class StringFieldListToPeriod extends BaseToPeriod<List<String>> {

		public StringFieldListToPeriod() {
			super();			
		}	
		
		public StringFieldListToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final List<String> strings, ExecCtx ctx) throws Exception {
			if (this.periodType != null) {
				// Check list size is consistent with periodType
				if (strings.size() != this.periodType.size()) { 
					throw new ExecutionException(
							"String arguments list for Period conversion with the periodType " +
							this.periodType.getName() + " should have size " + this.periodType.size() +
							". Size " + strings.size() + " is not valid.");
				}				
				
				int currentIndex = 0;
				int years = 0;
				int months = 0;
				int weeks = 0;
				int days = 0;
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				int millis = 0;
				if (this.periodType.isSupported(DurationFieldType.years())) {
					years = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.months())) {
					months = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.weeks())) {
					weeks = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.days())) {
					days = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.hours())) {
					hours = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.minutes())) {
					minutes = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.seconds())) {
					seconds = Integer.parseInt(strings.get(currentIndex++));					
				}
				if (this.periodType.isSupported(DurationFieldType.millis())) {
					millis = Integer.parseInt(strings.get(currentIndex++));					
				}				
				
				return new Period(years, months, weeks, days, hours, minutes, seconds, millis, this.periodType);
			} 			
			
			// When periodType is null, only two types of data are allowed: 
			// (hours, minutes, seconds, milliseconds)
			// (years, months, weeks, days, hours, minutes, seconds and milliseconds)
			if (strings.size() != 4 && // hours, minutes, seconds, milliseconds
					strings.size() != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new ExecutionException(
						"String arguments list for Period conversion without a PeriodType should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + strings.size() + " is not valid.");
			}

			// hours, minutes, seconds, milliseconds
			if (strings.size() == 4) {
				return new Period(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), 
						Integer.parseInt(strings.get(2)), Integer.parseInt(strings.get(3)));
			} 
			
			// years, months, weeks, days, hours, minutes, seconds and milliseconds
			return new Period(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), 
					Integer.parseInt(strings.get(2)), Integer.parseInt(strings.get(3)),
					Integer.parseInt(strings.get(4)), Integer.parseInt(strings.get(5)),
					Integer.parseInt(strings.get(6)), Integer.parseInt(strings.get(7)));
		}		
	}	
	
	static final class StringFieldArrayToPeriod extends BaseToPeriod<String[]> {

		public StringFieldArrayToPeriod() {
			super();			
		}		
		
		public StringFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public Period nullAsNullExecute(final String[] strings, ExecCtx ctx) throws Exception {
			if (this.periodType != null) {
				// Check list size is consistent with periodType
				if (strings.length != this.periodType.size()) { 
					throw new ExecutionException(
							"String arguments array for Period conversion with the periodType " +
							this.periodType.getName() + " should have size " + this.periodType.size() +
							". Size " + strings.length + " is not valid.");
				}				
				
				int currentIndex = 0;
				int years = 0;
				int months = 0;
				int weeks = 0;
				int days = 0;
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				int millis = 0;
				if (this.periodType.isSupported(DurationFieldType.years())) {
					years = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.months())) {
					months = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.weeks())) {
					weeks = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.days())) {
					days = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.hours())) {
					hours = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.minutes())) {
					minutes = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.seconds())) {
					seconds = Integer.parseInt(strings[currentIndex++]);					
				}
				if (this.periodType.isSupported(DurationFieldType.millis())) {
					millis = Integer.parseInt(strings[currentIndex++]);					
				}				
				
				return new Period(years, months, weeks, days, hours, minutes, seconds, millis, this.periodType);
			} 			
			
			// When periodType is null, only two types of data are allowed: 
			// (hours, minutes, seconds, milliseconds)
			// (years, months, weeks, days, hours, minutes, seconds and milliseconds)
			if (strings.length != 4 && // hours, minutes, seconds, milliseconds
					strings.length != 8) { // years, months, weeks, days, hours, minutes, seconds and milliseconds
				throw new ExecutionException(
						"String arguments array for Period conversion without a PeriodType should of sizes " +
						"4 (hours, minutes, seconds, milliseconds), 8 (years, months, weeks, days, hours, minutes, seconds and milliseconds). " +
						"Size " + strings.length + " is not valid.");
			}

			// hours, minutes, seconds, milliseconds
			if (strings.length == 4) {
				return new Period(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 
						Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
			} 
			
			// years, months, weeks, days, hours, minutes, seconds and milliseconds
			return new Period(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 
					Integer.parseInt(strings[2]), Integer.parseInt(strings[3]),
					Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
					Integer.parseInt(strings[6]), Integer.parseInt(strings[7]));
		}		
	}	
}
