package org.normal.common.economy;

import org.jetbrains.annotations.Nullable;
import org.normal.api.economy.BankTransaction;
import org.normal.api.economy.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class BankTransactionImpl implements BankTransaction {

    private final UUID transactionId;
    private final UUID accountId;
    private final BigDecimal amount;
    private final Instant instant;
    private final TransactionType transactionType;
    private final String description;

    public BankTransactionImpl(UUID transactionId, UUID accountId, BigDecimal amount, Instant instant, TransactionType type, @Nullable String description) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.instant = instant;
        this.transactionType = type;
        this.description = description;
    }

    @Override
    public UUID transactionId() {
        return null;
    }

    @Override
    public UUID accountId() {
        return null;
    }

    @Override
    public BigDecimal amount() {
        return null;
    }

    @Override
    public Instant instant() {
        return null;
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public TransactionType type() {
        return null;
    }
}
