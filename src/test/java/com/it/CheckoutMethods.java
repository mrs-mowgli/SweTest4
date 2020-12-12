package com.it;

import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CheckoutMethods extends TestCode {

    String emailCheckoutTest = "test@test.net";
    String passwordCheckoutTest = "testtest";
    String price;
    String productPrice;
    String shippingCost;
    Double totalPrice;
    Double finalPrice;

    public void loginWithExistingUser(){
        waiting();
        clickXpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
        sendKeysXpath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input", emailCheckoutTest);
        sendKeysXpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input", passwordCheckoutTest);
        clickXpath("//*[@id=\"submit-login\"]");
    }

    public void addProductsToCart(){
        //clickXpath("//*[@id=\"category-7\"]/a"); //go to category STATIONERY
        //clickXpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img"); //click BROWN BEAR NOTEBOOK
        driver.get("http://40.76.27.113:8085/en/stationery/17-32-brown-bear-notebook.html#/22-paper_type-ruled");
        clickXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"); //add to cart


        /*go to accessories and add mug
        clickXpath("//*[@id=\"category-6\"]/a");
        clickXpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img");
        price = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/div/span")).getText();
        clickXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
        */

        //getProducts.c("");

    }

    public void procedToCheckout(){
        //delay(200000);
        waiting();
       // clickXpath("");//modal checkout button
       // clickXpath(""); // next chekout button
        driver.get("http://40.76.27.113:8085/en/order");
        clickXpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button");
        //delay(10000);


        /*
       // clickXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"); //add to cart
        clickXpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
        //assertEquals("Mug The adventure begins", driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a")).getText());
        //clickXpath("//*[@id=\"blockcart-modal\"]/div/div/div[1]/button/span/i"); //close modal
        clickXpath("//*[@id=\"_desktop_cart\"]/div/div/a/span[1]"); //click checkout button
        //annars driver.get("http://40.76.27.113:8085/en/order");
        clickXpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"); //click next checkout button
        clickXpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button");

         */
    }

    public void chooseShippingMethod(String shippingMethod){
        //choice of shipping method
        waiting();
        if(shippingMethod.equals("PrestShop")){
            clickXpath("//*[@id=\"js-delivery\"]/button");
        }
        if(shippingMethod.equals("My carrier")){
            clickXpath("//*[@id=\"delivery_option_2\"]");
            clickXpath("//*[@id=\"js-delivery\"]/button");
        }
    }

    public void choosePaymentOption(String option){
        //choice of payment option

        if(option.equals("Check")){
            clickXpath("//*[@id=\"payment-option-1\"]");
            }

        if (option.equals("Wire")){
                clickXpath("//*[@id=\"payment-option-2\"]");
        }
    }

    public void acceptTermsOfService(){
        clickXpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]");
    }

    public void makeOrder(){
        totalPrice =         cleanPrice(productPrice = driver.findElement(By.xpath("//*[@id=\"cart-subtotal-products\"]")).getText())
        +         cleanPrice(shippingCost = driver.findElement(By.xpath("//*[@id=\"cart-subtotal-shipping\"]/span[2]")).getText())
        ;
        clickXpath("//*[@id=\"payment-confirmation\"]/div[1]/button");
        finalPrice = trimDec(totalPrice);
    }

    public void logOut(){
        clickXpath("//*[@id=\"_desktop_user_info\"]/div/a[1]");
    }

    //help functions
    public void clickXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickCss(String css){
        driver.findElement(By.cssSelector(css)).click();
    }

    public void sendKeysXpath(String xpath, String keys){
        driver.findElement(By.xpath(xpath)).sendKeys(keys);
    }

}
