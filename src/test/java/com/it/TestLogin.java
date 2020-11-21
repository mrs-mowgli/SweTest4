package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class TestLogin extends TestCode {
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

    @Then("^I am signed in$")
    public void i_am_signed_in() {
        String expectedHeader = "Your account";
        //Checks header on page that should be equal to Your account.
        String actualHeader = driver.findElement(By.xpath("//*[@id=\"main\"]/header/h1")).getText();

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
}
