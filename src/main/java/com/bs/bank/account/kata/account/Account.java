package com.bs.bank.account.kata.account;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.operation.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<Operation> operations;

    public Account() {
        this.operations = new ArrayList<>();
    }

    public Money getBalance() {
        return operations.stream()
                .map(Operation::getAmount)
                .reduce(new Money(BigDecimal.ZERO), Money::add);
    }

    public void deposit(Money money) {
        operations.add(Operation.createDepositOperation(money));
    }

    public void withdrawal(Money money) {
        operations.add(Operation.createWithdrawalOperation(money.negate()));
    }
}
