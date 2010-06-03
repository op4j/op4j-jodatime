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
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
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
public final class FnMutableDateTime {
	
	private final static TimestampToMutableDateTime TIMESTAMP_TO_MUTABLE_DATE_TIME = new TimestampToMutableDateTime();
	private final static LongToMutableDateTime LONG_TO_MUTABLE_DATE_TIME = new LongToMutableDateTime();
	private final static IntegerFieldCollectionToMutableDateTime INTEGER_FIELD_COLLECTION_TO_MUTABLE_DATE_TIME = new IntegerFieldCollectionToMutableDateTime();
	private final static IntegerFieldArrayToMutableDateTime INTEGER_FIELD_ARRAY_TO_MUTABLE_DATE_TIME = new IntegerFieldArrayToMutableDateTime();
	private final static StringFieldCollectionToMutableDateTime STRING_FIELD_COLLECTION_TO_MUTABLE_DATE_TIME = new StringFieldCollectionToMutableDateTime();
	private final static StringFieldArrayToMutableDateTime STRING_FIELD_ARRAY_TO_MUTABLE_DATE_TIME = new StringFieldArrayToMutableDateTime();
	
	private FnMutableDateTime() {
		super();
	}
		
	// From String
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link MutableDateTime} using the 
	 * given pattern parameter. If the pattern includes either, the name of 
	 * the month or day of week, a conversion accepting a {@link Locale} must 
	 * be used instead 
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern) {
		return new StringToMutableDateTime(pattern);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern parameter and with the given
	 * {@link MutableDateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, DateTimeZone dateTimeZone) {
		return new StringToMutableDateTime(pattern, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 * 		                
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Chronology chronology) {
		return new StringToMutableDateTime(pattern, chronology);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Locale locale) {
		return new StringToMutableDateTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link MutableDateTime} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, String locale) {
		return new StringToMutableDateTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given String into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link MutableDateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringToMutableDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link MutableDateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringToMutableDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link MutableDateTime} will be created with the given {@link Chronology}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Locale locale, Chronology chronology) {
		return new StringToMutableDateTime(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link MutableDateTime} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, String locale, Chronology chronology) {
		return new StringToMutableDateTime(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link MutableDateTime}
	 * </p>
	 * 
	 * @return the {@link MutableDateTime} created from the input 
	 */
	public static final <T extends Date> Function<T, MutableDateTime> dateToMutableDateTime() {
		return new DateToMutableDateTime<T>();
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link MutableDateTime} configured with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, MutableDateTime> dateToMutableDateTime(DateTimeZone dateTimeZone) {
		return new DateToMutableDateTime<T>(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link MutableDateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, MutableDateTime> dateToMutableDateTime(Chronology chronology) {
		return new DateToMutableDateTime<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link MutableDateTime}
	 * </p>
	 * 
	 * @return the {@link MutableDateTime} created from the input 
	 */
	public static final Function<Timestamp, MutableDateTime> timestampToMutableDateTime() {
		return TIMESTAMP_TO_MUTABLE_DATE_TIME;
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link MutableDateTime} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, MutableDateTime> timestampToMutableDateTime(DateTimeZone dateTimeZone) {
		return new TimestampToMutableDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link MutableDateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, MutableDateTime> timestampToMutableDateTime(Chronology chronology) {
		return new TimestampToMutableDateTime(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link MutableDateTime}
	 * </p>
	 * 
	 * @return the {@link MutableDateTime} created from the input 
	 */
	public static final Function<Long, MutableDateTime> longToMutableDateTime() {
		return LONG_TO_MUTABLE_DATE_TIME;
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link MutableDateTime} in the given
	 * {@link MutableDateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Long, MutableDateTime> longToMutableDateTime(DateTimeZone dateTimeZone) {
		return new LongToMutableDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link MutableDateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Long, MutableDateTime> longToMutableDateTime(Chronology chronology) {
		return new LongToMutableDateTime(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the input {@link Integer} {@link Collection}.
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
	 * @return the {@link MutableDateTime} created from the input 
	 */
	public static final Function<Collection<Integer>, MutableDateTime> integerFieldCollectionToMutableDateTime() {
		return INTEGER_FIELD_COLLECTION_TO_MUTABLE_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the input {@link Integer} {@link Collection}.
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
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Collection<Integer>, MutableDateTime> integerFieldCollectionToMutableDateTime(Chronology chronology) {
		return new  IntegerFieldCollectionToMutableDateTime(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the given {@link Integer} array.
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
     * @return the {@link MutableDateTime} created from the input 
	 */
	public static final Function<Integer[], MutableDateTime> integerFieldArrayToMutableDateTime() {
		return INTEGER_FIELD_ARRAY_TO_MUTABLE_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the given {@link Integer} array.
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
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Integer[], MutableDateTime> integerFieldArrayToMutableDateTime(Chronology chronology) {
		return new  IntegerFieldArrayToMutableDateTime(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the given {@link String} {@link Collection}.
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
     * @return the {@link MutableDateTime} created from the input 
	 */
	public static final Function<Collection<String>, MutableDateTime> strFieldCollectionToMutableDateTime() {
		return STRING_FIELD_COLLECTION_TO_MUTABLE_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the given {@link String} {@link Collection}.
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
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<Collection<String>, MutableDateTime> strFieldCollectionToMutableDateTime(Chronology chronology) {
		return new  StringFieldCollectionToMutableDateTime(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the given {@link String} array.
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
     * @return the {@link MutableDateTime} created from the input 
	 */
	public static final Function<String[], MutableDateTime> strFieldArrayToMutableDateTime() {
		return STRING_FIELD_ARRAY_TO_MUTABLE_DATE_TIME;
	}
	/**
	 * <p>
	 * A {@link MutableDateTime} is created from the given {@link String} array.
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
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final Function<String[], MutableDateTime> strFieldArrayToMutableDateTime(Chronology chronology) {
		return new  StringFieldArrayToMutableDateTime(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link MutableDateTime}
	 * </p>
	 * 
	 * @return the {@link MutableDateTime} created from the input 
	 */
	public static final <T extends Calendar> Function<T, MutableDateTime> calendarToMutableDateTime() {
		return new CalendarToMutableDateTime<T>();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link MutableDateTime} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, MutableDateTime> calendarToMutableDateTime(DateTimeZone dateTimeZone) {
		return new CalendarToMutableDateTime<T>(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link MutableDateTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link MutableDateTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, MutableDateTime> calendarToMutableDateTime(Chronology chronology) {
		return new CalendarToMutableDateTime<T>(chronology);
	}
	//
	
	
	static abstract class BaseToMutableDateTime<T> extends AbstractNullAsNullFunction<T, MutableDateTime> {

		final DateTimeZone dateTimeZone;
		final Chronology chronology;
		
		public BaseToMutableDateTime() {
			super();		
			this.dateTimeZone = null;
			this.chronology = null;
		}

		public BaseToMutableDateTime(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
			
			this.dateTimeZone = dateTimeZone;
			this.chronology = null;
		}

		public BaseToMutableDateTime(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.dateTimeZone = null;
			this.chronology = chronology;
		}
	}
	
	static final class StringToMutableDateTime extends BaseToMutableDateTime<String> {

		private final String pattern;
		private final Locale locale;
		
		
		public StringToMutableDateTime(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToMutableDateTime(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToMutableDateTime(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToMutableDateTime(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToMutableDateTime(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToMutableDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToMutableDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToMutableDateTime(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToMutableDateTime(String pattern, String locale, Chronology chronology) {
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
		public MutableDateTime nullAsNullExecute(String object, ExecCtx ctx) throws Exception {
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
		    
		    MutableDateTime result = new MutableDateTime();
		    if (this.dateTimeZone != null) {	    	
		    	dateTimeFormatter = dateTimeFormatter.withZone(this.dateTimeZone);
		    }
		    if (this.chronology != null) {
		    	dateTimeFormatter = dateTimeFormatter.withChronology(this.chronology);
		    }
			result = dateTimeFormatter.parseMutableDateTime(object);
			
			return result;		
		}
		
		
	}	
	
	static final class DateToMutableDateTime<T extends Date> extends BaseToMutableDateTime<T> {

		public DateToMutableDateTime() {
			super();			
		}

		public DateToMutableDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public DateToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new MutableDateTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new MutableDateTime(object.getTime(), this.chronology);
			}
			
			return new MutableDateTime(object.getTime());
		}
		
		
	}	
	
	static final class TimestampToMutableDateTime extends BaseToMutableDateTime<Timestamp> {

		public TimestampToMutableDateTime() {
			super();			
		}

		public TimestampToMutableDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public TimestampToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(Timestamp object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new MutableDateTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new MutableDateTime(object.getTime(), this.chronology);
			}
			
			return new MutableDateTime(object.getTime());
		}
	}	
	
	static final class LongToMutableDateTime extends BaseToMutableDateTime<Long> {

		public LongToMutableDateTime() {
			super();			
		}

		public LongToMutableDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public LongToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(Long object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new MutableDateTime(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new MutableDateTime(object.longValue(), this.chronology);
			}
			
			return new MutableDateTime(object.longValue());
		}
	}	
	
	static final class IntegerFieldCollectionToMutableDateTime extends BaseToMutableDateTime<Collection<Integer>> {

		public IntegerFieldCollectionToMutableDateTime() {
			super();			
		}

		public IntegerFieldCollectionToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(Collection<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new ExecutionException(
						"Integer arguments list for MutableDateTime conversion should of size " +
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
	        	return new MutableDateTime(year, month, day, hour, minute, second, milli, this.chronology);
	        }
			return new MutableDateTime(year, month, day,  hour, minute, second, milli);
		}
	}	
	
	static final class IntegerFieldArrayToMutableDateTime extends BaseToMutableDateTime<Integer[]> {

		public IntegerFieldArrayToMutableDateTime() {
			super();			
		}

		public IntegerFieldArrayToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(Integer[] object, ExecCtx ctx) throws Exception {
			if (object.length < 4 || object.length > 7) {
				throw new ExecutionException(
						"Integer arguments array for MutableDateTime conversion should of size " +
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
	        	return new MutableDateTime(year, month, day, hour, minute, second, milli, this.chronology);
	        }
			return new MutableDateTime(year, month, day, hour, minute, second, milli);
		}
		
	}	
	
	
	
	static final class StringFieldCollectionToMutableDateTime extends BaseToMutableDateTime<Collection<String>> {

		public StringFieldCollectionToMutableDateTime() {
			super();			
		}

		public StringFieldCollectionToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(Collection<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new ExecutionException(
						"String arguments list for MutableDateTime conversion should of size " +
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
	        	return new MutableDateTime(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
	        			Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli),
	        			this.chronology);
	        }
			return new MutableDateTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
					Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli));
		}
	}	
	
	static final class StringFieldArrayToMutableDateTime extends BaseToMutableDateTime<String[]> {

		public StringFieldArrayToMutableDateTime() {
			super();			
		}

		public StringFieldArrayToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(String[] object, ExecCtx ctx) throws Exception {
			if (object.length < 4 || object.length > 7) {
				throw new ExecutionException(
						"String arguments array for MutableDateTime conversion should of size " +
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
	        	return new MutableDateTime(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day), 
	        			Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli),
	        			this.chronology);
	        }
			return new MutableDateTime(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
					Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(milli));
		}
	}	
	
	static final class CalendarToMutableDateTime<T extends Calendar> extends BaseToMutableDateTime<T> {

		public CalendarToMutableDateTime() {
			super();			
		}

		public CalendarToMutableDateTime(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public CalendarToMutableDateTime(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public MutableDateTime nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new MutableDateTime(object, this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new MutableDateTime(object, this.chronology);
			}
			return new MutableDateTime(object);
		}
	}	
}
