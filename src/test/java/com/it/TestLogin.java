package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class TestLogin extends TestCode {

    private String xpathToSignInButton = "//*[@id=\"_desktop_user_info\"]/div/a/span";

    @Given("^I am at the login page$")
    public void i_am_at_the_login_page() {
        setUp();
        driver.get("http://40.76.27.113:8085/en/login?back=my-account");
    }

    @When("^I fill in (.*) in username field$")
    public void i_fill_in_username_at_login_page(String username) {

        //Clicks email field
        findElementsByxPath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input","click","");
        //Send keys to email field
        findElementsByxPath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input","sendKeys",username);
    }

    @When("^I fill in (.*) in password field")
    public void i_fill_in_password_at_login_page(String password) {
        //Clicks email field
        findElementsByxPath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input","click","");
        //Send keys to email field
        findElementsByxPath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input","sendKeys",password);
    }

    @When("^I click sign in$")
    public void i_click_sign_in() {
        //Clicks login button
        findElementsById("submit-login","click","");
    }
    @When("^I click (.*) button$")
    public void i_click_show_password_button(String showButton) {
        String XpathToShowPasswordButton = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/span/button";

        //If value is hidden the show password button is clicked twice.
        //First click the password is readable
        //Second click the password is hidden
        if(showButton.equals("hidden"))
        {
            findElementsByxPath(XpathToShowPasswordButton,"click","");
        }
        findElementsByxPath(XpathToShowPasswordButton,"click","");


    }
    @When("^I click sign out$")
    public void i_click_sign_out()
    {
        findElementsByxPath(xpathToSignInButton,"click","");
    }
    @Then("^I am signed in$")
    public void i_am_signed_in() {
        String expectedHeader = "Your account";
        //Checks header on page that should be equal to Your account.
        String actualHeader = driver.findElement(By.xpath("//*[@id=\"main\"]/header/h1")).getText();
        String SignInButtonText = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]")).getText();

        Assertions.assertEquals("Sign out",SignInButtonText);
        Assertions.assertEquals(expectedHeader,actualHeader);
        driver.quit();
    }
    @Then("^authentication failed message is displayed$")
    public void authentication_failed_message_is_displayed()
    {
        String expectedWarning = "Authentication failed.";

        //Checks authentication message that should be equal to authentication failed
        String actualWarning = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/ul/li")).getText();

        Assertions.assertEquals(expectedWarning,actualWarning);
        driver.quit();
    }
    @Then("the password is (.*) in password field$")
    public void password_is_displayed_in_password_field(String shown)
    {
        String actualResult;
        //Checks text in hide/show button to verify that password text is shown.
        //I tried to get the text from password field, with no success.
        //Future improvement would be to check password field.
        //When the show button is clicked the value is hidden, therefore I need to switch the values
        //So when password is shown the value in button is hidden and vice versa.

        if(shown.equals("show"))
        {
            actualResult ="hide";
        }
        else
        {
            actualResult = "show";
        }
        String hideButtonText = driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/span/button")).getText();

        //Compares hidden sho
        Assertions.assertEquals(actualResult,hideButtonText.toLowerCase());


        driver.quit();
    }
    @Then("^I am logged out from account$")
    public void i_am_logged_out_from_account()
    {
       String signInButtonText = driver.findElement(By.xpath(xpathToSignInButton)).getText();
       String expectedResult = "Sign in";
       Assertions.assertNotEquals(expectedResult,signInButtonText);
       teardown();
    }
}
