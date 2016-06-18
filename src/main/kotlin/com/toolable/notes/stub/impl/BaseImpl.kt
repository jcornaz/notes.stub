package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.BaseStub
import lotus.domino.Base
import java.util.*

/**
 * Base implementation for Lotus Notes objects
 */
open class BaseImpl<StubType : BaseStub<*>>(val stub: StubType) : Base {

    /**
     * Throw a [RecycledObjectException] if the object is recycled.
     * Do nothing if the object is not recycled
     *
     * @throws RecycledObjectException The object is recycled
     */
    @Throws(RecycledObjectException::class)
    fun assertNotRecycled() = stub.assertNotRecycled()

    /**
     * Recycle the object
     *
     * @throws RecycledObjectException The object is (already) recycled
     */
    @Throws(RecycledObjectException::class)
    override fun recycle() {
        assertNotRecycled()
        stub.isRecycled = true
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun recycle(vector: Vector<*>?) {
        throw UnsupportedOperationException()
    }
}