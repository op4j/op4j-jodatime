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
public final class FnToDateMidnight {
	
	private FnToDateMidnight() {
		super();
	}
		
	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern parameter. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern) {
		return FnDateMidnight.strToDateMidnight(pattern);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
	 * {@link DateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, DateTimeZone dateTimeZone) {
		return FnDateMidnight.strToDateMidnight(pattern, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern parameter and with the given
	 * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 * 	                
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, Chronology chronology) {
		return FnDateMidnight.strToDateMidnight(pattern, chronology);
	}	
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, Locale locale) {
		return FnDateMidnight.strToDateMidnight(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and
	 * {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, String locale) {
		return FnDateMidnight.strToDateMidnight(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the input String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
	 * </p>
	 *               
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnDateMidnight.strToDateMidnight(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} is configured with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnDateMidnight.strToDateMidnight(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} will be created with the given {@link Chronology}
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, Locale locale, Chronology chronology) {
		return FnDateMidnight.strToDateMidnight(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the input String into a {@link DateMidnight} using the given pattern and {@link Locale} parameters.
	 * The {@link DateMidnight} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String, DateMidnight> fromString(String pattern, String locale, Chronology chronology) {
		return FnDateMidnight.strToDateMidnight(pattern, locale, chronology);
	}
	
	
	
	
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateMidnight}
	 * </p>
	 * 
	 * @return the {@link DateMidnight} created from the input
	 */
	public static final <T extends Date> Function<T, DateMidnight> fromDate() {
		return FnDateMidnight.dateToDateMidnight();
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateMidnight} configured with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, DateMidnight> fromDate(DateTimeZone dateTimeZone) {
		return FnDateMidnight.dateToDateMidnight(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Date} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T, DateMidnight> fromDate(Chronology chronology) {
		return FnDateMidnight.dateToDateMidnight(chronology);
	}
	
	
	
	
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateMidnight}
	 * </p>
	 * 
	 * @return the {@link DateMidnight} created from the input  
	 */
	public static final Function<Timestamp, DateMidnight> fromTimestamp() {
		return FnDateMidnight.timestampToDateMidnight();
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Timestamp, DateMidnight> fromTimestamp(DateTimeZone dateTimeZone) {
		return FnDateMidnight.timestampToDateMidnight(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Timestamp, DateMidnight> fromTimestamp(Chronology chronology) {
		return FnDateMidnight.timestampToDateMidnight(chronology);
	}
	
		
	
	
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateMidnight}
	 * </p>
	 * 
	 * @return the {@link DateMidnight} created from the input
	 */
	public static final Function<Long, DateMidnight> fromLong() {
		return FnDateMidnight.longToDateMidnight();
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateMidnight} in the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Long, DateMidnight> fromLong(DateTimeZone dateTimeZone) {
		return FnDateMidnight.longToDateMidnight(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} representing the time in milliseconds is converted into a {@link DateMidnight} with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Long, DateMidnight> fromLong(Chronology chronology) {
		return FnDateMidnight.longToDateMidnight(chronology);
	}
	
	
	
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the input {@link Integer} {@link Collection}.
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
	 * @return the {@link DateMidnight} created from the input 
	 */
	public static final Function<Collection<Integer>, DateMidnight> fromIntegerFieldCollection() {
		return FnDateMidnight.integerFieldCollectionToDateMidnight();
	}
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the input {@link Integer} {@link Collection}.
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
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Collection<Integer>, DateMidnight> fromIntegerFieldCollection(Chronology chronology) {
		return FnDateMidnight.integerFieldCollectionToDateMidnight(chronology);
	}
	
	
	
	
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the input {@link Integer} array.
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
     * @return the {@link DateMidnight} created from the input 
	 */
	public static final Function<Integer[], DateMidnight> fromIntegerFieldArray() {
		return FnDateMidnight.integerFieldArrayToDateMidnight();
	}
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the given {@link Integer} array.
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
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Integer[], DateMidnight> fromIntegerFieldArray(Chronology chronology) {
		return FnDateMidnight.integerFieldArrayToDateMidnight(chronology);
	}
	
	
	
	
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the input {@link String} {@link Collection}.
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
     * @return the {@link DateMidnight} created from the input  
	 */
	public static final Function<Collection<String>, DateMidnight> fromStringFieldCollection() {
		return FnDateMidnight.strFieldCollectionToDateMidnight();
	}
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the input {@link String} {@link Collection}.
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
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<Collection<String>, DateMidnight> fromStringFieldCollection(Chronology chronology) {
		return FnDateMidnight.strFieldCollectionToDateMidnight(chronology);
	}
	
	
	
	
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the given {@link String} array.
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
     * @return the {@link DateMidnight} created from the input  
	 */
	public static final Function<String[], DateMidnight> fromStringFieldArray() {
		return FnDateMidnight.strFieldArrayToDateMidnight();
	}
	/**
	 * <p>
	 * A {@link DateMidnight} is created from the input {@link String} array.
	 * The result will be created with the given {@link Chronology}
	 * </p>                
	 * 
	 * <p>
     * The valid input String[] are:
     * </p>
     * 
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final Function<String[], DateMidnight> fromStringFieldArray(Chronology chronology) {
		return FnDateMidnight.strFieldArrayToDateMidnight(chronology);
	}
	
	
	
	
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateMidnight}
	 * </p>
	 * 
	 * @return the {@link DateMidnight} created from the input
	 */
	public static final <T extends Calendar> Function<T, DateMidnight> fromCalendar() {
		return FnDateMidnight.calendarToDateMidnight();
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateMidnight} in the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, DateMidnight> fromCalendar(DateTimeZone dateTimeZone) {
		return FnDateMidnight.calendarToDateMidnight(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts a {@link Calendar} into a {@link DateMidnight} with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link DateMidnight} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T, DateMidnight> fromCalendar(Chronology chronology) {
		return FnDateMidnight.calendarToDateMidnight(chronology);
	}
	

}
