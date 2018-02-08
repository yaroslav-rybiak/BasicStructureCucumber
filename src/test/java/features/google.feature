Feature: Google search
  Scenario: User is able to search via google
    Given User is on main google page
    When User inputs search query and clicks 'Google Search' button
    Then User is redirected on google page with search results
