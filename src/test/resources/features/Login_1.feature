Feature: Login
  # As a user, I should be able to login to the library app.
  @wip1
  Scenario Outline: : verify both students and  librarians can login
    Given the user login as a "<role>"
    Then the user is on "<page>" page
    Then the user logout
    Examples:
      | role      | page      |
      | student   | books     |
      | librarian | dashboard |