package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepdefinitions"
		)
public class Runner extends AbstractTestNGCucumberTests {
	
}
