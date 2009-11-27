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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.joda.time.Chronology;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToPeriod {

	private static final FromDateFieldList FROM_DATE_FIELD_LIST = new FromDateFieldList();
	private static final FromDateFieldArray FROM_DATE_FIELD_ARRAY = new FromDateFieldArray();
	
	private static final FromTimestampFieldList FROM_TIMESTAMP_FIELD_LIST = new FromTimestampFieldList();
	private static final FromTimestampFieldArray FROM_TIMESTAMP_FIELD_ARRAY = new FromTimestampFieldArray();
	
	private static final FromLong FROM_LONG = new FromLong();
	
	private static final FromLongFieldList FROM_LONG_FIELD_LIST = new FromLongFieldList();
	private static final FromLongFieldArray FROM_LONG_FIELD_ARRAY = new FromLongFieldArray();
	
	private ToPeriod() {
		super();
	}
	
	// Conversion from two date objects
	public static final FromDateFieldList fromDateFieldList() {
		return FROM_DATE_FIELD_LIST;
	}	
	public static final FromDateFieldList fromDateFieldList(final Chronology chronology) {
		return new FromDateFieldList(chronology);
	}	
	public static final FromDateFieldList fromDateFieldList(final PeriodType periodType) {
		return new FromDateFieldList(periodType);
	}
	public static final FromDateFieldArray fromDateFieldArray() {
		return FROM_DATE_FIELD_ARRAY;
	}	
	public static final FromDateFieldArray fromDateFieldArray(final Chronology chronology) {
		return new FromDateFieldArray(chronology);
	}	
	public static final FromDateFieldArray fromDateFieldArray(final PeriodType periodType) {
		return new FromDateFieldArray(periodType);
	}
	//
	
	// Conversion from two timestamp objects
	public static final FromTimestampFieldList fromTimestampFieldList() {
		return FROM_TIMESTAMP_FIELD_LIST;
	}	
	public static final FromTimestampFieldList fromTimestampFieldList(final Chronology chronology) {
		return new FromTimestampFieldList(chronology);
	}	
	public static final FromTimestampFieldList fromTimestampFieldList(final PeriodType periodType) {
		return new FromTimestampFieldList(periodType);
	}
	public static final FromTimestampFieldArray fromTimestampFieldArray() {
		return FROM_TIMESTAMP_FIELD_ARRAY;
	}	
	public static final FromTimestampFieldArray fromTimestampFieldArray(final Chronology chronology) {
		return new FromTimestampFieldArray(chronology);
	}	
	public static final FromTimestampFieldArray fromTimestampFieldArray(final PeriodType periodType) {
		return new FromTimestampFieldArray(periodType);
	}
	//
	
	// Conversion from Long
	public static final FromLong fromLong() {
		return FROM_LONG;
	}
	public static final FromLong fromLong(final Chronology chronology) {
		return new FromLong(chronology);
	}
	public static final FromLong fromLong(final PeriodType periodType) {
		return new FromLong(periodType);
	}
	public static final FromLong fromLong(final PeriodType periodType, final Chronology chronology) {
		return new FromLong(periodType, chronology);
	}
	//
	
	// Conversion from two long objects
	public static final FromLongFieldList fromLongFieldList() {
		return FROM_LONG_FIELD_LIST;
	}	
	public static final FromLongFieldList fromLongFieldList(final Chronology chronology) {
		return new FromLongFieldList(chronology);
	}	
	public static final FromLongFieldList fromLongFieldList(final PeriodType periodType) {
		return new FromLongFieldList(periodType);
	}
	public static final FromLongFieldList fromLongFieldList(final PeriodType periodType, final Chronology chronology) {
		return new FromLongFieldList(periodType, chronology);
	}
	public static final FromLongFieldArray fromLongFieldArray() {
		return FROM_LONG_FIELD_ARRAY;
	}	
	public static final FromLongFieldArray fromLongFieldArray(final Chronology chronology) {
		return new FromLongFieldArray(chronology);
	}	
	public static final FromLongFieldArray fromLongFieldArray(final PeriodType periodType) {
		return new FromLongFieldArray(periodType);
	}
	public static final FromLongFieldArray fromLongFieldArray(final PeriodType periodType, final Chronology chronology) {
		return new FromLongFieldArray(periodType, chronology);
	}
	//
	
	
	
	
	public static final class FromDateFieldList implements IFunc<Period, List<Date>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromDateFieldList() {
			super();			
		}		
		
		public FromDateFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromDateFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Date> dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromDateFieldArray implements IFunc<Period, Date[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromDateFieldArray() {
			super();			
		}		
		
		public FromDateFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromDateFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Date[] dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromTimestampFieldList implements IFunc<Period, List<Timestamp>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromTimestampFieldList() {
			super();			
		}		
		
		public FromTimestampFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromTimestampFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Timestamp> dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromTimestampFieldArray implements IFunc<Period, Timestamp[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromTimestampFieldArray() {
			super();			
		}		
		
		public FromTimestampFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromTimestampFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Timestamp[] dates) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromLong implements IFunc<Period, Long> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromLong() {
			super();			
		}		
		
		public FromLong(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromLong(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public FromLong(PeriodType periodType, Chronology chronology) {
			super();	
			this.periodType = periodType;
			this.chronology = chronology;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Long theLong) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromLongFieldList implements IFunc<Period, List<Long>> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromLongFieldList() {
			super();			
		}		
		
		public FromLongFieldList(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromLongFieldList(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public FromLongFieldList(PeriodType periodType, Chronology chronology) {
			super();		
			this.periodType = periodType;
			this.chronology = chronology;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final List<Long> longs) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
	
	public static final class FromLongFieldArray implements IFunc<Period, Long[]> {

		private Chronology chronology = null;
		private PeriodType periodType = null;
		
		public FromLongFieldArray() {
			super();			
		}		
		
		public FromLongFieldArray(Chronology chronology) {
			super();		
			this.chronology = chronology;
		}
		
		public FromLongFieldArray(PeriodType periodType) {
			super();		
			this.periodType = periodType;
		}
		
		public FromLongFieldArray(PeriodType periodType, Chronology chronology) {
			super();		
			this.periodType = periodType;
			this.chronology = chronology;
		}
		
		public Type<? super Period> getResultType() {
			return Types.forClass(Period.class);
		}

		public Period execute(final Long[] longs) throws Exception {
			//TODO Check size is two
			return null;
		}		
	}	
}
