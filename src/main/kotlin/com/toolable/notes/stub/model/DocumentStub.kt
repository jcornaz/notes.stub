package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentImpl
import com.toolable.notes.stub.utils.CustomDelegates
import com.toolable.notes.stub.utils.MutableLazyDelegate
import com.toolable.notes.stub.utils.minus

/**
 * Stub for [lotus.domino.Document]
 *
 * @author jonathan
 */
class DocumentStub : BaseStub<DocumentImpl> {
    override val implementation = DocumentImpl(this)
    override var isRecycled by CustomDelegates.cascadeRecyclingState { items.values }

    var database by CustomDelegates.lazyParent({ DatabaseStub() }, { documents -= unid }, { documents += unid to this@DocumentStub })

    var parentDocument: DocumentStub? = null

    var items = emptyMap<String, ItemStub>()
        internal set

    var unid: Unid by MutableLazyDelegate({ Unid.generate() }, { old, new -> Unid.register(new) })
}