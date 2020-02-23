Feature: Filtering tasks by status

  In order to make me feel a sense of accomplishment
  As a forgetful person
  I want to be to view all of things I have completed


  Scenario: Viewing active items
    Given that Jane has a todo list containing Buy some milk, Walk the dog
    And she has completed the task called 'Walk the dog'
    When she filters her list to show only Active tasks
    Then her todo list should contain Buy some milk

  Scenario Outline: Viewing items by status
    Given that Jane has a todo list containing <tasks>
    And she has completed the task called 'Walk the dog'
    When she filters her list to show only <filter> tasks
    Then her todo list should contain <expected>
    Examples:
      | tasks                       | filter    | expected      |
      | Buy some milk, Walk the dog | Active    | Buy some milk |
      | Buy some milk, Walk the dog | Completed | Walk the dog  |