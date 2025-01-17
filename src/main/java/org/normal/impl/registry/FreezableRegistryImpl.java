package org.normal.impl.registry;

import org.normal.api.registry.FreezableRegistry;

public class FreezableRegistryImpl<K, T> extends RegistryImpl<K, T> implements FreezableRegistry<K, T> {

    private boolean isFrozen;

    @Override
    public void freeze() {
        this.isFrozen = true;
    }

    @Override
    public void unfreeze() {
        this.isFrozen = false;
    }

    @Override
    public boolean isFrozen() {
        return this.isFrozen;
    }

    @Override
    public void register(K key, T object) {
        if (this.isFrozen) throw new UnsupportedOperationException("This registry is frozen!");
        super.register(key, object);
    }

    @Override
    public void unregister(K key) {
        if (this.isFrozen) throw new UnsupportedOperationException("This registry is frozen!");
        super.unregister(key);
    }

    @Override
    public void clearEntries() {
        if (this.isFrozen) throw new UnsupportedOperationException("This registry is frozen!");
        super.clearEntries();
    }
}
