package com.bs.bank.account.kata.statement;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.operation.Operation;

public class StatementLine {
    private final Operation operation;
    private final Money balance;

    public StatementLine(Operation operation, Money balance) {
        this.operation = operation;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public Money getBalance() {
        return balance;
    }
}
