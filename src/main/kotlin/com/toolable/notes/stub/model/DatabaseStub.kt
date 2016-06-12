package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DatabaseImpl

/**
 * Stub for [lotus.domino.Database]
 *
 * @author jonathan
 */
class DatabaseStub : BaseStub<DatabaseImpl> {
    override val implementation = DatabaseImpl(this)
    override var isRecycled = false
}