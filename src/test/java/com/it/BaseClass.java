package com.it;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {


    public static WebDriver driver;
    public static JavascriptExecutor js ;

    @DisplayName("Setup")
    public static void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("http://40.76.27.113:8085/en/");
        driver.manage().window().maximize();
    }

    @DisplayName("Teardown")
    public static void teardown(){
        driver.quit();
    }

}
