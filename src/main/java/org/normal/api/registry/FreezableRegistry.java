package org.normal.api.registry;

public interface FreezableRegistry<K, T> extends Registry<K, T> {

    void freeze();

    void unfreeze();

    boolean isFrozen();

}
