package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DatabaseImpl
import com.toolable.notes.stub.utils.cascadeRecyclingState
import com.toolable.notes.stub.utils.lazyParent

/**
 * Stub for [lotus.domino.Database]
 *
 * @author jonathan
 */
class DatabaseStub : BaseStub<DatabaseImpl> {
    override val implementation = DatabaseImpl(this)
    override var isRecycled by cascadeRecyclingState { documents.values }

    var session by lazyParent<DatabaseStub, SessionStub>(
            { SessionStub() },
            { databases -= this@DatabaseStub },
            { databases += this@DatabaseStub }
    )

    var documents = emptyMap<Unid, DocumentStub>()
        internal set

    var collections = emptyList<DocumentCollectionStub>()
        internal set

    operator fun get(unid: Unid) = documents[unid]
}