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

import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.FormatType;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.FromBaseDateTime;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.FromLocalDate;
import org.op4j.contrib.executables.functions.conversion.FnJodaToString.FromLocalTime;
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
		return new FromBaseDateTime(formatType, format);
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
		return new FromBaseDateTime(formatType, format, locale);
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
		return new FromBaseDateTime(formatType, format, chronology);
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
		return new FromBaseDateTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<BaseDateTime, String> baseDateTimeToStr(final DateTimeFormatter formatter) {
		return new FromBaseDateTime(formatter);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 *  
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 * @return
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return new FromLocalTime(formatType, format);
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
		return new FromLocalTime(formatType, format, locale);
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
		return new FromLocalTime(formatType, format, chronology);
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
		return new FromLocalTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<LocalTime, String> localTimeToStr(final DateTimeFormatter formatter) {
		return new FromLocalTime(formatter);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value)
	 * 
	 * @param formatType format {@link FormatType}
	 * @param format string with the format used to convert the target BaseDateTime
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
		return new FromLocalDate(formatType, format);
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
		return new FromLocalDate(formatType, format, locale);
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
		return new FromLocalDate(formatType, format, chronology);
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
		return new FromLocalDate(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final IFunction<LocalDate, String> localDateToStr(final DateTimeFormatter formatter) {
		return new FromLocalDate(formatter);
	}
	
}
