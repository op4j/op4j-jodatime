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
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType 
     * @param format 
     * @return
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromBaseDateTime(formatType, format);
	}
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     *  
     * @param formatType 
     * @param format
     * @param locale 
     * @return
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaToString.fromBaseDateTime(formatType, format, locale);
	}
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType
     * @param format 
     * @param chronology
     * @return
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaToString.fromBaseDateTime(formatType, format, chronology);
	}
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     *       
     * @param formatType
     * @param format
     * @param locale 
     * @return
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaToString.fromBaseDateTime(formatType, format, locale);
	}
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
     * </p>
     * 
     * @param formatter
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromBaseDateTime(formatter);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType 
     * @param format 
     * @return
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromLocalTime(formatType, format);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType
     * @param format
     * @param locale 
     * @return
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaToString.fromLocalTime(formatType, format, locale);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType 
     * @param format
     * @param chronology
     * @return
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaToString.fromLocalTime(formatType, format, chronology);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType
     * @param format 
     * @param locale 
     * @return
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaToString.fromLocalTime(formatType, format, locale);
	}
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
     * </p>
     * 
     * @param formatter
     */
	public static final Function<LocalTime, String> localTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromLocalTime(formatter);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value)
     * </p>
     * 
     * @param formatType 
     * @param format 
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
		return FnJodaToString.fromLocalDate(formatType, format);
	}
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value) with the given {@link Locale}
     * </p>
     * 
     * @param formatType 
     * @param format 
     * @param locale
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaToString.fromLocalDate(formatType, format, locale);
	}
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value) with the given {@link Chronology}
     * </p>
     * 
     * @param formatType 
     * @param format 
     * @param chronology
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaToString.fromLocalDate(formatType, format, chronology);
	}
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value) with the given {@link Locale}
     * </p>
     * 
     * @param formatType 
     * @param format 
     * @param locale
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaToString.fromLocalDate(formatType, format, locale);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
     * </p>
     * 
     * @param formatter
     */
	public static final Function<LocalDate, String> localDateToStr(final DateTimeFormatter formatter) {
		return FnJodaToString.fromLocalDate(formatter);
	}
	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern parameter. If
     * the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern) {
		return FnToDateMidnight.fromString(pattern);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
     * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern
     * @param dateTimeZone
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromString(pattern, dateTimeZone);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
     * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                  
     * @param pattern
     * @param chronology
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Chronology chronology) {
		return FnToDateMidnight.fromString(pattern, chronology);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale) {
		return FnToDateMidnight.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale) {
		return FnToDateMidnight.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the input String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
     * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
     * </p>
     *               
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
     * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
     * The {@link DateMidnight} will be created with the given {@link Chronology}
     * </p>
     *                 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, Chronology chronology) {
		return FnToDateMidnight.fromString(pattern, locale, chronology);
	}
	/**
     * <p>
     * It converts the input String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
     * The {@link DateMidnight} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale, Chronology chronology) {
		return FnToDateMidnight.fromString(pattern, locale, chronology);
	}
	
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateMidnight}
     * </p>
     */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight() {
		return FnToDateMidnight.fromDate();
	}
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateMidnight} configured with the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromDate(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateMidnight} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromDate(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateMidnight}
     * </p>
     */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight() {
		return FnToDateMidnight.fromTimestamp();
	}
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateMidnight} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromTimestamp(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateMidnight} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromTimestamp(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateMidnight}
     * </p>
     */
	public static final Function<Long, DateMidnight>  longToDateMidnight() {
		return FnToDateMidnight.fromLong();
	}
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateMidnight} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Long, DateMidnight>  longToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromLong(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Long}g representing the time in milliseconds is converted into a {@link DateMidnight} with the given
     * {@link Chronology}
     * <p>
     * 
     * @param chronology
     */
	public static final Function<Long, DateMidnight>  longToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromLong(chronology);
	}
	
	/**
     * <p>
     * A {@link DateMidnight} is created from the input {@link Integer} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     * 
     */
	public static final Function<Collection<Integer>, DateMidnight>  integerFieldCollectionToDateMidnight() {
		return FnToDateMidnight.fromIntegerFieldCollection();
	}
	/**
     * <p>
     * A {@link DateMidnight} is created from the input {@link Integer} {@link Collection}.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<Integer>, DateMidnight>  integerFieldCollectionToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromIntegerFieldCollection(chronology);
	}
	
	/**
     * <p>
     * A {@link DateMidnight} is created from the input {@link Integer} array.
     * </p>
     * 
     * <p>
     * The valid input Integer[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     */
	public static final Function<Integer[], DateMidnight>  integerFieldArrayToDateMidnight() {
		return FnToDateMidnight.fromIntegerFieldArray();
	}
	/**
     * <p>
     * A {@link DateMidnight} is created from the given {@link Integer} array.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Integer[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Integer[], DateMidnight>  integerFieldArrayToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromIntegerFieldArray(chronology);
	}
	
	/**
     * <p>
     * A {@link DateMidnight} is created from the input {@link String} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<String> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     */
	public static final Function<Collection<String>, DateMidnight>  strFieldCollectionToDateMidnight() {
		return FnToDateMidnight.fromStringFieldCollection();
	}
	/**
     * <p>
     * A {@link DateMidnight} is created from the input {@link String} {@link Collection}.
     * The result will be created with the given {@link Chronology}
     * </p>                
     * 
     * <p>
     * The valid input Collection<String> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<String>, DateMidnight>  strFieldCollectionToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromStringFieldCollection(chronology);
	}
	
	/**
     * <p>
     * A {@link DateMidnight} is created from the given {@link String} array.
     * </p>
     * 
     * <p>
     * The valid input String[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     * 
     */
	public static final Function<String[], DateMidnight>  strFieldArrayToDateMidnight() {
		return FnToDateMidnight.fromStringFieldArray();
	}
	/**
     * <p>
     * A {@link DateMidnight} is created from the input {@link String} array.
     * The result will be created with the given {@link Chronology}
     * </p>                
     * 
     * <p>
     * The valid input String[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<String[], DateMidnight>  strFieldArrayToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromStringFieldArray(chronology);
	}
	
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateMidnight}
     * </p>
     */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight() {
		return FnToDateMidnight.fromCalendar();
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight(DateTimeZone dateTimeZone) {
		return FnToDateMidnight.fromCalendar(dateTimeZone);
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight(Chronology chronology) {
		return FnToDateMidnight.fromCalendar(chronology);
	}
	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateTime} using the 
     * given pattern parameter. If the pattern includes either, the name of 
     * the month or day of week, a conversion accepting a {@link Locale} must 
     * be used instead 
     * </p>
     * 
     * @param pattern
     * @return
     */
	public static final Function<String, DateTime> strToDateTime(String pattern) {
		return FnToDateTime.fromString(pattern);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateTime} using the given pattern parameter and with the given
     * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern
     * @param dateTimeZone
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, DateTimeZone dateTimeZone) {
		return FnToDateTime.fromString(pattern, dateTimeZone);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateTime} using the given pattern parameter and with the given
     * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                      
     * @param pattern
     * @param chronology
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, Chronology chronology) {
		return FnToDateTime.fromString(pattern, chronology);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateTime} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale) {
		return FnToDateTime.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link DateTime} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale) {
		return FnToDateTime.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} is configured with the given {@link DateTimeZone}
     * </p>
     *                 
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToDateTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} is configured with the given {@link DateTimeZone}
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToDateTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} will be created with the given {@link Chronology}
     * </p>
     *                 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, Chronology chronology) {
		return FnToDateTime.fromString(pattern, locale, chronology);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, Chronology chronology) {
		return FnToDateTime.fromString(pattern, locale, chronology);
	}
	
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateTime}
     * </p>
     */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime() {
		return FnToDateTime.fromDate();
	}
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateTime} configured with the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromDate(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateTime} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(Chronology chronology) {
		return FnToDateTime.fromDate(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateTime}
     * </p>
     */
	public static final Function<Timestamp, DateTime> timestampToDateTime() {
		return FnToDateTime.fromTimestamp();
	}
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateTime} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Timestamp, DateTime> timestampToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromTimestamp(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateTime} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Timestamp, DateTime> timestampToDateTime(Chronology chronology) {
		return FnToDateTime.fromTimestamp(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime}
     * </p>
     */
	public static final Function<Long, DateTime> longToDateTime() {
		return FnToDateTime.fromLong();
	}
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Long, DateTime> longToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromLong(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Long, DateTime> longToDateTime(Chronology chronology) {
		return FnToDateTime.fromLong(chronology);
	}
	
	/**
     * <p>
     * A {@link DateTime} is created from the input {@link Integer} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     */
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime() {
		return FnToDateTime.fromIntegerFieldCollection();
	}
	/**
     * <p>
     * A {@link DateTime} is created from the input {@link Integer} {@link Collection}.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime(Chronology chronology) {
		return FnToDateTime.fromIntegerFieldCollection(chronology);
	}
	
	/**
     * <p>
     * A {@link DateTime} is created from the given {@link Integer} array.
     * </p>
     * 
     * <p>
     * The valid input Integer[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     */
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime() {
		return FnToDateTime.fromIntegerFieldArray();
	}
	/**
     * <p>
     * A {@link DateTime} is created from the given {@link Integer} array.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Integer[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime(Chronology chronology) {
		return FnToDateTime.fromIntegerFieldArray(chronology);
	}
	
	/**
     * <p>
     * A {@link DateTime} is created from the given {@link String} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<String> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     */
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime() {
		return FnToDateTime.fromStringFieldCollection();
	}
	/**
     * <p>
     * A {@link DateTime} is created from the given {@link String} {@link Collection}.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Collection<String> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime(Chronology chronology) {
		return FnToDateTime.fromStringFieldCollection(chronology);
	}
	
	/**
     * <p>
     * A {@link DateTime} is created from the given {@link String} array.
     * </p>
     * 
     * <p>
     * The valid input String[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     * 
     */
	public static final Function<String[], DateTime> strFieldArrayToDateTime() {
		return FnToDateTime.fromStringFieldArray();
	}
	/**
     * <p>
     * A {@link DateTime} is created from the given {@link String} array.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input String[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<String[], DateTime> strFieldArrayToDateTime(Chronology chronology) {
		return FnToDateTime.fromStringFieldArray(chronology);
	}
	
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateTime}
     * </p>
     */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime() {
		return FnToDateTime.fromCalendar();
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(DateTimeZone dateTimeZone) {
		return FnToDateTime.fromCalendar(dateTimeZone);
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(Chronology chronology) {
		return FnToDateTime.fromCalendar(chronology);
	}
	
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}
     * </p>
     * 
     * <p>
     * The accepted input Collection<String> are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *              
     * @return
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval() {
		return FnToInterval.fromStringFieldCollection();
	}

	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input Ccollection<String> are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     * @param dateTimeZone
     * @return
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input Collection<String> are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     * @param chronology
     * @return
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(chronology);
	}
	/**
     * <p>
     * It creates an {@link Interval} using the target {@link String} elements as the start and end. The given pattern
     * will be used to create the {@link DateTime} objects from the given {@link String} elements. If
     * the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern) {
		return FnToInterval.fromStringFieldCollection(pattern);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
     * and with the given {@link DateTimeZone}. If the pattern includes either, the name of the month or
     * day of week, a conversion accepting a {@link Locale} must be used instead
     * </p>
     *                  
     * @param pattern
     * @param dateTimeZone
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(pattern, dateTimeZone);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
     * and with the given {@link Chronology}. If the pattern includes either, the name of the month or
     * day of week, a conversion accepting a {@link Locale} must be used instead
     * </p>
     * 
     * @param pattern
     * @param chronology
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(pattern, chronology);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the given {@link String} elements using the given pattern
     * and {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale) {
		return FnToInterval.fromStringFieldCollection(pattern, locale);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the given {@link String} elements using the given pattern
     * and {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale) {
		return FnToInterval.fromStringFieldCollection(pattern, locale);
	}	
	/**
     * <p>
     * It creates an {@link Interval} from the given {@link String} elements using the given pattern
     * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the {@link Interval}.
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the given {@link String} elements using the given pattern
     * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the {@link Interval}.
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, dateTimeZone);
	}	
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link String} elements using the given pattern
     * and {@link Locale} parameters. The given {@link Chronology} will be used to create the {@link Interval}.
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, chronology);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link String} elements using the given pattern
     * and {@link Locale} parameters. The given {@link Chronology} will be used to create the {@link Interval}.
     * </p>
     *
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, Chronology chronology) {
		return FnToInterval.fromStringFieldCollection(pattern, locale, chronology);
	}	
	
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *              
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval() {
		return FnToInterval.fromStringFieldArray();
	}
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *  
     * @param dateTimeZone
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(dateTimeZone);
	}
	/**
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *      
     * @param chronology
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromStringFieldArray(chronology);
	}
	/**
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     * @param pattern
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern) {
		return FnToInterval.fromStringFieldArray(pattern);
	}
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *      
     * @param pattern
     * @param dateTimeZone
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, DateTimeZone dateTimeZone) {
		return FnToInterval.fromStringFieldArray(pattern, dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *      
     * @param pattern
     * @param chronology
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Chronology chronology) {
		return FnToInterval.fromStringFieldArray(pattern, chronology);
	}
	/**
     * <p>
     * It converts the input {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}.
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *      
     * @param pattern
     * @param locale
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale) {
		return FnToInterval.fromStringFieldArray(pattern, locale);
	}
	/**
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *  
     * @param pattern
     * @param locale
     * @return
     */
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale) {
		return FnToInterval.fromStringFieldArray(pattern, locale);
	}	
	/**
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
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
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
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
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
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
     * <p>
     * It converts the given {@link String} elements into an {@link Interval}. 
     * The target {@link String} elements represent the start and end of the {@link Interval}.
     * </p>
     * 
     * <p>
     * The accepted input String[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
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
     * <p>
     * It creates an {@link Interval} from the input {@link Date} elements  
     * </p>
     */
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval() {
		return FnToInterval.fromDateFieldCollection();
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Date}  elements.
     * The {@link Interval} will be created with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromDateFieldCollection(dateTimeZone);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Date} elements.
     * The {@link Interval} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromDateFieldCollection(chronology);
	}
	
	/**
     * <p>
     * It creates an {@link Interval} from the given {@link Date} elements.
     * </p>
     */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval() {
		return FnToInterval.fromDateFieldArray();
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Date} elements.
     * The {@link Interval} will be created with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromDateFieldArray(dateTimeZone);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Date} elements.
     * The {@link Interval} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromDateFieldArray(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned
     * </p>
     */
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval() {
		return FnToInterval.fromTimestampFieldCollection();
	}
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromTimestampFieldCollection(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromTimestampFieldCollection(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned
     * </p>
     */
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval() {
		return FnToInterval.fromTimestampFieldArray();
	}
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */ 
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromTimestampFieldArray(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromTimestampFieldArray(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned
     * </p>
     */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval() {
		return FnToInterval.fromLongFieldCollection();
	}
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromLongFieldCollection(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromLongFieldCollection(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned
     * </p>
     */
	public static final Function<Long[], Interval> longFieldArrayToInterval() {
		return FnToInterval.fromLongFieldArray();
	}
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Long[], Interval> longFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromLongFieldArray(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Long[], Interval> longFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromLongFieldArray(chronology);
	}
	
	/**
     * <p>
     * It converts the input {@link Integer} elements into an {@link Interval}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}.
     * </p>
     * 
     * <p>The accepted input Collection<Integer> collections are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *       
     * @return
     */
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval() {
		return FnToInterval.fromIntegerFieldCollection();
	}
	
	/**
     * <p>
     * It converts the input {@link Integer} elements into an {@link Interval} with the given {@link DateTime}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Collection<Integer> are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *          
     * @param dateTimeZone
     * @return
     */
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromIntegerFieldCollection(dateTimeZone);
	}
	
	/**
     * <p>
     * It converts the given {@link Integer} elements into an {@link Interval}.  with the given {@link Chronology}
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Collection<Integer> are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *  
     * @param chronology
     * @return
     */
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromIntegerFieldCollection(chronology);
	}
	
	/**
     * <p>
     * It converts the given {@link Integer} elements into an {@link Interval}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Integer[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *         
     * @return
     */
	public static final Function<Integer[], Interval> integerFieldArrayToInterval() {
		return FnToInterval.fromIntegerFieldArray();
	}
	
	/**
     * <p>
     * It converts the given {@link Integer} elements into an {@link Interval} with the given {@link DateTimeZone}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Integer[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     * @param dateTimeZone
     * @return
     */
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromIntegerFieldArray(dateTimeZone);
	}
	
	/**
     * <p>
     * It converts the given {@link Integer} elements into an {@link Interval} with the given {@link Chronology}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Integer[] are:
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     * @param chronology            
     * @return
     */
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromIntegerFieldArray(chronology);
	}
	
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets used as the start 
     * and end of the {@link Interval}
     * </p>
     */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval() {
		return FnToInterval.fromCalendarFieldCollection();
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets used as the start and end. 
     * Such an {@link Interval} will be created in the given DateTimeZone
     * </p>
     *                 
     * @param dateTimeZone
     */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromCalendarFieldCollection(dateTimeZone);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets used as the start and end. 
     * The {@link Interval} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromCalendarFieldCollection(chronology);
	}
	
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets representing the start 
     * and end of the {@link Interval}
     * </p>
     */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval() {
		return FnToInterval.fromCalendarFieldArray();
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets representing the start and end. 
     * Such an {@link Interval} will be created in the given DateTimeZone
     * </p>
     *                 
     * @param dateTimeZone
     */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromCalendarFieldArray(dateTimeZone);
	}
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets representing the start and end. 
     * The {@link Interval} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromCalendarFieldArray(chronology);
	}

	/**
     * <p>
     * The two target elements accepted by this function are used as the start and end of the
     * {@link Interval} returned
     * </p>
     * 
     * @return
     */
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval() {
		return FnToInterval.fromBaseDateTimeFieldCollection();
	}
	
	/**
     * <p>
     * The two target elements accepted by this function are used as the start and end of the
     * {@link Interval} being created with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     * @return
     */
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromBaseDateTimeFieldCollection(dateTimeZone);
	}
	
	/**
     * <p>
     * The two target elements accepted by this function are used as the start and end of the
     * {@link Interval} being created with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     * @return
     */
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(Chronology chronology) {
		return FnToInterval.fromBaseDateTimeFieldCollection(chronology);
	}
	
	/**
     * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} returned
     * </p>
     * 
     * @return
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval() {
		return FnToInterval.fromBaseDateTimeFieldArray();
	}
	
	/**
     * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} being created (with the given {@link DateTimeZone})
     * </p>
     * 
     * @param dateTimeZone
     * @return
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return FnToInterval.fromBaseDateTimeFieldArray(dateTimeZone);
	}
	
	/**
     * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} being created (with the given {@link Chronology})
     * </p>
     * 
     * @param chronology
     * @return
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(Chronology chronology) {
		return FnToInterval.fromBaseDateTimeFieldArray(chronology);
	}
	
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalDate} using the given pattern parameter. If
     * the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                
     * @param pattern
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern) {
		return FnToLocalDate.fromString(pattern);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern parameter and with the given
     * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *               
     * @param pattern
     * @param dateTimeZone
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromString(pattern, dateTimeZone);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern parameter and with the given
     * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                  
     * @param pattern
     * @param chronology
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, chronology);
	}	
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale) {
		return FnToLocalDate.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale) {
		return FnToLocalDate.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} is created with the specified {@link DateTimeZone}
     * </p>
     *              
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} is created with the specified {@link DateTimeZone}
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} will be created with the given {@link Chronology}
     * </p>
     *                 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, locale, chronology);
	}
	/**
     * <p>
     * It converts the input {@link String} into a {@link LocalDate} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, Chronology chronology) {
		return FnToLocalDate.fromString(pattern, locale, chronology);
	}
	
	/**
     * <p>
     * The input {@link Date} is converted into a {@link LocalDate}
     * </p>
     */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate() {
		return FnToLocalDate.fromDate();
	}
	/**
     * <p>
     * The input {@link Date} is converted into a {@link LocalDate} configured with the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromDate(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Date} is converted into a {@link LocalDate} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromDate(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link LocalDate}
     * </p>
     */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate() {
		return FnToLocalDate.fromTimestamp();
	}
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link LocalDate} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromTimestamp(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link LocalDate} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromTimestamp(chronology);
	}
	
	
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate}
     * </p>
     */
	public static final Function<Long, LocalDate> longToLocalDate() {
		return FnToLocalDate.fromLong();
	}
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Long, LocalDate> longToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromLong(dateTimeZone);
	}
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Long, LocalDate> longToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromLong(chronology);
	}
	
	/**
     * <p>
     * A {@link LocalDate} is created from the given {@link Integer} {@link Collection}.
     * </p>
     * <p>
     * The valid input Collection<Integer> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     * 
     */
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate() {
		return FnToLocalDate.fromIntegerFieldCollection();
	}
	/**
     * <p>
     * A {@link LocalDate} is created from the given {@link Integer} {@link Collection}.
     * The output {@link LocalDate} will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromIntegerFieldCollection(chronology);
	}
	
	/**
     * <p>
     * A {@link LocalDate} is created from the given integer array.
     * </p>
     * 
     * <p>
     * The valid input Integer[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     */
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate() {
		return FnToLocalDate.fromIntegerFieldArray();
	}
	/**
     * <p>
     * A {@link LocalDate} is created from the given integer array.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Integer[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromIntegerFieldArray(chronology);
	}
	
	/**
     * <p>
     * A {@link LocalDate} is created from the given {@link String} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<String> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     */
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate() {
		return FnToLocalDate.fromStringFieldCollection();
	}
	/**
     * <p>
     * A {@link LocalDate} is created from the input {@link String} {@link Collection}.
     * The result will be created with the given {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Collection<String> are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromStringFieldCollection(chronology);
	}
	
	/**
     * <p>
     * A {@link LocalDate} is created from the given string array.
     * </p>
     * 
     * <p>
     * The valid input String[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     */
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate() {
		return FnToLocalDate.fromStringFieldArray();
	}
	/**
     * <p>
     * A {@link LocalDate} is created from the given string array.
     * The output {@link LocalDate} will be created with the specified {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input String[] are:
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul> 
     * </p>
     * 
     * @param chronology
     */
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromStringFieldArray(chronology);
	}
	
	
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalDate}
     * </p>
     */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate() {
		return FnToLocalDate.fromCalendar();
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalDate} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(DateTimeZone dateTimeZone) {
		return FnToLocalDate.fromCalendar(dateTimeZone);
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalDate} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(Chronology chronology) {
		return FnToLocalDate.fromCalendar(chronology);
	}
	
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter. If
     * the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern 
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern) {
		return FnToLocalTime.fromString(pattern);
	}	
	/**
     * <p>
     * It converts the given String into a {@link LocalTime} using the given pattern parameter and with the specified
     * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p> 
     *             
     * @param pattern
     * @param dateTimeZone
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromString(pattern, dateTimeZone);
	}	
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter with the specified
     * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern
     * @param chronology
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, chronology);
	}	
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale) {
		return FnToLocalTime.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
     * </p>
     * 
     * @param pattern
     * @param locale
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale) {
		return FnToLocalTime.fromString(pattern, locale);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} is configured with the given {@link DateTimeZone}
     * </p>
     *                
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} is configured with the given {@link DateTimeZone}
     * </p> 
     *                
     * @param pattern
     * @param locale
     * @param dateTimeZone
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromString(pattern, locale, dateTimeZone);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} will be created with the specified {@link Chronology}
     * </p>  
     *              
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, locale, chronology);
	}
	/**
     * <p>
     * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
     * The {@link DateTime} will be created with the specified {@link Chronology}
     * </p> 
     *                
     * @param pattern
     * @param locale
     * @param chronology
     */
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale, Chronology chronology) {
		return FnToLocalTime.fromString(pattern, locale, chronology);
	}

	/**
     * <p>
     * The given {@link Date} is converted into a {@link LocalTime}
     * </p>
     */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime() {
		return FnToLocalTime.fromDate();
	}
	/**
     * <p>
     * The given {@link Date} is converted into a {@link LocalTime} configured with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromDate(dateTimeZone);
	}
	/**
     * <p>
     * The given {@link Date} is converted into a {@link LocalTime} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromDate(chronology);
	}

	/**
     * <p>
     * The given {@link Timestamp} is converted into a {@link LocalTime}
     * </p>
     */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime() {
		return FnToLocalTime.fromTimestamp();
	}
	/**
     * <p>
     * The given {@link Timestamp} is converted into a {@link LocalTime} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromTimestamp(dateTimeZone);
	}
	/**
     * <p>
     * The given {@link Timestamp} is converted into a {@link LocalTime} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromTimestamp(chronology);
	}

	/**
     * <p>
     * The given long representing the time in milliseconds is converted into a {@link LocalTime}
     * </p>
     */
	public static final Function<Long, LocalTime> longToLocalTime() {
		return FnToLocalTime.fromLong();
	}
	/**
     * <p>
     * The given long representing the time in milliseconds is converted into a {@link LocalTime} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final Function<Long, LocalTime> longToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromLong(dateTimeZone);
	}
	/**
     * <p>
     * The given long representing the time in milliseconds is converted into a {@link LocalTime} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Long, LocalTime> longToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromLong(chronology);
	}

	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link Integer} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     */
	public static final Function<Collection<Integer>, LocalTime> integerFieldCollectionToLocalTime() {
		return FnToLocalTime.fromIntegerFieldCollection();
	}
	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link Integer} {@link Collection} with the specified
     * {@link Chronology}.
     * </p>
     * 
     * <p>
     * The valid input Collection<Integer> represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>       
     *  
     * @param chronology
     */
	public static final Function<Collection<Integer>, LocalTime> integerFieldCollectionToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromIntegerFieldCollection(chronology);
	}

	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link Integer} Array.
     * </p>
     * 
     * <p>
     * The valid input Integer[] represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     */
	public static final Function<Integer[], LocalTime> integerFieldArrayToLocalTime() {
		return FnToLocalTime.fromIntegerFieldArray();
	}
	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link Integer} array with the specified {@link Chronology}.
     * </p>
     * 
     * <p>
     * The valid input Integer[] represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *                 
     * @param chronology
     */
	public static final Function<Integer[], LocalTime> integerFieldArrayToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromIntegerFieldArray(chronology);
	}

	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link String} {@link Collection}.
     * </p>
     * 
     * <p>
     * The valid input Collection<String> represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     */
	public static final Function<Collection<String>, LocalTime> strFieldCollectionToLocalTime() {
		return FnToLocalTime.fromStringFieldCollection();
	}
	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link String} {@link Collection} with the specified
     * {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input Collection<String> represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     * 
     * @param chronology
     */
	public static final Function<Collection<String>, LocalTime> strFieldCollectionToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromStringFieldCollection(chronology);
	}

	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link String} array.
     * </p>
     * 
     * <p>
     * The valid input String[] represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     */
	public static final Function<String[], LocalTime> strFieldArrayToLocalTime() {
		return FnToLocalTime.fromStringFieldArray();
	}
	/**
     * <p>
     * A {@link LocalTime} is created from the given {@link String} array with the specified {@link Chronology}
     * </p>
     * 
     * <p>
     * The valid input String[] represent:
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * </p>
     *                 
     * @param chronology
     */
	public static final Function<String[], LocalTime> strFieldArrayToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromStringFieldArray(chronology);
	}

	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalTime}
     * </p>
     */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime() {
		return FnToLocalTime.fromCalendar();
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalTime} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone
     */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime(DateTimeZone dateTimeZone) {
		return FnToLocalTime.fromCalendar(dateTimeZone);
	}
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalTime} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology
     */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime(Chronology chronology) {
		return FnToLocalTime.fromCalendar(chronology);
	}

	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod() {
		return FnToPeriod.fromDateFieldCollection();
	}	
	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology 
     * 
     * @return 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromDateFieldCollection(chronology);
	}	
	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified {@link PeriodType}
     * </p>
     * 
     * @param periodType 
     * 
     * @return 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromDateFieldCollection(periodType);
	}
	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType
     * @param chronology 
     * 
     * @return 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromDateFieldCollection(periodType, chronology);
	}
	
	/**
     * <p>
     * The function returned receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod() {
		return FnToPeriod.fromDateFieldArray();
	}	
	
	/**
     * <p>
     * The function returned receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology 
     * 
     * @return 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromDateFieldArray(chronology);
	}	
	
	/**
     * <p>
     * The function returned receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType 
     * 
     * @return 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromDateFieldArray(periodType);
	}
	
	/**
     * <p>
     * The function returned receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType
     * @param chronology 
     * 
     * @return 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromDateFieldArray(periodType, chronology);
	}

	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod() {
		return FnToPeriod.fromTimestampFieldCollection();
	}	
	
	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology 
     * 
     * @return
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldCollection(chronology);
	}	
	
	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType
     * 
     * @return 
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromTimestampFieldCollection(periodType);
	}
	
	/**
     * <p>
     * The function returned receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType 
     * @param chronology
     * 
     * @return 
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldCollection(periodType, chronology);
	}
	/**
     * <p>
     * The function returned receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return 
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod() {
		return FnToPeriod.fromTimestampFieldArray();
	}	
	/**
     * <p>
     * The function returned receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology 
     * 
     * @return 
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldArray(chronology);
	}	
	/**
     * <p>
     * The function returned receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType 
     * 
     * @return 
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromTimestampFieldArray(periodType);
	}
	/**
     * <p>
     * The function returned receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType 
     * @param chronology
     * 
     * @return the {@link Period} created from the {@link Timestamp} target elements given as the start
     * and end of such {@link Period}
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromTimestampFieldArray(periodType, chronology);
	}

	/**
     * <p>
     * The function returned receives a Long representing the {@link Period} duration in milliseconds
     * and creates a {@link Period} with such duration
     * </p>
     * 
     * @return 
     */
	public static final Function<Long, Period> longToPeriod() {
		return FnToPeriod.fromLong();
	}
	/**
     * <p>
     * Creates a {@link Period} with the specified {@link Chronology} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
     * @param chronology 
     * 
     * @return 
     */
	public static final Function<Long, Period> longToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLong(chronology);
	}
	/**
     * <p>
     * Creates a {@link Period} with the specified {@link PeriodType} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
     * @param periodType 
     * 
     * @return 
     */
	public static final Function<Long, Period> longToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLong(periodType);
	}
	/**
     * <p>
     * Creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
     * @param periodType 
     * @param chronology 
     * 
     * @return 
     */
	public static final Function<Long, Period> longToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLong(periodType, chronology);
	}

	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod() {
		return FnToPeriod.fromLongFieldCollection();
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param chronology
     * 
     * @return 
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLongFieldCollection(chronology);
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType
     * 
     * @return 
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLongFieldCollection(periodType);
	}
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType
     * @param chronology
     * 
     * @return
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLongFieldCollection(periodType, chronology);
	}
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     *  
     * @return
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod() {
		return FnToPeriod.fromLongFieldArray();
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param chronology
     * 
     * @return 
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromLongFieldArray(chronology);
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType 
     * 
     * @return 
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromLongFieldArray(periodType);
	}
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType 
     * @param chronology 
     * 
     * @return 
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromLongFieldArray(periodType, chronology);
	}

	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants. The input received by the {@link Function}
     * must have size 2
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod() {
		return FnToPeriod.fromCalendarFieldCollection();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology
     * @return 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldCollection(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromCalendarFieldCollection(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @param chronology
     * @return 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldCollection(periodType, chronology);
	}
	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants 
     * </p>
     * 
     * @return
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod() {
		return FnToPeriod.fromCalendarFieldArray();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology
     * @return 
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldArray(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromCalendarFieldArray(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @param chronology
     * @return 
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromCalendarFieldArray(periodType, chronology);
	}

	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod() {
		return FnToPeriod.fromBaseDateTimeFieldCollection();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology
     * @return 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldCollection(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromBaseDateTimeFieldCollection(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @param chronology
     * @return 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldCollection(periodType, chronology);
	}
	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants
     * </p>
     * 
     * @return 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod() {
		return FnToPeriod.fromBaseDateTimeFieldArray();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology
     * @return 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldArray(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final PeriodType periodType) {
		return FnToPeriod.fromBaseDateTimeFieldArray(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType
     * @param chronology
     * @return 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnToPeriod.fromBaseDateTimeFieldArray(periodType, chronology);
	}
	
	/**
     * <p>
     * It creates a Period either:
     * <ul>   
     * <li>From a {@link Collection} of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<Integer>, Period> integerFieldCollectionToPeriod() {
		return FnToPeriod.fromIntegerFieldCollection();
	}
	/**
     * <p>
     * It creates a Period with the specified {@link PeriodType} either:
     * <ul>   
     * <li>From a {@link Collection} of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final Function<Collection<Integer>, Period> integerFieldCollectionToPeriod(PeriodType periodType) {
		return FnToPeriod.fromIntegerFieldCollection(periodType);
	}
	/**
     * <p>
     * It creates a Period either:
     * <ul>   
     * <li>From an Integer[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From an Integer[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @return 
     */
	public static final Function<Integer[], Period> integerFieldArrayToPeriod() {
		return FnToPeriod.fromIntegerFieldArray();
	}
	/**
     * <p>
     * It creates a Period with the specified {@link PeriodType} either:
     * <ul>   
     * <li>From an Integer[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From an Integer[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final Function<Integer[], Period> integerFieldArrayToPeriod(PeriodType periodType) {
		return FnToPeriod.fromIntegerFieldArray(periodType);
	}
	
	/**
     * <p>
     * A Period is created either:
     * <ul>   
     * <li>From a {@link Collection} of {@link String} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @return 
     */
	public static final Function<Collection<String>, Period> strFieldCollectionToPeriod() {
		return FnToPeriod.fromStringFieldCollection();
	}
	/**
     * <p>
     * A Period is created with the specified {@link PeriodType} either:
     * <ul>   
     * <li>From a {@link Collection} of {@link String} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final Function<Collection<String>, Period> strFieldCollectionToPeriod(PeriodType periodType) {
		return FnToPeriod.fromStringFieldCollection(periodType);
	}
	/**
     * <p>
     * A Period is created either:
     * <ul>   
     * <li>From a String[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a String[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @return 
     */
	public static final Function<String[], Period> strFieldArrayToPeriod() {
		return FnToPeriod.fromStringFieldArray();
	}
	/**
     * <p>
     * A Period is created with the specified {@link PeriodType} either:
     * <ul>   
     * <li>From a String[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a String[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * </p>
     * 
     * @param periodType
     * @return 
     */
	public static final Function<String[], Period> strFieldArrayToPeriod(PeriodType periodType) {
		return FnToPeriod.fromStringFieldArray(periodType);
	}
	
}
