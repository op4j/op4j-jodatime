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
import org.joda.time.LocalTime;
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
public final class FnToLocalTime {
	
	private FnToLocalTime() {
		super();
	}
		
	// From String
	
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern) {
		return FnLocalTime.strToLocalTime(pattern);
	}	
	/**
	 * <p>
	 * It converts the given String into a {@link LocalTime} using the given pattern parameter and with the specified
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p> 
	 *             
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, DateTimeZone dateTimeZone) {
		return FnLocalTime.strToLocalTime(pattern, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern parameter with the specified
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Chronology chronology) {
		return FnLocalTime.strToLocalTime(pattern, chronology);
	}	
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Locale locale) {
		return FnLocalTime.strToLocalTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, String locale) {
		return FnLocalTime.strToLocalTime(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * </p>
	 *                
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnLocalTime.strToLocalTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} is configured with the given {@link DateTimeZone}
	 * </p> 
	 *                
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnLocalTime.strToLocalTime(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the specified {@link Chronology}
	 * </p>  
	 *              
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, Locale locale, Chronology chronology) {
		return FnLocalTime.strToLocalTime(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the given {@link String} into a {@link LocalTime} using the given pattern and {@link Locale} parameters.
	 * The {@link DateTime} will be created with the specified {@link Chronology}
	 * </p> 
	 *                
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String, LocalTime> fromString(String pattern, String locale, Chronology chronology) {
		return FnLocalTime.strToLocalTime(pattern, locale, chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The given {@link Date} is converted into a {@link LocalTime}
	 * </p>
	 * 
	 * @return the {@link LocalTime} created from the input
	 */
	public static final <T extends Date> Function<T, LocalTime> fromDate() {
		return FnLocalTime.dateToLocalTime();
	}
	/**
	 * <p>
	 * The given {@link Date} is converted into a {@link LocalTime} configured with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, LocalTime> fromDate(DateTimeZone dateTimeZone) {
		return FnLocalTime.dateToLocalTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The given {@link Date} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, LocalTime> fromDate(Chronology chronology) {
		return FnLocalTime.dateToLocalTime(chronology);
	}
	//
	
	
	// From Date
	/**
	 * <p>
	 * The given {@link Timestamp} is converted into a {@link LocalTime}
	 * </p>
	 * 
	 * @return the {@link LocalTime} created from the input 
	 */
	public static final Function<Timestamp, LocalTime> fromTimestamp() {
		return FnLocalTime.timestampToLocalTime();
	}
	/**
	 * <p>
	 * The given {@link Timestamp} is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, LocalTime> fromTimestamp(DateTimeZone dateTimeZone) {
		return FnLocalTime.timestampToLocalTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The given {@link Timestamp} is converted into a {@link LocalTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Timestamp, LocalTime> fromTimestamp(Chronology chronology) {
		return FnLocalTime.timestampToLocalTime(chronology);
	}
	//
		
	
	// Conversion from Long
	/**
	 * <p>
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime}
	 * </p>
	 * 
	 * @return the {@link LocalTime} created from the input
	 */
	public static final Function<Long, LocalTime> fromLong() {
		return FnLocalTime.longToLocalTime();
	}
	/**
	 * <p>
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Long, LocalTime> fromLong(DateTimeZone dateTimeZone) {
		return FnLocalTime.longToLocalTime(dateTimeZone);
	}
	/**
	 * <p>
	 * The given long representing the time in milliseconds is converted into a {@link LocalTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Long, LocalTime> fromLong(Chronology chronology) {
		return FnLocalTime.longToLocalTime(chronology);
	}
	//
	
	// Conversion from Integer list
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link Integer} {@link Collection}.
	 * </p>
	 * 
	 * <p>
	 * The valid input Collection&lt;Integer&gt; represent:
	 * </p>
	 * <ul>
	 * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
	 * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
	 * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
	 * <li>hour, minute, second, millisecond</li>
	 * </ul>
	 * 
	 * @return the {@link LocalTime} created from the input
	 */
	public static final Function<Collection<Integer>, LocalTime> fromIntegerFieldCollection() {
		return FnLocalTime.integerFieldCollectionToLocalTime();
	}
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link Integer} {@link Collection} with the specified
	 * {@link Chronology}.
	 * </p>
	 * 
	 * <p>
	 * The valid input Collection&lt;Integer&gt; represent:
	 * </p>
	 * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
	 *  
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Collection<Integer>, LocalTime> fromIntegerFieldCollection(Chronology chronology) {
		return FnLocalTime.integerFieldCollectionToLocalTime(chronology);
	}
	//
	
	
	// Conversion from Integer array
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link Integer} Array.
	 * </p>
	 * 
	 * <p>
	 * The valid input Integer[] represent:
	 * </p>
	 * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the {@link LocalTime} created from the input
	 */
	public static final Function<Integer[], LocalTime> fromIntegerFieldArray() {
		return FnLocalTime.integerFieldArrayToLocalTime();
	}
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link Integer} array with the specified {@link Chronology}.
	 * </p>
	 * 
	 * <p>
	 * The valid input Integer[] represent:
	 * </p>
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     *                
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Integer[], LocalTime> fromIntegerFieldArray(Chronology chronology) {
		return FnLocalTime.integerFieldArrayToLocalTime(chronology);
	}
	//
	
	
	// Conversion from String list
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link String} {@link Collection}.
	 * </p>
	 * 
	 * <p>
	 * The valid input Collection&lt;String&gt; represent:
	 * </p>
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the {@link LocalTime} created from the input
	 */
	public static final Function<Collection<String>, LocalTime> fromStringFieldCollection() {
		return FnLocalTime.strFieldCollectionToLocalTime();
	}
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link String} {@link Collection} with the specified
	 * {@link Chronology}
	 * </p>
	 * 
	 * <p>
	 * The valid input Collection&lt;String&gt; represent:
	 * </p>
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<Collection<String>, LocalTime> fromStringFieldCollection(Chronology chronology) {
		return FnLocalTime.strFieldCollectionToLocalTime(chronology);
	}
	//
	
	
	// Conversion from String array
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link String} array.
	 * </p>
	 * 
	 * <p>
	 * The valid input String[] represent:
	 * </p>
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the {@link LocalTime} created from the input
	 */
	public static final Function<String[], LocalTime> fromStringFieldArray() {
		return FnLocalTime.strFieldArrayToLocalTime();
	}
	/**
	 * <p>
	 * A {@link LocalTime} is created from the given {@link String} array with the specified {@link Chronology}
	 * </p>
	 * 
	 * <p>
	 * The valid input String[] represent:
	 * </p>
     * <ul>
     * <li>hour (minute, second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute (second and millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second (millisecond will be set to 0 in the output {@link LocalTime})</li>
     * <li>hour, minute, second, millisecond</li>
     * </ul>
	 *                  
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final Function<String[], LocalTime> fromStringFieldArray(Chronology chronology) {
		return FnLocalTime.strFieldArrayToLocalTime(chronology);
	}
	//
	
	
	// Conversion from Calendar
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalTime}
	 * </p>
	 * 
	 * @return the {@link LocalTime} created from the input 
	 */
	public static final <T extends Calendar> Function<T, LocalTime> fromCalendar() {
		return FnLocalTime.calendarToLocalTime();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalTime} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, LocalTime> fromCalendar(DateTimeZone dateTimeZone) {
		return FnLocalTime.calendarToLocalTime(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link LocalTime} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link LocalTime} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, LocalTime> fromCalendar(Chronology chronology) {
		return FnLocalTime.calendarToLocalTime(chronology);
	}
	//

}
