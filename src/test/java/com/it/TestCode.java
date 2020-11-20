/*
    Java class för kod/funktioner som är gemensamma för flera tester
    Skapad av Linus Finsbäck 2020-11-20
 */


package com.it;

import org.openqa.selenium.By;

public class TestCode extends BaseClass{

    //Variabler för att utföra actions i funktioner "findElementsBy..."
    public String click = "click";
    public String sendKeys = "sendKeys";
    public String empty = "";
    /*
        Funktion för att hitta element med hjälp av xPath
        När funktionen anropas ska tre argument skickas med
            String a = xPath
            String b , "click" = skickas för att clicka i elementet
                       "sendKeys" = Skickas för att fylla i text i textfält
                       "empty" = skickas om ingen åtgärd ska utföras
            String c = "Text" som ska matas in i textfält

        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */
    public void findElementsByxPath(String a, String b, String c) {

        switch (b) {
            case "click":
                driver.findElement(By.xpath(a)).click();
                break;
            case "sendKeys":
                driver.findElement(By.xpath(a)).sendKeys(c);
                break;
            case "":
                driver.findElement(By.xpath(a));
                break;
        }
    }
    /*
        Funktion för att hitta element med hjälp av ID
        När funktionen anropas ska tre argument skickas med
            String a = xPath
            String b , "click" = skickas för att clicka i elementet
                       "sendKeys" = Skickas för att fylla i text i textfält
                       "empty" = skickas om ingen åtgärd ska utföras
            String c = "Text" som ska matas in i textfält

        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */
    public void findElementsById(String a, String b, String c) {

        switch (b) {
            case "click":
                driver.findElement(By.id(a)).click();
                break;
            case "sendKeys":
                driver.findElement(By.id(a)).sendKeys(c);
                break;
            case "":
                driver.findElement(By.id(a));
                break;
        }
    }
    /*
        Funktion för att hitta element med hjälp av CSSselector
        När funktionen anropas ska tre argument skickas med
            String a = xPath
            String b , "click" = skickas för att clicka i elementet
                       "sendKeys" = Skickas för att fylla i text i textfält
                       "empty" = skickas om ingen åtgärd ska utföras
            String c = "Text" som ska matas in i textfält

        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */
    public void findElementsByCss(String a, String b, String c) {

        switch (b) {
            case "click":
                driver.findElement(By.cssSelector(a)).click();
                break;
            case "sendKeys":
                driver.findElement(By.cssSelector(a)).sendKeys(c);
                break;
            case "":
                driver.findElement(By.cssSelector(a));
                break;
        }
    }

    /*
        Funktion för att hämta nuvarande url
        Funktionen returnerer nuvarande url

        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
    */
    public String getCurrentUrl() {
        String url;
        url = driver.getCurrentUrl();
        return url;
    }

    /*
        Funktion för att hämta title
        Funktionen returnerar nuvarande title

        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */
    public String getTitle() {
        String title;
        title = driver.getTitle();
        return title;
    }
}
