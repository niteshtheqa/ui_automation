package com.qa.automation.ui.testcontext;

import com.qa.automation.ui.Utils;
import com.qa.automation.ui.base.Base;
import org.openqa.selenium.WebDriver;

import com.qa.automation.ui.base.TestBase;
import com.qa.automation.ui.pages.CartPage;
import com.qa.automation.ui.pages.HomePage;
import com.qa.automation.ui.pages.LoginPage;
import com.qa.automation.ui.services.Services;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.util.Properties;


@Getter
@Setter
public class TestContext {

    public String browser = null;
    public String baseURL = null;
    public WebDriver driver = null;
    public Services services = null;
    public TestBase testBase = null;
    public FileInputStream fileInputStream;
    public Properties log4j ;
    public Properties prop;

    public Base base;

    public Utils utils =null;

    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;

    
    
 
    
}
