package com.toolable.notes.stub.utils

operator fun <K> Map<K, *>.minus(key: K) = filterNot { it.key == key }