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

import java.util.LinkedHashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.operations.conversion.Converter;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class JodaLocalDateStringConverter extends Converter {
	
	private static final TypeScheme LOCALDATE_TYPESCHEME =
		TypeSchemes.forSingleClass(LocalDate.class);

    private static final ArgumentsTypeScheme ATS_LOCALDATE_PATTERN_FROMPATTERNPARAM = 
        new ArgumentsTypeScheme(
            LOCALDATE_TYPESCHEME, 
            TypeSchemes.forName("String, 'FROM_PATTERN'"), 
                "It converts the given LocalDate into an String by means of the given pattern");
    
    private static final ArgumentsTypeScheme ATS_LOCALDATE_STYLE_FROMSTYLEPARAM = 
        new ArgumentsTypeScheme(
            LOCALDATE_TYPESCHEME, 
            TypeSchemes.forName("String, 'FROM_STYLE'"), 
                "It converts the given LocalDate into an String by means of the given style");
    
    private static final ArgumentsTypeScheme ATS_LOCALDATE_PATTERN_LOCALE_FROMPATTERNPARAM = 
        new ArgumentsTypeScheme(
            LOCALDATE_TYPESCHEME, 
            TypeSchemes.forName("String, java.util.Locale, 'FROM_PATTERN'"), 
                "It converts the given LocalDate into an String by means of the given pattern" +
                " and Locale");
    
    private static final ArgumentsTypeScheme ATS_LOCALDATE_STYLE_LOCALE_FROMSTYLEPARAM = 
        new ArgumentsTypeScheme(
            LOCALDATE_TYPESCHEME, 
            TypeSchemes.forName("String, java.util.Locale, 'FROM_STYLE'"), 
                "It converts the given LocalDate into an String by means of the given style" +
                " and Locale");
    
    private static final ArgumentsTypeScheme ATS_LOCALDATE_DATETIMEFORMATTER = 
        new ArgumentsTypeScheme(
            LOCALDATE_TYPESCHEME, 
            TypeSchemes.forName("org.joda.time.format.DateTimeFormatter"), 
                "It converts the given LocalDate into an String by means of the given DateTimeFormatter");
    
    
    public JodaLocalDateStringConverter() {
        super();
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        
        matched.add(ATS_LOCALDATE_PATTERN_FROMPATTERNPARAM);
        matched.add(ATS_LOCALDATE_STYLE_FROMSTYLEPARAM);
        
        matched.add(ATS_LOCALDATE_PATTERN_LOCALE_FROMPATTERNPARAM);
        matched.add(ATS_LOCALDATE_STYLE_LOCALE_FROMSTYLEPARAM);
        
        matched.add(ATS_LOCALDATE_DATETIMEFORMATTER);
        
        return matched;
    }  
        
    @Override
    public Type getResultType() {
        return Types.STRING;
    }
    
    @Override
	protected Result doExecute(final Arguments arguments) throws Exception {
		    	    
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }
		
		if (ATS_LOCALDATE_PATTERN_FROMPATTERNPARAM.matches(arguments)) {
            return createUniqResult(((LocalDate) arguments.getTarget(0))
            		.toString(arguments.getStringParameter(0)));
        }
		
		if (ATS_LOCALDATE_STYLE_FROMSTYLEPARAM.matches(arguments)) {
            return createUniqResult(((LocalDate) arguments.getTarget(0))
            		.toString(DateTimeFormat.forStyle(arguments.getStringParameter(0))));
        }
		
		if (ATS_LOCALDATE_PATTERN_LOCALE_FROMPATTERNPARAM.matches(arguments)) {
            return createUniqResult(((LocalDate) arguments.getTarget(0))
            		.toString(arguments.getStringParameter(0), arguments.getLocaleParameter(1)));
        }
		
		if (ATS_LOCALDATE_STYLE_LOCALE_FROMSTYLEPARAM.matches(arguments)) {
			return createUniqResult(((LocalDate) arguments.getTarget(0))
            		.toString(DateTimeFormat.forStyle(arguments.getStringParameter(0))
            				.withLocale(arguments.getLocaleParameter(1))));
        }
		
		if (ATS_LOCALDATE_DATETIMEFORMATTER.matches(arguments)) {
            return createUniqResult(((LocalDate) arguments.getTarget(0))
            		.toString((DateTimeFormatter) arguments.getParameter(0)));
        }
		
		return null;
	}
}
