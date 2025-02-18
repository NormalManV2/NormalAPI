package org.normal.common.economy;

import org.normal.api.economy.Balance;
import org.normal.api.economy.Bank;
import org.normal.api.economy.BankTransaction;
import org.normal.api.economy.CurrencyType;
import org.normal.api.economy.TransactionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BankImpl<T extends CurrencyType> implements Bank<T> {

    private final List<BankTransaction> transactions;
    private Balance balance;
    private final UUID userId;
    private final T currencyType;

    public BankImpl(UUID uuid, T currencyType, BigDecimal initialBalance) {
        this.currencyType = currencyType;
        this.transactions = new ArrayList<>();
        this.balance = new BalanceImpl(initialBalance);
        this.userId = uuid;
    }

    @Override
    public T getType() {
        return this.currencyType;
    }

    @Override
    public UUID getBankUser() {
        return this.userId;
    }

    @Override
    public List<BankTransaction> getTransactionsList() {
        return Collections.unmodifiableList(this.transactions);
    }

    @Override
    public List<BankTransaction> getTransactions(TransactionType type) {
        return transactions.stream()
                .filter(tx -> tx.type() == type)
                .toList();
    }

    @Override
    public BigDecimal addTransaction(BankTransaction transaction) {
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
    public BigDecimal modifyBalance(BankTransaction transaction) {
        return this.addTransaction(transaction);
    }

    @Override
    public Balance setBalance(Balance newBalance) {
        this.balance = newBalance;
        return this.balance;
    }

}
