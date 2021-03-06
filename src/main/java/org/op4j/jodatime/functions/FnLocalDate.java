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
import org.joda.time.LocalDate;
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
public final class FnLocalDate {
	
	private final static TimestampToLocalDate TIMESTAMP_TO_LOCAL_DATE = new TimestampToLocalDate();
	private final static LongToLocalDate LONG_TO_LOCAL_DATE = new LongToLocalDate();
	private final static IntegerFieldCollectionToLocalDate INTEGER_FIELD_COLLECTION_TO_LOCAL_DATE = new IntegerFieldCollectionToLocalDate();
	private final static IntegerFieldArrayToLocalDate INTEGER_FIELD_ARRAY_TO_LOCAL_DATE = new IntegerFieldArrayToLocalDate();
	private final static StringFieldCollectionToLocalDate STRING_FIELD_COLLECTION_TO_LOCAL_DATE = new StringFieldCollectionToLocalDate();
	private final static StringFieldArrayToLocalDate STRING_FIELD_ARRAY_TO_LOCAL_DATE = new StringFieldArrayToLocalDate();
	
	
	private FnLocalDate() {
		super();
	}
		
	// From String
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                
	 * @param pattern string with the format of the input String 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern) {
		return new StringToLocalDate(pattern);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *               
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, DateTimeZone dateTimeZone) {
		return new StringToLocalDate(pattern, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 * 	                
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Chronology chronology) {
		return new StringToLocalDate(pattern, chronology);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale) {
		return new StringToLocalDate(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale) {
		return new StringToLocalDate(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is created with the specified {@link DateTimeZone}
	 * </p>
	 *              
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringToLocalDate(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is created with the specified {@link DateTimeZone}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringToLocalDate(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, Chronology chronology) {
		return new StringToLocalDate(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, Chronology chronology) {
		return new StringToLocalDate(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link LocalDate}
	 * </p>
	 * 
	 * @return the {@link LocalDate} created from the input 
	 */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate() {
		return new DateToLocalDate<T>();
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link LocalDate} configured with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(DateTimeZone dateTimeZone) {
		return new DateToLocalDate<T>(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(Chronology chronology) {
		return new DateToLocalDate<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link LocalDate}
	 * </p>
	 * 
	 * @return the {@link LocalDate} created from the input 
	 */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate() {
		return TIMESTAMP_TO_LOCAL_DATE;
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link LocalDate} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(DateTimeZone dateTimeZone) {
		return new TimestampToLocalDate(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(Chronology chronology) {
		return new TimestampToLocalDate(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate}
	 * </p>
	 * 
	 * @return the {@link LocalDate} created from the input 
	 */
	public static final Function<Long, LocalDate> longToLocalDate() {
		return LONG_TO_LOCAL_DATE;
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Long, LocalDate> longToLocalDate(DateTimeZone dateTimeZone) {
		return new LongToLocalDate(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Long, LocalDate> longToLocalDate(Chronology chronology) {
		return new LongToLocalDate(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given {@link Integer} {@link Collection}.
	 * </p>
	 * <p>
	 * The valid input Collection&lt;Integer&gt; are:
	 * </p>
	 * <ul>
	 * <li>year (month and day will be set to 1)</li>
	 * <li>year, month (day will be set to 1)</li>
	 * <li>year, month, day</li>
	 * </ul> 
	 * 
	 * @return the {@link LocalDate} created from the input
	 */
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate() {
		return INTEGER_FIELD_COLLECTION_TO_LOCAL_DATE;
	}
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given {@link Integer} {@link Collection}.
	 * The output {@link LocalDate} will be created with the given {@link Chronology}
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
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate(Chronology chronology) {
		return new IntegerFieldCollectionToLocalDate(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given integer array.
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
     * @return the {@link LocalDate} created from the input
	 */
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate() {
		return INTEGER_FIELD_ARRAY_TO_LOCAL_DATE;
	}
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given integer array.
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
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate(Chronology chronology) {
		return new IntegerFieldArrayToLocalDate(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given {@link String} {@link Collection}.
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
     * @return the {@link LocalDate} created from the input
	 */
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate() {
		return STRING_FIELD_COLLECTION_TO_LOCAL_DATE;
	}
	/**
	 * <p>
	 * A {@link LocalDate} is created from the input {@link String} {@link Collection}.
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
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate(Chronology chronology) {
		return new StringFieldCollectionToLocalDate(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given string array.
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
     * @return the {@link LocalDate} created from the input
	 */
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate() {
		return STRING_FIELD_ARRAY_TO_LOCAL_DATE;
	}
	/**
	 * <p>
	 * A {@link LocalDate} is created from the given string array.
	 * The output {@link LocalDate} will be created with the specified {@link Chronology}
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
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate(Chronology chronology) {
		return new  StringFieldArrayToLocalDate(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalDate}
	 * </p>
	 * 
	 * @return the {@link LocalDate} created from the input
	 */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate() {
		return new CalendarToLocalDate<T>();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalDate} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(DateTimeZone dateTimeZone) {
		return new CalendarToLocalDate<T>(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalDate} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(Chronology chronology) {
		return new CalendarToLocalDate<T>(chronology);
	}
	//
	
	
	static abstract class BaseToLocalDate<T> extends AbstractNullAsNullFunction<T, LocalDate> {

		final DateTimeZone dateTimeZone;
		final Chronology chronology;
		
		public BaseToLocalDate() {
			super();
			this.dateTimeZone = null;
			this.chronology = null;
		}

		public BaseToLocalDate(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
			
			this.dateTimeZone = dateTimeZone;
			this.chronology = null;
		}

		public BaseToLocalDate(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
			this.dateTimeZone = null;			
		}
	}
	
	static final class StringToLocalDate extends BaseToLocalDate<String> {

		private final String pattern;
		private final Locale locale;
		
		
		public StringToLocalDate(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToLocalDate(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToLocalDate(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToLocalDate(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToLocalDate(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToLocalDate(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToLocalDate(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
						
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToLocalDate(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
						
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToLocalDate(String pattern, String locale, Chronology chronology) {
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
		public LocalDate nullAsNullExecute(String object, ExecCtx ctx) throws Exception {
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
		    
		    LocalDate result = new LocalDate();
		    if (this.dateTimeZone != null) {	    	
		    	dateTimeFormatter = dateTimeFormatter.withZone(this.dateTimeZone);
		    }
		    if (this.chronology != null) {
		    	dateTimeFormatter = dateTimeFormatter.withChronology(this.chronology);
		    }
			result = dateTimeFormatter.parseDateTime(object).toLocalDate();
			
			return result;		
		}
		
		
	}	
	
	static final class DateToLocalDate<T extends Date> extends BaseToLocalDate<T> {

		public DateToLocalDate() {
			super();			
		}

		public DateToLocalDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public DateToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalDate(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalDate(object.getTime(), this.chronology);
			}
			
			return new LocalDate(object.getTime());
		}
		
		
	}	
	
	static final class TimestampToLocalDate extends BaseToLocalDate<Timestamp> {

		public TimestampToLocalDate() {
			super();			
		}

		public TimestampToLocalDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public TimestampToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(Timestamp object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalDate(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalDate(object.getTime(), this.chronology);
			}
			
			return new LocalDate(object.getTime());
		}
	}	
	
	static final class LongToLocalDate extends BaseToLocalDate<Long> {

		public LongToLocalDate() {
			super();			
		}

		public LongToLocalDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public LongToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(Long object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalDate(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalDate(object.longValue(), this.chronology);
			}
			
			return new LocalDate(object.longValue());
		}
	}	
	
	static final class IntegerFieldCollectionToLocalDate extends BaseToLocalDate<Collection<Integer>> {

		public IntegerFieldCollectionToLocalDate() {
			super();			
		}

		public IntegerFieldCollectionToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(Collection<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 3) {
				throw new ExecutionException(
						"Integer arguments list for LocalDate conversion should hava a size " +
						"between 1 and 3. Size " + object.size() + " is not valid.");
			}			
			
			Iterator<Integer> iterator = object.iterator();
			
			int year = iterator.next().intValue();
			int month = (object.size() >= 2) ? iterator.next().intValue() : 1;
			int day = (object.size() >= 3) ? iterator.next().intValue() : 1;
			
			if (this.chronology != null) {
	        	return new LocalDate(year, month, day, this.chronology);
	        }
			return new LocalDate(year, month, day);
		}
	}	
	
	static final class IntegerFieldArrayToLocalDate extends BaseToLocalDate<Integer[]> {

		public IntegerFieldArrayToLocalDate() {
			super();			
		}

		public IntegerFieldArrayToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(Integer[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 3) {
				throw new ExecutionException(
						"Integer arguments array for LocalDate conversion should hava a size " +
						"between 1 and 3. Size " + object.length + " is not valid.");
			}			
			
			int year = object[0].intValue();
			int month = (object.length >= 2) ? object[1].intValue() : 1;
			int day = (object.length >= 3) ? object[2].intValue() : 1;
			
			if (this.chronology != null) {
	        	return new LocalDate(year, month, day, this.chronology);
	        }
			return new LocalDate(year, month, day);
		}
		
	}	
	
	
	
	static final class StringFieldCollectionToLocalDate extends BaseToLocalDate<Collection<String>> {

		public StringFieldCollectionToLocalDate() {
			super();			
		}

		public StringFieldCollectionToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(Collection<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 3) {
				throw new ExecutionException(
						"String arguments list for LocalDate conversion should hava a size " +
						"between 1 and 3. Size " + object.size() + " is not valid.");
			}			
			
			Iterator<String> iterator = object.iterator();
			
			String year = iterator.next();
			String month = (object.size() >= 2) ? iterator.next() : "1";
			String day = (object.size() >= 3) ? iterator.next() : "1";
			
			if (this.chronology != null) {
	        	return new LocalDate(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
	        			this.chronology);
	        }
			return new LocalDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		
		
	}	
	
	static final class StringFieldArrayToLocalDate extends BaseToLocalDate<String[]> {

		public StringFieldArrayToLocalDate() {
			super();			
		}

		public StringFieldArrayToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(String[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 3) {
				throw new ExecutionException(
						"String arguments array for LocalDate conversion should a size " +
						"between 1 and 3. Size " + object.length + " is not valid.");
			}			
			
			String year = object[0];
			String month = (object.length >= 2) ? object[1] : "1";
			String day = (object.length >= 3) ? object[2] : "1";
			
			if (this.chronology != null) {
	        	return new LocalDate(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day), 
	        			this.chronology);
	        }
			return new LocalDate(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		}
	}	
	
	static final class CalendarToLocalDate<T extends Calendar> extends BaseToLocalDate<T> {

		public CalendarToLocalDate() {
			super();			
		}

		public CalendarToLocalDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public CalendarToLocalDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public LocalDate nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalDate(object, this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalDate(object, this.chronology);
			}
			return new LocalDate(object);
		}
	}	
}
