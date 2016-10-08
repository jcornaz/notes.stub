package com.toolable.notes.stub.model

import java.math.BigInteger
import java.util.*

/**
 * Universal ID
 */
data class Unid private constructor(private val value: BigInteger) {

    constructor(string: String) : this(BigInteger(string, 16).apply {
        if (bitLength() > 128) throw IllegalArgumentException("Invalid Universal ID")
    })

    override fun toString() = String.format("%032X", value)

    companion object {

        /**
         * Regular expression of a valid Unid
         */
        val REGEX = "[a-fA-F0-9]{32}".toRegex()

        /**
         * Random generator
         */
        var randomGenerator = Random()

        /**
         * List of known unids
         */
        private val knownUnids = HashSet<Unid>()

        /**
         * Parse an String to return the [Unid] instance equivalent
         */
        @JvmStatic
        @Throws(IllegalArgumentException::class)
        fun parse(value: String): Unid = Unid(value)

        /**
         * Create a new random unique [Unid]
         */
        @JvmStatic
        fun generate(): Unid {
            var result = Unid(BigInteger(128, randomGenerator))

            while (!register(result))
                result = Unid(BigInteger(128, randomGenerator))

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