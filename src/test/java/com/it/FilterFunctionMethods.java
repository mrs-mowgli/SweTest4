/*
All kod som används för att testa filter funktionen

Skapad av Sebastian Wimmer 2020-11-29

 */
package com.it;

import org.openqa.selenium.By;

public class FilterFunctionMethods extends TestCode{

    //Xpath till kategorier i top menyn
    String accessories = "//*[@id=\"category-6\"]/a";
    String clothes = "//*[@id=\"category-3\"]/a";
    String art = "//*[@id=\"category-9\"]/a";

    //Xpath till underkategorier
    String men = "//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a";
    String women = "//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[2]/a";
    String stationery = "//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a";
    String homeAccessories = "//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[2]/a";

    //Xpath till alla filter för Clothes
    String menCheckbox = "//*[@id=\"facet_15286\"]/li[1]/label/span/span";
    String womenCheckbox = "//*[@id=\"facet_91838\"]/li[2]/label/span/span/i";
    //det finns mer....


    //Namn på alla Stationeries
    String mountainFoxNotebook = "Mountain fox notebook";
    String brownBearNotebook = "Brown bear notebook";
    String hummingbirdNotebook = "Hummingbird notebook";

    public void Stationery(){
        findElementsByxPath(stationery, click, empty);
    }

    public void HomeAccessories(){
        findElementsByxPath(homeAccessories, click, empty);
    }

    //public String GetStationeryNames() {
        //String actualFox = findElementsByxPath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a", click, empty).getText();
        //String actualBear = findElementsByxPath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h2/a", empty, empty).getText();
        //String actualHummingbird = findElementsByxPath("//*[@id=\"js-product-list\"]/div[1]/article[3]/div/div[1]/h2/a", click, empty).getText();
    //}

    //Första utkast för att få jämföra ett resultat... Kollar just nu på hur många stationaries som finns, och borde därför skrivas om.
    public String GetResult() {
        return driver.findElement(By.xpath("//*[@id=\"js-product-list-top\"]/div[1]/p")).getText();
    }

    //Method för att välja filter
    public void selectFilter(String filter) {
        switch (filter) {
            case "S":
                findElementsByxPath("//*[@id=\"facet_23015\"]/li[1]/label/span/span", click, empty);
                break;
            case "M":
                findElementsByxPath("//*[@id=\"facet_79310\"]/li[2]/label/span/span/", click, empty);
                break;
            case "L":
                findElementsByxPath("//*[@id=\"facet_79310\"]/li[3]/label/span/span", click, empty);
                break;
            case "XL":
                findElementsByxPath("//*[@id=\"facet_79310\"]/li[4]/label/span/span", click, empty);
                break;
        }

    }

}
