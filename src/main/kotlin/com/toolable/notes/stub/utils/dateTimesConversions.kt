package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.DateTimeStub
import com.toolable.notes.stub.model.SessionStub
import org.joda.time.DateTime
import java.util.*

fun DateTime.toStub() = DateTimeStub(this)
fun DateTime.toStub(session: SessionStub) = DateTimeStub(session, this)

fun Date.toJodaTime() = DateTime(this)
fun String.toJodaTime() = DateTime.parse(this)
fun lotus.domino.DateTime.toJodaTime() = DateTime(this.toJavaDate())

fun Date.toStub() = toJodaTime().toStub()
fun Date.toStub(session: SessionStub) = toJodaTime().toStub(session)
