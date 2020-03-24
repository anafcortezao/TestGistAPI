Feature: Update gist
  Scenario: Update gist
    Given I have a gist
    When I update the gist file
    Then The gist file is updated