package com.it;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckoutNotLoggedin extends TestCheckoutNotLoggedinCode {

        /*
    Test methods that is connected to cucumber file checkoutNotLoggedin.feature

    Created by Linus Finsbäck 2020-11-20
    Created by Jenny Lernbring 2020-12-12
 */

    String RealStartURL = "http://40.76.27.113:8085/en/";

    String invalid_firstname = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/div/ul/li";
    String invalid_lastname = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/div/ul/li";
    String invalid_postalcode = "//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/div/ul/li";

    //String inCart_shipping_prestshop = "//*[@id=\"delivery_option_1\"]";
    //String inCart_shipping_prestshop = "//*[@id=\"js-delivery\"]/button";
    String inCart_shipping_prestshop = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span";
    String inCart_shipping_Mycarrier = "//*[@id=\"delivery_option_2\"]";
    String inCart_shipping_continue = "//*[@id=\"js-delivery\"]/button";


    //String inCart_payment_check = "//*[@id=\"payment-option-1\"]";
    String inCart_payment_check = "//*[@id=\"payment-option-1\"]";
    //xpath NOK
    String inCart_payment_bankwire = "//*[@id=\"payment-option-2\"]";
    //full xpath NOK
    //String inCart_payment_bankwire ="/html/body/section/div/section/div/div[1]/section[4]/div/div[2]/div[4]/div/span/input";
    //CSSelector NOK
    //String inCart_payment_bankwire = "#payment-option-2";
    //ID NOK
    //String inCart_payment_bankwire = "payment-option-2";

    String inCart_payment_termsAndCondition = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]";
    String inCart_payment_orderWithAnObligationToPay = "//*[@id=\"payment-confirmation\"]/div[1]/button";



    @Given("start")
    public void start(){
        // Setup chrome browser from BaseClass.
        //setUpChromeBrowser();

        //setUpChromeBrowser() pasted in here because call on method stoped working..?!
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\WebDriver\\bin\\chromedriver.exe");
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;


        //Go to RealStartURL http://40.76.27.113:8085/en/
        driver.get(RealStartURL);
        //driver.get("http://40.76.27.113:8085/en/");
        //Save current URL in variable startURL
        String startURL = driver.getCurrentUrl();
        //Compare given URl and current URL.
        assertEquals(startURL, RealStartURL, "Not correct URL");

        System.out.println("Correct URL, test will continue");
    }

    //Scenario: Checkout from cart as an uninlogged costumer

    @When("put something in cart")
    public void put_something_in_cart() {
        // Calls method from TestCheckoutNotLoggedinCode.
        //Puts a Hummingbird Sweater in cart.
        put_an_item_in_cart();
    }

    @And("^Proceed to checkout$")
    public void go_to_checkout() throws InterruptedException {
        // Calls method from TestCheckoutNotLoggedinCode.
        //Goes from modal to checkout cart
        proceed_to_checkout();
    }


    @When("^I am in cart$")
    public void at_cartURL() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Makes sure that you are at correct URL for cart.
        I_am_in_cart();
    }

    @And("I fill in personal information")
    public void I_fill_in_personal_information(){
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Fill in required personal information in cart in a correct way.
        inCart_Personal_Information();
    }

    @And("^I fill in Addresses$")
    public void addresses() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        // Fill in required address fields in a correct way.
        inCart_Address();
    }

    @And("^I Fill in shipping method \"(.*)\"$")
    public void shipping_method(String shipping_method) {
        //Selecting shippment method
        System.out.println("Shipping Method to be selected");
        //If testing PrestShop
        if(shipping_method.equals("PrestShop")){
            //Click on PrestShop
            findElementsByxPath(inCart_shipping_prestshop, click, empty);
            //Verification that PrestShop is selected.
            System.out.println("Prestshop is selected");
        }

        //If testing My Carrier
        if(shipping_method.equals("My Carrier")){
            //Click on My Carrier
            findElementsByxPath(inCart_shipping_Mycarrier, click, empty);
            //Verification that My Carrier is selected
            System.out.println("My Carrier is selected");
        }

        //Click on Continue
        findElementsByxPath(inCart_shipping_continue, click, empty);
        //Verification that Shipping method is selected
        System.out.println("shipping method selected ");
    }

    @And("^I choose payment \"(.*)\"$")
    public void payment_method(String payment) {
        //Selecting Payment method
        System.out.println("Selecting Payment method");

        //If testing payment Check
        if(payment.equals("check")) {
            System.out.println("Selecting Check");
            //Click on Check
            findElementsByxPath(inCart_payment_check, click, empty);
            //Verification that check is selected
            System.out.println("Check is selected");
        }

        //If testing payment Wire
        if(payment.equals("wire")) {
            System.out.println("Selecting Wire");
            //Click on Wire
            findElementsById(inCart_payment_bankwire, click, empty);
            //Verification that wire is selected
            System.out.println("Wire is selected");
        }
        //Click on checkbox terms and condition
        findElementsByxPath(inCart_payment_termsAndCondition, click, empty);
        //Click on button "Order with an obligation to pay"
        findElementsByxPath(inCart_payment_orderWithAnObligationToPay, click, empty);
        //Verification that payment is selected
        System.out.println("Payment selected");


    }
    @And("I see Order confirmation")
    public void order_confirmation() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Order is confirmed.
        order_is_confirmed();
    }




    //Scenario 2, negative test, personal information

    @And("I fill in wrong firstname \"(.*)\"$")
    public void negativetest_firstname(String firstname) {
        //Writing a name with invalid characters
        findElementsByxPath(inCart_firstname,sendKeys, firstname);
        waiting();
    }

    @And("I fill in wrong lastname \"(.*)\"$")
    public void negativetest_lastname(String lastname) {
        //Writing a lastname with invalid characters
        findElementsByxPath(inCart_lastname,sendKeys, lastname);
        waiting();
    }

    @And("I fill in email \"(.*)\"$")
    public void write_email(String email) {
        //Writing av invalid email address
        findElementsByxPath(inCart_email,sendKeys, email);
        waiting();
    }

    @And("I click on agree to terms and conditions")
    public void click_on_terms_and_conditions() {
        //Calls method from TestCheckoutNotLoggedinCode class.
        //Click on checkbox terms and conditions.
        terms_and_conditions();
    }

     @Then("Invalid fields in personal information")
    public void invalid_fields_in_personal_information() {
            //Alert warning for firstname in invalid format
             if (driver.findElement(By.xpath(invalid_firstname)).isDisplayed()) {
                 System.out.println("Invalid characters in firstname");
             } else {
                 System.out.println("Firstname are writen in correct format");
             }

            // Alert Warning for lastname in invalid format
             if (driver.findElement(By.xpath(invalid_lastname)).isDisplayed()) {
                 System.out.println("Invalid characters in lastname");
             } else {
                 System.out.println("Lastname are writen in correct format");
             }

     }


    //Scenario 3, negative test, addresses


    @And("I fill in address \"(.*)\"$")
    public void negativetest_address(String address) {
        //Writing an address with invalid characters
        findElementsByxPath(inCart_address,sendKeys, address);
        System.out.println("Invalid Address is written");

    }

    @And("I fill in invalid postalcode \"(.*)\"$")
    public void negativetest_postalcode(String postalcode) {
        findElementsByxPath(inCart_postalCode,sendKeys, postalcode);
        //System.out.println("Invalid postalcode is written");
    }

    @And("I fill in invalid city \"(.*)\"$")
    public void negativetest_city(String city) {
        findElementsByxPath(inCart_city,sendKeys, city);
        System.out.println("Invalid city is written");
    }

    @Then("Invalid fields in addresses")
    public void invalid_fields_in_addresses() {
        //Alert warning for postalcode in invalid format
        if (driver.findElement(By.xpath(invalid_postalcode)).isDisplayed()) {
            System.out.println("Invalid postalcode");
        } else {
            System.out.println("Postalcode are writen in correct format");
        }


    }

}


