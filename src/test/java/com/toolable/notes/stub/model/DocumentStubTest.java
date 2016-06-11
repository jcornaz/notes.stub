package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests of {@link DocumentStub}
 *
 * @author jonathan
 */
public class DocumentStubTest {

    /**
     * All method of a {@link DocumentStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DocumentStub());
    }

    /**
     * A document stub should always have a parent. It could be set by code.
     */
    @Test
    public void testParent() {
        Assert.assertNotNull(new DocumentStub().getParentDatabase());

        DatabaseStub parent = new DatabaseStub();
        DocumentStub item = new DocumentStub();
        item.setParentDatabase(parent);
        Assert.assertSame(parent, item.getParentDatabase());
    }
}
