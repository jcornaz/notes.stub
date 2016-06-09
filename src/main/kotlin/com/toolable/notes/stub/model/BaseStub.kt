package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.utils.MutableLazyDelegate
import lotus.domino.Base
import java.util.*

/**
 * Base class of Lotus Notes stubs

 * @author jonathan
 */
open class BaseStub : Base {

    private var children: Collection<BaseStub> = listOf()
    var isRecycled: Boolean = false

    internal fun removeChild(child: BaseStub) {
        children = this.children.minus(child)
    }

    internal fun addChild(child: BaseStub) {
        children = this.children.plus(child)
    }

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
     * Recycle the object.
     *
     * After this method all Lotus Notes methods of this instance will raise [RecycledObjectException]
     */
    override fun recycle() {
        assertNotRecycled()

        this.children.forEach { it.recycle() }

        isRecycled = true
    }

    override fun recycle(vector: Vector<*>?) {
        assertNotRecycled()

        vector?.forEach { if (it is Base) it.recycle() }
    }
}

fun <ChildType : BaseStub, ParentType : BaseStub> lazyChildStub(child: ChildType, initializer: () -> ParentType) =
        MutableLazyDelegate<ChildType, ParentType>({
            val parent = initializer();
            parent.addChild(child);
            return@MutableLazyDelegate parent;
        }, { oldValue, newValue ->
            oldValue?.removeChild(child);
            newValue.addChild(child);
        })