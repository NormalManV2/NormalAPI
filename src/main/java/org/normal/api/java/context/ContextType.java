package org.normal.api.java.context;

public record ContextType(String type) {

    public static ContextType fromUser(String type) {
        if (type.isBlank()) throw new IllegalArgumentException("Type cannot be blank");
        String normalized = type.trim().toLowerCase();

        return new ContextType(normalized);
    }

}
