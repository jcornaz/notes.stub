package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DateTimeImpl
import com.toolable.notes.stub.impl.ItemImpl
import com.toolable.notes.stub.utils.*
import lotus.domino.Item
import org.joda.time.DateTime

/**
 * Stub for [lotus.domino.Item]
 *
 * @author jonathan
 */
class ItemStub(val name: String = "ItemName") : BaseStub<ItemImpl> {

    var document by lazyParent({ DocumentStub() }, { items -= name }, { items += name.toLowerCase() to this@ItemStub })

    override val implementation = ItemImpl(this)
    override var isRecycled = false

    val session: SessionStub
        get() = document.database.session

    var isSummary = true
    var isEncrypted = false
    var isSigned = false
    var isProtected = false

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

    var strings = emptyList<String>()
        set(values) {
            field = values
            if (values.isNotEmpty() && (type == Item.NUMBERS || type == Item.DATETIMES))
                type = Item.TEXT
        }

    var string: String?
        get() = strings.firstOrNull()
        set(value) {
            strings = value?.let { listOf(it) } ?: emptyList()
        }

    var doubles = emptyList<Double>()
        set(values) {
            field = values
            if (values.isNotEmpty())
                type = Item.NUMBERS
        }

    var double: Double
        get() = doubles.firstOrNull().orZero()
        set(value) {
            doubles = listOf(value)
        }

    var integers: List<Int>
        get() = doubles.map { it.toInt() }
        set(values) {
            doubles = values.map { it.toDouble() }
        }

    var integer: Int
        get() = integers.firstOrNull().orZero()
        set(value) {
            integers = listOf(value)
        }

    var dateTimes = emptyList<DateTime>()
        set(values) {
            field = values
            if (values.isNotEmpty())
                type = Item.DATETIMES
        }

    var dateTime: DateTime?
        get() = dateTimes.firstOrNull()
        set(value) {
            dateTimes = value?.let { listOf(it) } ?: emptyList()
        }

    var dateTimeStubs: List<DateTimeStub>
        get() = dateTimes.map { it.toStub(session) }
        set(values) {
            dateTimes = values.map { it.value }
        }

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

    val size: Int
        get() = if (type == Item.DATETIMES) dateTimes.size else if (type == Item.NUMBERS) doubles.size else strings.size

    val isEmpty: Boolean
        get() = size == 0

    val isNotEmpty: Boolean
        get() = !isEmpty

    var isAuthors: Boolean
        get() = type == Item.AUTHORS
        set(value) {
            if (value)
                type = Item.AUTHORS
            else if (type == Item.AUTHORS)
                type = Item.TEXT
        }

    var isReaders: Boolean
        get() = type == Item.READERS
        set(value) {
            if (value)
                type = Item.READERS
            else if (type == Item.READERS)
                type = Item.TEXT
        }

    var isNames: Boolean
        get() = type == Item.NAMES
        set(value) {
            if (value)
                type = Item.NAMES
            else if (type == Item.NAMES)
                type = Item.TEXT
        }

    var isDateTime: Boolean
        get() = type == Item.DATETIMES
        set(value) {
            if (value)
                type = Item.DATETIMES
            else if (type == Item.DATETIMES)
                type = Item.TEXT
        }

    var isNumeric: Boolean
        get() = type == Item.NUMBERS
        set(value) {
            if (value)
                type = Item.NUMBERS
            else if (type == Item.NUMBERS)
                type = Item.TEXT
        }

    val isText: Boolean
        get() = type == Item.TEXT

    init {
        if (!"^\\$?\\w+$".toRegex().matches(name))
            throw IllegalArgumentException("Invalid item name : \"$name\"")
    }

    constructor(document: DocumentStub?, name: String) : this(name) {
        if (document != null)
            this.document = document
    }

    constructor(document: DocumentStub? = null, name: String, vararg values: String) : this(document, name) {
        strings = values.asList()
    }

    constructor(document: DocumentStub? = null, name: String, vararg values: Number) : this(document, name) {
        doubles = values.map { it.toDouble() }
    }

    constructor(document: DocumentStub? = null, name: String, vararg values: DateTime) : this(document, name) {
        dateTimes = values.asList()
    }

    fun setText() {
        isNumeric = false
        isDateTime = false
    }

    fun clear() {
        strings = emptyList()
        doubles = emptyList()
        dateTimes = emptyList()
    }

    fun copy(document: DocumentStub, name: String = this.name) = ItemStub(document, name)

    operator fun get(index: Int): Any? {

        val list = if (type == Item.DATETIMES) dateTimes
        else if (type == Item.NUMBERS) doubles
        else strings

        return if (list.isEmpty() && index == 0) null else list[index]
    }
}