/*

Testklass för att skapa en ny användare.
Skapad av Mio Lundqvist 2020-11-19
Ändrad av Mio Lundqvist 2020-11-22A


 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreateAccount extends TestCode {

        public static String socialTitle = "#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(1) > span";
        public static String firstname = "#customer-form > section > div:nth-child(2) > div.col-md-6 > input";
        public static String lastname = "#customer-form > section > div:nth-child(3) > div.col-md-6 > input";
        public static String email = "#customer-form > section > div:nth-child(4) > div.col-md-6 > input";
        public static String password = "#customer-form > section > div:nth-child(5) > div.col-md-6 > div > input";
        public static String birthdate = "#customer-form > section > div:nth-child(6) > div.col-md-6 > input";
        public static String birthdatexpath = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/input";
        public static String terms = "#customer-form > section > div:nth-child(9) > div.col-md-6 > span > label > input[type=checkbox]";
        public static String savebutton = "#customer-form > footer > button";
        public static String myaccount = "#_desktop_user_info > div > a.account > span";
        public static String accountinfo = "#identity-link > span > i";
        public static String usedEmailErrorMessage = "#customer-form > section > div.form-group.row.has-error > div.col-md-6 > div > ul > li";
        public static String wrongBirthdayFormat = "#customer-form > section > div.form-group.row.has-error > div.col-md-6 > div > ul > li";

        @Given("I am on the create an account page")
        public void i_am_on_the_create_an_account_page() {
            setUp();
        }

        @When("I choose a Social title")
        // Clicks on social title radio button
        public void i_choose_a_social_title() {
            findElementsByCss(socialTitle, click, empty);
        }

        @When("I fill in First name")
        public void i_fill_in_first_name() {
            // Clicks and fills in firstname in firstname field
            findElementsByCss(firstname, sendKeys, "Tolván");
        }

        @When("I fill in Last name")
        public void i_fill_in_last_name() {
            // Clicks and fills in lastname in first lastname field
            findElementsByCss(lastname, sendKeys, "Tölvansson");
        }

        @When("I fill in Email")
        public void i_fill_in_email() {
            // Clicks and fills in email in email field
            findElementsByCss(email, sendKeys, "tolvantolvansson@gmail.com");
        }

        @When("I fill in Password")
        public void i_fill_in_password() {
            // Clicks and fills in password in password field
            findElementsByCss(password, sendKeys, "TolvansLösenord*0123");
        }

        @When("I fill in Birth date")
        public void i_fill_in_birth_date() {
            // Clicks and fills in birth date in birth date field
            findElementsByCss(birthdate, sendKeys, "12/12/1912");
        }

        @When("I choose to agree to the terms")
        public void i_choose_to_agree_to_the_terms() {
            // Clicks on agree to terms checkbox
            findElementsByCss(terms, click, empty);
        }

        @When("I click on save")
        public void i_click_on_save() {
            // Clicks on save button
            findElementsByCss(savebutton, click, empty);
        }

        @Then("an account is created with the provided information")
        public void an_account_is_created() {
            // Navigated to "my account" page and "account info" page
            findElementsByCss(myaccount, click, empty);
            findElementsByCss(accountinfo, click, empty);

            String firstName = getAttributeByCssValue(firstname);
            // Asserts that firstname is Tolván
            assertEquals("Tolván", firstName);

            String lastName = getAttributeByCssValue(lastname);
            // Asserts that lastname is Tölvansson
            assertEquals("Tölvansson", lastName);

            String eMail = getAttributeByCssValue(email);
            // Asserts that email is tolvan.tolvansson_191212@domän.com
            assertEquals("tolvan.tolvansson_191212@domän.com", eMail);

            String birthDate = getAttributeByCssValue(birthdate);
            // Asserts that birth date is 12/12/1912
            assertEquals("12/12/1912", birthDate);
        }

        @When("I fill in an already existing email")
        public void i_fill_in_an_already_existing_email() {
            // Fills in an already existing email in email field
            findElementsByCss(email, sendKeys, "tolvantolvansson@gmail.com");
        }

        @Then("an error message should appear saying the email is already used")
        public void an_error_message_should_appear_saying_the_email_is_already_used() {
            // Checking if email error message is displayed, or not

            if (driver.findElement(By.cssSelector(usedEmailErrorMessage)).isDisplayed()){
                System.out.println("Used email error message is displayed");
            }else {
                System.out.println("Used email error message is not displayed");
            }
        }

        @Then("an account was not created")
        public void an_account_was_not_created() {
            // Asserts that an account was not created by checking that we're still on the Create account page
            assertEquals("http://40.76.27.113:8085/en/login?create_account=1", getCurrentUrl());
        }

        @When("I fill in a password in a wrong format")
        public void i_fill_in_a_password_in_a_wrong_format() {
            // Fills in a password in a wrong format in the password field
            findElementsByCss(password, sendKeys, "abcd");
        }

        @Then("an error message should appear saying the password has a wrong format")
        public void an_error_message_should_appear_saying_the_password_has_a_wrong_format() {
            // Checks that the element title equals the error message
            String passwordErrorMessage = getAttributeByCssTitle(password);
            assertEquals("At least 5 characters long", passwordErrorMessage);
        }

        @When("^I fill in a ([^\"]*) in a wrong format$")
        public void i_fill_in_a_birth_date_in_a_wrong_format(String birthdate) {
            // Clicks and fills in birth date in birth date field
            //findElementsByCss(birthdate, sendKeys, birthdate);
            driver.findElement(By.xpath(birthdatexpath)).sendKeys(birthdate);
        }

        @Then("an error message should appear saying the birth date has a wrong format")
        public void an_error_message_should_appear_saying_the_birth_date_has_a_wrong_format() {
            //
            if (driver.findElement(By.cssSelector(wrongBirthdayFormat)).isDisplayed()){
                System.out.println("Wrong birth date format error message is displayed");
            }else {
                System.out.println("Wrong birth date format error message is not displayed");
            }

        }
}

