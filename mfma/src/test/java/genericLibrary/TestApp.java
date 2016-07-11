package genericLibrary;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = {"mfma.features"},glue={"mfma.stepdefinitions"},plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {"@testfeature,@testfeature1"})

public class TestApp extends AbstractTestNGCucumberTests
{	
	
}
