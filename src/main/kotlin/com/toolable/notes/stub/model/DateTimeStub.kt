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
class DateTimeStub(var value: org.joda.time.DateTime = org.joda.time.DateTime.now()) : BaseStub(), DateTime {

    var parent: SessionStub by lazyChildStub(this) { SessionStub() }

    constructor(session: SessionStub, value: org.joda.time.DateTime) : this(value) {
        parent = session
    }

    constructor(session: SessionStub, year: Int, month: Int, day: Int) : this(session, year, month, day, 0, 0, 0)

    constructor(session: SessionStub, year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int) : this(session, org.joda.time.DateTime(year, month, day, hour, minute, second))

    constructor(session: SessionStub, millis: Long) : this(session, org.joda.time.DateTime(millis))

    constructor(year: Int, month: Int, day: Int) : this(year, month, day, 0, 0, 0)

    constructor(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int) : this(org.joda.time.DateTime(year, month, day, hour, minute, second))

    constructor(millis: Long) : this(org.joda.time.DateTime(millis))

    override fun toString(): String {
        return "${javaClass.simpleName}{value=$value}"
    }

    @Throws(RecycledObjectException::class)
    override fun getParent(): Session {
        this.assertNotRecycled()
        return parent
    }

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
}
