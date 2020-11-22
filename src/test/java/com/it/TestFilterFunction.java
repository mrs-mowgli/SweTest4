/*

Testklass för att filtrera produkter.
Skapad av Sebastian Wimmer 2020-11-22

 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestFilterFunction extends TestCode {

    @Given("I am on the accessories page")
    public void iAmOnTheAccessoriesPage() {
    }

    @When("I click on the {string} filter")
    public void iClickOnTheFilter(String arg0) {

    }

    @Then("only items of the category {string} should be displayed")
    public void onlyItemsOfTheCategoryShouldBeDisplayed(String arg0) {
    }
}
