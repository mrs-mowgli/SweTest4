/*
    Skapad av Linus Finsbäck 2020-12-08
    Ändrad av..
 */

package com.it;

import org.openqa.selenium.By;
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
                //findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/ul/li[2]/label/input", click, empty);
                findElementsByxPath("//input[@class='input-color' and @value='11']", click, empty);
                break;
            case "White":
                //findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/ul/li[1]/label/input", click, empty);
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

}
