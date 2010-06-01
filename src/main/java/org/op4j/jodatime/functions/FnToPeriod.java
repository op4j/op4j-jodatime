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

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.joda.time.Chronology;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.base.BaseDateTime;
import org.op4j.functions.Function;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez Labandeira
 *
 * @deprecated use {@link FnPeriod} instead
 */
@Deprecated
public final class FnToPeriod {
	
	private FnToPeriod() {
		super();
	}
	
	// Conversion from two date objects
	/**
	 * <p>
	 * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
	 * {@link Period} it creates
	 * </p>
	 * 
	 * @return the {@link Period} created from the input 
	 */
	public static final Function<Collection<? extends Date>, Period> fromDateFieldCollection() {
		return FnPeriod.dateFieldCollectionToPeriod();
	}	
	/**
	 * <p>
	 * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Collection<? extends Date>, Period> fromDateFieldCollection(final Chronology chronology) {
		return FnPeriod.dateFieldCollectionToPeriod(chronology);
	}	
	/**
	 * <p>
     * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Date>, Period> fromDateFieldCollection(final PeriodType periodType) {
		return FnPeriod.dateFieldCollectionToPeriod(periodType);
	}
	/**
	 * <p>
     * The function receives a {@link Collection} of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Date>, Period> fromDateFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.dateFieldCollectionToPeriod(periodType, chronology);
	}
	/**
	 * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input 
     */
	public static final <T extends Date> Function<T[], Period> fromDateFieldArray() {
		return FnPeriod.dateFieldArrayToPeriod();
	}	
	
	/**
	 * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Date> Function<T[], Period> fromDateFieldArray(final Chronology chronology) {
		return FnPeriod.dateFieldArrayToPeriod(chronology);
	}	
	
	/**
	 * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Date> Function<T[], Period> fromDateFieldArray(final PeriodType periodType) {
		return FnPeriod.dateFieldArrayToPeriod(periodType);
	}
	
	/**
	 * <p>
     * The function receives an Array of two {@link Date} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Date> Function<T[], Period> fromDateFieldArray(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.dateFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from two timestamp objects
	/**
	 * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Collection<Timestamp>, Period> fromTimestampFieldCollection() {
		return FnPeriod.timestampFieldCollectionToPeriod();
	}	
	
	/**
	 * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Timestamp>, Period> fromTimestampFieldCollection(final Chronology chronology) {
		return FnPeriod.timestampFieldCollectionToPeriod(chronology);
	}	
	
	/**
	 * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Timestamp>, Period> fromTimestampFieldCollection(final PeriodType periodType) {
		return FnPeriod.timestampFieldCollectionToPeriod(periodType);
	}
	
	/**
	 * <p>
     * The function receives a {@link Collection} of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Timestamp>, Period> fromTimestampFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.timestampFieldCollectionToPeriod(periodType, chronology);
	}
	
	/**
	 * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates
     * </p>
     * 
     * @return the {@link Period} created from the input 
     */
	public static final Function<Timestamp[], Period> fromTimestampFieldArray() {
		return FnPeriod.timestampFieldArrayToPeriod();
	}	
	
	/**
	 * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link Chronology}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Timestamp[], Period> fromTimestampFieldArray(final Chronology chronology) {
		return FnPeriod.timestampFieldArrayToPeriod(chronology);
	}	
	
	/**
	 * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the 
     * specified {@link PeriodType}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Timestamp[], Period> fromTimestampFieldArray(final PeriodType periodType) {
		return FnPeriod.timestampFieldArrayToPeriod(periodType);
	}
	
	/**
	 * <p>
     * The function receives an Array of two {@link Timestamp} elements used as the start and end of the
     * {@link Period} it creates. The {@link Period} will be created using the specified 
     * specified {@link PeriodType} and {@link Chronology}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Timestamp[], Period> fromTimestampFieldArray(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.timestampFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from Long
	/**
	 * <p>
	 * The function receives a Long representing the {@link Period} duration in milliseconds
	 * and creates a {@link Period} with such duration
	 * </p>
	 * 
	 * @return the {@link Period} created from the input
	 */
	public static final Function<Long, Period> fromLong() {
		return FnPeriod.longToPeriod();
	}
	/**
	 * <p>
	 * Creates a {@link Period} with the specified {@link Chronology} and, as the duration, the input
	 * received by this function (in milliseconds)
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Long, Period> fromLong(final Chronology chronology) {
		return FnPeriod.longToPeriod(chronology);
	}
	/**
	 * <p>
	 * Creates a {@link Period} with the specified {@link PeriodType} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
	 * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Long, Period> fromLong(final PeriodType periodType) {
		return FnPeriod.longToPeriod(periodType);
	}
	/**
	 * <p>
	 * Creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology} and, as the duration, the input
     * received by this function (in milliseconds)
     * </p>
     * 
	 * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Long, Period> fromLong(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.longToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from two long objects
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @return the {@link Period} created from the input 
	 */
	public static final Function<Collection<Long>, Period> fromLongFieldCollection() {
		return FnPeriod.longFieldCollectionToPeriod();
	}	
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Collection<Long>, Period> fromLongFieldCollection(final Chronology chronology) {
		return FnPeriod.longFieldCollectionToPeriod(chronology);
	}	
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Collection<Long>, Period> fromLongFieldCollection(final PeriodType periodType) {
		return FnPeriod.longFieldCollectionToPeriod(periodType);
	}
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Collection<Long>, Period> fromLongFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.longFieldCollectionToPeriod(periodType, chronology);
	}
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 *  
	 * @return the {@link Period} created from the input
	 */
	public static final Function<Long[], Period> fromLongFieldArray() {
		return FnPeriod.longFieldArrayToPeriod();
	}	
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Long[], Period> fromLongFieldArray(final Chronology chronology) {
		return FnPeriod.longFieldArrayToPeriod(chronology);
	}	
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Long[], Period> fromLongFieldArray(final PeriodType periodType) {
		return FnPeriod.longFieldArrayToPeriod(periodType);
	}
	/**
	 * <p>
	 * The given {@link Long} targets representing the time in milliseconds will be used as the start
	 * and end instants of the {@link Period} returned 
	 * </p>
	 * 
	 * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
	 * @param chronology {@link Chronology} to be used 
	 * 
	 * @return the {@link Period} created from the input and arguments 
	 */
	public static final Function<Long[], Period> fromLongFieldArray(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.longFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from two calendar objects
	/**
	 * <p>
	 * It creates a {@link Period} represented by the given start and end instants. The input received by the {@link Function}
	 * must have size 2
	 * </p>
	 * 
	 * @return the {@link Period} created from the input
	 */
	public static final Function<Collection<? extends Calendar>, Period> fromCalendarFieldCollection() {
		return FnPeriod.calendarFieldCollectionToPeriod();
	}	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Calendar>, Period> fromCalendarFieldCollection(final Chronology chronology) {
		return FnPeriod.calendarFieldCollectionToPeriod(chronology);
	}	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Calendar>, Period> fromCalendarFieldCollection(final PeriodType periodType) {
		return FnPeriod.calendarFieldCollectionToPeriod(periodType);
	}
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends Calendar>, Period> fromCalendarFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.calendarFieldCollectionToPeriod(periodType, chronology);
	}
	/**
	 * <p>
	 * It creates a {@link Period} represented by the given start and end instants 
	 * </p>
	 * 
	 * @return the {@link Period} created from the input 
	 */
	public static final <T extends Calendar> Function<T[], Period> fromCalendarFieldArray() {
		return FnPeriod.calendarFieldArrayToPeriod();
	}	
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Calendar> Function<T[], Period> fromCalendarFieldArray(final Chronology chronology) {
		return FnPeriod.calendarFieldArrayToPeriod(chronology);
	}	
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Calendar> Function<T[], Period> fromCalendarFieldArray(final PeriodType periodType) {
		return FnPeriod.calendarFieldArrayToPeriod(periodType);
	}
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends Calendar> Function<T[], Period> fromCalendarFieldArray(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.calendarFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	// Conversion from two datetime objects
	/**
	 * <p>
	 * It creates a {@link Period} represented by the given start and end instants
	 * </p>
	 * 
	 * @return the {@link Period} created from the input 
	 */
	public static final Function<Collection<? extends BaseDateTime>, Period> fromBaseDateTimeFieldCollection() {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod();
	}	
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> fromBaseDateTimeFieldCollection(final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod(chronology);
	}	
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> fromBaseDateTimeFieldCollection(final PeriodType periodType) {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod(periodType);
	}
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<? extends BaseDateTime>, Period> fromBaseDateTimeFieldCollection(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldCollectionToPeriod(periodType, chronology);
	}
	
	/**
	 * <p>
     * It creates a {@link Period} represented by the given start and end instants
     * </p>
     * 
     * @return the {@link Period} created from the input
     */
	public static final <T extends BaseDateTime> Function<T[], Period> fromBaseDateTimeFieldArray() {
		return FnPeriod.baseDateTimeFieldArrayToPeriod();
	}	
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> fromBaseDateTimeFieldArray(final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldArrayToPeriod(chronology);
	}	
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> fromBaseDateTimeFieldArray(final PeriodType periodType) {
		return FnPeriod.baseDateTimeFieldArrayToPeriod(periodType);
	}
	
	/**
	 * <p>
     * It creates a {@link Period} with the specified {@link PeriodType} and {@link Chronology}. The input received by the {@link Function} 
     * must have size 2 and represents the start and end instants of the {@link Period}
     * </p>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @param chronology {@link Chronology} to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final <T extends BaseDateTime> Function<T[], Period> fromBaseDateTimeFieldArray(final PeriodType periodType, final Chronology chronology) {
		return FnPeriod.baseDateTimeFieldArrayToPeriod(periodType, chronology);
	}
	//
	
	/**
	 * <p>
	 * It creates a Period either:
	 * </p>
	 * <ul>	  
	 * <li>From a {@link Collection} of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
	 * <li>From a {@link Collection} of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
	 * </ul>
	 * 
	 * @return the {@link Period} created from the input 
	 */
	public static final Function<Collection<Integer>, Period> fromIntegerFieldCollection() {
		return FnPeriod.integerFieldCollectionToPeriod();
	}
	
	/**
	 * <p>
     * It creates a Period with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From a {@link Collection} of {@link Integer} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link Integer} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<Integer>, Period> fromIntegerFieldCollection(PeriodType periodType) {
		return FnPeriod.integerFieldCollectionToPeriod(periodType);
	}
	
	/**
	 * <p>
     * It creates a Period either:
     * </p>
     * <ul>   
     * <li>From an Integer[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From an Integer[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @return the {@link Period} created from the input
     */
	public static final Function<Integer[], Period> fromIntegerFieldArray() {
		return FnPeriod.integerFieldArrayToPeriod();
	}
	
	/**
	 * <p>
     * It creates a Period with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From an Integer[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From an Integer[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Integer[], Period> fromIntegerFieldArray(PeriodType periodType) {
		return FnPeriod.integerFieldArrayToPeriod(periodType);
	}
	
	/**
	 * <p>
	 * A Period is created either:
	 * </p>
	 * <ul>	  
	 * <li>From a {@link Collection} of {@link String} representing the hours, minutes, seconds and milliseconds</li>
	 * <li>From a {@link Collection} of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
	 * </ul>
	 * 
	 * @return the {@link Period} created from the input
	 */
	public static final Function<Collection<String>, Period> fromStringFieldCollection() {
		return FnPeriod.strFieldCollectionToPeriod();
	}
	
	/**
	 * <p>
     * A Period is created with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From a {@link Collection} of {@link String} representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a {@link Collection} of {@link String} representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<Collection<String>, Period> fromStringFieldCollection(PeriodType periodType) {
		return FnPeriod.strFieldCollectionToPeriod(periodType);
	}
	
	/**
	 * <p>
     * A Period is created either:
     * </p>
     * <ul>   
     * <li>From a String[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a String[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @return the {@link Period} created from the input  
     */
	public static final Function<String[], Period> fromStringFieldArray() {
		return FnPeriod.strFieldArrayToPeriod();
	}
	
	/**
	 * <p>
     * A Period is created with the specified {@link PeriodType} either:
     * </p>
     * <ul>   
     * <li>From a String[] representing the hours, minutes, seconds and milliseconds</li>
     * <li>From a String[] representing the years, months, weeks, days, hours, minutes, seconds and milliseconds</li>
     * </ul>
     * 
     * @param periodType the {@link PeriodType} to be created. It specifies which duration fields are to be used 
     * @return the {@link Period} created from the input and arguments 
     */
	public static final Function<String[], Period> fromStringFieldArray(PeriodType periodType) {
		return FnPeriod.strFieldArrayToPeriod(periodType);
	}
}
