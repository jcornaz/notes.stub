package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.Unid

/**
 * Convert this string to a [Unid]
 *
 * @throws IllegalArgumentException This string is not a valid unid
 * @return The [Unid] instance represented by this string
 */
@Throws(IllegalArgumentException::class)
fun String.toUnid() = Unid.parse(this)