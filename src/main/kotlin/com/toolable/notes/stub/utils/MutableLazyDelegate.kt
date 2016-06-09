package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.Parent
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class MutableLazyDelegate<O, T>(private val initializer: () -> T, private val updater: (oldValue: T?, newValue: T) -> Unit) : ReadWriteProperty<O, T> {

    private var value: T? = null

    override fun setValue(thisRef: O, property: KProperty<*>, value: T) {
        updater(this.value, value)
        this.value = value
    }

    override fun getValue(thisRef: O, property: KProperty<*>): T {

        synchronized(this) {
            if (value == null)
                value = initializer()
        }

        return value!!
    }
}

fun <C, P : Parent<C>> lazyChild(child: C, initializer: () -> P) =
        MutableLazyDelegate<C, P>({
            val parent = initializer();
            parent.add(child);
            return@MutableLazyDelegate parent;
        }) { oldValue, newValue ->
            oldValue?.remove(child);
            newValue.add(child);
        }