# I denna featurefil finns alla scenarion för att skapa användare.
# Skapad av Mio Lundqvist 2020-11-19. Senast ändrad 2020-11-25.

Feature: Create an account
  In order to access my account
  As a user
  I want to be able to create an account

  Scenario Outline: Create new account
    Given I am on start page using "<browser>"
    When I go to the create an account page
    And I choose a Social title
    And I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in Password
    And I fill in Birth date
    And I choose to agree to the terms
    And I click on save
    Then an account is created with the provided information

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Create account with already existing email
    Given I am on start page using "<browser>"
    When I go to the create an account page
    And I choose a Social title
    And I fill in First name
    And I fill in Last name
    And I fill in an already existing email
    And I fill in Password
    And I fill in Birth date
    And I choose to agree to the terms
    And I click on save
    Then an error message should appear saying the email is already used
    And an account was not created

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Birth date in wrong format
    Given I am on start page using "<browser>"
    When I go to the create an account page
    And I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in Password
    And I fill in a <birthdate> in a wrong format
    And I choose to agree to the terms
    And I click on save
    Then an error message should appear saying the birth date has a wrong format
  Examples:
   |browser |birthdate  |
   |chrome | 19121212   |
   |chrome | 1912-12-12 |
   |chrome | 12121912   |
   |chrome | 1912/12/12 |
   |chrome | 12-12-1912 |
   |firefox | 19121212   |
   |firefox | 1912-12-12 |
   |firefox | 12121912   |
   |firefox | 1912/12/12 |
   |firefox | 12-12-1912 |

  Scenario Outline: I do not check the terms and conditions box
    Given I am on start page using "<browser>"
    When I go to the create an account page
    And I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in Password
    And I do not check the terms and conditions box
    And I click on save
    Then an error message should appear saying terms and conditions needs to be checked

    Examples:
      | browser |
      | chrome  |
      | firefox |

  Scenario Outline: Password in wrong format
    Given I am on start page using "<browser>"
    When I go to the create an account page
    And I fill in First name
    And I fill in Last name
    And I fill in Email
    And I fill in password in a wrong format
    And I click on save
    Then an account was not created

    Examples:
      | browser |
      | chrome  |
      | firefox |