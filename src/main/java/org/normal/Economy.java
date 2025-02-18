package org.normal;

import org.normal.api.economy.CurrencyType;
import org.normal.api.economy.TransactionType;
import org.normal.common.economy.BankImpl;
import org.normal.common.economy.BankTransactionImpl;
import org.normal.common.economy.CurrencyTypeImpl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Economy {

    public <T extends CurrencyType> BankImpl<T> createBank(UUID accountId, T currencyType, BigDecimal initialBalance) {
        return new BankImpl<>(accountId, currencyType, initialBalance);
    }

    public BankTransactionImpl createBankTransaction(
            UUID transactionId,
            UUID accountId,
            BigDecimal amount,
            Instant instant,
            TransactionType transactionType,
            String description,
            CurrencyType currencyType) {

        return new BankTransactionImpl(
                transactionId,
                accountId,
                amount,
                instant,
                transactionType,
                description,
                currencyType);
    }

    public CurrencyTypeImpl createCurrencyType(String name, String symbol, String pluginName) {
        return new CurrencyTypeImpl(name, symbol, pluginName);
    }

}
