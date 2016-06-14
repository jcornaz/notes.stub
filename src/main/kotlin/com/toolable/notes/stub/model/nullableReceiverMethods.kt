package com.toolable.notes.stub.model

import com.toolable.notes.stub.utils.orZero
import org.joda.time.DateTime


fun ItemStub?.toInt() = if (this == null) 0 else (this[0] as? Number)?.toInt().orZero()
fun ItemStub?.toDouble() = if (this == null) 0.0 else (this[0] as? Number)?.toDouble().orZero()
fun ItemStub?.toString() = if (this == null) "" else (this[0] as? String).orEmpty()
fun ItemStub?.toDateTime() = if (this == null) null else this[0] as? DateTime
fun ItemStub?.toDateTimeStub() = if (this == null || !isDateTimes || isEmpty) null else DateTimeStub(session, this[0] as DateTime)