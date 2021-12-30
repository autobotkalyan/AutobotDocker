Feature: To test all combinations in Login module

  @Login @Smoke
  Scenario Outline: To Test the combinations of all data of username and password
    Given I am on Mercury application
    Given I enter <UserName> and <Password>
    And I click on submit button
    Then I am on the HomePage

    Examples:
      | UserName | Password |
      | test1    | test1    |
      | test2    | test2    |
