package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Test;

/**
 * Unit tests of {@link SessionStub}
 *
 * @author jonathan
 */
public class SessionStubTest {

    /**
     * All method of a {@link com.toolable.notes.stub.impl.BaseImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new SessionStub());
    }
}
