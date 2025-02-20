package org.normal.api.economy.bank;

import org.normal.api.economy.bank.account.Account;

import java.util.List;
import java.util.UUID;

public interface Bank {

    List<Account<?>> getAccounts();

    Account<?> getAccount(UUID accountId);

    List<Account<?>> getAccounts(UUID accountId);

    void addAccount(Account<?> account);

    void removeAccount(Account<?> account);

    void removeAccounts(UUID accountId);

}
