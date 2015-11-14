package com.toolable.notes.stub;

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
     * Private constructor
     */
    private NotesStub() {
        // Helper class
    }
}
