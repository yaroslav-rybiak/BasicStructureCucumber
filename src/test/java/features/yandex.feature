Feature: Yandex search
  Scenario: User is able to search via yandex
    Given User is on main yandex page
    When User inputs search query and clicks 'Find' button
    Then User is redirected on yandex page with search results
