# I denna featurefil finns alla scenarion för att skapa användare och logga in.
# Skapad av Mio Lundqvist 2020-11-19

Feature: Create an account
  In order to access my account
  As a user
  I want to be able to create an account

  Scenario: Create new account
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

  Scenario: Create account with already existing email
    Given I am on the create an account page
    When I choose a Social title
    And I fill in First name
    And I fill in Last name
    And I fill in an already existing email
    And I fill in Password
    And I fill in Birth date
    And I choose to agree to the terms
    And I click on save
    Then an error message should appear saying the email is already used
    And an account was not created

  Scenario Outline: Birth date in wrong format
    Given I am on the create an account page
    When I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in Password
    And I fill in a <birthdate> in a wrong format
    And I choose to agree to the terms
    And I click on save
    Then an error message should appear saying the birth date has a wrong format
  Examples:
  |birthdate   |
  | 19121212   |
  | 1912-12-12 |
  | 12121912   |
  | 1912/12/12 |
  | 12-12-1912 |

  Scenario: I do not check the terms and conditions box
    Given I am on the create an account page
    When I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in Password
    And I do not check the terms and conditions box
    And I click on save
    Then an error message should appear saying terms and conditions needs to be checked


  Scenario: Password in wrong format
    Given I am on the create an account page
    When I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in a password in a wrong format
    And I click on save
    Then an account was not created