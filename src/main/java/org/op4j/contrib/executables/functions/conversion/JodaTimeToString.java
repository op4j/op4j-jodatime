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
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.joda.time.Chronology;
import org.joda.time.LocalTime;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class JodaTimeToString {

	
	private JodaTimeToString() {
		super();
	}
	
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format) {
		return new FromBaseDateTime(formatType, format);
	}
	
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format, final Locale locale) {
		return new FromBaseDateTime(formatType, format, locale);
	}
	
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format, final Chronology chronology) {
		return new FromBaseDateTime(formatType, format, chronology);
	}
	
	public static final FromBaseDateTime fromBaseDateTime(final FormatType formatType, final String format, final String locale) {
		return new FromBaseDateTime(formatType, format, locale);
	}
	
	public static final FromBaseDateTime fromBaseDateTime(final DateTimeFormatter formatter) {
		return new FromBaseDateTime(formatter);
	}

	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format) {
		return new FromLocalTime(formatType, format);
	}
	
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format, final Locale locale) {
		return new FromLocalTime(formatType, format, locale);
	}
	
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format, final Chronology chronology) {
		return new FromLocalTime(formatType, format, chronology);
	}
	
	public static final FromLocalTime fromLocalTime(final FormatType formatType, final String format, final String locale) {
		return new FromLocalTime(formatType, format, locale);
	}
	
	public static final FromLocalTime fromLocalTime(final DateTimeFormatter formatter) {
		return new FromLocalTime(formatter);
	}
	
	public static enum FormatType {
		PATTERN,
		STYLE			
	}
	
	public static final class FromBaseDateTime implements IFunc<String, BaseDateTime> {

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
			this.formatter = formatter;
			this.conversionType = ConversionType.FROM_FORMATTER;
		}
		
		public FromBaseDateTime(FormatType formatType, String format) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
		}
		
		public FromBaseDateTime(FormatType formatType, String format, Chronology chronology) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
			this.chronology = chronology;
		}
		
		public FromBaseDateTime(FormatType formatType, String format, Locale locale) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = locale;
		}
		
		public FromBaseDateTime(FormatType formatType, String format, String locale) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		private void setPatternStyleAndConversionType(FormatType formatType, String format) {
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
		
		/* 
		 * It converts the given BaseDateTime into an String by means of the given pattern or style.
		 * A chronology can also be used
		 * 
		 * If a formatter is passed, it will be used instead of the
		 * pattern or style
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public String execute(final BaseDateTime baseDateTime) throws Exception {
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
	
	public static final class FromLocalTime implements IFunc<String, LocalTime> {

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
			this.formatter = formatter;
			this.conversionType = ConversionType.FROM_FORMATTER;
		}
		
		public FromLocalTime(FormatType formatType, String format) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
		}
		
		public FromLocalTime(FormatType formatType, String format, Chronology chronology) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
			this.chronology = chronology;
		}
		
		public FromLocalTime(FormatType formatType, String format, Locale locale) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = locale;
		}
		
		public FromLocalTime(FormatType formatType, String format, String locale) {
			super();			
			setPatternStyleAndConversionType(formatType, format);
			this.locale = LocaleUtils.toLocale(locale);
		}
		
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		private void setPatternStyleAndConversionType(FormatType formatType, String format) {
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
		
		/* 
		 * It converts the given LocalTime into an String by means of the given pattern or style.
		 * A chronology can also be used
		 * 
		 * If a formatter is passed, it will be used instead of the
		 * pattern or style
		 * 
		 * (non-Javadoc)
		 * @see org.op4j.executables.IExecutable#execute(java.lang.Object)
		 */
		public String execute(final LocalTime localTime) throws Exception {
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
}
