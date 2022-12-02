@db @Vitalii
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.

  Background:
    Given Establish the database connection by Vitalii

  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users by Vitalii
    Then verify all users has unique ID by Vitalii

  Scenario: verify users table columns
    When Execute query to get all columns by Vitalii
    Then verify the below columns are listed in result by Vitalii
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |