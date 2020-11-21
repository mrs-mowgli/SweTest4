Feature: Checkingout Products When Logged In


  Scenario: Checkout And pay With Without Previously Filled Address
    Given I'am Logged In
    And   Have Products In Cart
    When  I Checkout
    Then  I Have To Enter Adress
    And   Choose "<Shipping Method>"
    And   Choose "<Payment Method>"
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email

  Scenario Outline: Checkout And Pay By Check

    And   Have Products In Cart
    When  I Checkout
    Then  Choose "<Shipping Method>"
    And   Choose "<Payment Method>"
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email


    Examples:
      |PrestShop  |Check    |
      |PrestShop  |Bank Wire|
      |My carrier |Check    |
      |My carrier |Bank Wire|