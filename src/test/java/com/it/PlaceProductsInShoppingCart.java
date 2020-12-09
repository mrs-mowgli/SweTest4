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
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void findProduct(String product) {

        String productName;
        String xPath1 = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[";
        String xPath2 = "]/div/div[1]/h2/a";

        for (int i = 1; i < 10; i ++) {
            productName = getAttributeByxPathInnerHTML(xPath1 + i + xPath2);
            if (productName.equals(product)) {
                findElementsByxPath(xPath1 + i + xPath2, click, empty);
                break;
            }
        }
    }
    /**
     * Method to get price from product
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public double getPrice() {
        String priceString;
        double price;
        priceString = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[2]/div/span[1]");
        if (priceString.equals("NoSuchElement")) {
            priceString = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[1]/div/span");
        }
        price = cleanPrice(priceString);
        return price;
    }
    /**
     * Method to set quantity of items to put into shopping cart
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setQuantity(String quantity) {
        findElementsByCss("#quantity_wanted", "clear", empty);
        findElementsByCss("#quantity_wanted", sendKeys, quantity);
    }
    /**
     * Method to set Size of item to put into shopping cart
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setSize(String size) {
        Select sizes = new Select(driver.findElement(By.id("group_1")));
        sizes.selectByVisibleText(size);
    }
    /**
     * Method to select color of product to put into shopping cart
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void setColor(String color) {

        switch (color) {
            case "Black":
                findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/ul/li[2]/label/input", click, empty);
                break;
            case "White":
                findElementsByxPath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/ul/li[1]/label/input", click, empty);
                break;
        }
    }

}
