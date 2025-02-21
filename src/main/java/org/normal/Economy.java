package org.normal;

import org.normal.api.economy.bank.Bank;
import org.normal.api.economy.currency.CurrencyType;
import org.normal.api.economy.bank.TransactionType;
import org.normal.common.economy.AccountImpl;
import org.normal.common.economy.BankImpl;
import org.normal.common.economy.BankTransactionImpl;
import org.normal.common.economy.CurrencyTypeImpl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Economy {

    public Bank createBank() {
        return new BankImpl();
    }

    public AccountImpl createAccount(UUID accountId, CurrencyType currencyType, BigDecimal initialBalance) {
        return new AccountImpl(accountId, currencyType, initialBalance);
    }

    public BankTransactionImpl createBankTransaction(
            UUID transactionId,
            UUID accountId,
            BigDecimal amount,
            Instant instant,
            TransactionType transactionType,
            String description) {

        return new BankTransactionImpl(
                transactionId,
                accountId,
                amount,
                instant,
                transactionType,
                description);
    }

    public CurrencyTypeImpl createCurrencyType(String name, String symbol, String pluginName) {
        return new CurrencyTypeImpl(name, symbol, pluginName);
    }

}
