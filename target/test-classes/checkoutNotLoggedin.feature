#Test för att visa flödet hur funktioner anropas i andra klasser och hur keywords anges redan i cucumber filen
#Skapad av Linus Finsbäck 2020-11-20

Feature: Test

  Scenario Outline: Add item to cart and checkout. Happytest.
    #Given I am on start page using "<browser>"
    Given start
    #Given Have Products In Cart
    When put something in cart
    And Proceed to checkout
    When I am in cart
    And I fill in personal information
    And I fill in Addresses
    And I Fill in shipping method "<shipping_method>"
    And I choose payment "<payment>"
    #Then I see Order confirmation



    Examples:
   |browser |shipping_method|payment|
   #NOK
   |chrome  |PrestShop      |check  |
   #OK
   |chrome  |My Carrier     |wire   |
    #|firefox|
    #firefox..?

    Scenario Outline: Add item to cart and checkout. Negative test, personal information.
      #Given I am on start page using "<browser>"
      Given start
      #Given Have Products In Cart
      When put something in cart
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
      |chrome   |sfghjhd!  |sgmjifg?|test@iths.se|

  Scenario Outline: Add item to cart and checkout. Negative test, addresses.
      #Given I am on start page using "<browser>"
      Given start
      #Given Have Products In Cart
      When put something in cart
      And Proceed to checkout
      When I am in cart
      And I fill in personal information
      And I fill in address "<address>"
      And I fill in invalid postalcode "<postalcode>"
      And I fill in invalid city "<city>"

        #Then Invalid fields in personal information

  Examples:
    |browser|address|postalcode|city|
    |chrome |hejhej |3444434   |4567|
    |chrome |fika   |23 23     |Göteborg|

