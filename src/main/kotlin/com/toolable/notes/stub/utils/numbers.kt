package com.toolable.notes.stub.utils

fun Double?.orZero() = if (this == null) 0.0 else this
fun Int?.orZero() = if (this == null) 0 else this