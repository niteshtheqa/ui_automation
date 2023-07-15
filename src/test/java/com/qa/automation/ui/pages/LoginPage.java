package com.qa.automation.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.automation.ui.base.TestBase;
import com.qa.automation.ui.testcontext.TestContext;

public class LoginPage {

    TestContext testContext;

    public static Logger logger = Logger.getLogger(LoginPage.class);

    public LoginPage(TestContext testContext) {
        this.testContext = testContext;
        testContext.setTestBase(new TestBase(this.testContext));
    }

    By username = By.xpath(".//input[@id='user-name']");
    By password = By.xpath(".//input[@id='password']");
    By loginBt = By.xpath(".//input[@id='login-button']");
    By appLogo = By.xpath(".//div[text()='Swag Labs']");

    public WebElement getUsername() {
        return testContext.driver.findElement(username);
    }

    public WebElement getPassword() {
        return testContext.driver.findElement(password);
    }

    public WebElement getLoginBtn() {
        return testContext.driver.findElement(loginBt);
    }

    public WebElement getAppLogo() {
        return testContext.driver.findElement(appLogo);
    }

    public WebElement getErrorMessage(String error) {
        return testContext.driver.findElement(By.xpath(".//*[text()='" + error + "']"));
    }

    public void loginToApplication(String usertype) {
        String pass = "secret_sauce";
        String userType = usertype;
        switch (userType) {
            case "standard_user":
                getUsername().sendKeys(userType);
                getPassword().sendKeys(pass);
                break;
            case "locked_out_user":
                getUsername().sendKeys(userType);
                getPassword().sendKeys(pass);
                break;
            case "problem_user":
                getUsername().sendKeys(userType);
                getPassword().sendKeys(pass);
                break;
            case "performance_glitch_user":
                getUsername().sendKeys(userType);
                getPassword().sendKeys(pass);
                break;
            default:
                System.out.println("Invalid username and password...");
                break;

        }

    }

    public HomePage userClicksOnLoginBtn() {
        getLoginBtn().click();
        return new HomePage();
    }

}
