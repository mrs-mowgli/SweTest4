package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class TestLogin extends Login {

    private String xpathToSignInButton = "//*[@id=\"_desktop_user_info\"]/div/a/span";

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
    @Then("^I am signed in$")
    public void i_am_signed_in() {
        String expectedHeader = "Your account";
        //Checks header on page that should be equal to Your account.
        String actualHeader = GetHeaderOnMyAccountPage();
        String SignInButtonText = GetSignInButtonText();
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
    @Then("the password is (.*) in password field$")
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
}
