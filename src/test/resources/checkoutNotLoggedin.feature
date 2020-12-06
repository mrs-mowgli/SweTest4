#Test för att visa flödet hur funktioner anropas i andra klasser och hur keywords anges redan i cucumber filen
#Skapad av Linus Finsbäck 2020-11-20

Feature: Test

  Scenario Outline: Add item to cart and checkout. Happytest.
    #Given I am on start page using "<browser>"
    Given start
    Given Have Products In Cart
    And Proceed to checkout
    When I am in cart
    And I fill in personal information
    And I fill in Addresses
    And I Fill in shipping method
    And I choose payment
    #Then I see Order confirmation

    #Lägg till så att de körs flera gånger o tester olika shipping och payment.
    #Varför funkar inte firefox..?

    Examples:
    |browser|
    |chrome |
    #|firefox|

    Scenario Outline: Add item to cart and checkout. Negative test, personal information.
      #Given I am on start page using "<browser>"
      Given start
      Given Have Products In Cart
      And Proceed to checkout
      When I am in cart
      And I fill in wrong firstname "<firstname>"
      And I fill in wrong lastname "<lastname>"
      And I fill in email "<email>"
      And I click on agree to terms and conditions
      Then Invalid fields in personal information


      Examples:
      |browser  |firstname |lastname|email|
      |chrome   |0123456789|2345678 |test@iths.se|


  Scenario Outline: Add item to cart and checkout. Negative test, addresses.
      #Given I am on start page using "<browser>"
      Given start
      Given Have Products In Cart
      And Proceed to checkout
      When I am in cart
      And I fill in personal information
      And I fill in address "<address>"
      And I fill in invalid postalcode "<postalcode>"
      And I fill in invalid city "<city>"

        #Then Invalid fields in personal information

  Examples:
    |browser|address|postalcode|city|
    |chrome |hejoh  |3444434   |4567|

