package com.it;

import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutNotLoggedinCode extends TestCode{
    //Här ska all kod vara.
    //Allt anropas till TestCheckoutNotLoggedin.

    //Proceed_to_checkout()
    String Proceed_to_checkout_modal = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a";
    String Proceed_to_checkout_cart = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a";

    //I_am_in_cart()
    String RealcartURL = "http://40.76.27.113:8085/en/order";

    //Personalinformation
    String socialtitle_mrs = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[2]/span/input";
    String inCart_firstname = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input";
    String inCart_lastname = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input";
    String inCart_email = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input";
    String inCart_termsAndCondition = "//*[@id=\"customer-form\"]/section/div[9]/div[1]/span/label/input";
    String inCart_personalInformation_continue = "//*[@id=\"customer-form\"]/footer/button";

    //Addresses
    String inCart_address = "//*[@id=\"delivery-address\"]/div/section/div[5]/div[1]/input";
    String inCart_postalCode = "//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/input";
    String inCart_city = "//*[@id=\"delivery-address\"]/div/section/div[8]/div[1]/input";
    String inCart_country = "//*[@id=\"delivery-address\"]/div/section/div[9]/div[1]/select";
    String inCart_phone = "//*[@id=\"delivery-address\"]/div/section/div[10]/div[1]/input";
    String inCart_address_continue = "//*[@id=\"delivery-address\"]/div/footer/button";

    //Shipping Methods
    String inCart_shipping_Mycarrier = "//*[@id=\"checkout\"]";
    String incart_shipping_continue = "//*[@id=\"js-delivery\"]/button";

    //Payment
    String inCart_payment_bankwire = "//*[@id=\"payment-option-2\"]";
    String inCart_payment_termsAndCondition = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]";
    String inCart_payment_orderWithAnObligationToPay = "//*[@id=\"payment-confirmation\"]/div[1]/button";

    //Order confirmed
    String confirmation = "//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3";



    String address_tab_text = "2 ADDRESSES";
    String Sweden = "Sweden";

    public void proceed_to_checkout() throws InterruptedException {
        Thread.sleep(2000);
        findElementsByxPath(Proceed_to_checkout_modal, click, empty);
        findElementsByxPath(Proceed_to_checkout_cart, click, empty);
    }

    public void I_am_in_cart() {
        assertEquals(getCurrentUrl(), RealcartURL, "Wrong URL for cart");
    }

    public void inCart_Personal_Information() {
        findElementsByxPath(socialtitle_mrs, click, empty);
        findElementsByxPath(inCart_firstname, sendKeys, "firstname");
        findElementsByxPath(inCart_lastname, sendKeys, "Lastname");
        findElementsByxPath(inCart_email, sendKeys, "hej@ohå.se");
        findElementsByxPath(inCart_termsAndCondition, click, empty);
        findElementsByxPath(inCart_personalInformation_continue, click, empty);

    }

    public void inCart_Address() {
        findElementsByxPath(inCart_address, sendKeys, "hej");
        findElementsByxPath(inCart_postalCode, sendKeys, "345 66");
        findElementsByxPath(inCart_city, sendKeys, "götlabörg");
        findElementsByxPath(inCart_phone, sendKeys, "31234567");
        findElementsByxPath(inCart_address_continue, click, empty);

    }
    public void inCart_shippingMethod(){
        findElementsByxPath(inCart_shipping_Mycarrier, click, empty);
        findElementsByxPath(incart_shipping_continue, click, empty);
    }

    public void inCart_payment() {
        findElementsByxPath(inCart_payment_bankwire, click, empty);
        findElementsByxPath(inCart_payment_termsAndCondition, click, empty);
        findElementsByxPath(inCart_payment_orderWithAnObligationToPay, click, empty);
    }

    public void order_is_confirmed() {
        String text = driver.findElement(By.xpath(confirmation)).getText();
        assertEquals(text, "YOUR ORDER IS CONFIRMED" );
    }

}
