package com.toolable.notes.stub;

import com.toolable.notes.stub.exception.RecycledObjectException;
import lotus.domino.NotesException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Unit tests of {@link DateTimeStub}
 *
 * @author jonathan
 */
public class DateTimeStubTest {

    /**
     * Create a random date
     *
     * @param excludes Date to exclude
     * @return A random date that is not present in {@code excludes}
     */
    public static DateTime createRandomDate(DateTime... excludes) {

        DateTime date;

        Set<DateTime> excluded = new HashSet<DateTime>(Arrays.asList(excludes));

        do {
            date = new DateTime(new Random().nextLong());
        } while (excluded.contains(date));

        return date;
    }

    private DateTime now;

    /**
     * Mock the current time
     */
    @Before
    public void setUp() {
        this.now = new DateTime(2015, 3, 14, 9, 26, 53, 590); // (PI day)
        DateTimeUtils.setCurrentMillisFixed(this.now.getMillis());
        Assert.assertEquals(this.now, DateTime.now());
    }

    /**
     * Restore the real current time
     */
    @After
    public void tearDown() {
        DateTimeUtils.setCurrentMillisSystem();
    }

    /**
     * All method of a {@link BaseStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        BaseStubTest.assertExceptionsRaisedOnRecycledObject(new DateTimeStub());
    }

    /**
     * AThe default value should be {@link DateTime#now()}
     */
    @Test
    public void testDefaultDate() {
        DateTimeStub stub = NotesStub.createDateTime();
        Assert.assertEquals(this.now, stub.getValue());
    }

    /**
     * Assert that the default
     */
    @Test
    public void testFixedDate() {
        DateTimeStub stub = NotesStub.createDateTime(2016, 6, 21);
        Assert.assertEquals(new DateTime(2016, 6, 21, 0, 0, 0), stub.getValue());

        stub = NotesStub.createDateTime(2016, 6, 21, 12, 0, 42);
        Assert.assertEquals(new DateTime(2016, 6, 21, 12, 0, 42), stub.getValue());

        DateTime jodaTime = new DateTime(new Random().nextLong());
        stub = NotesStub.createDateTime(jodaTime);
        Assert.assertEquals(jodaTime, stub.getValue());
    }

    /**
     * The {@link DateTimeStub} should implement {@link lotus.domino.DateTime}
     */
    @Test
    public void testDominoInterface() {
        BaseStubTest.assertNotesInterface(DateTimeStub.class, lotus.domino.DateTime.class);
    }

    /**
     * It should be possible to compute time differences
     *
     * @throws NotesException Unexpected exception
     */
    @Test
    public void testTimeDifference() throws NotesException {
        DateTimeStub stub1 = NotesStub.createDateTime(2014, 12, 13, 11, 9, 3);
        DateTimeStub stub2 = NotesStub.createDateTime(2015, 1, 14, 12, 10, 4);

        int delta = (31 * 24 * 60 * 60) + (24 * 60 * 60) + (60 * 60) + 60 + 1;

        Assert.assertEquals(delta, stub2.timeDifference(stub1));
        Assert.assertEquals(delta, stub2.timeDifferenceDouble(stub1), 0d);

        Assert.assertEquals(-delta, stub1.timeDifference(stub2));
        Assert.assertEquals(-delta, stub1.timeDifferenceDouble(stub2), 0d);
    }

    /**
     * It should be possible to set the date
     */
    @Test
    public void testSetDate() {
        DateTimeStub stub1 = NotesStub.createDateTime();
        Assert.assertEquals(this.now, stub1.getValue());

        DateTime randomDay = createRandomDate(this.now);
        Assert.assertNotEquals(this.now, randomDay);

        stub1.setValue(randomDay);
        Assert.assertEquals(randomDay, stub1.getValue());
    }

    /**
     * It shoult be possible to change the date for the current instant
     */
    @Test
    public void testSetSetNow() {
        DateTimeStub stub = NotesStub.createDateTime(createRandomDate(this.now));

        Assert.assertNotEquals(this.now, stub.getValue());
        stub.setNow();
        Assert.assertEquals(this.now, stub.getValue());
    }

    /**
     * It should be possible to set a date-time at any time without impact of the day
     */
    @Test
    public void testSetAnyTime() {
        DateTime towelDay = new DateTime(2015, 5, 25, 0, 0, 0);

        DateTimeStub stub = NotesStub.createDateTime(towelDay);

        do {
            stub.setAnyTime();
        } while (stub.getValue().getMillisOfDay() == 0);

        Assert.assertNotEquals(towelDay, stub.getValue());
        Assert.assertEquals(towelDay, stub.getValue().withTime(0, 0, 0, 0));
    }

    /**
     * It should be possible to set the date-time at any date without impact of the time
     */
    @Test
    public void testSetAnyDate() {
        DateTime towelDay = new DateTime(2015, 5, 25, 0, 0, 0);

        DateTimeStub stub = NotesStub.createDateTime(towelDay);

        do {
            stub.setAnyDate();
        } while (stub.getValue().getYear() == 2015);

        Assert.assertNotEquals(towelDay, stub.getValue());
        Assert.assertEquals(towelDay, stub.getValue().withDate(2015, 5, 25));
    }

    /**
     * It should be possible to add/remove time
     */
    @Test
    public void testAdjustDate() {
        DateTime towelDay = new DateTime(2015, 5, 25, 0, 0, 0);
        DateTimeStub stub = NotesStub.createDateTime(towelDay);

        stub.adjustYear(3);
        stub.adjustMonth(3);
        stub.adjustDay(7);
        stub.adjustHour(6);
        stub.adjustMinute(6);
        stub.adjustSecond(6);

        Assert.assertEquals(new DateTime(2018, 9, 1, 6, 6, 6), stub.getValue());

        stub.adjustYear(-2);
        stub.adjustMonth(-2);
        stub.adjustDay(-2);
        stub.adjustHour(-5);
        stub.adjustMinute(-4);
        stub.adjustSecond(-3);

        Assert.assertEquals(new DateTime(2016, 6, 29, 1, 2, 3), stub.getValue());
    }

    /**
     * The parent session should be accessible
     */
    @Test
    public void testParent() {
        Assert.assertNotNull(NotesStub.createDateTime().getParent());
    }

    /**
     * It should be possible to create instance from a session
     */
    @Test
    public void testCreateFromSession() {
        SessionStub session = NotesStub.createSession();

        DateTimeStub stub1 = NotesStub.createDateTime();
        DateTimeStub stub2 = session.createDateTime();
        DateTimeStub stub3 = session.createDateTime(this.now.toDate());
        DateTimeStub stub4 = session.createDateTime(this.now.toCalendar(null));

        Assert.assertNotNull(stub1);
        Assert.assertNotNull(stub2);
        Assert.assertNotNull(stub3);
        Assert.assertNotNull(stub4);

        Assert.assertNotSame(session, stub1.getParent());
        Assert.assertSame(session, stub2.getParent());
        Assert.assertSame(session, stub3.getParent());
        Assert.assertSame(session, stub4.getParent());

        Assert.assertEquals(this.now, stub1.getValue());
        Assert.assertEquals(this.now, stub2.getValue());
        Assert.assertEquals(this.now, stub3.getValue());
        Assert.assertEquals(this.now, stub4.getValue());
    }

    /**
     * It should be possible to retrieve the date part
     */
    @Test
    public void testDateOnly() {
        DateTimeStub stub = NotesStub.createDateTime(2015, 3, 14, 9, 26, 53);
        Assert.assertEquals("03/14/2015", stub.getDateOnly());
        Assert.assertEquals("09:26:53", stub.getTimeOnly());
    }

    /**
     * It should be possible to retrieve the time part
     */
    @Test
    public void testToString() {
        Assert.assertEquals("DateTimeStub{value=" + this.now.toString() + "}", NotesStub.createDateTime().toString());
    }
}
