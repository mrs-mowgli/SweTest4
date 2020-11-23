package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutNotLoggedin extends TestCode{
        /*
    Testclass för att visa flödet hur funktioner anropas från andra klassen "TestCode"
    Skapad av Linus Finsbäck 2020-11-20
    Ändrad av ...
 */

    @Given("^Test User is at webshop start page ecommerce$")
    public void openBrowserTest() {
        //Kallar på funktionen "setUp" i klassen "BaseClass"
        setUp();
    }


/*
        @Given("^I am on start page$")
        public void IAmOnStartPage() {
            driver.get("http://40.76.27.113:8085/en/");
        }

 */

    @When("^Test User click at \"(.*)\"$")
    public void clickatsweater(String Hummingbird_sweater) {
        //klicka på Hummingbird sweater
        // Kallar på funktionen "findElementsByxPath" tre argument skickas med.
        // click och empty är deklarerade i klassen "TestCode" och används här för att funktionen ska utföra action.
        findElementsByxPath(Hummingbird_sweater, click, empty);
    }

    @Then("^Test User should be att page Hummingbird sweater \"(.*)\"$")
    public void sweaterURL(String expectedURL) {
        //verifiera att korrekt url visas
        //String currentUrl = getCurrentUrl(); //Variabel för att spara nuvarande url.
        assertEquals(getCurrentUrl(), expectedURL); //Jämför nuvarande url med "expected url". Variabeln expectedUrl får sitt värde från cucumber filen.
        //getCurrentURL();

    }

    @Then("^Test User click at button \"(.*)\"$")
    public void addtocart(String Add_to_cart) {
        //Kommentera ngt smart
        findElementsByxPath(Add_to_cart, click, empty );
    }

    @Then("^Test User click at proceed to checkout from modal \"(.*)\"$")
    public void Proceed_to_checkout_from_modal(String Proceed_to_checkout_from_modal) throws InterruptedException {
        //Kommentera ngt smart
        Thread.sleep(2000);
        findElementsByxPath(Proceed_to_checkout_from_modal, click, empty);
    }

    @Then("^Test User click at proceed to checkout from cart \"(.*)\"$")
    public void Proceed_to_checkout_from_cart(String Proceed_to_checkout_from_cart) {
        //Kommentera ngt smart
        findElementsByxPath(Proceed_to_checkout_from_cart, click, empty);
    }




    @Given("^Test User is at checkout \"(.*)\"$")
    public void at_cartURL(String checkoutURL) {
        assertEquals(getCurrentUrl(), checkoutURL);
    }



}

