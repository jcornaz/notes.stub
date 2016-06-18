package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.Unid

@Throws(IllegalArgumentException::class)
fun String.toUnid() = Unid.parse(this)