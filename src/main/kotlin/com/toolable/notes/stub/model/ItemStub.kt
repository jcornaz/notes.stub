package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.ItemImpl
import com.toolable.notes.stub.utils.lazyParent
import com.toolable.notes.stub.utils.minus
import lotus.domino.DateTime
import lotus.domino.Item

/**
 * Stub for [lotus.domino.Item]
 *
 * @author jonathan
 */
data class ItemStub(val name: String, var values: ItemValues) : BaseStub<ItemImpl> {

    init {
        if (!"^\\w+$".toRegex().matches(name))
            throw IllegalArgumentException("Invalid item name : \"$name\"")
    }

    constructor(document: DocumentStub, name: String, values: ItemValues) : this(name, values) {
        this.document = document
    }

    @JvmOverloads
    constructor(document: DocumentStub? = null, name: String, value: String = "") : this(name, ItemValues(value)) {
        if (document != null)
            this.document = document
    }

    @JvmOverloads
    constructor(document: DocumentStub? = null, name: String, value: Number) : this(name, ItemValues(value)) {
        if (document != null)
            this.document = document
    }

    @JvmOverloads
    constructor(document: DocumentStub? = null, name: String, value: DateTime) : this(name, ItemValues(value)) {
        if (document != null)
            this.document = document
    }

    override val implementation = ItemImpl(this)
    override var isRecycled = false

    var document by lazyParent({ DocumentStub() }, { items -= name }, { items += name to this@ItemStub })

    var isSummary = true
    var isEncrypted = false
    var isSigned = false
    var isProtected = false

    var type = Item.TEXT

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

    fun copy(document: DocumentStub = this.document, name: String = this.name) = ItemStub(document, name, values)

    operator fun get(index: Int) = values[index]
}