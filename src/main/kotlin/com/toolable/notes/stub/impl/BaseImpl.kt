package com.toolable.notes.stub.impl

import com.toolable.notes.stub.model.BaseStub
import lotus.domino.Base
import java.util.*

/**
 * Base implementation for Lotus Notes objects
 */
open class BaseImpl<StubType : BaseStub<*>>(val stub: StubType) : Base {

    override fun recycle() {
        stub.assertNotRecycled()
        stub.isRecycled = true
    }

    override fun recycle(vector: Vector<*>?) {
        stub.assertNotRecycled()
        vector?.forEach { if (it is Base) it.recycle() }
    }
}