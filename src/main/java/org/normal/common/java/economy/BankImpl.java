package org.normal.common.java.economy;

import org.normal.api.java.economy.bank.Bank;
import org.normal.api.java.economy.bank.account.Account;
import org.normal.api.java.economy.currency.CurrencyType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BankImpl implements Bank {

    private final List<Account<?>> accounts;

    public BankImpl() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Gets a list of registered accounts.
     * @return The list of registered accounts for this bank.
     */
    @Override
    public List<Account<?>> getAccounts() {
        return Collections.unmodifiableList(this.accounts);
    }

    /**
     * Gets an account of a specific user of a specific currency type.
     * @param accountId The user to query.
     * @param currencyType The currency type to query.
     * @return The account that first matches the given parameters.
     */
    @Override
    public Account<?> getAccount(UUID accountId, CurrencyType currencyType) throws RuntimeException {
        for (Account<?> foundAccount : this.accounts) {
            if (foundAccount.getAccountUser().equals(accountId)) {
                if (foundAccount.getType() == currencyType) return foundAccount;
            }
        }
        throw new RuntimeException("No account found with id " + accountId);
    }

    /**
     * Gets a list of all accounts associated with a userId within this bank.
     * @param accountId The user to query.
     * @return A list of all user's accounts.
     */
    @Override
    public List<Account<?>> getAccounts(UUID accountId) {
        List<Account<?>> foundAccounts = new ArrayList<>();
        for (Account<?> foundAccount : this.accounts) {
            if (foundAccount.getAccountUser().equals(accountId)) {
                foundAccounts.add(foundAccount);
            }
        }
        return Collections.unmodifiableList(foundAccounts);
    }

    /**
     * Add an account to this bank.
     * @param account The account to add.
     */
    @Override
    public void addAccount(Account<?> account) {
        this.accounts.add(account);
    }

    /**
     * Remove an account from this bank.
     * @param account The account to remove.
     */
    @Override
    public void removeAccount(Account<?> account) {
        this.accounts.remove(account);
    }

    /**
     * Removes all accounts associated with a specific user.
     * @param accountId The user to query.
     */
    @Override
    public void clear(UUID accountId) {
        this.accounts.removeIf(foundAccount -> foundAccount.getAccountUser().equals(accountId));
    }
}
