package org.normal;

import org.normal.common.java.registry.FreezableRegistryImpl;
import org.normal.common.java.registry.RegistryImpl;

public class Registry {

    public <K, T> RegistryImpl<K, T> createRegistry() {
        return new RegistryImpl<>();
    }

    public <K, T> FreezableRegistryImpl<K, T> createFreezableRegistry() {
        return new FreezableRegistryImpl<>();
    }

}
