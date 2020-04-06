Feature: Create gist
  Scenario: Create gist
    Given I want to create a gist file
    When I add a new gist with files
    Then The gist with the files is created