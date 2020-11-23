package com.it;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {


    public static WebDriver driver;
    public static JavascriptExecutor js ;

   @Before
    @DisplayName("Setup")
    public static void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("http://40.76.27.113:8085/en/");
        driver.manage().window().maximize();

    }

    @After
    @DisplayName("Teardown")
    public static void teardown(){
        driver.quit();
    }

    //Method for locating timing issues during test construction, in test wait method should be used.
    //Can also be used to slow test down for visual inspection.
    public void sleeper(int milliS){
        try {
            Thread.sleep(milliS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
