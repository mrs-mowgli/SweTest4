package com.it;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for search and sort items with Selenium
 * Created by Lotta Berg, 201123
 */
public class TestSearchAndSortSel {


        @BeforeEach
    public void testSetup()
    {
        SearchAndSortSel.goToStartPage("http://40.76.27.113:8085/en/");
    }

    @Test
    public void testLanguageTranslation(){
        SearchAndSortSel.delay(2000);
        SearchAndSortSel.userChooseLanguage("sv");
        SearchAndSortSel.delay(2000);
      SearchAndSortSel.menuBarShouldChange();
    }

    @AfterEach
    public void cleanUp()
    { SearchAndSortSel.tearDown();}

}
