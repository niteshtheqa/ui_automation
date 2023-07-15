package com.qa.automation.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.automation.ui.testcontext.TestContext;
import org.apache.log4j.Logger;

public class Utils {
    public static Logger logger = Logger.getLogger(Utils.class);
    TestContext testContext;

    private String configFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "resources" + File.separator + "config.properties";

    public Utils(TestContext testContext) {
        this.testContext = testContext;
        try {
            testContext.prop = new Properties();
            testContext.fileInputStream = new FileInputStream(configFilePath);
        } catch (FileNotFoundException e) {
            logger.error(configFilePath + "  :not found", e.getCause());
        }
    }

    public String getConfig(String key) {
        try {
            testContext.prop.load(testContext.fileInputStream);
        } catch (IOException e) {
            logger.error(configFilePath + " not found", e.getCause());
        }
        return testContext.prop.getProperty(key);
    }
}
