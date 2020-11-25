/*
    Testklass för att skapa en ny användare.
    Skapad av Mio Lundqvist 2020-11-23
    Senast ändrad av Mio Lundqvist 2020-11-25
 */

package com.it;

import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAccountMethods extends TestCode {

    String socialTitle = "#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(1) > span";
    String firstname = "#customer-form > section > div:nth-child(2) > div.col-md-6 > input";
    String lastname = "#customer-form > section > div:nth-child(3) > div.col-md-6 > input";
    String email = "#customer-form > section > div:nth-child(4) > div.col-md-6 > input";
    String password = "#customer-form > section > div:nth-child(5) > div.col-md-6 > div > input";
    String birthdate = "#customer-form > section > div:nth-child(6) > div.col-md-6 > input";
    String birthdatexpath = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/input";
    String terms = "#customer-form > section > div:nth-child(9) > div.col-md-6 > span > label > input[type=checkbox]";
    String savebutton = "#customer-form > footer > button";
    String myaccount = "#_desktop_user_info > div > a.account > span";
    String accountinfo = "#identity-link > span > i";
    String usedEmailErrorMessage = "#customer-form > section > div.form-group.row.has-error > div.col-md-6 > div > ul > li";
    String wrongBirthdayFormat = "#customer-form > section > div.form-group.row.has-error > div.col-md-6 > div > ul > li";
    String termsAndConditionsCheckbox = "#customer-form > section > div:nth-child(9) > div.col-md-6 > span > label > input[type=checkbox]";
    String termsAndConditionsErrorMessage = "";

    public void createUserPage() {
        // Goes to the create user page
        driver.get("http://40.76.27.113:8085/en/login?create_account=1");
    }

    public void chooseSocialTitle() {
        // Clicks on social title radio button
        findElementsByCss(socialTitle, click, empty);
    }

    public void fillInFirstName() {
        // Clicks and fills in firstname in firstname field
        findElementsByCss(firstname, sendKeys, "Tolván");
    }

    public void fillInLastName() {
        // Clicks and fills in lastname in first lastname field
        findElementsByCss(lastname, sendKeys, "Tölvansson");
    }

    public void fillInEmail() {
        // Clicks and fills in email in email field
        findElementsByCss(email, sendKeys, "tolvantolvansson@gmail.com");
    }

    public void fillInPassword() {
        // Clicks and fills in password in password field
        findElementsByCss(password, sendKeys, "TolvansLösenord*0123");
    }

    public void fillInBirthDate() {
        // Clicks and fills in birth date in birth date field
        findElementsByCss(birthdate, sendKeys, "12/12/1912");
    }

    public void agreeToTerms() {
        // Clicks on agree to terms checkbox
        findElementsByCss(terms, click, empty);
    }

    public void clickOnSaveButton() {
        // Clicks on save button
        findElementsByCss(savebutton, click, empty);
    }

    public void accountIsCreated() {
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

    public void fillInExistingEmail() {
        // Fills in an already existing email in email field
        findElementsByCss(email, sendKeys, "tolvantolvansson@gmail.com");
    }

    public void errorEmailUsed() {
        // Checking if email error message is displayed, or not

        if (driver.findElement(By.cssSelector(usedEmailErrorMessage)).isDisplayed()){
            System.out.println("Used email error message is displayed");
        }else {
            System.out.println("Used email error message is not displayed");
        }
    }

    public void accountNotCreated() {
        // Asserts that an account was not created by checking that we're still on the Create account page
        assertEquals("http://40.76.27.113:8085/en/login?create_account=1", getCurrentUrl());
        teardown();
    }

    public void fillInPasswordWrongFormat() {
        // Fills in a password in a wrong format in the password field
        findElementsByCss(password, sendKeys, "abcd");
    }

    public void passwordWrongFormat() {
        // Checks that the element title equals the error message. Closes browser.
        String passwordErrorMessage = getAttributeByCssTitle(password);
        assertEquals("At least 5 characters long", passwordErrorMessage);
        teardown();
    }

    public void fillInBirthDateWrongFormat() {
        // Clicks and fills in birth date in birth date field. Could not get it to work when following code standard, hence the code.
        driver.findElement(By.xpath(birthdatexpath)).sendKeys(birthdate);
    }

    public void errorBirthDateWrongFormat() {
        // Checks that the error message for the wrong birth date format is displayed. Closes browser
        if (driver.findElement(By.cssSelector(wrongBirthdayFormat)).isDisplayed()){
            System.out.println("Wrong birth date format error message is displayed");
        }else {
            System.out.println("Wrong birth date format error message is not displayed");
        }
        teardown();
    }

    public void termsBoxIsUnchecked() {
        /*
        Checks if the checkbox is checked or not. Point is to somewhat verify that it is unchecked which it is by default.
        If checked, the test will fail at the "an error message should appear saying terms and conditions needs to be checked" step.
         */
        if (driver.findElement(By.cssSelector(termsAndConditionsCheckbox)).isSelected()){
            System.out.println("Terms and conditions checkbox is checked");
        }else {
            System.out.println("Terms and conditions checkbox is unchecked");
        }

    }

}
