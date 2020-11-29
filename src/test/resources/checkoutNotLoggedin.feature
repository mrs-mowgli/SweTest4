#Test för att visa flödet hur funktioner anropas i andra klasser och hur keywords anges redan i cucumber filen
#Skapad av Linus Finsbäck 2020-11-20

Feature: Test

  Scenario: Add item to cart
    Given I am at webshop start page ecommerce
    And Have Products In Cart
    And Proceed to checkout

  Scenario: Checkout from cart as an uninlogged costumer
    Given I am in cart
    When I fill in personal information
    And I fill in Addresses
    And I Fill in shipping method
    And I choose payment
    #Then I see Order confirmation
    Then close Browser



