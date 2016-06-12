package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.RecycledObjectException
import lotus.domino.Base

/**
 * Base class of Lotus Notes stubs
 *
 * @author jonathan
 */
interface BaseStub<ImplType : Base> {

    val implementation: ImplType
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
