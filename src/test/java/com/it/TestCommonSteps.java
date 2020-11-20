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
    @Given("^testGiven$")
    public void testGiven() {

    }

    /*
        Template för gemensamt Whenstep
        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */
    @When("^testWhen$")
    public void testWhen() {

    }
}
