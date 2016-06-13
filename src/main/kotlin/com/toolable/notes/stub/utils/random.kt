package com.toolable.notes.stub.utils

import com.google.common.base.Preconditions
import java.util.*

fun Random.nextString(length: Int, characters: List<Char>): String {
    Preconditions.checkArgument(length > 0)
    Preconditions.checkArgument(characters.size > 0)

    return (1..length).fold("") { str, i -> str + characters[nextInt(characters.size)] }
}