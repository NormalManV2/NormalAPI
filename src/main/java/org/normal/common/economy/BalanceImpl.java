package org.normal.common.economy;

import org.normal.api.economy.bank.Balance;

import java.math.BigDecimal;

public class BalanceImpl implements Balance {

    private BigDecimal balance;

    public BalanceImpl(BigDecimal startingBalance) {
        this.balance = startingBalance;
    }

    @Override
    public boolean add(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return true;
    }

    @Override
    public boolean subtract(BigDecimal amount) {
        BigDecimal newBalance = this.balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        this.balance = newBalance;
        return true;
    }

    @Override
    public void set(BigDecimal amount) {
        this.balance = amount;
    }

    @Override
    public BigDecimal getBalance() {
        return this.balance;
    }
}
