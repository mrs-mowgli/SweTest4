/*
All kod som används för att testa filter funktionen

Skapad av Sebastian Wimmer 2020-11-29

 */
package com.it;

import org.junit.Assert;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

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

    //Xptah till Clothes filter
    String white = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Color-White']";
    String black = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Color-Black']";
    String small = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Size-S']";
    String medium = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Size-M']";
    String large = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Size-L']";
    String xl = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Size-XL']";
    String longSleeve = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Property-Long+sleeves']";
    String shortSleeve = "//*[@data-search-url='http://40.76.27.113:8085/en/3-clothes?q=Property-Short+sleeves']";

    //Xpath till Accessories filter
    String whiteAccessories = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Color-White']";
    String blackAccessories = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Color-Black']";
    String ceramic = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Composition-Ceramic']";
    String polyester = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Composition-Polyester']";
    String recycledCardboard = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Composition-Recycled+cardboard']";
    String oneHundredTwentyPages = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Property-120+pages']";
    String removableCover = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Property-Removable+cover']";
    String graphicCorner = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Brand-Graphic+Corner']";
    String studioDesign = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Brand-Studio+Design']";
    String ruled = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Ruled']";
    String plain = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Plain']";
    String squarred = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Squarred']";
    String doted = "//*[@data-search-url='http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Doted']";

    //Xpath till Art filter
    String mattPaper = "//*[@data-search-url='http://40.76.27.113:8085/en/9-art?q=Composition-Matt+paper']";
    String graphicCornerArt = "//*[@data-search-url='http://40.76.27.113:8085/en/9-art?q=Brand-Graphic+Corner']";
    String fortyXsixty = "//*[@data-search-url='http://40.76.27.113:8085/en/9-art?q=Dimension-40x60cm']";
    String sixtyXninety = "//*[@data-search-url='http://40.76.27.113:8085/en/9-art?q=Dimension-60x90cm']";
    String eightyX120 = "//*[@data-search-url='http://40.76.27.113:8085/en/9-art?q=Dimension-80x120cm']";


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

    public String GetCurrentURL() {
        return driver.getCurrentUrl();
    }

    //Method för att välja filter
    public void selectFilter(String filter) {
        switch (filter) {
            case "Men":
                findElementsByxPath("//*[@id=\"facet_15286\"]/li[1]/label/span/span", click, empty);
                break;
            case "Stationery":
                findElementsByxPath(stationery, click, empty);
                break;
            case "Small":
                findElementsByxPath(small, click, empty);
                break;
            case "Medium":
                findElementsByxPath(medium, click, empty);
                break;
            case "Large":
                findElementsByxPath(large, click, empty);
                break;
            case "XL":
                findElementsByxPath(xl, click, empty);
                break;
            case "White":
                findElementsByxPath(white, click, empty);
                break;
            case "Black":
                findElementsByxPath(black, click, empty);
                break;
            case "Long Sleeves":
                findElementsByxPath(longSleeve, click, empty);
                break;
            case "Short Sleeves":
                findElementsByxPath(shortSleeve, click, empty);
                break;
            case "Black Accessories":
                findElementsByxPath(blackAccessories, click, empty);
                break;
            case "White Accessories":
                findElementsByxPath(whiteAccessories, click, empty);
                break;
            case "Ceramic":
                findElementsByxPath(ceramic, click, empty);
                break;
            case "Polyester":
                findElementsByxPath(polyester, click, empty);
                break;
            case "Recycled Cardboard":
                findElementsByxPath(recycledCardboard, click, empty);
                break;
            case "120 pages":
                findElementsByxPath(oneHundredTwentyPages, click, empty);
                break;
            case "Removable Cover":
                findElementsByxPath(removableCover, click, empty);
                break;
            case "Graphic Corner":
                findElementsByxPath(graphicCorner, click, empty);
                break;
            case "Studio Design":
                findElementsByxPath(studioDesign, click, empty);
                break;
            case "Ruled":
                findElementsByxPath(ruled, click, empty);
                break;
            case "Plain":
                findElementsByxPath(plain, click, empty);
                break;
            case "Squarred":
                findElementsByxPath(squarred, click, empty);
                break;
            case "Doted":
                findElementsByxPath(doted, click, empty);
                break;
            case "Matt Paper":
                findElementsByxPath(mattPaper, click, empty);
                break;
            case "Graphic Corner Art":
                findElementsByxPath(graphicCornerArt, click, empty);
                break;
            case "40x60":
                findElementsByxPath(fortyXsixty, click, empty);
                break;
            case "60x90":
                findElementsByxPath(sixtyXninety, click, empty);
                break;
            case "80x120":
                findElementsByxPath(eightyX120, click, empty);
                break;



        }

    }

    //Metod för att välja en av dem tre huvudkategoriarna
    public void selectCategory(String category) {
        switch (category) {
            case "clothes":
                findElementsByxPath("//*[@id=\"category-3\"]/a", click, empty);
                break;

            case "accessories":
                findElementsByxPath("//*[@id=\"category-6\"]/a", click, empty);
                break;

            case "art":
                findElementsByxPath("//*[@id=\"category-9\"]/a", click, empty);
                break;
        }
    }

    //Metod för att returnera korrekta URL för en aktiv filter
    public String expectedURL(String filter) {

        String expectedURL = "";

        switch (filter) {
            case "White":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Color-White";
                break;

            case "Black":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Color-Black";
                break;

            case "Small":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Size-S";
                break;
            case "Medium":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Size-M";
                break;
            case "Large":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Size-L";
                break;
            case "XL":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Size-XL";
                break;
            case "Long Sleeves":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Property-Long+sleeves";
                break;
            case "Short Sleeves":
                expectedURL = "http://40.76.27.113:8085/en/3-clothes?q=Property-Short+sleeves";
                break;
            case "White Accessories":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Color-White";
                break;
            case "Black Accessories":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Color-Black";
                break;
            case "Ceramic":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Composition-Ceramic";
                break;
            case "Polyester":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Composition-Polyester";
                break;
            case "Recycled Cardboard":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Composition-Recycled+cardboard";
                break;
            case "120 pages":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Property-120+pages";
                break;
            case "Removable Cover":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Property-Removable+cover";
                break;
            case "Graphic Corner":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Brand-Graphic+Corner";
                break;
            case "Studio Design":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Brand-Studio+Design";
                break;
            case "Ruled":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Ruled";
                break;
            case "Plain":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Plain";
                break;
            case "Squarred":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Squarred";
                break;
            case "Doted":
                expectedURL = "http://40.76.27.113:8085/en/6-accessories?q=Paper+Type-Doted";
                break;
            case "Matt Paper":
                expectedURL = "http://40.76.27.113:8085/en/9-art?q=Composition-Matt+paper";
                break;
            case "Graphic Corner Art":
                expectedURL = "http://40.76.27.113:8085/en/9-art?q=Brand-Graphic+Corner";
                break;
            case "40x60":
                expectedURL = "http://40.76.27.113:8085/en/9-art?q=Dimension-40x60cm";
                break;
            case "60x90":
                expectedURL = "http://40.76.27.113:8085/en/9-art?q=Dimension-60x90cm";
                break;
            case "80x120":
                expectedURL = "http://40.76.27.113:8085/en/9-art?q=Dimension-80x120cm";
                break;
            case "Stationery":
                expectedURL = "http://40.76.27.113:8085/en/7-stationery";
                break;
        }

        return expectedURL;

    }

}
