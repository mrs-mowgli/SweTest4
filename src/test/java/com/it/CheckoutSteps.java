package com.it;

import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSteps extends CheckoutMethods {

    @Given("I am Logged In")
    public void i_am_logged_in() {
        loginWithExistingUser();
        assertEquals( "Test Testingson", driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span")).getText());
    }

    @Given("Have Products In Cart")
    public void have_products_in_cart() {
        // Write code here that turns the phrase above into concrete actions
        addProductsToCart();
    }

    @When("I Checkout")
    public void i_checkout() {
        // Write code here that turns the phrase above into concrete actions
        //waiting();
        procedToCheckout();
    }

    @Then("Choose Shipping")
    public void choose_shipping() {
        // Write code here that turns the phrase above into concrete actions
        chooseShippingMethod();
    }

    @Then("Choose Payment")
    public void choose_payment() {
        // Write code here that turns the phrase above into concrete actions
        choosePaymentOption();
    }

    @Then("I choose to agree to the terms Of Service")
    public void i_choose_to_agree_to_the_terms_of_service() {
        // Write code here that turns the phrase above into concrete actions
        acceptTermsOfService();
    }

    @Then("Order Is Placed")
    public void order_is_placed() {
        // Write code here that turns the phrase above into concrete actions
        makeOrder();
        //Assert shipment method and price in order
        assertEquals("Free", driver.findElement(By.xpath("//*[@id=\"order-items\"]/div[2]/table/tbody/tr[2]/td[2]")).getText());
        assertEquals(price, driver.findElement(By.xpath("//*[@id=\"order-items\"]/div[2]/table/tbody/tr[3]/td[2]")).getText());
    }

    @Then("I Get Conformation Email")
    public void i_get_conformation_email() {
        // Write code here that turns the phrase above into concrete actions
        logOut();
    }

    public void superDuper(){
        System.out.println("SupaDupah!");
    }

}
