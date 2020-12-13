#Feature för att beskriva alla scenarios kring Filter funktionen
#Skapad av Sebastian Wimmer 2020-11-22
#Uppdaterad av Sebastian Wimmer 2020-12-12

Feature: Filter items
  As a user
  I want to be able to filter products
  In order to find the products I want to buy

  @testing
  Scenario: Filter accessories by categories
    Given I am on start page using "chrome"
    When I click on accessories page
    When I click on the stationery filter
    Then only items of the category stationery should be displayed
  
  @testing
  Scenario Outline: Filter categories
    Given I am on start page using "<browser>"
    #Given I am on start page
    And I have selected main category "<category>"
    When I select filter "<filter>"
    Then the selected "<filter>" should be active
  #Then only items matching the "<filter>" should be displayed

  Examples:
  | browser  | category         | filter             |
  | chrome   | accessories      | Stationery         |
  | firefox  | clothes          | White              |
  | chrome   | clothes          | Black              |
  | firefox  | clothes          | Small              |
  | chrome   | clothes          | Medium             |
  | firefox  | clothes          | Large              |
  | chrome   | clothes          | XL                 |
  | firefox  | clothes          | Long Sleeves       |
  | chrome   | clothes          | Short Sleeves      |
  | firefox  | accessories      | White Accessories  |
  | chrome   | accessories      | Black Accessories  |
  | firefox  | accessories      | Ceramic            |
  | chrome   | accessories      | Polyester          |
  | firefox  | accessories      | Recycled Cardboard |
  | chrome   | accessories      | 120 pages          |
  | firefox  | accessories      | Removable Cover    |
  | chrome   | accessories      | Graphic Corner     |
  | firefox  | accessories      | Studio Design      |
  | chrome   | accessories      | Ruled              |
  | firefox  | accessories      | Plain              |
  | chrome   | accessories      | Squarred           |
  | firefox  | accessories      | Doted              |
  | chrome   | art              | Matt Paper         |
  | firefox  | art              | Graphic Corner Art |
  | chrome   | art              | 40x60              |
  | firefox  | art              | 60x90              |
  | chrome   | art              | 80x120             |


  #@testing
  #Scenario Outline: Filter accessories by categories
  #  Given I am on main page
  #  When I click on accessories page
  #  When I click on the <filter> filter
  #  Then only items of the category <filter> should be displayed
  #  Examples:
  #    | filter           |
  #    | stationery       |
  #    | homeAccessories  |


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