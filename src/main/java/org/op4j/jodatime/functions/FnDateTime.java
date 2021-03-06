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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.AbstractNullAsNullFunction;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.Function;

/**
 * 
 * @since 1.1
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public final class FnDateTime {
	
	private final static TimestampToDateTime TIMESTAMP_TO_DATE_TIME = new TimestampToDateTime();
	private final static LongToDateTime LONG_TO_DATE_TIME = new LongToDateTime();
	private final static IntegerFieldCollectionToDateTime INTEGER_FIELD_COLLECTION_TO_DATE_TIME = new IntegerFieldCollectionToDateTime();
	private final static IntegerFieldArrayToDateTime INTEGER_FIELD_ARRAY_TO_DATE_TIME = new IntegerFieldArrayToDateTime();
	private final static StringFieldCollectionToDateTime STRING_FIELD_COLLECTION_TO_DATE_TIME = new StringFieldCollectionToDateTime();
	private final static StringFieldArrayToDateTime STRING_FIELD_ARRAY_TO_DATE_TIME = new StringFieldArrayToDateTime();
	
	private FnDateTime() {
		super();
	}
		
	// From String
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the 
	 * given pattern parameter. If the pattern includes either, the name of 
	 * the month or day of week, a conversion accepting a {@link Locale} must 
	 * be used instead 
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern) {
		return new StringToDateTime(pattern);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, DateTimeZone dateTimeZone) {
		return new StringToDateTime(pattern, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 * 		                
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, Chronology chronology) {
		return new StringToDateTime(pattern, chronology);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale) {
		return new StringToDateTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale) {
		return new StringToDateTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringToDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringToDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, Chronology chronology) {
		return new StringToDateTime(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, Chronology chronology) {
		return new StringToDateTime(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime() {
		return new DateToDateTime<T>();
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateTime} configured with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(DateTimeZone dateTimeZone) {
		return new DateToDateTime<T>(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(Chronology chronology) {
		return new DateToDateTime<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Timestamp, DateTime> timestampToDateTime() {
		return TIMESTAMP_TO_DATE_TIME;
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, DateTime> timestampToDateTime(DateTimeZone dateTimeZone) {
		return new TimestampToDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, DateTime> timestampToDateTime(Chronology chronology) {
		return new TimestampToDateTime(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Long, DateTime> longToDateTime() {
		return LONG_TO_DATE_TIME;
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Long, DateTime> longToDateTime(DateTimeZone dateTimeZone) {
		return new LongToDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Long, DateTime> longToDateTime(Chronology chronology) {
		return new LongToDateTime(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * <p>
	 * A {@link DateTime} is created from the input {@link Integer} {@link Collection}.
	 * </p>
	 * 
	 * <p>
	 * The valid input Collection&lt;Integer&gt; are:
	 * </p>
	 * <ul>
	 * <li>year (month and day will be set to 1)</li>
	 * <li>year, month (day will be set to 1)</li>
	 * <li>year, month, day</li>
	 * </ul>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime() {
		return INTEGER_FIELD_COLLECTION_TO_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the input {@link Integer} {@link Collection}.
	 * The result will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * <p>
     * The valid input Collection&lt;Integer&gt; are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime(Chronology chronology) {
		return new  IntegerFieldCollectionToDateTime(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link Integer} array.
	 * </p>
	 * 
	 * <p>
     * The valid input Integer[] are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
     * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime() {
		return INTEGER_FIELD_ARRAY_TO_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link Integer} array.
	 * The result will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * <p>
     * The valid input Integer[] are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime(Chronology chronology) {
		return new  IntegerFieldArrayToDateTime(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} {@link Collection}.
	 * </p>
	 * 
	 * <p>
     * The valid input Collection&lt;String&gt; are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
     * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime() {
		return STRING_FIELD_COLLECTION_TO_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} {@link Collection}.
	 * The result will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * <p>
     * The valid input Collection&lt;String&gt; are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime(Chronology chronology) {
		return new  StringFieldCollectionToDateTime(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} array.
	 * </p>
	 * 
	 * <p>
     * The valid input String[] are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
     * @return the {@link DateTime} created from the input 
	 */
	public static final Function<String[], DateTime> strFieldArrayToDateTime() {
		return STRING_FIELD_ARRAY_TO_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} array.
	 * The result will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * <p>
     * The valid input String[] are:
     * </p>
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String[], DateTime> strFieldArrayToDateTime(Chronology chronology) {
		return new  StringFieldArrayToDateTime(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime() {
		return new CalendarToDateTime<T>();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(DateTimeZone dateTimeZone) {
		return new CalendarToDateTime<T>(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(Chronology chronology) {
		return new CalendarToDateTime<T>(chronology);
	}
	//
	
	
	static abstract class BaseToDateTime<T> extends AbstractNullAsNullFunction<T, DateTime> {

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
	
	static final class IntegerFieldCollectionToDateTime extends BaseToDateTime<Collection<Integer>> {

		public IntegerFieldCollectionToDateTime() {
			super();			
		}

		public IntegerFieldCollectionToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(Collection<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new ExecutionException(
						"Integer arguments list for DateTime conversion should of size " +
						"between 4 and 7 (year, month, day, hour, minute, second, millisecond). Size " + object.size() + " is not valid.");
			}			
			
			Iterator<Integer> iterator = object.iterator();
			
			int year = iterator.next().intValue();
			int month = iterator.next().intValue();
			int day = iterator.next().intValue();
			int hour = iterator.next().intValue();
			int minute = (object.size() >= 5) ? iterator.next().intValue() : 0;
			int second = (object.size() >= 6) ? iterator.next().intValue() : 0;
			int milli = (object.size() >= 7) ? iterator.next().intValue() : 0;
			
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
	
	
	
	static final class StringFieldCollectionToDateTime extends BaseToDateTime<Collection<String>> {

		public StringFieldCollectionToDateTime() {
			super();			
		}

		public StringFieldCollectionToDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateTime nullAsNullExecute(Collection<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new ExecutionException(
						"String arguments list for DateTime conversion should of size " +
						"between 4 and 7 (year, month, day, hour, minute, second, millisecond). Size " + object.size() + " is not valid.");
			}			
			
			Iterator<String> iterator = object.iterator();
			
			String year = iterator.next();
			String month = iterator.next();
			String day = iterator.next();
			String hour = iterator.next();
			String minute = (object.size() >= 5) ? iterator.next() : "0";
			String second = (object.size() >= 6) ? iterator.next() : "0";
			String milli = (object.size() >= 7) ? iterator.next() : "0";
			
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
