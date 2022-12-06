@db @Aysun
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.

  Background:
    Given Establish the database connection by Aysun

  @db
  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users by Aysun
    Then verify all users has unique ID by Aysun

  @db
  Scenario: verify users table columns
    When Execute query to get all columns by Aysun
    Then verify the below columns are listed in result by Aysun
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