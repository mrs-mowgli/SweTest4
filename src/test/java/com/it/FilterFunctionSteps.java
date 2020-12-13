/*

Testklass för att filtrera produkter.
Skapad av Sebastian Wimmer 2020-11-22

 */

package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import static org.junit.jupiter.api.Assertions.*;

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
         selectFilter(filter);
    }

    @And("I have selected main category {string}")
    public void iHaveSelectedMainCategory(String category) {
        selectCategory(category);
    }

    @Then("only items matching the {string} should be displayed")
    public void onlyItemsMatchingTheShouldBeDisplayed(String filter) {
        //funkar bara för stationery testfall än så länge
        String expectedResult = "There are 3 products.";
        Assert.assertEquals(expectedResult, GetResult());
        teardown();
    }

    @Then("the selected {string} should be active")
    public void theSelectedShouldBeActive(String filter) {
        String expectedURL = expectedURL(filter);
        delay(2000);
        String actualURL = GetCurrentURL();
        assertEquals(expectedURL, actualURL);

    }
}
