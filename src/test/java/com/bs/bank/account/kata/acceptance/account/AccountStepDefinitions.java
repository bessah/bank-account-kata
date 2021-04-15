package com.bs.bank.account.kata.acceptance.account;

import com.bs.bank.account.kata.Money;
import com.bs.bank.account.kata.account.Account;
import com.bs.bank.account.kata.statement.Statement;
import com.bs.bank.account.kata.statement.StatementLine;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountStepDefinitions {
    private Account account;
    private Statement statement;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Given("^I deposit (\\d+) euros$")
    public void i_deposit(BigDecimal amount) {
        account.deposit(new Money(amount));
    }

    @When("^I ask the statement$")
    public void i_ask_the_statement() {
        statement = account.getStatement();
    }

    @Then("^There are no statement lines")
    public void there_are_no_statement_lines() {
        assertTrue(statement.getLines().isEmpty());
    }

    @Then("^My statement lines should be:$")
    public void my_statement_lines_should_be(List<Map<String, String>> expectedStatementLines) {
        assertEquals(expectedStatementLines.size(), statement.getLines().size());
        for (int i = 0; i < expectedStatementLines.size(); i++) {
            Map<String, String> expected = expectedStatementLines.get(i);
            StatementLine actual = statement.getLines().get(i);

            assertEquals(expected.get("operation_type"), actual.getOperation().getType().name());
            assertEquals(toMoney(expected.get("operation_amount")), actual.getOperation().getAmount());
            assertEquals(toMoney(expected.get("balance")), actual.getBalance());
        }
    }

    private Money toMoney(String amountStringValue) {
        return new Money(new BigDecimal(amountStringValue));
    }
}
