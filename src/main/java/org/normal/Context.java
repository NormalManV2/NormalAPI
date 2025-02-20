package org.normal;

import org.normal.common.context.ContextImpl;

public class Context {

    public <T> ContextImpl<T> createGenericContext(T type) {
        return new ContextImpl<>(type);
    }
}
