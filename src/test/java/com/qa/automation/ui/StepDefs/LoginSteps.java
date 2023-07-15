package com.qa.automation.ui.StepDefs;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.qa.automation.ui.pages.LoginPage;
import com.qa.automation.ui.testcontext.TestContext;

import io.cucumber.java.en.Given;

public class LoginSteps {

    TestContext testContext;

    public static Logger logger = Logger.getLogger(LoginSteps.class);

    /**
     * @param testContext
     */
    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        testContext.setLoginPage(new LoginPage(this.testContext));

    }

    /**
     * 
     */
    @Given("User is on Swag Labs login page")
    public void user_is_on_swag_labs_login_page() throws FileNotFoundException {
        testContext.testBase.launchApplication();

    }

    @Given("User enters {string} credentials")
    public void user_enters_credentials(String userType) {
        testContext.loginPage.loginToApplication(userType);
    }

    @Given("User clicks login button")
    public void user_clicks_button() {
        System.out.println("User clicks");
        testContext.loginPage.userClicksOnLoginBtn();
    }

    @Given("User verifies Home page")
    public void user_verifies_home_page() {
        Assert.assertTrue("App Logo is not present...", testContext.loginPage.getAppLogo().isDisplayed());
    }

    @Given("User verifies error message {string}")
    public void user_verifies_error_message(String string) {
        testContext.loginPage.getErrorMessage(string);
    }

    @Given("User verifies delay in visibility of Swag Labs logo")
    public void user_verifies_delay_in_visibility_of_swag_labs_logo() {
    }

}
