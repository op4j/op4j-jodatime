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
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
public final class FnToDateTime {
	
	private final static TimestampToDateTime TIMESTAMP_TO_DATE_TIME = new TimestampToDateTime();
	private final static LongToDateTime LONG_TO_DATE_TIME = new LongToDateTime();
	private final static IntegerFieldListToDateTime INTEGER_FIELD_LIST_TO_DATE_TIME = new IntegerFieldListToDateTime();
	private final static IntegerFieldArrayToDateTime INTEGER_FIELD_ARRAY_TO_DATE_TIME = new IntegerFieldArrayToDateTime();
	private final static StringFieldListToDateTime STRING_FIELD_LIST_TO_DATE_TIME = new StringFieldListToDateTime();
	private final static StringFieldArrayToDateTime STRING_FIELD_ARRAY_TO_DATE_TIME = new StringFieldArrayToDateTime();
	
	private FnToDateTime() {
		super();
	}
		
	// From String
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the 
	 * given pattern parameter. If the pattern includes either, the name of 
	 * the month or day of week, a conversion accepting a {@link Locale} must 
	 * be used instead 
	 * 
	 * @param pattern
	 * @return
	 */
	public static final StringToDateTime fromString(String pattern) {
		return new StringToDateTime(pattern);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final StringToDateTime fromString(String pattern, DateTimeZone dateTimeZone) {
		return new StringToDateTime(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final StringToDateTime fromString(String pattern, Chronology chronology) {
		return new StringToDateTime(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringToDateTime fromString(String pattern, Locale locale) {
		return new StringToDateTime(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringToDateTime fromString(String pattern, String locale) {
		return new StringToDateTime(pattern, locale);
	}
	/**
	 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final StringToDateTime fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringToDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final StringToDateTime fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringToDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final StringToDateTime fromString(String pattern, Locale locale, Chronology chronology) {
		return new StringToDateTime(pattern, locale, chronology);
	}
	/**
	 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final StringToDateTime fromString(String pattern, String locale, Chronology chronology) {
		return new StringToDateTime(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Date} is converted into a {@link DateTime}
	 */
	public static final <T extends Date> DateToDateTime<T> fromDate() {
		return new DateToDateTime<T>();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> DateToDateTime<T> fromDate(DateTimeZone dateTimeZone) {
		return new DateToDateTime<T>(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> DateToDateTime<T> fromDate(Chronology chronology) {
		return new DateToDateTime<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime}
	 */
	public static final TimestampToDateTime fromTimestamp() {
		return TIMESTAMP_TO_DATE_TIME;
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final TimestampToDateTime fromTimestamp(DateTimeZone dateTimeZone) {
		return new TimestampToDateTime(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final TimestampToDateTime fromTimestamp(Chronology chronology) {
		return new TimestampToDateTime(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime}
	 */
	public static final LongToDateTime fromLong() {
		return LONG_TO_DATE_TIME;
	}
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final LongToDateTime fromLong(DateTimeZone dateTimeZone) {
		return new LongToDateTime(dateTimeZone);
	}
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final LongToDateTime fromLong(Chronology chronology) {
		return new LongToDateTime(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * A {@link DateTime} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IntegerFieldListToDateTime fromIntegerFieldList() {
		return INTEGER_FIELD_LIST_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IntegerFieldListToDateTime fromIntegerFieldList(Chronology chronology) {
		return new  IntegerFieldListToDateTime(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * A {@link DateTime} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IntegerFieldArrayToDateTime fromIntegerFieldArray() {
		return INTEGER_FIELD_ARRAY_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IntegerFieldArrayToDateTime fromIntegerFieldArray(Chronology chronology) {
		return new  IntegerFieldArrayToDateTime(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * A {@link DateTime} is created from the given {@link String} list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final StringFieldListToDateTime fromStringFieldList() {
		return STRING_FIELD_LIST_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final StringFieldListToDateTime fromStringFieldList(Chronology chronology) {
		return new  StringFieldListToDateTime(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final StringFieldArrayToDateTime fromStringFieldArray() {
		return STRING_FIELD_ARRAY_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final StringFieldArrayToDateTime fromStringFieldArray(Chronology chronology) {
		return new  StringFieldArrayToDateTime(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * It converts a {@link Calendar} into a {@link DateTime}
	 */
	public static final <T extends Calendar> CalendarToDateTime<T> fromCalendar() {
		return new CalendarToDateTime<T>();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> CalendarToDateTime<T> fromCalendar(DateTimeZone dateTimeZone) {
		return new CalendarToDateTime<T>(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> CalendarToDateTime<T> fromCalendar(Chronology chronology) {
		return new CalendarToDateTime<T>(chronology);
	}
	//
	
	
	private static abstract class BaseToDateTime<T> extends AbstractNullAsNullFunction<T, DateTime> {

		final DateTimeZone dateTimeZone;
		final Chronology chronology;
		
		public BaseToDateTime() {
			super();		
			this.dateTimeZone = null;
			this.chronology = null;
		}

		public BaseToDateTime(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
			
			this.dateTimeZone = dateTimeZone;
			this.chronology = null;
		}

		public BaseToDateTime(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.dateTimeZone = null;
			this.chronology = chronology;
		}
	}
	
	static final class StringToDateTime extends BaseToDateTime<String> {

		private final String pattern;
		private final Locale locale;
		
		
		public StringToDateTime(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToDateTime(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToDateTime(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToDateTime(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToDateTime(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToDateTime(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToDateTime(String pattern, String locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(String object, ExecCtx ctx) throws Exception {
			DateTimeFormatter dateTimeFormatter = null;
		    if (this.locale == null) {
		        if (StringUtils.contains(this.pattern, "MMM") || StringUtils.contains(this.pattern, "EEE")) {
		        	throw new ExecutionException(
							"The use of MMM, MMMM, EEE or EEEE as part of the date pattern requires a Locale");
	            }
		        dateTimeFormatter = DateTimeFormat.forPattern(this.pattern);        
		    } else {    
		        dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withLocale(this.locale);
		    }
		    
		    DateTime result = new DateTime();
		    if (this.dateTimeZone != null) {	    	
		    	dateTimeFormatter = dateTimeFormatter.withZone(this.dateTimeZone);
		    }
		    if (this.chronology != null) {
		    	dateTimeFormatter = dateTimeFormatter.withChronology(this.chronology);
		    }
			result = dateTimeFormatter.parseDateTime(object).toDateTime();
			
			return result;		
		}
		
		
	}	
	
	static final class DateToDateTime<T extends Date> extends BaseToDateTime<T> {

		public DateToDateTime() {
			super();			
		}

		public DateToDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public DateToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object.getTime(), this.chronology);
			}
			
			return new DateTime(object.getTime());
		}
		
		
	}	
	
	static final class TimestampToDateTime extends BaseToDateTime<Timestamp> {

		public TimestampToDateTime() {
			super();			
		}

		public TimestampToDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public TimestampToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(Timestamp object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object.getTime(), this.chronology);
			}
			
			return new DateTime(object.getTime());
		}
	}	
	
	static final class LongToDateTime extends BaseToDateTime<Long> {

		public LongToDateTime() {
			super();			
		}

		public LongToDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public LongToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(Long object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object.longValue(), this.chronology);
			}
			
			return new DateTime(object.longValue());
		}
	}	
	
	static final class IntegerFieldListToDateTime extends BaseToDateTime<List<Integer>> {

		public IntegerFieldListToDateTime() {
			super();			
		}

		public IntegerFieldListToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(List<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new ExecutionException(
						"Integer arguments list for DateTime conversion should of size " +
						"between 4 and 7 (year, month, day, hour, minute, second, millisecond). Size " + object.size() + " is not valid.");
			}			
			
			int year = object.get(0).intValue();
			int month = object.get(1).intValue();
			int day = object.get(2).intValue();
			int hour = object.get(3).intValue();
			int minute = (object.size() >= 5) ? object.get(4).intValue() : 0;
			int second = (object.size() >= 6) ? object.get(5).intValue() : 0;
			int milli = (object.size() >= 7) ? object.get(6).intValue() : 0;
			
			if (this.chronology != null) {
	        	return new DateTime(year, month, day, hour, minute, second, milli, this.chronology);
	        }
			return new DateTime(year, month, day,  hour, minute, second, milli);
		}
	}	
	
	static final class IntegerFieldArrayToDateTime extends BaseToDateTime<Integer[]> {

		public IntegerFieldArrayToDateTime() {
			super();			
		}

		public IntegerFieldArrayToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(Integer[] object, ExecCtx ctx) throws Exception {
			if (object.length < 4 || object.length > 7) {
				throw new ExecutionException(
						"Integer arguments array for DateTime conversion should of size " +
						"between 4 and 7 (year, month, day, hour, minute, second, millisecond). Size " + object.length + " is not valid.");
			}		
			
			int year = object[0].intValue();
			int month = object[1].intValue();
			int day = object[2].intValue();
			int hour = object[3].intValue();
			int minute = (object.length >= 5) ? object[4].intValue() : 0;
			int second = (object.length >= 6) ? object[5].intValue() : 0;
			int milli = (object.length >= 7) ? object[6].intValue() : 0;
			
			if (this.chronology != null) {
	        	return new DateTime(year, month, day, hour, minute, second, milli, this.chronology);
	        }
			return new DateTime(year, month, day, hour, minute, second, milli);
		}
		
	}	
	
	
	
	static final class StringFieldListToDateTime extends BaseToDateTime<List<String>> {

		public StringFieldListToDateTime() {
			super();			
		}

		public StringFieldListToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(List<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new ExecutionException(
						"String arguments list for DateTime conversion should of size " +
						"between 4 and 7 (year, month, day, hour, minute, second, millisecond). Size " + object.size() + " is not valid.");
			}			
			
			String year = object.get(0);
			String month = object.get(1);
			String day = object.get(2);
			String hour = object.get(3);
			String minute = (object.size() >= 5) ? object.get(4) : "0";
			String second = (object.size() >= 6) ? object.get(5) : "0";
			String milli = (object.size() >= 7) ? object.get(6) : "0";
			
			if (this.chronology != null) {
	        	return new DateTime(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
	        			Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli),
	        			this.chronology);
	        }
			return new DateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
					Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli));
		}
	}	
	
	static final class StringFieldArrayToDateTime extends BaseToDateTime<String[]> {

		public StringFieldArrayToDateTime() {
			super();			
		}

		public StringFieldArrayToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(String[] object, ExecCtx ctx) throws Exception {
			if (object.length < 4 || object.length > 7) {
				throw new ExecutionException(
						"String arguments array for DateTime conversion should of size " +
						"between 4 and 7 (year, month, day, hour, minute, second, millisecond). Size " + object.length + " is not valid.");
			}			
			
			String year = object[0];
			String month = object[1];
			String day = object[2];
			String hour = object[3];
			String minute = (object.length >= 5) ? object[4] : "0";
			String second = (object.length >= 6) ? object[5] : "0";
			String milli = (object.length >= 7) ? object[6] : "0";
			
			if (this.chronology != null) {
	        	return new DateTime(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day), 
	        			Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli),
	        			this.chronology);
	        }
			return new DateTime(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
					Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli));
		}
	}	
	
	static final class CalendarToDateTime<T extends Calendar> extends BaseToDateTime<T> {

		public CalendarToDateTime() {
			super();			
		}

		public CalendarToDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public CalendarToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object, this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object, this.chronology);
			}
			return new DateTime(object);
		}
	}	
}
