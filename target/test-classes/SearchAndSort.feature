Feature: As a User I want to search and specific article


  @testing
  Scenario Outline: Search a article from specific trademark and sort
    Given I am on start page using "<browser>"
    When I search "<Item>"
    And I sort "<Sort order>"
    Then I can find article "<Sorted by>"


    Examples:
      | Item          | Sort order                  | Sorted by            | browser |
      | Mug           |  Price, low to high         | Price, low to high   | chrome  |
      | Cushion       |  Price, high to low         | Price, high to low   | chrome  |
      | Hummingbird   |  A to Z                     | A to Z               | chrome  |
      | Sweater       |  Relevance                  | Relevance            | chrome  |
      | Accessories   |  Z to A                     | Relevance            | chrome |
      | Mug           |  Price, low to high         | Price, low to high   | firefox  |
      | Cushion       |  Price, high to low         | Price, high to low   | firefox  |
      | Hummingbird   |  A to Z                     | A to Z               | firefox  |
      | Sweater       |  Relevance                  | Relevance            | firefox  |
      | Accessories   |  Z to A                     | Relevance            | firefox |



  @testing
  Scenario: Subcribe for newsletter with a no proper email address
    Given I am on start page using "firefox"
    When I write "lottaberg"
    Then I expect an error message



