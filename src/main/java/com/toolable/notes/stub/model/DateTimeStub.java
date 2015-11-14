package com.toolable.notes.stub.model;

import com.google.common.base.MoreObjects;
import com.toolable.notes.stub.NotesStub;
import com.toolable.notes.stub.exception.NotImplementedException;
import com.toolable.notes.stub.exception.RecycledObjectException;
import lotus.domino.DateTime;
import lotus.domino.NotesException;
import org.joda.time.format.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * The stub for {@link DateTime}
 *
 * @author jonathan
 * @see org.joda.time.DateTime
 */
public class DateTimeStub extends BaseStub implements DateTime {

    private org.joda.time.DateTime value;
    private SessionStub parent;

    /**
     * Construct a {@link DateTimeStub} that represent the current instant
     */
    public DateTimeStub() {
        this(org.joda.time.DateTime.now());
    }

    /**
     * Construct a {@link DateTimeStub} that represent a given value
     *
     * @param dateTime DateTime value to represent
     */
    public DateTimeStub(org.joda.time.DateTime dateTime) {
        this.value = dateTime;
    }

    /**
     * Construct a {@link DateTimeStub} that represent a given value
     *
     * @param session  Parent session
     * @param dateTime DateTime to represent
     */
    public DateTimeStub(SessionStub session, org.joda.time.DateTime dateTime) {
        this(dateTime);
        this.setParent(session);
    }

    /**
     * Get the {@link org.joda.time.DateTime} value represented by this instance
     *
     * @return DateTime value
     */
    public org.joda.time.DateTime getValue() {
        return this.value;
    }

    /**
     * Get the {@link org.joda.time.DateTime} value to represent with this instance
     *
     * @param dateTime DateTime to represent
     */
    public void setValue(org.joda.time.DateTime dateTime) {
        this.value = dateTime;
    }

    @Override
    public SessionStub getParent() {
        this.assertNotRecycled();

        if (this.parent == null)
            this.parent = NotesStub.createSession();

        return this.parent;
    }

    /**
     * Set the parent session
     *
     * @param parent Parent session
     * @see DateTimeStub#getParent()
     */
    public void setParent(SessionStub parent) {
        this.parent = parent;
    }

    @Override
    public void adjustHour(int hours) throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = this.value.plusHours(hours);
    }

    @Override
    public void adjustHour(int hours, boolean preserveLocalTime) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustMinute(int minutes) throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = this.value.plusMinutes(minutes);
    }

    @Override
    public void adjustMinute(int minutes, boolean preserveLocalTime) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustSecond(int seconds) throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = this.value.plusSeconds(seconds);
    }

    @Override
    public void adjustSecond(int seconds, boolean preserveLocalTime) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustDay(int days) throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = this.value.plusDays(days);
    }

    @Override
    public void adjustDay(int days, boolean preserveLocalTime) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustMonth(int months) throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = this.value.plusMonths(months);
    }

    @Override
    public void adjustMonth(int months, boolean preserveLocalTime) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustYear(int years) throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = this.value.plusYears(years);
    }

    @Override
    public void adjustYear(int years, boolean preserveLocalTime) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void convertToZone(int i, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setAnyDate() throws RecycledObjectException {
        this.assertNotRecycled();
        org.joda.time.DateTime randomDate = new org.joda.time.DateTime(new Random().nextLong());
        this.value = randomDate.withTime(this.value.getHourOfDay(), this.value.getMinuteOfHour(), this.value.getSecondOfMinute(), this.value.getMillisOfSecond());
    }

    @Override
    public void setAnyTime() throws RecycledObjectException {
        this.assertNotRecycled();
        org.joda.time.DateTime randomDate = new org.joda.time.DateTime(new Random().nextLong());
        this.value = randomDate.withDate(this.value.getYear(), this.value.getMonthOfYear(), this.value.getDayOfMonth());
    }

    @Override
    public void setNow() throws RecycledObjectException {
        this.assertNotRecycled();
        this.value = org.joda.time.DateTime.now();
    }

    @Override
    public int timeDifference(DateTime dateTime) throws NotesException {
        return (int) Math.round(this.timeDifferenceDouble(dateTime));
    }

    @Override
    public double timeDifferenceDouble(DateTime dateTime) throws NotesException {
        this.assertNotRecycled();
        return (this.value.getMillis() - new org.joda.time.DateTime(dateTime.toJavaDate()).getMillis()) / 1000d;
    }

    @Override
    public void setLocalDate(int i, int i1, int i2) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalDate(int i, int i1, int i2, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(int i, int i1, int i2, int i3) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(Date date) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(Calendar calendar) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getGMTTime() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isDST() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getLocalTime() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public int getTimeZone() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getZoneTime() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getDateOnly() throws RecycledObjectException {
        this.assertNotRecycled();
        return this.value.toString(DateTimeFormat.forPattern("MM/dd/yyyy"));
    }

    @Override
    public String getTimeOnly() throws RecycledObjectException {
        this.assertNotRecycled();
        return this.value.toString(DateTimeFormat.forPattern("HH:mm:ss"));
    }

    @Override
    public Date toJavaDate() throws NotImplementedException {
        this.assertNotRecycled();
        return this.value.toDate();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("value", this.value).toString();
    }
}
