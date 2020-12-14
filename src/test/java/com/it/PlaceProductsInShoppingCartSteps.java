/*
    Skapad av Linus Finsbäck 2020-11-23
    Ändrad av Linus Finsbäck 2020-12-11
 */

package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;



import static org.junit.jupiter.api.Assertions.*;

public class PlaceProductsInShoppingCartSteps extends PlaceProductsInShoppingCart {

    //Variables to save productvalue before putting it to shopping cart
    String currentUrl;
    String selectedProduct;
    double priceSelectedProduct;
    String sizeSelectedProduct;
    String colorSelectedProduct;
    String quantityInCart;
    double expectedPrice;
    String paperTypeSelectedProduct;
    String availability;
    String customText;
    String dimensionSelecetedProduct;
    String productAvailability;


    @And("I have selected category {string}")
    public void selectedCategory(String category) {
        selectCategory(category);
    }

    @And("I have selected product {string}")
    public void selectedProduct(String product) {
        findProduct(product);
        selectedProduct = getProductName(product);
    }

    @And("I have selected quantity {string}")
    public void selectedQuantity(String quantity) {
        delay(500);
        priceSelectedProduct = getPrice();
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

    @And("I have added my custom {string}")
    public void addCustomText(String text) {
        enterCustomText(text);
        customText = text;
    }

    @And("I have selected dimension {string}")
    public void selectedDimension(String dimension) {
        setDimension(dimension);
        dimensionSelecetedProduct = " " + dimension;
    }

    @And("I have selected a product from start page")
    public void selectedProductStartPage() {
        selectProductFromStartPage(1);
        currentUrl = getCurrentUrl();
    }

    @And("^I have selected too many products")
    public void addToManyProducts() {
        increaseQuantity();
    }

    @And("I have selected {string} including a product out of stock")
    public void selectPackageOutOfStock(String product) {
        findProduct(product);
        productAvailability = verifyAvailabilityOfPackProducts();
    }

    @And("^I have opened quick view of an product at start page$")
    public void openQuickView() {
        openQuickView(6);
        delay(2000);
        selectedProduct = getAttributeByxPathInnerHTML("//*[@id='quickview-modal-6-0']//h1[@class='h1']");
        priceSelectedProduct = getPrice();
        setQuantity("2");
        expectedPrice = priceSelectedProduct * 2;
    }

    @And("^I have added all available items of product to cart$")
    public void addAllAvailableItems() {
        increaseQuantity();
        findElementsByxPath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-down']", click, empty);
        currentUrl = getCurrentUrl();
        //click at add to cart
        findElementsByxPath("//*[@class='btn btn-primary add-to-cart']", click, empty);
    }

    @When("^I place product in shopping cart$")
    public void placeProductInCart() {

        availability = verifyAvailability();
        clickAddToCart(availability);
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

    @When("^I try to place product in shopping cart$")
    public void tryToPlaceProductInCart() {

    }
    @When("^I try to add one more item of same product$")
    public void addOneMoreItem() {
        goToUrl(currentUrl);

    }


    @Then("I will see a pop up with confirmation that product of {string} was added to shopping cart")
    public void verifyModal(String productType) {
        //Handle fault if product is out of stock
        if (!availability.contains("tock")) {
            //Wait for modal to load
            delay(4000);

            //Verify that product is added
            assertEquals("<i class=\"material-icons rtl-no-flip\">\uE876</i>Product successfully added to your shopping cart", getAttributeByIdInnerHTML("myModalLabel"));

            //Verify name of product
            assertEquals(selectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//h6[@class='h6 product-name']"));

            //Verify product price
            assertEquals(priceSelectedProduct, getPriceFromCart("//*[@id='blockcart-modal']//p[@class='product-price']"));

            switch (productType){
                case "sweaterMen":
                    //Verify Size
                    assertEquals(sizeSelectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Size:')]//strong"));
                    //Verify color
                    assertEquals(colorSelectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Color:')]//strong"));
                    break;

                case "sweaterWomen":
                    //Verify Size
                    assertEquals(sizeSelectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Size:')]//strong"));
                    break;

                case "notebook":
                    //Verify paperType
                    assertEquals(paperTypeSelectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Paper Type:')]//strong"));
                    break;
                case "pillow":
                    //Verify color
                    assertEquals(colorSelectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Color:')]//strong"));
                    break;
                case "poster":
                    //Verify dimension
                    assertEquals(dimensionSelecetedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Dimension:')]//strong"));
                    break;
            }

            //verify quantity
            assertEquals(quantityInCart, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//span[contains(.,'Quantity:')]//strong"));

            //Verify subtotal price
            assertEquals(expectedPrice, getPriceFromCart("//*[@id='blockcart-modal']//p[contains(.,'Subtotal:')]//span[@class='value']"), 0.1);

            //Verify total price
            assertEquals(checkShippingCost() + expectedPrice, getPriceFromCart("//*[@id='blockcart-modal']//p[@class='product-total']//span[@class='value']"), 0.1);

        }
    }

    @Then("^I will stay at product page")
    public void verifyPage() {
        assertEquals(currentUrl, getCurrentUrl());
    }

    @And("^Shopping cart will contain one item")
    public void verifyCartCounter() {
        assertEquals("(1)", getAttributeByxPathInnerHTML("//span[@class='cart-products-count']"));
    }

    @Then("^I will see content of my shopping cart")
    public void verifyContentOfCart() {
        //Handle fault if product is out of stock
        if (!availability.contains("tock")) {
            //Verify that shopping cart is opened
            assertEquals("Shopping Cart", getAttributeByxPathInnerHTML("//div[@class='cart-grid-body col-xs-12 col-lg-8']//h1"));
            //Verify productName
            assertEquals(selectedProduct, getAttributeByxPathInnerHTML("//div[@class='cart-grid-body col-xs-12 col-lg-8']//a[@class='label']"));
            //Verify product price
            assertEquals(priceSelectedProduct, getPriceFromCart("//div[@class='cart-grid-body col-xs-12 col-lg-8']//div[@class='current-price']//span[@class='price']"), 0.1);
            //Verify size
            assertEquals(sizeSelectedProduct, " " + getAttributeByxPathInnerHTML("//div[@class='cart-grid-body col-xs-12 col-lg-8']//div[@class='product-line-info' and contains(.,'Size:')]//Span[@class='value']"));
            //Verify color
            assertEquals(colorSelectedProduct, " " + getAttributeByxPathInnerHTML("//div[@class='cart-grid-body col-xs-12 col-lg-8']//div[@class='product-line-info' and contains(.,'Color:')]//Span[@class='value']"));
        }
    }

    @Then("^The add to cart button will not be interactable$")
    public void addToCartNotActive() {
        assertFalse(checkButtonStatus("//*[@class='btn btn-primary add-to-cart']"));
    }

    @Then("^I expect the add to cart button to be uninteractable$")
    public void verifyAddToCartButton() {
        if (productAvailability.equals("")) {
            assertTrue(checkButtonStatus("//*[@class='btn btn-primary add-to-cart']"));
        }
        else {
            assertFalse(checkButtonStatus("//*[@class='btn btn-primary add-to-cart']"));
        }
    }

    @Then("^I will see a pop up with confirmation that product was added to shopping cart$")
    public void verifyModalAfterQuickView() {
        //Handle fault if product is out of stock
        if (!availability.contains("tock")) {
            //Wait for modal to load
            delay(4000);

            //Verify that product is added
            assertEquals("<i class=\"material-icons rtl-no-flip\">\uE876</i>Product successfully added to your shopping cart", getAttributeByIdInnerHTML("myModalLabel"));

            //Verify name of product
            assertEquals(selectedProduct, getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//h6[@class='h6 product-name']"));

            //Verify product price
            assertEquals(priceSelectedProduct, getPriceFromCart("//*[@id='blockcart-modal']//p[@class='product-price']"));

            //Verify subtotal price
            assertEquals(expectedPrice, getPriceFromCart("//*[@id='blockcart-modal']//p[contains(.,'Subtotal:')]//span[@class='value']"), 0.1);

            //Verify total price
            assertEquals(checkShippingCost() + expectedPrice, getPriceFromCart("//*[@id='blockcart-modal']//p[@class='product-total']//span[@class='value']"), 0.1);

        }
    }
}
