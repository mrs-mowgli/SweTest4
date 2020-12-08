/*

Testklass för att filtrera produkter.
Skapad av Sebastian Wimmer 2020-11-22

 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FilterFunctionSteps extends FilterFunctionMethods {

    //@Given("^I am on main page$")
    //public void iAmOnMainPage() {
    //    setUp();
    //}

    @When("^I click on accessories page$")
    public void iClickOnAccessoriesPage() {
        findElementsByxPath(accessories, "click", "");
    }

    @When("^I click on the stationery filter$")
    public void iClickOnTheStationeryFilter() {
        findElementsByxPath(stationery, click, empty);
    }

    @Then("^only items of the category (.*) should be displayed$")
    public void onlyItemsOfTheCategoryFilterShouldBeDisplayed(String filter) {
        String expectedResult = "There are 3 products.";
        Assert.assertEquals(expectedResult, GetResult());
        teardown();
    }

    @When("I select filter {string}")
    public void iSelectFilter(String filter) {
        // selectFilter(filter);
    }

    @Then("only items matching the filter should be displayed")
    public void onlyItemsMatchingTheFilterShouldBeDisplayed() {
    }
}
