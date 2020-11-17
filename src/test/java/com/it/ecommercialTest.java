package com.it;

import io.cucumber.java.en.Given;

public class ecommercialTest extends BaseClass{

    @Given("^Open Browser$")
    public void open_browser(){
        setUp();
    }


    @Given("^tearDown$")
    public void tearDown() {
        teardown();
    }
}
