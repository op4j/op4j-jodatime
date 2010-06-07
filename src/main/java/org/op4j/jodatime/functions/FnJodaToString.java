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

import java.util.Locale;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.functions.Function;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 * @deprecated use {@link FnJodaString} instead
 */
@Deprecated
public final class FnJodaToString {

    private FnJodaToString() {
		super();
	}
	
	
	
	/**
     * <p>
     * It converts the input {@link BaseDateTime} into a {@link String}  
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<BaseDateTime, String> fromBaseDateTime() {
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
	 */
	public static final Function<BaseDateTime, String> fromBaseDateTime(final FormatType formatType, final String format) {
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
	 */
	public static final Function<BaseDateTime, String> fromBaseDateTime(final FormatType formatType, final String format, final Locale locale) {
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
	 */
	public static final Function<BaseDateTime, String> fromBaseDateTime(final FormatType formatType, final String format, final Chronology chronology) {
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
	 */
	public static final Function<BaseDateTime, String> fromBaseDateTime(final FormatType formatType, final String format, final String locale) {
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
	public static final Function<BaseDateTime, String> fromBaseDateTime(final DateTimeFormatter formatter) {
		return FnJodaString.baseDateTimeToStr(formatter);
	}
	
	
	
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String}
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<LocalTime, String> fromLocalTime() {
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
	 */
	public static final Function<LocalTime, String> fromLocalTime(final FormatType formatType, final String format) {
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
	 */
	public static final Function<LocalTime, String> fromLocalTime(final FormatType formatType, final String format, final Locale locale) {
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
	 */
	public static final Function<LocalTime, String> fromLocalTime(final FormatType formatType, final String format, final Chronology chronology) {
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
	 */
	public static final Function<LocalTime, String> fromLocalTime(final FormatType formatType, final String format, final String locale) {
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
	public static final Function<LocalTime, String> fromLocalTime(final DateTimeFormatter formatter) {
		return FnJodaString.localTimeToStr(formatter);
	}
	
	
	
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String}
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<LocalDate, String> fromLocalDate() {
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
	 */
	public static final Function<LocalDate, String> fromLocalDate(final FormatType formatType, final String format) {
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
	 */
	public static final Function<LocalDate, String> fromLocalDate(final FormatType formatType, final String format, final Locale locale) {
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
	 */
	public static final Function<LocalDate, String> fromLocalDate(final FormatType formatType, final String format, final Chronology chronology) {
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
	 */
	public static final Function<LocalDate, String> fromLocalDate(final FormatType formatType, final String format, final String locale) {
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
	public static final Function<LocalDate, String> fromLocalDate(final DateTimeFormatter formatter) {
		return FnJodaString.localDateToStr(formatter);
	}

	public static enum FormatType {
        PATTERN,
        STYLE           
    }
	
}
