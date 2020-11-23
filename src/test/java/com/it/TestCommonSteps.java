/*
    Testclass för teststeps som är lika för flera feature files
    Skapad av Linus Finsbäck 2020-11-20
 */

package com.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

public class TestCommonSteps extends TestCode{

    /*
        Template för gemensamt Givenstep
        Skapad av Linus Finsbäck 2020-11-20
        Ändrad av ....
     */

    @Before
    public void start()
    {
        setUp();
    }

    @After
    public void  stop()
        {
            teardown();
        }

    @Given("^I am on start page$")
    public void IAmOnStartPage() {
    driver.get("http://40.76.27.113:8085/en/");
    }

    @When("^testWhen$")
    public void testWhen() {

    }

    @Given("Test User is at webshop start page")
    public void testUserIsAtWebshopStartPage() {
        setUp();
    }
}
