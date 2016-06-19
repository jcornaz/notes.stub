package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.RecycledObjectException
import lotus.domino.Base

/**
 * Base interface for all Lotus Notes stubs
 */
interface BaseStub<ImplType : Base> {

    /**
     * Notes implementation instance
     */
    val implementation: ImplType

    /**
     * True if this object should be considered as recycled by the implementation
     *
     * If true, all methods of the implementations will throw [RecycledObjectException]
     */
    var isRecycled: Boolean

    /**
     * Assert that the object is not recycled and raise an [RecycledObjectException] it's recycled
     *
     * @throws RecycledObjectException The object is marked as recycled and is no longer usable
     */
    @Throws(RecycledObjectException::class)
    fun assertNotRecycled() {
        if (isRecycled)
            throw RecycledObjectException()
    }
}
