/*
    Skapad av Linus Finsbäck 2020-12-08
    Ändrad av..
 */

package com.it;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PlaceProductsInShoppingCart extends TestCode {

    /**
     * Method to find product at page
     * Include argument of productName when calling method
     * Created By Linus Finsbäck 2020-12-08
     * Changed By 2020-12-12
     */
    public void findProduct(String product) {
        findElementsByxPath("//article[@class='product-miniature js-product-miniature']//a[contains(.,'" + product + "')]", click, empty);
    }
    /**
     * Method to get price from product
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public double getPrice() {
        String priceString;
        double price;
        priceString = getAttributeByxPathInnerHTML("//div[@class='current-price']//span");
        price = cleanPrice(priceString);
        return price;
    }
    /**
     * Method to set quantity of items to put into shopping cart
     * Include argument of quantity when calling method
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setQuantity(String quantity) {
        delay(2000);
        findElementsByCss("#quantity_wanted", "clear", empty);
        delay(2000);
        findElementsByCss("#quantity_wanted", sendKeys, quantity);
    }
    /**
     * Method to set Size of item to put into shopping cart
     * Include argument of size when calling method
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setSize(String size) {
        Select sizes = new Select(driver.findElement(By.id("group_1")));
        sizes.selectByVisibleText(size);
    }
    /**
     * Method to set paperType of item to put into shopping cart
     * Include argument of paperType when calling method
     * Created By Linus Finsbäck 2020-12-10
     * Changed By ....
     */
    public void setPaperType(String paperType) {
        Select paperTypes = new Select(driver.findElement(By.id("group_4")));
        paperTypes.selectByVisibleText(paperType);
    }

    /**
     * Method to select color of product to put into shopping cart
     * Include argument of color when calling method
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setColor(String color) {

        switch (color) {
            case "Black":
                findElementsByxPath("//input[@class='input-color' and @value='11']", click, empty);
                break;
            case "White":
                findElementsByxPath("//input[@class='input-color' and @value='8']", click, empty);
                break;
        }
    }
    /**
     * Method to check price for shipping
     * Created By Linus Finsbäck 2020-12-12
     * Changed By ....
     */
    public double checkShippingCost() {
        String shippingPriceString;
        shippingPriceString = getAttributeByxPathInnerHTML("//*[@id='blockcart-modal']//p[contains(.,'Shipping:')]//span[@class='value']");
        double shippingPrice;
        if (shippingPriceString.equals("Free ")) {
            shippingPrice = 0;
        }
        else {
            shippingPrice = cleanPrice(shippingPriceString);
        }
        return shippingPrice;
    }
    /**
     * Method to get price from shopping cart
     * Include xPath as argument when calling method
     * Created By Linus Finsbäck 2020-12-12
     * Changed By ....
     */
    public double getPriceFromCart(String xPath) {
        String priceString = getAttributeByxPathInnerHTML(xPath);
        return cleanPrice(priceString);
    }
    /**
     * Method to check availability of product
     * Created By Linus Finsbäck 2020-12-12
     * Changed By ....
     */
    public String verifyAvailability() {
        return getAttributeByxPathInnerHTML("//span[@id='product-availability']");
    }
    /**
     * Method to add product to cart
     * Include String availability as argument when calling method
     * Created By Linus Finsbäck 2020-12-12
     * Changed By ....
     */
    public void clickAddToCart(String availability) {
        if (!availability.contains("tock")) {
            //click at add to cart
            findElementsByxPath("//*[@class='btn btn-primary add-to-cart']", click, empty);
        }
    }
    /**
     * Method to add product to cart
     * Include String customText as argument when calling method
     * Created By Linus Finsbäck 2020-12-12
     * Changed By ....
     */
    public void enterCustomText(String text) {
        findElementsByxPath("//section[@class='product-customization']//textarea[@class='product-message']", sendKeys, text);
        findElementsByxPath("//section[@class='product-customization']//button[@class='btn btn-primary float-xs-right']", click, empty);
    }
    /**
     * Method to set dimension of item to put into shopping cart
     * Include argument of size when calling method
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setDimension(String dimension) {
        Select dimensions = new Select(driver.findElement(By.id("group_3")));
        dimensions.selectByVisibleText(dimension);
    }
    /**
     * Method to get full name of item to put into shopping cart
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public String getProductName(String product) {
        String productName = getAttributeByxPathInnerHTML("//div[@class='row product-container']//h1[@class='h1']");
        if (productName.contains(product)) {
            return productName;
        }
        else {
            return "error";
        }
    }
    /**
     * Method to select a product from start page
     * Include argument of type int (index 1-8) when calling for method
     * Created By Linus Finsbäck 2020-12-13
     * Changed By ....
     */
    public void selectProductFromStartPage(Integer index) {
        findElementsByxPath("//article[@class='product-miniature js-product-miniature' and @data-id-product='" + index + "']//h3//a", click, empty);
    }
    /**
     * Method to check status of button
     * Include xPath to button as argument when calling method
     * Created By Linus Finsbäck 2020-12-13
     * Changed By ....
     */
    public boolean checkButtonStatus(String xPath) {
        WebElement button = driver.findElement(By.xpath(xPath));
        return button.isEnabled();
    }
    /**
     * Method to increase quantity until it reach limit of stock
     * Created By Linus Finsbäck 2020-12-13
     * Changed By ....
     */
    public void increaseQuantity() {
        for (int i = 0; i < 1000; i++) {
            findElementsByxPath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']", click, empty);
            delay(500);
            if (verifyAvailability().contains("There are not enough products in stock")) {
                break;
            }
        }
    }

    /**
     * Method to verify availability of product included in package
     * Created By Linus Finsbäck 2020-12-13
     * Changed By ....
     */
    public String verifyAvailabilityOfPackProducts() {
        String currentUrl = getCurrentUrl();
        findElementsByxPath("//section[@class='product-pack']//article[1]//div[@class='pack-product-name']//a", click, empty);
        setQuantity("5");
        String availabilityProduct1 = verifyAvailability();
        driver.get(currentUrl);
        findElementsByxPath("//section[@class='product-pack']//article[2]//div[@class='pack-product-name']//a", click, empty);
        setQuantity("5");
        String availabilityProduct2 = verifyAvailability();
        driver.get(currentUrl);

        if (availabilityProduct1.contains("tock")) {
            return "product 1 out of stock";
        }
        else if (availabilityProduct2.contains("tock")) {
            return "product 2 out of stock";
        }
        else {
            return "";
        }
    }
    /**
     * Method to open quick View of an product
     * Include argument of index at page when calling method
     * Created By Linus Finsbäck 2020-12-13
     * Changed By ....
     */
    public void openQuickView(Integer i) {
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//article[@class='product-miniature js-product-miniature' and @data-id-product='" + i + "']//div[@class='product-description']"));
        action.moveToElement(element1).perform();
        WebElement element2 = driver.findElement(By.xpath("//article[@class='product-miniature js-product-miniature' and @data-id-product='" + i + "']//div[@class='highlighted-informations no-variants hidden-sm-down']"));
        action.moveToElement(element2).perform();
        findElementsByxPath("//article[@class='product-miniature js-product-miniature' and @data-id-product='" + i + "']//div[@class='highlighted-informations no-variants hidden-sm-down']//a[@class='quick-view']", click, empty);
    }
    /**
     * Method to go to Url
     * Include argument of url at page when calling method
     * Created By Linus Finsbäck 2020-12-13
     * Changed By ....
     */
    public void goToUrl(String url) {
        driver.get(url);
    }
}
