package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Selenium_Project_Files\\AI_StockPrediction_App\\src\\test\\resources\\features",
glue = "stepDefinition",
plugin = {"pretty","html:test-output"},
monochrome = true
)
public class AI_STock_Runner 
{
	
}
