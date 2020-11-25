Feature: As a User I want to search and specific article

  @testing
  Scenario Outline: Search a article from specific trademark and sort
    Given I am on start page
    When user search "<Item>"
    And user sort "<Sort order>"
    Then user can find article "<Sorted by>"

    Examples:
      | Item          | Sort order                  | Sorted by            |
      | Mug           |  Price, low to high         | Price, low to high   |
      | Cushion       |  Price, high to low         | Price, high to low   |
      | Hummingbird   |  A to Z                     | A to Z               |
      | Sweater       |  Relevance                  | Relevance          |




