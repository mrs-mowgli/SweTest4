Feature: Checkingout Products When Logged In

  Scenario: Checkout And Pay With Check
    Given I am on start page using "firefox"
    And   I am Logged In
    And   Have Products In Cart
    When   I Checkout
    Then  Choose Shipping "My carrier"
    And   Choose Payment "Check"
    And   I choose to agree to the terms Of Service
    And   Order Is Placed
    And   I Get Conformation Email

  Scenario Outline: Checkout And Pay With Check
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

  Scenario: Checkout And Without Choosing Payment Option
    Given I am on start page using "firefox"
    And   I am Logged In
    And   Have Products In Cart
    When  I Checkout
    And   Choose Shipping "PrestShop"
    And   I choose to agree to the terms Of Service
    Then  It Should Not be Possible to Continue Checkout

  Scenario: Checkout Without Agreeing To Terms Of Service
    Given I am on start page using "chrome"
    And   I am Logged In
    And   Have Products In Cart
    When  I Checkout
    And   Choose Shipping "PrestShop"
    And   Choose Payment "Wire"
    Then  It Should Not be Possible to Continue Checkout