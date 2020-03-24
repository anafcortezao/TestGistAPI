Feature: Delete gist
  Scenario: Delete gist
    Given I have a gist
    When I delete the gist file
    Then The gist file is deleted