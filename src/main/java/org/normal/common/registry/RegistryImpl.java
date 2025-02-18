package org.normal.common.registry;

import org.normal.api.registry.Registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RegistryImpl<K, T> implements Registry<K, T> {

    private final Map<K, T> backingMap;

    public RegistryImpl() {
        this.backingMap = new HashMap<>();
    }

    @Override
    public Map<K, T> getBackingMap() {
        return Collections.unmodifiableMap(this.backingMap);
    }

    @Override
    public void register(K key, T object) {

        if (key == null || object == null) throw new NullPointerException("Key and/or object is null!");

        this.backingMap.put(key, object);
    }

    @Override
    public void unregister(K key) {
        if (key == null) throw new NullPointerException("Key is null!");
        this.backingMap.remove(key);
    }

    @Override
    public void set(Map<K, T> elements) {
        this.backingMap.clear();
        this.backingMap.putAll(elements);
    }

    @Override
    public T get(K key) {
        return this.backingMap.get(key);
    }

    @Override
    public void clearEntries() {
        this.backingMap.clear();
    }

}
