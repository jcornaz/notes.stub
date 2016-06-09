package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.RecycledObjectException
import lotus.domino.Base
import lotus.domino.NotesException
import java.util.*

/**
 * Base class of Lotus Notes stubs

 * @author jonathan
 */
open class BaseStub : Base {


    var isRecycled: Boolean = false

    /**
     * Assert that the object is not recycled and raise an [RecycledObjectException] it's recycled

     * @throws RecycledObjectException The object is marked as recycled and is no longer usable
     */
    @Throws(RecycledObjectException::class)
    protected fun assertNotRecycled() {
        if (isRecycled)
            throw RecycledObjectException()
    }

    /**
     *
     * Recycle the object.
     *
     * After this method all Lotus Notes methods of this instance will raise [RecycledObjectException]
     */
    override fun recycle() {
        assertNotRecycled()

        isRecycled = true
    }

    override fun recycle(vector: Vector<*>?) {
        assertNotRecycled()

        vector?.forEach { if (it is Base) it.recycle() }
    }
}
