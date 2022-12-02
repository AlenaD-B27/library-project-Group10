@db @Alena
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given I login as a "librarian" by Alena
    And I navigate to "Books" page by Alena
    When I open book "Chordeiles minor" by Alena
    Then book information must match the Database by Alena