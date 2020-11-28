
package com.it;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
/**
 * Cucumbertest search and sort items
 * Created by Lotta Berg, 201123
 */

public class TestSearchAndSort extends TestCode {


   @When("user search {string}") // OK men byggt på gammalt vis
    public void userSearch(String arg0) {
        WebElement search = driver.findElement(By.xpath("//input[contains(@class,'ui-autocomplete-input')]"));
        search.click();
        search.sendKeys(arg0);
        search.sendKeys(Keys.ENTER);
    }

    @And("user sort {string}")
    public void userSort(String arg0) {
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
    @Then("user can find article {string}")
    public boolean userCanFindArticle(String arg0){
        delay(2000);
        WebElement sortOrder = driver.findElement(By.xpath("//button[@class='btn-unstyle select-title']"));
        String currentSortOrder = sortOrder.getText();
        System.out.println("Sort order choosen: " + currentSortOrder);
      if (currentSortOrder.contains(arg0)) {
      return true;
      }
       Assertions.assertTrue(Boolean.parseBoolean(currentSortOrder)); // assertar inte om det false
       return false;
        //    Assert.assertEquals(arg0, currentSortOrder); // should be the correct one but junk char with line break
    }



}


