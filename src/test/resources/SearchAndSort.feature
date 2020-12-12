Feature: As a User I want to search and specific article and subscribe for newsletter


  @testing
  Scenario Outline: Search a article from specific trademark and sort
    Given I am on start page using "<browser>"
    When I search "<Item>"
    And I sort "<Sort order>"
    Then I can find article "<Item>"


    Examples:
      | Item          | Sort order                  | browser |
      | Mug           |  Price, low to high         | chrome  |
      | Cushion       |  Price, high to low         | chrome  |
      | Hummingbird   |  A to Z                     | chrome  |
      | Sweater       |  Relevance                  | chrome  |
      | Mug           |  Price, low to high         | firefox  |
      | Cushion       |  Price, high to low         | firefox  |
      | Hummingbird   |  A to Z                     | firefox  |
      | Sweater       |  Relevance                  | firefox  |




  @testing
  Scenario: Subcribe for newsletter with a no proper email address
    Given I am on start page using "firefox"
    When I write "lottaberg"
    Then I expect an error message



