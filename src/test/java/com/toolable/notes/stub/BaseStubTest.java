package com.toolable.notes.stub;

import com.toolable.notes.stub.exception.RecycledObjectException;
import lotus.domino.Base;
import lotus.domino.NotesException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

/**
 * Units tests for {@link BaseStub} and test utilities for derived classes
 *
 * @author jonathan
 */
public class BaseStubTest {

    /**
     * All method of a {@link BaseStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new BaseStub());
    }

    /**
     * The {@link BaseStub} should implement {@link lotus.domino.Base}
     */
    @Test
    public void testDominoInterface() {
        TestUtils.assertNotesInterface(BaseStub.class, lotus.domino.Base.class);
    }


    /**
     * Base object should be recyclables.<br />
     * A second recycle call should raise an {@link RecycledObjectException}
     *
     * @throws NotesException Unexpected exception
     */
    @Test
    public void testRecycling() throws NotesException {
        Base base = new BaseStub();

        try {
            base.recycle();
        } catch (RecycledObjectException e) {
            Assert.fail("No exception should be thrown on the first recycle");
        }

        try {
            base.recycle();
            Assert.fail("An exception should have been thrown on the second recycle");
        } catch (RecycledObjectException e) {
            // Expected exception
        }
    }

    /**
     * The recycling state of a {@link BaseStub} should be settable
     */
    @Test
    public void testSetRecycled() {
        BaseStub base = new BaseStub();

        base.setRecycled(true);
        Assert.assertTrue(base.isRecycled());

        try {
            base.recycle();
            Assert.fail("An exception should have be thrown if the instance as been set to a recycled state");
        } catch (RecycledObjectException e) {
            // Expected exception
        }

        base.setRecycled(false);
        try {
            base.recycle();
        } catch (RecycledObjectException e) {
            Assert.fail("No exception should be thrown if the instance as been set to a non-recycled state");
        }
    }

    /**
     * A list of Base object should be recycled by a call of {@link BaseStub#recycle(Vector)}
     *
     * @throws NotesException
     */
    @Test
    public void testBulkRecycling() throws NotesException {
        Vector<BaseStub> slaves = new Vector<BaseStub>();

        for (int i = 0; i < 10; i++) {
            slaves.add(new BaseStub());
        }

        BaseStub master = new BaseStub();
        master.recycle(slaves);

        // The object that made the call shouldn't be recycled
        Assert.assertFalse(master.isRecycled());

        for (BaseStub slave : slaves) {
            Assert.assertTrue(slave.isRecycled());
        }
    }

    /**
     * It should be easy to check if the recycling states of the NotesStubs
     */
    @Test
    public void testRecyclingAssertions() {
        BaseStub stub = new BaseStub();

        NotesStub.assertNotRecycled(stub);
        try {
            NotesStub.assertRecycled(stub);
            Assert.fail("An exception should have been thrown");
        } catch (AssertionError e) {
            // Expected exception
        }

        stub.setRecycled(true);

        NotesStub.assertRecycled(stub);
        try {
            NotesStub.assertNotRecycled(stub);
            Assert.fail("An exception should have been thrown");
        } catch (AssertionError e) {
            // Expected exception
        }
    }
}