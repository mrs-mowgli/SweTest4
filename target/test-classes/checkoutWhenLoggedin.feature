Feature: Checkingout Products When Logged In

  Scenario: Checkout And Pay With Check
    Given I am on start page using "firefox"
    And   I am Logged In
    And   Have Products In Cart
    When  I Checkout
    Then  Choose Shipping "My carrier"
    And   Choose Payment "Check"
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email

  """Scenario Outline: Checkout And Pay With Check
    Given I am on start page using "<Browser>"
    And   I am Logged In
    And   Have Products In Cart
    When  I Checkout
    Then  Choose Shipping "<SMethod>"
    And   Choose Payment "<PMethod>"
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email

  Examples:
    |SMethod    |PMethod|Browser |
    |PrestShop  |Check  |chrome|
    |PrestShop  |Wire   |chrome|
    |My carrier |Check  |chrome|
    |My carrier |Wire   |chrome|

"""

#negative
 #  change all obligatory fields for personal info and address

