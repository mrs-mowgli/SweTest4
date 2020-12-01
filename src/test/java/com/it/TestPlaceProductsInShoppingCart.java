/*
    Skapad av Linus Finsbäck 2020-11-23
    Ändrad av..
 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlaceProductsInShoppingCart extends TestCode{

    String currentUrl;
    String firstProductStartPage = "/html/body/main/section/div/div/section/section/section/div/article[1]/div/a/img";
    String secondProductStartPage = "";
    String firstProductMenCategory = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article/div/a/img";
    String selectedProduct;
    String priceSelectedProduct;
    String sizeSelectedProduct;
    String colorSelectedProduct;

    @Given("^I have selected category clothes men$")
    public void clickCategoryMen() {
        //Hover at category clothes and then Men
        mouseHoverElementById("category-3", "category-4");

        //Click at category Men
        findElementsById("category-4", click, empty);
    }

    @Given("^I have selected a product$")
    public void selectedProduct() {
        //CLick at product
        currentUrl = getCurrentUrl();
        if(currentUrl.equals("http://40.76.27.113:8085/en/4-men")) {
            findElementsByxPath(firstProductMenCategory, click, empty);
        }
        else {
            findElementsByxPath(firstProductStartPage, click, empty);
            currentUrl = getCurrentUrl();
        }
        selectedProduct = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/h1");
        priceSelectedProduct = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[2]/div/span[1]");
        sizeSelectedProduct = getAttributeByCssTitle("#group_1 > option:nth-child(1)");
        colorSelectedProduct = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/ul/li[1]/label/span/span");
    }

    @When("^I place product in shopping cart$")
    public void placeProductInCart() {
        //click at add to cart
        findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button", click, empty);
    }

    @When("^I continue to shopping cart from pop up")
    public void continueToCart() {
        //Wait for modal to load
        delay(2000);
        //Click at continue shopping
        findElementsByxPath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a", click, empty);
    }

    @When("^I continue to shop from pop up")
    public void continueToShop() {
        //Wait for modal to load
        delay(2000);
        //Click at continue shopping
        findElementsByxPath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button", click, empty);
    }

    @Then("^I will see a pop up with confirmation that product was added to shoppning cart")
    public void verifyModal() {
        //Wait for modal to load
        delay(2000);
        //Verify that product is added
        String currentText = getAttributeByIdInnerHTML("myModalLabel");
        assertEquals("<i class=\"material-icons rtl-no-flip\">\uE876</i>Product successfully added to your shopping cart", currentText);
    }

    @Then("^I will stay at product page")
    public void verifyPage() {
        String testurl;
        testurl = getCurrentUrl();
        assertEquals(currentUrl, testurl);
    }

    @Then("^I will see content of my shopping cart")
    public void verifyContentOfCart() {
        // Variable to save actual value of product in chart
        String actualSelectedProductvalue;
        //Verify name of product
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a");
        assertEquals(selectedProduct, actualSelectedProductvalue);
        //Verify price
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
        assertEquals(priceSelectedProduct, actualSelectedProductvalue);
        //Verify Size
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[2]/div[3]/span[2]");
        assertEquals(sizeSelectedProduct, actualSelectedProductvalue);
        //Verify color
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[2]/div[4]/span[2]");
        assertEquals(colorSelectedProduct, actualSelectedProductvalue);

        //Verify total price
        String totalPrice;
        totalPrice = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[1]/div[2]/div/span[2]");
        assertEquals(priceSelectedProduct, totalPrice);
    }

}
