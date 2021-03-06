Feature: user status feature

  @wip2
  Scenario: verify user status
    Given the user "librarian" on the homepage
    When the user click users module
    And the user click Status dropdown
    Then  the user should see the following column names
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |
    And the user should see the following options

      | ACTIVE   |
      | INACTIVE |
    And the user should see the following user group options:
      | ALL           |
      |Librarian      |
      |Students       |
