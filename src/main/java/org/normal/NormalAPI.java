package org.normal;

public class NormalAPI {

    private static final Economy ECONOMY = new Economy();
    private static final Registry REGISTRY = new Registry();

    public static Economy getEconomy(){
        return ECONOMY;
    }

    public static Registry getRegistry(){
        return REGISTRY;
    }
}