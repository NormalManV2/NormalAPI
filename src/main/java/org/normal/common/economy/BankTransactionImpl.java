package org.normal.common.economy;

import org.jetbrains.annotations.Nullable;
import org.normal.api.economy.BankTransaction;
import org.normal.api.economy.CurrencyType;
import org.normal.api.economy.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record BankTransactionImpl(
        UUID transactionId,
        UUID accountId,
        BigDecimal amount,
        Instant instant,
        TransactionType type,
        @Nullable String description,
        CurrencyType currencyType)
        implements BankTransaction {

    @Override
    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }
}
