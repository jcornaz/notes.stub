package com.toolable.notes.stub.utils

operator fun <K, V> Map<K, V>.minus(key: K) = filterNot { it.key == key }