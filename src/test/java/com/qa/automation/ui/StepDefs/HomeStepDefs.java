package com.qa.automation.ui.StepDefs;

import org.apache.log4j.Logger;

import com.qa.automation.ui.pages.HomePage;
import com.qa.automation.ui.testcontext.TestContext;

import io.cucumber.java.en.Given;

public class HomeStepDefs {

    public static Logger logger = Logger.getLogger(HomeStepDefs.class);

    TestContext testContext;
    HomePage homePage;
    public HomeStepDefs(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("User searches product {string}")
    public void user_searches_product(String string) {
       
    }
}
