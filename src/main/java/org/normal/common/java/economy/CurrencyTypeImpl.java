package org.normal.common.java.economy;

import org.normal.api.java.economy.currency.CurrencyType;

public record CurrencyTypeImpl(
        String name,
        String symbol,
        String pluginName) implements CurrencyType {

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String getPluginName() {
        return this.pluginName;
    }
}
