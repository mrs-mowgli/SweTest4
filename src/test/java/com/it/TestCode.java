//TestCode.java
/*
 * Javaclass för kod/funktioner som är gemensamma för flera tester
 * Skapad av Linus Finsbäck 2020-11-20
*/


package com.it;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestCode extends BaseClass {

    //Variabler för att utföra actions i funktioner "findElementsBy..."
    public String click = "click";
    public String sendKeys = "sendKeys";
    public String empty = "";
    /**
     * Funktion för att hitta element med hjälp av xPath
     * När funktionen anropas ska tre argument skickas med
     *      String a = xPath
     *      String b , "click" = skickas för att clicka i elementet
     *                  "sendKeys" = Skickas för att fylla i text i textfält
     *                  "empty" = skickas om ingen åtgärd ska utföras
     *      String c = "Text" som ska matas in i textfält
     *
     * Skapad av Linus Finsbäck 2020-11-20
     * Ändrad av ....
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
    /**
     * Funktion för att hitta element med hjälp av ID
     * När funktionen anropas ska tre argument skickas med
     *      String a = xPath
     *      String b , "click" = skickas för att clicka i elementet
     *                  "sendKeys" = Skickas för att fylla i text i textfält
     *                   "empty" = skickas om ingen åtgärd ska utföras
     *      String c = "Text" som ska matas in i textfält
     *
     * Skapad av Linus Finsbäck 2020-11-20
     * Ändrad av ....
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
    /**
     * Funktion för att hitta element med hjälp av CSSselector
     * När funktionen anropas ska tre argument skickas med
     *      String a = xPath
     *      String b , "click" = skickas för att clicka i elementet
     *                  "sendKeys" = Skickas för att fylla i text i textfält
     *                  "empty" = skickas om ingen åtgärd ska utföras
     *      String c = "Text" som ska matas in i textfält
     *
     * Skapad av Linus Finsbäck 2020-11-20
     * Ändrad av Linus Finsbäck 2020-12-06 Added case "clear"
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
            case "clear":
                driver.findElement(By.cssSelector(a)).clear();
                break;
        }
    }

    /**
     * Funktion för att hämta nuvarande url
     * Funktionen returnerer nuvarande url
     *
     * Skapad av Linus Finsbäck 2020-11-20
     * Ändrad av ....
    */
    public String getCurrentUrl() {
        String url;
        url = driver.getCurrentUrl();
        return url;
    }

    /**
     * Funktion för att hämta title
     * Funktionen returnerar nuvarande title
     *
     * Skapad av Linus Finsbäck 2020-11-20
     * Ändrad av ....
    */
    public String getTitle() {
        String title;
        title = driver.getTitle();
        return title;
    }

    /**
     * Method to get Attribute (innerHTML) by ID
     * Method returns text string
     *
     * Created by Linus Finsbäck 2020-11-29
     * Changed by ...
    */
    public String getAttributeByIdInnerHTML(String a) {
        String text;
        try {
            text = driver.findElement(By.id(a)).getAttribute("innerHTML");
            return text;
        }
        catch(Exception NoSuchElementException) {
            return "NoSuchElement";
        }
    }

    /**
     * Method to get Attribute (innerHTML) by xPath
     * Method returns text string
     *
     * Created by Linus Finsbäck 2020-12-01
     * Changed by ...
     */
    public String getAttributeByxPathInnerHTML(String a) {
        String text;
        try {
            text = driver.findElement(By.xpath(a)).getAttribute("innerHTML");
            return text;
        }
        catch(Exception NoSuchElementException) {
            return "NoSuchElement";
        }
    }


    /**
     * Funktion för att hämta css-attributet "value" med getAttribute
     * Funktionen returnerar värdet.
     *
     * Skapad av Mio Lundqvist 2020-11-22
     * Ändrad av ....
     */

    public String getAttributeByCssValue(String a) {
        String cssValue;
        cssValue = driver.findElement(By.cssSelector(a)).getAttribute("value");
        return cssValue;
    }

     /**
      * Funktion för att hämta css-attributet "title" med getAttribute
      * Funktionen returnerar värdet.
      *
      * Skapad av Mio Lundqvist 2020-11-22
      * Ändrad av ....
     */

    public String getAttributeByCssTitle(String a) {
        String cssTitle;
        cssTitle = driver.findElement(By.cssSelector(a)).getAttribute("title");
        return cssTitle;
    }

    /**
     * Tangentbordskommandon
     * skapad av Lotta Berg 2020-11-22
     */
    public static void SendKeyEnter()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER);
    }
    public static void SendKeyTab()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
    }
    /**
     * Laft till delay
     * @param milliseconds
     * Skapad av Lotta Berg 2020-11-22
     */
    public void delay(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } catch (Exception e)
        {System.out.println("something went wrong");
        }
    }

    /**
     * Implicit wait metod för att hantera waits dynamiskt.
     * Dvs den kör så fort som möjligt, men försöker i 30 sekunder
     * innan den kastar ett fel. När det är möjligt så är det fördel
     * att använda den istället för delay.
     * Skapad av Sese Castlind 2020-11-23
     */
    public static void waiting(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Method to hover with mouse over webElements By ID
     * Can be used for hadnling of dropdown menus (categories)
     * 2 Arguments should be included when calling for the method
     *      String a = Id of first element to hover
     *      String b = Id of second element to hover "empty" if not to be used
     *
     * Skapad av Linus Finsbäck 2020-12-01
     */
    public void mouseHoverElementById(String a, String b) {
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(By.id(a));
        action.moveToElement(element1).perform();
        if(!b.equals("empty")) {
            WebElement element2 = driver.findElement(By.id(b));
            action.moveToElement(element2).perform();
        }
    }

    /**
     * Metod för dels omvandla string till double, då de numeriska värdena är strings (på priser mm). Dels för att
     *     rensa bord boksäver, "kr" står med när man hämtar summor från sidan. Detta för att kunna få siffror som går
     *     att summera och jämföra i test, priser etc.
     *     Skapad av Sese Castlind 2020-12-03
     */

    public double cleanPrice(String stringSum){
        Double doubleSum;
        if(stringSum.equals("Free")){
            doubleSum = 0.0;
        }else {
            stringSum = stringSum.replaceAll("[^0-9.]", "");
            doubleSum = Double.parseDouble(stringSum.trim());
        }
        return doubleSum;
    }

    /**
     * Metod för att begränsa doubles till 2 decimaler. Vilket de är på sidan, men
     *     vid uträkningar i BE verkar räkna med double el bigdecimal vilket ger uträkningar
     *     med flera decimaler. Bör ses över lite nogrannare om tid finns. Fungerar korrekt i
     *     de fall jag testat. Behöver vara två decimaler för att kunna göra jämförelse (asserts) med
     *     produktpriser i systemet som skrivs ut med två decimaler:
     *     Skapad av Sese Castlind 2020-12-03
     */
    public double trimDec(Double d){
        return Math.floor(d * 100) / 100;
    }

    /**
     * Method to select product category
     * Include argument for wanted category when calling method
     * Created By Linus Finsbäck 2020-12-08
     * Changed By ....
     */
    public void selectCategory(String category) {
        switch (category) {
            case "men":
                //Hover at category clothes and then Men
                mouseHoverElementById("category-3", "category-4");
                //Click at category Men
                findElementsById("category-4", click, empty);
                break;
            case "women":
                //Hover at category clothes and then Women
                mouseHoverElementById("category-3", "category-5");
                //Click at category women
                findElementsById("category-5", click, empty);
                break;
            case "stationary":
                //Hover at category accessories and then stationary
                mouseHoverElementById("category-6", "category-7");
                //Click at category stationary
                findElementsById("category-7", click, empty);
                break;
            case "home accessories":
                //Hover at category accessories and then home accessories
                mouseHoverElementById("category-6", "category-8");
                //Click at category home accessories
                findElementsById("category-8", click, empty);
                break;
            case "art":
                //Hover at category art
                mouseHoverElementById("category-9", "empty");
                //Click at category art
                findElementsById("category-9", click, empty);
                break;
        }
    }

}
