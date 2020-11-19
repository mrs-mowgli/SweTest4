Feature: Sign in to website

  Scenario: Create new user
    Given I am on the create an account page
    When I choose a Social title
    And I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in Password
    And I fill in Birth date
    And I choose to agree to the terms
    And I click on save
    Then an account is created with the provided information

  Scenario: Create user with already existing email
    Given I am on the create an account page
    When I choose a Social title
    And I fill in First name
    And I fill in Last name
    And I fill in an already existing email
    And I fill in Password
    And I fill in Birth date
    And I choose to agree to the terms
    And I click on save
    Then an error message should appear
    And an account was not created