Feature: As a student, I should be able
  to see tables with default info,
  search books with different categories
  and see my borrowing books.

  @wip6
  Scenario: As a student,I should be able to see columns names
    Given user login as a "student"
    Then the user should see the following book column names
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |

    When the user click Borrowing Books module
    Then the user should see the following borrowed books column names
      | Action              |
      | Book Name           |
      | Borrowed Date       |
      | Planned Return Date |
      | Return Date         |
      | Is Returned ?       |
