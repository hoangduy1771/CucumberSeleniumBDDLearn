@Smoke
Feature: Feature to test login function

  @SmokeTest @test
  Scenario Outline: Check login is successful with valid credentials
    Given User is on login page
    When User enters <username> and <password>
    And User clicks on login button
    Then User can navigate to the homepage
    Examples:
      | username | password |
      | userName | passWord |