package org.normal.api.context;

public record ContextType(String type) {

    public static ContextType createType(String type) {
        return new ContextType(type);
    }

}
