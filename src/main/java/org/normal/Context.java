package org.normal;

import org.normal.api.context.ContextType;
import org.normal.common.context.ContextImpl;

public class Context {

    public <T extends ContextType> ContextImpl<T> createGenericContext(T type) {
        return new ContextImpl<>(type);
    }
}
