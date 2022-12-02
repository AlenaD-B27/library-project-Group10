@db @Jasmine
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given I login as a "librarian" by Jasmine
    When I navigate to "Books" page by Jasmine
    And I take all book categories in UI by Jasmine
    And I execute query to get book categories by Jasmine
    Then verify book categories must match book_categories table from db by Jasmine