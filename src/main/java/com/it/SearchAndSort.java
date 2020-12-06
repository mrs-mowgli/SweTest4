
package com.it;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


/**
 * Method class Selenium for search and sort
 * Created by Lotta Berg, 201123
 */
public class SearchAndSort {

     public static WebDriver driver;


    public SearchAndSort()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    public static void goToStartPage(String url) {
        driver.get(url);
    }

        public static void userChooseLanguage(String lang) {
            WebElement languageChooser = driver.findElement(By.xpath("//button[@class='hidden-sm-down btn-unstyle']"));
            languageChooser.click();
            delay(500);
            //WebElement selectLanguage = driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(.,'"+arg0+"')]"));
            WebElement selectLanguage = driver.findElement(By.xpath("//a[@data-iso-code='"+lang+"']"));
            selectLanguage.click();
        }


        public static  void menuBarShouldChange()  // rearranged from a test for each
        {
                String firstMenubarItem = driver.findElement(By.id("category-3")).getText();
                String secondMenubarItem = driver.findElement(By.id("category-6")).getText();
                String thirdMenubarItem = driver.findElement(By.id("category-9")).getText();

            System.out.println("Expected item: Kläder, Actual item: " +firstMenubarItem);
            System.out.println("Expected item: Tillbehör, Actual item: " +secondMenubarItem);
            System.out.println("Expected item: Konst, Actual item: " +thirdMenubarItem);

            delay(1000);
            Assert.assertEquals("Kläder", firstMenubarItem);
            Assert.assertEquals("Tillbehör", secondMenubarItem);
            Assert.assertEquals("Konst", thirdMenubarItem);
        }


            /**
             * Keyboard commands
             * created by Berg 2020-11-22
             */
            public static void SendKeyEnter()
            {
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.ENTER);
            }

            /**
             * Add delay
             * @param milliseconds
             * Created by Lotta Berg 2020-11-22
             */
            public static void delay(int milliseconds)
            {
                try
                {
                    Thread.sleep(milliseconds);
                } catch (Exception e)
                {System.out.println("something went wrong");
                }
            }
            public static  void tearDown()
            { driver.quit();}

}







