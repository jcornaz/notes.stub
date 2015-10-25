package com.toolable.notesstub.stub;

import com.toolable.notesstub.exceptions.RecycledObjectException;
import lotus.domino.Base;
import lotus.domino.NotesException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Vector;

/**
 * @author jonathan
 */
public class BaseStub implements Base {

    private boolean recycled;

    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }

    public boolean isRecycled() {
        return recycled;
    }

    @Override
    public void recycle() throws NotesException {
        this.assertNotRecycled();
        this.setRecycled(true);
    }

    @Override
    public void recycle(Vector vector) throws NotesException {
        throw new NotImplementedException();
    }

    protected void assertNotRecycled() throws RecycledObjectException {
        if( this.isRecycled() )
            throw new RecycledObjectException();
    }
}
