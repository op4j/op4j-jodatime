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
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.base.BaseDateTime;
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
//	private static final FromDateFieldArray FROM_DATE_FIELD_ARRAY = new FromDateFieldArray();
	
	private static final FromTimestampFieldList FROM_TIMESTAMP_FIELD_LIST = new FromTimestampFieldList();
	private static final FromTimestampFieldArray FROM_TIMESTAMP_FIELD_ARRAY = new FromTimestampFieldArray();
	
	private static final FromLong FROM_LONG = new FromLong();
	
	private static final FromLongFieldList FROM_LONG_FIELD_LIST = new FromLongFieldList();
	private static final FromLongFieldArray FROM_LONG_FIELD_ARRAY = new FromLongFieldArray();
	
	private static final FromCalendarFieldList FROM_CALENDAR_FIELD_LIST = new FromCalendarFieldList();
//	private static final FromCalendarFieldArray FROM_CALENDAR_FIELD_ARRAY = new FromCalendarFieldArray();
	
	private static final FromBaseDateTimeFieldList FROM_BASEDATETIME_FIELD_LIST = new FromBaseDateTimeFieldList();
//	private static final FromBaseDateTimeFieldArray FROM_BASEDATETIME_FIELD_ARRAY = new FromBaseDateTimeFieldArray();
	
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
	public static final FromDateFieldList fromDateFieldList(final PeriodType periodType, final Chronology chronology) {
		return new FromDateFieldList(periodType, chronology);
	}
	public static final <T extends Date> FromDateFieldArray<T> fromDateFieldArray() {
//		return FROM_DATE_FIELD_ARRAY;
		return new FromDateFieldArray<T>();
	}	
	public static final <T extends Date> FromDateFieldArray<T> fromDateFieldArray(final Chronology chronology) {
		return new FromDateFieldArray<T>(chronology);
	}	
	public static final <T extends Date> FromDateFieldArray<T> fromDateFieldArray(final PeriodType periodType) {
		return new FromDateFieldArray<T>(periodType);
	}
	public static final <T extends Date> FromDateFieldArray<T> fromDateFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new FromDateFieldArray<T>(periodType, chronology);
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
	public static final FromTimestampFieldList fromTimestampFieldList(final PeriodType periodType, final Chronology chronology) {
		return new FromTimestampFieldList(periodType, chronology);
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
	public static final FromTimestampFieldArray fromTimestampFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new FromTimestampFieldArray(periodType, chronology);
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
	public static final FromCalendarFieldList fromCalendarFieldList(final PeriodType periodType, final Chronology chronology) {
		return new FromCalendarFieldList(periodType, chronology);
	}
	public static final <T extends Calendar> FromCalendarFieldArray<T> fromCalendarFieldArray() {
//		return FROM_CALENDAR_FIELD_ARRAY;
		return new FromCalendarFieldArray<T>();
	}	
	public static final <T extends Calendar> FromCalendarFieldArray<T> fromCalendarFieldArray(final Chronology chronology) {
		return new FromCalendarFieldArray<T>(chronology);
	}	
	public static final <T extends Calendar> FromCalendarFieldArray<T> fromCalendarFieldArray(final PeriodType periodType) {
		return new FromCalendarFieldArray<T>(periodType);
	}
	public static final <T extends Calendar> FromCalendarFieldArray<T> fromCalendarFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new FromCalendarFieldArray<T>(periodType, chronology);
	}
	//
	
	// Conversion from two datetime objects
	public static final FromBaseDateTimeFieldList fromBaseDateTimeFieldList() {
		return FROM_BASEDATETIME_FIELD_LIST;
	}	
	public static final FromBaseDateTimeFieldList fromBaseDateTimeFieldList(final Chronology chronology) {
		return new FromBaseDateTimeFieldList(chronology);
	}	
	public static final FromBaseDateTimeFieldList fromBaseDateTimeFieldList(final PeriodType periodType) {
		return new FromBaseDateTimeFieldList(periodType);
	}
	public static final FromBaseDateTimeFieldList fromBaseDateTimeFieldList(final PeriodType periodType, final Chronology chronology) {
		return new FromBaseDateTimeFieldList(periodType, chronology);
	}
	public static final <T extends BaseDateTime> FromBaseDateTimeFieldArray<T> fromBaseDateTimeFieldArray() {
//		return FROM_BASEDATETIME_FIELD_ARRAY;
		return new FromBaseDateTimeFieldArray<T>();
	}	
	public static final <T extends BaseDateTime> FromBaseDateTimeFieldArray<T> fromBaseDateTimeFieldArray(final Chronology chronology) {
		return new FromBaseDateTimeFieldArray<T>(chronology);
	}	
	public static final <T extends BaseDateTime> FromBaseDateTimeFieldArray<T> fromBaseDateTimeFieldArray(final PeriodType periodType) {
		return new FromBaseDateTimeFieldArray<T>(periodType);
	}
	public static final <T extends BaseDateTime> FromBaseDateTimeFieldArray<T> fromBaseDateTimeFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new FromBaseDateTimeFieldArray<T>(periodType, chronology);
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
	
	
	private static abstract class BaseToPeriod<T> implements IFunc<Period, T> {

		Chronology chronology = null;
		PeriodType periodType = null;
		
		public BaseToPeriod() {
			super();			
		}

		public BaseToPeriod(Chronology chronology) {
			super();
			this.chronology = chronology;
		}

		public BaseToPeriod(PeriodType periodType) {
			super();
			this.periodType = periodType;
		}

		public BaseToPeriod(PeriodType periodType, Chronology chronology) {
			super();
			this.chronology = chronology;
			this.periodType = periodType;
		}
		
	}
	
	public static final class FromDateFieldList extends BaseToPeriod<List<? extends Date>> {

		public FromDateFieldList() {
			super();			
		}		
		
		public FromDateFieldList(Chronology chronology) {
			super(chronology);					
		}
		
		public FromDateFieldList(PeriodType periodType) {
			super(periodType);
		}
		
		public FromDateFieldList(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * The given java.util.Date targets will be used as the start and end instants of the Period
		 * returned
		 *  
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final List<? extends Date> dates) throws Exception {
			if (dates.size() != 2 ) {
				throw new FunctionExecutionException(
						"Timestamp arguments list for Period conversion should of sizes " +
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
	
	public static final class FromDateFieldArray<T extends Date> extends BaseToPeriod<T[]> {

		public FromDateFieldArray() {
			super();			
		}		
		
		public FromDateFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public FromDateFieldArray(PeriodType periodType) {
			super(periodType);
		}
		
		public FromDateFieldArray(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * The given java.util.Date targets will be used as the start and end instants of the Period
		 * returned
		 *  
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final T[] dates) throws Exception {
			if (dates.length != 2 ) {
				throw new FunctionExecutionException(
						"Timestamp arguments array for Period conversion should of sizes " +
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
	
	public static final class FromTimestampFieldList extends BaseToPeriod<List<Timestamp>> {

		public FromTimestampFieldList() {
			super();			
		}		
		
		public FromTimestampFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public FromTimestampFieldList(PeriodType periodType) {
			super(periodType);
		}
		
		public FromTimestampFieldList(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * The given java.sql.Timestamp target elements will be used as the start and end
		 * instants of the Period returned
		 *                 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final List<Timestamp> timestamps) throws Exception {
			if (timestamps.size() != 2 ) {
				throw new FunctionExecutionException(
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
	
	public static final class FromTimestampFieldArray extends BaseToPeriod<Timestamp[]> {

		public FromTimestampFieldArray() {
			super();			
		}		
		
		public FromTimestampFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public FromTimestampFieldArray(PeriodType periodType) {
			super(periodType);
		}
		
		public FromTimestampFieldArray(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * The given java.sql.Timestamp target elements will be used as the start and end
		 * instants of the Period returned
		 *                 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final Timestamp[] timestamps) throws Exception {
			if (timestamps.length != 2 ) {
				throw new FunctionExecutionException(
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
	
	public static final class FromLong extends BaseToPeriod<Long> {

		public FromLong() {
			super();			
		}		
		
		public FromLong(Chronology chronology) {
			super(chronology);
		}
		
		public FromLong(PeriodType periodType) {
			super(periodType);
		}
		
		public FromLong(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * It returns a Period with the given Duration in milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final Long theLong) throws Exception {
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
	
	public static final class FromLongFieldList extends BaseToPeriod<List<Long>> {

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
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * The given long targets representing the time in millis will be used as the start
		 * and end instants of the Period returned
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
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
	
	public static final class FromLongFieldArray extends BaseToPeriod<Long[]> {

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
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * The given long targets representing the time in millis will be used as the start
		 * and end instants of the Period returned
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
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
	 
	public static final class FromCalendarFieldList extends BaseToPeriod<List<? extends Calendar>> {

		public FromCalendarFieldList() {
			super();			
		}		
		
		public FromCalendarFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public FromCalendarFieldList(PeriodType periodType) {
			super(periodType);
		}
		
		public FromCalendarFieldList(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * It creates a Period with the given Calendar targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final List<? extends Calendar> calendars) throws Exception {
			if (calendars.size() != 2 ) {
				throw new FunctionExecutionException(
						"Calendar arguments list for Period conversion should of sizes " +
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
	
	public static final class FromCalendarFieldArray<T extends Calendar> extends BaseToPeriod<T[]> {

		public FromCalendarFieldArray() {
			super();			
		}		
		
		public FromCalendarFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public FromCalendarFieldArray(PeriodType periodType) {
			super(periodType);
		}
		
		public FromCalendarFieldArray(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * It creates a Period with the given Calendar targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final T[] calendars) throws Exception {
			if (calendars.length != 2 ) {
				throw new FunctionExecutionException(
						"Calendar arguments array for Period conversion should of sizes " +
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
	
	public static final class FromBaseDateTimeFieldList extends BaseToPeriod<List<? extends BaseDateTime>> {

		public FromBaseDateTimeFieldList() {
			super();			
		}		
		
		public FromBaseDateTimeFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public FromBaseDateTimeFieldList(PeriodType periodType) {
			super(periodType);
		}
		
		public FromBaseDateTimeFieldList(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * It creates a Period with the given DateTime targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final List<? extends BaseDateTime> dateTimes) throws Exception {
			if (dateTimes.size() != 2 ) {
				throw new FunctionExecutionException(
						"DateTime arguments list for Period conversion should of sizes " +
						"2. Size " + dateTimes.size() + " is not valid.");
			}
			if (this.periodType != null && this.chronology != null) {
				return new Period(dateTimes.get(0).getMillis(), dateTimes.get(1).getMillis(), this.periodType, this.chronology);
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
	
	public static final class FromBaseDateTimeFieldArray<T extends BaseDateTime> extends BaseToPeriod<T[]> {

		public FromBaseDateTimeFieldArray() {
			super();			
		}		
		
		public FromBaseDateTimeFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public FromBaseDateTimeFieldArray(PeriodType periodType) {
			super(periodType);
		}
		
		public FromBaseDateTimeFieldArray(PeriodType periodType, Chronology chronology) {
			super(periodType, chronology);
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * It creates a Period with the given DateTime targets as the start and end of it
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public Period execute(final T[] dateTimes) throws Exception {
			if (dateTimes.length != 2 ) {
				throw new FunctionExecutionException(
						"DateTime arguments array for Period conversion should of sizes " +
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
	
	public static final class FromIntegerFieldList extends BaseToPeriod<List<Integer>> {

		public FromIntegerFieldList() {
			super();			
		}	
		
		public FromIntegerFieldList(PeriodType periodType) {
			super(periodType);
		}	
		
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
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
	
	public static final class FromIntegerFieldArray extends BaseToPeriod<Integer[]> {

		public FromIntegerFieldArray() {
			super();			
		}		
		
		public FromIntegerFieldArray(PeriodType periodType) {
			super(periodType);
		}	
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
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
	
	public static final class FromStringFieldList extends BaseToPeriod<List<String>> {

		public FromStringFieldList() {
			super();			
		}	
		
		public FromStringFieldList(PeriodType periodType) {
			super(periodType);
		}	
		
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
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
	
	public static final class FromStringFieldArray extends BaseToPeriod<String[]> {

		public FromStringFieldArray() {
			super();			
		}		
		
		public FromStringFieldArray(PeriodType periodType) {
			super(periodType);
		}	
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		/* 
		 * A Period is created either:
		 * - from the given hours, minutes, seconds and milliseconds
		 * - from the given years, months, weeks, days, hours, minutes, seconds and milliseconds
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
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
