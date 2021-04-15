package com.bs.bank.account.kata.acceptance.account;

import com.bs.bank.account.kata.account.Account;
import com.bs.bank.account.kata.statement.Statement;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountStepDefinitions {
    private Account account;
    private Statement statement;

    @Before
    public void setUp() {
        account = new Account();
    }

    @When("^I ask the statement$")
    public void i_ask_the_statement() {
        statement = account.getStatement();
    }

    @Then("^There are no statement lines")
    public void there_are_no_statement_lines() {
        assertTrue(statement.getLines().isEmpty());
    }
}
