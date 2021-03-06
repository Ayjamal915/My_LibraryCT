Feature: As a librarian, I should be able to see book records on user page

  @wip5
  Scenario: Login as librarian
    Given I am on the login page
    When I click on "user" link
    Then Show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |