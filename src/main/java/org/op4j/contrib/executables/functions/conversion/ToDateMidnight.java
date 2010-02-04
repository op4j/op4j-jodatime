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
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.converters.AbstractNullAsNullConverter;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToDateMidnight {

	private static FromTimestamp FROM_TIMESTAMP = new FromTimestamp();
	private static FromLong FROM_LONG = new FromLong();
	private static FromIntegerFieldList FROM_INTEGER_FIELD_LIST = new FromIntegerFieldList();
	private static FromIntegerFieldArray FROM_INTEGER_FIELD_ARRAY = new FromIntegerFieldArray();
	private static FromStringFieldList FROM_STRING_FIELD_LIST = new FromStringFieldList();
	private static FromStringFieldArray FROM_STRING_FIELD_ARRAY = new FromStringFieldArray();
	
	private ToDateMidnight() {
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
	public static final FromString fromString(String pattern) {
		return new FromString(pattern);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final FromString fromString(String pattern, DateTimeZone dateTimeZone) {
		return new FromString(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final FromString fromString(String pattern, Chronology chronology) {
		return new FromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final FromString fromString(String pattern, Locale locale) {
		return new FromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final FromString fromString(String pattern, String locale) {
		return new FromString(pattern, locale);
	}
	/**
	 * It converts the given String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final FromString fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new FromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final FromString fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new FromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final FromString fromString(String pattern, Locale locale, Chronology chronology) {
		return new FromString(pattern, locale, chronology);
	}
	/**
	 * It converts the given String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} will be created with the given {@link Chronology}
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final FromString fromString(String pattern, String locale, Chronology chronology) {
		return new FromString(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight}
	 */
	public static final <T extends Date> FromDate<T> fromDate() {
		return new FromDate<T>();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> FromDate<T> fromDate(DateTimeZone dateTimeZone) {
		return new FromDate<T>(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> FromDate<T> fromDate(Chronology chronology) {
		return new FromDate<T>(chronology);
	}
	//
	
	
	// From Date
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight}
	 */
	public static final FromTimestamp fromTimestamp() {
		return FROM_TIMESTAMP;
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final FromTimestamp fromTimestamp(DateTimeZone dateTimeZone) {
		return new FromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final FromTimestamp fromTimestamp(Chronology chronology) {
		return new FromTimestamp(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight}
	 */
	public static final FromLong fromLong() {
		return FROM_LONG;
	}
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final FromLong fromLong(DateTimeZone dateTimeZone) {
		return new FromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final FromLong fromLong(Chronology chronology) {
		return new FromLong(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * A {@link DateMidnight} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final FromIntegerFieldList fromIntegerFieldList() {
		return FROM_INTEGER_FIELD_LIST;
	}
	/**
	 * A {@link DateMidnight} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final FromIntegerFieldList fromIntegerFieldList(Chronology chronology) {
		return new  FromIntegerFieldList(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * A {@link DateMidnight} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final FromIntegerFieldArray fromIntegerFieldArray() {
		return FROM_INTEGER_FIELD_ARRAY;
	}
	/**
	 * A {@link DateMidnight} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final FromIntegerFieldArray fromIntegerFieldArray(Chronology chronology) {
		return new  FromIntegerFieldArray(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * A {@link DateMidnight} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final FromStringFieldList fromStringFieldList() {
		return FROM_STRING_FIELD_LIST;
	}
	/**
	 * A {@link DateMidnight} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final FromStringFieldList fromStringFieldList(Chronology chronology) {
		return new  FromStringFieldList(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * A {@link DateMidnight} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final FromStringFieldArray fromStringFieldArray() {
		return FROM_STRING_FIELD_ARRAY;
	}
	/**
	 * A {@link DateMidnight} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final FromStringFieldArray fromStringFieldArray(Chronology chronology) {
		return new  FromStringFieldArray(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight}
	 */
	public static final <T extends Calendar> FromCalendar<T> fromCalendar() {
		return new FromCalendar<T>();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> FromCalendar<T> fromCalendar(DateTimeZone dateTimeZone) {
		return new FromCalendar<T>(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> FromCalendar<T> fromCalendar(Chronology chronology) {
		return new FromCalendar<T>(chronology);
	}
	//
	
	
	private static abstract class BaseToDateTime<T> extends AbstractNullAsNullConverter<DateMidnight, T> {

		DateTimeZone dateTimeZone = null;
		Chronology chronology = null;
		
		public BaseToDateTime() {
			super();			
		}

		public BaseToDateTime(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
			
			this.dateTimeZone = dateTimeZone;
		}

		public BaseToDateTime(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
						
			this.chronology = chronology;
		}

		public Type<? extends DateMidnight> getResultType(
				Type<? extends T> targetType) {
			return Types.forClass(DateMidnight.class);
		}
	}
	
	public static final class FromString extends BaseToDateTime<String> {

		private String pattern;
		private Locale locale;
		
		
		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter. If
		 * the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a {@link Locale} must be used instead
		 *                 
		 * @param pattern
		 */
		public FromString(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
		}

		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
		 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a {@link Locale} must be used instead
		 *                 
		 * @param pattern
		 * @param dateTimeZone
		 */
		public FromString(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
		}

		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
		 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a {@link Locale} must be used instead
		 * 		                
		 * @param pattern
		 * @param chronology
		 */
		public FromString(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
						
			this.pattern = pattern;
		}

		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
		 * {@link Locale} parameters
		 * 
		 * @param pattern
		 * @param locale
		 */
		public FromString(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
		 * {@link Locale} parameters
		 * 
		 * @param pattern
		 * @param locale
		 */
		public FromString(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		/**
		 * It converts the given String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
		 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
		 *                 
		 * @param pattern
		 * @param locale
		 * @param dateTimeZone
		 */
		public FromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
		 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
		 * 
		 * @param pattern
		 * @param locale
		 * @param dateTimeZone
		 */
		public FromString(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		/**
		 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
		 * The {@link DateMidnight} will be created with the given {@link Chronology}
		 *                 
		 * @param pattern
		 * @param locale
		 * @param chronology
		 */
		public FromString(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
		}
		
		/**
		 * It converts the given String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
		 * The {@link DateMidnight} will be created with the given {@link Chronology}
		 * 
		 * @param pattern
		 * @param locale
		 * @param chronology
		 */
		public FromString(String pattern, String locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public DateMidnight nullAsNullExecute(String object, ExecCtx ctx) throws Exception {
			DateTimeFormatter dateTimeFormatter = null;
		    if (this.locale == null) {
		        if (StringUtils.contains(this.pattern, "MMM") || StringUtils.contains(this.pattern, "EEE")) {
		        	throw new FunctionExecutionException(
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
	
	public static final class FromDate<T extends Date> extends BaseToDateTime<T> {

		/**
		 * The given {@link Date} is converted into a {@link DateMidnight}
		 */
		public FromDate() {
			super();			
		}

		/**
		 * The given {@link Date} is converted into a {@link DateMidnight} configured with the given
		 * {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given {@link Date} is converted into a {@link DateMidnight} with the given
		 * {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromDate(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
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
	
	public static final class FromTimestamp extends BaseToDateTime<Timestamp> {

		/**
		 * The given {@link Timestamp} is converted into a {@link DateMidnight}
		 */
		public FromTimestamp() {
			super();			
		}

		/**
		 * The given {@link Timestamp} is converted into a {@link DateMidnight} in the given
		 * {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromTimestamp(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given {@link Timestamp} is converted into a {@link DateMidnight} with the given
		 * {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromTimestamp(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
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
	
	public static final class FromLong extends BaseToDateTime<Long> {

		/**
		 * The given long representing the time in millis is converted into a {@link DateMidnight}
		 */
		public FromLong() {
			super();			
		}

		/**
		 * The given long representing the time in millis is converted into a {@link DateMidnight} in the given
		 * {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromLong(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given long representing the time in millis is converted into a {@link DateMidnight} with the given
		 * {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromLong(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
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
	
	public static final class FromIntegerFieldList extends BaseToDateTime<List<Integer>> {

		/**
		 * A {@link DateMidnight} is created from the given integer list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		public FromIntegerFieldList() {
			super();			
		}

		/**
		 * A {@link DateMidnight} is created from the given integer list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromIntegerFieldList(Chronology chronology) {
			super(chronology);
		}
		
		@Override
		public DateMidnight nullAsNullExecute(List<Integer> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 3) {
				throw new FunctionExecutionException(
						"Integer arguments list for DateMidnight conversion should of size " +
						"between 1 and 3 (year, month, day). Size " + object.size() + " is not valid.");
			}			
			
			int year = object.get(0).intValue();
			int month = (object.size() >= 2) ? object.get(1).intValue() : 1;
			int day = (object.size() >= 3) ? object.get(2).intValue() : 1;
			
			if (this.chronology != null) {
	        	return new DateMidnight(year, month, day, this.chronology);
	        }
			return new DateMidnight(year, month, day);
		}
	}	
	
	public static final class FromIntegerFieldArray extends BaseToDateTime<Integer[]> {

		/**
		 * A {@link DateMidnight} is created from the given integer array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */		
		public FromIntegerFieldArray() {
			super();			
		}

		/**
		 * A {@link DateMidnight} is created from the given integer array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromIntegerFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public DateMidnight nullAsNullExecute(Integer[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 3) {
				throw new FunctionExecutionException(
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
	
	
	
	public static final class FromStringFieldList extends BaseToDateTime<List<String>> {

		/**
		 * A {@link DateMidnight} is created from the given string list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		public FromStringFieldList() {
			super();			
		}

		/**
		 * A {@link DateMidnight} is created from the given string list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromStringFieldList(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public DateMidnight nullAsNullExecute(List<String> object, ExecCtx ctx) throws Exception {
			if (object.size() < 1 || object.size() > 3) {
				throw new FunctionExecutionException(
						"String arguments list for DateMidnight conversion should of size " +
						"between 1 and 3 (year, month, day). Size " + object.size() + " is not valid.");
			}			
			
			String year = object.get(0);
			String month = (object.size() >= 2) ? object.get(1) : "0";
			String day = (object.size() >= 3) ? object.get(2) : "0";
			
			if (this.chronology != null) {
	        	return new DateMidnight(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day),
	        			this.chronology);
	        }
			return new DateMidnight(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		
		
	}	
	
	public static final class FromStringFieldArray extends BaseToDateTime<String[]> {

		/**
		 * A {@link DateMidnight} is created from the given string array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		public FromStringFieldArray() {
			super();			
		}

		/**
		 * A {@link DateMidnight} is created from the given string array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromStringFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public DateMidnight nullAsNullExecute(String[] object, ExecCtx ctx) throws Exception {
			if (object.length < 1 || object.length > 3) {
				throw new FunctionExecutionException(
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
	
	public static final class FromCalendar<T extends Calendar> extends BaseToDateTime<T> {

		/**
		 * It converts a {@link Calendar} into a {@link DateMidnight}
		 */
		public FromCalendar() {
			super();			
		}

		/**
		 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromCalendar(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromCalendar(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
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
