package com.it;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TestLogin extends LoginMethods {

    @Given("^I am at the login page$")
    public void i_am_at_the_login_page() {
        setUp();
        GoToLoginPage();
    }

    @When("^I fill in (.*) in username field$")
    public void i_fill_in_username_at_login_page(String username) {

        //Clicks email field
        EmailFieldClick();
        //Send keys to email field
        EmailFieldSendKeys(username);
    }
    @When ("^I click forgotten password$")
    public void i_click_forgotten_password()
    {
        ForgottenPasswordClick();
    }
    @When ("I fill in {string} on forgotten password page")
    public void i_fill_in_email_on_forgotten_password_page(String email)
    {
        FillInEmailAddressInForgottenPasswordField(email);
    }
    @When("I click reset link")
    public void i_click_reset_link()
    {
        ClickResetPasswordButton();
    }
    @When("^I fill in (.*) in password field")
    public void i_fill_in_password_at_login_page(String password) {
        //Clicks email field
        PasswordFieldClick();
        //Send keys to email field
        PasswordFieldSendKeys(password);
    }

    @When("^I click sign in$")
    public void i_click_sign_in() {
        //Clicks login button
        SignInButtonClick();
    }
    @When ("^I click sign in button from start page")
    public void i_click_sign_in_button_from_start_page()
    {
        SignInButtonFromStartPage_Click();
    }
    @When("^I click (.*) button$")
    public void i_click_show_password_button(String showButton) {
        //If value is hidden the show password button is clicked twice.
        //First click the password is readable
        //Second click the password is hidden
        if(showButton.equals("hidden"))
        {
            ShowButtonClick();
        }
        ShowButtonClick();

    }
    @When("^I click sign out$")
    public void i_click_sign_out()
    {
        SignOutButtonClick();
    }
    @When("^I change ([^\"]*) to ([^\"]*)$")
    public void i_change_old_password_to_new_password(String oldPassword, String newPassword)
    {
        MyPage_ChangePassword(oldPassword,newPassword);
    }
    @When("^I close browser$")
    public void i_close_browser()
    {
        driver.quit();
    }

    @Then("reset password link is sent to {string}")
    public void reset_password_link_is_sent_to_email(String email)
    {
        String expectedString = "If this email address has been registered in our shop, you will " +
                "receive a link to reset your password at " + email + ".";
        String actualString = GetSuccessMessage_ResettingPassword();

        Assertions.assertEquals(expectedString,actualString);
    }
    @Then("reset password link is not sent to {string}")
    public void reset_password_link_is_not_sent_to_email(String email)
    {
        String expectedString = "An error occurred while sending the email.";
        String actualString = GetFailureMessage_ResettingPassword();
        Boolean foundExpectedString = false;
        if(actualString.contains(expectedString)) {
            foundExpectedString = true;
        }
        Assertions.assertTrue(foundExpectedString);
    }
    @Then("^I am signed in$")
    public void i_am_signed_in() {
        String expectedHeader = "Your account";
        //Checks header on page that should be equal to Your account.

        String actualHeader = GetHeaderOnMyAccountPage();
        Boolean isSignedIn = false;

        if(GetSignInButtonText().contains("Sign out")){
            isSignedIn = true;
        }

        Assertions.assertTrue(isSignedIn);
        Assertions.assertEquals(expectedHeader,actualHeader);
        teardown();
    }
    @Then("^authentication failed message is displayed$")
    public void authentication_failed_message_is_displayed()
    {
        String expectedWarning = "Authentication failed.";

        //Checks authentication message that should be equal to authentication failed
        String actualWarning = GetAuthenticationText();

        Assertions.assertEquals(expectedWarning,actualWarning);
        teardown();
    }
    @Then("the password is ([^\"]*) in password field$")
    public void password_is_displayed_in_password_field(String shown)
    {
        String expectedResult;
        //Checks text in hide/show button to verify that password text is shown.
        //I tried to get the text from password field, with no success.
        //Future improvement would be to check password field.
        //When the show button is clicked the value is hidden, therefore I need to switch the values
        //So when password is shown the value in button is hidden and vice versa.

        if(shown.equals("show"))
        {
            expectedResult ="hide";
        }
        else
        {
            expectedResult = "show";
        }
        String hideButtonText = GetHideButtonText();

        //Compares hidden sho
        Assertions.assertEquals(expectedResult,hideButtonText.toLowerCase());


        teardown();
    }
    @Then("^I am logged out from account$")
    public void i_am_logged_out_from_account()
    {
       Boolean isSignedOut = false;
       String expectedResult = "Sign in";

       if(GetSignInButtonText().contains(expectedResult)){
           isSignedOut = true;
       }
       Assertions.assertTrue(isSignedOut);
       teardown();
    }
    @Then("^Restore (.*) with (.*)$")
    public void restore_old_password(String newPassword, String oldPassword)
    {
        i_am_at_the_login_page();
        i_fill_in_username_at_login_page("test_password@hotmail.com");
        i_fill_in_password_at_login_page(newPassword);
        i_click_sign_in();
        i_change_old_password_to_new_password(newPassword,oldPassword);
        teardown();
    }

}
