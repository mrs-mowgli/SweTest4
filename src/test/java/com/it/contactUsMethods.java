/*
    Testklass för att kontakta kundservice via Contact us-sidan.
    Skapad av Mio Lundqvist 2020-11-25
    Senast ändrad av Mio Lundqvist 2020-27
 */

package com.it;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class contactUsMethods extends TestCode {

    String contactUsButton = "#contact-link > a";
    String messageSent = "#content > section > form > div";
    String subjectCustomerService = "#content > section > form > section > div:nth-child(2) > div > select > option:nth-child(1)";
    String subjectWebmaster = "#content > section > form > section > div:nth-child(2) > div > select > option:nth-child(2)";
    String contactUsEmailField = "#content > section > form > section > div:nth-child(3) > div > input";
    String contactUsMessageField = "#content > section > form > section > div:nth-child(5) > div > textarea";
    String contactUsSendButton = "#content > section > form > footer > input.btn.btn-primary";
    String invalidEmail = "#content > section > form > div";

    public void contactUsPage() {
        setUp();
        findElementsByCss(contactUsButton, click, empty);
        assertEquals("http://40.76.27.113:8085/en/contact-us", driver.getCurrentUrl());
    }

    public void subjectCustomerService() {
        findElementsByCss(subjectCustomerService, click, empty);
    }

    public void subjectWebmaster() {
        findElementsByCss(subjectWebmaster, click, empty);
    }

    public void contactUsFillInEmail() {
        findElementsByCss(contactUsEmailField, sendKeys, "tolvantolvanssön@hotmail.com");
    }

    public void contactUsFillInMessage() {
        findElementsByCss(contactUsMessageField, sendKeys, "Testing contact us page. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud motion ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }

    public void contactUsSendButton() {
        findElementsByCss(contactUsSendButton, click, empty);
    }

    public void contactUsMessageSent() {
        try {
            if (driver.findElement(By.cssSelector(messageSent)).isDisplayed()) {
                System.out.println("Message sent message is displayed");
            } else {
                System.out.println("Message sent message is not displayed");
            }
        }catch (NoSuchElementException e) {
            System.out.println("Exception in finding the element:" + e.getMessage());
        }

    teardown();

    }

    public void chooseASubject() {
        findElementsByCss(subjectCustomerService, click, empty);
    }

    public void contactUsMessageNotSent() {
        findElementsByCss(invalidEmail, empty, empty);
        teardown();
    }
}
