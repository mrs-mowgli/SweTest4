package com.it;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutWhenLoggedinMethods extends TestCode {

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
        waiting();
        driver.get("http://40.76.27.113:8085/en/stationery/17-32-brown-bear-notebook.html#/22-paper_type-ruled");
        clickXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"); //add to cart

    }

    public void procedToCheckout(){
        waiting();
        driver.get("http://40.76.27.113:8085/en/order");
        clickXpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button");
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
        waiting();
        if(option.equals("Check")){
            clickXpath("//*[@id=\"payment-option-1\"]");
            }

        if (option.equals("Wire")){
                clickXpath("//*[@id=\"payment-option-2\"]");
        }
    }

    public void acceptTermsOfService(){
        waiting();
        clickXpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]");
    }

    public void checkOrderbuttonInactive(){
        waiting();
        //assert submit button is disabled
        boolean buttonFalse = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).isEnabled();
        assertFalse(buttonFalse);
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
