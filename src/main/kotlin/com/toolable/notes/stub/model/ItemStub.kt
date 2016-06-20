package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DateTimeImpl
import com.toolable.notes.stub.impl.ItemImpl
import com.toolable.notes.stub.utils.lazyParent
import com.toolable.notes.stub.utils.minus
import com.toolable.notes.stub.utils.orZero
import com.toolable.notes.stub.utils.toJodaTime
import lotus.domino.Item
import org.joda.time.DateTime

/**
 * Stub for [lotus.domino.Item]
 *
 * @constructor Create a new item
 * @property name Item name
 * @throws IllegalArgumentException The name is invalid
 */
class ItemStub(val name: String = DEFAULT_NAME) : BaseStub<ItemImpl> {

    companion object {

        /**
         * Default name for new item when not specified
         */
        @JvmStatic
        val DEFAULT_NAME = "ItemName"
    }

    init {
        if (!"^\\$?\\w+$".toRegex().matches(name))
            throw IllegalArgumentException("Invalid item name : \"$name\"")
    }

    /**
     * Create a new item
     *
     * @param document Parent document or null to have a new empty parent
     * @param name Item name
     */
    constructor(document: DocumentStub? = null, name: String = DEFAULT_NAME) : this(name) {
        if (document != null)
            this.document = document
    }

    /**
     * Create a new item with values
     *
     * @param document Parent document or null to have a new empty parent
     * @param name Item name
     * @param values String values
     */
    constructor(document: DocumentStub? = null, name: String = DEFAULT_NAME, vararg values: String) : this(document, name) {
        strings = values.asList()
    }


    /**
     * Create a new item with values
     *
     * @param document Parent document or null to have a new empty parent
     * @param name Item name
     * @param values Numeric values
     */
    constructor(document: DocumentStub? = null, name: String = DEFAULT_NAME, vararg values: Number) : this(document, name) {
        doubles = values.map { it.toDouble() }
    }

    /**
     * Create a new item with values
     *
     * @param document Parent document or null to have a new empty parent
     * @param name Item name
     * @param values Date-times values
     */
    constructor(document: DocumentStub? = null, name: String = DEFAULT_NAME, vararg values: DateTime) : this(document, name) {
        dateTimes = values.asList()
    }

    override val implementation = ItemImpl(this)
    override var isRecycled = false

    /**
     * Parent document
     */
    var document by lazyParent({ DocumentStub() }, { items -= name }, { items += name.toLowerCase() to this@ItemStub })

    /**
     * Parent session
     */
    val session: SessionStub
        get() = document.database.session

    /**
     * If the item is summary
     */
    var isSummary = true

    /**
     * If the item is encrypted
     */
    var isEncrypted = false

    /**
     * If the item is signed
     */
    var isSigned = false

    /**
     * If the item is protected
     */
    var isProtected = false

    /**
     * Values type
     */
    var type = Item.TEXT
        set(value) {
            field = value

            if ((value == Item.NUMBERS || value == Item.DATETIMES) && strings.isNotEmpty())
                strings = emptyList()
            else if (value != Item.NUMBERS && doubles.isNotEmpty())
                doubles = emptyList()
            else if (value != Item.DATETIMES && dateTimes.isNotEmpty())
                dateTimes = emptyList()
        }

    /**
     * String values. Empty list if the item type is not String.
     */
    var strings = emptyList<String>()
        set(values) {
            field = values
            if (values.isNotEmpty() && (type == Item.NUMBERS || type == Item.DATETIMES))
                type = Item.TEXT
        }

    /**
     * First string value. Null for no value or if the item is not text.
     */
    var string: String?
        get() = strings.firstOrNull()
        set(value) {
            strings = value?.let { listOf(it) } ?: emptyList()
        }

    /**
     * Doubles values. Empty list if the item is not numeric
     */
    var doubles = emptyList<Double>()
        set(values) {
            field = values
            if (values.isNotEmpty())
                type = Item.NUMBERS
        }

    /**
     * First double value. Null for no value or if the item is not numeric
     */
    var double: Double
        get() = doubles.firstOrNull().orZero()
        set(value) {
            doubles = listOf(value)
        }

    /**
     * Integer values. Empty list if the item is not numeric
     */
    var integers: List<Int>
        get() = doubles.map { it.toInt() }
        set(values) {
            doubles = values.map { it.toDouble() }
        }

    /**
     * First integer value. Null for no value or if the item is not numeric
     */
    var integer: Int
        get() = integers.firstOrNull().orZero()
        set(value) {
            integers = listOf(value)
        }

    /**
     * Date-times values. Empty list if the item is not date-time
     */
    var dateTimes = emptyList<DateTime>()
        set(values) {
            field = values
            if (values.isNotEmpty())
                type = Item.DATETIMES
        }

    /**
     * First date-time value. Null for no value or if the item is not date-time
     */
    var dateTime: DateTime?
        get() = dateTimes.firstOrNull()
        set(value) {
            dateTimes = value?.let { listOf(it) } ?: emptyList()
        }

    /**
     * Values. The value type will be [String], [Double] or [DateTime] depending on the item type
     */
    var values: List<Any>
        get() = if (type == Item.NUMBERS) doubles else if (type == Item.DATETIMES) dateTimes else strings
        set(values) {
            if (values.isEmpty())
                clear()
            else if (values[0] is String)
                strings = values.map { it as? String ?: throw IllegalArgumentException() }
            else if (values[0] is Number)
                doubles = values.map { (it as? Number ?: throw IllegalArgumentException()).toDouble() }
            else
                dateTimes = values.map {
                    if (it is DateTimeStub) it.value
                    else if (it is DateTimeImpl) it.stub.value
                    else if (it is DateTime) DateTime(it)
                    else if (it is lotus.domino.DateTime) it.toJodaTime()
                    else throw IllegalArgumentException()
                }
        }

    /**
     * Number of values
     */
    val size: Int
        get() = if (type == Item.DATETIMES) dateTimes.size else if (type == Item.NUMBERS) doubles.size else strings.size

    /**
     * True if, and only if, there is no value
     */
    val isEmpty: Boolean
        get() = size == 0

    /**
     * inverse of [isEmpty]
     */
    val isNotEmpty: Boolean
        get() = !isEmpty

    /**
     * If the item is authors
     */
    var isAuthors: Boolean
        get() = type == Item.AUTHORS
        set(value) {
            if (value)
                type = Item.AUTHORS
            else if (type == Item.AUTHORS)
                type = Item.TEXT
        }

    /**
     * If the item is readers
     */
    var isReaders: Boolean
        get() = type == Item.READERS
        set(value) {
            if (value)
                type = Item.READERS
            else if (type == Item.READERS)
                type = Item.TEXT
        }

    /**
     * If the item is names
     */
    var isNames: Boolean
        get() = type == Item.NAMES
        set(value) {
            if (value)
                type = Item.NAMES
            else if (type == Item.NAMES)
                type = Item.TEXT
        }

    /**
     * If the item data type is date-time
     */
    var isDateTime: Boolean
        get() = type == Item.DATETIMES
        set(value) {
            if (value)
                type = Item.DATETIMES
            else if (type == Item.DATETIMES)
                type = Item.TEXT
        }

    /**
     * If the item data type is numeric
     */
    var isNumeric: Boolean
        get() = type == Item.NUMBERS
        set(value) {
            if (value)
                type = Item.NUMBERS
            else if (type == Item.NUMBERS)
                type = Item.TEXT
        }

    /**
     * If the item data type is text
     */
    val isText: Boolean
        get() = type == Item.TEXT

    /**
     * Set the item data type to text
     */
    fun setText() {
        isNumeric = false
        isDateTime = false
    }

    /**
     * Remove all values
     */
    fun clear() {
        strings = emptyList()
        doubles = emptyList()
        dateTimes = emptyList()
    }

    /**
     * Copy the item
     *
     * @param document Destination document
     * @param name Name for the copied item
     * @return The created item
     * @throws IllegalArgumentException The name is invalid
     */
    @Throws(IllegalArgumentException::class)
    fun copy(document: DocumentStub, name: String = this.name) = ItemStub(document, name)
}