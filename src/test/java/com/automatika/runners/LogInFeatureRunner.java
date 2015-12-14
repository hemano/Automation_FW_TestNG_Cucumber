package com.automatika.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/LogIn.feature",
glue = "com.automatika.glue",
format = {"pretty"})
public class LogInFeatureRunner extends AbstractTestNGCucumberTests {
}
