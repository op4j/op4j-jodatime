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
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
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
public final class JodaLocalTimeConverter extends Converter {
	
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.STRING_TYPESCHEME, 
                "It converts the given String into a LocalTime using the given pattern parameter. If" +
                " the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, org.joda.time.DateTimeZone"), 
                "It converts the given String into a LocalTime using the given pattern parameter and with the given" +
                " DateTimeZone. If the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, org.joda.time.Chronology"), 
                "It converts the given String into a LocalTime using the given pattern parameter and with the given" +
                " Chronology. If the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead");
    
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale"), 
                "It converts the given String into a LocalTime using the given pattern and Locale parameters");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale, org.joda.time.DateTimeZone"), 
                "It converts the given String into a LocalTime using the given pattern and Locale parameters." +
                " The DateTime is configured with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale, org.joda.time.Chronology"), 
                "It converts the given String into a LocalTime using the given pattern and Locale parameters." +
                " The DateTime will be created with the given Chronology");
        
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.util.Date is converted into a LocalTime");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The given java.util.Date is converted into a LocalTime configured with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"), 
                "The given java.util.Date is converted into a LocalTime with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Date is converted into a LocalTime");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given java.sql.Date is converted into a LocalTime with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_CHRONOLOGY= 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Date is converted into a LocalTime with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Timestamp is converted into a LocalTime");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given java.sql.Timestamp is converted into a LocalTime in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Timestamp is converted into a LocalTime with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_LONG_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given long representing the time in millis is converted into a LocalTime");
    private static final ArgumentsTypeScheme ATS_LONG_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The given long representing the time in millis is converted into a LocalTime in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_LONG_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given long representing the time in millis is converted into a LocalTime with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour. The minute, second and millisecond will be set to 0");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A LocalTime is created from the given hour. The minute, second and millisecond will be set to 0." +
                " The DateTime will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour. The minute, second and millisecond will be set to 0." +
                " The result will be created with the given Chronology");    
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour. The minute, second and millisecond will be set to 0");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A LocalTime is created from the given hour. The minute, second and millisecond will be set to 0. The DateTime" +
                " will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour. The minute, second and millisecond will be set to 0." +
                " The DateTime will be created with the given Chronology");
       
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour and minute. The second and millisecond will be set to 0");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A LocalTime is created from the given hour and minute. The second and millisecond will be set to 0." +
                " The DateTime will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour and minute. The second and millisecond will be set to 0." +
                " The result will be created with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour and minute. The second and millisecond will be set to 0");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A LocalTime is created from the given hour and minute. The second and millisecond will be set to 0. The DateTime" +
                " will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour and minute. The second and millisecond will be set to 0." +
                " The DateTime will be created with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour, minute and second. The millisecond will be set to 0");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A LocalTime is created from the given hour, minute and second. The millisecond will be set to 0. The" +
                " DateTime will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour, minute and second. The millisecond will be set to 0." +
                " The DateTime will be created based on the given Chronology");

    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour, minute and second. The millisecond will be set to 0");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "A LocalTime is created from the given hour, minute and second. The millisecond will be set to 0. The" +
                " DateTime will be created based on the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour, minute and second. The millisecond will be set to 0." +
                " The DateTime will be created based on the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour, minute, second and millisecond");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "A LocalTime is created from the given hour, minute, second and millisecond" +
                " in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour, minute, second and millisecond" +
                " with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A LocalTime is created from the given hour, minute, second and millisecond");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "A LocalTime is created from the given hour, minute, second and millisecond" +
                " in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "A LocalTime is created from the given hour, minute, second and millisecond" +
                " with the given Chronology");

    private static final ArgumentsTypeScheme ATS_CALENDAR_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "It converts a Calendar into a LocalTime");
    private static final ArgumentsTypeScheme ATS_CALENDAR_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "It converts a Calendar into a LocalTime in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_CALENDAR_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "It converts a Calendar into a LocalTime with the given Chronology");
    
    public JodaLocalTimeConverter() {
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
        
        matched.add(ATS_INTEGERHOUR_EMPTY);
        matched.add(ATS_INTEGERHOUR_DATETIMEZONE);
        matched.add(ATS_INTEGERHOUR_CHRONOLOGY);
                
        matched.add(ATS_STRINGHOUR_EMPTY);
        matched.add(ATS_STRINGHOUR_DATETIMEZONE);
        matched.add(ATS_STRINGHOUR_CHRONOLOGY);
        
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_EMPTY);
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_DATETIMEZONE);
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_CHRONOLOGY);
                
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_EMPTY);
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_DATETIMEZONE);
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_CHRONOLOGY);
        
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY);
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_DATETIMEZONE);
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_CHRONOLOGY);
                
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY);
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_DATETIMEZONE);
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_CHRONOLOGY);
        
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY);
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_DATETIMEZONE);
        matched.add(ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_CHRONOLOGY);
                
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY);
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_DATETIMEZONE);
        matched.add(ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_CHRONOLOGY);
                
        matched.add(ATS_CALENDAR_EMPTY);
        matched.add(ATS_CALENDAR_DATETIMEZONE);
        matched.add(ATS_CALENDAR_CHRONOLOGY);
        
        return matched;
    }
        
    @Override
    public Type getResultType() {
        return Types.forName("org.joda.time.LocalTime");
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
		
		if (ATS_INTEGERHOUR_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_INTEGERHOUR_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_INTEGERHOUR_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGHOUR_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_STRINGHOUR_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_STRINGHOUR_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_INTEGERHOUR_INTEGERMINUTE_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_INTEGERHOUR_INTEGERMINUTE_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_INTEGERHOUR_INTEGERMINUTE_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGHOUR_STRINGMINUTE_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_STRINGHOUR_STRINGMINUTE_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null));
        }
		if (ATS_STRINGHOUR_STRINGMINUTE_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(Chronology) arguments.getParameter(0)));
        }
				
		if (ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0),
					null));
        }
		if (ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0),
					null));
        }
		if (ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0),
					(Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0),
					null));
        }
		if (ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0),
					null));
        }
		if (ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0),
					(Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					null));
        }
		if (ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					null));
        }
		if (ATS_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					(Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        null));
        }
		if (ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        null));
        }
		if (ATS_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_CALENDAR_EMPTY.matches(arguments)) {
			return createUniqResult(new LocalTime((Calendar) arguments.getTarget(0)));
		}
		if (ATS_CALENDAR_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(new LocalTime((Calendar) arguments.getTarget(0),
					(DateTimeZone) arguments.getParameter(0)));
		}
		if (ATS_CALENDAR_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(new LocalTime((Calendar) arguments.getTarget(0),
					(Chronology) arguments.getParameter(0)));
		}
		
		return null;
	}
	
    private LocalTime fromString(final String asString, final String pattern, final Locale locale,
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
	        dateTimeFormatter = DateTimeFormat.forPattern(pattern).withLocale(locale);
	    }
	    
	    LocalTime result = new LocalTime();
	    if (dateTimeZone != null) {	    	
	    	dateTimeFormatter = dateTimeFormatter.withZone(dateTimeZone);
	    }
	    if (chronology != null) {
	    	dateTimeFormatter = dateTimeFormatter.withChronology(chronology);
	    }
		result = dateTimeFormatter.parseDateTime(asString).toLocalTime();
		
		return result;		
	}
		
	private LocalTime fromLong(final long asLong, final DateTimeZone dateTimeZone, final Chronology chronology) 
		throws Exception {

		Validate.isTrue(!((dateTimeZone != null) && (chronology != null)));
		
		if (dateTimeZone != null) {
			return new LocalTime(asLong, dateTimeZone);
		}
		if (chronology != null) {
			return new LocalTime(asLong, chronology);
		}
		
		return new LocalTime(asLong);
	}
	
	private LocalTime fromInts(final Integer hour, final Integer minute, final Integer second, 
			final Integer milli, Chronology chronology) 
		throws Exception {

		/*
	     * None of the Integers can be null 
	     */
		Validate.notNull(hour);
		Validate.notNull(minute);
		Validate.notNull(second);
		Validate.notNull(milli);
	    
		if (chronology != null) {
        	return new LocalTime(hour.intValue(), minute.intValue(), second.intValue(), milli.intValue(), chronology);
        }
	    return new LocalTime(hour.intValue(), minute.intValue(), second.intValue(), milli.intValue());
		
	}	
}

	