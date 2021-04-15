package com.bs.bank.account.kata.statement;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.operation.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Statement {
    private final List<StatementLine> lines;

    private Statement(List<StatementLine> lines) {
        this.lines = lines;
    }

    public static Statement of(List<Operation> operations) {
        List<StatementLine> lines = new ArrayList<>(operations.size());
        Money balance = new Money(BigDecimal.ZERO);

        for (Operation operation : operations) {
            balance = balance.add(operation.getAmount());
            lines.add(new StatementLine(operation, balance));
        }

        return new Statement(lines);
    }

    public List<StatementLine> getLines() {
        return lines;
    }
}
