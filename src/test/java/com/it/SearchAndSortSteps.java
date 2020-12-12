
package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import java.util.List;

/**
 * StepDefinitions for search and sort items
 * Created by Lotta Berg, 201123
 */

public class SearchAndSortSteps extends TestCode {

    @When("I search {string}")
    public void iSearch(String arg0) {
        WebElement search = driver.findElement(By.xpath("//input[contains(@class,'ui-autocomplete-input')]"));
        search.click();
        search.sendKeys(arg0);
        search.sendKeys(Keys.ENTER);



    }

    @And("I sort {string}")
    public void iSort(String arg0) {
        // added some delay for geckp-tests
        delay(1000);
        WebElement sort = driver.findElement(By.xpath("//button[contains(@class,'btn-unstyle select-title')]"));
        sort.click();
        switch (arg0) {
            case "Relevance":
                driver.findElement(By.partialLinkText("Relevance")).click();
                break;
            case "A to Z":
                driver.findElement(By.partialLinkText("Name, A to Z")).click();
                break;
            case "Z to A":
                driver.findElement(By.partialLinkText("Name, Z to A")).click();
                break;
            case "Price, low to high":
                driver.findElement(By.partialLinkText("Price, low to high")).click();
                break;
            case "Price, high to low":
                driver.findElement(By.partialLinkText("Price, high to low")).click();
                break;
        }
    }

    @Then("I can find article {string}")
    public void iCanFindArticle(String arg0) {
        delay(1000);
        List<WebElement> sortedItems = driver.findElements(By.xpath("//a[contains(@class, 'quick-view')]"));
        System.out.println("number of sorted items: " + sortedItems.size()); //Correct count of search items
        for (WebElement sortedItem : sortedItems){
            sortedItem = driver.findElement(By.xpath("//*[contains(@class, 'h3 product-title')]"));
            Assert.assertTrue(arg0, sortedItem.getText().contains(arg0));
        }
    }

    @When("I write {string}")
    public void iWrite (String arg0) {
    delay(1000);
    WebElement subscribeField = driver.findElement(By.xpath("//input[contains(@placeholder, 'Your email address')]"));
        js.executeScript("arguments[0].scrollIntoView();", subscribeField);
        js.executeScript("arguments[0].click()", subscribeField);
        delay(2000);
    subscribeField.sendKeys(arg0);
    WebElement submitEmail = driver.findElement(By.xpath("//input[@class='btn btn-primary float-xs-right hidden-xs-down']"));
    submitEmail.click();
    delay(4000);
    }

    @Then("I expect an error message")
    public void iExpectAnErrorMessage() {
            try{
                Alert alert = driver.switchTo().alert();
                System.out.println(alert.getText()+" Alert is Displayed");
            }
            catch(NoAlertPresentException ex){
                System.out.println("Alert is NOT Displayed");
            }
        }




}








