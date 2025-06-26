package org.normal.api.kt.context

import java.util.*

interface Context {

    val type: ContextType

    fun <data : Any> getData(key: String, type: Class<data>): data?

    fun <data : Any> putData(key: String, value: data)

    fun getId(): String? = getData("id", String::class.java)

    fun getName(): String? = getData("name", String::class.java)

    fun getUuid(): UUID? = getData("uuid", UUID::class.java)

}