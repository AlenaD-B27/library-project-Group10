@db @Vitalii
Feature: As a librarian, I want to know what genre of books is being borrowed the most

  Scenario: verify the common book genre that’s being borrowed
    Given Establish the database connection by Vitalii
    When I execute query to find most popular book genre by Vitalii
    Then verify "Action and Adventure" is the most popular book genre by Vitalii