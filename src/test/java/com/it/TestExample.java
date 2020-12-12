/*
    Testclass för att visa flödet hur funktioner anropas från andra klassen "TestCode"
    Skapad av Linus Finsbäck 2020-11-20
    Ändrad av ...
 *//*


package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExample extends TestCode{
/* kommenterar ut denna tillfälligt
    @Given("^Test User is at webshop start page$")
    public void openBrowserTest() {
        setUp(); //Kallar på funktionen "setUp" i klassen "BaseClass"
    }
*/
    @When("^Test User click at contact$")
    public void clickTest() {
        //klicka på länk
        findElementsById("contact-link", click, empty); //Kallar på funktionen "findElementsById" tre argument skickas med. "contact-link" = Id av elementet. click och empty är deklarerade i klassen "TestCode" och används här för att funktionen ska utföra action.
    }

    @Then("^Test User should see page contact us url \"([^\"]*)\"$")
    public void verifyUrlTest(String expectedUrl) {
        //verifiera att korrekt url visas
        String currentUrl; //Variabel för att spara nuvarande url
        currentUrl = getCurrentUrl(); //Hämta nuvarande url med hjälp av funktionen "getCurrentUrl". Funktionen returnerar nuvarande url
        assertEquals(currentUrl, expectedUrl); //Jämför nuvarande url med "expected url". Variabeln expectedUrl får sitt värde från cucumber filen step Then ("http://40.76.27.113:8085/en/contact-us")
    }
}
*/
