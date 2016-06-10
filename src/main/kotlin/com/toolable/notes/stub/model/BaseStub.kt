package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.utils.MutableLazyDelegate
import lotus.domino.Base
import java.util.*

/**
 * Base class of Lotus Notes stubs
 *
 * @author jonathan
 */
open class BaseStub : Base {

    var isRecycled: Boolean = false

    private var children: Collection<BaseStub> = listOf()

    /**
     * Remove a child
     *
     * @param child Child to remove
     */
    internal fun removeChild(child: BaseStub) {
        children = children.minus(child)
    }

    /**
     * Add a child
     *
     * @param child Child to remove
     */
    internal fun addChild(child: BaseStub) {
        children = children.plus(child)
    }

    /**
     * Assert that the object is not recycled and raise an [RecycledObjectException] it's recycled
     *
     * @throws RecycledObjectException The object is marked as recycled and is no longer usable
     */
    @Throws(RecycledObjectException::class)
    protected fun assertNotRecycled() {
        if (isRecycled)
            throw RecycledObjectException()
    }

    //region Implemented methods
    override fun recycle() {
        assertNotRecycled()

        children.forEach { it.recycle() }

        isRecycled = true
    }

    override fun recycle(vector: Vector<*>?) {
        assertNotRecycled()

        vector?.forEach { if (it is Base) it.recycle() }
    }
    //endregion
}

/**
 * Create a property delegate that is lazy, mutable and that inform the parent of the new attribution as a child
 *
 * @param child Child instance (to transmit to the parent)
 * @param initializer Instantiation of a new Parent
 */
fun <ChildType : BaseStub, ParentType : BaseStub> lazyChildStub(child: ChildType, initializer: () -> ParentType) =
        MutableLazyDelegate<ChildType, ParentType>({
            val parent = initializer();
            parent.addChild(child);
            return@MutableLazyDelegate parent;
        }, { oldValue, newValue ->
            oldValue?.removeChild(child);
            newValue.addChild(child);
        })