@Smoke
Feature: Feature to test login function

  @SmokeTest @test
  Scenario Outline: Check login is successful with valid credentials
    Given User navigate to "https://example.testproject.io/web/" with <browser>
    When User enters <username> and <password>
    And User clicks on login button
    Then User can navigate to the homepage
    Examples:
      | username | password | browser  |
      | example  | 12345    | "Chrome"  |
      | HoangDuy | 12345    | "Chrome"  |
      | example  | 12345    | "Firefox" |
      | HoangDuy | 12345    | "Firefox" |
