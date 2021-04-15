package com.bs.bank.account.kata.statement;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.operation.Operation;
import com.bs.bank.account.kata.operation.OperationType;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StatementPrinterShould {

    private final StatementPrinter statementPrinter = new StatementPrinter();

    @Test
    void print_expected_statement_lines() {
        // Given
        Statement statement = Statement.of(List.of(
                operation(new Money(BigDecimal.valueOf(100)), LocalDateTime.of(2021, 4, 12, 0, 0)),
                operation(new Money(BigDecimal.valueOf(500)), LocalDateTime.of(2021, 4, 13, 0, 0)),
                operation(new Money(BigDecimal.valueOf(-50)), LocalDateTime.of(2021, 4, 14, 0, 0))
        ));

        // When
        StringWriter output = new StringWriter();
        statementPrinter.print(statement, output);

        // Then
        String expected = "| OPERATION | DATE | AMOUNT | BALANCE |\n"
                + "| DEPOSIT | 12/04/2021 | 100 | 100 |\n"
                + "| DEPOSIT | 13/04/2021 | 500 | 600 |\n"
                + "| WITHDRAWAL | 14/04/2021 | -50 | 550 |\n";
        assertEquals(expected, output.toString());
    }

    private Operation operation(Money amount, LocalDateTime date) {
        Operation operation = mock(Operation.class);

        when(operation.getType()).thenReturn(amount.isPositive() ? OperationType.DEPOSIT : OperationType.WITHDRAWAL);
        when(operation.getAmount()).thenReturn(amount);
        when(operation.getDate()).thenReturn(date);

        return operation;
    }
}