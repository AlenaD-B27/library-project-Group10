@db @Cumali
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given I login as a "librarian" by Cumali
    And I navigate to "Books" page by Cumali
    When I open book "Chordeiles minor" by Cumali
    Then book information must match the Database by Cumali