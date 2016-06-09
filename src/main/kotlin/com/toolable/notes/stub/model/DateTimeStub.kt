package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.NotImplementedException
import com.toolable.notes.stub.exception.RecycledObjectException
import lotus.domino.DateTime
import lotus.domino.Session
import org.joda.time.format.DateTimeFormat
import java.util.*

/**
 * The stub for [DateTime]

 * @author jonathan
 */
class DateTimeStub(var value: org.joda.time.DateTime = org.joda.time.DateTime.now()) : BaseStub(), DateTime, Comparable<DateTime> {

    //region Secondary constructors
    constructor(session: SessionStub, value: org.joda.time.DateTime) : this(value) {
        parent = session
    }

    @JvmOverloads
    constructor(
            session: SessionStub,
            year: Int,
            monthOfYear: Int,
            dayOfMonth: Int,
            hourOfDay: Int = 0,
            minuteOfHour: Int = 0,
            secondOfMinute: Int = 0,
            millisOfSecond: Int = 0
    ) : this(session, org.joda.time.DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute, millisOfSecond))

    constructor(session: SessionStub, millis: Long) : this(session, org.joda.time.DateTime(millis))

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

    constructor(millis: Long) : this(org.joda.time.DateTime(millis))
    //endregion

    //region toString(), hashCode() and equals()
    override fun toString(): String {
        return "${javaClass.simpleName}{value=$value}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as DateTimeStub

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
    //endregion

    //region Parent
    var parent: SessionStub by lazyChildStub(this) { SessionStub() }

    @Throws(RecycledObjectException::class)
    override fun getParent(): Session {
        this.assertNotRecycled()
        return parent
    }
    //endregion

    //region Adjust
    @Throws(RecycledObjectException::class)
    override fun adjustHour(hours: Int) {
        this.assertNotRecycled()
        this.value = this.value.plusHours(hours)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustMinute(minutes: Int) {
        this.assertNotRecycled()
        this.value = this.value.plusMinutes(minutes)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustSecond(seconds: Int) {
        this.assertNotRecycled()
        this.value = this.value.plusSeconds(seconds)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustDay(days: Int) {
        this.assertNotRecycled()
        this.value = this.value.plusDays(days)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustMonth(months: Int) {
        this.assertNotRecycled()
        this.value = this.value.plusMonths(months)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustYear(years: Int) {
        this.assertNotRecycled()
        this.value = this.value.plusYears(years)
    }
    //endregion

    //region Set
    @Throws(RecycledObjectException::class)
    override fun setAnyDate() {
        this.assertNotRecycled()
        val randomDate = org.joda.time.DateTime(Random().nextLong())
        this.value = randomDate.withTime(this.value.hourOfDay, this.value.minuteOfHour, this.value.secondOfMinute, this.value.millisOfSecond)
    }

    @Throws(RecycledObjectException::class)
    override fun setAnyTime() {
        this.assertNotRecycled()
        val randomDate = org.joda.time.DateTime(Random().nextLong())
        this.value = randomDate.withDate(this.value.year, this.value.monthOfYear, this.value.dayOfMonth)
    }

    @Throws(RecycledObjectException::class)
    override fun setNow() {
        this.assertNotRecycled()
        this.value = org.joda.time.DateTime.now()
    }
    //endregion

    //region Get
    @Throws(RecycledObjectException::class)
    override fun getDateOnly(): String {
        this.assertNotRecycled()
        return this.value.toString(DateTimeFormat.forPattern("MM/dd/yyyy"))
    }

    @Throws(RecycledObjectException::class)
    override fun getTimeOnly(): String {
        this.assertNotRecycled()
        return this.value.toString(DateTimeFormat.forPattern("HH:mm:ss"))
    }

    @Throws(NotImplementedException::class)
    override fun toJavaDate(): Date {
        this.assertNotRecycled()
        return this.value.toDate()
    }
    //endregion

    //region Difference
    @Throws(RecycledObjectException::class)
    override fun timeDifference(dateTime: DateTime): Int {
        this.assertNotRecycled()
        return Math.round(this.timeDifferenceDouble(dateTime)).toInt()
    }

    @Throws(RecycledObjectException::class)
    override fun timeDifferenceDouble(dateTime: DateTime): Double {
        this.assertNotRecycled()
        return (this.value.millis - org.joda.time.DateTime(dateTime.toJavaDate()).millis) / 1000.0
    }

    override fun compareTo(other: DateTime) = timeDifference(other)
    //endregion

    //region Not implemented methods
    @Throws(NotImplementedException::class)
    override fun adjustDay(days: Int, preserveLocalTime: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun adjustMonth(months: Int, preserveLocalTime: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun adjustMinute(minutes: Int, preserveLocalTime: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun adjustSecond(seconds: Int, preserveLocalTime: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun adjustHour(hours: Int, preserveLocalTime: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun adjustYear(years: Int, preserveLocalTime: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun convertToZone(i: Int, b: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setLocalDate(i: Int, i1: Int, i2: Int) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setLocalDate(i: Int, i1: Int, i2: Int, b: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setLocalTime(i: Int, i1: Int, i2: Int, i3: Int) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setLocalTime(date: Date) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setLocalTime(calendar: Calendar) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getGMTTime(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isDST(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getLocalTime(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setLocalTime(s: String) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getTimeZone(): Int {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getZoneTime(): String {
        throw NotImplementedException()
    }
    //endregion
}
