package org.normal.api.kt.registry

interface FreezableRegistry<K, T> : Registry<K, T> {

    fun freeze()
    fun unfreeze()
    fun isFrozen(): Boolean

}