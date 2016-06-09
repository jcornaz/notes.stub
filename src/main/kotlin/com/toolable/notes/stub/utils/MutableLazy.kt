package com.toolable.notes.stub.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MutableLazy<T>(private val initializer: () -> T) : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

        synchronized(this) {
            if (value == null)
                value = initializer()
        }

        return value!!
    }
}