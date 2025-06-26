package org.normal.common.java.economy;

import org.normal.api.java.economy.bank.Balance;
import org.normal.api.java.economy.bank.account.Account;
import org.normal.api.java.economy.bank.Transaction;
import org.normal.api.java.economy.currency.CurrencyType;
import org.normal.api.java.economy.bank.TransactionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class AccountImpl implements Account<CurrencyType> {

    private final List<Transaction> transactions;
    private Balance balance;
    private final UUID userId;
    private final CurrencyType currencyType;

    public AccountImpl(UUID uuid, CurrencyType currencyType, BigDecimal initialBalance) {
        this.currencyType = currencyType;
        this.transactions = new ArrayList<>();
        this.balance = new BalanceImpl(initialBalance);
        this.userId = uuid;
    }

    @Override
    public CurrencyType getType() {
        return this.currencyType;
    }

    @Override
    public UUID getAccountUser() {
        return this.userId;
    }

    @Override
    public List<Transaction> getTransactionsList() {
        return Collections.unmodifiableList(this.transactions);
    }

    @Override
    public List<Transaction> getTransactions(TransactionType type) {
        return transactions.stream()
                .filter(tx -> tx.type() == type)
                .toList();
    }

    @Override
    public BigDecimal addTransaction(Transaction transaction) {
        this.transactions.add(transaction);

        boolean success = transaction.type() == TransactionType.DEPOSIT
                ? this.balance.add(transaction.amount())
                : this.balance.subtract(transaction.amount());

        if (transaction.type() == TransactionType.WITHDRAW && !success) {
            throw new RuntimeException("Cannot withdraw transaction");
        }

        return this.balance.getBalance();
    }

    @Override
    public BigDecimal getBalance() {
        return this.balance.getBalance();
    }

    @Override
    public BigDecimal modifyBalance(Transaction transaction) {
        return this.addTransaction(transaction);
    }

    @Override
    public Balance setBalance(Balance newBalance) {
        this.balance = newBalance;
        return this.balance;
    }

}
