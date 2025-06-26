package org.normal;

import org.normal.api.java.context.ContextType;
import org.normal.common.java.context.ContextImpl;

public class Context {

    public <T extends ContextType> ContextImpl<T> createGenericContext(T type) {
        return new ContextImpl<>(type);
    }
}
