package com.it;

import org.openqa.selenium.By;

public class CheckoutMethods extends TestCode {

    String emailSese = "test@test.net";
    String passwordSese = "testtest";

    public void loginWithExistingUser(){
        clickXpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
        sendKeysXpath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input", emailSese);
        sendKeysXpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input", passwordSese);
        clickXpath("//*[@id=\"submit-login\"]");
    }

    public void addProductsToCart(){
        //go to accessories and add mug
        clickXpath("//*[@id=\"category-6\"]/a");
        clickXpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img");
        clickXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");

        //clickXpath("//*[@id=\"blockcart-modal\"]/div/div/div[1]/button/span/i");
        //sleeper(2000);
    }

    public void procedToCheckout(){
        //sleeper(2000);//*[@id="main"]/div/div[2]/div[1]/div[2]/div/a
        clickXpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
        clickXpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");
        clickXpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button");
    }

    public void chooseShippingMethod(){
        //default option, should be made dynamic
        clickXpath("//*[@id=\"js-delivery\"]/button");
    }

    public void choosePaymentOption(){
        //check, should be made dynamic
        clickXpath("//*[@id=\"payment-option-1\"]");
    }

    public void acceptTermsOfService(){
        clickXpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]");
    }

    public void makeOrder(){
        clickXpath("//*[@id=\"payment-confirmation\"]/div[1]/button");
    }

    public void logOut(){
        clickXpath("//*[@id=\"_desktop_user_info\"]/div/a[1]");
    }

    public void clickXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void sendKeysXpath(String xpath, String keys){
        driver.findElement(By.xpath(xpath)).sendKeys(keys);
    }

}
