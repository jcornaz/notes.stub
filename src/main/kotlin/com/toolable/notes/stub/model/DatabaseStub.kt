package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DatabaseImpl
import com.toolable.notes.stub.utils.CustomDelegates

/**
 * Stub for [lotus.domino.Database]
 *
 * @author jonathan
 */
class DatabaseStub : BaseStub<DatabaseImpl> {
    override val implementation = DatabaseImpl(this)
    override var isRecycled by CustomDelegates.cascadeRecyclingState { documents.values }

    var session by CustomDelegates.lazyParent<DatabaseStub, SessionStub>(
            { SessionStub() },
            { databaes -= this@DatabaseStub },
            { databaes += this@DatabaseStub }
    )

    var documents = emptyMap<Unid, DocumentStub>()
        internal set
}