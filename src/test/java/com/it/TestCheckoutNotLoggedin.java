package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutNotLoggedin extends TestCheckoutNotLoggedinCode {

        /*
    Test methods that is connected to cucumber file checkoutNotLoggedin.feature

    Created by Linus Finsbäck 2020-11-20
    Created by Jenny Lernbring 2020-12-02
 */

    String invalid_firstname = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/div/ul/li";
    String invalid_lastname = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/div/ul/li";
    String invalid_postalcode = "//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/div/ul/li";

    //Högst tillfällig!
    @Given("^start$")
    public void start() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("http://40.76.27.113:8085/en/");
        driver.manage().window().maximize();
    }

    @And("^Proceed to checkout$")
    public void go_to_checkout() throws InterruptedException {
        // Calls method from TestCheckoutNotLoggedinCode class.
        //Goes from modal to checkout cart
        proceed_to_checkout();
    }

    //Scenario: Checkout from cart as an uninlogged costumer
    @When("^I am in cart$")
    public void at_cartURL() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Makes sure that you are at correct URL.
        I_am_in_cart();
    }

    @And("I fill in personal information")
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
    @And("I see Order confirmation")
    public void order_confirmation() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Order is confirmed.
        order_is_confirmed();
    }
/*
    @Then("close Browser")
    public void close_browser(){
        // Call method from Baseclass.
        // Close browser.
        teardown();
    }

 */

    //Scenario 2, negative test, personal information

    //Given I Am on statpage using "<browser>"
    //Given Have products in cart
    //And Proceed to checkout
    //When I am in cart

    @And("I fill in wrong firstname \"(.*)\"$")
    public void negativetest_firstname(String firstname) throws InterruptedException {
        findElementsByxPath(inCart_firstname,sendKeys, firstname);
        Thread.sleep(1000);
    }

    @And("I fill in wrong lastname \"(.*)\"$")
    public void negativetest_lastname(String lastname) throws InterruptedException {
        findElementsByxPath(inCart_lastname,sendKeys, lastname);
        Thread.sleep(1000);
    }

    @And("I fill in email \"(.*)\"$")
    public void write_email(String email) throws InterruptedException {
        findElementsByxPath(inCart_email,sendKeys, email);
        Thread.sleep(1000);
    }

    @And("I click on agree to terms and conditions")
    public void terms_and_conditions() throws InterruptedException {
        findElementsByxPath(inCart_termsAndCondition, click, empty);
        findElementsByxPath(inCart_personalInformation_continue, click, empty);
        Thread.sleep(1000);
    }

     @Then("Invalid fields in personal information")
    public void invalid_fields_in_personal_information() {
            //Alert warning for firstname invalid format
             if (driver.findElement(By.xpath(invalid_firstname)).isDisplayed()) {
                 System.out.println("Invalid characters in firstname");
             } else {
                 System.out.println("Firstname are writen in correct format");
             }

            // Alert Warning for lastname invalid format
             if (driver.findElement(By.xpath(invalid_lastname)).isDisplayed()) {
                 System.out.println("Invalid characters in lastname");
             } else {
                 System.out.println("Lastname are writen in correct format");
             }

     }



    //Scenario 3, negative test, addresses

    //Given I Am on statpage using "<browser>"
    //Given Have products in cart
    //And Proceed to checkout
    //When I am in cart
    //And i fill in personal information


    @And("I fill in address \"(.*)\"$")
    public void negativetest_address(String address) throws InterruptedException {
        findElementsByxPath(inCart_address,sendKeys, address);
        Thread.sleep(1000);
        System.out.println("negative address");
    }

    @And("I fill in invalid postalcode \"(.*)\"$")
    public void negativetest_postalcode(String postalcode) throws InterruptedException {
        findElementsByxPath(inCart_postalCode,sendKeys, postalcode);
        Thread.sleep(1000);
        System.out.println("negatvie postalcode");
    }

    @And("I fill in invalid city \"(.*)\"$")
    public void negativetest_city(String city) throws InterruptedException {
        findElementsByxPath(inCart_city,sendKeys, city);
        Thread.sleep(1000);
        System.out.println("negative city");
    }

    @Then("Invalid fields in addresses")
    public void invalid_fields_in_addresses() {
        //Alert warning for firstname invalid format
        if (driver.findElement(By.xpath(invalid_postalcode)).isDisplayed()) {
            System.out.println("Invalid postalcode");
        } else {
            System.out.println("Postalcode are writen in correct format");
        }
        System.out.println("alert");
/*
        // Alert Warning for lastname invalid format
        if (driver.findElement(By.xpath(invalid_lastname)).isDisplayed()) {
            System.out.println("Invalid characters in lastname");
        } else {
            System.out.println("Lastname are writen in correct format");
        }

 */

    }

}


