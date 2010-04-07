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

package org.op4j.jodatime.functions;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.AbstractNullAsNullFunction;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.Function;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public final class FnToLocalTime {
	
	private final static TimestampToLocalTime TIMESTAMP_TO_LOCAL_TIME = new TimestampToLocalTime();
	private final static LongToLocalTime LONG_TO_LOCAL_TIME = new LongToLocalTime();
	private final static IntegerFieldCollectionToLocalTime INTEGER_FIELD_LIST_TO_LOCAL_TIME = new IntegerFieldCollectionToLocalTime();
	private final static IntegerFieldArrayToLocalTime INTEGER_FIELD_ARRAY_TO_LOCAL_TIME = new IntegerFieldArrayToLocalTime();
	private final static StringFieldCollectionToLocalTime STRING_FIELD_LIST_TO_LOCAL_TIME = new StringFieldCollectionToLocalTime();
	private final static StringFieldArrayToLocalTime STRING_FIELD_ARRAY_TO_LOCAL_TIME = new StringFieldArrayToLocalTime();
	
	
	private FnToLocalTime() {
		super();
	}
		
	// From String
	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern 
	 */
	public static final Function<String, LocalTime> fromString(String pattern) {
		return new StringToLocalTime(pattern);
	}	
	/**
	 * It converts the given String into a {@link LocalTime} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final Function<String, LocalTime> fromString(String pattern, DateTimeZone dateTimeZone) {
		return new StringToLocalTime(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Chronology chronology) {
		return new StringToLocalTime(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Locale locale) {
		return new StringToLocalTime(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, LocalTime> fromString(String pattern, String locale) {
		return new StringToLocalTime(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringToLocalTime(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final Function<String, LocalTime> fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringToLocalTime(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Locale locale, Chronology chronology) {
		return new StringToLocalTime(pattern, locale, chronology);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final Function<String, LocalTime> fromString(String pattern, String locale, Chronology chronology) {
		return new StringToLocalTime(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Date} is converted into a {@link LocalTime}
	 */
	public static final <T extends Date> Function<T, LocalTime> fromDate() {
		return new DateToLocalTime<T>();
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalTime} configured with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> Function<T, LocalTime> fromDate(DateTimeZone dateTimeZone) {
		return new DateToLocalTime<T>(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> Function<T, LocalTime> fromDate(Chronology chronology) {
		return new DateToLocalTime<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime}
	 */
	public static final Function<Timestamp, LocalTime> fromTimestamp() {
		return TIMESTAMP_TO_LOCAL_TIME;
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Timestamp, LocalTime> fromTimestamp(DateTimeZone dateTimeZone) {
		return new TimestampToLocalTime(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Timestamp, LocalTime> fromTimestamp(Chronology chronology) {
		return new TimestampToLocalTime(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime}
	 */
	public static final Function<Long, LocalTime> fromLong() {
		return LONG_TO_LOCAL_TIME;
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Long, LocalTime> fromLong(DateTimeZone dateTimeZone) {
		return new LongToLocalTime(dateTimeZone);
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Long, LocalTime> fromLong(Chronology chronology) {
		return new LongToLocalTime(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<Collection<Integer>, LocalTime> fromIntegerFieldCollection() {
		return INTEGER_FIELD_LIST_TO_LOCAL_TIME;
	}
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<Integer>, LocalTime> fromIntegerFieldCollection(Chronology chronology) {
		return new IntegerFieldCollectionToLocalTime(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<Integer[], LocalTime> fromIntegerFieldArray() {
		return INTEGER_FIELD_ARRAY_TO_LOCAL_TIME;
	}
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Integer[], LocalTime> fromIntegerFieldArray(Chronology chronology) {
		return new IntegerFieldArrayToLocalTime(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * A {@link LocalTime} is created from the given {@link String} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<Collection<String>, LocalTime> fromStringFieldCollection() {
		return STRING_FIELD_LIST_TO_LOCAL_TIME;
	}
	/**
	 * A {@link LocalTime} is created from the given {@link String} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<String>, LocalTime> fromStringFieldCollection(Chronology chronology) {
		return new StringFieldCollectionToLocalTime(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<String[], LocalTime> fromStringFieldArray() {
		return STRING_FIELD_ARRAY_TO_LOCAL_TIME;
	}
	/**
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<String[], LocalTime> fromStringFieldArray(Chronology chronology) {
		return new StringFieldArrayToLocalTime(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime}
	 */
	public static final <T extends Calendar> Function<T, LocalTime> fromCalendar() {
		return new CalendarToLocalTime<T>();
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> Function<T, LocalTime> fromCalendar(DateTimeZone dateTimeZone) {
		return new CalendarToLocalTime<T>(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> Function<T, LocalTime> fromCalendar(Chronology chronology) {
		return new CalendarToLocalTime<T>(chronology);
	}
	//
	
		
	static abstract class BaseToLocalTime<T> extends AbstractNullAsNullFunction<T, LocalTime> {

		final DateTimeZone dateTimeZone;
		final Chronology chronology;
		
		public BaseToLocalTime() {
			super();
			
			this.dateTimeZone = null;
			this.chronology = null;
		}

		public BaseToLocalTime(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
			
			this.dateTimeZone = dateTimeZone;
			this.chronology = null;
		}

		public BaseToLocalTime(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.dateTimeZone = null;
			this.chronology = chronology;
		}
	}
	
	static final class StringToLocalTime extends BaseToLocalTime<String> {

		private final String pattern;
		private final Locale locale;
		
		
		public StringToLocalTime(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToLocalTime(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToLocalTime(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToLocalTime(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToLocalTime(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToLocalTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToLocalTime(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToLocalTime(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToLocalTime(String pattern, String locale, Chronology chronology) {
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
		public LocalTime nullAsNullExecute(String object, ExecCtx ctx) throws Exception {
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
		    
		    LocalTime result = new LocalTime();
		    if (this.dateTimeZone != null) {	    	
		    	dateTimeFormatter = dateTimeFormatter.withZone(this.dateTimeZone);
		    }
		    if (this.chronology != null) {
		    	dateTimeFormatter = dateTimeFormatter.withChronology(this.chronology);
		    }
			result = dateTimeFormatter.parseDateTime(object).toLocalTime();
			
			return result;		
		}
		
		
	}	
	
	static final class DateToLocalTime<T extends Date> extends BaseToLocalTime<T> {

		public DateToLocalTime() {
			super();			
		}

		public DateToLocalTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public DateToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object.getTime(), this.chronology);
			}
			
			return new LocalTime(object.getTime());
		}
	}	
	
	static final class TimestampToLocalTime extends BaseToLocalTime<Timestamp> {

		public TimestampToLocalTime() {
			super();			
		}

		public TimestampToLocalTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public TimestampToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(Timestamp object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object.getTime(), this.chronology);
			}
			
			return new LocalTime(object.getTime());
		}
	}	
	
	static final class LongToLocalTime extends BaseToLocalTime<Long> {

		public LongToLocalTime() {
			super();			
		}

		public LongToLocalTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public LongToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(Long object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object.longValue(), this.chronology);
			}
			
			return new LocalTime(object.longValue());
		}
	}	
	
	static final class IntegerFieldCollectionToLocalTime extends BaseToLocalTime<Collection<Integer>> {

		public IntegerFieldCollectionToLocalTime() {
			super();			
		}

		public IntegerFieldCollectionToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(Collection<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 4) {
				throw new ExecutionException(
						"Integer arguments list for LocalTime conversion should have a size " +
						"between 1 and 4. Size " + object.size() + " is not valid.");
			}			
			
			Iterator<Integer> iterator = object.iterator();
			
			int hour = iterator.next().intValue();
			int minute = (object.size() >= 2) ? iterator.next().intValue() : 0;
			int second = (object.size() >= 3) ? iterator.next().intValue() : 0;
			int milli = (object.size() >= 4) ? iterator.next().intValue() : 0;
			
			if (this.chronology != null) {
	        	return new LocalTime(hour, minute, second, 
	        			milli, this.chronology);
	        }
			return new LocalTime(hour, minute, second, 
        			milli);
		}
	}	
	
	static final class IntegerFieldArrayToLocalTime extends BaseToLocalTime<Integer[]> {

		public IntegerFieldArrayToLocalTime() {
			super();			
		}

		public IntegerFieldArrayToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(Integer[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 4) {
				throw new ExecutionException(
						"Integer arguments array for LocalTime conversion should have a size " +
						"between 1 and 4. Size " + object.length + " is not valid.");
			}			
			
			int hour = object[0].intValue();
			int minute = (object.length >= 2) ? object[1].intValue() : 0;
			int second = (object.length >= 3) ? object[2].intValue() : 0;
			int milli = (object.length >= 4) ? object[3].intValue() : 0;
			
			if (this.chronology != null) {
	        	return new LocalTime(hour, minute, second, 
	        			milli, this.chronology);
	        }
			return new LocalTime(hour, minute, second, 
        			milli);
		}
		
	}	
	
	
	
	static final class StringFieldCollectionToLocalTime extends BaseToLocalTime<Collection<String>> {

		public StringFieldCollectionToLocalTime() {
			super();			
		}

		public StringFieldCollectionToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(Collection<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 4) {
				throw new ExecutionException(
						"String arguments list for LocalTime conversion should have a size " +
						"between 1 and 4. Size " + object.size() + " is not valid.");
			}			
			
			Iterator<String> iterator = object.iterator();
			
			String hour = iterator.next();
			String minute = (object.size() >= 2) ? iterator.next() : "0";
			String second = (object.size() >= 3) ? iterator.next() : "0";
			String milli = (object.size() >= 4) ? iterator.next() : "0";
			
			if (this.chronology != null) {
	        	return new LocalTime(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second), 
	        			Integer.parseInt(milli), this.chronology);
	        }
			return new LocalTime(Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), 
        			Integer.parseInt(milli));
		}
		
		
	}	
	
	static final class StringFieldArrayToLocalTime extends BaseToLocalTime<String[]> {

		public StringFieldArrayToLocalTime() {
			super();			
		}

		public StringFieldArrayToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(String[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 4) {
				throw new ExecutionException(
						"String arguments array for LocalTime conversion should have a size " +
						"between 1 and 4. Size " + object.length + " is not valid.");
			}			
			
			String hour = object[0];
			String minute = (object.length >= 2) ? object[1] : "0";
			String second = (object.length >= 3) ? object[2] : "0";
			String milli = (object.length >= 4) ? object[3] : "0";
			
			if (this.chronology != null) {
	        	return new LocalTime(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second), 
	        			Integer.parseInt(milli), this.chronology);
	        }
			return new LocalTime(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second), 
        			Integer.parseInt(milli));
		}
	}	
	
	static final class CalendarToLocalTime<T extends Calendar> extends BaseToLocalTime<T> {

		public CalendarToLocalTime() {
			super();			
		}

		public CalendarToLocalTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public CalendarToLocalTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalTime nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object, this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object, this.chronology);
			}
			return new LocalTime(object);
		}
	}	
}
