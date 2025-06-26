package org.normal.api.kt.context

data class ContextType(val context : String) {

    companion object {
        fun fromUser(context: String) : ContextType {
            require(context.isNotBlank()) { "Context cannot be blank" }
            val normalized = context.trim().lowercase()

            return ContextType(normalized)
        }
    }

}