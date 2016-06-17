package com.toolable.notes.stub.model

import com.toolable.notes.stub.utils.orZero
import com.toolable.notes.stub.utils.toStub
import org.joda.time.DateTime


fun ItemStub?.asInt() = (this?.get(0) as? Number)?.toInt().orZero()
fun ItemStub?.asDouble() = (this?.get(0) as? Number)?.toDouble().orZero()
fun ItemStub?.asString() = this?.get(0) as? String
fun ItemStub?.asDateTime() = this?.get(0) as? DateTime
fun ItemStub?.asDateTimeStub() = this?.asDateTime()?.toStub(session)