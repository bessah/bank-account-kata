package com.bs.bank.account.kata.operation;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.statement.Statement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationsHistory {
    private final List<Operation> operations;

    public OperationsHistory() {
        this.operations = new ArrayList<>();
    }

    public void add(Operation operation) {
        operations.add(operation);
    }

    public Money getTotalAmount() {
        return operations.stream()
                .map(Operation::getAmount)
                .reduce(new Money(BigDecimal.ZERO), Money::add);
    }

    public Statement getStatement() {
        return Statement.of(operations);
    }
}
