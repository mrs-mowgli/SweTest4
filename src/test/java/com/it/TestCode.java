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
     */
    public void findElementsByxPath(String a, String b, String c) {

        if(b.equals("click")) {
            driver.findElement(By.xpath(a)).click();
        }
        else if(b.equals("sendKeys")) {
            driver.findElement(By.xpath(a)).sendKeys(c);
        }
        else {
            driver.findElement(By.xpath(a));
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
     */
    public void findElementsById(String a, String b, String c) {

        if(b.equals("click")) {
            driver.findElement(By.id(a)).click();
        }
        else if(b.equals("sendKeys")) {
            driver.findElement(By.id(a)).sendKeys(c);
        }
        else {
            driver.findElement(By.id(a));
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
     */
    public void findElementsByCss(String a, String b, String c) {

        if(b.equals("click")) {
            driver.findElement(By.cssSelector(a)).click();
        }
        else if(b.equals("sendKeys")) {
            driver.findElement(By.cssSelector(a)).sendKeys(c);
        }
        else {
            driver.findElement(By.cssSelector(a));
        }
    }

}
