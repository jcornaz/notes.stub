package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.DateTimeImpl;
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
    private static DateTime createRandomDate(DateTime... excludes) {

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
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DateTimeStub());
    }

    /**
     * AThe default value should be {@link DateTime#now()}
     */
    @Test
    public void testDefaultDate() {
        DateTimeStub stub = new DateTimeStub();
        Assert.assertEquals(this.now, stub.getValue());
    }

    /**
     * Assert that the default
     */
    @Test
    public void testFixedDate() {
        DateTimeStub stub = new DateTimeStub(2016, 6, 21);
        Assert.assertEquals(new DateTime(2016, 6, 21, 0, 0, 0), stub.getValue());

        stub = new DateTimeStub(2016, 6, 21, 12, 0, 42);
        Assert.assertEquals(new DateTime(2016, 6, 21, 12, 0, 42), stub.getValue());

        DateTime jodaTime = new DateTime(new Random().nextLong());
        stub = new DateTimeStub(jodaTime);
        Assert.assertEquals(jodaTime, stub.getValue());
    }

    /**
     * It should be possible to compute time differences
     *
     * @throws NotesException Unexpected exception
     */
    @Test
    public void testTimeDifference() throws NotesException {
        DateTimeStub stub1 = new DateTimeStub(2014, 12, 13, 11, 9, 3);
        DateTimeStub stub2 = new DateTimeStub(2015, 1, 14, 12, 10, 4);

        int delta = (31 * 24 * 60 * 60) + (24 * 60 * 60) + (60 * 60) + 60 + 1;

        Assert.assertEquals(delta, stub2.getImplementation().timeDifference(stub1.getImplementation()));
        Assert.assertEquals(delta, stub2.getImplementation().timeDifferenceDouble(stub1.getImplementation()), 0d);

        Assert.assertEquals(-delta, stub1.getImplementation().timeDifference(stub2.getImplementation()));
        Assert.assertEquals(-delta, stub1.getImplementation().timeDifferenceDouble(stub2.getImplementation()), 0d);
    }

    /**
     * It should be possible to set the date
     */
    @Test
    public void testSetDate() {
        DateTimeStub stub1 = new DateTimeStub();
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
        DateTimeStub stub = new DateTimeStub(createRandomDate(this.now));

        Assert.assertNotEquals(this.now, stub.getValue());
        stub.getImplementation().setNow();
        Assert.assertEquals(this.now, stub.getValue());
    }

    /**
     * It should be possible to set a date-time at any time without impact of the day
     */
    @Test
    public void testSetAnyTime() {
        DateTime towelDay = new DateTime(2015, 5, 25, 0, 0, 0);

        DateTimeStub stub = new DateTimeStub(towelDay);

        do {
            stub.getImplementation().setAnyTime();
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

        DateTimeStub stub = new DateTimeStub(towelDay);

        do {
            stub.getImplementation().setAnyDate();
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
        DateTimeStub stub = new DateTimeStub(towelDay);

        DateTimeImpl impl = stub.getImplementation();
        impl.adjustYear(3);
        impl.adjustMonth(3);
        impl.adjustDay(7);
        impl.adjustHour(6);
        impl.adjustMinute(6);
        impl.adjustSecond(6);

        Assert.assertEquals(new DateTime(2018, 9, 1, 6, 6, 6), stub.getValue());

        impl.adjustYear(-2);
        impl.adjustMonth(-2);
        impl.adjustDay(-2);
        impl.adjustHour(-5);
        impl.adjustMinute(-4);
        impl.adjustSecond(-3);

        Assert.assertEquals(new DateTime(2016, 6, 29, 1, 2, 3), stub.getValue());
    }

    /**
     * It should be possible to retrieve the date part
     */
    @Test
    public void testDateOnly() {
        DateTimeStub stub = new DateTimeStub(2015, 3, 14, 9, 26, 53);
        Assert.assertEquals("03/14/2015", stub.getImplementation().getDateOnly());
        Assert.assertEquals("09:26:53", stub.getImplementation().getTimeOnly());
    }

    /**
     * It should be possible to retrieve the time part
     */
    @Test
    public void testToString() {
        Assert.assertEquals("DateTimeStub(value=" + this.now.toString() + ")", new DateTimeStub().toString());
    }
}
