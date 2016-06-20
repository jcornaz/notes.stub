package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.DateTimeStub
import lotus.domino.DateTime
import lotus.domino.Session
import org.joda.time.format.DateTimeFormat
import java.util.*

/**
 * Implementation of [DateTime] with a stub
 *
 * @constructor Create a new implementation
 * @param stub Stub holding data for this implementation
 */
class DateTimeImpl(stub: DateTimeStub) : BaseImpl<DateTimeStub>(stub), DateTime {

    override fun equals(other: Any?): Boolean {
        return stub.equals((other as? DateTimeImpl)?.stub)
    }

    override fun hashCode(): Int {
        return stub.hashCode()
    }

    /**
     * Return the parent session
     *
     * @return The parent session
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getParent(): Session {
        stub.assertNotRecycled()
        return stub.session.implementation
    }

    /**
     * Edit the value by adding hours
     *
     * @param hours The amount of hours to add (a negative value will lead to substraction)
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun adjustHour(hours: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusHours(hours)
    }

    /**
     * Edit the value by adding minutes
     *
     * @param minutes The amount of minutes to add (a negative value will lead to substraction)
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun adjustMinute(minutes: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusMinutes(minutes)
    }

    /**
     * Edit the value by adding seconds
     *
     * @param seconds The amount of seconds to add (a negative value will lead to substraction)
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun adjustSecond(seconds: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusSeconds(seconds)
    }

    /**
     * Edit the value by adding days
     *
     * @param days The amount of days to add (a negative value will lead to substraction)
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun adjustDay(days: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusDays(days)
    }

    /**
     * Edit the value by adding months
     *
     * @param months The amount of months to add (a negative value will lead to substraction)
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun adjustMonth(months: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusMonths(months)
    }

    /**
     * Edit the value by adding years
     *
     * @param years The amount of years to add (a negative value will lead to substraction)
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun adjustYear(years: Int) {
        stub.assertNotRecycled()
        stub.value = stub.value.plusYears(years)
    }

    /**
     * Change date part for a random day
     *
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setAnyDate() {
        stub.assertNotRecycled()
        val randomDate = org.joda.time.DateTime(Random().nextLong())
        stub.value = randomDate.withTime(stub.value.hourOfDay, stub.value.minuteOfHour, stub.value.secondOfMinute, stub.value.millisOfSecond)
    }

    /**
     * Change time part for a random instant
     *
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setAnyTime() {
        stub.assertNotRecycled()
        val randomDate = org.joda.time.DateTime(Random().nextLong())
        stub.value = randomDate.withDate(stub.value.year, stub.value.monthOfYear, stub.value.dayOfMonth)
    }

    /**
     * Set the value at now
     *
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setNow() {
        stub.assertNotRecycled()
        stub.value = org.joda.time.DateTime.now()
    }

    /**
     * Return the date part
     *
     * @return A string that represent the date part
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getDateOnly(): String {
        stub.assertNotRecycled()
        return stub.value.toString(DateTimeFormat.forPattern("MM/dd/yyyy"))
    }

    /**
     * Return the time part
     *
     * @return A string that represent the time part
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getTimeOnly(): String {
        stub.assertNotRecycled()
        return stub.value.toString(DateTimeFormat.forPattern("HH:mm:ss"))
    }

    /**
     * Transform the value to a [Date]
     *
     * @return The [Date] version of the value
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun toJavaDate(): Date {
        stub.assertNotRecycled()
        return stub.value.toDate()
    }

    /**
     * Return the difference in seconds between this date and an another one
     *
     * @param dateTime The other date
     * @return The difference in seconds between the two dates in seconds
     *  * If the result is positive, this date is after the argument
     *  * If the result is negative, this date is before the argument
     *  * If the result is 0, both instances are equals
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun timeDifference(dateTime: DateTime): Int {
        stub.assertNotRecycled()
        return Math.round(this.timeDifferenceDouble(dateTime)).toInt()
    }

    /**
     * Return the difference in seconds (and fractions of seconds) between this date and another one
     *
     * @param dateTime The other date
     * @return The difference in seconds between the two dates in seconds
     *  * If the result is positive, this date is after the argument
     *  * If the result is negative, this date is before the argument
     *  * If the result is 0, both instances are equals
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun timeDifferenceDouble(dateTime: DateTime): Double {
        stub.assertNotRecycled()
        return (stub.value.millis - org.joda.time.DateTime(dateTime.toJavaDate()).millis) / 1000.0
    }

    /**
     * Return the difference in seconds between this date and another one
     *
     * @param dateTime The other date
     * @return The difference in seconds between the two dates.
     *  * If the result is positive, this date is after the argument.
     *  * If the result is negative, this date is before the argument.
     *  * If the result is 0, both instances are equals
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(UnsupportedOperationException::class)
    override fun adjustDay(days: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun adjustMonth(months: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun adjustMinute(minutes: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun adjustSecond(seconds: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun adjustHour(hours: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun adjustYear(years: Int, preserveLocalTime: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun convertToZone(i: Int, b: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setLocalDate(i: Int, i1: Int, i2: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setLocalDate(i: Int, i1: Int, i2: Int, b: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(i: Int, i1: Int, i2: Int, i3: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(date: Date) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(calendar: Calendar) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getGMTTime(): String {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isDST(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getLocalTime(): String {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setLocalTime(s: String) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getTimeZone(): Int {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getZoneTime(): String {
        throw UnsupportedOperationException()
    }
}