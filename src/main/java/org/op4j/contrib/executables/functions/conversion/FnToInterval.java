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

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnToInterval {
	
	private static final DateFieldListToInterval DATE_FIELD_LIST_TO_INTERVAL = new DateFieldListToInterval();
	
	private static final TimestampFieldListToInterval TIMESTAMP_FIELD_LIST_TO_INTERVAL = new TimestampFieldListToInterval();
	private static final TimestampFieldArrayToInterval TIMESTAMP_FIELD_ARRAY_TO_INTERVAL = new TimestampFieldArrayToInterval();
	
	private static final LongFieldListToInterval LONG_FIELD_LIST_TO_INTERVAL = new LongFieldListToInterval();
	private static final LongFieldArrayToInterval LONG_FIELD_ARRAY_TO_INTERVAL = new LongFieldArrayToInterval();
	
	private static final IntegerFieldListToInterval INTEGER_FIELD_LIST_TO_INTERVAL = new IntegerFieldListToInterval();
	private static final IntegerFieldArrayToInterval INTEGER_FIELD_ARRAY_TO_INTERVAL = new IntegerFieldArrayToInterval();
	
	private static final CalendarFieldListToInterval CALENDAR_FIELD_LIST_TO_INTERVAL = new CalendarFieldListToInterval();
	
	private static final BaseDateTimeFieldListToInterval BASE_DATE_TIME_FIELD_LIST_TO_INTERVAL = new BaseDateTimeFieldListToInterval();
	
	private static final StringFieldListToInterval STRING_FIELD_LIST_TO_INTERVAL = new StringFieldListToInterval();
	private static final StringFieldArrayToInterval STRING_FIELD_ARRAY_TO_INTERVAL = new StringFieldArrayToInterval();
	
	private FnToInterval() {
		super();
	}
	
	
	//From String list or array
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
	public static final StringFieldListToInterval fromStringFieldList() {
		return STRING_FIELD_LIST_TO_INTERVAL;
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
	public static final StringFieldListToInterval fromStringFieldList(DateTimeZone dateTimeZone) {
		return new StringFieldListToInterval(dateTimeZone);
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
	public static final StringFieldListToInterval fromStringFieldList(Chronology chronology) {
		return new StringFieldListToInterval(chronology);
	}
	/**
	 * It creates an {@link Interval} using the target {@link String} elements as the start and end. The given pattern
	 * will be used to create the {@link DateTime} objects from the given {@link String} elements. If
	 * the pattern includes either, the name of the month or day of week, a conversion
	 * accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern) {
		return new StringFieldListToInterval(pattern);
	}
	/**
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link DateTimeZone}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 *                 
	 * @param pattern
	 * @param dateTimeZone
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, DateTimeZone dateTimeZone) {
		return new StringFieldListToInterval(pattern, dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given start and end {@link String} elements using the given pattern parameter
	 * and with the given {@link Chronology}. If the pattern includes either, the name of the month or
	 * day of week, a conversion accepting a {@link Locale} must be used instead
	 * 
	 * @param pattern
	 * @param chronology
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, Chronology chronology) {
		return new StringFieldListToInterval(pattern, chronology);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, Locale locale) {
		return new StringFieldListToInterval(pattern, locale);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters
	 * 
	 * @param pattern
	 * @param locale
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, String locale) {
		return new StringFieldListToInterval(pattern, locale);
	}	
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the interval.
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringFieldListToInterval(pattern, locale, dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link DateTimeZone} will be used to create the interval.
	 * 
	 * @param pattern
	 * @param locale
	 * @param dateTimeZone
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringFieldListToInterval(pattern, locale, dateTimeZone);
	}	
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the interval.
	 * 
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, Locale locale, Chronology chronology) {
		return new StringFieldListToInterval(pattern, locale, chronology);
	}
	/**
	 * It creates an {@link Interval} from the given {@link String} elements using the given pattern
	 * and {@link Locale} parameters. The given {@link Chronology} will be used to create the interval.
	 *
	 * @param pattern
	 * @param locale
	 * @param chronology
	 */
	public static final StringFieldListToInterval fromStringFieldList(String pattern, String locale, Chronology chronology) {
		return new StringFieldListToInterval(pattern, locale, chronology);
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
	public static final StringFieldArrayToInterval fromStringFieldArray() {
		return STRING_FIELD_ARRAY_TO_INTERVAL;
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
	public static final StringFieldArrayToInterval fromStringFieldArray(DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(dateTimeZone);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(Chronology chronology) {
		return new StringFieldArrayToInterval(chronology);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern) {
		return new StringFieldArrayToInterval(pattern);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(pattern, dateTimeZone);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, Chronology chronology) {
		return new StringFieldArrayToInterval(pattern, chronology);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, Locale locale) {
		return new StringFieldArrayToInterval(pattern, locale);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, String locale) {
		return new StringFieldArrayToInterval(pattern, locale);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, Locale locale, DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(pattern, locale, dateTimeZone);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, String locale, DateTimeZone dateTimeZone) {
		return new StringFieldArrayToInterval(pattern, locale, dateTimeZone);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, Locale locale, Chronology chronology) {
		return new StringFieldArrayToInterval(pattern, locale, chronology);
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
	public static final StringFieldArrayToInterval fromStringFieldArray(String pattern, String locale, Chronology chronology) {
		return new StringFieldArrayToInterval(pattern, locale, chronology);
	}	
	//
	
	// From Date list or array
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements  
	 */
	public static final DateFieldListToInterval fromDateFieldList() {
		return DATE_FIELD_LIST_TO_INTERVAL;
	}
	/**
	 * 
	 * It creates an {@link Interval} from the given {@link Date}  elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final DateFieldListToInterval fromDateFieldList(DateTimeZone dateTimeZone) {
		return new DateFieldListToInterval(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final DateFieldListToInterval fromDateFieldList(Chronology chronology) {
		return new DateFieldListToInterval(chronology);
	}
	
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 */
	public static final <T extends Date> DateFieldArrayToInterval<T> fromDateFieldArray() {
		return new DateFieldArrayToInterval<T>();
	}
	/**
	 * 
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final <T extends Date> DateFieldArrayToInterval<T> fromDateFieldArray(DateTimeZone dateTimeZone) {
		return new DateFieldArrayToInterval<T>(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} from the given {@link Date} elements.
	 * The {@link Interval} will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Date> DateFieldArrayToInterval<T> fromDateFieldArray(Chronology chronology) {
		return new DateFieldArrayToInterval<T>(chronology);
	}
	//
	
	// From Timestamp list or array
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 */
	public static final TimestampFieldListToInterval fromTimestampFieldList() {
		return TIMESTAMP_FIELD_LIST_TO_INTERVAL;
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */	
	public static final TimestampFieldListToInterval fromTimestampFieldList(DateTimeZone dateTimeZone) {
		return new TimestampFieldListToInterval(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final TimestampFieldListToInterval fromTimestampFieldList(Chronology chronology) {
		return new TimestampFieldListToInterval(chronology);
	}
	
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned
	 */
	public static final TimestampFieldArrayToInterval fromTimestampFieldArray() {
		return TIMESTAMP_FIELD_ARRAY_TO_INTERVAL;
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */	
	public static final TimestampFieldArrayToInterval fromTimestampFieldArray(DateTimeZone dateTimeZone) {
		return new TimestampFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * The given {@link Timestamp} target elements will be used as the start and end
	 * of the {@link Interval} returned with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final TimestampFieldArrayToInterval fromTimestampFieldArray(Chronology chronology) {
		return new TimestampFieldArrayToInterval(chronology);
	}
	//
	
	// From Long list or array
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 */
	public static final LongFieldListToInterval fromLongFieldList() {
		return LONG_FIELD_LIST_TO_INTERVAL;
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final LongFieldListToInterval fromLongFieldList(DateTimeZone dateTimeZone) {
		return new LongFieldListToInterval(dateTimeZone);
	}
	/**
	 * The given {@link Long} targets representing the time in millis will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final LongFieldListToInterval fromLongFieldList(Chronology chronology) {
		return new LongFieldListToInterval(chronology);
	}
	
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned
	 */
	public static final LongFieldArrayToInterval fromLongFieldArray() {
		return LONG_FIELD_ARRAY_TO_INTERVAL;
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link DateTimeZone}
	 * 
	 * @param dateTimeZone
	 */
	public static final LongFieldArrayToInterval fromLongFieldArray(DateTimeZone dateTimeZone) {
		return new LongFieldArrayToInterval(dateTimeZone);
	}
	/**
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end of the {@link Interval} returned. The interval will be created with the given
	 * {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final LongFieldArrayToInterval fromLongFieldArray(Chronology chronology) {
		return new LongFieldArrayToInterval(chronology);
	}
	//
	
	
	// From Integer List or array
	public static final IntegerFieldListToInterval fromIntegerFieldList() {
		return INTEGER_FIELD_LIST_TO_INTERVAL;
	}
	public static final IntegerFieldListToInterval fromIntegerFieldList(DateTimeZone dateTimeZone) {
		return new IntegerFieldListToInterval(dateTimeZone);
	}
	public static final IntegerFieldListToInterval fromIntegerFieldList(Chronology chronology) {
		return new IntegerFieldListToInterval(chronology);
	}
	
	public static final IntegerFieldArrayToInterval fromIntegerFieldArray() {
		return INTEGER_FIELD_ARRAY_TO_INTERVAL;
	}
	public static final IntegerFieldArrayToInterval fromIntegerFieldArray(DateTimeZone dateTimeZone) {
		return new IntegerFieldArrayToInterval(dateTimeZone);
	}
	public static final IntegerFieldArrayToInterval fromIntegerFieldArray(Chronology chronology) {
		return new IntegerFieldArrayToInterval(chronology);
	}
	//
	
	// From Calendar list or array
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start 
	 * and end of the interval
	 */
	public static final CalendarFieldListToInterval fromCalendarFieldList() {
		return CALENDAR_FIELD_LIST_TO_INTERVAL;
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * Such an interval will be created in the given DateTimeZone
	 *                 
	 * @param dateTimeZone
	 */
	public static final CalendarFieldListToInterval fromCalendarFieldList(DateTimeZone dateTimeZone) {
		return new CalendarFieldListToInterval(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * The interval will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final CalendarFieldListToInterval fromCalendarFieldList(Chronology chronology) {
		return new CalendarFieldListToInterval(chronology);
	}
	
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start 
	 * and end of the interval
	 */
	public static final <T extends Calendar> CalendarFieldArrayToInterval<T> fromCalendarFieldArray() {
		return new CalendarFieldArrayToInterval<T>();
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * Such an interval will be created in the given DateTimeZone
	 *                 
	 * @param dateTimeZone
	 */
	public static final <T extends Calendar> CalendarFieldArrayToInterval<T> fromCalendarFieldArray(DateTimeZone dateTimeZone) {
		return new CalendarFieldArrayToInterval<T>(dateTimeZone);
	}
	/**
	 * It creates an {@link Interval} with the given {@link Calendar} targets as the start and end. 
	 * The interval will be created with the given {@link Chronology}
	 * 
	 * @param chronology
	 */
	public static final <T extends Calendar> CalendarFieldArrayToInterval<T> fromCalendarFieldArray(Chronology chronology) {
		return new CalendarFieldArrayToInterval<T>(chronology);
	}
	//
	
	// From BaseDateTime list or array
	public static final BaseDateTimeFieldListToInterval fromBaseDateTimeFieldList() {
		return BASE_DATE_TIME_FIELD_LIST_TO_INTERVAL;
	}
	public static final BaseDateTimeFieldListToInterval fromBaseDateTimeFieldList(DateTimeZone dateTimeZone) {
		return new BaseDateTimeFieldListToInterval(dateTimeZone);
	}
	public static final BaseDateTimeFieldListToInterval fromBaseDateTimeFieldList(Chronology chronology) {
		return new BaseDateTimeFieldListToInterval(chronology);
	}
	
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToInterval<T> fromBaseDateTimeFieldArray() {
		return new BaseDateTimeFieldArrayToInterval<T>();
	}
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToInterval<T> fromBaseDateTimeFieldArray(DateTimeZone dateTimeZone) {
		return new BaseDateTimeFieldArrayToInterval<T>(dateTimeZone);
	}
	public static final <T extends BaseDateTime> BaseDateTimeFieldArrayToInterval<T> fromBaseDateTimeFieldArray(Chronology chronology) {
		return new BaseDateTimeFieldArrayToInterval<T>(chronology);
	}
	//
	
	
	
	private static abstract class BaseToInterval<T> extends AbstractNullAsNullFunction<T, Interval> {

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
	
	
	static final class StringFieldListToInterval extends BaseToInterval<List<String>> {

		private final ConversionType conversionType;
		private final String pattern;
		private final Locale locale;
		
		public StringFieldListToInterval() {
			super();
			this.conversionType = ConversionType.NO_PARAM;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);			
			this.conversionType = ConversionType.DATETIMEZONE;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldListToInterval(Chronology chronology) {
			super(chronology);		
			this.conversionType = ConversionType.CHRONOLOGY;
			this.pattern = null;
			this.locale = null;
		}
		
		public StringFieldListToInterval(String pattern) {
			super();	
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN;
			this.locale = null;
		}	
		
		public StringFieldListToInterval(String pattern, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN_DATETIMEZONE;
			this.locale = null;
		}	
		
		public StringFieldListToInterval(String pattern, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
			this.conversionType = ConversionType.PATTERN_CHRONOLOGY;
			this.locale = null;			
		}
		
		public StringFieldListToInterval(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE;
		}
		
		public StringFieldListToInterval(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE;
		}
		
		public StringFieldListToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE_DATETIMEZONE;
		}
		
		public StringFieldListToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
			super(dateTimeZone);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
			this.conversionType = ConversionType.PATTERN_LOCALE_DATETIMEZONE;
		}
		
		public StringFieldListToInterval(String pattern, Locale locale, Chronology chronology) {
			super(chronology);
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
						
			this.pattern = pattern;
			this.locale = locale;
			this.conversionType = ConversionType.PATTERN_LOCALE_CHRONOLOGY;
		}
		
		public StringFieldListToInterval(String pattern, String locale, Chronology chronology) {
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
		public Interval nullAsNullExecute(final List<String> object, ExecCtx ctx) throws Exception {
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
				
				int year1 = Integer.parseInt(object.get(0));
				int month1 = Integer.parseInt(object.get(1));
				int day1 = Integer.parseInt(object.get(2));
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
					year2 = Integer.parseInt(object.get(3));
					month2 = Integer.parseInt(object.get(4));
					day2 = Integer.parseInt(object.get(5));
				} else if (object.size() == 10) {
					hour1 = Integer.parseInt(object.get(3));
					minute1 = Integer.parseInt(object.get(4));
					year2 = Integer.parseInt(object.get(5));
					month2 = Integer.parseInt(object.get(6));
					day2 = Integer.parseInt(object.get(7));
					hour2 = Integer.parseInt(object.get(8));
					minute2 = Integer.parseInt(object.get(9));
				} else if (object.size() == 12) {
					hour1 = Integer.parseInt(object.get(3));
					minute1 = Integer.parseInt(object.get(4));
					second1 = Integer.parseInt(object.get(5));
					year2 = Integer.parseInt(object.get(6));
					month2 = Integer.parseInt(object.get(7));
					day2 = Integer.parseInt(object.get(8));
					hour2 = Integer.parseInt(object.get(9));
					minute2 = Integer.parseInt(object.get(10));
					second2 = Integer.parseInt(object.get(11));
				} else {
					hour1 = Integer.parseInt(object.get(3));
					minute1 = Integer.parseInt(object.get(4));
					second1 = Integer.parseInt(object.get(5));
					millisecond1 = Integer.parseInt(object.get(6));
					year2 = Integer.parseInt(object.get(7));
					month2 = Integer.parseInt(object.get(8));
					day2 = Integer.parseInt(object.get(9));
					hour2 = Integer.parseInt(object.get(10));
					minute2 = Integer.parseInt(object.get(11));
					second2 = Integer.parseInt(object.get(12));
					millisecond2 = Integer.parseInt(object.get(13));
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
				return new Interval(dateTimeFormatter.parseDateTime(object.get(0)).getMillis(), 
						dateTimeFormatter.parseDateTime(object.get(1)).getMillis(),
						this.chronology);	
			}
			if (this.dateTimeZone != null) {
				return new Interval(dateTimeFormatter.parseDateTime(object.get(0)).getMillis(), 
						dateTimeFormatter.parseDateTime(object.get(1)).getMillis(),
						this.dateTimeZone);	
			}
			return new Interval(dateTimeFormatter.parseDateTime(object.get(0)).getMillis(), 
					dateTimeFormatter.parseDateTime(object.get(1)).getMillis());	
									
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
	
	static final class DateFieldListToInterval extends BaseToInterval<List<? extends Date>> {

		/**
		 * It creates an {@link Interval} from the given {@link Date} elements  
		 */
		public DateFieldListToInterval() {
			super();			
		}		
		
		public DateFieldListToInterval(Chronology chronology) {
			super(chronology);					
		}
		
		public DateFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final List<? extends Date> object, ExecCtx ctx) throws Exception {			
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Date arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object.get(0).getTime(), object.get(1).getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object.get(0).getTime(), object.get(1).getTime(), this.chronology);
			}
			
			return new Interval(object.get(0).getTime(), object.get(1).getTime());
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
	
	static final class TimestampFieldListToInterval extends BaseToInterval<List<Timestamp>> {

		public TimestampFieldListToInterval() {
			super();			
		}		
		
		public TimestampFieldListToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public TimestampFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final List<Timestamp> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Timestamp arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object.get(0).getTime(), object.get(1).getTime(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object.get(0).getTime(), object.get(1).getTime(), this.chronology);
			}
			
			return new Interval(object.get(0).getTime(), object.get(1).getTime());
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
	
	static final class LongFieldListToInterval extends BaseToInterval<List<Long>> {

		public LongFieldListToInterval() {
			super();			
		}		
		
		public LongFieldListToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public LongFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final List<Long> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Long arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object.get(0).longValue(), object.get(1).longValue(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object.get(0).longValue(), object.get(1).longValue(), this.chronology);
			}
			
			return new Interval(object.get(0).longValue(), object.get(1).longValue());
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
	
	static final class IntegerFieldListToInterval extends BaseToInterval<List<Integer>> {

		public IntegerFieldListToInterval() {
			super();			
		}	
		
		public IntegerFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		public IntegerFieldListToInterval(Chronology chronology) {
			super(chronology);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final List<Integer> object, ExecCtx ctx) throws Exception {
			
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

			int year1 = object.get(0).intValue();
			int month1 = object.get(1).intValue();
			int day1 = object.get(2).intValue();
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
				year2 = object.get(3).intValue();
				month2 = object.get(4).intValue();
				day2 = object.get(5).intValue();
			} else if (object.size() == 10) {
				hour1 = object.get(3).intValue();
				minute1 = object.get(4).intValue();
				year2 = object.get(5).intValue();
				month2 = object.get(6).intValue();
				day2 = object.get(7).intValue();
				hour2 = object.get(8).intValue();
				minute2 = object.get(9).intValue();
			} else if (object.size() == 12) {
				hour1 = object.get(3).intValue();
				minute1 = object.get(4).intValue();
				second1 = object.get(5).intValue();
				year2 = object.get(6).intValue();
				month2 = object.get(7).intValue();
				day2 = object.get(8).intValue();
				hour2 = object.get(9).intValue();
				minute2 = object.get(10).intValue();
				second2 = object.get(11).intValue();
			} else {
				hour1 = object.get(3).intValue();
				minute1 = object.get(4).intValue();
				second1 = object.get(5).intValue();
				millisecond1 = object.get(6).intValue();
				year2 = object.get(7).intValue();
				month2 = object.get(8).intValue();
				day2 = object.get(9).intValue();
				hour2 = object.get(10).intValue();
				minute2 = object.get(11).intValue();
				second2 = object.get(12).intValue();
				millisecond2 = object.get(13).intValue();
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
	
	static final class CalendarFieldListToInterval extends BaseToInterval<List<? extends Calendar>> {

		public CalendarFieldListToInterval() {
			super();			
		}		
		
		public CalendarFieldListToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public CalendarFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final List<? extends Calendar> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"Calendar arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object.get(0).getTimeInMillis(), object.get(1).getTimeInMillis(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object.get(0).getTimeInMillis(), object.get(1).getTimeInMillis(), this.chronology);
			}
			
			return new Interval(object.get(0).getTimeInMillis(), object.get(1).getTimeInMillis());
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
		
	static final class BaseDateTimeFieldListToInterval extends BaseToInterval<List<? extends BaseDateTime>> {

		public BaseDateTimeFieldListToInterval() {
			super();			
		}		
		
		public BaseDateTimeFieldListToInterval(Chronology chronology) {
			super(chronology);
		}
		
		public BaseDateTimeFieldListToInterval(DateTimeZone dateTimeZone) {
			super(dateTimeZone);
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public Interval nullAsNullExecute(final List<? extends BaseDateTime> object, ExecCtx ctx) throws Exception {
			if (object.size() != 2 ) {
				throw new ExecutionException(
						"BaseDateTime arguments list for Interval conversion should have size 2. " +
						"Size " + object.size() + " is not valid.");
			}
			
			if (this.dateTimeZone != null) {
				return new Interval(object.get(0).getMillis(), object.get(1).getMillis(), this.dateTimeZone);
			}
			if (this.chronology != null) {
				return new Interval(object.get(0).getMillis(), object.get(1).getMillis(), this.chronology);
			}
			
			return new Interval(object.get(0).getMillis(), object.get(1).getMillis());
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
