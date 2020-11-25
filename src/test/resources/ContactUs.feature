# I denna featurefil finns alla scenarion för att kontakta kundservice via Contact us-sidan.
# Skapad av Mio Lundqvist 2020-11-25.

Feature: Contact customer service
  In order to get help
  As a user
  I want to be able to contact customer service

  Scenario Outline: Contact customer service
    Given I am on the contact us page
    When I choose a <subject>
    And I fill in Email address
    And I fill in a message
    And I click on send
    Then a message is sent to the customer service
    Examples:
      |subject           |
      | Customer service |
      | Webmaster        |

  Scenario: No email is provided
    Given I am on the contact us page
    When choose a subject
    And I fill in a message
    And I click on send
    Then a message is not sent
