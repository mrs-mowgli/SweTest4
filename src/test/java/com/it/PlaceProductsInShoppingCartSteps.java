/*
    Skapad av Linus Finsbäck 2020-11-23
    Ändrad av Linus Finsbäck 2020-12-11
 */

package com.it;

import io.cucumber.datatable.internal.difflib.Delta;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


import static org.junit.jupiter.api.Assertions.*;

public class PlaceProductsInShoppingCartSteps extends PlaceProductsInShoppingCart {

    String currentUrl;
    String selectedProduct;
    double priceSelectedProduct;
    String sizeSelectedProduct;
    String colorSelectedProduct;
    String quantityInCart;
    double expectedPrice;
    String paperTypeSelectedProduct;


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
        expectedPrice = priceSelectedProduct * quantityInt;
    }

    @And("I have selected size {string}")
    public void selectedSize(String size) {
        setSize(size);
        sizeSelectedProduct = " " + size;
    }

    @And("I have selected paperType {string}")
    public void selectedPaperType(String paperType) {
        setPaperType(paperType);
        paperTypeSelectedProduct = " " + paperType;
    }

    @And("I have selected color {string}")
    public void selectedColor(String color) {
            setColor(color);
            colorSelectedProduct = " " + color;
    }

    @When("^I place product in shopping cart$")
    public void placeProductInCart() {
        //click at add to cart

        //findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button", click, empty);
        findElementsByxPath("//*[@class='btn btn-primary add-to-cart']", click, empty);
    }
    @When("^I continue to shopping cart from pop up")
    public void continueToCart() {
        //Wait for modal to load
        delay(2000);
        //Click at continue shopping
        findElementsByxPath("//*[@id='blockcart-modal']//a[@class='btn btn-primary']", click, empty);
    }

    @When("^I continue to shop from pop up")
    public void continueToShop() {
        //Wait for modal to load
        delay(2000);
        //Click at continue shopping
        findElementsByxPath("//*[@id='blockcart-modal']//button[@class='btn btn-secondary']", click, empty);
    }

    @Then("I will see a pop up with confirmation that product of {string} was added to shopping cart")
    public void verifyModal(String productType) {
        //Wait for modal to load
        delay(4000);

        //Verify that product is added
        String message = getAttributeByIdInnerHTML("myModalLabel");
        assertEquals("<i class=\"material-icons rtl-no-flip\">\uE876</i>Product successfully added to your shopping cart", message);

        // Variable to save actual value of product in chart
        String actualSelectedProductvalue;

        //Verify name of product
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//h6[@class='h6 product-name']");
        assertEquals(selectedProduct, actualSelectedProductvalue);

        //Verify product price
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//p[@class='product-price']");
        double testPrice;
        testPrice = cleanPrice(actualSelectedProductvalue);
        assertEquals(priceSelectedProduct, testPrice);

        switch (productType){
            case "sweaterMen":
                //Verify Size
                actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Size:')]//strong");
                assertEquals(sizeSelectedProduct, actualSelectedProductvalue);
                //Verify color
                actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Color:')]//strong");
                assertEquals(colorSelectedProduct, actualSelectedProductvalue);
                break;

            case "sweaterWomen":
                //Verify Size
                actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Size:')]//strong");
                assertEquals(sizeSelectedProduct, actualSelectedProductvalue);
                break;

            case "notebook":
                //Verify paperType
                actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Paper Type:')]//strong");
                assertEquals(paperTypeSelectedProduct, actualSelectedProductvalue);
                break;
            case "pillow":
                //Verify color
                actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Color:')]//strong");
                assertEquals(colorSelectedProduct, actualSelectedProductvalue);
                break;
        }

        //verify quantity
        actualSelectedProductvalue = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Quantity:')]//strong");
        assertEquals(quantityInCart, actualSelectedProductvalue);

        //Verify subtotal price
        String subTotalPriceString;
        subTotalPriceString = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//p[contains(.,'Subtotal:')]//span[@class='value']");
        double subTotalPrice;
        subTotalPrice = cleanPrice(subTotalPriceString);
        assertEquals(subTotalPrice, expectedPrice, 0.1);

        //Verify total price
        double shippingCost;
        shippingCost = checkShippingCost();
        double expectedTotalPrice;
        expectedTotalPrice = shippingCost + subTotalPrice;
        String totalPriceString;
        totalPriceString = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//p[@class='product-total']//span[@class='value']");
        double totalPrice;
        totalPrice = cleanPrice(totalPriceString);
        assertEquals(expectedTotalPrice, totalPrice, 0.1);
    }

    @Then("^I will stay at product page")
    public void verifyPage() {
        String testurl;
        testurl = getCurrentUrl();
        assertEquals(currentUrl, testurl);
    }
/*
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
    }*/


}
