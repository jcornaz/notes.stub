package com.toolable.notes.stub.model;

import com.toolable.notes.stub.exception.RecycledObjectException;
import lotus.domino.Base;
import lotus.domino.NotesException;

import java.util.Vector;

/**
 * Base class of Lotus Notes stubs
 *
 * @author jonathan
 */
public class BaseStub implements Base {

    private boolean recycled;

    /**
     * <p>Get the recycling state of the stub.</p>
     * <p>{@code true} means the stub is recycled and {@link RecycledObjectException} will be thrown on Lotus Notes methods calls.</p>
     *
     * @return Recycling state of the stub.
     */
    public boolean isRecycled() {
        return recycled;
    }

    /**
     * <p>Set the recycling state of the stub</p>
     * <p>{@code true} means the stub is recycled and {@link RecycledObjectException} will be thrown on Lotus Notes methods calls.</p>
     *
     * @param recycled Recycling state of the stub.
     */
    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }

    /**
     * Assert that the object is not recycled and raise an {@link RecycledObjectException} it's recycled
     *
     * @throws RecycledObjectException The object is marked as recycled and is no longer usable
     */
    protected void assertNotRecycled() throws RecycledObjectException {
        if (this.isRecycled())
            throw new RecycledObjectException();
    }

    /**
     * <p>Recycle the object.</p>
     * <p>After this method all Lotus Notes methods of this instance will raise {@link RecycledObjectException}</p>
     */
    @Override
    public void recycle() {
        this.assertNotRecycled();
        this.setRecycled(true);
    }

    @Override
    public void recycle(Vector vector) throws NotesException {
        this.assertNotRecycled();
        for (Object obj : vector) {
            if (obj instanceof Base) {
                ((Base) obj).recycle();
            }
        }
    }
}
