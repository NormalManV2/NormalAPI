package org.normal.api.economy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface Bank <T extends CurrencyType> extends Serializable {

    /**
     * Get the type of currency this bank holds.
     * @return Returns the type of currency this bank uses.
     */
    T getType();

    /**
     * Get the user of the bank.
     * @return The bank user.
     */
    UUID getBankUser();

    /**
     * Get the transactions list.
     * @return The transactions list. **(This will only return transactions made during runtime)**
     */
    List<BankTransaction> getTransactionsList();

    /**
     * Get the transactions for a user.
     * @return The list of transactions for the user.
     */
    List<BankTransaction> getTransactions(TransactionType type);

    /**
     * Add a transaction for the user.
     * @param transaction The transaction to add.
     * @return The balance.
     */
    BigDecimal addTransaction(BankTransaction transaction);

    /**
     * Get the balance of the user.
     * @return The balance of the user.
     */
    BigDecimal getBalance();

    /**
     * Modify the balance of the user.
     * @param transaction The transaction of which dictates internal handling logic.
     * @return The updated balance.
     */
    BigDecimal modifyBalance(BankTransaction transaction);

    /**
     * Sets the balance held within this bank to the passed balance object.
     * @param newBalance The passed balance object.
     * @return The balance field held within the bank.
     */
    Balance setBalance(Balance newBalance);

}
