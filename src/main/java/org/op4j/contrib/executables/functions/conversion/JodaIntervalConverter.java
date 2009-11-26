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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
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
public final class JodaIntervalConverter extends Converter {

	private static final ArgumentsTypeScheme ATS_STRING_STRING_PATTERN = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.STRING_TYPESCHEME, 
                "It creates an Interval using the target Strings as the start and end. The given pattern" +
                " will be used to create the DateTime objects from the given Strings. If" +
                " the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead");
    private static final ArgumentsTypeScheme ATS_STRING_STRING_PATTERN_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("String, org.joda.time.DateTimeZone"), 
                "It creates an Interval from the given start and end Strings using the given pattern parameter" +
                " and with the given DateTimeZone. If the pattern includes either, the name of the month or" +
                " day of week, a conversion accepting a Locale must be used instead");
    private static final ArgumentsTypeScheme ATS_STRING_STRING_PATTERN_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("String, org.joda.time.Chronology"), 
                "It creates an Interval from the given start and end Strings using the given pattern parameter and with the given" +
                " Chronology. If the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead");
    
    private static final ArgumentsTypeScheme ATS_STRING_STRING_PATTERN_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("String, Locale"), 
                "It creates an Interval from the given Strings using the given pattern and Locale parameters");
    private static final ArgumentsTypeScheme ATS_STRING_STRING_PATTERN_LOCALE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("String, Locale, org.joda.time.DateTimeZone"), 
                "It creates an Interval from the given Strings using the given pattern and Locale parameters." +
                " The DateTime is configured with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRING_STRING_PATTERN_LOCALE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String"), 
            TypeSchemes.forName("String, Locale, org.joda.time.Chronology"), 
                "It creates an Interval from the given Strings using the given pattern and Locale parameters." +
                " The DateTime will be created with the given Chronology");
        
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_JAVAUTILDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.util.Date, java.util.Date"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.util.Date targets will be used as the start and end of the Interval " +
                " returned");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_JAVAUTILDATE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.util.Date, java.util.Date"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The given java.util.Date targets will be used as the start and end of the interval" +
                " returned. The DateTime objects created will be configured with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_JAVAUTILDATE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        		TypeSchemes.forName("java.util.Date, java.util.Date"), 
            TypeSchemes.forName("org.joda.time.Chronology"), 
                "The given java.util.Date elements will be used as the start and end of the Interval " +
                " returned. The DateTime objects created will be created with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_JAVASQLDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.sql.Date, java.sql.Date"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Date elements will be used as the start and end of the Interval created");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_JAVASQLDATE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Date, java.sql.Date"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given java.sql.Date elements will be used as the start and end of the returned" +
                " Interval. The start and end DateTime objects will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_JAVASQLDATE_CHRONOLOGY= 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Date, java.sql.Date"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Date elements will be used as the start and end of the returned" +
                " Interval. The start and end DateTime objects will be created with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_TIMESTAMP_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.sql.Timestamp, java.sql.Timestamp"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Timestamp target elements will be used as the start and end" +
                " of the Interval returned");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_TIMESTAMP_DATETIMEZONE = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Timestamp, java.sql.Timestamp"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given java.sql.Timestamp target elements will be used as the start and end" +
                " of the Interval returned. The start and end DateTime objects will be created with the" +
                " given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_TIMESTAMP_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Timestamp, java.sql.Timestamp"),                 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Timestamp target elements will be used as the start and end" +
                " of the Interval returned. The start and end will be created with the given given Chronology");
    
    private static final ArgumentsTypeScheme ATS_LONG_LONG_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given long targets representing the time in millis will be used as the start" +
                " and end of the Interval returned");
    private static final ArgumentsTypeScheme ATS_LONG_LONG_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The given long targets representing the time in millis will be converted int DateTime with" +
                " the given DateTimeZone and used as the start and end of the returned Interval");
    private static final ArgumentsTypeScheme ATS_LONG_LONG_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given long representing the time in millis will be converted into DateTime with the" +
                " given Chronology and used as the start and end of the returned Interval");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "Two DateTime elements will be created from the given year, month and day." +
                " The hour, minute, second and millisecond will be set to 0. The DateTime elements" +
                " created will be used as the start and end of the returned Interval");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "Two DateTime elements will be created from the given year, month, day, year, month, day target elements. The hour," +
                " minute, second and millisecond will be set to 0." +
                " The DateTime elements will be created in the given DateTimeZone and used as the start and" +
                " end of the Interval returned");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "Two DateTime objects will be created from the given year, month, day, year, month, day. The hour, minute, second and millisecond" +
                " will be set to 0. The DateTime objects will be created with the given Chronology and used" +
                " as the start and end of the Interval returned");

    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "Two DateTime objects will be created from the given year, month, day, year, month, day. The hour, minute, second and" +
                " millisecond will be set to 0. The DateTime objects created will be used as the start and end of the interval returned");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "Two DateTime objects will be created from the given year, month, day, year, month, day. The hour, minute, second and" +
                " millisecond will be set to 0. The DateTime objects will be created with the given DateTimeZone and used as the start" +
                " and end of the Interval returned");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "Two DateTime objects will be created from the given year, month, day, year, month, day targets. The hour, minute, second" +
                " and millisecond will be set to 0. The DateTime objects will be created with the given Chronology and used as the start and end of" +
                " the interval returned");

    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "Two DateTime objects will be created from the given year, month, day, hour, minute, year, month, day, hour, minute targets. The second and" +
                " millisecond will be set to 0. The DateTime objects will be used as the start and end of the Interval returned");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "Two DateTime objects will be created from the given year, month, day, hour, minute, year, month, day, hour, minute targets. The second" +
                " and millisecond will be set to 0. The DateTime objects will be created with the given DateTimeZone and used as the start and end of the interval returned");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "Two DateTime objects will be created from the given year, month, day, hour, minute, year, month, day, hour, minute. The second and" +
                " millisecond will be set to 0. The DateTime objects will be created with the given Chronology and used as the start and end of the" +
                " result Interval");
    
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "Two DateTime objects will be created from the given year, month, day, hour, minute, year, month, day, hour, minute. The second and" +
                " millisecond will be set to 0. The DateTime objects will be used as the start and end of the result Interval");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "Two DateTime objects will be created from the given year, month, day, hour, minute, year, month, day, hour, minute targets. The second and" +
                " millisecond will be set to 0. The DateTime objects will be created with the given DateTimeZone and used as the start and end of the result Interval");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "Two DateTime objects will be created from the given year, month, day, hour, minute, year, month, day, hour, minute. The second and" +
                " millisecond will be set to 0. The DateTime objects will be created with the given Chronology and used as the start and end of the Interval");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "Two DateTime objects will be created from the given year, month, day, hour, minute, second, year, month, day, hour, minute, second targets." +
                " The millisecond will be set to 0. The DateTime objects will be used as the start and end of the Interval");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "Two DateTime objects will be created from the given year, month, day, hour, minute, second, year, month, day, hour, minute, second." +
                " The millisecond will be set to 0. The DateTime objects will be created with the given DateTimeZone and used as the" +
                " start and end of the Interval");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "Two DateTime objects will be created from the given year, month, day, hour, minute, second, year, month, day, hour, minute, second targets." +
                " The millisecond will be set to 0. The DateTime objects will be created based on the given Chronology and used as the start and end" +
                " of the returned Interval");

    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "Two DateTime objects will be created from the given year, month, day, hour, minute, second, year, month, day, hour, minute, second targets. The" +
                " millisecond will be set to 0. The DateTime objects will be used as the start and end of the Interval");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "The year, month, day, hour, minute, second, year, month, day, hour, minute, second targets will be used as the start and end of the" +
                " returned Interval. The Interval will be created based on the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given year, month, day, hour, minute, second, year, month, day, hour, minute, second targets will be used as the start and" +
                " end of the Interval returned. Such an Interval will be created based on the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond will be used as the" +
                " start and end of the returned Interval");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second, millisecond will be" +
                " used as the start and end of the returned Interval. Such an Interval will be created in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second and millisecond targets will be used" +
                " as the start and end of the returned Interval. The Interval will be created with the given Chronology");
    
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second and millisecond will be used as" +
                " the start and end of the returned Interval");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_DATETIMEZONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"), 
                "The given year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second and millisecond will be used as the" +
                " start and end of the returned Interval. The Interval will be created with the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String, String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given year, month, day, hour, minute, second, millisecond, year, month, day, hour, minute, second and millisecond will be used as the" +
                " start and end of the returned Interval. Such an Interval will be created with the given Chronology");

    private static final ArgumentsTypeScheme ATS_CALENDAR_CALENDAR_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.util.Calendar, java.util.Calendar"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "It creates an Interval with the given Calendar targets as the start and end of the interval");
    private static final ArgumentsTypeScheme ATS_CALENDAR_CALENDAR_DATETIMEZONE = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.util.Calendar, java.util.Calendar"), 
            TypeSchemes.forName("org.joda.time.DateTimeZone"),
                "It creates an Interval with the given Calendar targets as the start and end. Such an interval will be created" +
                " in the given DateTimeZone");
    private static final ArgumentsTypeScheme ATS_CALENDAR_CALENDAR_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.util.Calendar, java.util.Calendar"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "It creates an Interval with the given Calendar targets as the start and end. The interval will be created with the given Chronology");
    
    public JodaIntervalConverter() {
        super();
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_STRING_STRING_PATTERN);
        matched.add(ATS_STRING_STRING_PATTERN_DATETIMEZONE);
        matched.add(ATS_STRING_STRING_PATTERN_CHRONOLOGY);
        
        matched.add(ATS_STRING_STRING_PATTERN_LOCALE);
        matched.add(ATS_STRING_STRING_PATTERN_LOCALE_DATETIMEZONE);
        matched.add(ATS_STRING_STRING_PATTERN_LOCALE_CHRONOLOGY);
        
        matched.add(ATS_JAVAUTILDATE_JAVAUTILDATE_EMPTY);
        matched.add(ATS_JAVAUTILDATE_JAVAUTILDATE_DATETIMEZONE);
        matched.add(ATS_JAVAUTILDATE_JAVAUTILDATE_CHRONOLOGY);
        
        matched.add(ATS_JAVASQLDATE_JAVASQLDATE_EMPTY);
        matched.add(ATS_JAVASQLDATE_JAVASQLDATE_DATETIMEZONE);
        matched.add(ATS_JAVASQLDATE_JAVASQLDATE_CHRONOLOGY);
        
        matched.add(ATS_TIMESTAMP_TIMESTAMP_EMPTY);
        matched.add(ATS_TIMESTAMP_TIMESTAMP_DATETIMEZONE);
        matched.add(ATS_TIMESTAMP_TIMESTAMP_CHRONOLOGY);
        
        matched.add(ATS_LONG_LONG_EMPTY);
        matched.add(ATS_LONG_LONG_DATETIMEZONE);
        matched.add(ATS_LONG_LONG_CHRONOLOGY);
        
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_DATETIMEZONE);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_CHRONOLOGY);
        
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_DATETIMEZONE);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_CHRONOLOGY);
        
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_DATETIMEZONE);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_CHRONOLOGY);
                
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_DATETIMEZONE);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_CHRONOLOGY);
        
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_DATETIMEZONE);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_CHRONOLOGY);
                
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_DATETIMEZONE);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_CHRONOLOGY);
        
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_DATETIMEZONE);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_CHRONOLOGY);
                
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_DATETIMEZONE);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_CHRONOLOGY);
        
        matched.add(ATS_CALENDAR_CALENDAR_EMPTY);
        matched.add(ATS_CALENDAR_CALENDAR_DATETIMEZONE);
        matched.add(ATS_CALENDAR_CALENDAR_CHRONOLOGY);
        
        return matched;
    }
        
    @Override
    public Type getResultType() {
        return Types.forName("org.joda.time.Interval");
    }
    

    @Override
	protected Result doExecute(final Arguments arguments) throws Exception {
		    	    
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }
		
		if (ATS_STRING_STRING_PATTERN.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringTarget(1), arguments.getStringParameter(0), null, null, null));
        }
		if (ATS_STRING_STRING_PATTERN_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringTarget(1), 
            		arguments.getStringParameter(0), null, (DateTimeZone) arguments.getParameter(1), null));
        }
		if (ATS_STRING_STRING_PATTERN_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringTarget(1),
            		arguments.getStringParameter(0), null, null, (Chronology) arguments.getParameter(1)));
        }
		
		if (ATS_STRING_STRING_PATTERN_LOCALE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringTarget(1), arguments.getStringParameter(0), arguments.getLocaleParameter(1),
            		null, null));
        }
		if (ATS_STRING_STRING_PATTERN_LOCALE_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringTarget(1), arguments.getStringParameter(0), arguments.getLocaleParameter(1),
            		(DateTimeZone) arguments.getParameter(2), null));
        }
		if (ATS_STRING_STRING_PATTERN_LOCALE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringTarget(0), arguments.getStringParameter(0), arguments.getLocaleParameter(1),
            		null, (Chronology) arguments.getParameter(2)));
        }
        
        if (ATS_JAVAUTILDATE_JAVAUTILDATE_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime(), ((java.util.Date)arguments.getTarget(1)).getTime(), null, null));
        }
        if (ATS_JAVAUTILDATE_JAVAUTILDATE_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime(), ((java.util.Date)arguments.getTarget(1)).getTime(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
        if (ATS_JAVAUTILDATE_JAVAUTILDATE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime(), ((java.util.Date)arguments.getTarget(1)).getTime(),
            		null, (Chronology) arguments.getParameter(0)));
        }
        
		if (ATS_JAVASQLDATE_JAVASQLDATE_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime(), ((java.sql.Date)arguments.getTarget(1)).getTime(),
            		null, null));
        }
		if (ATS_JAVASQLDATE_JAVASQLDATE_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime(), ((java.sql.Date)arguments.getTarget(1)).getTime(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_JAVASQLDATE_JAVASQLDATE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime(), ((java.sql.Date)arguments.getTarget(1)).getTime(),
            		null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_TIMESTAMP_TIMESTAMP_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime(), ((java.sql.Timestamp)arguments.getTarget(1)).getTime(),
            		null, null));
        }
		if (ATS_TIMESTAMP_TIMESTAMP_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime(), ((java.sql.Timestamp)arguments.getTarget(1)).getTime(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_TIMESTAMP_TIMESTAMP_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime(), ((java.sql.Timestamp)arguments.getTarget(1)).getTime(),
            		null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_LONG_LONG_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue(),
            		null, null));
        }
		if (ATS_LONG_LONG_DATETIMEZONE.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue(),
            		(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_LONG_LONG_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue(),
            		null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGYEAR_STRINGMONTH_STRINGDAY_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					Integer.valueOf(0),
					Integer.valueOf(0),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					Integer.valueOf(0),
					Integer.valueOf(0),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					Integer.valueOf(0),
					Integer.valueOf(0),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(arguments.getStringTarget(6)),
					Integer.valueOf(arguments.getStringTarget(7)),
					Integer.valueOf(arguments.getStringTarget(8)),
					Integer.valueOf(arguments.getStringTarget(9)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(arguments.getStringTarget(6)),
					Integer.valueOf(arguments.getStringTarget(7)),
					Integer.valueOf(arguments.getStringTarget(8)),
					Integer.valueOf(arguments.getStringTarget(9)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(arguments.getStringTarget(6)),
					Integer.valueOf(arguments.getStringTarget(7)),
					Integer.valueOf(arguments.getStringTarget(8)),
					Integer.valueOf(arguments.getStringTarget(9)),
					Integer.valueOf(0),
					Integer.valueOf(0),
					null, (Chronology) arguments.getParameter(0)));
        }
				
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					arguments.getIntegerTarget(10),
					arguments.getIntegerTarget(11),
					Integer.valueOf(0),
					null, null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					arguments.getIntegerTarget(10),
					arguments.getIntegerTarget(11),
					Integer.valueOf(0),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					arguments.getIntegerTarget(10),
					arguments.getIntegerTarget(11),
					Integer.valueOf(0),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(6)),
					Integer.valueOf(arguments.getStringTarget(7)),
					Integer.valueOf(arguments.getStringTarget(8)),
					Integer.valueOf(arguments.getStringTarget(9)),
					Integer.valueOf(arguments.getStringTarget(10)),
					Integer.valueOf(arguments.getStringTarget(11)),
					Integer.valueOf(0),
					null, null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(6)),
					Integer.valueOf(arguments.getStringTarget(7)),
					Integer.valueOf(arguments.getStringTarget(8)),
					Integer.valueOf(arguments.getStringTarget(9)),
					Integer.valueOf(arguments.getStringTarget(10)),
					Integer.valueOf(arguments.getStringTarget(11)),
					Integer.valueOf(0),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0),
					Integer.valueOf(arguments.getStringTarget(6)),
					Integer.valueOf(arguments.getStringTarget(7)),
					Integer.valueOf(arguments.getStringTarget(8)),
					Integer.valueOf(arguments.getStringTarget(9)),
					Integer.valueOf(arguments.getStringTarget(10)),
					Integer.valueOf(arguments.getStringTarget(11)),
					Integer.valueOf(0),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					arguments.getIntegerTarget(10),
					arguments.getIntegerTarget(11),
					arguments.getIntegerTarget(12),
					arguments.getIntegerTarget(13),
					null, null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					arguments.getIntegerTarget(10),
					arguments.getIntegerTarget(11),
					arguments.getIntegerTarget(12),
					arguments.getIntegerTarget(13),
					(DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6),
					arguments.getIntegerTarget(7),
					arguments.getIntegerTarget(8),
					arguments.getIntegerTarget(9),
					arguments.getIntegerTarget(10),
					arguments.getIntegerTarget(11),
					arguments.getIntegerTarget(12),
					arguments.getIntegerTarget(13),
					null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        Integer.valueOf(arguments.getStringTarget(4)),
			        Integer.valueOf(arguments.getStringTarget(5)),
			        Integer.valueOf(arguments.getStringTarget(6)),
			        Integer.valueOf(arguments.getStringTarget(7)),
			        Integer.valueOf(arguments.getStringTarget(8)),
			        Integer.valueOf(arguments.getStringTarget(9)),
			        Integer.valueOf(arguments.getStringTarget(10)),
			        Integer.valueOf(arguments.getStringTarget(11)),
			        Integer.valueOf(arguments.getStringTarget(12)),
			        Integer.valueOf(arguments.getStringTarget(13)),
			        null, null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        Integer.valueOf(arguments.getStringTarget(4)),
			        Integer.valueOf(arguments.getStringTarget(5)),
			        Integer.valueOf(arguments.getStringTarget(6)),
			        Integer.valueOf(arguments.getStringTarget(7)),
			        Integer.valueOf(arguments.getStringTarget(8)),
			        Integer.valueOf(arguments.getStringTarget(9)),
			        Integer.valueOf(arguments.getStringTarget(10)),
			        Integer.valueOf(arguments.getStringTarget(11)),
			        Integer.valueOf(arguments.getStringTarget(12)),
			        Integer.valueOf(arguments.getStringTarget(13)),
			        (DateTimeZone) arguments.getParameter(0), null));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        Integer.valueOf(arguments.getStringTarget(4)),
			        Integer.valueOf(arguments.getStringTarget(5)),
			        Integer.valueOf(arguments.getStringTarget(6)),
			        Integer.valueOf(arguments.getStringTarget(7)),
			        Integer.valueOf(arguments.getStringTarget(8)),
			        Integer.valueOf(arguments.getStringTarget(9)),
			        Integer.valueOf(arguments.getStringTarget(10)),
			        Integer.valueOf(arguments.getStringTarget(11)),
			        Integer.valueOf(arguments.getStringTarget(12)),
			        Integer.valueOf(arguments.getStringTarget(13)),
			        null, (Chronology) arguments.getParameter(0)));
        }
		
		if (ATS_CALENDAR_CALENDAR_EMPTY.matches(arguments)) {
			return createUniqResult(new Interval(((Calendar) arguments.getTarget(0)).getTimeInMillis(), ((Calendar) arguments.getTarget(1)).getTimeInMillis()));
		}
		if (ATS_CALENDAR_CALENDAR_DATETIMEZONE.matches(arguments)) {
			return createUniqResult(new Interval(((Calendar) arguments.getTarget(0)).getTimeInMillis(), ((Calendar) arguments.getTarget(1)).getTimeInMillis(),
					(DateTimeZone) arguments.getParameter(0)));
		}
		if (ATS_CALENDAR_CALENDAR_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(new Interval(((Calendar) arguments.getTarget(0)).getTimeInMillis(), ((Calendar) arguments.getTarget(1)).getTimeInMillis(),
					(Chronology) arguments.getParameter(0)));
		}
		
		return null;
	}
	
    private Interval fromString(final String fromAsString, final String toAsString,  final String pattern, final Locale locale,
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
	    
	    if (dateTimeZone != null) {	    
	    	dateTimeFormatter = dateTimeFormatter.withZone(dateTimeZone);
	    	return new Interval(dateTimeFormatter.parseDateTime(fromAsString).getMillis(), dateTimeFormatter.parseDateTime(toAsString).getMillis(), dateTimeZone);
	    }
	    if (chronology != null) {
	    	dateTimeFormatter = dateTimeFormatter.withChronology(chronology);
	    	return new Interval(dateTimeFormatter.parseDateTime(fromAsString).getMillis(), dateTimeFormatter.parseDateTime(toAsString).getMillis(), chronology);
	    }
	    
	    return new Interval(dateTimeFormatter.parseDateTime(fromAsString).getMillis(), dateTimeFormatter.parseDateTime(toAsString).getMillis());				
	}
		
	private Interval fromLong(final long fromAsLong, final long toAsLong, final DateTimeZone dateTimeZone, final Chronology chronology) 
		throws Exception {

		Validate.isTrue(!((dateTimeZone != null) && (chronology != null)));
		
		if (dateTimeZone != null) {
			return new Interval(fromAsLong, toAsLong, dateTimeZone);
		}
		if (chronology != null) {
			return new Interval(fromAsLong, toAsLong, chronology);
		}
		
		return new Interval(fromAsLong, toAsLong);
	}
	
	private Interval fromInts(final Integer fromYear, final Integer fromMonth, final Integer fromDay, 
	        final Integer fromHour, final Integer fromMinute, final Integer fromSecond, final Integer fromMilli,
	        final Integer toYear, final Integer toMonth, final Integer toDay, 
	        final Integer toHour, final Integer toMinute, final Integer toSecond, final Integer toMilli,
	        DateTimeZone dateTimeZone, Chronology chronology) 
		throws Exception {

		/*
	     * None of the Integers can be null 
	     */
		Validate.notNull(fromYear);
		Validate.notNull(fromMonth);
		Validate.notNull(fromDay);
		Validate.notNull(fromHour);
		Validate.notNull(fromMinute);
		Validate.notNull(fromSecond);
		Validate.notNull(fromMilli);
		Validate.notNull(toYear);
		Validate.notNull(toMonth);
		Validate.notNull(toDay);
		Validate.notNull(toHour);
		Validate.notNull(toMinute);
		Validate.notNull(toSecond);
		Validate.notNull(toMilli);
	    
		Validate.isTrue(4 == fromYear.toString().length(), "Year (from) must have 4 digits (yyyy)");
		Validate.isTrue(4 == toYear.toString().length(), "Year (to) must have 4 digits (yyyy)");
		Validate.isTrue(!((dateTimeZone != null) && (chronology != null)));
		
        if (dateTimeZone != null) {
        	return new Interval(
        			new DateTime(fromYear.intValue(), fromMonth.intValue(), fromDay.intValue(), 
        					fromHour.intValue(), fromMinute.intValue(), fromSecond.intValue(), fromMilli.intValue(), dateTimeZone).getMillis(), 
        			new DateTime(toYear.intValue(), toMonth.intValue(), toDay.intValue(), 
        					toHour.intValue(), toMinute.intValue(), toSecond.intValue(), toMilli.intValue(), dateTimeZone).getMillis(), 
        			dateTimeZone);
        }
        if (chronology != null) {
        	return new Interval(
        			new DateTime(fromYear.intValue(), fromMonth.intValue(), fromDay.intValue(), 
        					fromHour.intValue(), fromMinute.intValue(), fromSecond.intValue(), fromMilli.intValue(), chronology).getMillis(), 
        			new DateTime(toYear.intValue(), toMonth.intValue(), toDay.intValue(), 
        					toHour.intValue(), toMinute.intValue(), toSecond.intValue(), toMilli.intValue(), chronology).getMillis(), 
        			chronology);
        }
	    return new Interval(
    			new DateTime(fromYear.intValue(), fromMonth.intValue(), fromDay.intValue(), 
    					fromHour.intValue(), fromMinute.intValue(), fromSecond.intValue(), fromMilli.intValue()).getMillis(), 
    			new DateTime(toYear.intValue(), toMonth.intValue(), toDay.intValue(), 
    					toHour.intValue(), toMinute.intValue(), toSecond.intValue(), toMilli.intValue()).getMillis());
		
	}	
}

	