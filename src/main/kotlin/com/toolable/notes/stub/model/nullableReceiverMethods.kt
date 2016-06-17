package com.toolable.notes.stub.model

import com.toolable.notes.stub.utils.orZero
import com.toolable.notes.stub.utils.toStub


fun ItemStub?.asInt() = this?.getInt(0).orZero()
fun ItemStub?.asDouble() = this?.getDouble(0).orZero()
fun ItemStub?.asString() = this?.getString(0)
fun ItemStub?.asDateTime() = this?.getDateTime(0)
fun ItemStub?.asDateTimeStub() = this?.asDateTime()?.toStub(session)