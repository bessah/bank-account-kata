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

    public static Operation createDepositOperation(Money amount) {
        if (!amount.isPositive()) {
            throw new IllegalArgumentException("Amount of deposit operation should be positive");
        }
        return new Operation(OperationType.DEPOSIT, amount, LocalDateTime.now());
    }

    public static Operation createWithdrawalOperation(Money amount) {
        if (!amount.isNegative()) {
            throw new IllegalArgumentException("Amount of withdrawal operation should be negative");
        }
        return new Operation(OperationType.WITHDRAWAL, amount, LocalDateTime.now());
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
