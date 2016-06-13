package com.toolable.notes.stub.utils

import com.google.common.base.Preconditions

fun Double?.orZero() = if (this == null) 0.0 else this
fun Int?.orZero() = if (this == null) 0 else this

fun Int.toHexa(): String {
    val result = java.lang.Integer.toHexString(this)
    return if (result.length >= 8) result else (result.length..7).fold(result) { r, v -> '0' + r }
}

fun Long.toHexa(): String {
    var result = java.lang.Long.toHexString(this)
    return if (result.length >= 16) result else (result.length..15).fold(result) { r, v -> '0' + r }
}

fun String.toLongFromHexa(): Long {
    Preconditions.checkArgument("^[a-fA-F0-9]*$".toRegex().matches(this))

    return toUpperCase().fold(0L) { value, char ->
        value.shl(4) + if (char >= '0' && char <= '9') char - '0' else 10 + (char - 'A')
    }
}