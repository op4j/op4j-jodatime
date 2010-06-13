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
import org.joda.time.MutableDateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.functions.Function;
import org.op4j.jodatime.functions.FnJodaString.FormatType;


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
     * It converts the input {@link BaseDateTime} into a {@link String}  
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<BaseDateTime, String> baseDateTimeToStr() {
        return FnJodaString.baseDateTimeToStr();
    }
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @return the {@link String} created from the input and arguments
     * 
     * @since 1.1
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format) {
		return FnJodaString.baseDateTimeToStr(formatType, format);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @return
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<BaseDateTime, String> baseDateTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format) {
        return FnJodaString.baseDateTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format);
    }
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     *  
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param locale {@link Locale} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaString.baseDateTimeToStr(formatType, format, locale);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param locale
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<BaseDateTime, String> baseDateTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final Locale locale) {
        return FnJodaString.baseDateTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, locale);
    }
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaString.baseDateTimeToStr(formatType, format, chronology);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param chronology
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<BaseDateTime, String> baseDateTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final Chronology chronology) {
        return FnJodaString.baseDateTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, chronology);
    }
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     *       
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param locale {@link Locale} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaString.baseDateTimeToStr(formatType, format, locale);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param locale
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<BaseDateTime, String> baseDateTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final String locale) {
        return FnJodaString.baseDateTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, locale);
    }
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
     * </p>
     * 
     * @param formatter {@link DateTimeFormatter} to generate the output String with 
     * @return the {@link String} created from the input and arguments 
     */
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaString.baseDateTimeToStr(formatter);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String}
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<LocalTime, String> localTimeToStr() {
        return FnJodaString.localTimeToStr();
    }
    
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return FnJodaString.localTimeToStr(formatType, format);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalTime, String> localTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format) {
        return FnJodaString.localTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format);
    }
	
	
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param locale {@link Locale} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaString.localTimeToStr(formatType, format, locale);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param locale
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalTime, String> localTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final Locale locale) {
        return FnJodaString.localTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, locale);
    }
	
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaString.localTimeToStr(formatType, format, chronology);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param chronology
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalTime, String> localTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final Chronology chronology) {
        return FnJodaString.localTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, chronology);
    }
	
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given pattern or style
     * (depending on the value of formatType parameter).
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param locale {@link Locale} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaString.localTimeToStr(formatType, format, locale);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param locale
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalTime, String> localTimeToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final String locale) {
        return FnJodaString.localTimeToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, locale);
    }
	
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
     * </p>
     * 
     * @param formatter {@link DateTimeFormatter} to generate the output String with 
     * @return the {@link String} created from the input and arguments 
     */
	public static final Function<LocalTime, String> localTimeToStr(final DateTimeFormatter formatter) {
		return FnJodaString.localTimeToStr(formatter);
	}
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String}
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<LocalDate, String> localDateToStr() {
        return FnJodaString.localDateToStr();
    }
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value)
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
		return FnJodaString.localDateToStr(formatType, format);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalDate, String> localDateToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format) {
        return FnJodaString.localDateToStr(FnJodaString.FormatType.valueOf(formatType.name()), format);
    }
	
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value) with the given {@link Locale}
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param locale {@link Locale} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Locale locale) {
		return FnJodaString.localDateToStr(formatType, format, locale);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param locale
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalDate, String> localDateToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final Locale locale) {
        return FnJodaString.localDateToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, locale);
    }
	
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value) with the given {@link Chronology}
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link String} created from the input and arguments 
     * 
     * @since 1.1
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return FnJodaString.localDateToStr(formatType, format, chronology);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param chronology
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalDate, String> localDateToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final Chronology chronology) {
        return FnJodaString.localDateToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, chronology);
    }
	
	
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given pattern
     * or style (depending on the formatType value) with the given {@link Locale}
     * </p>
     * 
     * @param formatType the format {@link FormatType} 
     * @param format string with the format used for the output 
     * @param locale {@link Locale} to be used 
     * @return the {@link String} created from the input and arguments
     * 
     *  @since 1.1
     */
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final String locale) {
		return FnJodaString.localDateToStr(formatType, format, locale);
	}
	
	/**
	 * @param formatType
	 * @param format
	 * @param locale
	 * @return
	 * 
	 * @deprecated This method will be removed in version 1.2 
	 */
	@Deprecated
    public static final Function<LocalDate, String> localDateToStr(final org.op4j.jodatime.functions.FnJodaToString.FormatType formatType, final String format, final String locale) {
        return FnJodaString.localDateToStr(FnJodaString.FormatType.valueOf(formatType.name()), format, locale);
    }
	
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
     * </p>
     * 
     * @param formatter {@link DateTimeFormatter} to generate the output String with 
     * @return the {@link String} created from the input and arguments 
     */
	public static final Function<LocalDate, String> localDateToStr(final DateTimeFormatter formatter) {
		return FnJodaString.localDateToStr(formatter);
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Chronology chronology) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, DateMidnight> strToDateMidnight(String pattern, String locale, Chronology chronology) {
		return FnDateMidnight.strToDateMidnight(pattern, locale, chronology);
	}
	
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateMidnight}
     * </p>
     * 
     * @return the {@link DateMidnight} created from the input  
     */
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight() {
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
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight(DateTimeZone dateTimeZone) {
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
	public static final <T extends Date> Function<T, DateMidnight> dateToDateMidnight(Chronology chronology) {
		return FnDateMidnight.dateToDateMidnight(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateMidnight}
     * </p>
     * 
     * @return the {@link DateMidnight} created from the input  
     */
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight() {
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
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight(DateTimeZone dateTimeZone) {
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
	public static final Function<Timestamp, DateMidnight>  timestampToDateMidnight(Chronology chronology) {
		return FnDateMidnight.timestampToDateMidnight(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateMidnight}
     * </p>
     * 
     * @return the {@link DateMidnight} created from the input 
     */
	public static final Function<Long, DateMidnight>  longToDateMidnight() {
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
	public static final Function<Long, DateMidnight>  longToDateMidnight(DateTimeZone dateTimeZone) {
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
	public static final Function<Long, DateMidnight>  longToDateMidnight(Chronology chronology) {
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
	public static final Function<Collection<Integer>, DateMidnight>  integerFieldCollectionToDateMidnight() {
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
	public static final Function<Collection<Integer>, DateMidnight>  integerFieldCollectionToDateMidnight(Chronology chronology) {
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
	public static final Function<Integer[], DateMidnight>  integerFieldArrayToDateMidnight() {
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
	public static final Function<Integer[], DateMidnight>  integerFieldArrayToDateMidnight(Chronology chronology) {
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
	public static final Function<Collection<String>, DateMidnight>  strFieldCollectionToDateMidnight() {
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
	public static final Function<Collection<String>, DateMidnight>  strFieldCollectionToDateMidnight(Chronology chronology) {
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
	public static final Function<String[], DateMidnight>  strFieldArrayToDateMidnight() {
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
     * <ul>
     * <li>year (month and day will be set to 1)</li>
     * <li>year, month (day will be set to 1)</li>
     * <li>year, month, day</li>
     * </ul>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link DateMidnight} created from the input and arguments 
     */
	public static final Function<String[], DateMidnight>  strFieldArrayToDateMidnight(Chronology chronology) {
		return FnDateMidnight.strFieldArrayToDateMidnight(chronology);
	}
	
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateMidnight}
     * </p>
     * 
     * @return the {@link DateMidnight} created from the input 
     */
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight() {
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
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight(DateTimeZone dateTimeZone) {
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
	public static final <T extends Calendar> Function<T, DateMidnight> calendarToDateMidnight(Chronology chronology) {
		return FnDateMidnight.calendarToDateMidnight(chronology);
	}
	
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
	public static final Function<String, DateTime> strToDateTime(String pattern) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Chronology chronology) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, DateTime> strToDateTime(String pattern, String locale, Chronology chronology) {
		return FnDateTime.strToDateTime(pattern, locale, chronology);
	}
	
	/**
     * <p>
     * The input {@link Date} is converted into a {@link DateTime}
     * </p>
     * 
     * @return the {@link DateTime} created from the input  
     */
	public static final <T extends Date> Function<T, DateTime> dateToDateTime() {
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
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(DateTimeZone dateTimeZone) {
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
	public static final <T extends Date> Function<T, DateTime> dateToDateTime(Chronology chronology) {
		return FnDateTime.dateToDateTime(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link DateTime}
     * </p>
     * 
     * @return the {@link DateTime} created from the input
     */
	public static final Function<Timestamp, DateTime> timestampToDateTime() {
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
	public static final Function<Timestamp, DateTime> timestampToDateTime(DateTimeZone dateTimeZone) {
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
	public static final Function<Timestamp, DateTime> timestampToDateTime(Chronology chronology) {
		return FnDateTime.timestampToDateTime(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link DateTime}
     * </p>
     * 
     * @return the {@link DateTime} created from the input
     */
	public static final Function<Long, DateTime> longToDateTime() {
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
	public static final Function<Long, DateTime> longToDateTime(DateTimeZone dateTimeZone) {
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
	public static final Function<Long, DateTime> longToDateTime(Chronology chronology) {
		return FnDateTime.longToDateTime(chronology);
	}
	
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
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime() {
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
	public static final Function<Collection<Integer>, DateTime> integerFieldCollectionToDateTime(Chronology chronology) {
		return FnDateTime.integerFieldCollectionToDateTime(chronology);
	}
	
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
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime() {
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
	public static final Function<Integer[], DateTime> integerFieldArrayToDateTime(Chronology chronology) {
		return FnDateTime.integerFieldArrayToDateTime(chronology);
	}
	
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
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime() {
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
	public static final Function<Collection<String>, DateTime> strFieldCollectionToDateTime(Chronology chronology) {
		return FnDateTime.strFieldCollectionToDateTime(chronology);
	}
	
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
	public static final Function<String[], DateTime> strFieldArrayToDateTime() {
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
	public static final Function<String[], DateTime> strFieldArrayToDateTime(Chronology chronology) {
		return FnDateTime.strFieldArrayToDateTime(chronology);
	}
	
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link DateTime}
     * </p>
     * 
     * @return the {@link DateTime} created from the input
     */
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime() {
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
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(DateTimeZone dateTimeZone) {
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
	public static final <T extends Calendar> Function<T, DateTime> calendarToDateTime(Chronology chronology) {
		return FnDateTime.calendarToDateTime(chronology);
	}
	
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(Chronology chronology) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Chronology chronology) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<Collection<String>, Interval> strFieldCollectionToInterval(String pattern, String locale, Chronology chronology) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval() {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(Chronology chronology) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Chronology chronology) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String[], Interval> strFieldArrayToInterval(String pattern, String locale, Chronology chronology) {
		return FnInterval.strFieldArrayToInterval(pattern, locale, chronology);
	}	
	
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Date} elements  
     * </p>
     * 
     * @return the {@link Interval} created from the input 
     */
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval() {
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
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<? extends Date>, Interval> dateFieldCollectionToInterval(Chronology chronology) {
		return FnInterval.dateFieldCollectionToInterval(chronology);
	}
	
	/**
     * <p>
     * It creates an {@link Interval} from the given {@link Date} elements.
     * </p>
     * 
     * @return the {@link Interval} created from the input 
     */
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval() {
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
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final <T extends Date> Function<T[], Interval> dateFieldArrayToInterval(Chronology chronology) {
		return FnInterval.dateFieldArrayToInterval(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} target elements will be used as the start and end
     * of the {@link Interval} returned
     * </p>
     * 
     * @return the {@link Interval} created from the input 
     */
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval() {
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
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<Timestamp>, Interval> timestampFieldCollectionToInterval(Chronology chronology) {
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
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval() {
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
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Timestamp[], Interval> timestampFieldArrayToInterval(Chronology chronology) {
		return FnInterval.timestampFieldArrayToInterval(chronology);
	}
	
	/**
     * <p>
     * The input {@link Long} targets representing the time in milliseconds will be used as the start
     * and end of the {@link Interval} returned
     * </p>
     * 
     * @return the {@link Interval} created from the input
     */
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval() {
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
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<Long>, Interval> longFieldCollectionToInterval(Chronology chronology) {
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
	public static final Function<Long[], Interval> longFieldArrayToInterval() {
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
	public static final Function<Long[], Interval> longFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Long[], Interval> longFieldArrayToInterval(Chronology chronology) {
		return FnInterval.longFieldArrayToInterval(chronology);
	}
	
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
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<Integer>, Interval> integerFieldCollectionToInterval(Chronology chronology) {
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
	public static final Function<Integer[], Interval> integerFieldArrayToInterval() {
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
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Integer[], Interval> integerFieldArrayToInterval(Chronology chronology) {
		return FnInterval.integerFieldArrayToInterval(chronology);
	}
	
	/**
     * <p>
     * It creates an {@link Interval} from the input {@link Calendar} targets used as the start 
     * and end of the {@link Interval}
     * </p>
     * 
     * @return the {@link Interval} created from the input 
     */
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval() {
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
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<? extends Calendar>, Interval> calendarFieldCollectionToInterval(Chronology chronology) {
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
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval() {
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
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final <T extends Calendar> Function<T[], Interval> calendarFieldArrayToInterval(Chronology chronology) {
		return FnInterval.calendarFieldArrayToInterval(chronology);
	}

	/**
     * <p>
     * The two target elements accepted by this function are used as the start and end of the
     * {@link Interval} returned
     * </p>
     * 
     * @return the {@link Interval} created from the input
     */
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval() {
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
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(DateTimeZone dateTimeZone) {
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
	public static final Function<Collection<? extends BaseDateTime>, Interval> baseDateTimeFieldCollectionToInterval(Chronology chronology) {
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
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval() {
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
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(DateTimeZone dateTimeZone) {
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
	public static final <T extends BaseDateTime> Function<T[], Interval> baseDateTimeFieldArrayToInterval(Chronology chronology) {
		return FnInterval.baseDateTimeFieldArrayToInterval(chronology);
	}
	
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Chronology chronology) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, LocalDate> strToLocalDate(String pattern, String locale, Chronology chronology) {
		return FnLocalDate.strToLocalDate(pattern, locale, chronology);
	}
	
	/**
     * <p>
     * The input {@link Date} is converted into a {@link LocalDate}
     * </p>
     * 
     * @return the {@link LocalDate} created from the input
     */
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate() {
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
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(DateTimeZone dateTimeZone) {
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
	public static final <T extends Date> Function<T, LocalDate> dateToLocalDate(Chronology chronology) {
		return FnLocalDate.dateToLocalDate(chronology);
	}
	
	/**
     * <p>
     * The input {@link Timestamp} is converted into a {@link LocalDate}
     * </p>
     * 
     * @return the {@link LocalDate} created from the input 
     */
	public static final Function<Timestamp, LocalDate> timestampToLocalDate() {
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
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(DateTimeZone dateTimeZone) {
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
	public static final Function<Timestamp, LocalDate> timestampToLocalDate(Chronology chronology) {
		return FnLocalDate.timestampToLocalDate(chronology);
	}
	
	
	/**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link LocalDate}
     * </p>
     * 
     * @return the {@link LocalDate} created from the input
     */
	public static final Function<Long, LocalDate> longToLocalDate() {
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
	public static final Function<Long, LocalDate> longToLocalDate(DateTimeZone dateTimeZone) {
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
	public static final Function<Long, LocalDate> longToLocalDate(Chronology chronology) {
		return FnLocalDate.longToLocalDate(chronology);
	}
	
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
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate() {
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
	public static final Function<Collection<Integer>, LocalDate> integerFieldCollectionToLocalDate(Chronology chronology) {
		return FnLocalDate.integerFieldCollectionToLocalDate(chronology);
	}
	
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
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate() {
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
	public static final Function<Integer[], LocalDate> integerFieldArrayToLocalDate(Chronology chronology) {
		return FnLocalDate.integerFieldArrayToLocalDate(chronology);
	}
	
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
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate() {
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
	public static final Function<Collection<String>, LocalDate> strFieldCollectionToLocalDate(Chronology chronology) {
		return FnLocalDate.strFieldCollectionToLocalDate(chronology);
	}
	
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
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate() {
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
	public static final Function<String[], LocalDate> strFieldArrayToLocalDate(Chronology chronology) {
		return FnLocalDate.strFieldArrayToLocalDate(chronology);
	}
	
	
	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalDate}
     * </p>
     * 
     * @return the {@link LocalDate} created from the input
     */
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate() {
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
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(DateTimeZone dateTimeZone) {
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
	public static final <T extends Calendar> Function<T, LocalDate> calendarToLocalDate(Chronology chronology) {
		return FnLocalDate.calendarToLocalDate(chronology);
	}

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
	public static final Function<String, LocalTime> strToLocalTime(String pattern) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Chronology chronology) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale, DateTimeZone dateTimeZone) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, Locale locale, Chronology chronology) {
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
	public static final Function<String, LocalTime> strToLocalTime(String pattern, String locale, Chronology chronology) {
		return FnLocalTime.strToLocalTime(pattern, locale, chronology);
	}

	/**
     * <p>
     * The given {@link Date} is converted into a {@link LocalTime}
     * </p>
     * 
     * @return the {@link LocalTime} created from the input 
     */
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime() {
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
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime(DateTimeZone dateTimeZone) {
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
	public static final <T extends Date> Function<T, LocalTime> dateToLocalTime(Chronology chronology) {
		return FnLocalTime.dateToLocalTime(chronology);
	}

	/**
     * <p>
     * The given {@link Timestamp} is converted into a {@link LocalTime}
     * </p>
     * 
     * @return the {@link LocalTime} created from the input
     */
	public static final Function<Timestamp, LocalTime> timestampToLocalTime() {
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
	public static final Function<Timestamp, LocalTime> timestampToLocalTime(DateTimeZone dateTimeZone) {
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
	public static final Function<Timestamp, LocalTime> timestampToLocalTime(Chronology chronology) {
		return FnLocalTime.timestampToLocalTime(chronology);
	}

	/**
     * <p>
     * The given long representing the time in milliseconds is converted into a {@link LocalTime}
     * </p>
     * 
     * @return the {@link LocalTime} created from the input 
     */
	public static final Function<Long, LocalTime> longToLocalTime() {
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
	public static final Function<Long, LocalTime> longToLocalTime(DateTimeZone dateTimeZone) {
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
	public static final Function<Long, LocalTime> longToLocalTime(Chronology chronology) {
		return FnLocalTime.longToLocalTime(chronology);
	}

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
	public static final Function<Collection<Integer>, LocalTime> integerFieldCollectionToLocalTime() {
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
	public static final Function<Collection<Integer>, LocalTime> integerFieldCollectionToLocalTime(Chronology chronology) {
		return FnLocalTime.integerFieldCollectionToLocalTime(chronology);
	}

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
	public static final Function<Integer[], LocalTime> integerFieldArrayToLocalTime() {
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
	public static final Function<Integer[], LocalTime> integerFieldArrayToLocalTime(Chronology chronology) {
		return FnLocalTime.integerFieldArrayToLocalTime(chronology);
	}

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
	public static final Function<Collection<String>, LocalTime> strFieldCollectionToLocalTime() {
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
	public static final Function<Collection<String>, LocalTime> strFieldCollectionToLocalTime(Chronology chronology) {
		return FnLocalTime.strFieldCollectionToLocalTime(chronology);
	}

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
	public static final Function<String[], LocalTime> strFieldArrayToLocalTime() {
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
	public static final Function<String[], LocalTime> strFieldArrayToLocalTime(Chronology chronology) {
		return FnLocalTime.strFieldArrayToLocalTime(chronology);
	}

	/**
     * <p>
     * It converts a {@link Calendar} into a {@link LocalTime}
     * </p>
     * 
     * @return the {@link LocalTime} created from the input 
     */
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime() {
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
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime(DateTimeZone dateTimeZone) {
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
	public static final <T extends Calendar> Function<T, LocalTime> calendarToLocalTime(Chronology chronology) {
		return FnLocalTime.calendarToLocalTime(chronology);
	}

	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod() {
		return FnPeriod.dateFieldCollectionToPeriod();
	}	
	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final Chronology chronology) {
		return FnPeriod.dateFieldCollectionToPeriod(chronology);
	}	
	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final PeriodType periodType) {
		return FnPeriod.dateFieldCollectionToPeriod(periodType);
	}
	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Date>, Period> dateFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.dateFieldCollectionToPeriod(periodType, chronology);
	}
	
	/**
     * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod() {
		return FnPeriod.dateFieldArrayToPeriod();
	}	
	
	/**
     * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final Chronology chronology) {
		return FnPeriod.dateFieldArrayToPeriod(chronology);
	}	
	
	/**
     * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final PeriodType periodType) {
		return FnPeriod.dateFieldArrayToPeriod(periodType);
	}
	
	/**
     * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Date> Function<T[], Period> dateFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.dateFieldArrayToPeriod(periodType, chronology);
	}

	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod() {
		return FnPeriod.timestampFieldCollectionToPeriod();
	}	
	
	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final Chronology chronology) {
		return FnPeriod.timestampFieldCollectionToPeriod(chronology);
	}	
	
	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final PeriodType periodType) {
		return FnPeriod.timestampFieldCollectionToPeriod(periodType);
	}
	
	/**
     * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Timestamp>, Period> timestampFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.timestampFieldCollectionToPeriod(periodType, chronology);
	}
	/**
     * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod() {
		return FnPeriod.timestampFieldArrayToPeriod();
	}	
	/**
     * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final Chronology chronology) {
		return FnPeriod.timestampFieldArrayToPeriod(chronology);
	}	
	/**
     * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final PeriodType periodType) {
		return FnPeriod.timestampFieldArrayToPeriod(periodType);
	}
	/**
     * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Timestamp[], Period> timestampFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.timestampFieldArrayToPeriod(periodType, chronology);
	}

	/**
     * <p>
     * The function receives a Long representing the {@link Period} duration in milliseconds
     * and creates a {@link Period} with such duration
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Long, Period> longToPeriod() {
		return FnPeriod.longToPeriod();
	}
	/**
     * <p>
     * Creates a {@link Period} with the specified {@link Chronology} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Long, Period> longToPeriod(final Chronology chronology) {
		return FnPeriod.longToPeriod(chronology);
	}
	/**
     * <p>
     * Creates a {@link Period} with the specified {@link PeriodType} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Long, Period> longToPeriod(final PeriodType periodType) {
		return FnPeriod.longToPeriod(periodType);
	}
	/**
     * <p>
     * Creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Long, Period> longToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.longToPeriod(periodType, chronology);
	}

	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod() {
		return FnPeriod.longFieldCollectionToPeriod();
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final Chronology chronology) {
		return FnPeriod.longFieldCollectionToPeriod(chronology);
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final PeriodType periodType) {
		return FnPeriod.longFieldCollectionToPeriod(periodType);
	}
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Long>, Period> longFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.longFieldCollectionToPeriod(periodType, chronology);
	}
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     *  
     * @return the {@link Period} created from the input
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod() {
		return FnPeriod.longFieldArrayToPeriod();
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final Chronology chronology) {
		return FnPeriod.longFieldArrayToPeriod(chronology);
	}	
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final PeriodType periodType) {
		return FnPeriod.longFieldArrayToPeriod(periodType);
	}
	/**
     * <p>
     * The given {@link Long} targets representing the time in milliseconds will be used as the start
     * and end instants of the {@link Period} returned 
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Long[], Period> longFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.longFieldArrayToPeriod(periodType, chronology);
	}

	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants. The input received by the {@link Function}
     * must have size 2
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod() {
		return FnPeriod.calendarFieldCollectionToPeriod();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final Chronology chronology) {
		return FnPeriod.calendarFieldCollectionToPeriod(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final PeriodType periodType) {
		return FnPeriod.calendarFieldCollectionToPeriod(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Calendar>, Period> calendarFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.calendarFieldCollectionToPeriod(periodType, chronology);
	}
	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants 
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod() {
		return FnPeriod.calendarFieldArrayToPeriod();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final Chronology chronology) {
		return FnPeriod.calendarFieldArrayToPeriod(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final PeriodType periodType) {
		return FnPeriod.calendarFieldArrayToPeriod(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Calendar> Function<T[], Period> calendarFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.calendarFieldArrayToPeriod(periodType, chronology);
	}

	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod() {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final PeriodType periodType) {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> baseDateTimeFieldCollectionToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod(periodType, chronology);
	}
	/**
     * <p>
     * It creates a {@link Period} represented by the given start and end instants
     * </p>
     * 
     * @return the {@link Period} created from the input 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod() {
		return FnPeriod.baseDateTimeFieldArrayToPeriod();
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldArrayToPeriod(chronology);
	}	
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final PeriodType periodType) {
		return FnPeriod.baseDateTimeFieldArrayToPeriod(periodType);
	}
	/**
     * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> baseDateTimeFieldArrayToPeriod(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldArrayToPeriod(periodType, chronology);
	}
	
	/**
     * <p>
     * It creates a Period either:
     * </p>
     * <ul>   
     * <li>From a {@link Collection} of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @return the {@link Period} created from the input 
     */
	public static final Function<Collection<Integer>, Period> integerFieldCollectionToPeriod() {
		return FnPeriod.integerFieldCollectionToPeriod();
	}
	/**
     * <p>
     * It creates a Period with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From a {@link Collection} of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Integer>, Period> integerFieldCollectionToPeriod(PeriodType periodType) {
		return FnPeriod.integerFieldCollectionToPeriod(periodType);
	}
	/**
     * <p>
     * It creates a Period either:
     * </p>
     * <ul>   
     * <li>From an Integer[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From an Integer[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Integer[], Period> integerFieldArrayToPeriod() {
		return FnPeriod.integerFieldArrayToPeriod();
	}
	/**
     * <p>
     * It creates a Period with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From an Integer[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From an Integer[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Integer[], Period> integerFieldArrayToPeriod(PeriodType periodType) {
		return FnPeriod.integerFieldArrayToPeriod(periodType);
	}
	
	/**
     * <p>
     * A Period is created either:
     * </p>
     * <ul>   
     * <li>From a {@link Collection} of {@link String} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<String>, Period> strFieldCollectionToPeriod() {
		return FnPeriod.strFieldCollectionToPeriod();
	}
	/**
     * <p>
     * A Period is created with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From a {@link Collection} of {@link String} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<String>, Period> strFieldCollectionToPeriod(PeriodType periodType) {
		return FnPeriod.strFieldCollectionToPeriod(periodType);
	}
	/**
     * <p>
     * A Period is created either:
     * </p>
     * <ul>   
     * <li>From a String[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a String[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @return the {@link Period} created from the input 
     */
	public static final Function<String[], Period> strFieldArrayToPeriod() {
		return FnPeriod.strFieldArrayToPeriod();
	}
	/**
     * <p>
     * A Period is created with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From a String[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a String[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<String[], Period> strFieldArrayToPeriod(PeriodType periodType) {
		return FnPeriod.strFieldArrayToPeriod(periodType);
	}
	
	// From String
    /**
     * <p>
     * It converts the input {@link String} into a {@link MutableDateTime} using the 
     * given pattern parameter. If the pattern includes either, the name of 
     * the month or day of week, a conversion accepting a {@link Locale} must 
     * be used instead 
     * </p>
     * 
     * @param pattern string with the format of the input String 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern) {
        return FnMutableDateTime.strToMutableDateTime(pattern);
    }   
    /**
     * <p>
     * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern parameter and with the given
     * {@link MutableDateTimeZone}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                 
     * @param pattern string with the format of the input String 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, DateTimeZone dateTimeZone) {
        return FnMutableDateTime.strToMutableDateTime(pattern, dateTimeZone);
    }   
    /**
     * <p>
     * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern parameter and with the given
     * {@link Chronology}. If the pattern includes either, the name of the month or day of week, a conversion
     * accepting a {@link Locale} must be used instead
     * </p>
     *                      
     * @param pattern string with the format of the input String 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Chronology chronology) {
        return FnMutableDateTime.strToMutableDateTime(pattern, chronology);
    }   
    /**
     * <p>
     * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern string with the format of the input String 
     * @param locale {@link Locale} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Locale locale) {
        return FnMutableDateTime.strToMutableDateTime(pattern, locale);
    }
    /**
     * <p>
     * It converts the given {@link String} into a {@link MutableDateTime} using the given pattern and
     * {@link Locale} parameters
     * </p>
     * 
     * @param pattern string with the format of the input String 
     * @param locale {@link Locale} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, String locale) {
        return FnMutableDateTime.strToMutableDateTime(pattern, locale);
    }
    /**
     * <p>
     * It converts the given String into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
     * The {@link MutableDateTime} is configured with the given {@link DateTimeZone}
     * </p>
     *                 
     * @param pattern string with the format of the input String 
     * @param locale {@link Locale} to be used 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Locale locale, DateTimeZone dateTimeZone) {
        return FnMutableDateTime.strToMutableDateTime(pattern, locale, dateTimeZone);
    }
    /**
     * <p>
     * It converts the given {@link String} into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
     * The {@link MutableDateTime} is configured with the given {@link DateTimeZone}
     * </p>
     * 
     * @param pattern string with the format of the input String 
     * @param locale {@link Locale} to be used 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, String locale, DateTimeZone dateTimeZone) {
        return FnMutableDateTime.strToMutableDateTime(pattern, locale, dateTimeZone);
    }
    /**
     * <p>
     * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
     * The {@link MutableDateTime} will be created with the given {@link Chronology}
     * </p>
     *                 
     * @param pattern string with the format of the input String 
     * @param locale {@link Locale} to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, Locale locale, Chronology chronology) {
        return FnMutableDateTime.strToMutableDateTime(pattern, locale, chronology);
    }
    /**
     * <p>
     * It converts the input {@link String} into a {@link MutableDateTime} using the given pattern and {@link Locale} parameters.
     * The {@link MutableDateTime} will be created with the given {@link Chronology}
     * </p>
     * 
     * @param pattern string with the format of the input String 
     * @param locale {@link Locale} to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String, MutableDateTime> strToMutableDateTime(String pattern, String locale, Chronology chronology) {
        return FnMutableDateTime.strToMutableDateTime(pattern, locale, chronology);
    }
    //
    
    
    // From Date
    /**
     * <p>
     * The input {@link Date} is converted into a {@link MutableDateTime}
     * </p>
     * 
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final <T extends Date> Function<T, MutableDateTime> dateToMutableDateTime() {
        return FnMutableDateTime.dateToMutableDateTime();
    }
    /**
     * <p>
     * The input {@link Date} is converted into a {@link MutableDateTime} configured with the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final <T extends Date> Function<T, MutableDateTime> dateToMutableDateTime(DateTimeZone dateTimeZone) {
        return FnMutableDateTime.dateToMutableDateTime(dateTimeZone);
    }
    /**
     * <p>
     * The input {@link Date} is converted into a {@link MutableDateTime} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final <T extends Date> Function<T, MutableDateTime> dateToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.dateToMutableDateTime(chronology);
    }
    //
    
    
    // From Date
    /**
     * <p>
     * The input {@link Timestamp} is converted into a {@link MutableDateTime}
     * </p>
     * 
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final Function<Timestamp, MutableDateTime> timestampToMutableDateTime() {
        return FnMutableDateTime.timestampToMutableDateTime();
    }
    /**
     * <p>
     * The input {@link Timestamp} is converted into a {@link MutableDateTime} in the given
     * {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<Timestamp, MutableDateTime> timestampToMutableDateTime(DateTimeZone dateTimeZone) {
        return FnMutableDateTime.timestampToMutableDateTime(dateTimeZone);
    }
    /**
     * <p>
     * The input {@link Timestamp} is converted into a {@link MutableDateTime} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<Timestamp, MutableDateTime> timestampToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.timestampToMutableDateTime(chronology);
    }
    //
        
    
    // Conversion from Long
    /**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link MutableDateTime}
     * </p>
     * 
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final Function<Long, MutableDateTime> longToMutableDateTime() {
        return FnMutableDateTime.longToMutableDateTime();
    }
    /**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link MutableDateTime} in the given
     * {@link MutableDateTimeZone}
     * </p>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<Long, MutableDateTime> longToMutableDateTime(DateTimeZone dateTimeZone) {
        return FnMutableDateTime.longToMutableDateTime(dateTimeZone);
    }
    /**
     * <p>
     * The input {@link Long} representing the time in milliseconds is converted into a {@link MutableDateTime} with the given
     * {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<Long, MutableDateTime> longToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.longToMutableDateTime(chronology);
    }
    //
    
    // Conversion from Integer list
    /**
     * <p>
     * A {@link MutableDateTime} is created from the input {@link Integer} {@link Collection}.
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
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final Function<Collection<Integer>, MutableDateTime> integerFieldCollectionToMutableDateTime() {
        return FnMutableDateTime.integerFieldCollectionToMutableDateTime();
    }
    /**
     * <p>
     * A {@link MutableDateTime} is created from the input {@link Integer} {@link Collection}.
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
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<Collection<Integer>, MutableDateTime> integerFieldCollectionToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.integerFieldCollectionToMutableDateTime(chronology);
    }
    //
    
    
    // Conversion from Integer array
    /**
     * <p>
     * A {@link MutableDateTime} is created from the given {@link Integer} array.
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
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final Function<Integer[], MutableDateTime> integerFieldArrayToMutableDateTime() {
        return FnMutableDateTime.integerFieldArrayToMutableDateTime();
    }
    /**
     * <p>
     * A {@link MutableDateTime} is created from the given {@link Integer} array.
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
     * @return the {@link MutableDateTime} created from the input and arguments
     * 
     * @since 1.1
     */
    public static final Function<Integer[], MutableDateTime> integerFieldArrayToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.integerFieldArrayToMutableDateTime(chronology);
    }
    //
    
    
    // Conversion from String list
    /**
     * <p>
     * A {@link MutableDateTime} is created from the given {@link String} {@link Collection}.
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
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final Function<Collection<String>, MutableDateTime> strFieldCollectionToMutableDateTime() {
        return FnMutableDateTime.strFieldCollectionToMutableDateTime();
    }
    /**
     * <p>
     * A {@link MutableDateTime} is created from the given {@link String} {@link Collection}.
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
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<Collection<String>, MutableDateTime> strFieldCollectionToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.strFieldCollectionToMutableDateTime(chronology);
    }
    //
    
    
    // Conversion from String array
    /**
     * <p>
     * A {@link MutableDateTime} is created from the given {@link String} array.
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
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final Function<String[], MutableDateTime> strFieldArrayToMutableDateTime() {
        return FnMutableDateTime.strFieldArrayToMutableDateTime();
    }
    /**
     * <p>
     * A {@link MutableDateTime} is created from the given {@link String} array.
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
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final Function<String[], MutableDateTime> strFieldArrayToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.strFieldArrayToMutableDateTime(chronology);
    }
    //
    
    
    // Conversion from Calendar
    /**
     * <p>
     * It converts a {@link Calendar} into a {@link MutableDateTime}
     * </p>
     * 
     * @return the {@link MutableDateTime} created from the input 
     * 
     * @since 1.1
     */
    public static final <T extends Calendar> Function<T, MutableDateTime> calendarToMutableDateTime() {
        return FnMutableDateTime.calendarToMutableDateTime();
    }
    /**
     * <p>
     * It converts a {@link Calendar} into a {@link MutableDateTime} in the given {@link DateTimeZone}
     * </p>
     * 
     * @param dateTimeZone the the time zone ({@link DateTimeZone}) to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final <T extends Calendar> Function<T, MutableDateTime> calendarToMutableDateTime(DateTimeZone dateTimeZone) {
        return FnMutableDateTime.calendarToMutableDateTime(dateTimeZone);
    }
    /**
     * <p>
     * It converts a {@link Calendar} into a {@link MutableDateTime} with the given {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link MutableDateTime} created from the input and arguments 
     * 
     * @since 1.1
     */
    public static final <T extends Calendar> Function<T, MutableDateTime> calendarToMutableDateTime(Chronology chronology) {
        return FnMutableDateTime.calendarToMutableDateTime(chronology);
    }
    //
	
}
