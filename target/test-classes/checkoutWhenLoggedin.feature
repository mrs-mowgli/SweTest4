Feature: Checkingout Products When Logged In

  #Scenario: Checkout And Pay With Check
   # Given I am Logged In
   # And   Have Products In Cart
   # When  I Checkout
   # Then  Choose Shipping
   # And   Choose Payment
   # And   I choose to agree to the terms Of Service
   # And   Order Is Placed
   # And   I Get Conformation Email

  Scenario Outline: Checkout And Pay With Check
    Given I am Logged In
    And   Have Products In Cart
    When  I Checkout
    Then  Choose Shipping "<SMethod>"
    And   Choose Payment "<PMethod>"
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email

  Examples:
    |SMethod   |PMethod|
    |PrestShop  |Check  |
    |PrestShop  |Wire   |
    |My carrier |Check  |
    |My carrier |Wire   |



#negative
 #  change all obligatory fields for personal info and address

