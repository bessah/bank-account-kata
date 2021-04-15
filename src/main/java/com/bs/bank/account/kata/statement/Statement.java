package com.bs.bank.account.kata.statement;

import java.util.List;

public class Statement {
    private final List<StatementLine> lines;

    public Statement(List<StatementLine> lines) {
        this.lines = lines;
    }

    public List<StatementLine> getLines() {
        return lines;
    }
}
