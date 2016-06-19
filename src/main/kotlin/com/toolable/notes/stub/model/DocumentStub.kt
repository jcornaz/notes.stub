package com.toolable.notes.stub.model

import com.google.common.base.Preconditions
import com.toolable.notes.stub.impl.DocumentImpl
import com.toolable.notes.stub.utils.*
import org.joda.time.DateTime

/**
 * Stub for [lotus.domino.Document]
 *
 * @author jonathan
 */
class DocumentStub() : BaseStub<DocumentImpl> {
    override val implementation = DocumentImpl(this)
    override var isRecycled by cascadeRecyclingState { items.values }

    var database by lazyParent({ DatabaseStub() }, { documents -= unid }, { documents += unid to this@DocumentStub })

    var parentDocument: DocumentStub? = null
        set(value) {
            if (value == null) {
                this["\$ref"]?.document = DocumentStub()
            } else {
                this["\$ref"] = value.unid.toString()
            }
            field = value
        }

    var items = emptyMap<String, ItemStub>()
        internal set

    var unid: Unid by MutableLazyDelegate({ Unid.generate() }, { old, new ->
        Preconditions.checkArgument(new !in database, "There is already a document with this unid it the document database")
        old?.let { database.documents -= it }
        database.documents += new to this
    })

    var isSaved = true

    constructor(database: DatabaseStub) : this() {
        this.database = database
    }

    operator fun get(itemName: String) = items[itemName.toLowerCase()]
    operator fun set(itemName: String, values: List<Any>) {
        ItemStub(this, itemName).values = values
    }

    operator fun set(itemName: String, value: String) {
        (this[itemName] ?: ItemStub(this, itemName)).strings = listOf(value)
    }

    operator fun set(itemName: String, value: Number) {
        (this[itemName] ?: ItemStub(this, itemName)).doubles = listOf(value.toDouble())
    }

    operator fun set(itemName: String, value: DateTime) {
        (this[itemName] ?: ItemStub(this, itemName)).dateTimes = listOf(value)
    }
}