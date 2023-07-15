package com.qa.automation.ui.base;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.automation.ui.testcontext.TestContext;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase  {

    TestContext testContext;

    public static org.apache.log4j.Logger Logger = org.apache.log4j.Logger.getLogger(TestBase.class);
    public TestBase(TestContext testContext) {

        this.testContext = testContext;
        this.testContext.setBase(new Base(this.testContext));

    }


    public void initializeDriver() throws FileNotFoundException {
        testContext.base.loadUtils();
        Logger.info("Initializing driver...", null);

        testContext.setBrowser(testContext.utils.getConfig("browser"));

        if (testContext.getBrowser().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            testContext.driver = new ChromeDriver();
        } else {
            Logger.error("Browser not selected...");
        }
    }

    public void launchApplication() throws FileNotFoundException {
        new TestBase(this.testContext).initializeDriver();
        testContext.setBaseURL(testContext.utils.getConfig("app_url"));
        testContext.driver.get(testContext.utils.getConfig("app_url"));
        testContext.driver.manage().window().maximize();
        testContext.driver.manage().deleteAllCookies();
        testContext.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

@After
    public void tearDown() {
        testContext.driver.close();
    }
}
