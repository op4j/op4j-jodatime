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

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
public final class FnJodaString {

	
	private FnJodaString() {
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
        return new BaseDateTimeToStr();
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
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format) {
		return new BaseDateTimeToStr(formatType, format);
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
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return new BaseDateTimeToStr(formatType, format, locale);
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
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return new BaseDateTimeToStr(formatType, format, chronology);
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
	public static final Function<BaseDateTime, String> baseDateTimeToStr(final FormatType formatType, final String format, final String locale) {
		return new BaseDateTimeToStr(formatType, format, locale);
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
		return new BaseDateTimeToStr(formatter);
	}
	
	
	
	
	/**
     * <p>
     * It converts the input {@link LocalTime} into a {@link String}
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<LocalTime, String> localTimeToStr() {
        return new LocalTimeToStr();
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
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format) {
		return new LocalTimeToStr(formatType, format);
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
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Locale locale) {
		return new LocalTimeToStr(formatType, format, locale);
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
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return new LocalTimeToStr(formatType, format, chronology);
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
	public static final Function<LocalTime, String> localTimeToStr(final FormatType formatType, final String format, final String locale) {
		return new LocalTimeToStr(formatType, format, locale);
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
		return new LocalTimeToStr(formatter);
	}
	
	
	
	
	/**
     * <p>
     * It converts the input {@link LocalDate} into a {@link String}
     * </p>
     * 
     * @return the {@link String} created from the input and arguments 
     */
    public static final Function<LocalDate, String> localDateToStr() {
        return new LocalDateToStr();
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format) {
		return new LocalDateToStr(formatType, format);
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Locale locale) {
		return new LocalDateToStr(formatType, format, locale);
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final Chronology chronology) {
		return new LocalDateToStr(formatType, format, chronology);
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
	public static final Function<LocalDate, String> localDateToStr(final FormatType formatType, final String format, final String locale) {
		return new LocalDateToStr(formatType, format, locale);
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
		return new LocalDateToStr(formatter);
	}
	
	
	public static enum FormatType {
		PATTERN,
		STYLE			
	}
	
	static final class BaseDateTimeToStr extends AbstractNullAsNullFunction<BaseDateTime, String> {

		private final ConversionType conversionType;		
		private final DateTimeFormatter formatter;
		private final String pattern;
		private final String style;
		private final Locale locale;
		private final Chronology chronology;
		
		private static enum ConversionType {
			FROM_PATTERN,
			FROM_STYLE,
			FROM_FORMATTER
		}
		
		public BaseDateTimeToStr() {
            super();
            
            this.conversionType = null;            
            this.formatter = null;
            this.pattern = null;
            this.style = null;
            this.locale = null;
            this.chronology = null;
            
        }
		
		public BaseDateTimeToStr(DateTimeFormatter formatter) {
			super();
			
			Validate.notNull(formatter, "formatter can't be null");
			
			this.conversionType = ConversionType.FROM_FORMATTER;			
			this.formatter = formatter;
			this.pattern = null;
			this.style = null;
			this.locale = null;
			this.chronology = null;
			
		}
		
		public BaseDateTimeToStr(FormatType formatType, String format) {
			super();		
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			
			this.locale = null;
			this.formatter = null;
			this.chronology = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default: // STYLE
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;	
			}
		}
		
		public BaseDateTimeToStr(FormatType formatType, String format, Chronology chronology) {
			super();			
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
			this.locale = null;
			this.formatter = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default: // STYLE
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;	
			}
		}
		
		public BaseDateTimeToStr(FormatType formatType, String format, Locale locale) {
			super();			
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.locale = locale;
			this.formatter = null;
			this.chronology = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default: // STYLE
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;	
			}
		}
		
		public BaseDateTimeToStr(FormatType formatType, String format, String locale) {
			super();	
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.locale = LocaleUtils.toLocale(locale);
			this.formatter = null;
			this.chronology = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default: // STYLE
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;	
			}
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public String nullAsNullExecute(final BaseDateTime baseDateTime, ExecCtx ctx) throws Exception {
			if (this.conversionType == null) {
			    return baseDateTime.toString();
			}
		    switch (this.conversionType) {
				case FROM_FORMATTER:
					return baseDateTime.toString(this.formatter);					
				default:
					// Either pattern or style
					DateTimeFormatter f = null;
					if (ConversionType.FROM_PATTERN.equals(this.conversionType)) {
						f = DateTimeFormat.forPattern(this.pattern);
					} else {
						f = DateTimeFormat.forStyle(this.style);
					}
					if (this.locale != null) {
						f = f.withLocale(this.locale);
					}
					if (this.chronology != null) {
						f = f.withChronology(this.chronology);
					}
					return baseDateTime.toString(f);					
			}			
		}		
	}
	
	static final class LocalTimeToStr extends AbstractNullAsNullFunction<LocalTime, String> {

		private final ConversionType conversionType;		
		private final DateTimeFormatter formatter;
		private final String pattern;
		private final String style;
		private final Locale locale;
		private final Chronology chronology;
		
		private static enum ConversionType {
			FROM_PATTERN,
			FROM_STYLE,
			FROM_FORMATTER
		}
		
		public LocalTimeToStr() {
            super();
            
            this.conversionType = null;
            this.formatter = null;
            this.pattern = null;
            this.style = null;
            this.locale = null;
            this.chronology = null;
        }
		
		public LocalTimeToStr(DateTimeFormatter formatter) {
			super();
			
			Validate.notNull(formatter, "formatter can't be null");
			
			this.conversionType = ConversionType.FROM_FORMATTER;
			this.formatter = formatter;
			this.pattern = null;
			this.style = null;
			this.locale = null;
			this.chronology = null;
		}
		
		public LocalTimeToStr(FormatType formatType, String format) {
			super();			
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			
			this.locale = null;
			this.formatter = null;
			this.chronology = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		public LocalTimeToStr(FormatType formatType, String format, Chronology chronology) {
			super();			
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notNull(chronology, "chronology can't be null");
			
			this.chronology = chronology;
			this.locale = null;
			this.formatter = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		public LocalTimeToStr(FormatType formatType, String format, Locale locale) {
			super();			
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.locale = locale;
			this.formatter = null;
			this.chronology = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		public LocalTimeToStr(FormatType formatType, String format, String locale) {
			super();			
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.locale = LocaleUtils.toLocale(locale);
			this.formatter = null;
			this.chronology = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public String nullAsNullExecute(final LocalTime localTime, ExecCtx ctx) throws Exception {
			if (this.conversionType == null) {
			    return localTime.toString();
			}
			
		    switch (this.conversionType) {
				case FROM_FORMATTER:
					return localTime.toString(this.formatter);					
				default:
					// Either pattern or style
					DateTimeFormatter f = null;
					if (ConversionType.FROM_PATTERN.equals(this.conversionType)) {
						f = DateTimeFormat.forPattern(this.pattern);
					} else {
						f = DateTimeFormat.forStyle(this.style);
					}
					if (this.locale != null) {
						f = f.withLocale(this.locale);
					}
					if (this.chronology != null) {
						f = f.withChronology(this.chronology);
					}
					return localTime.toString(f);					
			}			
		}
	}
	
	static final class LocalDateToStr extends AbstractNullAsNullFunction<LocalDate, String> {

		private final ConversionType conversionType;		
		private final DateTimeFormatter formatter;
		private final String pattern;
		private final String style;
		private final Locale locale;
		private final Chronology chronology;
		
		private static enum ConversionType {
			FROM_PATTERN,
			FROM_STYLE,
			FROM_FORMATTER
		}
		
		public LocalDateToStr() {
            super();
            
            this.formatter = null;
            this.conversionType = null;
            this.pattern = null;
            this.style = null;
            this.locale = null;
            this.chronology = null;
        }
		
		public LocalDateToStr(DateTimeFormatter formatter) {
			super();
			
			Validate.notNull(formatter, "formatter can't be null");
			
			this.formatter = formatter;
			this.conversionType = ConversionType.FROM_FORMATTER;
			this.pattern = null;
			this.style = null;
			this.locale = null;
			this.chronology = null;
		}
		
		public LocalDateToStr(FormatType formatType, String format) {
			super();	
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
						
			this.locale = null;
			this.chronology = null;
			this.formatter = null;
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		public LocalDateToStr(FormatType formatType, String format, Chronology chronology) {
			super();		
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notNull(chronology, "chronology can't be null");
						
			this.chronology = chronology;
			this.locale = null;
			this.formatter = null;
						
			switch (formatType) {
				case PATTERN:
					this.style = null;
					this.pattern = format;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.style = format;
					this.pattern = null;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}		
		
		public LocalDateToStr(FormatType formatType, String format, Locale locale) {
			super();	
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.locale = locale;
			this.formatter = null;
			this.chronology = null;
						
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}

		}
		
		public LocalDateToStr(FormatType formatType, String format, String locale) {
			super();	
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.locale = LocaleUtils.toLocale(locale);
			this.chronology = null;
			this.formatter = null;
						
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.style = null;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				default:
					this.pattern = null;
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunction#nullAsNullExecute(java.lang.Object, org.op4j.functions.ExecCtx)
		 */
		@Override
		public String nullAsNullExecute(final LocalDate localDate, ExecCtx ctx) throws Exception {
			if (this.conversionType == null) {
			    return localDate.toString();
			}
			
		    switch (this.conversionType) {
				case FROM_FORMATTER:
					return localDate.toString(this.formatter);					
				default:
					// Either pattern or style
					DateTimeFormatter f = null;
					if (ConversionType.FROM_PATTERN.equals(this.conversionType)) {
						f = DateTimeFormat.forPattern(this.pattern);
					} else {
						f = DateTimeFormat.forStyle(this.style);
					}
					if (this.locale != null) {
						f = f.withLocale(this.locale);
					}
					if (this.chronology != null) {
						f = f.withChronology(this.chronology);
					}
					return localDate.toString(f);					
			}			
		}
	}
}
