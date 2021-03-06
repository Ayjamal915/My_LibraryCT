Feature: As a librarian, I should be able to add users from users
  page.

  @wip4
  Scenario: Login as librarian
    Given I am on the login page
    When I click on "Add User" tab.
    Then I should be able add users with valid information.
    And I able to close the add user window by clicking on close button.


