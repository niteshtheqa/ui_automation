package com.qa.automation.ui.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.qa.automation.ui.testcontext.TestContext;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.qa.automation.ui.Utils;

public class Base {

    TestContext testContext;
    public static Logger Logger = org.apache.log4j.Logger.getLogger(Base.class);

    public Base(TestContext testContext) {
        this.testContext = testContext;
        this.testContext.log4j = new Properties();
    }
        public void loadUtils() {
        try{
            // src/resources/log4j.properties
            String log4jFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
                    + "resources" + File.separator + "log4j.properties";
            FileInputStream fis = new FileInputStream(log4jFilePath);
            testContext.log4j.load(fis);
            PropertyConfigurator.configure(testContext.log4j);
            Logger.info("Logger initiated successfully...");
            testContext.utils = new Utils(this.testContext);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
