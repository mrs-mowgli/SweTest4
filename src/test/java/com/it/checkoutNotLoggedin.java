package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutNotLoggedin extends TestCode{
        /*
    Testclass för att visa flödet hur funktioner anropas från andra klassen "TestCode"
    Skapad av Linus Finsbäck 2020-11-20
    Ändrad av Jenny Lernbring 2020-xx-xx
 */

    @Given("^Test User is at webshop start page ecommerce$")
    public void openBrowserTest() {
        //Kallar på funktionen "setUp" i klassen "BaseClass"
        setUp();
    }


/*
        //Ett fail försök till att anropa @Given som ska vara gemensam
        @Given("^I am on start page$")
        public void IAmOnStartPage() {
            //Start at start page http://40.76.27.113:8085/en/
            driver.get("http://40.76.27.113:8085/en/");
        }

 */

    @When("^Test User click at \"(.*)\"$")
    public void clickatsweater(String Hummingbird_sweater) {
        //Click on Hummingbird sweater
        // Call on function "findElementsByxPath" from "TestCode".
        // click and empty are declared in class "TestCode" and is used here to actually do something.
        findElementsByxPath(Hummingbird_sweater, click, empty);
    }

    @Then("^Test User should be att page Hummingbird sweater \"(.*)\"$")
    public void sweaterURL(String expectedURL) {
        //verify that correct URL is shown
        //compare current URL with "expected url".
        // variable "expectedUrl" gets its value from cucumber file "checkedoutNotLoggedin".
        assertEquals(getCurrentUrl(), expectedURL, "Wrong URL for hummingbird sweater");
    }

    @Then("^Test User click at button \"(.*)\"$")
    public void addtocart(String Add_to_cart) {
        //Click on add to cart
        // Call on function "findElementsByxPath" from "TestCode".
        // click and empty are declared in class "TestCode" and is used here to actually do something.
        findElementsByxPath(Add_to_cart, click, empty );
    }

    @Then("^Test User click at proceed to checkout from modal \"(.*)\"$")
    public void Proceed_to_checkout_from_modal(String Proceed_to_checkout_from_modal) throws InterruptedException {
        //put page to sleep for modal to load properly.
        Thread.sleep(2000);
        // Call on function "findElementsByxPath" from "TestCode".
        // click and empty are declared in class "TestCode" and is used here to actually do something.
        findElementsByxPath(Proceed_to_checkout_from_modal, click, empty);
    }

    @Then("^Test User click at proceed to checkout from cart \"(.*)\"$")
    public void Proceed_to_checkout_from_cart(String Proceed_to_checkout_from_cart) {
        //Click on proceed to checkout
        // Call on function "findElementsByxPath" from "TestCode".
        // click and empty are declared in class "TestCode" and is used here to actually do something.
        findElementsByxPath(Proceed_to_checkout_from_cart, click, empty);
    }




    @Given("^Test User is at checkout \"(.*)\"$")
    public void at_cartURL(String checkoutURL) {
        //verify that correct URL is shown
        //compare current URL with "expected url".
        // variable "expectedUrl" gets its value from cucumber file "checkedoutNotLoggedin".
        assertEquals(getCurrentUrl(), checkoutURL);
    }
/*
    @When("^I fill in social title$")
    public void socialtitle() {

    }

    @And("^I fill in personal information$")
    public void personal_information() {
        //Fill in personal information and click continue

    }

    @And("^I fill in adress$")
    public void address() {
        //fill in address and click continue
    }

    @And("^I fill in shipping method$")
    public void shipping_method() {
        // fill in shipping method and click continue
    }

    @And("^I fill in payment$")
    public void payment() {
        //select payment method and order
    }

 */


}

