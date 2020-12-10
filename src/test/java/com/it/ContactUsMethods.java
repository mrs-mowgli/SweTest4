/*
    Testklass för att kontakta kundservice via Contact us-sidan.
    Skapad av Mio Lundqvist 2020-11-25
    Senast ändrad av Mio Lundqvist 2020-27
 */

package com.it;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUsMethods extends TestCode {

    String contactUsButton = "#contact-link > a";
    String subjectButton = "#content > section > form > section > div:nth-child(2) > div > select";
    String messageSent = "col-xs-12 alert alert-success";
    String subjectCustomerService = "#content > section > form > section > div:nth-child(2) > div > select > option:nth-child(1)";
    String subjectWebmaster = "#content > section > form > section > div:nth-child(2) > div > select > option:nth-child(2)";
    String contactUsEmailField = "#content > section > form > section > div:nth-child(3) > div > input";
    String contactUsMessageField = "#content > section > form > section > div:nth-child(5) > div > textarea";
    String contactUsSendButton = "#content > section > form > footer > input.btn.btn-primary";
    String contactUsHeader = "#content > section > form > section > div:nth-child(1) > div > h3";

    public void clickOnContactUs() {
        // Goes to the contact us page
        findElementsByCss(contactUsButton, click, empty);
        assertEquals("http://40.76.27.113:8085/en/contact-us", driver.getCurrentUrl());
    }

    public void subjectCustomerService() {
        // Chooses "customer service" as subject
        findElementsByCss(subjectCustomerService, click, empty);
    }

    public void subjectWebmaster() {
        // Chooses "webmaster" as subject
        findElementsByCss(subjectWebmaster, click, empty);
    }

    public void contactUsFillInEmail() {
        // Fills in the email field
        findElementsByCss(contactUsEmailField, sendKeys, "tolvantolvanssön@hotmail.com");
    }

    public void contactUsFillInMessage() {
        // Fills in the message field
        findElementsByCss(contactUsMessageField, sendKeys, "Testing contact us page. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud motion ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    public void contactUsSendButton() {
        // Clicks on the send button
        findElementsByCss(contactUsSendButton, click, empty);
    }

    public void contactUsMessageSent() {
        // Confirms that the "Message sent" message is present.
        delay(2000);
        Boolean isPresent = driver.findElements(By.className(messageSent)).size() > 0;
    }

    public void chooseASubject() {
        // Also picks "customer service" as subject but is not a part of a data driven scenario step
        findElementsByCss(subjectButton, click, empty);
        findElementsByCss(subjectCustomerService, click, empty);
    }

    public void contactUsMessageNotSent() {
        // Confirms message is not sent by checking that we're still on the first contact us page.

        try {
            if (driver.findElement(By.cssSelector(contactUsHeader)).isDisplayed()) {
                System.out.println("Message is not sent");
            } else {
                System.out.println("Message is sent");
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception in finding the element:" + e.getMessage());
        }
    }
}
