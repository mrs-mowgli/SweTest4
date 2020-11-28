package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutNotLoggedin extends TestCheckoutNotLoggedinCode {
    //Här ska alla Given When Then vara
    //Ropar på metoder fr TestCheckoutNotLoggedinCode där all kod är.

        /*
    Testclass för att visa flödet hur funktioner anropas från andra klassen "TestCode"
    Skapad av Linus Finsbäck 2020-11-20
    Ändrad av Jenny Lernbring 2020-11-28
 */

    //Scenario 1
    @Given("^I am at webshop start page ecommerce$")
    public void openBrowserTest() {
        //Calls setup method from BaseClass
        setUp();
    }

    @When("^Proceed to checkout$")
    public void go_to_checkout() throws InterruptedException {
        proceed_to_checkout();
    }

    //Scenario 2
    @Given("^I am in cart$")
    public void at_cartURL() {
        I_am_in_cart();
    }

    @When("I fill in personal information")
    public void I_fill_in_personal_information(){
        inCart_Personal_Information();
    }

    @And("^I fill in Addresses$")
    public void addresses() {
        inCart_Address();
    }

    @And("I Fill in shipping method")
    public void shipping_method() {
        inCart_shippingMethod();
    }

    @And("I choose payment")
    public void payment_method() {
        inCart_payment();
    }
    @Then("I see Order confirmation")
    public void order_confirmation() {
        order_is_confirmed();
    }

}

