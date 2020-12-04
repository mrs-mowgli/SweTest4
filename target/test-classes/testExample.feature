#Test för att visa flödet hur funktioner anropas i andra klasser och hur keywords anges redan i cucumber filen
#Skapad av Linus Finsbäck 2020-11-20

Feature: Test

  Scenario: Test Iths.se
    Given Test User is at webshop start page
    When Test User click at contact
    Then Test User should see page contact us url "http://40.76.27.113:8085/en/contact-us"

###########################################
  # "...url..." skickas med som argument när funktionen för step Then anropas