package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Test;

/**
 * Unit tests for {@link lotus.domino.Document]
 */
public class DocumentCollectionTest {

    /**
     * All method of a {@link com.toolable.notes.stub.impl.DocumentCollectionImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DocumentCollectionStub());
    }
}
