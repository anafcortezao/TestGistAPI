Feature: List gists
  Scenario: List gists for a user
    Given I have an user
    When I get a gists list for the user
    Then All public gists for the user are list
