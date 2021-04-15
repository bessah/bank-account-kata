package com.bs.bank.account.kata.operation;

import com.bs.bank.account.kata.Money;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class OperationShould {

    @Test
    void create_deposit_operation_when_positive_amount() {
        // Given
        Money amount = new Money(BigDecimal.valueOf(100));
        // When
        Operation actual = Operation.createDepositOperation(amount);
        // Then
        assertThat(actual).isNotNull();
    }

    @Test
    void fail_to_create_deposit_operation_when_negative_amount() {
        // Given
        Money amount = new Money(BigDecimal.valueOf(-100));
        // When
        ThrowableAssert.ThrowingCallable throwingCallable = () ->
                Operation.createDepositOperation(amount);
        // Then
        assertThatCode(throwingCallable).isInstanceOf(IllegalArgumentException.class)
                .extracting(IllegalArgumentException.class::cast)
                .extracting(IllegalArgumentException::getMessage)
                .isEqualTo("Amount of deposit operation should be positive");
    }

    @Test
    void create_withdrawal_operation_when_negative_amount() {
        // Given
        Money amount = new Money(BigDecimal.valueOf(-100));
        // When
        Operation actual = Operation.createWithdrawalOperation(amount);
        // Then
        assertThat(actual).isNotNull();
    }

    @Test
    void fail_to_create_withdrawal_operation_when_positive_amount() {
        // Given
        Money amount = new Money(BigDecimal.valueOf(100));
        // When
        ThrowableAssert.ThrowingCallable throwingCallable = () ->
                Operation.createWithdrawalOperation(amount);
        // Then
        assertThatCode(throwingCallable).isInstanceOf(IllegalArgumentException.class)
                .extracting(IllegalArgumentException.class::cast)
                .extracting(IllegalArgumentException::getMessage)
                .isEqualTo("Amount of withdrawal operation should be negative");
    }
}