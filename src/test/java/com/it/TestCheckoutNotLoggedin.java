package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutNotLoggedin extends TestCheckoutNotLoggedinCode {

        /*
    Test methods that is connected to cucumber file checkoutNotLoggedin.feature

    Created by Linus Finsbäck 2020-11-20
    Created by Jenny Lernbring 2020-11-29
 */

    //Scenario: Add item to cart
    @Given("^I am at webshop start page ecommerce$")
    public void openBrowserTest() {
        //Calls setup method from BaseClass
        setUp();
    }

    @When("^Proceed to checkout$")
    public void go_to_checkout() throws InterruptedException {
        // Calls method from TestCheckoutNotLoggedinCode class.
        //Goes from modal to checkout cart
        proceed_to_checkout();
    }

    //Scenario: Checkout from cart as an uninlogged costumer
    @Given("^I am in cart$")
    public void at_cartURL() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Makes sure that you are at correct URL.
        I_am_in_cart();
    }

    @When("I fill in personal information")
    public void I_fill_in_personal_information(){
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Fill in required personal information in cart.
        inCart_Personal_Information();
    }

    @And("^I fill in Addresses$")
    public void addresses() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        // Fill in required address fields.
        inCart_Address();
    }

    @And("I Fill in shipping method")
    public void shipping_method() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Select shipping method
        inCart_shippingMethod();
    }

    @And("I choose payment")
    public void payment_method() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Select how i would like to pay.
        inCart_payment();
    }
    @Then("I see Order confirmation")
    public void order_confirmation() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Order is confirmed.
        order_is_confirmed();
    }

}

