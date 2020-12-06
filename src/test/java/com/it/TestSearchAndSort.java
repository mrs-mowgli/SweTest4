package com.it;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for search and sort items with Selenium
 * Created by Lotta Berg, 201123
 */
public class TestSearchAndSort {

 

        @BeforeEach
    public void testSetup()
    {
        SearchAndSort.goToStartPage("http://40.76.27.113:8085/en/");
    }

    @Test
    public void testLanguageTranslation(){
        SearchAndSort.delay(2000);
        SearchAndSort.userChooseLanguage("sv");
        SearchAndSort.delay(2000);
        SearchAndSort.menuBarShouldChange();
    }

    @AfterEach
    public void cleanUp()
    { SearchAndSort.tearDown();}

}
