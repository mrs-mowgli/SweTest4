/*
    Testclass för teststeps som är lika för flera feature files
    Skapad av Linus Finsbäck 2020-11-20
 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TestCommonSteps extends TestCode{

    /*
        Template för gemensamt Givenstep
        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */
    @Given("^I am on start page$")
    public void IAmOnStartPage() {
    driver.getUrl();
    }

  
    @When("^testWhen$")
    public void testWhen() {

    }
}
