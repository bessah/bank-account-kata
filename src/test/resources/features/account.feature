Feature: Bank Account

  Scenario: Create an account and ask the statement lines
    When I ask the statement
    Then There are no statement lines

  Scenario: Deposit 100 euros and ask the statement lines
    Given I deposit 100 euros
    When I ask the statement
    Then My statement lines should be:
      | operation_type | operation_amount | balance |
      | DEPOSIT        | 100              | 100     |

  Scenario: Withdrawal 50 and ask the statement lines
    Given I withdrawal 50 euros
    When I ask the statement
    Then My statement lines should be:
      | operation_type | operation_amount | balance |
      | WITHDRAWAL     | -50              | -50     |

  Scenario: Multiple Deposit / Withdrawal and ask the statement lines
    Given I deposit 100 euros
    And I deposit 500 euros
    And I withdrawal 50 euros
    When I ask the statement
    Then My statement lines should be:
      | operation_type | operation_amount | balance |
      | DEPOSIT        | 100              | 100     |
      | DEPOSIT        | 500              | 600     |
      | WITHDRAWAL     | -50              | 550      |