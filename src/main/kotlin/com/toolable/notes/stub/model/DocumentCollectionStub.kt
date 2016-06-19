package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentCollectionImpl
import com.toolable.notes.stub.utils.lazyParent

/**
 * Stub for [lotus.domino.DocumentCollection]
 */
data class DocumentCollectionStub(val documents: MutableList<DocumentStub> = emptyList<DocumentStub>().toMutableList()) : BaseStub<DocumentCollectionImpl>, MutableList<DocumentStub> by documents {
    override val implementation = DocumentCollectionImpl(this)
    override var isRecycled = false

    var database by lazyParent(
            { DatabaseStub() },
            { collections = collections.minusElement(this@DocumentCollectionStub) },
            { collections = collections.minusElement(this@DocumentCollectionStub) }
    )
}