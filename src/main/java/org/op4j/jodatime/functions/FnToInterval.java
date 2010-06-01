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
import org.joda.time.Interval;
import org.joda.time.base.BaseDateTime;
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
public final class FnToInterval {
	
    private FnToInterval() {
		super();
	}
	
	
	//From String list or array
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}
	 * </p>
	 * 
	 * <p>
	 * The accepted input Collection&lt;String&gt; are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 				
	 * @return the {@link Interval} created from the input
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection() {
		return FnInterval.strFieldCollectionToInterval();
	}

	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input CCollection&lt;String&gt; are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.strFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input Collection&lt;String&gt; are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(Chronology chronology) {
		return FnInterval.strFieldCollectionToInterval(chronology);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} using the target {@link String} elements as the start and end. The given pattern
	 * will be used to create the {@link DateTime} objects from the given {@link String} elements. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 * </p>
	 *                 
	 * @param pattern string with the format of the input String 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern) {
		return FnInterval.strFieldCollectionToInterval(pattern);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link DateTimeZone}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 * </p>
	 *                  
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, DateTimeZone dateTimeZone) {
		return FnInterval.strFieldCollectionToInterval(pattern, dateTimeZone);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link Chronology}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, Chronology chronology) {
		return FnInterval.strFieldCollectionToInterval(pattern, chronology);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, Locale locale) {
		return FnInterval.strFieldCollectionToInterval(pattern, locale);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, String locale) {
		return FnInterval.strFieldCollectionToInterval(pattern, locale);
	}	
	/**
	 * <p>
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the {@link Interval}.
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnInterval.strFieldCollectionToInterval(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the {@link Interval}.
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnInterval.strFieldCollectionToInterval(pattern, locale, dateTimeZone);
	}	
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the {@link Interval}.
	 * </p>
	 * 
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, Locale locale, Chronology chronology) {
		return FnInterval.strFieldCollectionToInterval(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the {@link Interval}.
	 * </p>
	 *
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<String>, Interval> fromStringFieldCollection(String pattern, String locale, Chronology chronology) {
		return FnInterval.strFieldCollectionToInterval(pattern, locale, chronology);
	}	
	
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 			
	 * @return the {@link Interval} created from the input
	 */
	public static final Function<String[], Interval> fromStringFieldArray() {
		return FnInterval.strFieldArrayToInterval();
	}
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 	
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.strFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(Chronology chronology) {
		return FnInterval.strFieldArrayToInterval(chronology);
	}
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 
	 * @param pattern string with the format of the input String 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern) {
		return FnInterval.strFieldArrayToInterval(pattern);
	}
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 	
	 * @param pattern string with the format of the input String 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, DateTimeZone dateTimeZone) {
		return FnInterval.strFieldArrayToInterval(pattern, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern string with the format of the input String 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, Chronology chronology) {
		return FnInterval.strFieldArrayToInterval(pattern, chronology);
	}
	/**
	 * <p>
	 * It converts the input {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}.
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, Locale locale) {
		return FnInterval.strFieldArrayToInterval(pattern, locale);
	}
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 	
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, String locale) {
		return FnInterval.strFieldArrayToInterval(pattern, locale);
	}	
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return FnInterval.strFieldArrayToInterval(pattern, locale, dateTimeZone);
	}
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, String locale, DateTimeZone dateTimeZone) {
		return FnInterval.strFieldArrayToInterval(pattern, locale, dateTimeZone);
	}	
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}. 
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 	
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, Locale locale, Chronology chronology) {
		return FnInterval.strFieldArrayToInterval(pattern, locale, chronology);
	}
	/**
	 * <p>
	 * It converts the given {@link String} elements into an {@link Interval}. 
	 * The target {@link String} elements represent the start and end of the {@link Interval}.
	 * </p>
	 * 
	 * <p>
	 * The accepted input String[] are:
	 * </p>
	 * <ul>
	 * <li>year, month, day, year, month, day</li>
	 * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
	 * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
	 * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
	 * </ul>
	 * 		
	 * @param pattern string with the format of the input String 
	 * @param locale {@link Locale} to be used 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<String[], Interval> fromStringFieldArray(String pattern, String locale, Chronology chronology) {
		return FnInterval.strFieldArrayToInterval(pattern, locale, chronology);
	}	
	//
	
	// From Date list or array
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Date} elements  
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final Function<Collection<? extends Date>, Interval> fromDateFieldCollection() {
		return FnInterval.dateFieldCollectionToInterval();
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Date}  elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<? extends Date>, Interval> fromDateFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.dateFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<? extends Date>, Interval> fromDateFieldCollection(Chronology chronology) {
		return FnInterval.dateFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final <T extends Date> Function<T[], Interval> fromDateFieldArray() {
		return FnInterval.dateFieldArrayToInterval();
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T[], Interval> fromDateFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.dateFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final <T extends Date> Function<T[], Interval> fromDateFieldArray(Chronology chronology) {
		return FnInterval.dateFieldArrayToInterval(chronology);
	}
	//
	
	// From Timestamp list or array
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input 
	 */
	public static final Function<Collection<Timestamp>, Interval> fromTimestampFieldCollection() {
		return FnInterval.timestampFieldCollectionToInterval();
	}
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */	
	public static final Function<Collection<Timestamp>, Interval> fromTimestampFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.timestampFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<Timestamp>, Interval> fromTimestampFieldCollection(Chronology chronology) {
		return FnInterval.timestampFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input 
	 */
	public static final Function<Timestamp[], Interval> fromTimestampFieldArray() {
		return FnInterval.timestampFieldArrayToInterval();
	}
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */	
	public static final Function<Timestamp[], Interval> fromTimestampFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.timestampFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Timestamp[], Interval> fromTimestampFieldArray(Chronology chronology) {
		return FnInterval.timestampFieldArrayToInterval(chronology);
	}
	//
	
	// From Long list or array
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input 
	 */
	public static final Function<Collection<Long>, Interval> fromLongFieldCollection() {
		return FnInterval.longFieldCollectionToInterval();
	}
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<Long>, Interval> fromLongFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.longFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<Long>, Interval> fromLongFieldCollection(Chronology chronology) {
		return FnInterval.longFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final Function<Long[], Interval> fromLongFieldArray() {
		return FnInterval.longFieldArrayToInterval();
	}
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link DateTimeZone}
	 * </p>
	 * 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Long[], Interval> fromLongFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.longFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The {@link Interval} will be created with the given
	 * {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Long[], Interval> fromLongFieldArray(Chronology chronology) {
		return FnInterval.longFieldArrayToInterval(chronology);
	}
	//
	
	
	// From Integer List or array
	/**
	 * <p>
     * It converts the input {@link Integer} elements into an {@link Interval}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}.
     * </p>
     * 
     * <p>The accepted input Collection&lt;Integer&gt; collections are:</p>
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     *       
     * @return the {@link Interval} created from the input 
     */
	public static final Function<Collection<Integer>, Interval> fromIntegerFieldCollection() {
		return FnInterval.integerFieldCollectionToInterval();
	}
	/**
	 * <p>
     * It converts the input {@link Integer} elements into an {@link Interval} with the given {@link DateTime}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Collection&lt;Integer&gt; are:</p>
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     *              
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final Function<Collection<Integer>, Interval> fromIntegerFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.integerFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
     * It converts the given {@link Integer} elements into an {@link Interval}.  with the given {@link Chronology}
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Collection&lt;Integer&gt; are:</p>
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     *       
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final Function<Collection<Integer>, Interval> fromIntegerFieldCollection(Chronology chronology) {
		return FnInterval.integerFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
     * It converts the given {@link Integer} elements into an {@link Interval}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Integer[] are:</p>
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     *         
     * @return the {@link Interval} created from the input 
     */
	public static final Function<Integer[], Interval> fromIntegerFieldArray() {
		return FnInterval.integerFieldArrayToInterval();
	}
	/**
	 * <p>
     * It converts the given {@link Integer} elements into an {@link Interval} with the given {@link DateTimeZone}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Integer[] are:</p>
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final Function<Integer[], Interval> fromIntegerFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.integerFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
     * It converts the given {@link Integer} elements into an {@link Interval} with the given {@link Chronology}. 
     * The target {@link Integer} elements represent the start and end of the {@link Interval}. 
     * </p>
     * 
     * <p>The accepted input Integer[] are:</p>
     * <ul>
     * <li>year, month, day, year, month, day</li>
     * <li>year, month, day, hour, minute, year, month, day, hour, minute</li>
     * <li>year, month, day, hour, minute, second, year, month, day, hour, minute, second</li>
     * <li>year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final Function<Integer[], Interval> fromIntegerFieldArray(Chronology chronology) {
		return FnInterval.integerFieldArrayToInterval(chronology);
	}
	//
	
	// From Calendar list or array
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets used as the start 
	 * and end of the {@link Interval}
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input  
	 */
	public static final Function<Collection<? extends Calendar>, Interval> fromCalendarFieldCollection() {
		return FnInterval.calendarFieldCollectionToInterval();
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets used as the start and end. 
	 * Such an {@link Interval} will be created in the given DateTimeZone
	 * </p>
	 *                 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<? extends Calendar>, Interval> fromCalendarFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.calendarFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets used as the start and end. 
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final Function<Collection<? extends Calendar>, Interval> fromCalendarFieldCollection(Chronology chronology) {
		return FnInterval.calendarFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets representing the start 
	 * and end of the {@link Interval}
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final <T extends Calendar> Function<T[], Interval> fromCalendarFieldArray() {
		return FnInterval.calendarFieldArrayToInterval();
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets representing the start and end. 
	 * Such an {@link Interval} will be created in the given DateTimeZone
	 * </p>
	 *                 
	 * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T[], Interval> fromCalendarFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.calendarFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets representing the start and end. 
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * @return the {@link Interval} created from the input and arguments 
	 */
	public static final <T extends Calendar> Function<T[], Interval> fromCalendarFieldArray(Chronology chronology) {
		return FnInterval.calendarFieldArrayToInterval(chronology);
	}
	//
	
	// From BaseDateTime list or array
	/**
	 * <p>
	 * The two target elements accepted by this function are used as the start and end of the
	 * {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input  
	 */
	public static final Function<Collection<? extends BaseDateTime>, Interval> fromBaseDateTimeFieldCollection() {
		return FnInterval.baseDateTimeFieldCollectionToInterval();
	}
	/**
	 * <p>
     * The two target elements accepted by this function are used as the start and end of the
     * {@link Interval} being created with the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Interval> fromBaseDateTimeFieldCollection(DateTimeZone dateTimeZone) {
		return FnInterval.baseDateTimeFieldCollectionToInterval(dateTimeZone);
	}
	/**
	 * <p>
     * The two target elements accepted by this function are used as the start and end of the
     * {@link Interval} being created with the given {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Interval> fromBaseDateTimeFieldCollection(Chronology chronology) {
		return FnInterval.baseDateTimeFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} returned
     * </p>
     * 
     * @return the {@link Interval} created from the input  
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> fromBaseDateTimeFieldArray() {
		return FnInterval.baseDateTimeFieldArrayToInterval();
	}
	/**
	 * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} being created (with the given {@link DateTimeZone})
     * </p>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> fromBaseDateTimeFieldArray(DateTimeZone dateTimeZone) {
		return FnInterval.baseDateTimeFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} being created (with the given {@link Chronology})
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Interval} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> fromBaseDateTimeFieldArray(Chronology chronology) {
		return FnInterval.baseDateTimeFieldArrayToInterval(chronology);
	}
	//
			
}
