package org.normal;

import org.bukkit.plugin.java.JavaPlugin;
import org.normal.impl.registry.FreezableRegistryImpl;
import org.normal.impl.registry.RegistryImpl;

import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NormalAPI extends JavaPlugin {

    private static NormalAPI instance;

    public static NormalAPI getInstance() {
        if (instance == null) instance = new NormalAPI();
        return instance;
    }

    public static <K, T> RegistryImpl<K, T> createRegistry() {
        return new RegistryImpl<>();
    }

    public static <K, T> FreezableRegistryImpl<K, T> createFreezableRegistry() {
        return new FreezableRegistryImpl<>();
    }

}