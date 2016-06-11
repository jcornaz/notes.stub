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
     * All method of a {@link DatabaseStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DatabaseStub());
    }

    /**
     * A item stub should always have a parent. It could be set by code.
     */
    @Test
    public void testParent() {
        Assert.assertNotNull(new DatabaseStub().getParent());

        SessionStub parent = new SessionStub();
        DatabaseStub item = new DatabaseStub();
        item.setParent(parent);
        Assert.assertSame(parent, item.getParent());
    }
}
