package com.it;

import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutNotLoggedinCode extends TestCode{
    /*
        Here is the code and variables that is specifically used when
        we want to place an order with an customer that is not a member.

        Created by Jenny Lernbring 2020-11-28
        Created by Jenny Lernbring 2020-11-29
     */

    //Proceed_to_checkout()
    String Proceed_to_checkout_modal = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a";
    String Proceed_to_checkout_cart = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a";

    //I_am_in_cart()
    String RealcartURL = "http://40.76.27.113:8085/en/order";

    //I_fill_in_personal_information()
    String socialtitle_mrs = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[2]/span/input";
    String inCart_firstname = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input";
    String inCart_lastname = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input";
    String inCart_email = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input";
    String inCart_termsAndCondition = "//*[@id=\"customer-form\"]/section/div[9]/div[1]/span/label/input";
    String inCart_personalInformation_continue = "//*[@id=\"customer-form\"]/footer/button";
    //String firstname = "" ;

    //addresses()
    String inCart_address = "//*[@id=\"delivery-address\"]/div/section/div[5]/div[1]/input";
    String inCart_postalCode = "//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/input";
    String inCart_city = "//*[@id=\"delivery-address\"]/div/section/div[8]/div[1]/input";
    String inCart_country = "//*[@id=\"delivery-address\"]/div/section/div[9]/div[1]/select";
    String inCart_phone = "//*[@id=\"delivery-address\"]/div/section/div[10]/div[1]/input";
    String inCart_address_continue = "//*[@id=\"delivery-address\"]/div/footer/button";

    //shipping_method()
    String inCart_shipping_prestshop = "//*[@id=\"delivery_option_1\"]";
    String inCart_shipping_Mycarrier = "//*[@id=\"delivery_option_2\"]";
    String incart_shipping_continue = "//*[@id=\"js-delivery\"]/button";

    //payment_method()
    String inCart_payment_bankwire = "//*[@id=\"payment-option-2\"]";
    String inCart_payment_check = "//*[@id=\"payment-option-1\"]";
    String inCart_payment_termsAndCondition = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]";
    String inCart_payment_orderWithAnObligationToPay = "//*[@id=\"payment-confirmation\"]/div[1]/button";

    //order_confirmation()
    String confirmation = "//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3";



    public void proceed_to_checkout() throws InterruptedException {
        // Need to sleep for modal to load properly
        Thread.sleep(2000);
        // Click on Proceed to checkout from modal
        findElementsByxPath(Proceed_to_checkout_modal, click, empty);
        // Click on Proceed to checkout from cart
        findElementsByxPath(Proceed_to_checkout_cart, click, empty);
    }

    public void I_am_in_cart() {
        //Verify that you are on correct URL
        assertEquals(getCurrentUrl(), RealcartURL, "Wrong URL");
    }

    public void inCart_Personal_Information() {
        // Select social title Mrs
        findElementsByxPath(socialtitle_mrs, click, empty);
        // Print Firstname
        findElementsByxPath(inCart_firstname, sendKeys, "firstname");
        // Print Lastname
        findElementsByxPath(inCart_lastname, sendKeys, "Lastname");
        // Print email address
        findElementsByxPath(inCart_email, sendKeys, "testperson@testemail.com");
        // Accept terms and condition
        findElementsByxPath(inCart_termsAndCondition, click, empty);
        // Click on continue
        findElementsByxPath(inCart_personalInformation_continue, click, empty);
        System.out.println("Personal info writen");

    }

    public void inCart_Address() {
        // Print Address
        findElementsByxPath(inCart_address, sendKeys, "Ebbe Lieberathsgatan 18C");
        // Print postalcode
        findElementsByxPath(inCart_postalCode, sendKeys, "412 65");
        // Print city
        findElementsByxPath(inCart_city, sendKeys, "Göteborg");
        // Print Phonenumber
        findElementsByxPath(inCart_phone, sendKeys, "031-790 42 55");
        // Click on continue
        findElementsByxPath(inCart_address_continue, click, empty);
        System.out.println("address writen");

    }
    /*
    public void inCart_shipping_method(String shipping_method){
        // Select shipping method
        if(shipping_method.equals("PrestShop")){
            //clickXpath("//*[@id=\"js-delivery\"]/button");
            findElementsByxPath(inCart_shipping_prestshop, click, empty);
        }
        if(shipping_method.equals("My Carrier")){
            findElementsByxPath(inCart_shipping_Mycarrier, click, empty);
            //clickXpath("//*[@id=\"delivery_option_2\"]");
            //clickXpath("//*[@id=\"js-delivery\"]/button");
        }
        findElementsByxPath(incart_shipping_continue, click, empty);
        System.out.println("shipping method selected ");

        /*
        findElementsByxPath(inCart_shipping_Mycarrier, click, empty);
        // Click on continue
        findElementsByxPath(incart_shipping_continue, click, empty);
        System.out.println("shipping method selected ");


    }

    public void inCart_payment(String payment) {
        // Select payment
        if(payment.equals("check")){
           // clickXpath("//*[@id=\"js-delivery\"]/button");
            findElementsByxPath(inCart_payment_check, click, empty);
            findElementsByxPath(inCart_payment_termsAndCondition, click, empty);

        }
        if(payment.equals("wire")){
            findElementsByxPath(inCart_payment_bankwire, click, empty);
            findElementsByxPath(inCart_payment_termsAndCondition, click, empty);
            findElementsByxPath(inCart_payment_orderWithAnObligationToPay, click, empty);
            //clickXpath("//*[@id=\"delivery_option_2\"]");
            //clickXpath("//*[@id=\"js-delivery\"]/button");
        }
        System.out.println("Payment selected");
        /*
        findElementsByxPath(inCart_payment_bankwire, click, empty);
        // Accept trams and condition
        findElementsByxPath(inCart_payment_termsAndCondition, click, empty);
        // Send order
        findElementsByxPath(inCart_payment_orderWithAnObligationToPay, click, empty);
        System.out.println("Payment selected");


    }

     */



    public void order_is_confirmed() {
        // Saves the header in a variable calls text.
        String text = driver.findElement(By.xpath(confirmation)).getText();
        // Compare the variable text, with expected text when order is placed.
        assertEquals(text, "YOUR ORDER IS CONFIRMED" );
    }

}
