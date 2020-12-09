/*
    Skapad av Linus Finsbäck 2020-11-23
    Ändrad av..
 */

package com.it;

import io.cucumber.datatable.internal.difflib.Delta;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class PlaceProductsInShoppingCartSteps extends PlaceProductsInShoppingCart {

    String currentUrl;
    String firstProductStartPage = "/html/body/main/section/div/div/section/section/section/div/article[1]/div/a/img";
    String secondProductStartPage = "";
    String firstProductMenCategory = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article/div/a/img";
    String selectedProduct;
    double priceSelectedProduct;
    String sizeSelectedProduct;
    String colorSelectedProduct;
    String quantityInCart;
    double expectedPrice = 0;


    @And("I have selected category {string}")
    public void selectedCategory(String category) {
        selectCategory(category);
    }

    @And("I have selected product {string}")
    public void selectedProduct(String product) {
        findProduct(product);
        selectedProduct = product;
        priceSelectedProduct = getPrice();
    }

    @And("I have selected quantity {string}")
    public void selectedQuantity(String quantity) {
        setQuantity(quantity);
        quantityInCart = quantity;
        int quantityInt;
        quantityInt = Integer.parseInt(quantity);

        for (int i = 0; i < quantityInt; i ++) {
            expectedPrice = expectedPrice + priceSelectedProduct;
        }
    }

    @And("I have selected size {string}")
    public void selectedSize(String size) {
        setSize(size);
        sizeSelectedProduct = " " + size;
    }

    @And("I have selected color {string}")
    public void selectedColor(String color) {
        if (color.equals("N.A")) {
            colorSelectedProduct = "1";
        }
        else {
            setColor(color);
            colorSelectedProduct = " " + color;
        }

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

    @Then("^I will see a pop up with confirmation that product was added to shopping cart")
    public void verifyModal() {
        //Wait for modal to load
        delay(2000);
        //Verify that product is added
        String message = getAttributeByIdInnerHTML("myModalLabel");
        assertEquals("<i class=\"material-icons rtl-no-flip\">\uE876</i>Product successfully added to your shopping cart", message);
        // Variable to save actual value of product in chart
        String actualSelectedProductvalue;
        //Verify name of product
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/h6");
        assertEquals(selectedProduct, actualSelectedProductvalue);
        //Verify product price
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
        double testPrice;
        testPrice = cleanPrice(actualSelectedProductvalue);
        assertEquals(priceSelectedProduct, testPrice);
        //Verify Size
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[1]/strong");
        assertEquals(sizeSelectedProduct, actualSelectedProductvalue);
        //Verify color
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[2]/strong");
        assertEquals(colorSelectedProduct, actualSelectedProductvalue);

        //Verify total price
        String totalPriceString;
        totalPriceString = getAttributeByxPathInnerHTML("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
        double totalPrice;
        totalPrice = cleanPrice(totalPriceString);
        assertEquals(totalPrice, expectedPrice, 0.01);
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
