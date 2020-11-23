#Test för att visa flödet hur funktioner anropas i andra klasser och hur keywords anges redan i cucumber filen
#Skapad av Linus Finsbäck 2020-11-20

Feature: Test

  Scenario Outline: Add an item to chart
    Given Test User is at webshop start page ecommerce
    #Given I am on start page
    When Test User click at "<Hummingbird_sweater>"
    And Test User should be att page Hummingbird sweater "<expectedURL>"
    And Test User click at button "<Add_to_cart>"
    And Test User click at proceed to checkout from modal "<Proceed_to_checkout_from_modal>"
    Then Test User click at proceed to checkout from cart "<Proceed_to_checkout_from_cart>"

    Examples:
      |Hummingbird_sweater                                |Add_to_cart                                                 |expectedURL                                                                    |Proceed_to_checkout_from_modal                                |Proceed_to_checkout_from_cart|
      |//*[@id="content"]/section/div/article[2]/div/a/img| //*[@id="add-to-cart-or-refresh"]/div[2]/div/div[2]/button |http://40.76.27.113:8085/en/women/2-9-brown-bear-printed-sweater.html#/1-size-s|//*[@id="blockcart-modal"]/div/div/div[2]/div/div[2]/div/div/a|//*[@id="main"]/div/div[2]/div[1]/div[2]/div/a|


  Scenario Outline:
    Given Test User is at checkout "<checkoutURL>"
   #When


    Examples:
      |checkoutURL|
      |http://40.76.27.113:8085/en/order|