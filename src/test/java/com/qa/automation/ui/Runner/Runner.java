package com.qa.automation.ui.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/qa/automation/ui/Feature", // Specify the path to your feature files
                glue = "com.qa.automation.ui.StepDefs", // Specify the package where your step definitions
                                                                      // are located
                tags = "@smoke", // Specify the tags for the scenarios to be executed
                plugin = { "pretty", "html:target/cucumber-reports" }, 
                dryRun = false// Specify the reporting format and
                                                                                    // output directory
)
public class Runner {

}
