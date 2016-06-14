package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DocumentImpl
import com.toolable.notes.stub.utils.MutableLazyDelegate
import com.toolable.notes.stub.utils.cascadeRecyclingState
import com.toolable.notes.stub.utils.lazyParent
import com.toolable.notes.stub.utils.minus
import lotus.domino.DateTime

/**
 * Stub for [lotus.domino.Document]
 *
 * @author jonathan
 */
class DocumentStub : BaseStub<DocumentImpl> {
    override val implementation = DocumentImpl(this)
    override var isRecycled by cascadeRecyclingState { items.values }

    var database by lazyParent({ DatabaseStub() }, { documents -= unid }, { documents += unid to this@DocumentStub })

    var parentDocument: DocumentStub? = null

    var items = emptyMap<String, ItemStub>()
        internal set

    var unid: Unid by MutableLazyDelegate({ Unid.generate() }, { old, new -> Unid.register(new) })

    operator fun get(itemName: String) = if (itemName in items) items[itemName]!!.values else ItemValues()
    operator fun set(itemName: String, values: ItemValues) = ItemStub(this, itemName, values)
    operator fun set(itemName: String, value: String) = ItemStub(this, itemName, value)
    operator fun set(itemName: String, value: Number) = ItemStub(this, itemName, value)
    operator fun set(itemName: String, value: DateTime) = ItemStub(this, itemName, value)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as DocumentStub

        if (unid != other.unid) return false

        return true
    }

    override fun hashCode(): Int {
        return unid.hashCode()
    }
}