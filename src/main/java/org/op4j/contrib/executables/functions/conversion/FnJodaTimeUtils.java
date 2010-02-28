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
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.FormatType;
import org.op4j.contrib.executables.functions.conversion.FnToInterval.BaseDateTimeFieldListToInterval;
import org.op4j.contrib.executables.functions.conversion.FnToInterval.DateFieldListToInterval;
import org.op4j.functions.IFunction;


/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public class FnJodaTimeUtils {
	
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
		return FnJodaToString.fromBaseDateTime(formatType, format);
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
		return FnJodaToString.fromBaseDateTime(formatType, format, locale);
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
		return FnJodaToString.fromBaseDateTime(formatType, format, chronology);
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
		return FnJodaToString.fromBaseDateTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromBaseDateTime(formatter);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 *  
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @return
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromLocalTime(formatType, format);
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
		return FnJodaToString.fromLocalTime(formatType, format, locale);
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
		return FnJodaToString.fromLocalTime(formatType, format, chronology);
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
		return FnJodaToString.fromLocalTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromLocalTime(formatter);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value)
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromLocalDate(formatType, format);
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
		return FnJodaToString.fromLocalDate(formatType, format, locale);
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
		return FnJodaToString.fromLocalDate(formatType, format, chronology);
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
		return FnJodaToString.fromLocalDate(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromLocalDate(formatter);
	}
	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern) {
		return FnToDateMidnight.fromString(pattern);
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
		return FnToDateMidnight.fromString(pattern, dateTimeZone);
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
		return FnToDateMidnight.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, Locale locale) {
		return FnToDateMidnight.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, DateMidnight> strToDateMidnight(String pattern, String locale) {
		return FnToDateMidnight.fromString(pattern, locale);
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
		return FnToDateMidnight.fromString(pattern, locale, dateTimeZone);
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
		return FnToDateMidnight.fromString(pattern, locale, dateTimeZone);
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
		return FnToDateMidnight.fromString(pattern, locale, chronology);
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
		return FnToDateMidnight.fromString(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight}
	 */
	public static final <T extends Date> IFunction<T, DateMidnight> dateToDateMidnight() {
		return FnToDateMidnight.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> IFunction<T, DateMidnight> dateToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> IFunction<T, DateMidnight> dateToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromDate(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight}
	 */
	public static final IFunction<Timestamp, DateMidnight>  timestampToDateMidnight() {
		return FnToDateMidnight.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Timestamp, DateMidnight>  timestampToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Timestamp, DateMidnight>  timestampToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromTimestamp(chronology);
	}
	
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight}
	 */
	public static final IFunction<Long, DateMidnight>  longToDateMidnight() {
		return FnToDateMidnight.fromLong();
	}
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Long, DateMidnight>  longToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in millis is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Long, DateMidnight>  longToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromLong(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<Integer>, DateMidnight>  integerFieldListToDateMidnight() {
		return FnToDateMidnight.fromIntegerFieldList();
	}
	/**
	 * A {@link DateMidnight} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<Integer>, DateMidnight>  integerFieldListToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromIntegerFieldList(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<Integer[], DateMidnight>  integerFieldArrayToDateMidnight() {
		return FnToDateMidnight.fromIntegerFieldArray();
	}
	/**
	 * A {@link DateMidnight} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<Integer[], DateMidnight>  integerFieldArrayToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<String>, DateMidnight>  stringFieldListToDateMidnight() {
		return FnToDateMidnight.fromStringFieldList();
	}
	/**
	 * A {@link DateMidnight} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<String>, DateMidnight>  stringFieldListToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromStringFieldList(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<String[], DateMidnight>  stringFieldArrayToDateMidnight() {
		return FnToDateMidnight.fromStringFieldArray();
	}
	/**
	 * A {@link DateMidnight} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<String[], DateMidnight>  stringFieldArrayToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromStringFieldArray(chronology);
	}
	
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight}
	 */
	public static final <T extends Calendar> IFunction<T, DateMidnight> calendarToDateMidnight() {
		return FnToDateMidnight.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> IFunction<T, DateMidnight> calendarToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> IFunction<T, DateMidnight> calendarToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromCalendar(chronology);
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
	public static final IFunction<String, DateTime> strToDateTime(String pattern) {
		return FnToDateTime.fromString(pattern);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, DateTimeZone dateTimeZone) {
		return FnToDateTime.fromString(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, Chronology chronology) {
		return FnToDateTime.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, Locale locale) {
		return FnToDateTime.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, String locale) {
		return FnToDateTime.fromString(pattern, locale);
	}
	/**
	 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToDateTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToDateTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, Locale locale, Chronology chronology) {
		return FnToDateTime.fromString(pattern, locale, chronology);
	}
	/**
	 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<String, DateTime> strToDateTime(String pattern, String locale, Chronology chronology) {
		return FnToDateTime.fromString(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link DateTime}
	 */
	public static final <T extends Date> IFunction<T, DateTime> dateToDateTime() {
		return FnToDateTime.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> IFunction<T, DateTime> dateToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> IFunction<T, DateTime> dateToDateTime(Chronology chronology) {
		return FnToDateTime.fromDate(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime}
	 */
	public static final IFunction<Timestamp, DateTime> timestampToDateTime() {
		return FnToDateTime.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Timestamp, DateTime> timestampToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Timestamp, DateTime> timestampToDateTime(Chronology chronology) {
		return FnToDateTime.fromTimestamp(chronology);
	}
	
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime}
	 */
	public static final IFunction<Long, DateTime> longToDateTime() {
		return FnToDateTime.fromLong();
	}
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Long, DateTime> longToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromLong(dateTimeZone);
	}
	/**
	 * The given {@link Long} representing the time in millis is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Long, DateTime> longToDateTime(Chronology chronology) {
		return FnToDateTime.fromLong(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<Integer>, DateTime> integerFieldListToDateTime() {
		return FnToDateTime.fromIntegerFieldList();
	}
	/**
	 * A {@link DateTime} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<Integer>, DateTime> integerFieldListToDateTime(Chronology chronology) {
		return FnToDateTime.fromIntegerFieldList(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<Integer[], DateTime> integerFieldArrayToDateTime() {
		return FnToDateTime.fromIntegerFieldArray();
	}
	/**
	 * A {@link DateTime} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<Integer[], DateTime> integerFieldArrayToDateTime(Chronology chronology) {
		return FnToDateTime.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link String} list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<String>, DateTime> stringFieldListToDateTime() {
		return FnToDateTime.fromStringFieldList();
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<String>, DateTime> stringFieldListToDateTime(Chronology chronology) {
		return FnToDateTime.fromStringFieldList(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<String[], DateTime> stringFieldArrayToDateTime() {
		return FnToDateTime.fromStringFieldArray();
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<String[], DateTime> stringFieldArrayToDateTime(Chronology chronology) {
		return FnToDateTime.fromStringFieldArray(chronology);
	}
	
	/**
	 * It converts a {@link Calendar} into a {@link DateTime}
	 */
	public static final <T extends Calendar> IFunction<T, DateTime> calendarToDateTime() {
		return FnToDateTime.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> IFunction<T, DateTime> calendarToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> IFunction<T, DateTime> calendarToDateTime(Chronology chronology) {
		return FnToDateTime.fromCalendar(chronology);
	}
	
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input lists are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 				
	 * @return
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval() {
		return FnToInterval.fromStringFieldList();
	}

	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input lists are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 
	 * @param dateTimeZone
	 * @return
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldList(dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input lists are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 
	 * @param chronology
	 * @return
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromStringFieldList(chronology);
	}
	/**
	 * It creates an {@link Interval} using the target {@link String} elements as the start and end. The given pattern
	 * will be used to create the {@link DateTime} objects from the given {@link String} elements. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern) {
		return FnToInterval.fromStringFieldList(pattern);
	}
	/**
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link DateTimeZone}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldList(pattern, dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link Chronology}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 * 
	 * @param pattern
	 * @param chronology
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, Chronology chronology) {
		return FnToInterval.fromStringFieldList(pattern, chronology);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, Locale locale) {
		return FnToInterval.fromStringFieldList(pattern, locale);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, String locale) {
		return FnToInterval.fromStringFieldList(pattern, locale);
	}	
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the interval.
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldList(pattern, locale, dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the interval.
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldList(pattern, locale, dateTimeZone);
	}	
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the interval.
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, Locale locale, Chronology chronology) {
		return FnToInterval.fromStringFieldList(pattern, locale, chronology);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the interval.
	 *
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<List<String>, Interval> stringFieldListToInterval(String pattern, String locale, Chronology chronology) {
		return FnToInterval.fromStringFieldList(pattern, locale, chronology);
	}	
	
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 				
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval() {
		return FnToInterval.fromStringFieldArray();
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param dateTimeZone
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param chronology
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromStringFieldArray(chronology);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern) {
		return FnToInterval.fromStringFieldArray(pattern);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param dateTimeZone
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param chronology
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, chronology);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, Locale locale) {
		return FnToInterval.fromStringFieldArray(pattern, locale);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, String locale) {
		return FnToInterval.fromStringFieldArray(pattern, locale);
	}	
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, locale, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param locale
	 * @param chronology
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, Locale locale, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, locale, chronology);
	}
	/**
	 * It converts the given {@link String} elements into an interval. 
	 * The target {@link String} elements represent the start and end of the interval. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern
	 * @param locale
	 * @param chronology
	 * @return
	 */
	public static final IFunction<String[], Interval> stringFieldArrayToInterval(String pattern, String locale, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, locale, chronology);
	}	
	
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements  
	 */
	public static final DateFieldListToInterval dateFieldListToInterval() {
		return FnToInterval.fromDateFieldList();
	}
	/**
	 * 
	 * It creates an {@link Interval} from the given {@link Date}  elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<List<? extends Date>, Interval> dateFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromDateFieldList(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<List<? extends Date>, Interval> dateFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromDateFieldList(chronology);
	}
	
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 */
	public static final <T extends Date> IFunction<T[], Interval> dateFieldArrayToInterval() {
		return FnToInterval.fromDateFieldArray();
	}
	/**
	 * 
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> IFunction<T[], Interval> dateFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromDateFieldArray(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> IFunction<T[], Interval> dateFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromDateFieldArray(chronology);
	}
	
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 */
	public static final IFunction<List<Timestamp>, Interval> timestampFieldListToInterval() {
		return FnToInterval.fromTimestampFieldList();
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */	
	public static final IFunction<List<Timestamp>, Interval> timestampFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromTimestampFieldList(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<List<Timestamp>, Interval> timestampFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromTimestampFieldList(chronology);
	}
	
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 */
	public static final IFunction<Timestamp[], Interval> timestampFieldArrayToInterval() {
		return FnToInterval.fromTimestampFieldArray();
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */	
	public static final IFunction<Timestamp[], Interval> timestampFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromTimestampFieldArray(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Timestamp[], Interval> timestampFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromTimestampFieldArray(chronology);
	}
	
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 */
	public static final IFunction<List<Long>, Interval> longFieldListToInterval() {
		return FnToInterval.fromLongFieldList();
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<List<Long>, Interval> longFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromLongFieldList(dateTimeZone);
	}
	/**
	 * The given {@link Long} targets representing the time in millis will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<List<Long>, Interval> longFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromLongFieldList(chronology);
	}
	
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 */
	public static final IFunction<Long[], Interval> longFieldArrayToInterval() {
		return FnToInterval.fromLongFieldArray();
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Long[], Interval> longFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromLongFieldArray(dateTimeZone);
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Long[], Interval> longFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromLongFieldArray(chronology);
	}
	
	public static final IFunction<List<Integer>, Interval> integerFieldListToInterval() {
		return FnToInterval.fromIntegerFieldList();
	}
	public static final IFunction<List<Integer>, Interval> integerFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromIntegerFieldList(dateTimeZone);
	}
	public static final IFunction<List<Integer>, Interval> integerFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromIntegerFieldList(chronology);
	}
	
	public static final IFunction<Integer[], Interval> integerFieldArrayToInterval() {
		return FnToInterval.fromIntegerFieldArray();
	}
	public static final IFunction<Integer[], Interval> integerFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromIntegerFieldArray(dateTimeZone);
	}
	public static final IFunction<Integer[], Interval> integerFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start 
	 * and end of the interval
	 */
	public static final IFunction<List<? extends Calendar>, Interval> calendarFieldListToInterval() {
		return FnToInterval.fromCalendarFieldList();
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * Such an interval will be created in the given DateTimeZone
	 *                 
	 * @param dateTimeZone
	 */
	public static final IFunction<List<? extends Calendar>, Interval> calendarFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromCalendarFieldList(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * The interval will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<List<? extends Calendar>, Interval> calendarFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromCalendarFieldList(chronology);
	}
	
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start 
	 * and end of the interval
	 */
	public static final <T extends Calendar> IFunction<T[], Interval> calendarFieldArrayToInterval() {
		return FnToInterval.fromCalendarFieldArray();
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * Such an interval will be created in the given DateTimeZone
	 *                 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> IFunction<T[], Interval> calendarFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromCalendarFieldArray(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * The interval will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> IFunction<T[], Interval> calendarFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromCalendarFieldArray(chronology);
	}

	public static final BaseDateTimeFieldListToInterval fromBaseDateTimeFieldListToInterval() {
		return FnToInterval.fromBaseDateTimeFieldList();
	}
	public static final IFunction<List<? extends BaseDateTime>, Interval> fromBaseDateTimeFieldListToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromBaseDateTimeFieldList(dateTimeZone);
	}
	public static final IFunction<List<? extends BaseDateTime>, Interval> fromBaseDateTimeFieldListToInterval(Chronology chronology) {
		return FnToInterval.fromBaseDateTimeFieldList(chronology);
	}
	
	public static final <T extends BaseDateTime> IFunction<T[], Interval> fromBaseDateTimeFieldArrayToInterval() {
		return FnToInterval.fromBaseDateTimeFieldArray();
	}
	public static final <T extends BaseDateTime> IFunction<T[], Interval> fromBaseDateTimeFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromBaseDateTimeFieldArray(dateTimeZone);
	}
	public static final <T extends BaseDateTime> IFunction<T[], Interval> fromBaseDateTimeFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromBaseDateTimeFieldArray(chronology);
	}
	
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern) {
		return FnToLocalDate.fromString(pattern);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromString(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, Locale locale) {
		return FnToLocalDate.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, String locale) {
		return FnToLocalDate.fromString(pattern, locale);
	}
	/**
	 * It converts the given String into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, Locale locale, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, locale, chronology);
	}
	/**
	 * It converts the given String into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<String, LocalDate> stringToLocalDate(String pattern, String locale, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link LocalDate}
	 */
	public static final <T extends Date> IFunction<T, LocalDate> dateToLocalDate() {
		return FnToLocalDate.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalDate} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> IFunction<T, LocalDate> dateToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> IFunction<T, LocalDate> dateToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromDate(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalDate}
	 */
	public static final IFunction<Timestamp, LocalDate> timestampToLocalDate() {
		return FnToLocalDate.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalDate} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Timestamp, LocalDate> timestampToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Timestamp, LocalDate> timestampToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromTimestamp(chronology);
	}
	
	
	/**
	 * The given long representing the time in millis is converted into a {@link LocalDate}
	 */
	public static final IFunction<Long, LocalDate> longToLocalDate() {
		return FnToLocalDate.fromLong();
	}
	/**
	 * The given long representing the time in millis is converted into a {@link LocalDate} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Long, LocalDate> longToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in millis is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Long, LocalDate> longToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromLong(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<Integer>, LocalDate> integerFieldListToLocalDate() {
		return FnToLocalDate.fromIntegerFieldList();
	}
	/**
	 * A {@link LocalDate} is created from the given integer list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<Integer>, LocalDate> integerFieldListToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromIntegerFieldList(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<Integer[], LocalDate> integerFieldArrayToLocalDate() {
		return FnToLocalDate.fromIntegerFieldArray();
	}
	/**
	 * A {@link LocalDate} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<Integer[], LocalDate> integerFieldArrayToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<List<String>, LocalDate> stringFieldListToLocalDate() {
		return FnToLocalDate.fromStringFieldList();
	}
	/**
	 * A {@link LocalDate} is created from the given string list.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<String>, LocalDate> stringFieldListToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromStringFieldList(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final IFunction<String[], LocalDate> stringFieldArrayToLocalDate() {
		return FnToLocalDate.fromStringFieldArray();
	}
	/**
	 * A {@link LocalDate} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<String[], LocalDate> stringFieldArrayToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromStringFieldArray(chronology);
	}
	
	
	/**
	 * It converts a {@link Calendar} into a {@link LocalDate}
	 */
	public static final <T extends Calendar> IFunction<T, LocalDate> calendarToLocalDate() {
		return FnToLocalDate.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalDate} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> IFunction<T, LocalDate> calendarToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalDate} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> IFunction<T, LocalDate> calendarToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromCalendar(chronology);
	}
	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern 
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern) {
		return FnToLocalTime.fromString(pattern);
	}	
	/**
	 * It converts the given String into a {@link LocalTime} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromString(pattern, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * 		                
	 * @param pattern
	 * @param chronology
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, Locale locale) {
		return FnToLocalTime.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, String locale) {
		return FnToLocalTime.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, Locale locale, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, locale, chronology);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 *                 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final IFunction<String, LocalTime> stringToLocalTime(String pattern, String locale, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, locale, chronology);
	}

	/**
	 * The given {@link Date} is converted into a {@link LocalTime}
	 */
	public static final <T extends Date> IFunction<T, LocalTime> dateToLocalTime() {
		return FnToLocalTime.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalTime} configured with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> IFunction<T, LocalTime> dateToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> IFunction<T, LocalTime> dateToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromDate(chronology);
	}

	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime}
	 */
	public static final IFunction<Timestamp, LocalTime> timestampToLocalTime() {
		return FnToLocalTime.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Timestamp, LocalTime> timestampToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Timestamp, LocalTime> timestampToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromTimestamp(chronology);
	}

	/**
	 * The given long representing the time in millis is converted into a {@link LocalTime}
	 */
	public static final IFunction<Long, LocalTime> longToLocalTime() {
		return FnToLocalTime.fromLong();
	}
	/**
	 * The given long representing the time in millis is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final IFunction<Long, LocalTime> longToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in millis is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final IFunction<Long, LocalTime> longToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromLong(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link Integer} list.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final IFunction<List<Integer>, LocalTime> integerFieldListToLocalTime() {
		return FnToLocalTime.fromIntegerFieldList();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} list.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<Integer>, LocalTime> integerFieldListToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromIntegerFieldList(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link Integer} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final IFunction<Integer[], LocalTime> integerFieldArrayToLocalTime() {
		return FnToLocalTime.fromIntegerFieldArray();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<Integer[], LocalTime> integerFieldArrayToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromIntegerFieldArray(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link String} list.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final IFunction<List<String>, LocalTime> stringFieldListToLocalTime() {
		return FnToLocalTime.fromStringFieldList();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link String} list.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<List<String>, LocalTime> stringFieldListToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromStringFieldList(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final IFunction<String[], LocalTime> stringFieldArrayToLocalTime() {
		return FnToLocalTime.fromStringFieldArray();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final IFunction<String[], LocalTime> stringFieldArrayToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromStringFieldArray(chronology);
	}

	/**
	 * It converts a {@link Calendar} into a {@link LocalTime}
	 */
	public static final <T extends Calendar> IFunction<T, LocalTime> calendarToLocalTime() {
		return FnToLocalTime.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> IFunction<T, LocalTime> calendarToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> IFunction<T, LocalTime> calendarToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromCalendar(chronology);
	}

	/**
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final IFunction<List<? extends Date>, Period> fromDateFieldListToPeriod() {
		return FnToPeriod.fromDateFieldList();
	}	
	/**
	 * @param chronology {@link Chronology} the {@link Period} is being created with
	 * 
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final IFunction<List<? extends Date>, Period> fromDateFieldListToPeriod(final Chronology chronology) {
		return FnToPeriod.fromDateFieldList(chronology);
	}	
	public static final IFunction<List<? extends Date>, Period> fromDateFieldListToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromDateFieldList(periodType);
	}
	public static final IFunction<List<? extends Date>, Period> fromDateFieldListToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromDateFieldList(periodType, chronology);
	}
	public static final <T extends Date> IFunction<T[], Period> fromDateFieldArrayToPeriod() {
		return FnToPeriod.fromDateFieldArray();
	}	
	public static final <T extends Date> IFunction<T[], Period> fromDateFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromDateFieldArray(chronology);
	}	
	public static final <T extends Date> IFunction<T[], Period> fromDateFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromDateFieldArray(periodType);
	}
	public static final <T extends Date> IFunction<T[], Period> fromDateFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromDateFieldArray(periodType, chronology);
	}

	public static final IFunction<List<Timestamp>, Period> fromTimestampFieldListToPeriod() {
		return FnToPeriod.fromTimestampFieldList();
	}	
	public static final IFunction<List<Timestamp>, Period> fromTimestampFieldListToPeriod(final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldList(chronology);
	}	
	public static final IFunction<List<Timestamp>, Period> fromTimestampFieldListToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromTimestampFieldList(periodType);
	}
	public static final IFunction<List<Timestamp>, Period> fromTimestampFieldListToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldList(periodType, chronology);
	}
	public static final IFunction<Timestamp[], Period> fromTimestampFieldArrayToPeriod() {
		return FnToPeriod.fromTimestampFieldArray();
	}	
	public static final IFunction<Timestamp[], Period> fromTimestampFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldArray(chronology);
	}	
	public static final IFunction<Timestamp[], Period> fromTimestampFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromTimestampFieldArray(periodType);
	}
	public static final IFunction<Timestamp[], Period> fromTimestampFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldArray(periodType, chronology);
	}

	/**
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final IFunction<Long, Period> fromLongToPeriod() {
		return FnToPeriod.fromLong();
	}
	/**
	 * @param chronology the {@link Chronology} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final IFunction<Long, Period> fromLongToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLong(chronology);
	}
	/**
	 * @param periodType the {@link PeriodType} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final IFunction<Long, Period> fromLongToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLong(periodType);
	}
	/**
	 * @param periodType the {@link PeriodType} the returned {@link Period} will
	 * be created with
	 * @param chronology the {@link Chronology} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final IFunction<Long, Period> fromLongToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLong(periodType, chronology);
	}

	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<List<Long>, Period> fromLongFieldListToPeriod() {
		return FnToPeriod.fromLongFieldList();
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<List<Long>, Period> fromLongFieldListToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLongFieldList(chronology);
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<List<Long>, Period> fromLongFieldListToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLongFieldList(periodType);
	}
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<List<Long>, Period> fromLongFieldListToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLongFieldList(periodType, chronology);
	}
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<Long[], Period> fromLongFieldArrayToPeriod() {
		return FnToPeriod.fromLongFieldArray();
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<Long[], Period> fromLongFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLongFieldArray(chronology);
	}	
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<Long[], Period> fromLongFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLongFieldArray(periodType);
	}
	/**
	 * The given long targets representing the time in millis will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<Long[], Period> fromLongFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLongFieldArray(periodType, chronology);
	}

	/**
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final IFunction<List<? extends Calendar>, Period> fromCalendarFieldListToPeriod() {
		return FnToPeriod.fromCalendarFieldList();
	}	
	public static final IFunction<List<? extends Calendar>, Period> fromCalendarFieldListToPeriod(final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldList(chronology);
	}	
	public static final IFunction<List<? extends Calendar>, Period> fromCalendarFieldListToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromCalendarFieldList(periodType);
	}
	public static final IFunction<List<? extends Calendar>, Period> fromCalendarFieldListToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldList(periodType, chronology);
	}
	/**
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final <T extends Calendar> IFunction<T[], Period> fromCalendarFieldArrayToPeriod() {
		return FnToPeriod.fromCalendarFieldArray();
	}	
	public static final <T extends Calendar> IFunction<T[], Period> fromCalendarFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldArray(chronology);
	}	
	public static final <T extends Calendar> IFunction<T[], Period> fromCalendarFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromCalendarFieldArray(periodType);
	}
	public static final <T extends Calendar> IFunction<T[], Period> fromCalendarFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldArray(periodType, chronology);
	}

	/**
	 * @return the {@link Period} represented by the given start and end 
	 * {@link BaseDateTime} elements
	 */ 
	public static final IFunction<List<? extends BaseDateTime>, Period> fromBaseDateTimeFieldListToPeriod() {
		return FnToPeriod.fromBaseDateTimeFieldList();
	}	
	public static final IFunction<List<? extends BaseDateTime>, Period> fromBaseDateTimeFieldListToPeriod(final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldList(chronology);
	}	
	public static final IFunction<List<? extends BaseDateTime>, Period> fromBaseDateTimeFieldListToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromBaseDateTimeFieldList(periodType);
	}
	public static final IFunction<List<? extends BaseDateTime>, Period> fromBaseDateTimeFieldListToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldList(periodType, chronology);
	}
	/**
	 * @return the {@link Period} represented by the given start and end 
	 * {@link BaseDateTime} elements
	 */
	public static final <T extends BaseDateTime> IFunction<T[], Period> fromBaseDateTimeFieldArrayToPeriod() {
		return FnToPeriod.fromBaseDateTimeFieldArray();
	}	
	public static final <T extends BaseDateTime> IFunction<T[], Period> fromBaseDateTimeFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldArray(chronology);
	}	
	public static final <T extends BaseDateTime> IFunction<T[], Period> fromBaseDateTimeFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromBaseDateTimeFieldArray(periodType);
	}
	public static final <T extends BaseDateTime> IFunction<T[], Period> fromBaseDateTimeFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldArray(periodType, chronology);
	}
	
	/**
	 * A Period is created either:
	 * <ul>	  
	 * <li>From a set of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
	 * <li>From a set of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
	 * </ul>
	 * 
	 * @return the {@link Period}
	 */
	public static final IFunction<List<Integer>, Period> fromIntegerFieldListToPeriod() {
		return FnToPeriod.fromIntegerFieldList();
	}
	public static final IFunction<List<Integer>, Period> fromIntegerFieldListToPeriod(PeriodType periodType) {
		return FnToPeriod.fromIntegerFieldList(periodType);
	}
	public static final IFunction<Integer[], Period> fromIntegerFieldArrayToPeriod() {
		return FnToPeriod.fromIntegerFieldArray();
	}
	public static final IFunction<Integer[], Period> fromIntegerFieldArrayToPeriod(PeriodType periodType) {
		return FnToPeriod.fromIntegerFieldArray(periodType);
	}
	
	/**
	 * A Period is created either:
	 * <ul>	  
	 * <li>From a set of {@link String} representing the hours, minutes, seconds and milliseconds</li>
	 * <li>From a set of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
	 * </ul>
	 * 
	 * @return the {@link Period}
	 */
	public static final IFunction<List<String>, Period> fromStringFieldListToPeriod() {
		return FnToPeriod.fromStringFieldList();
	}
	public static final IFunction<List<String>, Period> fromStringFieldListToPeriod(PeriodType periodType) {
		return FnToPeriod.fromStringFieldList(periodType);
	}
	public static final IFunction<String[], Period> fromStringFieldArrayToPeriod() {
		return FnToPeriod.fromStringFieldArray();
	}
	public static final IFunction<String[], Period> fromStringFieldArrayToPeriod(PeriodType periodType) {
		return FnToPeriod.fromStringFieldArray(periodType);
	}
	
}
