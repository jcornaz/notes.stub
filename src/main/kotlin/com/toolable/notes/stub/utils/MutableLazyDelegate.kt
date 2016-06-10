package com.toolable.notes.stub.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Lazy delegate for a mutable property
 *
 * @param initializer Instantiation to call if the the value has not been set yet
 * @param updater Listener called when the value is updated (do nothing by default)
 */
open class MutableLazyDelegate<O, T>(private val initializer: () -> T, private val updater: (oldValue: T?, newValue: T) -> Unit = { a, b -> /* do nothing */ }) : ReadWriteProperty<O, T> {

    private var value: T? = null

    override fun setValue(thisRef: O, property: KProperty<*>, value: T) {
        synchronized(this) {
            updater(this.value, value)
            this.value = value
        }
    }

    override fun getValue(thisRef: O, property: KProperty<*>): T {
        synchronized(this) {
            if (value == null)
                value = initializer()
        }

        return value!!
    }
}