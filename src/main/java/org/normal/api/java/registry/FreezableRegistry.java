package org.normal.api.java.registry;

public interface FreezableRegistry<K, T> extends Registry<K, T> {

    void freeze();

    void unfreeze();

    boolean isFrozen();

}
