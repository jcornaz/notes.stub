package com.toolable.notes.stub.model

import com.google.common.base.Preconditions
import com.toolable.notes.stub.utils.toHexa
import com.toolable.notes.stub.utils.toLongFromHexa
import java.util.*

/**
 * Universal ID
 */
data class Unid private constructor(private val leftPart: Long, private val rightPart: Long) {

    override fun toString() = (leftPart.toHexa() + rightPart.toHexa()).toUpperCase()

    companion object {

        /**
         * Regular expression of a valid Unid
         */
        val REGEX = "[a-fA-F0-9]{32}".toRegex()

        /**
         * Random generator
         */
        var random = Random()

        /**
         * List of known unids
         */
        private val knownUnids = HashSet<Unid>()

        /**
         * Parse an String to return the [Unid] instance equivalent
         */
        @JvmStatic
        @Throws(IllegalArgumentException::class)
        fun parse(value: String): Unid {
            Preconditions.checkArgument(REGEX.matches(value), "Invalid universal id : \"$value\"")
            val leftPart = value.substring(0..15).toLowerCase().toLongFromHexa()
            val rightPart = value.substring(16..31).toLowerCase().toLongFromHexa()
            val unid = Unid(leftPart, rightPart)
            register(unid)
            return unid
        }

        /**
         * Create a new random unique [Unid]
         */
        @JvmStatic
        fun generate(): Unid {
            var result = Unid(random.nextLong(), random.nextLong())

            while (!register(result))
                result = Unid(random.nextLong(), random.nextLong())

            return result
        }

        /**
         * Register a new [Unid] in order to never generate it by [Unid.generate]
         *
         * @param unid Unid to register
         * @return True if, and only if, the unid wasn't knew.
         */
        @JvmStatic
        fun register(unid: Unid): Boolean {

            var hasBeenRegistered = false

            synchronized(this) {
                hasBeenRegistered = knownUnids.add(unid)
            }

            return hasBeenRegistered
        }
    }
}