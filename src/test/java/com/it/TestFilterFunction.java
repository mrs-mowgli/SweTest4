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
        System.out.println("Ska vara på accessories page");
    }

    @When("I click on the (.*) filter")
    public void iClickOnTheFilterFilter(String filter) {
        System.out.println("Ska välja någon filter");
    }

    @Then("only items of the category (.*) should be displayed")
    public void onlyItemsOfTheCategoryFilterShouldBeDisplayed(String filter) {
        System.out.println("Ska bara visa produkter som tillhör filtern");
    }

}
