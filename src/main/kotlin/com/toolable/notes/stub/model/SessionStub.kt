package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.SessionImpl
import com.toolable.notes.stub.utils.cascadeRecyclingState

/**
 * Stub for [lotus.domino.Session]
 *
 * @author jonathan
 */
class SessionStub : BaseStub<SessionImpl> {
    override val implementation = SessionImpl(this)
    override var isRecycled by cascadeRecyclingState { databases + dates }

    /**
     * Databases opened by this session
     */
    var databases = emptyList<DatabaseStub>()
        internal set

    /**
     * Date-times linked to this session
     */
    var dates = emptyList<DateTimeStub>()
        internal set
}
