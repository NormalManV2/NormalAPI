package org.normal.api.economy;

public interface CurrencyType {

    /**
     * @return The name of the currency.
     */
    String getName();

    /**
     * The symbol of the currency in most cases would be used for chat extensions and UI displays... etc.
     * @return The symbol of the currency.
     */
    String getSymbol();

    /**
     * Intended to be used in the creation of different economy hooks.
     * @return The plugin's name.
     */
    String getPluginName();

}
