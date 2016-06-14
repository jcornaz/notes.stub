package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.Unid
import org.joda.time.DateTime

fun String.toUnid() = Unid.parse(this)

fun lotus.domino.DateTime.toJodaTime() = DateTime(this.toJavaDate())