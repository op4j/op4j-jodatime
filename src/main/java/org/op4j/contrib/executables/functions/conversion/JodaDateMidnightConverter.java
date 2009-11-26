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

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.operations.conversion.Converter;
import org.op4j.operations.conversion.exceptions.ConversionException;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class JodaDateMidnightConverter extends Converter {
	
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.STRING_TYPESCHEME, 
                "It converts the given String into a DateMidnigth using the given pattern parameter. If" +
                " the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead. Any information related to the time will" +
                " be removed from the result");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, org.joda.time.DateTimeZone"), 
                "It converts the given String into a DateMidnight using the given pattern parameter and with the given" +
                " DateTimeZone. If the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead. Any information concerning the date will" +
                " be removed from the result");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, org.joda.time.Chronology"), 
                "It converts the given String into a DateMidnight using the given pattern parameter and with the given" +
                " Chronology. If the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead. Any information related to the date will be" +
                " removed from the result");
    
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale"), 
                "It converts the given String into a DateMidnight using the given pattern and Locale parameters." +
                " Any information related to the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale, org.joda.time.DateTimeZone"), 
                "It converts the given String into a DateMidnight using the given pattern and Locale parameters." +
                " The DateTime is configured with the given DateTimeZone. Any information related" +
                " to the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale, org.joda.time.Chronology"), 
                "It converts the given String into a DateMidnight using the given pattern and Locale parameters." +
                " The DateTime will be created with the given Chronology. Any information related to the" +
                " time will be removed from the result");
        
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.util.Date is converted into a DateMidnight. Any" +
                " information related to the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The given java.util.Date is converted into a DateMidnight configured with the given" +
                " DateTimeZone. Any information concerning the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"), 
                "The given java.util.Date is converted into a DateMidnight with the given Chronology." +
                " Any information about the time will be removed from the result");
    
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Date is converted into a DateMidnight. Any information related to" +
                " the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given java.sql.Date is converted into a DateMidnight with the given DateTimeZone. Any" +
                " information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_CHRONOLOGY= 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Date is converted into a DateMidnight with the given Chronology. Any" +
                " information about the time will be removed from the result");
    
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Timestamp is converted into a DateMidnight." +
                " Any information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given java.sql.Timestamp is converted into a DateMidnight in the given DateTimeZone." +
                " Any information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Timestamp is converted into a DateMidnight with the given Chronology. " +
                "Any information about the time will be removed from the result");
    
    private static final ArgumentsTypeScheme ATS_LONG_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given long representing the time in millis is converted into a DateMidnight." +
                " Any information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_LONG_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The given long representing the time in millis is converted into a DateMidnight in the" +
                " given DateTimeZone. Any information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_LONG_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given long representing the time in millis is converted into a DateMidnight with the" +
                " given Chronology. Any information about the time will be removed from the result");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A DateMidnight is created from the given year, month and day.");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A DateMidnight is created from the given year, month and day." +
                " The DateMidnight will be created in the given DateTimeZone.");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A DateMidnight is created from the given year, month and day." +
        " The DateMidnight will be created with the given Chronology");

    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A DateMidnight is created from the given year, month and day.");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A DateMidnight is created from the given year, month and day." +
                " The DateMidnight will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A DateMidnight is created from the given year, month and day." +
                " The DateMidnight will be created with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_CALENDAR_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "It converts a Calendar into a DateMidnight. Any information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_CALENDAR_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "It converts a Calendar into a DateMidnight in the given DateTimeZone." +
                " Any information about the time will be removed from the result");
    private static final ArgumentsTypeScheme ATS_CALENDAR_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "It converts a Calendar into a DateMidnight with the given Chronology." +
                " Any information about the time will be removed from the result");
    
    public JodaDateMidnightConverter() {
        super();
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_STRING_PATTERN);
        matched.add(ATS_STRING_PATTERN_DATETIMEZONE);
        matched.add(ATS_STRING_PATTERN_CHRONOLOGY);
        
        matched.add(ATS_STRING_PATTERN_LOCALE);
        matched.add(ATS_STRING_PATTERN_LOCALE_DATETIMEZONE);
        matched.add(ATS_STRING_PATTERN_LOCALE_CHRONOLOGY);
        
        matched.add(ATS_JAVAUTILDATE_EMPTY);
        matched.add(ATS_JAVAUTILDATE_DATETIMEZONE);
        matched.add(ATS_JAVAUTILDATE_CHRONOLOGY);
        
        matched.add(ATS_JAVASQLDATE_EMPTY);
        matched.add(ATS_JAVASQLDATE_DATETIMEZONE);
        matched.add(ATS_JAVASQLDATE_CHRONOLOGY);
        
        matched.add(ATS_TIMESTAMP_EMPTY);
        matched.add(ATS_TIMESTAMP_DATETIMEZONE);
        matched.add(ATS_TIMESTAMP_CHRONOLOGY);
        
        matched.add(ATS_LONG_EMPTY);
        matched.add(ATS_LONG_DATETIMEZONE);
        matched.add(ATS_LONG_CHRONOLOGY);
        
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_DATETIMEZONE);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_CHRONOLOGY);
        
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_DATETIMEZONE);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_CHRONOLOGY);
        
        matched.add(ATS_CALENDAR_EMPTY);
        matched.add(ATS_CALENDAR_DATETIMEZONE);
        matched.add(ATS_CALENDAR_CHRONOLOGY);
        
        return matched;
    }
    
    
    
    @Override
    public Type getResultType() {
        return Types.forName("org.joda.time.DateMidnight");
    }
    

    @Override
	protected Result doExecute(final Arguments arguments) throws Exception {
		    	    
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }
		
		if (ATS_STRING_PATTERN.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringParameter(0), null, null, null));
        }
		if (ATS_STRING_PATTERN_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), 
            		arguments.getStringParameter(0), null, (DateTimeZone) arguments.getParameter(1), null));
        }
		if (ATS_STRING_PATTERN_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), 
            		arguments.getStringParameter(0), null, null, (Chronology) arguments.getParameter(1)));
        }
		
		if (ATS_STRING_PATTERN_LOCALE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringParameter(0), arguments.getLocaleParameter(1),
            		null, null));
        }
		if (ATS_STRING_PATTERN_LOCALE_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringParameter(0), arguments.getLocaleParameter(1),
            		(DateTimeZone) arguments.getParameter(2), null));
        }
		if (ATS_STRING_PATTERN_LOCALE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringParameter(0), arguments.getLocaleParameter(1),
            		null, (Chronology) arguments.getParameter(2)));
        }
        
        if (ATS_JAVAUTILDATE_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime(), null, null));
        }
        if (ATS_JAVAUTILDATE_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
        if (ATS_JAVAUTILDATE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime(),
            		null, (Chronology) arguments.getParameter(0)));
        }
        
		if (ATS_JAVASQLDATE_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime(),
            		null, null));
        }
		if (ATS_JAVASQLDATE_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_JAVASQLDATE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime(),
            		null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_TIMESTAMP_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime(),
            		null, null));
        }
		if (ATS_TIMESTAMP_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_TIMESTAMP_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime(),
            		null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_LONG_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue(),
            		null, null));
        }
		if (ATS_LONG_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_LONG_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue(),
            		null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					null, null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					null, null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_CALENDAR_EMPTY.matches(arguments)) {
			return createUniqResult(new DateMidnight((Calendar) arguments.getTarget(0)));
		}
		if (ATS_CALENDAR_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(new DateMidnight((Calendar) arguments.getTarget(0),
					(DateTimeZone) arguments.getParameter(0)));
		}
		if (ATS_CALENDAR_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(new DateMidnight((Calendar) arguments.getTarget(0),
					(Chronology) arguments.getParameter(0)));
		}
		
		return null;
	}
	
    private DateMidnight fromString(final String asString, final String pattern, final Locale locale,
			final DateTimeZone dateTimeZone, final Chronology chronology) 
		throws Exception {
		
		Validate.isTrue(!((dateTimeZone != null) && (chronology != null)),
				"If chronology is set, dateTimeZone should not as it is already contained in chronology.");
		
		DateTimeFormatter dateTimeFormatter = null;
	    if (locale == null) {
	        if (StringUtils.contains(pattern, "MMM")) {
                throw new ConversionException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
	        if (StringUtils.contains(pattern, "EEE")) {
	            throw new ConversionException("The use of EEE or EEEE as part of the date pattern requires a Locale");
	        }
	        dateTimeFormatter = DateTimeFormat.forPattern(pattern);        
	    } else {    
	        dateTimeFormatter = DateTimeFormat.forPattern(pattern);
	        dateTimeFormatter = dateTimeFormatter.withLocale(locale);
	    }
	    
	    DateMidnight result = new DateMidnight();
	    if (dateTimeZone != null) {	    	
	    	dateTimeFormatter = dateTimeFormatter.withZone(dateTimeZone);
	    }
	    if (chronology != null) {
	    	dateTimeFormatter = dateTimeFormatter.withChronology(chronology);
	    }
		result = dateTimeFormatter.parseDateTime(asString).toDateMidnight();
		
		return result;		
	}
		
	private DateMidnight fromLong(final long asLong, final DateTimeZone dateTimeZone, final Chronology chronology) 
		throws Exception {

		Validate.isTrue(!((dateTimeZone != null) && (chronology != null)));
		
		if (dateTimeZone != null) {
			return new DateMidnight(asLong, dateTimeZone);
		}
		if (chronology != null) {
			return new DateMidnight(asLong, chronology);
		}
		
		return new DateMidnight(asLong);
	}
	
	private DateMidnight fromInts(final Integer year, final Integer month, final Integer day,
	        DateTimeZone dateTimeZone, Chronology chronology) 
		throws Exception {

		/*
	     * None of the Integers can be null 
	     */
		Validate.notNull(year);
		Validate.notNull(month);
		Validate.notNull(day);
			    
		Validate.isTrue(4 == year.toString().length(), "Year must have 4 digits (yyyy)");
		Validate.isTrue(!((dateTimeZone != null) && (chronology != null)));
		
        if (dateTimeZone != null) {
        	return new DateMidnight(year.intValue(), month.intValue(),
    	    		day.intValue(), dateTimeZone);
        }
        if (chronology != null) {
        	return new DateMidnight(year.intValue(), month.intValue(),
    	    		day.intValue(), chronology);
        }
	    return new DateMidnight(year.intValue(), month.intValue(),
	    		day.intValue());
		
	}	
}
