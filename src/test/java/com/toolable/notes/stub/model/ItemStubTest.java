package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Test;

import java.util.Collections;

/**
 * Unit tests of {@link ItemStub}
 *
 * @author jonathan
 */
public class ItemStubTest {

    /**
     * All method of a {@link ItemStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new ItemStub("fieldName", Collections.emptyList()));
    }
}
