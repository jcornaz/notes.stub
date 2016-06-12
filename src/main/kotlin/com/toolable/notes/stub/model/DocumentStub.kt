package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentImpl

/**
 * Stub for [lotus.domino.Document]
 *
 * @author jonathan
 */
class DocumentStub : BaseStub<DocumentImpl> {
    override val implementation = DocumentImpl(this)
    override var isRecycled = false
}