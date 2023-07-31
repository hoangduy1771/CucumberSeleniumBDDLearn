Feature: Feature testing Google search functionality

  Scenario: Validate Google search is working
    Given User open browser
    And User navigate to Google
    When User enters text in the search box
    And User click Search
    Then User can view the results