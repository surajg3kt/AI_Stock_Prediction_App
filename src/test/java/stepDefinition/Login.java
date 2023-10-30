package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login 
{
WebDriver driver;
	
	@Given("Open the browser")
	public void open_the_browser() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
	}

	@When("enter the test url")
	public void enter_the_test_url() 
	{
		driver.get("http://localhost:8501/");
	}

	@Then("homepage should be displayed")
	public void homepage_should_be_displayed() 
	{
		String exp_title="app · Streamlit";
		String logtit = driver.getTitle();
		System.out.println(logtit);
		
	 if(logtit.equals(exp_title))
	 {
		System.out.println("true");
	 }
	 else 
	 {
		System.out.println("false");
	 }
		driver.close();
	}
}
