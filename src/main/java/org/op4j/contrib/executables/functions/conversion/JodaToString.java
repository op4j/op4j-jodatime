/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.converters.AbstractNullAsNullConverter;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class JodaToString {

	
	private JodaToString() {
		super();
	}
	
	// From BaseDateTime
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
	 * 		 
	 * @param formatType
	 * @param format
	 * @return
	 */
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format) {
		return new FromBaseDateTime(formatType, format);
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
	 * 		 
	 * @param formatType
	 * @param format
	 * @param locale locale to be used with the given pattern
	 * @return
	 */
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format, final Locale locale) {
		return new FromBaseDateTime(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style
	 * 
	 * @param formatType
	 * @param format
	 * @param chronology
	 * @return
	 */
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format, final Chronology chronology) {
		return new FromBaseDateTime(formatType, format, chronology);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
	 * 		 
	 * @param formatType
	 * @param format
	 * @param locale locale to be used with the given pattern
	 * @return
	 */
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format, final String locale) {
		return new FromBaseDateTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final FromBaseDateTime fromBaseDateTime(final DateTimeFormatter formatter) {
		return new FromBaseDateTime(formatter);
	}
	//
	
	// From LocalTime
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 *  
	 * @param formatType
	 * @param format
	 * @return
	 */
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format) {
		return new FromLocalTime(formatType, format);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 *  
	 * @param formatType
	 * @param format
	 * @param locale locale to be used with the pattern
	 * @return
	 */
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format, final Locale locale) {
		return new FromLocalTime(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 * 
	 * @param formatType
	 * @param format
	 * @param chronology
	 * @return
	 */
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format, final Chronology chronology) {
		return new FromLocalTime(formatType, format, chronology);
	}
	
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
	 * 
	 * @param formatType
	 * @param format
	 * @param locale locale to be used with the pattern
	 * @return
	 */
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format, final String locale) {
		return new FromLocalTime(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalTime} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final FromLocalTime fromLocalTime(final DateTimeFormatter formatter) {
		return new FromLocalTime(formatter);
	}
	//
	
	// From LocalDate
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value)
	 * 
	 * @param formatType
	 * @param format
	 */
	public static final FromLocalDate fromLocalDate(final FormatType formatType, final String format) {
		return new FromLocalDate(formatType, format);
	}
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value) with the given {@link Locale}
	 * 
	 * @param formatType
	 * @param format
	 * @param locale
	 */
	public static final FromLocalDate fromLocalDate(final FormatType formatType, final String format, final Locale locale) {
		return new FromLocalDate(formatType, format, locale);
	}
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value) with the given {@link Chronology}
	 * 
	 * @param formatType
	 * @param format
	 * @param chronology
	 */
	public static final FromLocalDate fromLocalDate(final FormatType formatType, final String format, final Chronology chronology) {
		return new FromLocalDate(formatType, format, chronology);
	}
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
	 * or style (depending on the formatType value) with the given {@link Locale}
	 * 
	 * @param formatType
	 * @param format
	 * @param locale
	 */
	public static final FromLocalDate fromLocalDate(final FormatType formatType, final String format, final String locale) {
		return new FromLocalDate(formatType, format, locale);
	}
	
	/**
	 * It converts the given {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
	 * 
	 * @param formatter
	 */
	public static final FromLocalDate fromLocalDate(final DateTimeFormatter formatter) {
		return new FromLocalDate(formatter);
	}
	//
	
	public static enum FormatType {
		PATTERN,
		STYLE			
	}
	
	public static final class FromBaseDateTime extends AbstractNullAsNullConverter<String, BaseDateTime> {

		private ConversionType conversionType;
		
		private DateTimeFormatter formatter = null;
		private String pattern = null;
		private String style = null;
		private Locale locale = null;
		private Chronology chronology = null;
		
		private static enum ConversionType {
			FROM_PATTERN,
			FROM_STYLE,
			FROM_FORMATTER
		}
		
		public FromBaseDateTime(DateTimeFormatter formatter) {
			super();
			
			Validate.notNull(formatter, "formatter can't be null");
			
			this.formatter = formatter;
			this.conversionType = ConversionType.FROM_FORMATTER;
		}
		
		public FromBaseDateTime(FormatType formatType, String format) {
			super();		
			
			setPatternStyleAndConversionType(formatType, format);
		}
		
		public FromBaseDateTime(FormatType formatType, String format, Chronology chronology) {
			super();			
			
			Validate.notNull(chronology, "chronology can't be null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.chronology = chronology;
		}
		
		public FromBaseDateTime(FormatType formatType, String format, Locale locale) {
			super();			
			
			Validate.notNull(locale, "locale can't be null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = locale;
		}
		
		public FromBaseDateTime(FormatType formatType, String format, String locale) {
			super();	
			
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public Type<? extends String> getResultType(
				Type<? extends BaseDateTime> targetType) {
			return Types.STRING;
		}	
		
		private void setPatternStyleAndConversionType(FormatType formatType, String format) {
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				case STYLE:
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		/**
		 * It converts the given {@link BaseDateTime} into a {@link String} by means of the given pattern or style.
		 * A chronology can also be used
		 * 
		 * If a formatter is passed, it will be used instead of the
		 * pattern or style
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public String nullAsNullExecute(final BaseDateTime baseDateTime, ExecCtx ctx) throws Exception {
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
	
	public static final class FromLocalTime extends AbstractNullAsNullConverter<String, LocalTime> {

		private ConversionType conversionType;
		
		private DateTimeFormatter formatter = null;
		private String pattern = null;
		private String style = null;
		private Locale locale = null;
		private Chronology chronology = null;
		
		private static enum ConversionType {
			FROM_PATTERN,
			FROM_STYLE,
			FROM_FORMATTER
		}
		
		public FromLocalTime(DateTimeFormatter formatter) {
			super();
			
			Validate.notNull(formatter, "formatter can't be null");
			
			this.formatter = formatter;
			this.conversionType = ConversionType.FROM_FORMATTER;
		}
		
		public FromLocalTime(FormatType formatType, String format) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
		}
		
		public FromLocalTime(FormatType formatType, String format, Chronology chronology) {
			super();			
			
			Validate.notNull(chronology, "chronology can't be null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.chronology = chronology;
		}
		
		public FromLocalTime(FormatType formatType, String format, Locale locale) {
			super();			
			
			Validate.notNull(locale, "locale can't be null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = locale;
		}
		
		public FromLocalTime(FormatType formatType, String format, String locale) {
			super();			
			
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public Type<? extends String> getResultType(
				Type<? extends LocalTime> targetType) {
			return Types.STRING;
		}	

		private void setPatternStyleAndConversionType(FormatType formatType, String format) {
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
			
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				case STYLE:
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		/** 
		 * It converts the given {@link LocalTime} into a {@link String} by means of the given pattern or style.
		 * A chronology can also be used
		 * 
		 * If a formatter is passed, it will be used instead of the
		 * pattern or style
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public String nullAsNullExecute(final LocalTime localTime, ExecCtx ctx) throws Exception {
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
	
	public static final class FromLocalDate extends AbstractNullAsNullConverter<String, LocalDate> {

		private ConversionType conversionType;
		
		private DateTimeFormatter formatter = null;
		private String pattern = null;
		private String style = null;
		private Locale locale = null;
		private Chronology chronology = null;
		
		private static enum ConversionType {
			FROM_PATTERN,
			FROM_STYLE,
			FROM_FORMATTER
		}
		
		/**
		 * It converts the given {@link LocalDate} into a {@link String} by means of the given {@link DateTimeFormatter}
		 * 
		 * @param formatter
		 */
		public FromLocalDate(DateTimeFormatter formatter) {
			super();
			
			Validate.notNull(formatter, "formatter can't be null");
			
			this.formatter = formatter;
			this.conversionType = ConversionType.FROM_FORMATTER;
		}
		
		/**
		 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
		 * or style (depending on the formatType value)
		 * 
		 * @param formatType
		 * @param format
		 */
		public FromLocalDate(FormatType formatType, String format) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
		}
		
		/**
		 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
		 * or style (depending on the formatType value) with the given {@link Chronology}
		 * 
		 * @param formatType
		 * @param format
		 * @param chronology
		 */
		public FromLocalDate(FormatType formatType, String format, Chronology chronology) {
			super();		
			
			Validate.notNull(chronology, "chronology can't be null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.chronology = chronology;
		}
		
		
		/**
		 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
		 * or style (depending on the formatType value) with the given {@link Locale}
		 * 
		 * @param formatType
		 * @param format
		 * @param locale
		 */
		public FromLocalDate(FormatType formatType, String format, Locale locale) {
			super();	
			
			Validate.notNull(locale, "locale can't be null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = locale;
		}
		
		/**
		 * It converts the given {@link LocalDate} into a {@link String} by means of the given pattern
		 * or style (depending on the formatType value) with the given {@link Locale}
		 * 
		 * @param formatType
		 * @param format
		 * @param locale
		 */
		public FromLocalDate(FormatType formatType, String format, String locale) {
			super();	
			
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public Type<? extends String> getResultType(
				Type<? extends LocalDate> targetType) {
			return Types.STRING;
		}

		private void setPatternStyleAndConversionType(FormatType formatType, String format) {
			
			Validate.notNull(formatType, "formatType can't be null");
			Validate.notEmpty(format, "format can't be neither empty nor null");
						
			switch (formatType) {
				case PATTERN:
					this.pattern = format;
					this.conversionType = ConversionType.FROM_PATTERN;
					break;
				case STYLE:
					this.style = format;
					this.conversionType = ConversionType.FROM_STYLE;
					break;				
			}
		}
		
		/* (non-Javadoc)
		 * @see org.op4j.functions.AbstractNullAsNullFunc#nullAsNullExecute(java.lang.Object)
		 */
		@Override
		public String nullAsNullExecute(final LocalDate LocalDate, ExecCtx ctx) throws Exception {
			switch (this.conversionType) {
				case FROM_FORMATTER:
					return LocalDate.toString(this.formatter);					
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
					return LocalDate.toString(f);					
			}			
		}
	}
}
