@db @Olga
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given I login as a "librarian" by Olga
    When I navigate to "Books" page by Olga
    And I take all book categories in UI by Olga
    And I execute query to get book categories by Olga
    Then verify book categories must match book_categories table from db by Olga

      | Action and Adventure    |
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |