package com.it;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BaseClass {


    public static WebDriver driver;
    public static JavascriptExecutor js ;
    public static ChromeOptions options = new ChromeOptions();

public static void setUpChromeBrowser()
{
    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\WebDriver\\bin\\chromedriver.exe");
    options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    js = (JavascriptExecutor) driver;


}
public static void setUpFirefoxBrowser()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\WebDriver\\bin\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
  
        firefoxOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
          driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

 @DisplayName("Setup")
    public static void setUp() {
   
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\WebDriver\\bin\\chromedriver.exe");
     
        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @DisplayName("Teardown")
    public static void teardown(){
        driver.quit();
    }

}
