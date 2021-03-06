@wip3
Feature: As a user, I should be able to  see several modules once I login.
  Scenario:
    Given the student on the home page
    Then the student should see following modules
      | Books           |
      | Borrowing Books |
  Scenario:
  Librarians  should have access to 3 modules
    Given the librarian on the homepage
    Then the librarian should see following modules
      | Dashboard       |
      | Users           |
      | Books |