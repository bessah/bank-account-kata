package com.bs.bank.account.kata.account;

import com.bs.bank.account.kata.Money;

import java.math.BigDecimal;

public class Account {
    private Money balance;

    public Account() {
        this.balance = new Money(BigDecimal.ZERO);
    }

    public Money getBalance() {
        return balance;
    }

    public void deposit(Money money) {
        balance = balance.add(money);
    }

    public void withdrawal(Money money) {
        balance = balance.subtract(money);
    }
}
