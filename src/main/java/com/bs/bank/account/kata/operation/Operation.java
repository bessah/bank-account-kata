package com.bs.bank.account.kata.operation;

import com.bs.bank.account.kata.Money;

import java.time.LocalDateTime;

public class Operation {
    private final OperationType type;
    private final Money amount;
    private final LocalDateTime date;

    public Operation(OperationType type, Money amount, LocalDateTime date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public OperationType getType() {
        return type;
    }

    public Money getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
