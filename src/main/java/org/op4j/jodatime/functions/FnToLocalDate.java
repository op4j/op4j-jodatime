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
import org.joda.time.LocalDate;
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
public final class FnToLocalDate {
		
	private FnToLocalDate() {
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
	public static final Function<String, LocalDate> fromString(String pattern) {
		return FnLocalDate.strToLocalDate(pattern);
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
	public static final Function<String, LocalDate> fromString(String pattern, DateTimeZone dateTimeZone) {
		return FnLocalDate.strToLocalDate(pattern, dateTimeZone);
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
	public static final Function<String, LocalDate> fromString(String pattern, Chronology chronology) {
		return FnLocalDate.strToLocalDate(pattern, chronology);
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
	public static final Function<String, LocalDate> fromString(String pattern, Locale locale) {
		return FnLocalDate.strToLocalDate(pattern, locale);
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
	public static final Function<String, LocalDate> fromString(String pattern, String locale) {
		return FnLocalDate.strToLocalDate(pattern, locale);
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
	public static final Function<String, LocalDate> fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnLocalDate.strToLocalDate(pattern, locale, dateTimeZone);
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
	public static final Function<String, LocalDate> fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnLocalDate.strToLocalDate(pattern, locale, dateTimeZone);
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
	public static final Function<String, LocalDate> fromString(String pattern, Locale locale, Chronology chronology) {
		return FnLocalDate.strToLocalDate(pattern, locale, chronology);
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
	public static final Function<String, LocalDate> fromString(String pattern, String locale, Chronology chronology) {
		return FnLocalDate.strToLocalDate(pattern, locale, chronology);
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
	public static final <T extends Date> Function<T, LocalDate> fromDate() {
		return FnLocalDate.dateToLocalDate();
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
	public static final <T extends Date> Function<T, LocalDate> fromDate(DateTimeZone dateTimeZone) {
		return FnLocalDate.dateToLocalDate(dateTimeZone);
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
	public static final <T extends Date> Function<T, LocalDate> fromDate(Chronology chronology) {
		return FnLocalDate.dateToLocalDate(chronology);
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
	public static final Function<Timestamp, LocalDate> fromTimestamp() {
		return FnLocalDate.timestampToLocalDate();
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
	public static final Function<Timestamp, LocalDate> fromTimestamp(DateTimeZone dateTimeZone) {
		return FnLocalDate.timestampToLocalDate(dateTimeZone);
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
	public static final Function<Timestamp, LocalDate> fromTimestamp(Chronology chronology) {
		return FnLocalDate.timestampToLocalDate(chronology);
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
	public static final Function<Long, LocalDate> fromLong() {
		return FnLocalDate.longToLocalDate();
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
	public static final Function<Long, LocalDate> fromLong(DateTimeZone dateTimeZone) {
		return FnLocalDate.longToLocalDate(dateTimeZone);
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
	public static final Function<Long, LocalDate> fromLong(Chronology chronology) {
		return FnLocalDate.longToLocalDate(chronology);
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
	public static final Function<Collection<Integer>, LocalDate> fromIntegerFieldCollection() {
		return FnLocalDate.integerFieldCollectionToLocalDate();
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
	public static final Function<Collection<Integer>, LocalDate> fromIntegerFieldCollection(Chronology chronology) {
		return FnLocalDate.integerFieldCollectionToLocalDate(chronology);
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
	public static final Function<Integer[], LocalDate> fromIntegerFieldArray() {
		return FnLocalDate.integerFieldArrayToLocalDate();
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
	public static final Function<Integer[], LocalDate> fromIntegerFieldArray(Chronology chronology) {
		return FnLocalDate.integerFieldArrayToLocalDate(chronology);
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
	public static final Function<Collection<String>, LocalDate> fromStringFieldCollection() {
		return FnLocalDate.strFieldCollectionToLocalDate();
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
	public static final Function<Collection<String>, LocalDate> fromStringFieldCollection(Chronology chronology) {
		return FnLocalDate.strFieldCollectionToLocalDate(chronology);
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
	public static final Function<String[], LocalDate> fromStringFieldArray() {
		return FnLocalDate.strFieldArrayToLocalDate();
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
	public static final Function<String[], LocalDate> fromStringFieldArray(Chronology chronology) {
		return FnLocalDate.strFieldArrayToLocalDate(chronology);
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
	public static final <T extends Calendar> Function<T, LocalDate> fromCalendar() {
		return FnLocalDate.calendarToLocalDate();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalDate} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, LocalDate> fromCalendar(DateTimeZone dateTimeZone) {
		return FnLocalDate.calendarToLocalDate(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalDate} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalDate} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, LocalDate> fromCalendar(Chronology chronology) {
		return FnLocalDate.calendarToLocalDate(chronology);
	}
	//
	
}
