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

public class SwotAnalysis 
{
	 WebDriver driver;
	    
		
		@Given("click on Swot Assesment radio button")
		public void click_on_Swot_Assesment_radio_button() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	        Thread.sleep(2000);
	        driver.manage().window().maximize();
	        driver.get("http://localhost:8501/");
	        Thread.sleep(2000);
		  //driver.findElement(By.xpath("//div/label[5]")).click();
	        
	        POM_Class pom= new POM_Class(driver);
	        pom.getswot_Rbt().click();
		  Thread.sleep(3000);
		}
		
		@When("Select a stock and click on submit button")
		public void Select_a_stock_and_click_on_submit_button() throws InterruptedException
		{
			//WebElement textfield = driver.findElement(By.xpath("//div[@data-baseweb='select']"));
			//Thread.sleep(2000);
			//textfield.click();
			Thread.sleep(2000);
			
			POM_Class pom = new POM_Class(driver);
			//pom.getStockTextfield().click();
			
			Actions act= new Actions(driver);
			  act.doubleClick(pom.getStockTextfield()).sendKeys("AMZN",Keys.ENTER).perform();
			  Thread.sleep(3000);
			  
		    //driver.findElement(By.xpath("//*[text()='Generate SWOT Analysis']")).click();
			  
			  pom.getswot_submit().click();
		    Thread.sleep(4000);
		}
		
		@Then("Results should be displayed")
		public void Results_should_be_displayed()
		{
			WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Strengths:')]"));
			String actual = text.getText();
			Assert.assertEquals("Strengths:", actual);
			
			WebElement t2 = driver.findElement(By.xpath("//span[contains(text(),'Weaknesses:')]"));
			String a2 = t2.getText();
			Assert.assertEquals("Weaknesses:", a2);
			
			WebElement t3 = driver.findElement(By.xpath("//span[contains(text(),'Opportunities:')]"));
			String a3 = t3.getText();
			Assert.assertEquals("Opportunities:", a3);
			
			WebElement t4 = driver.findElement(By.xpath("//span[contains(text(),'Threats:')]"));
			String a4 = t4.getText();
			Assert.assertEquals("Threats:", a4);
			driver.close();
		}
}
