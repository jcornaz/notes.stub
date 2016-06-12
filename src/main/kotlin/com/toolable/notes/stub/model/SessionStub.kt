package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.SessionImpl

/**
 * Stub for [lotus.domino.Session]
 *
 * @author jonathan
 */
class SessionStub : BaseStub<SessionImpl> {
    override val implementation = SessionImpl(this)
    override var isRecycled = false

    var databaes = emptyList<DatabaseStub>()
        internal set

    var dates = emptyList<DateTimeStub>()
        internal set
}
