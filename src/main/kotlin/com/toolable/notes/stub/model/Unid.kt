package com.toolable.notes.stub.model

import com.google.common.base.Preconditions
import com.toolable.notes.stub.utils.toHexa
import com.toolable.notes.stub.utils.toLongFromHexa
import java.util.*


data class Unid private constructor(private val leftPart: Long, private val rightPart: Long) {

    override fun toString() = (leftPart.toHexa() + rightPart.toHexa()).toUpperCase()

    companion object {
        val REGEX = "[a-fA-F0-9]{32}".toRegex()

        var random = Random()

        var knownUnids = emptyList<Unid>()
            private set

        fun parse(value: String): Unid {
            Preconditions.checkArgument(REGEX.matches(value))
            val leftPart = value.substring(0..15).toLowerCase().toLongFromHexa()
            val rightPart = value.substring(16..31).toLowerCase().toLongFromHexa()
            return Unid(leftPart, rightPart)
        }

        fun generate(): Unid {
            var result = Unid(random.nextLong(), random.nextLong())

            while (!register(result))
                result = Unid(random.nextLong(), random.nextLong())

            return result
        }

        fun register(unid: Unid): Boolean {

            var hasBeenRegistered = false

            synchronized(this) {
                hasBeenRegistered = unid !in knownUnids

                if (hasBeenRegistered)
                    knownUnids += unid
            }

            return hasBeenRegistered
        }
    }
}