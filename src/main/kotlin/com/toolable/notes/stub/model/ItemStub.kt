package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DateTimeImpl
import com.toolable.notes.stub.impl.ItemImpl
import com.toolable.notes.stub.utils.lazyParent
import com.toolable.notes.stub.utils.minus
import com.toolable.notes.stub.utils.toJodaTime
import com.toolable.notes.stub.utils.toStub
import lotus.domino.Item
import org.joda.time.DateTime

/**
 * Stub for [lotus.domino.Item]
 *
 * @author jonathan
 */
class ItemStub(val name: String = "ItemName") : BaseStub<ItemImpl> {

    var document by lazyParent({ DocumentStub() }, { items -= name }, { items += name to this@ItemStub })

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
            else if (value != Item.NUMBERS && numbers.isNotEmpty())
                numbers = emptyList()
            else if (value != Item.DATETIMES && dateTimes.isNotEmpty())
                dateTimes = emptyList()
        }

    var strings = emptyList<String>()
        get() =
        if (type == Item.NUMBERS) numbers.map { it.toString() }
        else if (type == Item.DATETIMES) dateTimes.map { it.toString() }
        else field
        set(values) {
            field = values
            if (values.isNotEmpty() && (type == Item.NUMBERS || type == Item.DATETIMES))
                type = Item.TEXT
        }

    var numbers = emptyList<Number>()
        set(values) {
            field = values
            if (values.isNotEmpty())
                type = Item.NUMBERS
        }

    var dateTimes = emptyList<DateTime>()
        get() =
        if (type == Item.DATETIMES) field
        else if (type == Item.NUMBERS) emptyList()
        else strings.map { it.toJodaTime() }
        set(values) {
            field = values
            if (values.isNotEmpty())
                type = Item.DATETIMES
        }

    var dateTimeStubs: List<DateTimeStub>
        get() = dateTimes.map { it.toStub(session) }
        set(values) {
            dateTimes = values.map { it.value }
        }

    var values: List<Any>
        get() = if (type == Item.NUMBERS) numbers else if (type == Item.DATETIMES) dateTimes else strings
        set(values) {
            if (values.isEmpty())
                clear()
            else if (values[0] is String)
                strings = values.filter { it is String }.map { it as String }
            else if (values[0] is Number)
                numbers = values.filter { it is Number }.map { it as Number }
            else
                dateTimes = values.filter { it is DateTimeStub || it is DateTime || it is lotus.domino.DateTime }.map {
                    if (it is DateTimeStub) it.value
                    else if (it is DateTimeImpl) it.stub.value
                    else if (it is DateTime) DateTime(it)
                    else (it as lotus.domino.DateTime).toJodaTime()
                }
        }

    val size: Int
        get() = if (type == Item.DATETIMES) dateTimes.size else if (type == Item.NUMBERS) numbers.size else strings.size

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

    var isDateTimes: Boolean
        get() = type == Item.DATETIMES
        set(value) {
            if (value)
                type = Item.DATETIMES
            else if (type == Item.DATETIMES)
                type = Item.TEXT
        }

    var isNumbers: Boolean
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
        if (!"^\\w+$".toRegex().matches(name))
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
        numbers = values.asList()
    }

    constructor(document: DocumentStub? = null, name: String, vararg values: DateTimeStub) : this(document, name) {
        dateTimes = values.map { it.value }
    }

    constructor(document: DocumentStub? = null, name: String, vararg values: DateTime) : this(document, name) {
        dateTimes = values.asList()
    }
    
    fun clear() {
        type = Item.TEXT
        strings = emptyList()
    }

    fun copy(document: DocumentStub, name: String = this.name) = ItemStub(document, name)

    operator fun get(index: Int): Any? {
        val list = if (type == Item.DATETIMES) dateTimes
        else if (type == Item.NUMBERS) numbers
        else strings

        return if (list.isEmpty() && index == 0) null else list[index]
    }
}