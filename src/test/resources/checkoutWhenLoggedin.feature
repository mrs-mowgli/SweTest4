Feature: Checkingout Products When Logged In

  Scenario: Checkout And Pay By Check
    Given I am Logged In
    And   Have Products In Cart
    When  I Checkout
    Then  Choose Shipping
    And   Choose Payment
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email
