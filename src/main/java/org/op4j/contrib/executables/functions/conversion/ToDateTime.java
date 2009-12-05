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
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.functions.converters.IConverter;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToDateTime {

	//TODO Replace with valid code
	
	private ToDateTime() {
		super();
	}
		
	// From String
	public static final FromString fromString(String pattern) {
		return new FromString(pattern);
	}	
	public static final FromString fromString(String pattern, DateTimeZone dateTimeZone) {
		return new FromString(pattern, dateTimeZone);
	}	
	public static final FromString fromString(String pattern, Chronology chronology) {
		return new FromString(pattern, chronology);
	}	
	public static final FromString fromString(String pattern, Locale locale) {
		return new FromString(pattern, locale);
	}
	public static final FromString fromString(String pattern, String locale) {
		return new FromString(pattern, locale);
	}
	public static final FromString fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new FromString(pattern, locale, dateTimeZone);
	}
	public static final FromString fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new FromString(pattern, locale, dateTimeZone);
	}
	public static final FromString fromString(String pattern, Locale locale, Chronology chronology) {
		return new FromString(pattern, locale, chronology);
	}
	public static final FromString fromString(String pattern, String locale, Chronology chronology) {
		return new FromString(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	public static final <T extends Date> FromDate<T> fromDate() {
		return new FromDate<T>();
	}
	public static final <T extends Date> FromDate<T> fromDate(DateTimeZone dateTimeZone) {
		return new FromDate<T>(dateTimeZone);
	}
	public static final <T extends Date> FromDate<T> fromDate(Chronology chronology) {
		return new FromDate<T>(chronology);
	}
	//
	
	
	// From Date
	public static final FromTimestamp fromTimestamp() {
		return new FromTimestamp();
	}
	public static final FromTimestamp fromTimestamp(DateTimeZone dateTimeZone) {
		return new FromTimestamp(dateTimeZone);
	}
	public static final FromTimestamp fromTimestamp(Chronology chronology) {
		return new FromTimestamp(chronology);
	}
	//
		
	
	// Conversion from Long
	public static final FromLong fromLong() {
		return new FromLong();
	}
	public static final FromLong fromLong(DateTimeZone dateTimeZone) {
		return new FromLong(dateTimeZone);
	}
	public static final FromLong fromLong(Chronology chronology) {
		return new FromLong(chronology);
	}
	//
	
	// Conversion from Integer list
	public static final FromIntegerFieldList fromIntegerFieldList() {
		return new  FromIntegerFieldList();
	}
	public static final FromIntegerFieldList fromIntegerFieldList(Chronology chronology) {
		return new  FromIntegerFieldList(chronology);
	}
	//
	
	
	// Conversion from Integer array
	public static final FromIntegerFieldArray fromIntegerFieldArray() {
		return new  FromIntegerFieldArray();
	}
	public static final FromIntegerFieldArray fromIntegerFieldArray(Chronology chronology) {
		return new  FromIntegerFieldArray(chronology);
	}
	//
	
	
	// Conversion from String list
	public static final FromStringFieldList fromStringFieldList() {
		return new  FromStringFieldList();
	}
	public static final FromStringFieldList fromStringFieldList(Chronology chronology) {
		return new  FromStringFieldList(chronology);
	}
	//
	
	
	// Conversion from String array
	public static final FromStringFieldArray fromStringFieldArray() {
		return new  FromStringFieldArray();
	}
	public static final FromStringFieldArray fromStringFieldArray(Chronology chronology) {
		return new  FromStringFieldArray(chronology);
	}
	//
	
	
	// Conversion from Calendar
	public static final <T extends Calendar> FromCalendar<T> fromCalendar() {
		return new FromCalendar<T>();
	}
	public static final <T extends Calendar> FromCalendar<T> fromCalendar(DateTimeZone dateTimeZone) {
		return new FromCalendar<T>(dateTimeZone);
	}
	public static final <T extends Calendar> FromCalendar<T> fromCalendar(Chronology chronology) {
		return new FromCalendar<T>(chronology);
	}
	//
	
	
	private static abstract class BaseToDateTime<T> implements IConverter<DateTime, T> {

		DateTimeZone dateTimeZone = null;
		Chronology chronology = null;
		
		public BaseToDateTime() {
			super();			
		}

		public BaseToDateTime(DateTimeZone dateTimeZone) {
			super();
			this.dateTimeZone = dateTimeZone;
		}

		public BaseToDateTime(Chronology chronology) {
			super();
			this.chronology = chronology;
		}

		public Type<DateTime> getResultType() {
			return Types.forClass(DateTime.class);
		}
	}
	
	public static final class FromString extends BaseToDateTime<String> {

		private String pattern;
		private Locale locale;
		
		
		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter. If
		 * the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a {@link Locale} must be used instead
		 *                 
		 * @param pattern
		 */
		public FromString(String pattern) {
			super();
			this.pattern = pattern;
		}

		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter and with the given
		 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a {@link Locale} must be used instead
		 *                 
		 * @param pattern
		 * @param dateTimeZone
		 */
		public FromString(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			this.pattern = pattern;
		}

		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter and with the given
		 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a {@link Locale} must be used instead
		 * 		                
		 * @param pattern
		 * @param chronology
		 */
		public FromString(String pattern, Chronology chronology) {
			super(chronology);
			this.pattern = pattern;
		}

		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
		 * {@link Locale} parameters
		 * 
		 * @param pattern
		 * @param locale
		 */
		public FromString(String pattern, Locale locale) {
			super();
			this.pattern = pattern;
			this.locale = locale;
		}
		
		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
		 * {@link Locale} parameters
		 * 
		 * @param pattern
		 * @param locale
		 */
		public FromString(String pattern, String locale) {
			super();
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		/**
		 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
		 * The {@link DateTime} is configured with the given {@link DateTimeZone}
		 *                 
		 * @param pattern
		 * @param locale
		 * @param dateTimeZone
		 */
		public FromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			this.pattern = pattern;
			this.locale = locale;
		}
		
		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
		 * The {@link DateTime} is configured with the given {@link DateTimeZone}
		 * 
		 * @param pattern
		 * @param locale
		 * @param dateTimeZone
		 */
		public FromString(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		/**
		 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
		 * The {@link DateTime} will be created with the given {@link Chronology}
		 *                 
		 * @param pattern
		 * @param locale
		 * @param chronology
		 */
		public FromString(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			this.pattern = pattern;
			this.locale = locale;
		}
		
		/**
		 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
		 * The {@link DateTime} will be created with the given {@link Chronology}
		 * 
		 * @param pattern
		 * @param locale
		 * @param chronology
		 */
		public FromString(String pattern, String locale, Chronology chronology) {
			super(chronology);
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public DateTime execute(String object) throws Exception {
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
	
	public static final class FromDate<T extends Date> extends BaseToDateTime<T> {

		/**
		 * The given {@link Date} is converted into a {@link DateTime}
		 */
		public FromDate() {
			super();			
		}

		/**
		 * The given {@link Date} is converted into a {@link DateTime} configured with the given
		 * {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given {@link Date} is converted into a {@link DateTime} with the given
		 * {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromDate(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(T object) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object.getTime(), this.chronology);
			}
			
			return new DateTime(object.getTime());
		}
		
		
	}	
	
	public static final class FromTimestamp extends BaseToDateTime<Timestamp> {

		/**
		 * The given {@link Timestamp} is converted into a {@link DateTime}
		 */
		public FromTimestamp() {
			super();			
		}

		/**
		 * The given {@link Timestamp} is converted into a {@link DateTime} in the given
		 * {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromTimestamp(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given {@link Timestamp} is converted into a {@link DateTime} with the given
		 * {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromTimestamp(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(Timestamp object) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object.getTime(), this.chronology);
			}
			
			return new DateTime(object.getTime());
		}
	}	
	
	public static final class FromLong extends BaseToDateTime<Long> {

		/**
		 * The given long representing the time in millis is converted into a {@link DateTime}
		 */
		public FromLong() {
			super();			
		}

		/**
		 * The given long representing the time in millis is converted into a {@link DateTime} in the given
		 * {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromLong(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given long representing the time in millis is converted into a {@link DateTime} with the given
		 * {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromLong(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(Long object) throws Exception {
			if (this.dateTimeZone != null) {
				return new DateTime(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new DateTime(object.longValue(), this.chronology);
			}
			
			return new DateTime(object.longValue());
		}
	}	
	
	public static final class FromIntegerFieldList extends BaseToDateTime<List<Integer>> {

		/**
		 * A {@link DateTime} is created from the given integer list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		public FromIntegerFieldList() {
			super();			
		}

		/**
		 * A {@link DateTime} is created from the given integer list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromIntegerFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(List<Integer> object) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new FunctionExecutionException(
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
	
	public static final class FromIntegerFieldArray extends BaseToDateTime<Integer[]> {

		/**
		 * A {@link DateTime} is created from the given integer array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		
		public FromIntegerFieldArray() {
			super();			
		}

		/**
		 * A {@link DateTime} is created from the given integer array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromIntegerFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(Integer[] object) throws Exception {
			if (object.length < 4 || object.length > 7) {
				throw new FunctionExecutionException(
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
	
	
	
	public static final class FromStringFieldList extends BaseToDateTime<List<String>> {

		/**
		 * A {@link DateTime} is created from the given string list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		public FromStringFieldList() {
			super();			
		}

		/**
		 * A {@link DateTime} is created from the given string list.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromStringFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(List<String> object) throws Exception {
			if (object.size() < 4 || object.size() > 7) {
				throw new FunctionExecutionException(
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
	
	public static final class FromStringFieldArray extends BaseToDateTime<String[]> {

		/**
		 * A {@link DateTime} is created from the given string array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
		 */
		public FromStringFieldArray() {
			super();			
		}

		/**
		 * A {@link DateTime} is created from the given string array.
		 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
		 * The result will be created with the given {@link Chronology}
		 *                 
		 * @param chronology
		 */
		public FromStringFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(String[] object) throws Exception {
			if (object.length < 4 || object.length > 7) {
				throw new FunctionExecutionException(
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
	
	public static final class FromCalendar<T extends Calendar> extends BaseToDateTime<T> {

		/**
		 * It converts a {@link Calendar} into a {@link DateTime}
		 */
		public FromCalendar() {
			super();			
		}

		/**
		 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
		 * 
		 * @param dateTimeZone
		 */
		public FromCalendar(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
		 * 
		 * @param chronology
		 */
		public FromCalendar(Chronology chronology) {
			super(chronology);
		}
		
		public DateTime execute(T object) throws Exception {
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
