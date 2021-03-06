/*
        Step definitions för att skapa en ny användare.
        Skapad av Mio Lundqvist 2020-11-19
        Senast ändrad av Mio Lundqvist 2020-11-25
        */

        package com.it;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAccountSteps extends CreateAccount {

    @When("I go to the create an account page")
    public void i_go_to_the_create_an_account_page() {
        createAccountPage();
    }

    @When("I choose a Social title")
    public void i_choose_a_social_title() {
        chooseSocialTitle();
    }

    @When("I fill in First name")
    public void i_fill_in_first_name() {
        fillInFirstName();
    }

    @When("I fill in Last name")
    public void i_fill_in_last_name() {
        fillInLastName();
    }

    @When("I fill in Email")
    public void i_fill_in_email() {
        fillInEmail();
    }

    @When("I fill in Password")
    public void i_fill_in_password() {
        fillInPassword();
    }

    @When("I fill in Birth date")
    public void i_fill_in_birth_date() {
        fillInBirthDate();
    }

    @When("I choose to agree to the terms")
    public void i_choose_to_agree_to_the_terms() {
        agreeToTerms();
    }

    @When("I click on save")
    public void i_click_on_save() {
        clickOnSaveButton();
    }

    @Then("an account is created with the provided information")
    public void an_account_is_created() {
        accountIsCreated();
    }

    @When("I fill in an already existing email")
    public void i_fill_in_an_already_existing_email() {
        fillInExistingEmail();
    }

    @Then("an error message should appear saying the email is already used")
    public void an_error_message_should_appear_saying_the_email_is_already_used() {
        errorEmailUsed();
    }

    @Then("an account was not created")
    public void an_account_was_not_created() {
        accountNotCreated();
    }

    @When("I fill in password in a wrong format")
    public void i_fill_in_password_in_a_wrong_format() {
        fillInPasswordWrongFormat();
    }

    @Then("an error message should appear saying the password has a wrong format")
    public void an_error_message_should_appear_saying_the_password_has_a_wrong_format() {
        passwordWrongFormat();
    }

    @When("^I fill in a ([^\"]*) in a wrong format$")
    public void i_fill_in_a_birth_date_in_a_wrong_format(String birthdate) {
        fillInBirthDateWrongFormat();
    }

    @Then("an error message should appear saying the birth date has a wrong format")
    public void an_error_message_should_appear_saying_the_birth_date_has_a_wrong_format() {
        errorBirthDateWrongFormat();
    }

    @When("I do not check the terms and conditions box")
    public void i_do_not_check_the_terms_and_conditions_box() {


    }

    @Then("an error message should appear saying terms and conditions needs to be checked")
    public void an_error_message_should_appear_saying_terms_and_conditions_needs_to_be_checked() {

    }
}

