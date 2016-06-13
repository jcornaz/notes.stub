package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentCollectionImpl
import com.toolable.notes.stub.utils.CustomDelegates

data class DocumentCollectionStub(var documents: List<DocumentStub>) : BaseStub<DocumentCollectionImpl>, List<DocumentStub> by documents {
    override val implementation = DocumentCollectionImpl(this)
    override var isRecycled = false

    var database by CustomDelegates.lazyParent({ DatabaseStub() }, { collections -= this@DocumentCollectionStub }, { collections += this@DocumentCollectionStub })
}