package com.toolable.notes.stub.model

import com.toolable.notes.stub.utils.orZero
import com.toolable.notes.stub.utils.toStub
import org.joda.time.DateTime


fun ItemStub?.asInt() = if (this == null) 0 else (this[0] as? Number)?.toInt().orZero()
fun ItemStub?.asDouble() = if (this == null) 0.0 else (this[0] as? Number)?.toDouble().orZero()
fun ItemStub?.asString() = if (this == null) "" else (this[0] as? String).orEmpty()
fun ItemStub?.asDateTime() = if (this == null) null else this[0] as? DateTime
fun ItemStub?.asDateTimeStub() = if (this == null) null else asDateTime()?.toStub(session)