#Feature för att beskriva alla scenarios kring Filter funktionen
#Skapad av Sebastian Wimmer 2020-11-22
#Uppdaterad av

Feature: Filter items
  As a user
  I want to be able to filter products
  In order to find the products I want to buy

  Scenario Outline: Filter accessories by categories
    Given I am on the accessories page
    When I click on the <filter> filter
    Then only items of the category <filter> should be displayed
    Examples:
      | filter           |
      | Stationary       |
      | Home Accessories |


  #Scenario: Filter clothes
  #  Given a user is on the clothes page
  #  When the user clicks on the a filter
  #  Then only items of the matching the selected filter should be displayed
  #
  #Scenario: Filter clothes
  #  Given a user is on the accessories page
  #  When the user clicks on the a filter
  #  Then only items of the matching the selected filter should be displayed
  #
  #Scenario: Filter art
  #  Given a user is on the art page
  #  When the user clicks on the a filter
  #  Then only items of the matching the selected filter should be displayed