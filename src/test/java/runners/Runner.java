package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin={"html:target/cucumber-report", "json:target/cucumber.json"},
		features = "src/test/resources/features",
		glue = "stepdefinitions"
		)
public class Runner extends AbstractTestNGCucumberTests {
	
}
