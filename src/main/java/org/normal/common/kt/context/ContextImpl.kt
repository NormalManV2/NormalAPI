package org.normal.common.kt.context

import org.normal.api.kt.context.Context
import org.normal.api.kt.context.ContextType

class ContextImpl(override val type : ContextType) : Context {

    private val backingMap: MutableMap<String, Any> = mutableMapOf()

    override fun <data: Any> getData(key: String, type: Class<data>): data? {
        require(backingMap[key] != null) { "Data does not exist" }

        return backingMap[key] as data?
    }

    override fun <data : Any> putData(key: String, value: data) {
        backingMap[key] = value
    }



    fun getBackingMap(): Map<String, Any> {
        return backingMap.toMap()
    }
}