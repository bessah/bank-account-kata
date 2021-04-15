package com.bs.bank.account.kata.account;

import com.bs.bank.account.kata.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountShould {

    @Test
    void have_balance_initialized_to_zero_when_created() {
        // Given / When
        Account account = new Account();

        // Then
        Money expected = new Money(BigDecimal.ZERO);
        assertEquals(expected, account.getBalance());
    }

    @Test
    void have_balance_increased_by_500_when_deposit_500() {
        // Given
        Account account = new Account();
        Money money = new Money(BigDecimal.valueOf(500));

        // When
        account.deposit(money);

        // Then
        Money expected = new Money(BigDecimal.valueOf(500));
        assertEquals(expected, account.getBalance());
    }
}