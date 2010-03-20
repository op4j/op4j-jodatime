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
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
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
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public final class FnToDateMidnight {
	
	private final static TimestampToDateMidnight TIMESTAMP_TO_DATE_MIDNIGHT = new TimestampToDateMidnight();
	private final static LongToDateMidnight LONG_TO_DATE_MIDNIGHT = new LongToDateMidnight();
	private final static IntegerFieldCollectionToDateMidnight INTEGER_FIELD_COLLECTION_TO_DATE_MIDNIGHT = new IntegerFieldCollectionToDateMidnight();
	private final static IntegerFieldArrayToDateMidnight INTEGER_FIELD_ARRAY_TO_DATE_MIDNIGHT = new IntegerFieldArrayToDateMidnight();
	private final static StringFieldCollectionToDateMidnight STRING_FIELD_LIST_TO_DATE_MIDNIGHT = new StringFieldCollectionToDateMidnight();
	private final static StringFieldArrayToDateMidnight STRING_FIELD_ARRAY_TO_DATE_MIDNIGHT = new StringFieldArrayToDateMidnight();
	
	private FnToDateMidnight() {
		super();
	}
		
	// From String
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final StringToDateMidnight fromString(String pattern) {
		return new StringToDateMidnight(pattern);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final StringToDateMidnight fromString(String pattern, DateTimeZone dateTimeZone) {
		return new StringToDateMidnight(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final StringToDateMidnight fromString(String pattern, Chronology chronology) {
		return new StringToDateMidnight(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringToDateMidnight fromString(String pattern, Locale locale) {
		return new StringToDateMidnight(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringToDateMidnight fromString(String pattern, String locale) {
		return new StringToDateMidnight(pattern, locale);
	}
	/**
	 * It converts the given String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final StringToDateMidnight fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringToDateMidnight(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final StringToDateMidnight fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringToDateMidnight(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final StringToDateMidnight fromString(String pattern, Locale locale, Chronology chronology) {
		return new StringToDateMidnight(pattern, locale, chronology);
	}
	/**
	 * It converts the given String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} will be created with the given {@link Chronology}
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final StringToDateMidnight fromString(String pattern, String locale, Chronology chronology) {
		return new StringToDateMidnight(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight}
	 */
	public static final <T extends Date> DateToDateMidnight<T> fromDate() {
		return new DateToDateMidnight<T>();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> DateToDateMidnight<T> fromDate(DateTimeZone dateTimeZone) {
		return new DateToDateMidnight<T>(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> DateToDateMidnight<T> fromDate(Chronology chronology) {
		return new DateToDateMidnight<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight}
	 */
	public static final TimestampToDateMidnight fromTimestamp() {
		return TIMESTAMP_TO_DATE_MIDNIGHT;
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final TimestampToDateMidnight fromTimestamp(DateTimeZone dateTimeZone) {
		return new TimestampToDateMidnight(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final TimestampToDateMidnight fromTimestamp(Chronology chronology) {
		return new TimestampToDateMidnight(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * The given long representing the time in milliseconds is converted into a {@link DateMidnight}
	 */
	public static final LongToDateMidnight fromLong() {
		return LONG_TO_DATE_MIDNIGHT;
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final LongToDateMidnight fromLong(DateTimeZone dateTimeZone) {
		return new LongToDateMidnight(dateTimeZone);
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final LongToDateMidnight fromLong(Chronology chronology) {
		return new LongToDateMidnight(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IntegerFieldCollectionToDateMidnight fromIntegerFieldCollection() {
		return INTEGER_FIELD_COLLECTION_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IntegerFieldCollectionToDateMidnight fromIntegerFieldCollection(Chronology chronology) {
		return new  IntegerFieldCollectionToDateMidnight(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IntegerFieldArrayToDateMidnight fromIntegerFieldArray() {
		return INTEGER_FIELD_ARRAY_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IntegerFieldArrayToDateMidnight fromIntegerFieldArray(Chronology chronology) {
		return new  IntegerFieldArrayToDateMidnight(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * A {@link DateMidnight} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final StringFieldCollectionToDateMidnight fromStringFieldCollection() {
		return STRING_FIELD_LIST_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final StringFieldCollectionToDateMidnight fromStringFieldCollection(Chronology chronology) {
		return new  StringFieldCollectionToDateMidnight(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * A {@link DateMidnight} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final StringFieldArrayToDateMidnight fromStringFieldArray() {
		return STRING_FIELD_ARRAY_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final StringFieldArrayToDateMidnight fromStringFieldArray(Chronology chronology) {
		return new  StringFieldArrayToDateMidnight(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight}
	 */
	public static final <T extends Calendar> CalendarToDateMidnight<T> fromCalendar() {
		return new CalendarToDateMidnight<T>();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> CalendarToDateMidnight<T> fromCalendar(DateTimeZone dateTimeZone) {
		return new CalendarToDateMidnight<T>(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> CalendarToDateMidnight<T> fromCalendar(Chronology chronology) {
		return new CalendarToDateMidnight<T>(chronology);
	}
	//
	
	
	static abstract class BaseToDateMidnight<T> extends AbstractNullAsNullFunction<T, DateMidnight> {

		final DateTimeZone dateTimeZone;
		final Chronology chronology;
		
		public BaseToDateMidnight() {
			super();	
			this.dateTimeZone = null;
			this.chronology = null;
		}

		public BaseToDateMidnight(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
			
			this.dateTimeZone = dateTimeZone;
			this.chronology = null;
		}

		public BaseToDateMidnight(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
						
			this.dateTimeZone = null;
			this.chronology = chronology;
		}
	}
	
	static final class StringToDateMidnight extends BaseToDateMidnight<String> {

		private final String pattern;
		private final Locale locale;
		
		
		public StringToDateMidnight(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToDateMidnight(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToDateMidnight(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
						
			this.pattern = pattern;
			this.locale = null;
		}

		public StringToDateMidnight(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToDateMidnight(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToDateMidnight(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		public StringToDateMidnight(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public StringToDateMidnight(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}

		public StringToDateMidnight(String pattern, String locale, Chronology chronology) {
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
		public DateMidnight nullAsNullExecute(String object, ExecCtx ctx) throws Exception {
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
		    
		    DateMidnight result = new DateMidnight();
		    if (this.dateTimeZone != null) {	    	
		    	dateTimeFormatter = dateTimeFormatter.withZone(this.dateTimeZone);
		    }
		    if (this.chronology != null) {
		    	dateTimeFormatter = dateTimeFormatter.withChronology(this.chronology);
		    }
			result = dateTimeFormatter.parseDateTime(object).toDateMidnight();
			
			return result;		
		}
		
	}	
	
	static final class DateToDateMidnight<T extends Date> extends BaseToDateMidnight<T> {

		public DateToDateMidnight() {
			super();			
		}

		public DateToDateMidnight(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public DateToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateMidnight(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateMidnight(object.getTime(), this.chronology);
			}
			
			return new DateMidnight(object.getTime());
		}
		
		
	}	
	
	static final class TimestampToDateMidnight extends BaseToDateMidnight<Timestamp> {

		public TimestampToDateMidnight() {
			super();			
		}

		public TimestampToDateMidnight(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public TimestampToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(Timestamp object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateMidnight(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateMidnight(object.getTime(), this.chronology);
			}
			
			return new DateMidnight(object.getTime());
		}
	}	
	
	static final class LongToDateMidnight extends BaseToDateMidnight<Long> {

		public LongToDateMidnight() {
			super();			
		}

		public LongToDateMidnight(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public LongToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(Long object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateMidnight(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateMidnight(object.longValue(), this.chronology);
			}
			
			return new DateMidnight(object.longValue());
		}
	}	
	
	static final class IntegerFieldCollectionToDateMidnight extends BaseToDateMidnight<Collection<Integer>> {

		public IntegerFieldCollectionToDateMidnight() {
			super();			
		}

		public IntegerFieldCollectionToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(Collection<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 3) {
				throw new ExecutionException(
						"Integer arguments list for DateMidnight conversion should of size " +
						"between 1 and 3 (year, month, day). Size " + object.size() + " is not valid.");
			}			
			
			Iterator<Integer> iterator = object.iterator();
			
			int year = iterator.next().intValue();
			int month = (object.size() >= 2) ? iterator.next().intValue() : 1;
			int day = (object.size() >= 3) ? iterator.next().intValue() : 1;
			
			if (this.chronology != null) {
	        	return new DateMidnight(year, month, day, this.chronology);
	        }
			return new DateMidnight(year, month, day);
		}
	}	
	
	static final class IntegerFieldArrayToDateMidnight extends BaseToDateMidnight<Integer[]> {

		public IntegerFieldArrayToDateMidnight() {
			super();			
		}

		public IntegerFieldArrayToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(Integer[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 3) {
				throw new ExecutionException(
						"Integer arguments array for DateMidnight conversion should of size " +
						"between 1 and 3 (year, month, day). Size " + object.length + " is not valid.");
			}		
			
			int year = object[0].intValue();
			int month = (object.length >= 2) ? object[1].intValue() : 0;
			int day = (object.length >= 3) ? object[2].intValue() : 0;
			
			if (this.chronology != null) {
	        	return new DateMidnight(year, month, day, this.chronology);
	        }
			return new DateMidnight(year, month, day);
		}
		
	}	
	
	
	
	static final class StringFieldCollectionToDateMidnight extends BaseToDateMidnight<Collection<String>> {

		public StringFieldCollectionToDateMidnight() {
			super();			
		}

		public StringFieldCollectionToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(Collection<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 3) {
				throw new ExecutionException(
						"String arguments list for DateMidnight conversion should of size " +
						"between 1 and 3 (year, month, day). Size " + object.size() + " is not valid.");
			}			
			
			Iterator<String> iterator = object.iterator();
			
			String year = iterator.next();
			String month = (object.size() >= 2) ? iterator.next() : "0";
			String day = (object.size() >= 3) ? iterator.next() : "0";
			
			if (this.chronology != null) {
	        	return new DateMidnight(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
	        			this.chronology);
	        }
			return new DateMidnight(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		
		
	}	
	
	static final class StringFieldArrayToDateMidnight extends BaseToDateMidnight<String[]> {

		public StringFieldArrayToDateMidnight() {
			super();			
		}

		public StringFieldArrayToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(String[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 3) {
				throw new ExecutionException(
						"String arguments array for DateMidnight conversion should of size " +
						"between 1 and 3 (year, month, day). Size " + object.length + " is not valid.");
			}			
			
			String year = object[0];
			String month = (object.length >= 2) ? object[1] : "0";
			String day = (object.length >= 3) ? object[2] : "0";
			
			if (this.chronology != null) {
	        	return new DateMidnight(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
	        			this.chronology);
	        }
			return new DateMidnight(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		}
	}	
	
	static final class CalendarToDateMidnight<T extends Calendar> extends BaseToDateMidnight<T> {

		public CalendarToDateMidnight() {
			super();			
		}

		public CalendarToDateMidnight(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		public CalendarToDateMidnight(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public DateMidnight nullAsNullExecute(T object, ExecCtx ctx) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateMidnight(object, this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateMidnight(object, this.chronology);
			}
			return new DateMidnight(object);
		}
	}	
}
