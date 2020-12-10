# Skapad av Linus Finsbäck 2020-11-23
# Ändrad av Linus Finsbäck 2020-12-06

Feature: Place products in shopping cart

  @Testing
  Scenario Outline: Place product of type clothes in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected quantity "<quantity>"
    And I have selected size "<size>"
    And I have selected color "<color>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<category>" was added to shopping cart

    Examples:
    | browser | category | product                     | quantity | size | color |
    | chrome  | men      | Hummingbird printed t-shirt | 3        | M    | Black |
    | chrome  | men      | Hummingbird printed t-shirt | 2        | XL   | White |
    | chrome  | women    | Hummingbird printed sweater | 1        | L    | N.A   |
    | chrome  | women    | Hummingbird printed sweater | 1        | S    | N.A   |

  @Testing
  Scenario Outline: Place product of type notebook in shopping cart and verify popup
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected category "<category>"
    And I have selected product "<product>"
    And I have selected paperType "<paperType>"
    And I have selected quantity "<quantity>"
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product of "<category>" was added to shopping cart

    Examples:
      | browser | category   | product               | quantity | paperType |
      | chrome  | stationary | Mountain fox notebook | 3        | Plain     |
      | chrome  | stationary | Brown bear notebook   | 1        | Plain     |
      | chrome  | stationary | Brown bear notebook   | 1        | Squarred  |
      | chrome  | stationary | Hummingbird notebook  | 2        | Doted     |

#  @Testing
#  Scenario: Place product in shopping cart and continue shopping
#    Given I am on start page
#    And I have selected a product
#    When I place product in shopping cart
#    And I continue to shop from pop up
#    Then I will stay at product page
#
#  @Testing
#  Scenario: Place product in shopping cart and check content
#    Given I am on start page
#    And I have selected category clothes men
#    And I have selected a product
#    When I place product in shopping cart
#    And I continue to shopping cart from pop up
#    Then I will see content of my shopping cart