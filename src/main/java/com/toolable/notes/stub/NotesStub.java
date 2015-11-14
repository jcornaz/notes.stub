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

    public static DateTimeStub createDateTime() {
        return new DateTimeStub();
    }

    public static DateTimeStub createDateTime(int year, int monthOfYear, int dayOfMonth) {
        return createDateTime(year, monthOfYear, dayOfMonth, 0, 0, 0);
    }

    public static DateTimeStub createDateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute) {
        return createDateTime(new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute));
    }

    public static DateTimeStub createDateTime(DateTime dateTime) {
        return new DateTimeStub(dateTime);
    }

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
