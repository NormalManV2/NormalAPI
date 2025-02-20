package org.normal.common.economy;

import org.normal.api.economy.bank.Bank;
import org.normal.api.economy.bank.account.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BankImpl implements Bank {

    private final List<Account<?>> accounts;

    public BankImpl() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public List<Account<?>> getAccounts() {
        return Collections.unmodifiableList(this.accounts);
    }

    @Override
    public Account<?> getAccount(UUID accountId) {
        for (Account<?> foundAccount : this.accounts) {
            if (foundAccount.getAccountUser().equals(accountId)) {
                return foundAccount;
            }
        }
        throw new RuntimeException("No account found with id " + accountId);
    }

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

    @Override
    public void addAccount(Account<?> account) {
        this.accounts.add(account);
    }

    @Override
    public void removeAccount(Account<?> account) {
        this.accounts.remove(account);
    }

    @Override
    public void removeAccounts(UUID accountId) {
        this.accounts.removeIf(foundAccount -> foundAccount.getAccountUser().equals(accountId));
    }
}
