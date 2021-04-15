package com.bs.bank.account.kata.statement;

import java.io.StringWriter;
import java.time.format.DateTimeFormatter;

public class StatementPrinter {
    private static final String STATEMENT_HEADER = "| OPERATION | DATE | AMOUNT | BALANCE |\n";
    private static final String STATEMENT_LINE = "| %s | %s | %s | %s |\n";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void print(Statement statement, StringWriter output) {
        output.append(STATEMENT_HEADER);
        for (StatementLine statementLine : statement.getLines()) {
            String line = String.format(
                    STATEMENT_LINE,
                    statementLine.getOperation().getType(),
                    DATE_FORMATTER.format(statementLine.getOperation().getDate()),
                    statementLine.getOperation().getAmount(),
                    statementLine.getBalance()
            );
            output.append(line);
        }
    }
}
