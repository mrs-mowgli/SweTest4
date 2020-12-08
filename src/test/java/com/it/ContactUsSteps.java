/*
    Step definitions för att kontakta kundservice via Contact us-sidan.
    Skapad av Mio Lundqvist 2020-11-25
    Senast ändrad av Mio Lundqvist 2020-27
 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUsSteps extends ContactUsMethods {

   /* @Given("I am on the contact us page")
    public void i_am_on_the_contact_us_page() {
        contactUsPage();
    }*/

    @When("I click on Contact us")
    public void i_click_on_contact_us() {
        clickOnContactUs();
    }


    @When("I choose a Customer service")
    public void i_choose_a_customer_service() {
        subjectCustomerService();
    }

    @When("I fill in Email address")
    public void i_fill_in_email_address() {
        contactUsFillInEmail();
    }

    @When("I fill in a message")
    public void i_fill_in_a_message() {
        contactUsFillInMessage();
    }

    @When("I click on send")
    public void i_click_on_send() {
        contactUsSendButton();
    }

    @Then("a message is sent to the customer service")
    public void a_message_is_sent_to_the_customer_service() {
        contactUsMessageSent();
    }

    @When("I choose a Webmaster")
    public void i_choose_a_webmaster() {
        subjectWebmaster();
    }

    @When("choose a subject")
    public void choose_a_subject() {
        chooseASubject();
    }

    @Then("a message is not sent")
    public void a_message_is_not_sent() {
        contactUsMessageNotSent();
    }
}
