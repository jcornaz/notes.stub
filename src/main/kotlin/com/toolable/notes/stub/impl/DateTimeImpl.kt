package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.DateTimeStub
import lotus.domino.DateTime
import lotus.domino.Session
import org.joda.time.format.DateTimeFormat
import java.util.*

/**
 * Implementation of [DateTime] with a stub
 */
class DateTimeImpl(stub: DateTimeStub) : BaseImpl<DateTimeStub>(stub), DateTime {

    @Throws(RecycledObjectException::class)
    override fun getParent(): Session {
        stub.assertNotRecycled()
        return stub.session.implementation
    }

    @Throws(RecycledObjectException::class)
    override fun adjustHour(hours: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusHours(hours)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustMinute(minutes: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusMinutes(minutes)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustSecond(seconds: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusSeconds(seconds)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustDay(days: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusDays(days)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustMonth(months: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusMonths(months)
    }

    @Throws(RecycledObjectException::class)
    override fun adjustYear(years: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusYears(years)
    }

    @Throws(RecycledObjectException::class)
    override fun setAnyDate() {
        stub.assertNotRecycled()
        val randomDate = org.joda.time.DateTime(Random().nextLong())
        stub.value = randomDate.withTime(stub.value.hourOfDay, stub.value.minuteOfHour, stub.value.secondOfMinute, stub.value.millisOfSecond)
    }

    @Throws(RecycledObjectException::class)
    override fun setAnyTime() {
        stub.assertNotRecycled()
        val randomDate = org.joda.time.DateTime(Random().nextLong())
        stub.value = randomDate.withDate(stub.value.year, stub.value.monthOfYear, stub.value.dayOfMonth)
    }

    @Throws(RecycledObjectException::class)
    override fun setNow() {
        stub.assertNotRecycled()
        stub.value = org.joda.time.DateTime.now()
    }

    @Throws(RecycledObjectException::class)
    override fun getDateOnly(): String {
        stub.assertNotRecycled()
        return stub.value.toString(DateTimeFormat.forPattern("MM/dd/yyyy"))
    }

    @Throws(RecycledObjectException::class)
    override fun getTimeOnly(): String {
        stub.assertNotRecycled()
        return stub.value.toString(DateTimeFormat.forPattern("HH:mm:ss"))
    }

    @Throws(RecycledObjectException::class)
    override fun toJavaDate(): Date {
        stub.assertNotRecycled()
        return stub.value.toDate()
    }

    @Throws(RecycledObjectException::class)
    override fun timeDifference(dateTime: DateTime): Int {
        stub.assertNotRecycled()
        return Math.round(this.timeDifferenceDouble(dateTime)).toInt()
    }

    @Throws(RecycledObjectException::class)
    override fun timeDifferenceDouble(dateTime: DateTime): Double {
        stub.assertNotRecycled()
        return (stub.value.millis - org.joda.time.DateTime(dateTime.toJavaDate()).millis) / 1000.0
    }

    @Throws(UnsupportedOperationException::class)
    override fun adjustDay(days: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun adjustMonth(months: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun adjustMinute(minutes: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun adjustSecond(seconds: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun adjustHour(hours: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun adjustYear(years: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun convertToZone(i: Int, b: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setLocalDate(i: Int, i1: Int, i2: Int) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setLocalDate(i: Int, i1: Int, i2: Int, b: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(i: Int, i1: Int, i2: Int, i3: Int) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(date: Date) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(calendar: Calendar) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getGMTTime(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isDST(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getLocalTime(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(s: String) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getTimeZone(): Int {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getZoneTime(): String {
        throw UnsupportedOperationException()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other) || stub.equals((other as? DateTimeImpl)?.stub)
    }

    override fun hashCode(): Int {
        return stub.hashCode()
    }
}