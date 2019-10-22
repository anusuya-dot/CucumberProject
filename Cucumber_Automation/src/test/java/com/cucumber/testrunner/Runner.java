package com.cucumber.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.cucumber.stepDef" }, plugin = {
"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/WikipediaResult.html" })

@Test
public class Runner extends AbstractTestNGCucumberTests {

	public static String filePathdir = System.getProperty("user.dir");

	@AfterClass
	public void setup() {

		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows");
		Reporter.setTestRunnerOutput("Sample test runner output message");

	}

}
