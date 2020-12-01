# Skapad av Linus Finsbäck 2020-11-23
# Ändrad av

Feature: Place products in shopping cart

  @Testing
  Scenario: Place product in shopping cart
    Given I am on start page
    And I have selected a product
    When I place product in shopping cart
    Then I will see a pop up with confirmation that product was added to shoppning cart

  @Testing
  Scenario: Place product in shopping cart and continue shopping
    Given I am on start page
    And I have selected a product
    When I place product in shopping cart
    And I continue to shop from pop up
    Then I will stay at product page

  @Testing
  Scenario: Place product in shopping cart and check content
    Given I am on start page
    And I have selected category clothes men
    And I have selected a product
    When I place product in shopping cart
    And I continue to shopping cart from pop up
    Then I will see content of my shopping cart