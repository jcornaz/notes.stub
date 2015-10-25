package com.toolable.notesstub.stub;

import com.toolable.notesstub.exceptions.RecycledObjectException;
import lotus.domino.Base;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Vector;

/**
 * Base class of Lotus Notes stubs
 * @author jonathan
 */
public class BaseStub implements Base {

    private boolean recycled;

    /**
     * Get the recycling state of the stub.<br />
     * {@code true} means the stub is recycled and {@link RecycledObjectException} will be thrown on Lotus Notes methods calls.
     * @return Recycling state of the stub.
     */
    public boolean isRecycled() {
        return recycled;
    }

    /**
     * Set the recycling state of the stub<br />
     * {@code true} means the stub is recycled and {@link RecycledObjectException} will be thrown on Lotus Notes methods calls.
     * @param recycled Recycling state of the stub.
     */
    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }

    /**
     * Assert that the object is not recycled and raise an {@link RecycledObjectException} it's recycled
     * @throws RecycledObjectException The object is marked as recycled and is no longer usable
     */
    protected void assertNotRecycled() throws RecycledObjectException {
        if (this.isRecycled())
            throw new RecycledObjectException();
    }

    /**
     * Recycle the object.<br />
     * After this method all Lotus Notes methods of this instance will raise {@link RecycledObjectException}
     */
    @Override
    public void recycle() {
        this.assertNotRecycled();
        this.setRecycled(true);
    }

    @Override
    public void recycle(Vector vector) {
        throw new NotImplementedException();
    }
}
