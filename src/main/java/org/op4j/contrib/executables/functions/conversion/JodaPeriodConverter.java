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
import java.util.Set;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.operations.conversion.Converter;
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
public final class JodaPeriodConverter extends Converter {

	private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_JAVAUTILDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.util.Date, java.util.Date"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.util.Date targets will be used as the start and end instants of the Period" +
                " returned");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_JAVAUTILDATE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        		TypeSchemes.forName("java.util.Date, java.util.Date"), 
            TypeSchemes.forName("org.joda.time.Chronology"), 
                "The given java.util.Date elements will be used as the start and end instants of the Period" +
                " returned.");
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_JAVAUTILDATE_PERIODTYPE = 
        new ArgumentsTypeScheme(
        		TypeSchemes.forName("java.util.Date, java.util.Date"), 
            TypeSchemes.forName("org.joda.time.PeriodType"), 
                "The given java.util.Date elements will be used as the start and end instants of the Period" +
                " returned. Such a Period will be created with the given PeriodType");
    
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_JAVASQLDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.sql.Date, java.sql.Date"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Date elements will be used as the start and end instants of the Period created");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_JAVASQLDATE_CHRONOLOGY= 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Date, java.sql.Date"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Date elements will be used as the start and end instantz of the returned" +
                " Period");
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_JAVASQLDATE_PERIODTYPE= 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Date, java.sql.Date"), 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "The given java.sql.Date elements will be used as the start and end instantz of the returned" +
                " Period. The Period will be created with the given PeriodType");
    
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_TIMESTAMP_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.sql.Timestamp, java.sql.Timestamp"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Timestamp target elements will be used as the start and end" +
                " instants of the Period returned");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_TIMESTAMP_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Timestamp, java.sql.Timestamp"),                 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given java.sql.Timestamp target elements will be used as the start and end" +
                " instants of the Period returned.");
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_TIMESTAMP_PERIODTYPE = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.sql.Timestamp, java.sql.Timestamp"),                 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "The given java.sql.Timestamp target elements will be used as the start and end" +
                " instants of the Period returned. The Period will be created with the given PeriodType");
    
    private static final ArgumentsTypeScheme ATS_LONG_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "It returns a Period with the given Duration");
    private static final ArgumentsTypeScheme ATS_LONG_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long"), 
            TypeSchemes.forName("org.joda.time.Chronology"), 
                "Creates a period from the given millisecond duration");
    private static final ArgumentsTypeScheme ATS_LONG_PERIODTYPE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long"), 
            TypeSchemes.forName("org.joda.time.PeriodType"), 
                "Creates a period from the given millisecond duration");
    private static final ArgumentsTypeScheme ATS_LONG_PERIODTYPE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long"), 
            TypeSchemes.forName("org.joda.time.PeriodType, org.joda.time.Chronology"), 
                "Creates a period from the given millisecond duration");
    
    private static final ArgumentsTypeScheme ATS_LONG_LONG_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given long targets representing the time in millis will be used as the start" +
                " and end instants of the Period returned");
    private static final ArgumentsTypeScheme ATS_LONG_LONG_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "The given long representing the time in millis will be used as the start and end instants of the Period returned. The" +
                " given Chronology will be used as the Period Chronology");
    private static final ArgumentsTypeScheme ATS_LONG_LONG_PERIODTYPE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "The given long representing the time in millis will be used as the start and end instants of the Period returned. The" +
                " given PeriodType will be used as the type of the returned Period");
    private static final ArgumentsTypeScheme ATS_LONG_LONG_PERIODTYPE_CHRONOLOGY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Long, Long"), 
            TypeSchemes.forName("org.joda.time.PeriodType, org.joda.time.Chronology"),
                "The given long representing the time in millis will be used as the start and end instants of the Period returned.");
        
    private static final ArgumentsTypeScheme ATS_CALENDAR_CALENDAR_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("java.util.Calendar, java.util.Calendar"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "It creates a Period with the given Calendar targets as the start and end of it");
    private static final ArgumentsTypeScheme ATS_CALENDAR_CALENDAR_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.util.Calendar, java.util.Calendar"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "It creates a Period with the given Calendar targets as the start and end. The period will be created with the given Chronology");
    private static final ArgumentsTypeScheme ATS_CALENDAR_CALENDAR_PERIODTYPE = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("java.util.Calendar, java.util.Calendar"), 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "It creates a Period with the given Calendar targets as the start and end. The period will be created with the given PeriodType");
    
    private static final ArgumentsTypeScheme ATS_DATETIME_DATETIME_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("org.joda.time.DateTime, org.joda.time.DateTime"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "It creates a Period with the given DateTime targets as the start and end of it");
    private static final ArgumentsTypeScheme ATS_DATETIME_DATETIME_CHRONOLOGY = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("org.joda.time.DateTime, org.joda.time.DateTime"), 
            TypeSchemes.forName("org.joda.time.Chronology"),
                "It creates a Period with the given DateTime targets as the start and end. The period will be created with the given Chronology");
    private static final ArgumentsTypeScheme ATS_DATETIME_DATETIME_PERIODTYPE = 
        new ArgumentsTypeScheme(
        	TypeSchemes.forName("org.joda.time.DateTime, org.joda.time.DateTime"), 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "It creates a Period with the given DateTime targets as the start and end. The period will be created with the given PeriodType");
    
    private static final ArgumentsTypeScheme ATS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME,
                "A Period is created from the given hours, minutes, seconds and milliseconds");
    private static final ArgumentsTypeScheme ATS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME,
                "A Period is created from the given hours, minutes, seconds and milliseconds");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEARS_INTEGERMONTHS_INTEGERWEEKS_INTEGERDAYS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME,
                "A Period is created from the given years, months, weeks, days, hours, minutes, seconds and milliseconds");
    private static final ArgumentsTypeScheme ATS_STRINGYEARS_STRINGMONTHS_STRINGWEEKS_STRINGDAYS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME,
                "A Period is created from the given years, months, weeks, days, hours, minutes, seconds and milliseconds");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEARS_INTEGERMONTHS_INTEGERWEEKS_INTEGERDAYS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS_PERIODTYPE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "A Period is created from the given years, months, weeks, days, hours, minutes, seconds and milliseconds");
    private static final ArgumentsTypeScheme ATS_STRINGYEARS_STRINGMONTHS_STRINGWEEKS_STRINGDAYS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS_PERIODTYPE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String"), 
            TypeSchemes.forName("org.joda.time.PeriodType"),
                "A Period is created from the given years, months, weeks, days, hours, minutes, seconds and milliseconds");
    
    public JodaPeriodConverter() {
        super();
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        
        matched.add(ATS_JAVAUTILDATE_JAVAUTILDATE_EMPTY);
        matched.add(ATS_JAVAUTILDATE_JAVAUTILDATE_CHRONOLOGY);
        matched.add(ATS_JAVAUTILDATE_JAVAUTILDATE_PERIODTYPE);
        
        matched.add(ATS_JAVASQLDATE_JAVASQLDATE_EMPTY);
        matched.add(ATS_JAVASQLDATE_JAVASQLDATE_CHRONOLOGY);
        matched.add(ATS_JAVASQLDATE_JAVASQLDATE_PERIODTYPE);
        
        matched.add(ATS_TIMESTAMP_TIMESTAMP_EMPTY);
        matched.add(ATS_TIMESTAMP_TIMESTAMP_CHRONOLOGY);
        matched.add(ATS_TIMESTAMP_TIMESTAMP_PERIODTYPE);
        
        matched.add(ATS_LONG_EMPTY);
        matched.add(ATS_LONG_CHRONOLOGY);
        matched.add(ATS_LONG_PERIODTYPE);
        matched.add(ATS_LONG_PERIODTYPE_CHRONOLOGY);
        
        matched.add(ATS_LONG_LONG_EMPTY);
        matched.add(ATS_LONG_LONG_CHRONOLOGY);
        matched.add(ATS_LONG_LONG_PERIODTYPE);
        matched.add(ATS_LONG_LONG_PERIODTYPE_CHRONOLOGY);
        
        matched.add(ATS_CALENDAR_CALENDAR_EMPTY);
        matched.add(ATS_CALENDAR_CALENDAR_CHRONOLOGY);
        matched.add(ATS_CALENDAR_CALENDAR_PERIODTYPE);
        
        matched.add(ATS_DATETIME_DATETIME_EMPTY);
        matched.add(ATS_DATETIME_DATETIME_CHRONOLOGY);
        matched.add(ATS_DATETIME_DATETIME_PERIODTYPE);
        
        matched.add(ATS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS);
        matched.add(ATS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS);
        
        matched.add(ATS_INTEGERYEARS_INTEGERMONTHS_INTEGERWEEKS_INTEGERDAYS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS);
        matched.add(ATS_STRINGYEARS_STRINGMONTHS_STRINGWEEKS_STRINGDAYS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS);
        
        matched.add(ATS_INTEGERYEARS_INTEGERMONTHS_INTEGERWEEKS_INTEGERDAYS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS_PERIODTYPE);
        matched.add(ATS_STRINGYEARS_STRINGMONTHS_STRINGWEEKS_STRINGDAYS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS_PERIODTYPE);
        
        return matched;
    }
        
    @Override
    public Type getResultType() {
        return Types.forName("org.joda.time.Period");
    }
    

    @Override
	protected Result doExecute(final Arguments arguments) throws Exception {
		    	    
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }
		
        if (ATS_JAVAUTILDATE_JAVAUTILDATE_EMPTY.matches(arguments)) {
            return createUniqResult(new Period(((java.util.Date)arguments.getTarget(0)).getTime(), ((java.util.Date)arguments.getTarget(1)).getTime()));
        }
        if (ATS_JAVAUTILDATE_JAVAUTILDATE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(((java.util.Date)arguments.getTarget(0)).getTime(), ((java.util.Date)arguments.getTarget(1)).getTime(),
            		(Chronology) arguments.getParameter(0)));
        }
        if (ATS_JAVAUTILDATE_JAVAUTILDATE_PERIODTYPE.matches(arguments)) {
            return createUniqResult(new Period(((java.util.Date)arguments.getTarget(0)).getTime(), ((java.util.Date)arguments.getTarget(1)).getTime(),
            		(PeriodType) arguments.getParameter(0)));
        }
        
		if (ATS_JAVASQLDATE_JAVASQLDATE_EMPTY.matches(arguments)) {
            return createUniqResult(new Period(((java.sql.Date)arguments.getTarget(0)).getTime(), ((java.sql.Date)arguments.getTarget(1)).getTime()));
        }
		if (ATS_JAVASQLDATE_JAVASQLDATE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(((java.sql.Date)arguments.getTarget(0)).getTime(), ((java.sql.Date)arguments.getTarget(1)).getTime(),
            		(Chronology) arguments.getParameter(0)));
        }
		if (ATS_JAVASQLDATE_JAVASQLDATE_PERIODTYPE.matches(arguments)) {
            return createUniqResult(new Period(((java.sql.Date)arguments.getTarget(0)).getTime(), ((java.sql.Date)arguments.getTarget(1)).getTime(),
            		(PeriodType) arguments.getParameter(0)));
        }
		
		if (ATS_TIMESTAMP_TIMESTAMP_EMPTY.matches(arguments)) {
            return createUniqResult(new Period(((java.sql.Timestamp)arguments.getTarget(0)).getTime(), ((java.sql.Timestamp)arguments.getTarget(1)).getTime()));
        }
		if (ATS_TIMESTAMP_TIMESTAMP_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(((java.sql.Timestamp)arguments.getTarget(0)).getTime(), ((java.sql.Timestamp)arguments.getTarget(1)).getTime(),
            		(Chronology) arguments.getParameter(0)));
        }
		if (ATS_TIMESTAMP_TIMESTAMP_PERIODTYPE.matches(arguments)) {
            return createUniqResult(new Period(((java.sql.Timestamp)arguments.getTarget(0)).getTime(), ((java.sql.Timestamp)arguments.getTarget(1)).getTime(),
            		(PeriodType) arguments.getParameter(0)));
        }
		
		if (ATS_LONG_EMPTY.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue()));
        }
		if (ATS_LONG_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(),
            		(Chronology) arguments.getParameter(0)));
        }
		if (ATS_LONG_PERIODTYPE.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(),
            		(PeriodType) arguments.getParameter(0)));
        }
		if (ATS_LONG_LONG_PERIODTYPE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(),
            		(PeriodType) arguments.getParameter(0), (Chronology) arguments.getParameter(1)));
        }
		
		if (ATS_LONG_LONG_EMPTY.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue()));
        }
		if (ATS_LONG_LONG_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue(),
            		(Chronology) arguments.getParameter(0)));
        }
		if (ATS_LONG_LONG_PERIODTYPE.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue(),
            		(PeriodType) arguments.getParameter(0)));
        }
		if (ATS_LONG_LONG_PERIODTYPE_CHRONOLOGY.matches(arguments)) {
            return createUniqResult(new Period(arguments.getLongTarget(0).longValue(), arguments.getLongTarget(1).longValue(),
            		(PeriodType) arguments.getParameter(0), (Chronology) arguments.getParameter(1)));
        }
		
		if (ATS_CALENDAR_CALENDAR_EMPTY.matches(arguments)) {
			return createUniqResult(new Period(((Calendar) arguments.getTarget(0)).getTimeInMillis(), ((Calendar) arguments.getTarget(1)).getTimeInMillis()));
		}
		if (ATS_CALENDAR_CALENDAR_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(new Period(((Calendar) arguments.getTarget(0)).getTimeInMillis(), ((Calendar) arguments.getTarget(1)).getTimeInMillis(),
					(Chronology) arguments.getParameter(0)));
		}
		if (ATS_CALENDAR_CALENDAR_PERIODTYPE.matches(arguments)) {
			return createUniqResult(new Period(((Calendar) arguments.getTarget(0)).getTimeInMillis(), ((Calendar) arguments.getTarget(1)).getTimeInMillis(),
					(PeriodType) arguments.getParameter(0)));
		}
		
		if (ATS_DATETIME_DATETIME_EMPTY.matches(arguments)) {
			return createUniqResult(new Period(((DateTime) arguments.getTarget(0)).getMillis(), ((DateTime) arguments.getTarget(1)).getMillis()));
		}
		if (ATS_DATETIME_DATETIME_CHRONOLOGY.matches(arguments)) {
			return createUniqResult(new Period(((DateTime) arguments.getTarget(0)).getMillis(), ((DateTime) arguments.getTarget(1)).getMillis(),
					(Chronology) arguments.getParameter(0)));
		}
		if (ATS_DATETIME_DATETIME_PERIODTYPE.matches(arguments)) {
			return createUniqResult(new Period(((DateTime) arguments.getTarget(0)).getMillis(), ((DateTime) arguments.getTarget(1)).getMillis(),
					(PeriodType) arguments.getParameter(0)));
		}
		
		if (ATS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS.matches(arguments)) {
			return createUniqResult(new Period(arguments.getIntegerTarget(0).intValue(), arguments.getIntegerTarget(1).intValue(),
					arguments.getIntegerTarget(2).intValue(), arguments.getIntegerTarget(3).intValue()));
		}
		if (ATS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS.matches(arguments)) {
			return createUniqResult(new Period(Integer.parseInt(arguments.getStringTarget(0)), Integer.parseInt(arguments.getStringTarget(1)),
					Integer.parseInt(arguments.getStringTarget(2)), Integer.parseInt(arguments.getStringTarget(3))));
		}
		
		if (ATS_INTEGERYEARS_INTEGERMONTHS_INTEGERWEEKS_INTEGERDAYS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS.matches(arguments)) {
			return createUniqResult(new Period(arguments.getIntegerTarget(0).intValue(), arguments.getIntegerTarget(1).intValue(),
					arguments.getIntegerTarget(2).intValue(), arguments.getIntegerTarget(3).intValue(), arguments.getIntegerTarget(4).intValue(),
					arguments.getIntegerTarget(5).intValue(), arguments.getIntegerTarget(6).intValue(), arguments.getIntegerTarget(7).intValue()));
		}
		if (ATS_STRINGYEARS_STRINGMONTHS_STRINGWEEKS_STRINGDAYS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS.matches(arguments)) {
			return createUniqResult(new Period(Integer.parseInt(arguments.getStringTarget(0)), Integer.parseInt(arguments.getStringTarget(1)),
					Integer.parseInt(arguments.getStringTarget(2)), Integer.parseInt(arguments.getStringTarget(3)),
					Integer.parseInt(arguments.getStringTarget(4)), Integer.parseInt(arguments.getStringTarget(5)),
					Integer.parseInt(arguments.getStringTarget(6)), Integer.parseInt(arguments.getStringTarget(7))));
		}
		
		if (ATS_INTEGERYEARS_INTEGERMONTHS_INTEGERWEEKS_INTEGERDAYS_INTEGERHOURS_INTEGERMINUTES_INTEGERSECONDS_INTEGERMILLISECONDS_PERIODTYPE.matches(arguments)) {
			return createUniqResult(new Period(arguments.getIntegerTarget(0).intValue(), arguments.getIntegerTarget(1).intValue(),
					arguments.getIntegerTarget(2).intValue(), arguments.getIntegerTarget(3).intValue(), arguments.getIntegerTarget(4).intValue(),
					arguments.getIntegerTarget(5).intValue(), arguments.getIntegerTarget(6).intValue(), arguments.getIntegerTarget(7).intValue(),
					(PeriodType) arguments.getParameter(0)));
		}
		if (ATS_STRINGYEARS_STRINGMONTHS_STRINGWEEKS_STRINGDAYS_STRINGHOURS_STRINGMINUTES_STRINGSECONDS_STRINGMILLISECONDS_PERIODTYPE.matches(arguments)) {
			return createUniqResult(new Period(Integer.parseInt(arguments.getStringTarget(0)), Integer.parseInt(arguments.getStringTarget(1)),
					Integer.parseInt(arguments.getStringTarget(2)), Integer.parseInt(arguments.getStringTarget(3)),
					Integer.parseInt(arguments.getStringTarget(4)), Integer.parseInt(arguments.getStringTarget(5)),
					Integer.parseInt(arguments.getStringTarget(6)), Integer.parseInt(arguments.getStringTarget(7)),
					(PeriodType) arguments.getParameter(0)));
		}
		
		return null;
	}    
}


	
	