/*
    Skapad av Linus Finsbäck 2020-11-23
    Ändrad av..
 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlaceProductsInShoppingCart extends TestCode{

    String currentUrl;

    @Given("^I have selected category clothes men$")
    public void categoryMen() {

    }

    @Given("^I have selected a product$")
    public void selectedProduct() {
        // click at ad to cart
        findElementsByxPath("/html/body/main/section/div/div/section/section/section/div/article[1]/div/a/img", click, empty);
        currentUrl = getCurrentUrl();
    }

    @When("^I place product in shopping cart$")
    public void productInCart() {
        findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button", click, empty);
    }

    @When("^I continue to shopping cart from pop up")
    public void continueToCart() {

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

    }

}
