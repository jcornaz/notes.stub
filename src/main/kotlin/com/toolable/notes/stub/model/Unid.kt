package com.toolable.notes.stub.model

import kable.encoding.decodeFromHexadecimal
import kable.encoding.encodeToHexadecimal
import java.security.SecureRandom
import java.util.*

/**
 * Universal ID
 */
class Unid private constructor(val bytes: ByteArray) {

    /**
     * Hash code of the instance
     */
    val hash = Arrays.hashCode(bytes)

    /**
     * Construct an unid with an existing string
     */
    constructor(string: String) : this(string.decodeFromHexadecimal())

    override fun hashCode() = hash

    override fun equals(other: Any?): Boolean =
            other === this || (
                    other is Unid
                            && this.hash == other.hash
                            && Arrays.equals(this.bytes, other.bytes)
                    )

    override fun toString() = bytes.encodeToHexadecimal().toUpperCase()

    companion object {

        /**
         * Regular expression of a valid Unid
         */
        val REGEX = "[a-fA-F0-9]{32}".toRegex()

        /**
         * Random generator
         */
        var randomGenerator = SecureRandom()

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
            var result = Unid(ByteArray(16).apply { randomGenerator.nextBytes(this) })

            while (!register(result))
                result = Unid(ByteArray(16).apply { randomGenerator.nextBytes(this) })

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