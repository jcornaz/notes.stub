package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Assert;
import org.junit.Test;

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
        TestUtils.assertExceptionsRaisedOnRecycledObject(new ItemStub());
    }

    /**
     * A item stub should always have a parent. It could be set by code.
     */
    @Test
    public void testParent() {
        Assert.assertNotNull(new ItemStub().getParent());

        DocumentStub parent = new DocumentStub();
        ItemStub item = new ItemStub();
        item.setParent(parent);
        Assert.assertSame(parent, item.getParent());
    }
}
