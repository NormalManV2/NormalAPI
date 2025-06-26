package org.normal.common.java.context;

import org.normal.api.java.context.Context;
import org.normal.api.java.context.ContextType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContextImpl<T extends ContextType> implements Context<T> {

    private final Map<String, Object> data;
    private final T type;

    public ContextImpl(T type) {
        this.data = new HashMap<>();
        this.type = type;
    }

    @Override
    public T getType() {
        return this.type;
    }

    @Override
    public <Z> Optional<Z> getData(String key, Class<Z> type) {
        return Optional.ofNullable(data.get(key)).map(type::cast);
    }

    @Override
    public void putData(String key, Object value) {
        this.data.put(key, value);
    }
}
