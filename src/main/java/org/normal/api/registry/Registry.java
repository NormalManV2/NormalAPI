package org.normal.api.registry;

import java.util.Map;

public interface Registry<K, T> {

    Map<K, T> getBackingMap();

    void register(K key, T object);

    void unregister(K key);

    void set(Map<K, T> elements);

    T get(K key);

    void clearEntries();

}
