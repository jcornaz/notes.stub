package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DatabaseImpl
import com.toolable.notes.stub.utils.lazyParent

/**
 * Stub for [lotus.domino.Database]
 *
 * @author jonathan
 */
class DatabaseStub : BaseStub<DatabaseImpl> {
    override val implementation = DatabaseImpl(this)
    override var isRecycled = false

    var session: SessionStub by lazyParent<DatabaseStub, SessionStub>(
            { SessionStub() },
            { databaes -= this@DatabaseStub },
            { databaes += this@DatabaseStub }
    )

    var documents = emptyList<DocumentStub>()
        internal set
}