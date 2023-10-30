package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom_class.POM_Class;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logo_section 
{
WebDriver driver;
	
	@Given("Open app")
	public void Open_app() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        Thread.sleep(2000);
        
        driver.manage().window().maximize(); 
        driver.get("http://localhost:8501/");
        Thread.sleep(2000);
	}
	
	@When("user click on close button")
	public void user_click_on_close_button() throws InterruptedException
	{
	   //driver.findElement(By.xpath("//button[@kind='header']")).click();
		
		POM_Class pom= new POM_Class(driver);
		pom.getLogo().click();
	    Thread.sleep(2000);
	}

	@Then("logo section should be closed")
	public void logo_section_should_be_closed() 
	{
		System.out.println("Logo section closed");
	}

	@When("User click on right arrow button")
	public void user_click_on_right_arrow_button() throws InterruptedException 
	{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//button[@kind='headerNoPadding'])[2]")).click();
		
		POM_Class pom= new POM_Class(driver);
		pom.getArrow_bt().click();
	    
	}

	@Then("Logo section should Reappear")
	public void logo_section_should_be_displayed() 
	{
		System.out.println("Logo section re-appeared");
		driver.close();
	}
}
