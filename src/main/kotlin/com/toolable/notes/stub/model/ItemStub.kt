package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.ItemImpl
import com.toolable.notes.stub.utils.CustomDelegates
import com.toolable.notes.stub.utils.minus
import lotus.domino.DateTime

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

    var document by CustomDelegates.lazyParent({ DocumentStub() }, { items -= name }, { items += name to this@ItemStub })

    var isSummary = true
    var isEncrypted = false
    var isSigned = false
    var isProtected = false

    var isAuthors = false
        set(value) {
            if (value) {
                if (isReaders) isReaders = false
                if (isNames) isNames = false
            }
            field = value
        }

    var isReaders = false
        set(value) {
            if (value) {
                if (isAuthors) isAuthors = false
                if (isNames) isNames = false
            }
            field = value
        }

    var isNames = false
        set(value) {
            if (value) {
                if (isAuthors) isAuthors = false
                if (isReaders) isReaders = false
            }
            field = value
        }

    fun copy(document: DocumentStub = this.document, name: String = this.name) = ItemStub(document, name, values)

    operator fun get(index: Int) = values[index]
}