package com.bs.bank.account.kata.account;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.operation.Operation;
import com.bs.bank.account.kata.operation.OperationsHistory;
import com.bs.bank.account.kata.statement.Statement;

public class Account {
    private final OperationsHistory operationsHistory;

    public Account() {
        this.operationsHistory = new OperationsHistory();
    }

    public Money getBalance() {
        return operationsHistory.getTotalAmount();
    }

    public void deposit(Money money) {
        operationsHistory.add(Operation.createDepositOperation(money));
    }

    public void withdrawal(Money money) {
        operationsHistory.add(Operation.createWithdrawalOperation(money.negate()));
    }

    public Statement getStatement() {
        return operationsHistory.getStatement();
    }
}
