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

import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.BaseDateTimeToStr;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.FormatType;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.LocalDateToStr;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.LocalTimeToStr;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.CalendarToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.DateToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.IntegerFieldArrayToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.IntegerFieldListToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.LongToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.StringFieldArrayToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.StringFieldListToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.StringToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateMidnight.TimestampToDateMidnight;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.CalendarToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.DateToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.IntegerFieldArrayToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.IntegerFieldListToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.LongToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.StringFieldArrayToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.StringFieldListToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.StringToDateTime;
import org.op4j.contrib.executables.functions.conversion.FnToDateTime.TimestampToDateTime;
import org.op4j.functions.IFunction;


/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public class FnJodaTimeUtils {

	private final static TimestampToDateMidnight TIMESTAMP_TO_DATE_MIDNIGHT = new TimestampToDateMidnight();
	private final static LongToDateMidnight LONG_TO_DATE_MIDNIGHT = new LongToDateMidnight();
	private final static IntegerFieldListToDateMidnight INTEGER_FIELD_LIST_TO_DATE_MIDNIGHT = new IntegerFieldListToDateMidnight();
	private final static IntegerFieldArrayToDateMidnight INTEGER_FIELD_ARRAY_TO_DATE_MIDNIGHT = new IntegerFieldArrayToDateMidnight();
	private final static StringFieldListToDateMidnight STRING_FIELD_LIST_TO_DATE_MIDNIGHT = new StringFieldListToDateMidnight();
	private final static StringFieldArrayToDateMidnight STRING_FIELD_ARRAY_TO_DATE_MIDNIGHT = new StringFieldArrayToDateMidnight();
	
	private final static TimestampToDateTime TIMESTAMP_TO_DATE_TIME = new TimestampToDateTime();
	private final static LongToDateTime LONG_TO_DATE_TIME = new LongToDateTime();
	private final static IntegerFieldListToDateTime INTEGER_FIELD_LIST_TO_DATE_TIME = new IntegerFieldListToDateTime();
	private final static IntegerFieldArrayToDateTime INTEGER_FIELD_ARRAY_TO_DATE_TIME = new IntegerFieldArrayToDateTime();
	private final static StringFieldListToDateTime STRING_FIELD_LIST_TO_DATE_TIME = new StringFieldListToDateTime();
	private final static StringFieldArrayToDateTime STRING_FIELD_ARRAY_TO_DATE_TIME = new StringFieldArrayToDateTime();
	
	
	private FnJodaTimeUtils() {
		super();           
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
	 * 		 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @return
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format) {
		return new BaseDateTimeToStr(formatType, format);
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
	 * 		 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale {@link Locale} to be used with the given pattern
	 * @return
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return new BaseDateTimeToStr(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param chronology
	 * @return
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return new BaseDateTimeToStr(formatType, format, chronology);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
	 * 		 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale locale to be used with the given pattern
	 * @return
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final String locale) {
		return new BaseDateTimeToStr(formatType, format, locale);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final DateTimeFormatter formatter) {
		return new BaseDateTimeToStr(formatter);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 *  
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @return
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return new LocalTimeToStr(formatType, format);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 *  
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale locale to be used with the pattern
	 * @return
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return new LocalTimeToStr(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param chronology
	 * @return
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return new LocalTimeToStr(formatType, format, chronology);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale locale to be used with the pattern
	 * @return
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final String locale) {
		return new LocalTimeToStr(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final DateTimeFormatter formatter) {
		return new LocalTimeToStr(formatter);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value)
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
		return new LocalDateToStr(formatType, format);
	}
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value) with the given {@link Locale}
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Locale locale) {
		return new LocalDateToStr(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value) with the given {@link Chronology}
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param chronology
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return new LocalDateToStr(formatType, format, chronology);
	}
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value) with the given {@link Locale}
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final String locale) {
		return new LocalDateToStr(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final DateTimeFormatter formatter) {
		return new LocalDateToStr(formatter);
	}
	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern) {
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
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, DateTimeZone dateTimeZone) {
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
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, Chronology chronology) {
		return new StringToDateMidnight(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, Locale locale) {
		return new StringToDateMidnight(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, String locale) {
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
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, Chronology chronology) {
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
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, String locale, Chronology chronology) {
		return new StringToDateMidnight(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight}
	 */
	public static final <T extends Date> IFunction<T, DateMidnight> dateToDateMidnight() {
		return new DateToDateMidnight<T>();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> IFunction<T, DateMidnight> dateToDateMidnight(DateTimeZone dateTimeZone) {
		return new DateToDateMidnight<T>(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> IFunction<T, DateMidnight> dateToDateMidnight(Chronology chronology) {
		return new DateToDateMidnight<T>(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight}
	 */
	public static final IFunction<Timestamp, DateMidnight>  timestampToDateMidnight() {
		return TIMESTAMP_TO_DATE_MIDNIGHT;
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Timestamp, DateMidnight>  timestampToDateMidnight(DateTimeZone dateTimeZone) {
		return new TimestampToDateMidnight(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Timestamp, DateMidnight>  timestampToDateMidnight(Chronology chronology) {
		return new TimestampToDateMidnight(chronology);
	}
	
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight}
	 */
	public static final IFunction<Long, DateMidnight>  longToDateMidnight() {
		return LONG_TO_DATE_MIDNIGHT;
	}
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Long, DateMidnight>  longToDateMidnight(DateTimeZone dateTimeZone) {
		return new LongToDateMidnight(dateTimeZone);
	}
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Long, DateMidnight>  longToDateMidnight(Chronology chronology) {
		return new LongToDateMidnight(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<Integer>, DateMidnight>  integerFieldListToDateMidnight() {
		return INTEGER_FIELD_LIST_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<Integer>, DateMidnight>  integerFieldListToDateMidnight(Chronology chronology) {
		return new  IntegerFieldListToDateMidnight(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<Integer[], DateMidnight>  integerFieldArrayToDateMidnight() {
		return INTEGER_FIELD_ARRAY_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<Integer[], DateMidnight>  integerFieldArrayToDateMidnight(Chronology chronology) {
		return new  IntegerFieldArrayToDateMidnight(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<String>, DateMidnight>  stringFieldListToDateMidnight() {
		return STRING_FIELD_LIST_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<String>, DateMidnight>  stringFieldListToDateMidnight(Chronology chronology) {
		return new  StringFieldListToDateMidnight(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<String[], DateMidnight>  stringFieldArrayToDateMidnight() {
		return STRING_FIELD_ARRAY_TO_DATE_MIDNIGHT;
	}
	/**
	 * A {@link DateMidnight} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<String[], DateMidnight>  stringFieldArrayToDateMidnight(Chronology chronology) {
		return new  StringFieldArrayToDateMidnight(chronology);
	}
	
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight}
	 */
	public static final <T extends Calendar> IFunction<T, DateMidnight> calendarToDateMidnight() {
		return new CalendarToDateMidnight<T>();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> IFunction<T, DateMidnight> calendarToDateMidnight(DateTimeZone dateTimeZone) {
		return new CalendarToDateMidnight<T>(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> IFunction<T, DateMidnight> calendarToDateMidnight(Chronology chronology) {
		return new CalendarToDateMidnight<T>(chronology);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the 
	 * given pattern parameter. If the pattern includes either, the name of 
	 * the month or day of week, a conversion accepting a {@link Locale} must 
	 * be used instead 
	 * 
	 * @param pattern
	 * @return
	 */
	public static final StringToDateTime strToDateTime(String pattern) {
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
	public static final StringToDateTime strToDateTime(String pattern, DateTimeZone dateTimeZone) {
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
	public static final StringToDateTime strToDateTime(String pattern, Chronology chronology) {
		return new StringToDateTime(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringToDateTime strToDateTime(String pattern, Locale locale) {
		return new StringToDateTime(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringToDateTime strToDateTime(String pattern, String locale) {
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
	public static final StringToDateTime strToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final StringToDateTime strToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final StringToDateTime strToDateTime(String pattern, Locale locale, Chronology chronology) {
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
	public static final StringToDateTime strToDateTime(String pattern, String locale, Chronology chronology) {
		return new StringToDateTime(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link DateTime}
	 */
	public static final <T extends Date> DateToDateTime<T> dateToDateTime() {
		return new DateToDateTime<T>();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> DateToDateTime<T> dateToDateTime(DateTimeZone dateTimeZone) {
		return new DateToDateTime<T>(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> DateToDateTime<T> dateToDateTime(Chronology chronology) {
		return new DateToDateTime<T>(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime}
	 */
	public static final TimestampToDateTime timestampToDateTime() {
		return TIMESTAMP_TO_DATE_TIME;
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final TimestampToDateTime timestampToDateTime(DateTimeZone dateTimeZone) {
		return new TimestampToDateTime(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final TimestampToDateTime timestampToDateTime(Chronology chronology) {
		return new TimestampToDateTime(chronology);
	}
	
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime}
	 */
	public static final LongToDateTime longToDateTime() {
		return LONG_TO_DATE_TIME;
	}
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final LongToDateTime longToDateTime(DateTimeZone dateTimeZone) {
		return new LongToDateTime(dateTimeZone);
	}
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final LongToDateTime longToDateTime(Chronology chronology) {
		return new LongToDateTime(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IntegerFieldListToDateTime integerFieldListToDateTime() {
		return INTEGER_FIELD_LIST_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IntegerFieldListToDateTime integerFieldListToDateTime(Chronology chronology) {
		return new  IntegerFieldListToDateTime(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IntegerFieldArrayToDateTime integerFieldArrayToDateTime() {
		return INTEGER_FIELD_ARRAY_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IntegerFieldArrayToDateTime integerFieldArrayToDateTime(Chronology chronology) {
		return new  IntegerFieldArrayToDateTime(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link String} list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final StringFieldListToDateTime stringFieldListToDateTime() {
		return STRING_FIELD_LIST_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final StringFieldListToDateTime stringFieldListToDateTime(Chronology chronology) {
		return new  StringFieldListToDateTime(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final StringFieldArrayToDateTime stringFieldArrayToDateTime() {
		return STRING_FIELD_ARRAY_TO_DATE_TIME;
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final StringFieldArrayToDateTime stringFieldArrayToDateTime(Chronology chronology) {
		return new  StringFieldArrayToDateTime(chronology);
	}
	
	/**
	 * It converts a {@link Calendar} into a {@link DateTime}
	 */
	public static final <T extends Calendar> CalendarToDateTime<T> calendarToDateTime() {
		return new CalendarToDateTime<T>();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> CalendarToDateTime<T> calendarToDateTime(DateTimeZone dateTimeZone) {
		return new CalendarToDateTime<T>(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> CalendarToDateTime<T> calendarToDateTime(Chronology chronology) {
		return new CalendarToDateTime<T>(chronology);
	}
	
}
