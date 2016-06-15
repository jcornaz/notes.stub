package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests of {@link DatabaseStub}
 *
 * @author jonathan
 */
public class DatabaseStubTest {

    /**
     * All method of a {@link com.toolable.notes.stub.impl.DatabaseImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DatabaseStub());
    }
}
