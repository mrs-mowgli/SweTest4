#Test för att visa flödet hur funktioner anropas i andra klasser

Feature: Test

  Scenario: Test Iths.se
    Given Test User is at webshop start page
    When Test User click at "contact-link"
    Then Test User should see page contact us url "http://40.76.27.113:8085/en/contact-us"