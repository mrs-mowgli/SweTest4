/*

Testklass för att skapa en ny användare.
Skapad av Mio Lundqvist 2020-11-19
Ändrad av Mio Lundqvist 2020-11-20

 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class TestCreateNewUser extends TestCode {

        public static String socialTitle = "#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(1) > span";
        public static String firstname = "#customer-form > section > div:nth-child(2) > div.col-md-6 > input";
        public static String lastname = "#customer-form > section > div:nth-child(3) > div.col-md-6 > input";
        public static String email = "#customer-form > section > div:nth-child(4) > div.col-md-6 > input";
        public static String password = "#customer-form > section > div:nth-child(5) > div.col-md-6 > div > input";
        public static String birthdate = "#customer-form > section > div:nth-child(6) > div.col-md-6 > input";
        public static String terms = "#customer-form > section > div:nth-child(9) > div.col-md-6 > span > label > input[type=checkbox]";
        public static String savebutton = "#customer-form > footer > button";
        public static String myaccount = "#_desktop_user_info > div > a.account > span";
        public static String accountinfo = "#identity-link > span > i";


        @Given("I am on the create an account page")
        public void i_am_on_the_create_an_account_page() {
            setUp();
            driver.get("http://40.76.27.113:8085/en/login?create_account=1");
        }

        @When("I choose a Social title")
        public void i_choose_a_social_title(String socialTitle) {

        }

        @When("I fill in First name")
        public void i_fill_in_first_name() {
            driver.findElement(By.cssSelector(firstname)).sendKeys("Tolván");
        }

        @When("I fill in Last name")
        public void i_fill_in_last_name() {
            driver.findElement(By.cssSelector(lastname)).sendKeys("Tölvansson");
        }

        @When("I fill in Email")
        public void i_fill_in_email() {
            driver.findElement(By.cssSelector(email)).sendKeys("tolvan.tolvansson_191212@domän.com");
        }

        @When("I fill in Password")
        public void i_fill_in_password() {
            driver.findElement(By.cssSelector(password)).sendKeys("TolvansLösenord*0123");
        }

        @When("I fill in Birth date")
        public void i_fill_in_birth_date() {
            driver.findElement(By.cssSelector(birthdate)).sendKeys("12/12/1912");
        }

        @When("I choose to agree to the terms")
        public void i_choose_to_agree_to_the_terms() {
            driver.findElement(By.cssSelector(terms)).click();
        }

        @When("I click on save")
        public void i_click_on_save() {
            driver.findElement(By.cssSelector(savebutton)).click();
        }

        @Then("an account is created with the provided information")
        public void an_account_is_created() {
            driver.findElement(By.cssSelector(myaccount)).click();
            driver.findElement(By.cssSelector(accountinfo)).click();

            driver.findElement(By.cssSelector(firstname)).getText();
            assertTrue("firstname does not equal Tolván", firstname.contains("Tolván"));
            driver.findElement(By.cssSelector(lastname)).getText();
            assertTrue("lastname does not equal Tölvansson", lastname.contains("Tölvansson"));
            driver.findElement(By.cssSelector(email)).getText();
            assertTrue("email does not equal tolvan.tolvansson_191212@domän.com", email.contains("tolvan.tolvansson_191212@domän.com"));
            driver.findElement(By.cssSelector(birthdate)).getText();
            assertTrue("birthdate does not equal 12/12/1912", birthdate.contains("12/12/1912"));
        }

        public void tearDown(){
            teardown();
        }


}

