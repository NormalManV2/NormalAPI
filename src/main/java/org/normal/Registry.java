package org.normal;

import org.normal.common.registry.FreezableRegistryImpl;
import org.normal.common.registry.RegistryImpl;

public class Registry {

    public <K, T> RegistryImpl<K, T> createRegistry() {
        return new RegistryImpl<>();
    }

    public <K, T> FreezableRegistryImpl<K, T> createFreezableRegistry() {
        return new FreezableRegistryImpl<>();
    }

}
