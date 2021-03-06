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
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.AbstractNullAsNullFunction;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.Function;

/**
 * 
 * @since 1.1
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 */
public final class FnInterval {
	
	private static final Function<Collection<? extends Date>, Interval> DATE_FIELD_COLLECTION_TO_INTERVAL = new DateFieldCollectionToInterval();
	
	private static final Function<Collection<Timestamp>, Interval> TIMESTAMP_FIELD_COLLECTION_TO_INTERVAL = new TimestampFieldCollectionToInterval();
	private static final Function<Timestamp[], Interval> TIMESTAMP_FIELD_ARRAY_TO_INTERVAL = new TimestampFieldArrayToInterval();
	
	private static final Function<Collection<Long>, Interval> LONG_FIELD_COLLECTION_TO_INTERVAL = new LongFieldCollectionToInterval();
	private static final Function<Long[], Interval> LONG_FIELD_ARRAY_TO_INTERVAL = new LongFieldArrayToInterval();
	
	private static final Function<Collection<Integer>, Interval> INTEGER_FIELD_COLLECTION_TO_INTERVAL = new IntegerFieldCollectionToInterval();
	private static final Function<Integer[], Interval> INTEGER_FIELD_ARRAY_TO_INTERVAL = new IntegerFieldArrayToInterval();
	
	private static final Function<Collection<? extends Calendar>, Interval> CALENDAR_FIELD_COLLECTION_TO_INTERVAL = new CalendarFieldCollectionToInterval();
	
	private static final Function<Collection<? extends BaseDateTime>, Interval> BASE_DATE_TIME_FIELD_COLLECTION_TO_INTERVAL = new BaseDateTimeFieldCollectionToInterval();
	
	private static final Function<Collection<String>, Interval> STRING_FIELD_COLLECTION_TO_INTERVAL = new StringFieldCollectionToInterval();
	private static final Function<String[], Interval> STRING_FIELD_ARRAY_TO_INTERVAL = new StringFieldArrayToInterval();
	
	private FnInterval() {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval() {
		return STRING_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new StringFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(Chronology chronology) {
		return new StringFieldCollectionToInterval(chronology);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern) {
		return new StringFieldCollectionToInterval(pattern);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, DateTimeZone dateTimeZone) {
		return new StringFieldCollectionToInterval(pattern, dateTimeZone);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Chronology chronology) {
		return new StringFieldCollectionToInterval(pattern, chronology);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale) {
		return new StringFieldCollectionToInterval(pattern, locale);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale) {
		return new StringFieldCollectionToInterval(pattern, locale);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringFieldCollectionToInterval(pattern, locale, dateTimeZone);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringFieldCollectionToInterval(pattern, locale, dateTimeZone);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, Chronology chronology) {
		return new StringFieldCollectionToInterval(pattern, locale, chronology);
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, Chronology chronology) {
		return new StringFieldCollectionToInterval(pattern, locale, chronology);
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
	public static final Function<String[], Interval> strFieldArrayToInterval() {
		return STRING_FIELD_ARRAY_TO_INTERVAL;
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
	public static final Function<String[], Interval> strFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(dateTimeZone);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(Chronology chronology) {
		return new StringFieldArrayToInterval(chronology);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern) {
		return new StringFieldArrayToInterval(pattern);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(pattern, dateTimeZone);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Chronology chronology) {
		return new StringFieldArrayToInterval(pattern, chronology);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale) {
		return new StringFieldArrayToInterval(pattern, locale);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale) {
		return new StringFieldArrayToInterval(pattern, locale);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(pattern, locale, dateTimeZone);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(pattern, locale, dateTimeZone);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale, Chronology chronology) {
		return new StringFieldArrayToInterval(pattern, locale, chronology);
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale, Chronology chronology) {
		return new StringFieldArrayToInterval(pattern, locale, chronology);
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
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval() {
		return DATE_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new DateFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(Chronology chronology) {
		return new DateFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval() {
		return new DateFieldArrayToInterval<T>();
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
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new DateFieldArrayToInterval<T>(dateTimeZone);
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
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(Chronology chronology) {
		return new DateFieldArrayToInterval<T>(chronology);
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
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval() {
		return TIMESTAMP_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new TimestampFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(Chronology chronology) {
		return new TimestampFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * The input {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input 
	 */
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval() {
		return TIMESTAMP_FIELD_ARRAY_TO_INTERVAL;
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
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new TimestampFieldArrayToInterval(dateTimeZone);
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
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(Chronology chronology) {
		return new TimestampFieldArrayToInterval(chronology);
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
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval() {
		return LONG_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new LongFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(Chronology chronology) {
		return new LongFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * The input {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final Function<Long[], Interval> longFieldArrayToInterval() {
		return LONG_FIELD_ARRAY_TO_INTERVAL;
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
	public static final Function<Long[], Interval> longFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new LongFieldArrayToInterval(dateTimeZone);
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
	public static final Function<Long[], Interval> longFieldArrayToInterval(Chronology chronology) {
		return new LongFieldArrayToInterval(chronology);
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
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval() {
		return INTEGER_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new IntegerFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(Chronology chronology) {
		return new IntegerFieldCollectionToInterval(chronology);
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
	public static final Function<Integer[], Interval> integerFieldArrayToInterval() {
		return INTEGER_FIELD_ARRAY_TO_INTERVAL;
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
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new IntegerFieldArrayToInterval(dateTimeZone);
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
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(Chronology chronology) {
		return new IntegerFieldArrayToInterval(chronology);
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
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval() {
		return CALENDAR_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new CalendarFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(Chronology chronology) {
		return new CalendarFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
	 * It creates an {@link Interval} from the input {@link Calendar} targets representing the start 
	 * and end of the {@link Interval}
	 * </p>
	 * 
	 * @return the {@link Interval} created from the input
	 */
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval() {
		return new CalendarFieldArrayToInterval<T>();
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
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new CalendarFieldArrayToInterval<T>(dateTimeZone);
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
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(Chronology chronology) {
		return new CalendarFieldArrayToInterval<T>(chronology);
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
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval() {
		return BASE_DATE_TIME_FIELD_COLLECTION_TO_INTERVAL;
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
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(DateTimeZone dateTimeZone) {
		return new BaseDateTimeFieldCollectionToInterval(dateTimeZone);
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
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(Chronology chronology) {
		return new BaseDateTimeFieldCollectionToInterval(chronology);
	}
	
	/**
	 * <p>
     * The array accepted by this function, as its input, contains two {@link BaseDateTime} objects used
     * as the start and end of the {@link Interval} returned
     * </p>
     * 
     * @return the {@link Interval} created from the input  
     */
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval() {
		return new BaseDateTimeFieldArrayToInterval<T>();
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
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(DateTimeZone dateTimeZone) {
		return new BaseDateTimeFieldArrayToInterval<T>(dateTimeZone);
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
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(Chronology chronology) {
		return new BaseDateTimeFieldArrayToInterval<T>(chronology);
	}
	//
	
	
	
	static abstract class BaseToInterval<T> extends AbstractNullAsNullFunction<T, Interval> {

		final Chronology chronology;
		final DateTimeZone dateTimeZone;
		
		public BaseToInterval() {
			super();
			this.chronology = null;
			this.dateTimeZone = null;
		}

		public BaseToInterval(Chronology chronology) {
			super();
			
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
			this.dateTimeZone = null;
		}

		public BaseToInterval(DateTimeZone dateTimeZone) {
			super();
			
			Validate.notNull(dateTimeZone, "dateTimeZone can't be null");
						
			this.chronology = null;
			this.dateTimeZone = dateTimeZone;			
		}
	}
	
	
	static final class StringFieldCollectionToInterval extends BaseToInterval<Collection<String>> {

		private final ConversionType conversionType;
		private final String pattern;
		private final Locale locale;
		
		public StringFieldCollectionToInterval() {
			super();
			this.conversionType = ConversionType.NO_PARAM;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);			
			this.conversionType = ConversionType.DATETIMEZONE;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldCollectionToInterval(Chronology chronology) {
			super(chronology);		
			this.conversionType = ConversionType.CHRONOLOGY;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldCollectionToInterval(String pattern) {
			super();	
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN;
			this.locale = null;
		}	
		
		public StringFieldCollectionToInterval(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN_DATETIMEZONE;
			this.locale = null;
		}	
		
		public StringFieldCollectionToInterval(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN_CHRONOLOGY;
			this.locale = null;			
		}
		
		public StringFieldCollectionToInterval(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE;
		}
		
		public StringFieldCollectionToInterval(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE;
		}
		
		public StringFieldCollectionToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE_DATETIMEZONE;
		}
		
		public StringFieldCollectionToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE_DATETIMEZONE;
		}
		
		public StringFieldCollectionToInterval(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
						
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE_CHRONOLOGY;
		}
		
		public StringFieldCollectionToInterval(String pattern, String locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE_CHRONOLOGY;
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<String> object, ExecCtx ctx) throws Exception {
			Iterator<String> iterator = object.iterator();
			
			if ((ConversionType.NO_PARAM.compareTo(this.conversionType) == 0)
					|| (ConversionType.CHRONOLOGY.compareTo(this.conversionType) == 0)
					|| (ConversionType.DATETIMEZONE.compareTo(this.conversionType) == 0)) {
				//Size 6 (year, month, day)
				//Size 10 (year, month, day, hour, minute)
				//Size 12 (year, month, day, hour, minute, second)
				//Size 14 (year, month, day, hour, minute, second, millisecond)
				if (object.size() != 6 
						&& object.size() != 10 
						&& object.size() != 12 
						&& object.size() != 14) {
					throw new ExecutionException(
							"String arguments list for Interval conversion should of sizes " +
							"2 (start and end of the interval), " +
							"6 (year, month, day, year, month, day), " +
							"10 (year, month, day, hour, minute, year, month, day, hour, minute), " +
							"12 (year, month, day, hour, minute, second, year, month, day, hour, minute, second), " +
							"14 (year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond)" +
							". Size " + object.size() + " is not valid.");
				}
				
				int year1 = Integer.parseInt(iterator.next());
				int month1 = Integer.parseInt(iterator.next());
				int day1 = Integer.parseInt(iterator.next());
				int hour1 = 0;
				int minute1 = 0;
				int second1 = 0;
				int millisecond1 = 0;
				int year2 = 0;
				int month2 = 0;
				int day2 = 0;
				int hour2 = 0;
				int minute2 = 0;
				int second2 = 0;
				int millisecond2 = 0;
				if (object.size() == 6) {
					year2 = Integer.parseInt(iterator.next());
					month2 = Integer.parseInt(iterator.next());
					day2 = Integer.parseInt(iterator.next());
				} else if (object.size() == 10) {
					hour1 = Integer.parseInt(iterator.next());
					minute1 = Integer.parseInt(iterator.next());
					year2 = Integer.parseInt(iterator.next());
					month2 = Integer.parseInt(iterator.next());
					day2 = Integer.parseInt(iterator.next());
					hour2 = Integer.parseInt(iterator.next());
					minute2 = Integer.parseInt(iterator.next());
				} else if (object.size() == 12) {
					hour1 = Integer.parseInt(iterator.next());
					minute1 = Integer.parseInt(iterator.next());
					second1 = Integer.parseInt(iterator.next());
					year2 = Integer.parseInt(iterator.next());
					month2 = Integer.parseInt(iterator.next());
					day2 = Integer.parseInt(iterator.next());
					hour2 = Integer.parseInt(iterator.next());
					minute2 = Integer.parseInt(iterator.next());
					second2 = Integer.parseInt(iterator.next());
				} else {
					hour1 = Integer.parseInt(iterator.next());
					minute1 = Integer.parseInt(iterator.next());
					second1 = Integer.parseInt(iterator.next());
					millisecond1 = Integer.parseInt(iterator.next());
					year2 = Integer.parseInt(iterator.next());
					month2 = Integer.parseInt(iterator.next());
					day2 = Integer.parseInt(iterator.next());
					hour2 = Integer.parseInt(iterator.next());
					minute2 = Integer.parseInt(iterator.next());
					second2 = Integer.parseInt(iterator.next());
					millisecond2 = Integer.parseInt(iterator.next());
				}
				
				switch (this.conversionType) {
					case NO_PARAM:
						return new Interval(
				    			new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1).getMillis(), 
				    			new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2).getMillis());
					case CHRONOLOGY:
						return new Interval(
								new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.chronology).getMillis(), 
				    			new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.chronology).getMillis(), 
			        			this.chronology);
					default:
						//DATETIMEZONE
						return new Interval(
								new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.dateTimeZone).getMillis(), 
				    			new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.dateTimeZone).getMillis(), 
			        			this.dateTimeZone);
				}
			} 
			

			if (object.size() != 2 ) {
				throw new ExecutionException(
						"String arguments list for Interval conversion should of sizes " +
						"2 (start and end of the interval), " +
						"6 (year, month, day, year, month, day), " +
						"10 (year, month, day, hour, minute, year, month, day, hour, minute), " +
						"12 (year, month, day, hour, minute, second, year, month, day, hour, minute, second), " +
						"14 (year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond)" +
						". Size " + object.size() + " is not valid.");
			}
			
			if (this.locale == null && StringUtils.contains(this.pattern, "MMM")) {
				throw new ExecutionException("The use of MMM, MMMM, EEE or EEEE as part of the date pattern "
						+ "requires a Locale");
			}

			DateTimeFormatter dateTimeFormatter = null;
			switch (this.conversionType) {
				case PATTERN:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern);  				
					break;
				case PATTERN_LOCALE:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withLocale(this.locale);
					break;	
				case PATTERN_CHRONOLOGY:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withChronology(this.chronology);
					break;	
				case PATTERN_DATETIMEZONE:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withZone(this.dateTimeZone);
					break;	
				case PATTERN_LOCALE_CHRONOLOGY:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern)
						.withLocale(this.locale).withChronology(this.chronology);
					break;	
				default:
					// PATTERN_LOCALE_DATETIMEZONE
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern)
						.withLocale(this.locale).withZone(this.dateTimeZone);
					break;		
			}
			if (this.chronology != null) {
				return new Interval(dateTimeFormatter.parseDateTime(iterator.next()).getMillis(), 
						dateTimeFormatter.parseDateTime(iterator.next()).getMillis(),
						this.chronology);	
			}
			if (this.dateTimeZone != null) {
				return new Interval(dateTimeFormatter.parseDateTime(iterator.next()).getMillis(), 
						dateTimeFormatter.parseDateTime(iterator.next()).getMillis(),
						this.dateTimeZone);	
			}
			return new Interval(dateTimeFormatter.parseDateTime(iterator.next()).getMillis(), 
					dateTimeFormatter.parseDateTime(iterator.next()).getMillis());	
									
		}
		
		private static enum ConversionType {
			NO_PARAM,
			CHRONOLOGY,
			DATETIMEZONE,
			PATTERN,
			PATTERN_LOCALE,
			PATTERN_CHRONOLOGY,
			PATTERN_DATETIMEZONE,
			PATTERN_LOCALE_CHRONOLOGY,
			PATTERN_LOCALE_DATETIMEZONE
		}		
	}	
	
	static final class StringFieldArrayToInterval extends BaseToInterval<String[]> {

		private final ConversionType conversionType;
		private final String pattern;
		private final Locale locale;
		
		public StringFieldArrayToInterval() {
			super();		
			this.conversionType = ConversionType.NO_PARAM;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldArrayToInterval(String pattern) {
			super();	
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN;
			this.locale = null;
		}	
		
		public StringFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);	
			this.conversionType = ConversionType.DATETIMEZONE;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldArrayToInterval(Chronology chronology) {
			super(chronology);	
			this.conversionType = ConversionType.CHRONOLOGY;
			this.pattern = null;
			this.locale = null;
		}
				
		public StringFieldArrayToInterval(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN_DATETIMEZONE;
			this.locale = null;
		}	
		
		public StringFieldArrayToInterval(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN_CHRONOLOGY;
			this.locale = null;
		}
		
		public StringFieldArrayToInterval(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE;
		}
		
		public StringFieldArrayToInterval(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE;
		}
		
		public StringFieldArrayToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE_DATETIMEZONE;
		}
		
		public StringFieldArrayToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE_DATETIMEZONE;
		}
		
		public StringFieldArrayToInterval(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE_CHRONOLOGY;
		}
		
		public StringFieldArrayToInterval(String pattern, String locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE_CHRONOLOGY;
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final String[] object, ExecCtx ctx) throws Exception {
			
			
			if ((ConversionType.NO_PARAM.compareTo(this.conversionType) == 0)
					|| (ConversionType.CHRONOLOGY.compareTo(this.conversionType) == 0)
					|| (ConversionType.DATETIMEZONE.compareTo(this.conversionType) == 0)) {
				//Size 6 (year, month, day)
				//Size 10 (year, month, day, hour, minute)
				//Size 12 (year, month, day, hour, minute, second)
				//Size 14 (year, month, day, hour, minute, second, millisecond)
				if (object.length != 6 
						&& object.length != 10 
						&& object.length != 12 
						&& object.length != 14) {
					throw new ExecutionException(
							"String arguments array for Interval conversion should of sizes " +
							"6 (year, month, day, year, month, day), " +
							"10 (year, month, day, hour, minute, year, month, day, hour, minute), " +
							"12 (year, month, day, hour, minute, second, year, month, day, hour, minute, second), " +
							"14 (year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond)" +
							". Size " + object.length + " is not valid.");
				}
				
				int year1 = Integer.parseInt(object[0]);
				int month1 = Integer.parseInt(object[1]);
				int day1 = Integer.parseInt(object[2]);
				int hour1 = 0;
				int minute1 = 0;
				int second1 = 0;
				int millisecond1 = 0;
				int year2 = 0;
				int month2 = 0;
				int day2 = 0;
				int hour2 = 0;
				int minute2 = 0;
				int second2 = 0;
				int millisecond2 = 0;
				if (object.length == 6) {
					year2 = Integer.parseInt(object[3]);
					month2 = Integer.parseInt(object[4]);
					day2 = Integer.parseInt(object[5]);
				} else if (object.length == 10) {
					hour1 = Integer.parseInt(object[3]);
					minute1 = Integer.parseInt(object[4]);
					year2 = Integer.parseInt(object[5]);
					month2 = Integer.parseInt(object[6]);
					day2 = Integer.parseInt(object[7]);
					hour2 = Integer.parseInt(object[8]);
					minute2 = Integer.parseInt(object[9]);
				} else if (object.length == 12) {
					hour1 = Integer.parseInt(object[3]);
					minute1 = Integer.parseInt(object[4]);
					second1 = Integer.parseInt(object[5]);
					year2 = Integer.parseInt(object[6]);
					month2 = Integer.parseInt(object[7]);
					day2 = Integer.parseInt(object[8]);
					hour2 = Integer.parseInt(object[9]);
					minute2 = Integer.parseInt(object[10]);
					second2 = Integer.parseInt(object[11]);
				} else {
					hour1 = Integer.parseInt(object[3]);
					minute1 = Integer.parseInt(object[4]);
					second1 = Integer.parseInt(object[5]);
					millisecond1 = Integer.parseInt(object[6]);
					year2 = Integer.parseInt(object[7]);
					month2 = Integer.parseInt(object[8]);
					day2 = Integer.parseInt(object[9]);
					hour2 = Integer.parseInt(object[10]);
					minute2 = Integer.parseInt(object[11]);
					second2 = Integer.parseInt(object[12]);
					millisecond2 = Integer.parseInt(object[13]);
				}
				
				switch (this.conversionType) {
					case NO_PARAM:
						return new Interval(
				    			new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1).getMillis(), 
				    			new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2).getMillis());
					case CHRONOLOGY:
						return new Interval(
								new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.chronology).getMillis(), 
				    			new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.chronology).getMillis(), 
			        			this.chronology);
					default:
						//DATETIMEZONE
						return new Interval(
								new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.dateTimeZone).getMillis(), 
				    			new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.dateTimeZone).getMillis(), 
			        			this.dateTimeZone);
				}
			} 
			
			if (object.length != 2 ) {
				throw new ExecutionException(
						"String arguments array for Interval conversion should of sizes " +
						"2 (start and end of the interval), " +
						"6 (year, month, day, year, month, day), " +
						"10 (year, month, day, hour, minute, year, month, day, hour, minute), " +
						"12 (year, month, day, hour, minute, second, year, month, day, hour, minute, second), " +
						"14 (year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond)" +
						". Size " + object.length + " is not valid.");
			}
			
			if (this.locale == null && StringUtils.contains(this.pattern, "MMM")) {
				throw new ExecutionException("The use of MMM, MMMM, EEE or EEEE as part of the date pattern "
						+ "requires a Locale");
			}

			DateTimeFormatter dateTimeFormatter = null;
			switch (this.conversionType) {
				case PATTERN:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern);  				
					break;
				case PATTERN_LOCALE:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withLocale(this.locale);
					break;	
				case PATTERN_CHRONOLOGY:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withChronology(this.chronology);
					break;	
				case PATTERN_DATETIMEZONE:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern).withZone(this.dateTimeZone);
					break;	
				case PATTERN_LOCALE_CHRONOLOGY:
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern)
					.withLocale(this.locale).withChronology(this.chronology);
					break;	
				default:
					// PATTERN_LOCALE_DATETIMEZONE
					dateTimeFormatter = DateTimeFormat.forPattern(this.pattern)
					.withLocale(this.locale).withZone(this.dateTimeZone);
					break;		
			}
			if (this.chronology != null) {
				return new Interval(dateTimeFormatter.parseDateTime(object[0]).getMillis(), 
						dateTimeFormatter.parseDateTime(object[1]).getMillis(),
						this.chronology);	
			}
			if (this.dateTimeZone != null) {
				return new Interval(dateTimeFormatter.parseDateTime(object[0]).getMillis(), 
						dateTimeFormatter.parseDateTime(object[1]).getMillis(),
						this.dateTimeZone);	
			}
			return new Interval(dateTimeFormatter.parseDateTime(object[0]).getMillis(), 
					dateTimeFormatter.parseDateTime(object[1]).getMillis());	
									
		}
		
		private static enum ConversionType {
			NO_PARAM,
			CHRONOLOGY,
			DATETIMEZONE,
			PATTERN,
			PATTERN_LOCALE,
			PATTERN_CHRONOLOGY,
			PATTERN_DATETIMEZONE,
			PATTERN_LOCALE_CHRONOLOGY,
			PATTERN_LOCALE_DATETIMEZONE
		}
	}	
	
	static final class DateFieldCollectionToInterval extends BaseToInterval<Collection<? extends Date>> {

		/**
		 * It creates an {@link Interval} from the given {@link Date} elements  
		 */
		public DateFieldCollectionToInterval() {
			super();			
		}		
		
		public DateFieldCollectionToInterval(Chronology chronology) {
			super(chronology);					
		}
		
		public DateFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<? extends Date> object, ExecCtx ctx) throws Exception {			
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Date arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			Iterator<? extends Date> iterator = object.iterator();
			
			if (this.dateTimeZone != null) {
				return new Interval(iterator.next().getTime(), iterator.next().getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(iterator.next().getTime(), iterator.next().getTime(), this.chronology);
			}
			
			return new Interval(iterator.next().getTime(), iterator.next().getTime());
		}		
	}	
	
	static final class DateFieldArrayToInterval<T extends Date> extends BaseToInterval<T[]> {

		public DateFieldArrayToInterval() {
			super();			
		}		
		
		public DateFieldArrayToInterval(Chronology chronology) {
			super(chronology);					
		}
		
		public DateFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final T[] object, ExecCtx ctx) throws Exception {
			if (object.length != 2 ) {
				throw new ExecutionException(
						"Date arguments array for Interval conversion should have size 2. " +
						"Size " + object.length + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object[0].getTime(), object[1].getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object[0].getTime(), object[1].getTime(), this.chronology);
			}
			
			return new Interval(object[0].getTime(), object[1].getTime());
		}		
	}	
	
	static final class TimestampFieldCollectionToInterval extends BaseToInterval<Collection<Timestamp>> {

		public TimestampFieldCollectionToInterval() {
			super();			
		}		
		
		public TimestampFieldCollectionToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public TimestampFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<Timestamp> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Timestamp arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			Iterator<Timestamp> iterator = object.iterator();
			
			if (this.dateTimeZone != null) {
				return new Interval(iterator.next().getTime(), iterator.next().getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(iterator.next().getTime(), iterator.next().getTime(), this.chronology);
			}
			
			return new Interval(iterator.next().getTime(), iterator.next().getTime());
		}		
	}	
	
	static final class TimestampFieldArrayToInterval extends BaseToInterval<Timestamp[]> {

		public TimestampFieldArrayToInterval() {
			super();			
		}		
		
		public TimestampFieldArrayToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public TimestampFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Timestamp[] object, ExecCtx ctx) throws Exception {
			if (object.length != 2 ) {
				throw new ExecutionException(
						"Timestamp arguments array for Interval conversion should have size 2. " +
						"Size " + object.length + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object[0].getTime(), object[1].getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object[0].getTime(), object[1].getTime(), this.chronology);
			}
			
			return new Interval(object[0].getTime(), object[1].getTime());
		}		
	}	
	
	static final class LongFieldCollectionToInterval extends BaseToInterval<Collection<Long>> {

		public LongFieldCollectionToInterval() {
			super();			
		}		
		
		public LongFieldCollectionToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public LongFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<Long> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Long arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			Iterator<Long> iterator = object.iterator();
			
			if (this.dateTimeZone != null) {
				return new Interval(iterator.next().longValue(), iterator.next().longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(iterator.next().longValue(), iterator.next().longValue(), this.chronology);
			}
			
			return new Interval(iterator.next().longValue(), iterator.next().longValue());
		}		
	}	
	
	static final class LongFieldArrayToInterval extends BaseToInterval<Long[]> {

		public LongFieldArrayToInterval() {
			super();			
		}		
		
		public LongFieldArrayToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public LongFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Long[] object, ExecCtx ctx) throws Exception {
			if (object.length != 2 ) {
				throw new ExecutionException(
						"Long arguments array for Interval conversion should have size 2. " +
						"Size " + object.length + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object[0].longValue(), object[1].longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object[0].longValue(), object[1].longValue(), this.chronology);
			}
			
			return new Interval(object[0].longValue(), object[1].longValue());
		}		
	}	
	
	static final class IntegerFieldCollectionToInterval extends BaseToInterval<Collection<Integer>> {

		public IntegerFieldCollectionToInterval() {
			super();			
		}	
		
		public IntegerFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		public IntegerFieldCollectionToInterval(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<Integer> object, ExecCtx ctx) throws Exception {
			
			//Size 6 (year, month, day)
			//Size 10 (year, month, day, hour, minute)
			//Size 12 (year, month, day, hour, minute, second)
			//Size 14 (year, month, day, hour, minute, second, millisecond)
			if (object.size() != 6 
					&& object.size() != 10 
					&& object.size() != 12 
					&& object.size() != 14) {
				throw new ExecutionException(
						"Integer arguments list for Interval conversion should of sizes " +
						"6 (year, month, day, year, month, day), " +
						"10 (year, month, day, hour, minute, year, month, day, hour, minute), " +
						"12 (year, month, day, hour, minute, second, year, month, day, hour, minute, second), " +
						"14 (year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond), " +
						". Size " + object.size() + " is not valid.");
			}

			Iterator<Integer> iterator = object.iterator();
			
			int year1 = iterator.next().intValue();
			int month1 = iterator.next().intValue();
			int day1 = iterator.next().intValue();
			int hour1 = 0;
			int minute1 = 0;
			int second1 = 0;
			int millisecond1 = 0;
			int year2 = 0;
			int month2 = 0;
			int day2 = 0;
			int hour2 = 0;
			int minute2 = 0;
			int second2 = 0;
			int millisecond2 = 0;
			if (object.size() == 6) {
				year2 = iterator.next().intValue();
				month2 = iterator.next().intValue();
				day2 = iterator.next().intValue();
			} else if (object.size() == 10) {
				hour1 = iterator.next().intValue();
				minute1 = iterator.next().intValue();
				year2 = iterator.next().intValue();
				month2 = iterator.next().intValue();
				day2 = iterator.next().intValue();
				hour2 = iterator.next().intValue();
				minute2 = iterator.next().intValue();
			} else if (object.size() == 12) {
				hour1 = iterator.next().intValue();
				minute1 = iterator.next().intValue();
				second1 = iterator.next().intValue();
				year2 = iterator.next().intValue();
				month2 = iterator.next().intValue();
				day2 = iterator.next().intValue();
				hour2 = iterator.next().intValue();
				minute2 = iterator.next().intValue();
				second2 = iterator.next().intValue();
			} else {
				hour1 = iterator.next().intValue();
				minute1 = iterator.next().intValue();
				second1 = iterator.next().intValue();
				millisecond1 = iterator.next().intValue();
				year2 = iterator.next().intValue();
				month2 = iterator.next().intValue();
				day2 = iterator.next().intValue();
				hour2 = iterator.next().intValue();
				minute2 = iterator.next().intValue();
				second2 = iterator.next().intValue();
				millisecond2 = iterator.next().intValue();
			}

			if (this.chronology != null) {
				return new Interval(
						new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.chronology).getMillis(), 
						new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.chronology).getMillis(), 
						this.chronology);
			}

			if (this.dateTimeZone != null) {
				return new Interval(
						new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.dateTimeZone).getMillis(), 
						new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.dateTimeZone).getMillis(), 
						this.dateTimeZone);
			}

			return new Interval(
					new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1).getMillis(), 
					new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2).getMillis());
		}		
	}	
	
	static final class IntegerFieldArrayToInterval extends BaseToInterval<Integer[]> {

		public IntegerFieldArrayToInterval() {
			super();			
		}	
		
		public IntegerFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		public IntegerFieldArrayToInterval(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Integer[] object, ExecCtx ctx) throws Exception {
			//length 6 (year, month, day)
			//length 10 (year, month, day, hour, minute)
			//length 12 (year, month, day, hour, minute, second)
			//length 14 (year, month, day, hour, minute, second, millisecond)
			if (object.length != 6 
					&& object.length != 10 
					&& object.length != 12 
					&& object.length != 14) {
				throw new ExecutionException(
						"Integer arguments array for Interval conversion should of lengths " +
						"6 (year, month, day, year, month, day), " +
						"10 (year, month, day, hour, minute, year, month, day, hour, minute), " +
						"12 (year, month, day, hour, minute, second, year, month, day, hour, minute, second), " +
						"14 (year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond)" +
						". Size " + object.length + " is not valid.");
			}

			int year1 = object[0].intValue();
			int month1 = object[1].intValue();
			int day1 = object[2].intValue();
			int hour1 = 0;
			int minute1 = 0;
			int second1 = 0;
			int millisecond1 = 0;
			int year2 = 0;
			int month2 = 0;
			int day2 = 0;
			int hour2 = 0;
			int minute2 = 0;
			int second2 = 0;
			int millisecond2 = 0;
			if (object.length == 6) {
				year2 = object[3].intValue();
				month2 = object[4].intValue();
				day2 = object[5].intValue();
			} else if (object.length == 10) {
				hour1 = object[3].intValue();
				minute1 = object[4].intValue();
				year2 = object[5].intValue();
				month2 = object[6].intValue();
				day2 = object[7].intValue();
				hour2 = object[8].intValue();
				minute2 = object[9].intValue();
			} else if (object.length == 12) {
				hour1 = object[3].intValue();
				minute1 = object[4].intValue();
				second1 = object[5].intValue();
				year2 = object[6].intValue();
				month2 = object[7].intValue();
				day2 = object[8].intValue();
				hour2 = object[9].intValue();
				minute2 = object[10].intValue();
				second2 = object[11].intValue();
			} else {
				hour1 = object[3].intValue();
				minute1 = object[4].intValue();
				second1 = object[5].intValue();
				millisecond1 = object[6].intValue();
				year2 = object[7].intValue();
				month2 = object[8].intValue();
				day2 = object[9].intValue();
				hour2 = object[10].intValue();
				minute2 = object[11].intValue();
				second2 = object[12].intValue();
				millisecond2 = object[13].intValue();
			}

			if (this.chronology != null) {
				return new Interval(
						new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.chronology).getMillis(), 
						new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.chronology).getMillis(), 
						this.chronology);
			}

			if (this.dateTimeZone != null) {
				return new Interval(
						new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1, this.dateTimeZone).getMillis(), 
						new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2, this.dateTimeZone).getMillis(), 
						this.dateTimeZone);
			}

			return new Interval(
					new DateTime(year1, month1, day1, hour1, minute1, second1, millisecond1).getMillis(), 
					new DateTime(year2, month2, day2, hour2, minute2, second2, millisecond2).getMillis());
		}		
	}	
	
	static final class CalendarFieldCollectionToInterval extends BaseToInterval<Collection<? extends Calendar>> {

		public CalendarFieldCollectionToInterval() {
			super();			
		}		
		
		public CalendarFieldCollectionToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public CalendarFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<? extends Calendar> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Calendar arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			Iterator<? extends Calendar> iterator = object.iterator();
			
			if (this.dateTimeZone != null) {
				return new Interval(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis(), this.chronology);
			}
			
			return new Interval(iterator.next().getTimeInMillis(), iterator.next().getTimeInMillis());
		}		
	}	
	
	static final class CalendarFieldArrayToInterval<T extends Calendar> extends BaseToInterval<T[]> {

		public CalendarFieldArrayToInterval() {
			super();			
		}		
		
		public CalendarFieldArrayToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public CalendarFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final T[] object, ExecCtx ctx) throws Exception {
			if (object.length != 2 ) {
				throw new ExecutionException(
						"Calendar arguments array for Interval conversion should have size 2. " +
						"Size " + object.length + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object[0].getTimeInMillis(), object[1].getTimeInMillis(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object[0].getTimeInMillis(), object[1].getTimeInMillis(), this.chronology);
			}
			
			return new Interval(object[0].getTimeInMillis(), object[1].getTimeInMillis());
		}		
	}	
		
	static final class BaseDateTimeFieldCollectionToInterval extends BaseToInterval<Collection<? extends BaseDateTime>> {

		public BaseDateTimeFieldCollectionToInterval() {
			super();			
		}		
		
		public BaseDateTimeFieldCollectionToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public BaseDateTimeFieldCollectionToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final Collection<? extends BaseDateTime> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"BaseDateTime arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			Iterator<? extends BaseDateTime> iterator = object.iterator();
			
			if (this.dateTimeZone != null) {
				return new Interval(iterator.next().getMillis(), iterator.next().getMillis(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(iterator.next().getMillis(), iterator.next().getMillis(), this.chronology);
			}
			
			return new Interval(iterator.next().getMillis(), iterator.next().getMillis());
		}		
	}	
	
	static final class BaseDateTimeFieldArrayToInterval<T extends BaseDateTime> extends BaseToInterval<T[]> {

		public BaseDateTimeFieldArrayToInterval() {
			super();			
		}		
		
		public BaseDateTimeFieldArrayToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public BaseDateTimeFieldArrayToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final T[] object, ExecCtx ctx) throws Exception {
			if (object.length != 2 ) {
				throw new ExecutionException(
						"BaseDateTime arguments array for Interval conversion should have size 2. " +
						"Size " + object.length + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object[0].getMillis(), object[1].getMillis(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object[0].getMillis(), object[1].getMillis(), this.chronology);
			}
			
			return new Interval(object[0].getMillis(), object[1].getMillis());
		}		
	}	
	
		
}
