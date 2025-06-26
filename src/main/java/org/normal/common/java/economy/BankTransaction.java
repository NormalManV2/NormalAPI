package org.normal.common.java.economy;

import org.jetbrains.annotations.Nullable;
import org.normal.api.java.economy.bank.Transaction;
import org.normal.api.java.economy.bank.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class BankTransaction implements Transaction {

    private final UUID transactionId;
    private final UUID accountId;
    private final BigDecimal amount;
    private final Instant instant;
    private final TransactionType transactionType;
    private final String description;

    public BankTransaction(UUID transactionId, UUID accountId, BigDecimal amount, Instant instant, TransactionType type, @Nullable String description) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.instant = instant;
        this.transactionType = type;
        this.description = description;
    }

    @Override
    public UUID transactionId() {
        return this.transactionId;
    }

    @Override
    public UUID accountId() {
        return this.accountId;
    }

    @Override
    public BigDecimal amount() {
        return this.amount;
    }

    @Override
    public Instant instant() {
        return this.instant;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public TransactionType type() {
        return this.transactionType;
    }
}
