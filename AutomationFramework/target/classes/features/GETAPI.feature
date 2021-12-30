Feature: To test all the GET API calls

  @GETAPI
  Scenario Outline: To test all the GET API calls
    Given I am on Regres application
    When I check all the <EndPoints>
    Then I verify the <StatusCode>

    Examples:
      | EndPoints          | StatusCode |
      | /api/users?page=2  | 200        |
      | /api/users/2       | 200        |
      | /api/users/23      | 404        |
      | /api/unknown       | 200        |
      | /api/unknown/2     | 200        |
      | /api/unknown/23    | 404        |
      | /api/users?delay=3 | 200        |
