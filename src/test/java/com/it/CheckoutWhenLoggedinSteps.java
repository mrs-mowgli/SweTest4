package com.it;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutWhenLoggedinSteps extends CheckoutWhenLoggedinMethods {

    @Given("I am Logged In")
    public void i_am_logged_in() {
        loginWithExistingUser();
        assertEquals( "Test Testingson", driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText());
    }

    @Given("Have Products In Cart")
    public void have_products_in_cart() {
        addProductsToCart();
    }

    @When("I Checkout")
    public void i_checkout() {
        procedToCheckout();
    }

    @Then("Choose Shipping {string}")
    public void choose_shipping(String string) {
        chooseShippingMethod(string);
    }

    @Then("Choose Payment {string}")
    public void choose_payment(String string) {
        choosePaymentOption(string);
    }

    @Then("I choose to agree to the terms Of Service")
    public void i_choose_to_agree_to_the_terms_of_service() {
        acceptTermsOfService();
    }

    @Then("Order Is Placed")
    public void order_is_placed() {
        makeOrder();
        //Assert shipment method and price in order.
        assertEquals(finalPrice, trimDec(cleanPrice(driver.findElement(By.xpath("//*[@id=\"order-items\"]/div[2]/table/tbody/tr[3]/td[2]")).getText())));
    }

    @Then("I Get Conformation Email")
    public void i_get_conformation_email() {
        // Write code here that turns the phrase above into concrete actions
        logOut();
    }

    @Then("It Should Not be Possible to Continue Checkout")
    public void it_should_not_be_possible_to_continue_checkout() {
        checkOrderbuttonInactive();
    }

}
