package org.normal.api.kt.registry

interface Registry<K, T> {

    fun getBackingMap(): Map<K, T>

    fun register(key: K, obj: T)

    fun unregister(key: K)

    fun set(elements: Map<K, T>)

    fun get(key: K): T?

    fun clearEntries()

}