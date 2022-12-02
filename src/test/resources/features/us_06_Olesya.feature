@db @Olesya
Feature: Books module: As a librarian, I should be able to add new books to the library

  Scenario Outline: Verify added book is matching with DB
    Given I login as a "librarian" by Olesya
    And I navigate to "Books" page by Olesya
    When the librarian click to add book by Olesya
    And the librarian enter book name "<Book Name>" by Olesya
    When the librarian enter ISBN "<ISBN>" by Olesya
    And the librarian enter year "<Year>" by Olesya
    When the librarian enter author "<Author>" by Olesya
    And the librarian choose the book category "<Book Category>" by Olesya
    And the librarian click to save changes by Olesya
    Then the librarian verify new book by "<Book Name>" by Olesya
    Then the librarian verify new book from database by "<Book Name>" by Olesya

    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Clean Code            | 09112021 | 2021 | Robert C.Martin | Drama                |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |