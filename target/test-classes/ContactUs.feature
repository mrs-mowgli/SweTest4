# I denna featurefil finns alla scenarion för att kontakta kundservice via Contact us-sidan.
# Skapad av Mio Lundqvist 2020-11-25.

Feature: Contact customer service
  In order to get help
  As a user
  I want to be able to contact customer service

  Scenario Outline: Contact customer service
    Given I am on start page using "<browser>"
    When I click on Contact us
    And I choose a <subject>
    And I fill in Email address
    And I fill in a message
    And I click on send
    Then a message is sent to the customer service
    Examples:
      |subject           | browser
      | Customer service | chrome
      | Webmaster        | chrome
      | Customer service | firefox
      | Webmaster        | firefox

  Scenario Outline: No email is provided
    Given I am on start page using "<browser>"
    When choose a subject
    And I fill in a message
    And I click on send
    Then a message is not sent
    Examples:
      |browser|
      |chrome|
      |firefox|

