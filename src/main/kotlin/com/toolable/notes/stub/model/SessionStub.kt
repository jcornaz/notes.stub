package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.SessionImpl
import com.toolable.notes.stub.utils.CustomDelegates

/**
 * Stub for [lotus.domino.Session]
 *
 * @author jonathan
 */
class SessionStub : BaseStub<SessionImpl> {
    override val implementation = SessionImpl(this)
    override var isRecycled by CustomDelegates.cascadeRecyclingState { databaes + dates }

    var databaes = emptyList<DatabaseStub>()
        internal set

    var dates = emptyList<DateTimeStub>()
        internal set
}
