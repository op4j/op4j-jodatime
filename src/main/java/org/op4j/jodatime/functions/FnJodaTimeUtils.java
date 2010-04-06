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
import org.op4j.functions.Function;
import org.op4j.jodatime.functions.FnJodaToString.FormatType;
import org.op4j.jodatime.functions.FnToInterval.BaseDateTimeFieldCollectionToInterval;
import org.op4j.jodatime.functions.FnToInterval.DateFieldCollectionToInterval;


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
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @return
	 */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromBaseDateTime(formatType, format);
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 * 		 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale {@link Locale} to be used with the given pattern
	 * @return
	 */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaToString.fromBaseDateTime(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param chronology
	 * @return
	 */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaToString.fromBaseDateTime(formatType, format, chronology);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 * 		 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale locale to be used with the given pattern
	 * @return
	 */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaToString.fromBaseDateTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromBaseDateTime(formatter);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 *  
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @return
	 */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromLocalTime(formatType, format);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 *  
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale locale to be used with the pattern
	 * @return
	 */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaToString.fromLocalTime(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param chronology
	 * @return
	 */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaToString.fromLocalTime(formatType, format, chronology);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style
	 * (depending on the value of formatType parameter).
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @param locale locale to be used with the pattern
	 * @return
	 */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaToString.fromLocalTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final Function<LocalTime, String> localTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromLocalTime(formatter);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value)
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Locale locale) {
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Chronology chronology) {
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaToString.fromLocalDate(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final Function<LocalDate, String> localDateToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromLocalDate(formatter);
	}
	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Chronology chronology) {
		return FnToDateMidnight.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale) {
		return FnToDateMidnight.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale, Chronology chronology) {
		return FnToDateMidnight.fromString(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight}
	 */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight() {
		return FnToDateMidnight.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromDate(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight}
	 */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight() {
		return FnToDateMidnight.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromTimestamp(chronology);
	}
	
	/**
	 * The given long representing the time in milliseconds is converted into a {@link DateMidnight}
	 */
	public static final Function<Long, DateMidnight>  longToDateMidnight() {
		return FnToDateMidnight.fromLong();
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Long, DateMidnight>  longToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Long, DateMidnight>  longToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromLong(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Collection<Integer>, DateMidnight>  integerFieldCollectionToDateMidnight() {
		return FnToDateMidnight.fromIntegerFieldCollection();
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<Integer>, DateMidnight>  integerFieldCollectionToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromIntegerFieldCollection(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Integer[], DateMidnight>  integerFieldArrayToDateMidnight() {
		return FnToDateMidnight.fromIntegerFieldArray();
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link Integer} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Integer[], DateMidnight>  integerFieldArrayToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Collection<String>, DateMidnight>  strFieldCollectionToDateMidnight() {
		return FnToDateMidnight.fromStringFieldCollection();
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<String>, DateMidnight>  strFieldCollectionToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromStringFieldCollection(chronology);
	}
	
	/**
	 * A {@link DateMidnight} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<String[], DateMidnight>  strFieldArrayToDateMidnight() {
		return FnToDateMidnight.fromStringFieldArray();
	}
	/**
	 * A {@link DateMidnight} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<String[], DateMidnight>  strFieldArrayToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromStringFieldArray(chronology);
	}
	
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight}
	 */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight() {
		return FnToDateMidnight.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight(Chronology chronology) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Chronology chronology) {
		return FnToDateTime.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale) {
		return FnToDateTime.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, Chronology chronology) {
		return FnToDateTime.fromString(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link DateTime}
	 */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime() {
		return FnToDateTime.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(Chronology chronology) {
		return FnToDateTime.fromDate(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime}
	 */
	public static final Function<Timestamp, DateTime> timestampToDateTime() {
		return FnToDateTime.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Timestamp, DateTime> timestampToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Timestamp, DateTime> timestampToDateTime(Chronology chronology) {
		return FnToDateTime.fromTimestamp(chronology);
	}
	
	/**
	 * The given {@link Long} representing the time in milliseconds is converted into a {@link DateTime}
	 */
	public static final Function<Long, DateTime> longToDateTime() {
		return FnToDateTime.fromLong();
	}
	/**
	 * The given {@link Long} representing the time in milliseconds is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Long, DateTime> longToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromLong(dateTimeZone);
	}
	/**
	 * The given {@link Long} representing the time in milliseconds is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Long, DateTime> longToDateTime(Chronology chronology) {
		return FnToDateTime.fromLong(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime() {
		return FnToDateTime.fromIntegerFieldCollection();
	}
	/**
	 * A {@link DateTime} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime(Chronology chronology) {
		return FnToDateTime.fromIntegerFieldCollection(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link Integer} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime() {
		return FnToDateTime.fromIntegerFieldArray();
	}
	/**
	 * A {@link DateTime} is created from the given {@link Integer} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime(Chronology chronology) {
		return FnToDateTime.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime() {
		return FnToDateTime.fromStringFieldCollection();
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime(Chronology chronology) {
		return FnToDateTime.fromStringFieldCollection(chronology);
	}
	
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<String[], DateTime> strFieldArrayToDateTime() {
		return FnToDateTime.fromStringFieldArray();
	}
	/**
	 * A {@link DateTime} is created from the given {@link String} array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<String[], DateTime> strFieldArrayToDateTime(Chronology chronology) {
		return FnToDateTime.fromStringFieldArray(chronology);
	}
	
	/**
	 * It converts a {@link Calendar} into a {@link DateTime}
	 */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime() {
		return FnToDateTime.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(Chronology chronology) {
		return FnToDateTime.fromCalendar(chronology);
	}
	
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input collections are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 				
	 * @return
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval() {
		return FnToInterval.fromStringFieldCollection();
	}

	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input collections are:
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input collections are:
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(chronology);
	}
	/**
	 * It creates an {@link Interval} using the target {@link String} elements as the start and end. The given pattern
	 * will be used to create the {@link DateTime} objects from the given {@link String} elements. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern) {
		return FnToInterval.fromStringFieldCollection(pattern);
	}
	/**
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link DateTimeZone}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(pattern, dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link Chronology}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 * 
	 * @param pattern
	 * @param chronology
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(pattern, chronology);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale) {
		return FnToInterval.fromStringFieldCollection(pattern, locale);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale) {
		return FnToInterval.fromStringFieldCollection(pattern, locale);
	}	
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the {@link Interval}.
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the {@link Interval}.
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, dateTimeZone);
	}	
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the {@link Interval}.
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, chronology);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the {@link Interval}.
	 *
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, chronology);
	}	
	
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 				
	 * @return
	 */
	public static final Function<String[], Interval> strFieldArrayToInterval() {
		return FnToInterval.fromStringFieldArray();
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromStringFieldArray(chronology);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern) {
		return FnToInterval.fromStringFieldArray(pattern);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, chronology);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale) {
		return FnToInterval.fromStringFieldArray(pattern, locale);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale) {
		return FnToInterval.fromStringFieldArray(pattern, locale);
	}	
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, locale, dateTimeZone);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, locale, dateTimeZone);
	}	
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, locale, chronology);
	}
	/**
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. The accepted input arrays are:
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, locale, chronology);
	}	
	
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements  
	 */
	public static final DateFieldCollectionToInterval dateFieldCollectionToInterval() {
		return FnToInterval.fromDateFieldCollection();
	}
	/**
	 * 
	 * It creates an {@link Interval} from the given {@link Date}  elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromDateFieldCollection(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromDateFieldCollection(chronology);
	}
	
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval() {
		return FnToInterval.fromDateFieldArray();
	}
	/**
	 * 
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromDateFieldArray(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromDateFieldArray(chronology);
	}
	
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 */
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval() {
		return FnToInterval.fromTimestampFieldCollection();
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */	
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromTimestampFieldCollection(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromTimestampFieldCollection(chronology);
	}
	
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 */
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval() {
		return FnToInterval.fromTimestampFieldArray();
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */	
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromTimestampFieldArray(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromTimestampFieldArray(chronology);
	}
	
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval() {
		return FnToInterval.fromLongFieldCollection();
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromLongFieldCollection(dateTimeZone);
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromLongFieldCollection(chronology);
	}
	
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 */
	public static final Function<Long[], Interval> longFieldArrayToInterval() {
		return FnToInterval.fromLongFieldArray();
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Long[], Interval> longFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromLongFieldArray(dateTimeZone);
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Long[], Interval> longFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromLongFieldArray(chronology);
	}
	
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval() {
		return FnToInterval.fromIntegerFieldCollection();
	}
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromIntegerFieldCollection(dateTimeZone);
	}
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromIntegerFieldCollection(chronology);
	}
	
	public static final Function<Integer[], Interval> integerFieldArrayToInterval() {
		return FnToInterval.fromIntegerFieldArray();
	}
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromIntegerFieldArray(dateTimeZone);
	}
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start 
	 * and end of the {@link Interval}
	 */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval() {
		return FnToInterval.fromCalendarFieldCollection();
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * Such an {@link Interval} will be created in the given DateTimeZone
	 *                 
	 * @param dateTimeZone
	 */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromCalendarFieldCollection(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromCalendarFieldCollection(chronology);
	}
	
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start 
	 * and end of the {@link Interval}
	 */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval() {
		return FnToInterval.fromCalendarFieldArray();
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * Such an {@link Interval} will be created in the given DateTimeZone
	 *                 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromCalendarFieldArray(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromCalendarFieldArray(chronology);
	}

	public static final BaseDateTimeFieldCollectionToInterval baseDateTimeFieldCollectionToInterval() {
		return FnToInterval.fromBaseDateTimeFieldCollection();
	}
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromBaseDateTimeFieldCollection(dateTimeZone);
	}
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromBaseDateTimeFieldCollection(chronology);
	}
	
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval() {
		return FnToInterval.fromBaseDateTimeFieldArray();
	}
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromBaseDateTimeFieldArray(dateTimeZone);
	}
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromBaseDateTimeFieldArray(chronology);
	}
	
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale) {
		return FnToLocalDate.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalDate} using the given pattern and
	 * {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, locale, chronology);
	}
	
	/**
	 * The given {@link Date} is converted into a {@link LocalDate}
	 */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate() {
		return FnToLocalDate.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalDate} configured with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromDate(chronology);
	}
	
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalDate}
	 */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate() {
		return FnToLocalDate.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalDate} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromTimestamp(chronology);
	}
	
	
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalDate}
	 */
	public static final Function<Long, LocalDate> longToLocalDate() {
		return FnToLocalDate.fromLong();
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalDate} in the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Long, LocalDate> longToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalDate} with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Long, LocalDate> longToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromLong(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate() {
		return FnToLocalDate.fromIntegerFieldCollection();
	}
	/**
	 * A {@link LocalDate} is created from the given {@link Integer} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromIntegerFieldCollection(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate() {
		return FnToLocalDate.fromIntegerFieldArray();
	}
	/**
	 * A {@link LocalDate} is created from the given integer array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromIntegerFieldArray(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate() {
		return FnToLocalDate.fromStringFieldCollection();
	}
	/**
	 * A {@link LocalDate} is created from the given {@link String} {@link Collection}.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromStringFieldCollection(chronology);
	}
	
	/**
	 * A {@link LocalDate} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1.
	 */
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate() {
		return FnToLocalDate.fromStringFieldArray();
	}
	/**
	 * A {@link LocalDate} is created from the given string array.
	 * Year, month, day can be used. If not all of them set, the last ones will be set to 1
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromStringFieldArray(chronology);
	}
	
	
	/**
	 * It converts a {@link Calendar} into a {@link LocalDate}
	 */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate() {
		return FnToLocalDate.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalDate} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalDate} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromCalendar(chronology);
	}
	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern 
	 */
	public static final Function<String, LocalTime> strToLocalTime(String pattern) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, chronology);
	}	
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale) {
		return FnToLocalTime.fromString(pattern, locale);
	}
	/**
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, locale, chronology);
	}

	/**
	 * The given {@link Date} is converted into a {@link LocalTime}
	 */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime() {
		return FnToLocalTime.fromDate();
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalTime} configured with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromDate(dateTimeZone);
	}
	/**
	 * The given {@link Date} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromDate(chronology);
	}

	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime}
	 */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime() {
		return FnToLocalTime.fromTimestamp();
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromTimestamp(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromTimestamp(chronology);
	}

	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime}
	 */
	public static final Function<Long, LocalTime> longToLocalTime() {
		return FnToLocalTime.fromLong();
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final Function<Long, LocalTime> longToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromLong(dateTimeZone);
	}
	/**
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final Function<Long, LocalTime> longToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromLong(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link Integer} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<Collection<Integer>, LocalTime> integerFieldCollectionToLocalTime() {
		return FnToLocalTime.fromIntegerFieldCollection();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<Integer>, LocalTime> integerFieldCollectionToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromIntegerFieldCollection(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link Integer} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<Integer[], LocalTime> integerFieldArrayToLocalTime() {
		return FnToLocalTime.fromIntegerFieldArray();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link Integer} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Integer[], LocalTime> integerFieldArrayToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromIntegerFieldArray(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link String} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<Collection<String>, LocalTime> strFieldCollectionToLocalTime() {
		return FnToLocalTime.fromStringFieldCollection();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link String} {@link Collection}.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<Collection<String>, LocalTime> strFieldCollectionToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromStringFieldCollection(chronology);
	}

	/**
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0.
	 */
	public static final Function<String[], LocalTime> strFieldArrayToLocalTime() {
		return FnToLocalTime.fromStringFieldArray();
	}
	/**
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * Hour, minute, second and millisecond can be used. If not all of them set, the last ones will be set to 0
	 * The result will be created with the given {@link Chronology}
	 *                 
	 * @param chronology
	 */
	public static final Function<String[], LocalTime> strFieldArrayToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromStringFieldArray(chronology);
	}

	/**
	 * It converts a {@link Calendar} into a {@link LocalTime}
	 */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime() {
		return FnToLocalTime.fromCalendar();
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime} in the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromCalendar(dateTimeZone);
	}
	/**
	 * It converts a {@link Calendar} into a {@link LocalTime} with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromCalendar(chronology);
	}

	/**
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod() {
		return FnToPeriod.fromDateFieldCollection();
	}	
	/**
	 * @param chronology {@link Chronology} the {@link Period} is being created with
	 * 
	 * @return the {@link Period} created from the {@link Date} target elements given as the start
	 * and end of such {@link Period}
	 */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromDateFieldCollection(chronology);
	}	
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromDateFieldCollection(periodType);
	}
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromDateFieldCollection(periodType, chronology);
	}
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod() {
		return FnToPeriod.fromDateFieldArray();
	}	
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromDateFieldArray(chronology);
	}	
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromDateFieldArray(periodType);
	}
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromDateFieldArray(periodType, chronology);
	}

	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod() {
		return FnToPeriod.fromTimestampFieldCollection();
	}	
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldCollection(chronology);
	}	
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromTimestampFieldCollection(periodType);
	}
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldCollection(periodType, chronology);
	}
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod() {
		return FnToPeriod.fromTimestampFieldArray();
	}	
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldArray(chronology);
	}	
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromTimestampFieldArray(periodType);
	}
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldArray(periodType, chronology);
	}

	/**
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final Function<Long, Period> longToPeriod() {
		return FnToPeriod.fromLong();
	}
	/**
	 * @param chronology the {@link Chronology} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final Function<Long, Period> longToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLong(chronology);
	}
	/**
	 * @param periodType the {@link PeriodType} the returned {@link Period} will
	 * be created with
	 * 
	 * @return a Period with the given Duration in milliseconds
	 */
	public static final Function<Long, Period> longToPeriod(final PeriodType periodType) {
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
	public static final Function<Long, Period> longToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLong(periodType, chronology);
	}

	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod() {
		return FnToPeriod.fromLongFieldCollection();
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLongFieldCollection(chronology);
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLongFieldCollection(periodType);
	}
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLongFieldCollection(periodType, chronology);
	}
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 *  
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Long[], Period> longFieldArrayToPeriod() {
		return FnToPeriod.fromLongFieldArray();
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLongFieldArray(chronology);
	}	
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLongFieldArray(periodType);
	}
	/**
	 * The given long targets representing the time in milliseconds will be used as the start
	 * and end instants of the Period returned 
	 * 
	 * @param periodType {@link PeriodType} the {@link Period} will be created with
	 * @param chronology {@link Chronology} the {@link Period} will be created with
	 * 
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLongFieldArray(periodType, chronology);
	}

	/**
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod() {
		return FnToPeriod.fromCalendarFieldCollection();
	}	
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldCollection(chronology);
	}	
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromCalendarFieldCollection(periodType);
	}
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldCollection(periodType, chronology);
	}
	/**
	 * @return the {@link Period} represented by the given start and end instants
	 */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod() {
		return FnToPeriod.fromCalendarFieldArray();
	}	
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldArray(chronology);
	}	
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromCalendarFieldArray(periodType);
	}
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldArray(periodType, chronology);
	}

	/**
	 * @return the {@link Period} represented by the given start and end 
	 * {@link BaseDateTime} elements
	 */ 
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod() {
		return FnToPeriod.fromBaseDateTimeFieldCollection();
	}	
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldCollection(chronology);
	}	
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromBaseDateTimeFieldCollection(periodType);
	}
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldCollection(periodType, chronology);
	}
	/**
	 * @return the {@link Period} represented by the given start and end 
	 * {@link BaseDateTime} elements
	 */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod() {
		return FnToPeriod.fromBaseDateTimeFieldArray();
	}	
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldArray(chronology);
	}	
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromBaseDateTimeFieldArray(periodType);
	}
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
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
	public static final Function<Collection<Integer>, Period> integerFieldCollectionToPeriod() {
		return FnToPeriod.fromIntegerFieldCollection();
	}
	public static final Function<Collection<Integer>, Period> integerFieldCollectionToPeriod(PeriodType periodType) {
		return FnToPeriod.fromIntegerFieldCollection(periodType);
	}
	public static final Function<Integer[], Period> integerFieldArrayToPeriod() {
		return FnToPeriod.fromIntegerFieldArray();
	}
	public static final Function<Integer[], Period> integerFieldArrayToPeriod(PeriodType periodType) {
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
	public static final Function<Collection<String>, Period> strFieldCollectionToPeriod() {
		return FnToPeriod.fromStringFieldCollection();
	}
	public static final Function<Collection<String>, Period> strFieldCollectionToPeriod(PeriodType periodType) {
		return FnToPeriod.fromStringFieldCollection(periodType);
	}
	public static final Function<String[], Period> strFieldArrayToPeriod() {
		return FnToPeriod.fromStringFieldArray();
	}
	public static final Function<String[], Period> strFieldArrayToPeriod(PeriodType periodType) {
		return FnToPeriod.fromStringFieldArray(periodType);
	}
	
}
