package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentImpl
import com.toolable.notes.stub.utils.CustomDelegates

/**
 * Stub for [lotus.domino.Document]
 *
 * @author jonathan
 */
class DocumentStub : BaseStub<DocumentImpl> {
    override val implementation = DocumentImpl(this)
    override var isRecycled by CustomDelegates.cascadeRecyclingState { items }

    var database by CustomDelegates.lazyParent({ DatabaseStub() }, { documents -= this@DocumentStub }, { documents += this@DocumentStub })

    var parentDocument: DocumentStub? = null

    var items = emptyList<ItemStub>()
        internal set
}