package com.it;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for search and sort items with Selenium
 * Created by Lotta Berg, 201123
 *
 */
public class TestSearchAndSort {

    SearchAndSort searchAndSort = new SearchAndSort();

        @BeforeEach
    public void testSetup()
    {
        searchAndSort.goToStartPage("http://40.76.27.113:8085/en/");
    }

    @Test
    public void testLanguageTranslation(){
        searchAndSort.delay(2000);
        searchAndSort.userChooseLanguage("sv");
        searchAndSort.delay(2000);
        searchAndSort.menuBarShouldChange();
    }

    @AfterEach
    public void cleanUp()
    { searchAndSort.tearDown();}

}
