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
            System.out.println(productName);
            if (productName.equals(product)) {
                //selectedProduct = productName;
                findElementsByxPath(xPath1 + i + xPath2, click, empty);
                break;
            }
           /* else if (i == 9) {
                productName = getAttributeByxPathInnerHTML("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article/div/div[1]/h2/a");
                selectedProduct = productName;
                findElementsByxPath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article/div/div[1]/h2/a", click, empty);
            }*/
        }
    }
    /**
     * Method to get price from product
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public String getPrice() {
        String price;
        price = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[2]/div/span[1]");
        if (price.equals("NoSuchElement")) {
            price = getAttributeByxPathInnerHTML("/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[1]/div/span");
        }
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
