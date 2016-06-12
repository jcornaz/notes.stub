package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentImpl
import com.toolable.notes.stub.utils.lazyParent

/**
 * Stub for [lotus.domino.Document]
 *
 * @author jonathan
 */
class DocumentStub : BaseStub<DocumentImpl> {
    override val implementation = DocumentImpl(this)
    override var isRecycled = false

    var database: DatabaseStub by lazyParent({ DatabaseStub() }, { documents -= this@DocumentStub }, { documents += this@DocumentStub })

    var parentDocument: DocumentStub? = null

    var items = emptyList<ItemStub>()
        internal set
}