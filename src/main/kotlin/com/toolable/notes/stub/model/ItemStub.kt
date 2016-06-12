package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.ItemImpl

/**
 * Stub for [lotus.domino.Item]
 *
 * @author jonathan
 */
data class ItemStub(val name: String, var values: List<Any> = emptyList()) : BaseStub<ItemImpl> {

    override val implementation = ItemImpl(this)
    override var isRecycled = false
}