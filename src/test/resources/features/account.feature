Feature: Bank Account

  Scenario: Create an account and ask the statement lines
    When I ask the statement
    Then There are no statement lines