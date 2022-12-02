@db @Elena
Feature: As a librarian, I want to know borrowed books number

  Scenario: verify the total amount of borrowed books
    Given user login as a "librarian" by Elena
    When user take borrowed books number by Elena
    Then borrowed books number information must match with DB by Elena