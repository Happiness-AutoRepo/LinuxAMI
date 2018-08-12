package stepdefinitions;

import cucumber.api.java.en.Given;
import utilities.ConfigurationReader;
import utilities.Driver;

public class HomePageStepDefs {
	
	@Given("I go to the website")
	public void i_go_to_the_website() throws InterruptedException {
		
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		System.out.println(Driver.getInstance().getTitle());
	}

}
