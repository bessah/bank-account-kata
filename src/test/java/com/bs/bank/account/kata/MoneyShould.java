package com.bs.bank.account.kata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyShould {

    @Test
    void add_money() {
        // Given
        Money money1 = new Money(BigDecimal.valueOf(1000));
        Money money2 = new Money(BigDecimal.valueOf(150));

        // When
        Money actual = money1.add(money2);

        // Then
        Money expected = new Money(BigDecimal.valueOf(1150));
        assertEquals(expected, actual);
    }

    @Test
    void subtract_money() {
        // Given
        Money money1 = new Money(BigDecimal.valueOf(1000));
        Money money2 = new Money(BigDecimal.valueOf(150));

        // When
        Money actual = money1.subtract(money2);

        // Then
        Money expected = new Money(BigDecimal.valueOf(850));
        assertEquals(expected, actual);
    }
}