package com.it;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutSteps extends TestCode {

    String emailSese = "test@test.net";
    String passwordSese = "testtest";

    @Given("I'am Logged In")
    public void i_am_logged_in() {
        //Funktion to log in as existing user
        driver = new ChromeDriver();
        driver.get("http://40.76.27.113:8085/en/login?back=my-account");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input")).sendKeys(emailSese);
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")).sendKeys(passwordSese);
        driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]")).click();
        teardown();
    }

    @Given("Have Products In Cart")
    public void have_products_in_cart() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    @When("I Checkout")
    public void i_checkout() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    @Then("Choose Shipping")
    public void choose_shipping() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    @Then("Choose Payment")
    public void choose_payment() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    @Then("I choose to agree to the terms Of Service")
    public void i_choose_to_agree_to_the_terms_of_service() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    @Then("Order Is Placed")
    public void order_is_placed() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    @Then("I Get Conformation Email")
    public void i_get_conformation_email() {
        // Write code here that turns the phrase above into concrete actions
        tester();
    }

    public void tester(){
        System.out.println("Dry Test");
    }
}
