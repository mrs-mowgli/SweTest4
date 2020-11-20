# I denna featurefil finns alla scenarion för att skapa användare och logga in.
# Skapad av Mio Lundqvist 2020-11-19

Feature: Sign in to the website
  In order to access my account
  As a user
  I want to be able to sign in to the website

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

  Scenario: