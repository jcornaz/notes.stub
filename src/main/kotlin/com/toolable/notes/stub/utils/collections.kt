package com.toolable.notes.stub.utils

/**
 * Minus operator for a map
 *
 * @param key Key to remove from the map
 * @return The same map without the specified key
 */
operator fun <K, V> Map<K, V>.minus(key: K) = filterNot { it.key == key }