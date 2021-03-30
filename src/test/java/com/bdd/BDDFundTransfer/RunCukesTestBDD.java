package com.bdd.BDDFundTransfer;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
        features = "src/test/resources",
        glue = "com.bdd",
        tags = {"@dev", "~@bug"})
public class RunCukesTestBDD extends AbstractTestNGCucumberTests {
}
