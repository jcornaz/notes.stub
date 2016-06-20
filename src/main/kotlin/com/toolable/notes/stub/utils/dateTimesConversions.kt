package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.DateTimeStub
import com.toolable.notes.stub.model.SessionStub
import org.joda.time.DateTime

/**
 * Return a stub for this date
 *
 * @param session Session for the date-time stub
 * @return A new [DateTimeStub]
 */
fun DateTime.toStub(session: SessionStub) = DateTimeStub(session, this)

/**
 * Return [DateTime] representation of this instance
 *
 * @return The [DateTime] represented by thie instance
 */
fun lotus.domino.DateTime.toJodaTime() = DateTime(this.toJavaDate())

