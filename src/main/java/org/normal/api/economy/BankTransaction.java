package org.normal.api.economy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public interface BankTransaction extends Serializable {

    /**
     * Get the unique identifier of the transaction.
     * @return The transaction UUID.
     */
    UUID transactionId();

    /**
     * Get the unique identifier of the account in which the transaction is being applied.
     * @return The account UUID.
     */
    UUID accountId();

    /**
     * Get the amount involved in the transaction.
     * @return The transaction amount.
     */
    BigDecimal amount();

    /**
     * Get the instant when the transaction occurred.
     * @return The instant of the transaction.
     */
    Instant instant();

    /**
     * Get a description of the transaction.
     * @return A short description.
     */
    String description();

    /**
     * Get the type of the transaction (e.g., DEPOSIT, WITHDRAWAL).
     * @return The transaction type.
     */
    TransactionType type();
}
