package com.toolable.notes.stub.model

import com.google.common.base.Preconditions
import com.toolable.notes.stub.impl.DocumentImpl
import com.toolable.notes.stub.utils.MutableLazyDelegate
import com.toolable.notes.stub.utils.cascadeRecyclingState
import com.toolable.notes.stub.utils.lazyParent
import com.toolable.notes.stub.utils.minus
import org.joda.time.DateTime

/**
 * Stub for [lotus.domino.Document]
 *
 * @constructor Create a new document
 */
class DocumentStub() : BaseStub<DocumentImpl> {

    /**
     * Create a new document in the specified database
     */
    constructor(database: DatabaseStub) : this() {
        this.database = database
    }

    override val implementation = DocumentImpl(this)
    override var isRecycled by cascadeRecyclingState { items.values }

    /**
     * Parent database
     */
    var database by lazyParent({ DatabaseStub() }, { documents -= unid }, { documents += unid to this@DocumentStub })

    /**
     * Parent document if response.
     *
     * Null if not a response document.
     */
    var parentDocument: DocumentStub? = null
        set(value) {
            if (value == null) {
                this["\$ref"]?.document = DocumentStub()
            } else {
                this["\$ref"] = value.unid.toString()
            }
            field = value
        }

    /**
     * Items contained in the document
     */
    var items = emptyMap<String, ItemStub>()
        internal set

    /**
     * Universal ID of the document
     */
    var unid: Unid by MutableLazyDelegate({ Unid.generate() }, { old, new ->
        Preconditions.checkArgument(new !in database, "There is already a document with this unid it the document database")
        old?.let { database.documents -= it }
        database.documents += new to this
    })

    /**
     * If the document is saved or if it has not been modified from the notes implementation
     */
    var isSaved = true

    /**
     * Return the item with the specified name
     *
     * @param itemName Item name (case-insensitive)
     * @return The desired item or null if there is no item with that name
     */
    operator fun get(itemName: String) = items[itemName.toLowerCase()]

    /**
     * Replace an item value
     *
     * Create the item if it does not exist
     * @param itemName Name of the item to replace
     * @param values  New values for the item
     */
    operator fun set(itemName: String, values: List<Any>) {
        ItemStub(this, itemName).values = values
    }

    /**
     * Replace an item value
     *
     * Create the item if it does not exist
     * @param itemName Name of the item to replace
     * @param value  New values for the item
     */
    operator fun set(itemName: String, value: String) {
        (this[itemName] ?: ItemStub(this, itemName)).strings = listOf(value)
    }

    /**
     * Replace an item value
     *
     * Create the item if it does not exist
     * @param itemName Name of the item to replace
     * @param value  New values for the item
     */
    operator fun set(itemName: String, value: Number) {
        (this[itemName] ?: ItemStub(this, itemName)).doubles = listOf(value.toDouble())
    }

    /**
     * Replace an item value
     *
     * Create the item if it does not exist
     * @param itemName Name of the item to replace
     * @param value  New values for the item
     */
    operator fun set(itemName: String, value: DateTime) {
        (this[itemName] ?: ItemStub(this, itemName)).dateTimes = listOf(value)
    }

    /**
     * Check if the document contains a given item name
     *
     * @param itemName Name of the item
     * @return True if, and only if the documents contains an item with that name
     */
    operator fun contains(itemName: String) = itemName.toLowerCase() in items
}