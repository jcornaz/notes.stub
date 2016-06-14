package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.Unid

fun String.toUnid() = Unid.parse(this)