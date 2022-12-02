@db @Maria
Feature: Books module: As a student, I should be able to borrow a book

  Scenario: Students borrow new books
    Given I login as a "student" by Maria
    And I navigate to "Books" page by Maria
    And I search book name called "Head First Java" by Maria
    When I click Borrow Book by Maria
    Then  verify that book is shown in "Borrowing Books" page by Maria
    And  verify logged student has same book in database by Maria