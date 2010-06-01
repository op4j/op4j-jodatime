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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.op4j.functions.Function;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 * @deprecated use {@link FnLocalTime} instead
 */
@Deprecated
public final class FnToDateTime {
	
	private FnToDateTime() {
		super();
	}
		
	// From String
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the 
	 * given pattern parameter. If the pattern includes either, the name of 
	 * the month or day of week, a conversion accepting a {@link Locale} must 
	 * be used instead 
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern) {
		return FnDateTime.strToDateTime(pattern);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, DateTimeZone dateTimeZone) {
		return FnDateTime.strToDateTime(pattern, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 * 		                
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, Chronology chronology) {
		return FnDateTime.strToDateTime(pattern, chronology);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, Locale locale) {
		return FnDateTime.strToDateTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, String locale) {
		return FnDateTime.strToDateTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given String into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnDateTime.strToDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnDateTime.strToDateTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, Locale locale, Chronology chronology) {
		return FnDateTime.strToDateTime(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String, DateTime> fromString(String pattern, String locale, Chronology chronology) {
		return FnDateTime.strToDateTime(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final <T extends Date> Function<T, DateTime> fromDate() {
		return FnDateTime.dateToDateTime();
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateTime} configured with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, DateTime> fromDate(DateTimeZone dateTimeZone) {
		return FnDateTime.dateToDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, DateTime> fromDate(Chronology chronology) {
		return FnDateTime.dateToDateTime(chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Timestamp, DateTime> fromTimestamp() {
		return FnDateTime.timestampToDateTime();
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, DateTime> fromTimestamp(DateTimeZone dateTimeZone) {
		return FnDateTime.timestampToDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, DateTime> fromTimestamp(Chronology chronology) {
		return FnDateTime.timestampToDateTime(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Long, DateTime> fromLong() {
		return FnDateTime.longToDateTime();
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Long, DateTime> fromLong(DateTimeZone dateTimeZone) {
		return FnDateTime.longToDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Long, DateTime> fromLong(Chronology chronology) {
		return FnDateTime.longToDateTime(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * <p>
	 * A {@link DateTime} is created from the input {@link Integer} {@link Collection}.
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
	 * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Collection<Integer>, DateTime> fromIntegerFieldCollection() {
		return FnDateTime.integerFieldCollectionToDateTime();
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the input {@link Integer} {@link Collection}.
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
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Collection<Integer>, DateTime> fromIntegerFieldCollection(Chronology chronology) {
		return FnDateTime.integerFieldCollectionToDateTime(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link Integer} array.
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
     * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Integer[], DateTime> fromIntegerFieldArray() {
		return FnDateTime.integerFieldArrayToDateTime();
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link Integer} array.
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
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Integer[], DateTime> fromIntegerFieldArray(Chronology chronology) {
		return FnDateTime.integerFieldArrayToDateTime(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} {@link Collection}.
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
     * @return the {@link DateTime} created from the input 
	 */
	public static final Function<Collection<String>, DateTime> fromStringFieldCollection() {
		return FnDateTime.strFieldCollectionToDateTime();
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} {@link Collection}.
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
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<Collection<String>, DateTime> fromStringFieldCollection(Chronology chronology) {
		return FnDateTime.strFieldCollectionToDateTime(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} array.
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
     * @return the {@link DateTime} created from the input 
	 */
	public static final Function<String[], DateTime> fromStringFieldArray() {
		return FnDateTime.strFieldArrayToDateTime();
	}
	/**
	 * <p>
	 * A {@link DateTime} is created from the given {@link String} array.
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
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final Function<String[], DateTime> fromStringFieldArray(Chronology chronology) {
		return FnDateTime.strFieldArrayToDateTime(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateTime}
	 * </p>
	 * 
	 * @return the {@link DateTime} created from the input 
	 */
	public static final <T extends Calendar> Function<T, DateTime> fromCalendar() {
		return FnDateTime.calendarToDateTime();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateTime} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, DateTime> fromCalendar(DateTimeZone dateTimeZone) {
		return FnDateTime.calendarToDateTime(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, DateTime> fromCalendar(Chronology chronology) {
		return FnDateTime.calendarToDateTime(chronology);
	}
	//
	

}
