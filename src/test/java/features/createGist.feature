Feature: Create gist
  Scenario: Create gist
    Given I have a token
    When I add a new gist with files
    Then The gist with the files is created