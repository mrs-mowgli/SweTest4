# Skapad av Linus Finsbäck 2020-11-23
# Ändrad av Linus Finsbäck 2020-12-06

Feature: Place products in shopping cart

  @Testing
  Scenario Outline: Place product of type sweater in shopping cart and verify popup
    Given I am on start page using "<browser>"
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
      | firefox | men      | Hummingbird printed t-shirt | 3        | L    | Black | sweaterMen   |
      | firefox | men      | Hummingbird printed t-shirt | 2        | S    | White | sweaterMen   |
      | firefox | women    | Hummingbird printed sweater | 1        | S    | N.A   | sweaterWomen |

  @Testing
  Scenario Outline: Place product of type notebook in shopping cart and verify popup
    Given I am on start page using "<browser>"
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
      | firefox | stationary | Brown bear notebook   | 1        | Squarred  | notebook |
      | firefox | stationary | Hummingbird notebook  | 2        | Doted     | notebook |

  @Testing
  Scenario Outline: Place product of type mug in shopping cart and verify popup
    Given I am on start page using "<browser>"
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
      | chrome   | home accessories | Hummingbird cushion   | White | 2        | pillow  |
      | firefox  | home accessories | Hummingbird cushion   | Black | 2        | pillow  |

  @Testing
  Scenario Outline: Place product of type customizable mug in shopping cart and verify popup
    Given I am on start page using "<browser>"
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


  @Testing
  Scenario Outline: Place product of type customizable mug in shopping cart without customization set
    Given I am on start page using "<browser>"
    And I have selected category "<category>"
    And I have selected product "<product>"
    When I try to place product in shopping cart
    Then The add to cart button will not be interactable

    Examples:
      | browser  | category         | product           |
      | chrome   | home accessories | Customizable mug  |
      | firefox  | home accessories | Customizable mug  |

  @Testing
  Scenario Outline: Place product of type mug which is out of stock to shopping cart
    Given I am on start page using "<browser>"
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected quantity "<quantity>"
    When I try to place product in shopping cart
    Then The add to cart button will not be interactable

    Examples:
      | browser  | category         | product                     | quantity |
      | firefox  | home accessories | Mug The adventure begins    | 1        |
      | chrome   | home accessories | Mug The adventure begins    | 1        |

  @Testing
  Scenario Outline: Place more products of type pillow then what is available in stock
    Given I am on start page using "<browser>"
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected color "<color>"
    And I have selected too many products
    When I try to place product in shopping cart
    Then The add to cart button will not be interactable

  Examples:
    | browser | category         | product            | color |
    | chrome  | home accessories | Brown bear cushion | black |
    | firefox | home accessories | Brown bear cushion | black |


  @Testing
  Scenario Outline: Place package in shopping cart which include a product which is out of stock
    Given I am on start page using "<browser>"
    And I have selected category "<category>"
    And I have selected "<package>" including a product out of stock
    When I try to place product in shopping cart
    Then I expect the add to cart button to be uninteractable

    Examples:
      | browser | category         | package                  |
      | chrome  | home accessories | Pack Mug + Framed poster |
      | firefox | home accessories | Pack Mug + Framed poster |

  @Testing
  Scenario Outline: Place product in shopping cart from product quick view
    Given I am on start page using "<browser>"
    And I have opened quick view of an product at start page
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product was added to shopping cart

    Examples:
      | browser |
      | chrome  |
      | firefox |

  @Testing
  Scenario Outline: Place all available items of an product in cart and see that product will change to out of stock
    Given I am on start page using "<browser>"
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have added all available items of product to cart
    When I try to add one more item of same product
    Then The add to cart button will not be interactable

    Examples:
    | browser | category         | product                     |
    | chrome  | home accessories | Mug The best is yet to come |