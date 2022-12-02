@db @Alina
Feature: Books module: As a student, I should be able to borrow a book

  Scenario: Students borrow new books
    Given I login as a "student" by Alina
    And I navigate to "Books" page by Alina
    And I search book name called "Head First Java" by Alina
    When I click Borrow Book by Alina
    Then  verify that book is shown in "Borrowing Books" page by Alina
    And  verify logged student has same book in database by Alina