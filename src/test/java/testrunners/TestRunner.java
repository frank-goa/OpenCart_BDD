package testrunners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectFile("src/test/resources/features/login.feature")
@ConfigurationParameter(key = "cucumber.glue", value = "stepdefinitions,hooks")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty,html:reports/myreport.html,com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
@ConfigurationParameter(key = "cucumber.publish", value = "true")
@ConfigurationParameter(key = "cucumber.monochrome", value = "true")
@ConfigurationParameter(key = "cucumber.dry-run", value = "false")
public class TestRunner {
}