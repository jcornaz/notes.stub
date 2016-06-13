package com.toolable.notes.stub.model

import lotus.domino.DateTime

/**
 * List that can only contain [Number], [String] and [DateTime] as the notes items do
 *
 * @constructor Create a instance for an existing list
 * @param list List of values. It should not contains forbidden types. It will not be checked
 */
data class ItemValues private constructor(val list: List<Any>) : List<Any> by list {
    constructor() : this(emptyList())

    constructor(value: Number) : this(listOf(value))

    constructor(value: String) : this(listOf(value))

    constructor(value: DateTime) : this(listOf(value))

    val firstValue: Any?
        get() = if (isEmpty()) null else list[0]

    fun asInt(): Int {
        val value = firstValue as? Number;
        if (value == null)
            return 0
        else
            return value.toInt()
    }

    fun asDouble(): Double {
        val value = firstValue as? Number;
        if (value == null)
            return 0.0
        else
            return value.toDouble()
    }

    fun asString() = firstValue?.toString().orEmpty()

    fun asDateTime() = firstValue as? DateTime

    operator fun plus(element: Number) = ItemValues(list + element)
    operator fun plus(element: String) = ItemValues(list + element)
    operator fun plus(element: DateTime) = ItemValues(list + element)
    operator fun plus(elements: List<Any>) = if (elements is ItemValues) ItemValues(list + elements.list) else elements.fold(this) { newList, element ->
        if (element is Number)
            return newList + element
        else if (element is String)
            return newList + element
        else if (element is DateTime)
            return newList + element
        else
            throw IllegalArgumentException("${element.javaClass.name} is not accepted as item value")
    }

    operator fun minus(element: Any) = ItemValues(list - element)
    operator fun minus(elements: List<Any>) = elements.fold(this) { newList, element -> newList - element }
}