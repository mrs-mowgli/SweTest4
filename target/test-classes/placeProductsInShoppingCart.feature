# Skapad av Linus Finsbäck 2020-11-23
# Ändrad av Linus Finsbäck 2020-12-06

Feature: Place products in shopping cart

  @Testing
  Scenario Outline: Place product of type sweater in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected size "<size>"
    And I have selected color "<color>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser | category | product                     | quantity | size | color | type         |
      | chrome  | men      | Hummingbird printed t-shirt | 3        | M    | Black | sweaterMen   |
      | chrome  | men      | Hummingbird printed t-shirt | 2        | XL   | White | sweaterMen   |
      | chrome  | women    | Hummingbird printed sweater | 1        | L    | N.A   | sweaterWomen |
      | chrome  | women    | Hummingbird printed sweater | 1        | S    | N.A   | sweaterWomen |
      | firefox | men      | Hummingbird printed t-shirt | 3        | M    | Black | sweaterMen   |
      | firefox | men      | Hummingbird printed t-shirt | 2        | S    | White | sweaterMen   |
      | firefox | women    | Hummingbird printed sweater | 1        | S    | N.A   | sweaterWomen |

  @Testing
  Scenario Outline: Place product of type notebook in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected paperType "<paperType>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser | category   | product               | quantity | paperType | type     |
      | chrome  | stationary | Mountain fox notebook | 3        | Ruled     | notebook |
      | chrome  | stationary | Brown bear notebook   | 1        | Plain     | notebook |
      | chrome  | stationary | Brown bear notebook   | 1        | Squarred  | notebook |
      | chrome  | stationary | Hummingbird notebook  | 2        | Doted     | notebook |
      | firefox | stationary | Mountain fox notebook | 3        | Ruled     | notebook |
      | firefox | stationary | Brown bear notebook   | 1        | Plain     | notebook |
      | firefox | stationary | Brown bear notebook   | 1        | Squarred  | notebook |
      | firefox | stationary | Hummingbird notebook  | 2        | Doted     | notebook |

  @Testing
  Scenario Outline: Place product of type mug in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser  | category         | product                     | quantity | type |
      | chrome   | home accessories | Mug The best is yet to come | 3        | mug  |
      | firefox  | home accessories | Mug The adventure begins    | 1        | mug  |

  @Testing
  Scenario Outline: Place product of type pillow in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected color "<color>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser  | category         | product               | color | quantity | type    |
      | chrome   | home accessories | Mountain fox cushion  | Black | 3        | pillow  |
      | firefox  | home accessories | Brown bear cushion    | White | 1        | pillow  |
      | chrome   | home accessories | Hummingbird cushion   | Black | 2        | pillow  |
      | firefox  | home accessories | Hummingbird cushion   | Black | 2        | pillow  |

  @Testing
  Scenario Outline: Place product of type customizable mug in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have added my custom "<text>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser  | category         | product           | text     | quantity | type    |
      | chrome   | home accessories | Customizable mug  | testText | 3        | mug     |
      | firefox  | home accessories | Customizable mug  | firefox  | 2        | mug     |

  @Testing
  Scenario Outline: Place product of type framed poster in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected dimension "<dimension>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser | category | product                 | dimension | quantity | type    |
      | chrome  | art      | The best is yet to come | 40x60cm   | 3        | poster  |
      | firefox | art      | The best is yet to come | 60x90cm   | 1        | poster  |
      | chrome  | art      | Today is a good day     | 80x120cm  | 4        | poster  |
      | firefox | art      | Today is a good day     | 40x60cm   | 3        | poster  |
      | chrome  | art      | The adventure begins    | 60x90cm   | 1        | poster  |
      | firefox | art      | The adventure begins    | 80x120cm  | 4        | poster  |

  @Testing
  Scenario Outline: Place product of type Vector Graphics in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<type>" was added to shopping cart

    Examples:
      | browser | category | product                        | quantity | type    |
      | chrome  | art      | Mountain fox - Vector graphics | 3        | vector  |
      | firefox | art      | Brown bear - Vector graphics   | 1        | vector  |


  @Testing
  Scenario Outline: Place product in shopping cart and continue shopping
    Given I am on start page using "<browser>"
    And I have selected a product from start page
    When I place product in shopping cart
    And I continue to shop from pop up
    Then I will stay at product page
    And Shopping cart will contain one item
  Examples:
    | browser |
    | chrome  |
    | firefox |

  @Testing
  Scenario Outline: Place product in shopping cart and check content
    #Given I am on start page
    Given I am on start page using "<browser>"
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected size "<size>"
    And I have selected color "<color>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    And I continue to shopping cart from pop up
    Then I will see content of my shopping cart
  Examples:
    | browser | category | product                     | size | color | quantity |
    | chrome  | men      | Hummingbird printed t-shirt | L    | Black | 2        |
    | firefox | men      | Hummingbird printed t-shirt | M    | White | 3        |

  # Negative tests
  # Add customized mug to cart without customization
  # add product out of stock to cart
  # add to many products to cart
  # Possible to buy mug which is out off stock if buying it in package