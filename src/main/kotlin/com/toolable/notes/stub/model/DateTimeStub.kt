package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DateTimeImpl

/**
 * Stub for [lotus.domino.DateTime]
 *
 * @constructor Construct a new instance for an arbitrary date
 * @param value Value (now by default)
 * @author jonathan
 */
class DateTimeStub(var value: org.joda.time.DateTime = org.joda.time.DateTime.now()) : BaseStub<DateTimeImpl> {

    override val implementation = DateTimeImpl(this)
    override var isRecycled = false

    /**
     * Construct a new instance for date defined by field values
     *
     * @param year Year
     * @param monthOfYear Month of year
     * @param dayOfMonth Day of month
     * @param hourOfDay Hour of day (0 by default)
     * @param minuteOfHour Minute of hour (0 by default)
     * @param secondOfMinute Second of second (0 by default)
     * @param millisOfSecond Millisecond of second (0 by default)
     */
    @JvmOverloads
    constructor(
            year: Int,
            monthOfYear: Int,
            dayOfMonth: Int,
            hourOfDay: Int = 0,
            minuteOfHour: Int = 0,
            secondOfMinute: Int = 0,
            millisOfSecond: Int = 0
    ) : this(org.joda.time.DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute, millisOfSecond))

    /**
     * Construct a new instance for a session and a date defined by milliseconds
     *
     * @param millis Number of milliseconds from the 01.01.1970 at 00:00:00
     */
    constructor(millis: Long) : this(org.joda.time.DateTime(millis))

    override fun toString() = "${javaClass.simpleName}(value=$value)"
}
