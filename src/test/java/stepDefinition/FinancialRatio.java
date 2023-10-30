package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pom_class.POM_Class;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FinancialRatio
{
WebDriver driver;
	
	@Given("Open the app")
	public void Open_the_app() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize(); 
        driver.get("http://localhost:8501/");
        Thread.sleep(2000);
	}
	
	@Given("Click on Financial Ratios radio button")
	public void click_on_financial_ratios_radio_button() throws InterruptedException 
	{
		POM_Class pom= new POM_Class(driver);
		pom.getFinancialRatio().click();
	}

	@When("Select one stock")
	public void select_one_stock_() throws InterruptedException 
	{	
	  POM_Class pom= new POM_Class(driver);
	  pom.getStockTextfield().click();
	  Thread.sleep(2000);
	  Actions act= new Actions(driver);
	  act.doubleClick(pom.getStockTextfield()).sendKeys("AMZN",Keys.ENTER).perform();
	  Thread.sleep(3000);
	}
	
	@Then("Selected stock should display below textfield")
	public void Selected_stock_should_display_below_textfield()
	{
		WebElement confirm_text = driver.findElement(By.xpath("//p[text()='The stock name is AMZN']"));
		String stock_confirm_text = confirm_text.getText();
		Assert.assertEquals("The stock name is AMZN",stock_confirm_text);
	}
	
	@When("Click on submit button")
	public void Click_on_submit_button() throws InterruptedException 
	{
		//driver.findElement(By.xpath("//p[text()='Predict']")).click();
		
		POM_Class pom= new POM_Class(driver);
		pom.getSubmit_bt().click();
		  Thread.sleep(9000);
	}
	
	@Then("Relative Result should be displayed")
	public void relative_result_should_be_displayed() 
	{
	    
	    WebElement Heading1 = driver.findElement(By.xpath("//span[text()='Historical Stock Price']"));
	    String Result_heading1 = Heading1.getText();
	    Assert.assertEquals("Historical Stock Price",Result_heading1 );
	    
	    WebElement Heading2 = driver.findElement(By.xpath("//span[text()='Financial Ratios']"));
	    String Result_heading2 = Heading2.getText();
	    Assert.assertEquals("Financial Ratios",Result_heading2 );
	     
	     
	    WebElement Heading3 = driver.findElement(By.xpath("//span[text()='Stock Prediction Results']"));
		String Result_heading3 = Heading3.getText();
		Assert.assertEquals("Stock Prediction Results",Result_heading3 );
		
		driver.close();
	}
}
