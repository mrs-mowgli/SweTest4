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
    Double totalPriceInt;
    Double finalPrice;

    public void loginWithExistingUser(){
        waiting();
        clickXpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
        sendKeysXpath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input", emailCheckoutTest);
        sendKeysXpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input", passwordCheckoutTest);
        clickXpath("//*[@id=\"submit-login\"]");
    }

    public void addProductsToCart(){
        //go to accessories and add mug
        clickXpath("//*[@id=\"category-6\"]/a");
        clickXpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img");
        price = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/div/span")).getText();
        clickXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    }

    public void procedToCheckout(){
        clickXpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
        assertEquals("Mug The adventure begins", driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a")).getText());
        clickXpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");
        clickXpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button");
    }

    public void chooseShippingMethod(String shippingMethod){
        //default option, should be made dynamic
        waiting();
        if(shippingMethod.equals("PrestShop")){
            clickXpath("//*[@id=\"js-delivery\"]/button");
        }
        if(shippingMethod.equals("My carrier")){
            clickXpath("//*[@id=\"delivery_option_2\"]");
            clickXpath("//*[@id=\"js-delivery\"]/button");
        }

       // if(shippingMethod.equals("PrestShop")) clickXpath("//*[@id=\"js-delivery\"]/button");
    }

    public void choosePaymentOption(String option){
        //check, should be made dynamic

        if(option.equals("Check")){
            clickXpath("//*[@id=\"payment-option-1\"]");
            }

        if (option.equals("Wire")){
                clickXpath("//*[@id=\"payment-option-2\"]");
        }

        //clickXpath("//*[@id=\"payment-option-1\"]");
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

    //remove non numerical values from string and cast to double

    public double cleanPrice(String totalPrice){
        if(totalPrice.equals("Free")){
            totalPriceInt = 0.0;
        }else {
            totalPrice = totalPrice.replaceAll("[^0-9.]", "");
            totalPriceInt = Double.parseDouble(totalPrice.trim());
        }
        return totalPriceInt;
    }

    //method for trimming decimals
    public double trimDec(Double d){
        return Math.floor(d * 100) / 100;
    }

    public void clickXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void sendKeysXpath(String xpath, String keys){
        driver.findElement(By.xpath(xpath)).sendKeys(keys);
    }

}
