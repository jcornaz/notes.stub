package com.toolable.notes.stub;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Main Class</p>
 * <p>Can create and retrieve all the needed utilities</p>
 *
 * @author jonathan
 */
public final class NotesStub {

    /**
     * Assert that notes objects are recycled
     *
     * @param stubs {@link NotesStub} objects to check
     * @throws AssertionError If one or more stubs are not recycled
     */
    public static void assertRecycled(BaseStub... stubs) throws AssertionError {
        assertRecycled(Arrays.asList(stubs));
    }

    /**
     * Assert that notes objects are recycled
     *
     * @param stubs {@link NotesStub} objects to check
     * @throws AssertionError If one or more stubs are not recycled
     */
    public static void assertRecycled(List<? extends BaseStub> stubs) throws AssertionError {
        for (BaseStub stub : stubs)
            if (!stub.isRecycled())
                throw new AssertionError();
    }

    /**
     * Assert that notes objects are not recycled
     *
     * @param stubs {@link NotesStub} objects to check
     * @throws AssertionError If one or more stubs are recycled
     */
    public static void assertNotRecycled(BaseStub... stubs) throws AssertionError {
        assertNotRecycled(Arrays.asList(stubs));
    }

    /**
     * Assert that notes objects are not recycled
     *
     * @param stubs {@link NotesStub} objects to check
     * @throws AssertionError If one or more stubs are recycled
     */
    public static void assertNotRecycled(List<? extends BaseStub> stubs) throws AssertionError {
        for (BaseStub stub : stubs)
            if (stub.isRecycled())
                throw new AssertionError();
    }

    /**
     * Create a {@link DateTimeStub} that represent the current instant
     *
     * @return {@link DateTimeStub} created
     */
    public static DateTimeStub createDateTime() {
        return new DateTimeStub();
    }

    /**
     * Create a {@link DateTimeStub} that represent a given date
     *
     * @param year        Year
     * @param monthOfYear Month of year
     * @param dayOfMonth  Day of month
     * @return {@link DateTimeStub} created
     */
    public static DateTimeStub createDateTime(int year, int monthOfYear, int dayOfMonth) {
        return createDateTime(year, monthOfYear, dayOfMonth, 0, 0, 0);
    }

    /**
     * Create a {@link DateTimeStub} that represent a given instant
     *
     * @param year           Year
     * @param monthOfYear    Month of year
     * @param dayOfMonth     Day of month
     * @param hourOfDay      Hour of day
     * @param minuteOfHour   Minute of hour
     * @param secondOfMinute Second of minute
     * @return {@link DateTimeStub} created
     */
    public static DateTimeStub createDateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute) {
        return createDateTime(new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute));
    }

    /**
     * Create a {@link DateTimeStub} that represent a given date and time
     *
     * @param dateTime Date and time
     * @return {@link DateTimeStub} created
     */
    public static DateTimeStub createDateTime(DateTime dateTime) {
        return new DateTimeStub(dateTime);
    }

    /**
     * Create a {@link SessionStub}
     *
     * @return {@link SessionStub} created
     */
    public static SessionStub createSession() {
        return new SessionStub();
    }

    /**
     * Private constructor
     */
    private NotesStub() {
        // Helper class
    }
}
