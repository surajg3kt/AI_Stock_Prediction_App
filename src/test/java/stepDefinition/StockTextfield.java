package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StockTextfield 
{
	public WebDriver driver;
	@Given("Open the AI Stock Application")
	public void open_the_ai_stock_application() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("http://localhost:8501/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/label[5]")).click();     //Label[1,2,3,4,5]- changes for different modules
		Thread.sleep(3000);
	}

	@When("^user selects stocks as (.+) and clicks on predict button$")
	public void user_selects_stock_as(String stock) throws InterruptedException 
	{
		WebElement Stock_dropdown = driver.findElement(By.xpath("//div[@data-baseweb='select']"));
		Thread.sleep(2000);
		Actions A = new Actions(driver);

		A.moveToElement(Stock_dropdown).doubleClick().sendKeys(stock,Keys.ENTER).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Generate SWOT Analysis']")).click();
		
		//driver.findElement(By.xpath("//p[text()='Submit']")).click();      //Submit button-xpath
		//driver.findElement(By.xpath("//p[text()='Predict']")).click();   //Predict button-xpath 
		Thread.sleep(3000);
		
		driver.close();
		
	}
	
	@Then("Result should be display")
	public void Result_should_be_display()
	{
		System.out.println("Stock fetched succesfully");
		
	}
	

	/* @When("user selects stocks as AMZN")
	public void user_selects_stocks_as_amzn() 
	{
	    
	}
    
	@When("user selects stocks as GOOG")
	public void user_selects_stocks_as_goog() 
	{
	    
	}
	
	@When("user selects stocks as META")
	public void user_selects_stocks_as_meta() 
	{
	    
	}
    
	@When("user selects stocks as TSLA")
	public void user_selects_stocks_as_tsla() 
	{
	    
	}  */
}
