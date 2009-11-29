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
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToLocalTime {

	
	
	private ToLocalTime() {
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
	
	
	
	
	
	
	
	private static abstract class BaseToLocalTime<T> implements IFunc<LocalTime, T> {

		DateTimeZone dateTimeZone = null;
		Chronology chronology = null;
		
		public BaseToLocalTime() {
			super();			
		}

		public BaseToLocalTime(DateTimeZone dateTimeZone) {
			super();
			this.dateTimeZone = dateTimeZone;
		}

		public BaseToLocalTime(Chronology chronology) {
			super();
			this.chronology = chronology;
		}

		public Type<LocalTime> getResultType() {
			return Types.forClass(LocalTime.class);
		}
	}
	
	public static final class FromString extends BaseToLocalTime<String> {

		private String pattern;
		private Locale locale;
		
		
		/**
		 * It converts the given String into a LocalTime using the given pattern parameter. If
		 * the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a Locale must be used instead
		 *                 
		 * @param pattern
		 */
		public FromString(String pattern) {
			super();
			this.pattern = pattern;
		}

		/**
		 * It converts the given String into a LocalTime using the given pattern parameter and with the given
		 * DateTimeZone. If the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a Locale must be used instead
		 *                 
		 * @param pattern
		 * @param dateTimeZone
		 */
		public FromString(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			this.pattern = pattern;
		}

		/**
		 * It converts the given String into a LocalTime using the given pattern parameter and with the given
		 * Chronology. If the pattern includes either, the name of the month or day of week, a conversion
		 * accepting a Locale must be used instead
		 * 		                
		 * @param pattern
		 * @param chronology
		 */
		public FromString(String pattern, Chronology chronology) {
			super(chronology);
			this.pattern = pattern;
		}

		/**
		 * It converts the given String into a LocalTime using the given pattern and Locale parameters
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
		 * It converts the given String into a LocalTime using the given pattern and Locale parameters
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
		 * It converts the given String into a LocalTime using the given pattern and Locale parameters.
		 * The DateTime is configured with the given DateTimeZone
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
		 * It converts the given String into a LocalTime using the given pattern and Locale parameters.
		 * The DateTime is configured with the given DateTimeZone
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
		 * It converts the given String into a LocalTime using the given pattern and Locale parameters.
		 * The DateTime will be created with the given Chronology
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
		 * It converts the given String into a LocalTime using the given pattern and Locale parameters.
		 * The DateTime will be created with the given Chronology
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
		
		public LocalTime execute(String object) throws Exception {
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
	
	public static final class FromDate<T extends Date> extends BaseToLocalTime<T> {

		/**
		 * The given {@link Date} is converted into a LocalTime
		 */
		public FromDate() {
			super();			
		}

		/**
		 * The given {@link Date} is converted into a LocalTime configured with the given DateTimeZone
		 * 
		 * @param dateTimeZone
		 */
		public FromDate(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given {@link Date} is converted into a LocalTime with the given Chronology
		 * 
		 * @param chronology
		 */
		public FromDate(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(T object) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object.getTime(), this.chronology);
			}
			
			return new LocalTime(object.getTime());
		}
		
		
	}	
	
	public static final class FromTimestamp extends BaseToLocalTime<Timestamp> {

		/**
		 * The given {@link Timestamp} is converted into a LocalTime
		 */
		public FromTimestamp() {
			super();			
		}

		/**
		 * The given {@link Timestamp} is converted into a LocalTime in the given DateTimeZone
		 * 
		 * @param dateTimeZone
		 */
		public FromTimestamp(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given {@link Timestamp} is converted into a LocalTime with the given Chronology
		 * 
		 * @param chronology
		 */
		public FromTimestamp(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(Timestamp object) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object.getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object.getTime(), this.chronology);
			}
			
			return new LocalTime(object.getTime());
		}
	}	
	
	public static final class FromLong extends BaseToLocalTime<Long> {

		/**
		 * The given long representing the time in millis is converted into a LocalTime
		 */
		public FromLong() {
			super();			
		}

		/**
		 * The given long representing the time in millis is converted into a LocalTime in the given DateTimeZone
		 * 
		 * @param dateTimeZone
		 */
		public FromLong(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * The given long representing the time in millis is converted into a LocalTime with the given Chronology
		 * 
		 * @param chronology
		 */
		public FromLong(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(Long object) throws Exception {
			if (this.dateTimeZone != null) {
				return new LocalTime(object.longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new LocalTime(object.longValue(), this.chronology);
			}
			
			return new LocalTime(object.longValue());
		}
	}	
	
	public static final class FromIntegerFieldList extends BaseToLocalTime<List<Integer>> {

		/**
		 * A LocalTime is created from the given integer list.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
		 */
		public FromIntegerFieldList() {
			super();			
		}

		/**
		 * A LocalTime is created from the given integer list.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
		 * The result will be created with the given Chronology
		 *                 
		 * @param chronology
		 */
		public FromIntegerFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(List<Integer> object) throws Exception {
			if (object.size() > 4) {
				throw new FunctionExecutionException(
						"Integer arguments list for LocalTime conversion should of size " +
						"<= 4. Size " + object.size() + " is not valid.");
			}			
			
			int hour = (object.size() >= 1) ? object.get(0).intValue() : 0;
			int minute = (object.size() >= 2) ? object.get(1).intValue() : 0;
			int second = (object.size() >= 3) ? object.get(2).intValue() : 0;
			int milli = (object.size() >= 4) ? object.get(3).intValue() : 0;
			
			if (this.chronology != null) {
	        	return new LocalTime(hour, minute, second, 
	        			milli, this.chronology);
	        }
			return new LocalTime(hour, minute, second, 
        			milli);
		}
	}	
	
	public static final class FromIntegerFieldArray extends BaseToLocalTime<Integer[]> {

		/**
		 * A LocalTime is created from the given integer array.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
		 */
		
		public FromIntegerFieldArray() {
			super();			
		}

		/**
		 * A LocalTime is created from the given integer array.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
		 * The result will be created with the given Chronology
		 *                 
		 * @param chronology
		 */
		public FromIntegerFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(Integer[] object) throws Exception {
			if (object.length > 4) {
				throw new FunctionExecutionException(
						"Integer arguments array for LocalTime conversion should of size " +
						"<= 4. Size " + object.length + " is not valid.");
			}			
			
			int hour = (object.length >= 1) ? object[0].intValue() : 0;
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
	
	
	
	public static final class FromStringFieldList extends BaseToLocalTime<List<String>> {

		/**
		 * A LocalTime is created from the given string list.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
		 */
		public FromStringFieldList() {
			super();			
		}

		/**
		 * A LocalTime is created from the given string list.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
		 * The result will be created with the given Chronology
		 *                 
		 * @param chronology
		 */
		public FromStringFieldList(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(List<String> object) throws Exception {
			if (object.size() > 4) {
				throw new FunctionExecutionException(
						"String arguments list for LocalTime conversion should of size " +
						"<= 4. Size " + object.size() + " is not valid.");
			}			
			
			String hour = (object.size() >= 1) ? object.get(0) : "0";
			String minute = (object.size() >= 2) ? object.get(1) : "0";
			String second = (object.size() >= 3) ? object.get(2) : "0";
			String milli = (object.size() >= 4) ? object.get(3) : "0";
			
			if (this.chronology != null) {
	        	return new LocalTime(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second), 
	        			Integer.parseInt(milli), this.chronology);
	        }
			return new LocalTime(Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), 
        			Integer.parseInt(milli));
		}
		
		
	}	
	
	public static final class FromStringFieldArray extends BaseToLocalTime<String[]> {

		/**
		 * A LocalTime is created from the given string array.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
		 */
		public FromStringFieldArray() {
			super();			
		}

		/**
		 * A LocalTime is created from the given string array.
		 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
		 * The result will be created with the given Chronology
		 *                 
		 * @param chronology
		 */
		public FromStringFieldArray(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(String[] object) throws Exception {
			if (object.length > 4) {
				throw new FunctionExecutionException(
						"String arguments array for LocalTime conversion should of size " +
						"<= 4. Size " + object.length + " is not valid.");
			}			
			
			String hour = (object.length >= 1) ? object[0] : "0";
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
	
	public static final class FromCalendar<T extends Calendar> extends BaseToLocalTime<T> {

		/**
		 * It converts a Calendar into a LocalTime
		 */
		public FromCalendar() {
			super();			
		}

		/**
		 * It converts a Calendar into a LocalTime in the given DateTimeZone
		 * 
		 * @param dateTimeZone
		 */
		public FromCalendar(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}

		/**
		 * It converts a Calendar into a LocalTime with the given Chronology
		 * 
		 * @param chronology
		 */
		public FromCalendar(Chronology chronology) {
			super(chronology);
		}
		
		public LocalTime execute(T object) throws Exception {
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
