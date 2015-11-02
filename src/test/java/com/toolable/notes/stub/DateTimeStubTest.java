package com.toolable.notes.stub;

import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Test;

/**
 * @author jonathan
 */
public class DateTimeStubTest {

    /**
     * all method of a {@link BaseStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        BaseStubTest.assertExceptionsRaisedOnRecycledObject(new BaseStub());
    }
}
