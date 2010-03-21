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
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

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
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public final class FnToPeriod {
	
	private static final DateFieldCollectionToPeriod DATE_FIELD_COLLECTION_TO_PERIOD = new DateFieldCollectionToPeriod();
	
	private static final TimestampFieldCollectionToPeriod TIMESTAMP_FIELD_COLLECTION_TO_PERIOD = new TimestampFieldCollectionToPeriod();
	private static final TimestampFieldArrayToPeriod TIMESTAMP_FIELD_ARRAY_TO_PERIOD = new TimestampFieldArrayToPeriod();
	
	private static final LongToPeriod LONG_TO_PERIOD = new LongToPeriod();
	
	private static final LongFieldCollectionToPeriod LONG_FIELD_COLLECTION_TO_PERIOD = new LongFieldCollectionToPeriod();
	private static final LongFieldArrayToPeriod LONG_FIELD_ARRAY_TO_PERIOD = new LongFieldArrayToPeriod();
	
	private static final CalendarFieldCollectionToPeriod CALENDAR_FIELD_COLLECTION_TO_PERIOD = new CalendarFieldCollectionToPeriod();
	
	private static final BaseDateTimeFieldCollectionToPeriod BASE_DATE_TIME_FIELD_COLLECTION_TO_PERIOD = new BaseDateTimeFieldCollectionToPeriod();
	
	private static final IntegerFieldCollectionToPeriod INTEGER_FIELD_COLLECTION_TO_PERIOD = new IntegerFieldCollectionToPeriod();
	private static final IntegerFieldArrayToPeriod INTEGER_FIELD_ARRAY_TO_PERIOD = new IntegerFieldArrayToPeriod();
	
	private static final StringFieldCollectionToPeriod STRING_FIELD_COLLECTION_TO_PERIOD = new StringFieldCollectionToPeriod();
	private static final StringFieldArrayToPeriod STRING_FIELD_ARRAY_TO_PERIOD = new StringFieldArrayToPeriod();
	
	
	private FnToPeriod() {
		super();
	}
	
	// Conversion from two date objects
	/**
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final DateFieldCollectionToPeriod fromDateFieldCollection() {
		return DATE_FIELD_COLLECTION_TO_PERIOD;
	}	
	/**
	 * @param chronology {@link Chronology} the {@link Period} is being created with
	 * 
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final DateFieldCollectionToPeriod fromDateFieldCollection(final Chronology chronology) {
		return new DateFieldCollectionToPeriod(chronology);
	}	
	public static final DateFieldCollectionToPeriod fromDateFieldCollection(final PeriodType periodType) {
		return new DateFieldCollectionToPeriod(periodType);
	}
	public static final DateFieldCollectionToPeriod fromDateFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return new DateFieldCollectionToPeriod(periodType, chronology);
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
	public static final TimestampFieldCollectionToPeriod fromTimestampFieldCollection() {
		return TIMESTAMP_FIELD_COLLECTION_TO_PERIOD;
	}	
	public static final TimestampFieldCollectionToPeriod fromTimestampFieldCollection(final Chronology chronology) {
		return new TimestampFieldCollectionToPeriod(chronology);
	}	
	public static final TimestampFieldCollectionToPeriod fromTimestampFieldCollection(final PeriodType periodType) {
		return new TimestampFieldCollectionToPeriod(periodType);
	}
	public static final TimestampFieldCollectionToPeriod fromTimestampFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return new TimestampFieldCollectionToPeriod(periodType, chronology);
	}
	public static final TimestampFieldArrayToPeriod fromTimestampFieldArray() {
		return TIMESTAMP_FIELD_ARRAY_TO_PERIOD;
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
		return LONG_TO_PERIOD;
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
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldCollectionToPeriod fromLongFieldCollection() {
		return LONG_FIELD_COLLECTION_TO_PERIOD;
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldCollectionToPeriod fromLongFieldCollection(final Chronology chronology) {
		return new LongFieldCollectionToPeriod(chronology);
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldCollectionToPeriod fromLongFieldCollection(final PeriodType periodType) {
		return new LongFieldCollectionToPeriod(periodType);
	}
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldCollectionToPeriod fromLongFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return new LongFieldCollectionToPeriod(periodType, chronology);
	}
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final LongFieldArrayToPeriod fromLongFieldArray() {
		return LONG_FIELD_ARRAY_TO_PERIOD;
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
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
	 * The given long targets representing the time in milliseconds will be used as the start
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
	 * The given long targets representing the time in milliseconds will be used as the start
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
	public static final CalendarFieldCollectionToPeriod fromCalendarFieldCollection() {
		return CALENDAR_FIELD_COLLECTION_TO_PERIOD;
	}	
	public static final CalendarFieldCollectionToPeriod fromCalendarFieldCollection(final Chronology chronology) {
		return new CalendarFieldCollectionToPeriod(chronology);
	}	
	public static final CalendarFieldCollectionToPeriod fromCalendarFieldCollection(final PeriodType periodType) {
		return new CalendarFieldCollectionToPeriod(periodType);
	}
	public static final CalendarFieldCollectionToPeriod fromCalendarFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return new CalendarFieldCollectionToPeriod(periodType, chronology);
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
	public static final BaseDateTimeFieldCollectionToPeriod fromBaseDateTimeFieldCollection() {
		return BASE_DATE_TIME_FIELD_COLLECTION_TO_PERIOD;
	}	
	public static final BaseDateTimeFieldCollectionToPeriod fromBaseDateTimeFieldCollection(final Chronology chronology) {
		return new BaseDateTimeFieldCollectionToPeriod(chronology);
	}	
	public static final BaseDateTimeFieldCollectionToPeriod fromBaseDateTimeFieldCollection(final PeriodType periodType) {
		return new BaseDateTimeFieldCollectionToPeriod(periodType);
	}
	public static final BaseDateTimeFieldCollectionToPeriod fromBaseDateTimeFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return new BaseDateTimeFieldCollectionToPeriod(periodType, chronology);
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
	public static final IntegerFieldCollectionToPeriod fromIntegerFieldCollection() {
		return INTEGER_FIELD_COLLECTION_TO_PERIOD;
	}
	public static final IntegerFieldCollectionToPeriod fromIntegerFieldCollection(PeriodType periodType) {
		return new IntegerFieldCollectionToPeriod(periodType);
	}
	public static final IntegerFieldArrayToPeriod fromIntegerFieldArray() {
		return INTEGER_FIELD_ARRAY_TO_PERIOD;
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
	public static final StringFieldCollectionToPeriod fromStringFieldCollection() {
		return STRING_FIELD_COLLECTION_TO_PERIOD;
	}
	public static final StringFieldCollectionToPeriod fromStringFieldCollection(PeriodType periodType) {
		return new StringFieldCollectionToPeriod(periodType);
	}
	public static final StringFieldArrayToPeriod fromStringFieldArray() {
		return STRING_FIELD_ARRAY_TO_PERIOD;
	}
	public static final StringFieldArrayToPeriod fromStringFieldArray(PeriodType periodType) {
		return new StringFieldArrayToPeriod(periodType);
	}
	
	
	private static abstract class BaseToPeriod<T> extends AbstractNullAsNullFunction<T, Period> {

		final Chronology chronology;
		final PeriodType periodType;
		
		public BaseToPeriod() {
			super();	
			
			this.chronology = null;
			this.periodType = null;
		}

		public BaseToPeriod(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
			this.periodType = null;
		}

		public BaseToPeriod(PeriodType periodType) {
			super();
			
			Validate.notNull(periodType, "periodType can't be null");
			
			this.chronology = null;
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
	
	static final class DateFieldCollectionToPeriod extends BaseToPeriod<Collection<? extends Date>> {

		public DateFieldCollectionToPeriod() {
			super();			
		}		
		
		public DateFieldCollectionToPeriod(Chronology chronology) {
			super(chronology);					
		}
		
		public DateFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public DateFieldCollectionToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<? extends Date> dates, ExecCtx ctx) throws Exception {
			if (dates.size() != 2 ) {
				throw new ExecutionException(
						"Date arguments list for Period conversion should have size " +
						"2. Size " + dates.size() + " is not valid.");
			}
			
			Iterator<? extends Date> iterator = dates.iterator();
			
			if (this.periodType != null && this.chronology != null) {
				return new Period(iterator.next().getTime(), iterator.next().getTime(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(iterator.next().getTime(), iterator.next().getTime(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(iterator.next().getTime(), iterator.next().getTime(), this.chronology);
			}
			return new Period(iterator.next().getTime(), iterator.next().getTime());
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
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
	
	static final class TimestampFieldCollectionToPeriod extends BaseToPeriod<Collection<Timestamp>> {

		public TimestampFieldCollectionToPeriod() {
			super();			
		}		
		
		public TimestampFieldCollectionToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public TimestampFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public TimestampFieldCollectionToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<Timestamp> timestamps, ExecCtx ctx) throws Exception {
			if (timestamps.size() != 2 ) {
				throw new ExecutionException(
						"Timestamp arguments list for Period conversion should of sizes " +
						"2. Size " + timestamps.size() + " is not valid.");
			}
			
			Iterator<Timestamp> iterator = timestamps.iterator();
			
			if (this.periodType != null && this.chronology != null) {
				return new Period(iterator.next().getTime(), iterator.next().getTime(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(iterator.next().getTime(), iterator.next().getTime(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(iterator.next().getTime(), iterator.next().getTime(), this.chronology);
			}
			return new Period(iterator.next().getTime(), iterator.next().getTime());
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
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
	
	static final class LongFieldCollectionToPeriod extends BaseToPeriod<Collection<Long>> {

		public LongFieldCollectionToPeriod() {
			super();			
		}		
		
		public LongFieldCollectionToPeriod(Chronology chronology) {
			super(chronology);				
		}
		
		public LongFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public LongFieldCollectionToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<Long> longs, ExecCtx ctx) throws Exception {
			if (longs.size() != 2 ) {
				throw new ExecutionException(
						"Long arguments list for Period conversion should have size " +
						"2. Size " + longs.size() + " is not valid.");
			}
			
			Iterator<Long> iterator = longs.iterator();
			
			if (this.periodType != null && this.chronology != null) {
				return new Period(iterator.next().longValue(), iterator.next().longValue(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(iterator.next().longValue(), iterator.next().longValue(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(iterator.next().longValue(), iterator.next().longValue(), this.chronology);
			}
			return new Period(iterator.next().longValue(), iterator.next().longValue());
		}		
	}	
	
	static final class LongFieldArrayToPeriod extends BaseToPeriod<Long[]> {

		public LongFieldArrayToPeriod() {
			super();			
		}		
		
		public LongFieldArrayToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public LongFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public LongFieldArrayToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
	 
	static final class CalendarFieldCollectionToPeriod extends BaseToPeriod<Collection<? extends Calendar>> {

		public CalendarFieldCollectionToPeriod() {
			super();			
		}		
		
		public CalendarFieldCollectionToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public CalendarFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public CalendarFieldCollectionToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<? extends Calendar> calendars, ExecCtx ctx) throws Exception {
			if (calendars.size() != 2 ) {
				throw new ExecutionException(
						"Calendar arguments list for Period conversion should have size " +
						"2. Size " + calendars.size() + " is not valid.");
			}
			
			Iterator<? extends Calendar> iterator = calendars.iterator();
			
			if (this.periodType != null && this.chronology != null) {
				return new Period(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis(), this.chronology);
			}
			return new Period(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis());
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
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
	
	static final class BaseDateTimeFieldCollectionToPeriod extends BaseToPeriod<Collection<? extends BaseDateTime>> {

		public BaseDateTimeFieldCollectionToPeriod() {
			super();			
		}		
		
		public BaseDateTimeFieldCollectionToPeriod(Chronology chronology) {
			super(chronology);
		}
		
		public BaseDateTimeFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}
		
		public BaseDateTimeFieldCollectionToPeriod(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<? extends BaseDateTime> dateTimes, ExecCtx ctx) throws Exception {
			if (dateTimes.size() != 2 ) {
				throw new ExecutionException(
						"DateTime arguments list for Period conversion should have size " +
						"2. Size " + dateTimes.size() + " is not valid.");
			}
			
			Iterator<? extends BaseDateTime> iterator = dateTimes.iterator();
			
			if (this.periodType != null && this.chronology != null) {
				return new Period(iterator.next().getMillis(), iterator.next().getMillis(), 
						this.periodType, this.chronology);
			}
			if (this.periodType != null) {
				return new Period(iterator.next(), iterator.next(), this.periodType);
			}
			if (this.chronology != null) {
				return new Period(iterator.next().getMillis(), iterator.next().getMillis(), this.chronology);
			}
			return new Period(iterator.next(), iterator.next());
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
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
	
	static final class IntegerFieldCollectionToPeriod extends BaseToPeriod<Collection<Integer>> {

		public IntegerFieldCollectionToPeriod() {
			super();			
		}	
		
		public IntegerFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<Integer> integers, ExecCtx ctx) throws Exception {
			
			Iterator<Integer> iterator = integers.iterator();
			
			if (this.periodType != null) {
				// Check list size is consistent with periodType
				if (integers.size() != this.periodType.size()) { 
					throw new ExecutionException(
							"Integer arguments list for Period conversion with the periodType " +
							this.periodType.getName() + " should have size " + this.periodType.size() +
							". Size " + integers.size() + " is not valid.");
				}				
				
				int years = 0;
				int months = 0;
				int weeks = 0;
				int days = 0;
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				int millis = 0;
				if (this.periodType.isSupported(DurationFieldType.years())) {
					years = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.months())) {
					months = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.weeks())) {
					weeks = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.days())) {
					days = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.hours())) {
					hours = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.minutes())) {
					minutes = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.seconds())) {
					seconds = iterator.next().intValue();					
				}
				if (this.periodType.isSupported(DurationFieldType.millis())) {
					millis = iterator.next().intValue();					
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
				return new Period(iterator.next().intValue(), iterator.next().intValue(), 
						iterator.next().intValue(), iterator.next().intValue());
			} 
			
			// years, months, weeks, days, hours, minutes, seconds and milliseconds
			return new Period(iterator.next().intValue(), iterator.next().intValue(), 
					iterator.next().intValue(), iterator.next().intValue(),
					iterator.next().intValue(), iterator.next().intValue(),
					iterator.next().intValue(), iterator.next().intValue());
		}		
	}	
	
	static final class IntegerFieldArrayToPeriod extends BaseToPeriod<Integer[]> {

		public IntegerFieldArrayToPeriod() {
			super();			
		}		
		
		public IntegerFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
	
	static final class StringFieldCollectionToPeriod extends BaseToPeriod<Collection<String>> {

		public StringFieldCollectionToPeriod() {
			super();			
		}	
		
		public StringFieldCollectionToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Period nullAsNullExecute(final Collection<String> strings, ExecCtx ctx) throws Exception {
			
			Iterator<String> iterator = strings.iterator();
			
			if (this.periodType != null) {
				// Check list size is consistent with periodType
				if (strings.size() != this.periodType.size()) { 
					throw new ExecutionException(
							"String arguments list for Period conversion with the periodType " +
							this.periodType.getName() + " should have size " + this.periodType.size() +
							". Size " + strings.size() + " is not valid.");
				}				
				
				int years = 0;
				int months = 0;
				int weeks = 0;
				int days = 0;
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				int millis = 0;
				if (this.periodType.isSupported(DurationFieldType.years())) {
					years = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.months())) {
					months = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.weeks())) {
					weeks = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.days())) {
					days = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.hours())) {
					hours = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.minutes())) {
					minutes = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.seconds())) {
					seconds = Integer.parseInt(iterator.next());					
				}
				if (this.periodType.isSupported(DurationFieldType.millis())) {
					millis = Integer.parseInt(iterator.next());					
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
				return new Period(Integer.parseInt(iterator.next()), Integer.parseInt(iterator.next()), 
						Integer.parseInt(iterator.next()), Integer.parseInt(iterator.next()));
			} 
			
			// years, months, weeks, days, hours, minutes, seconds and milliseconds
			return new Period(Integer.parseInt(iterator.next()), Integer.parseInt(iterator.next()), 
					Integer.parseInt(iterator.next()), Integer.parseInt(iterator.next()),
					Integer.parseInt(iterator.next()), Integer.parseInt(iterator.next()),
					Integer.parseInt(iterator.next()), Integer.parseInt(iterator.next()));
		}		
	}	
	
	static final class StringFieldArrayToPeriod extends BaseToPeriod<String[]> {

		public StringFieldArrayToPeriod() {
			super();			
		}		
		
		public StringFieldArrayToPeriod(PeriodType periodType) {
			super(periodType);
		}	
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
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
