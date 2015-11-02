package com.toolable.notes.stub;

import com.toolable.notes.stub.exception.NotImplementedException;
import lotus.domino.DateTime;
import lotus.domino.NotesException;
import lotus.domino.Session;

import java.util.Calendar;
import java.util.Date;

/**
 * The stub for {@link DateTime}
 *
 * @author jonathan
 */
public class DateTimeStub extends BaseStub implements DateTime {

    private org.joda.time.DateTime value;

    public DateTimeStub() {
        this(org.joda.time.DateTime.now());
    }

    public DateTimeStub(int year, int month, int day) {
        this(year, month, day, 0, 0, 0);
    }

    public DateTimeStub(int year, int month, int day, int hour, int minute, int second) {
        this(new org.joda.time.DateTime(year, month, day, hour, minute, second));
    }

    public DateTimeStub(long millis) {
        this(new org.joda.time.DateTime(millis));
    }

    public DateTimeStub(org.joda.time.DateTime value) {
        this.value = value;
    }

    @Override
    public void adjustHour(int hours) throws NotesException {
        this.assertNotRecycled();
        this.value = this.value.plusHours(hours);
    }

    @Override
    public void adjustHour(int hours, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustMinute(int minutes) throws NotesException {
        this.assertNotRecycled();
        this.value = this.value.plusMinutes(minutes);
    }

    @Override
    public void adjustMinute(int minutes, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustSecond(int seconds) throws NotesException {
        this.assertNotRecycled();
        this.value = this.value.plusSeconds(seconds);
    }

    @Override
    public void adjustSecond(int seconds, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustDay(int days) throws NotesException {
        this.assertNotRecycled();
        this.value = this.value.plusDays(days);
    }

    @Override
    public void adjustDay(int days, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustMonth(int months) throws NotesException {
        this.assertNotRecycled();
        this.value = this.value.plusMonths(months);
    }

    @Override
    public void adjustMonth(int months, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void adjustYear(int years) throws NotesException {
        this.assertNotRecycled();
        this.value = this.value.plusYears(years);
    }

    @Override
    public void adjustYear(int years, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void convertToZone(int i, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setAnyDate() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setAnyTime() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setNow() throws NotesException {
        this.assertNotRecycled();
        this.value = org.joda.time.DateTime.now();
    }

    @Override
    public int timeDifference(DateTime dateTime) throws NotesException {
        this.assertNotRecycled();
        return this.value.compareTo(new org.joda.time.DateTime(dateTime.toJavaDate()));
    }

    @Override
    public double timeDifferenceDouble(DateTime dateTime) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalDate(int i, int i1, int i2) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalDate(int i, int i1, int i2, boolean b) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(int i, int i1, int i2, int i3) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(Date date) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(Calendar calendar) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public String getGMTTime() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isDST() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public String getLocalTime() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public void setLocalTime(String s) throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public int getTimeZone() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public String getZoneTime() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public String getDateOnly() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public Session getParent() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public String getTimeOnly() throws NotesException {
        throw new NotImplementedException();
    }

    @Override
    public Date toJavaDate() throws NotesException {
        this.assertNotRecycled();
        return this.value.toDate();
    }
}
