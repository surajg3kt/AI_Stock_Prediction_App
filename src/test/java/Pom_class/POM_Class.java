package Pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Class 
{
	 @FindBy(xpath="//button[@kind='header']")
	  private WebElement logo;
	 public WebElement getLogo()
	 {
	  return logo;	
	 }
	 
	 @FindBy(xpath = "(//button[@kind='headerNoPadding'])[2]")
	 private WebElement arrow_bt;
	 public WebElement getArrow_bt()
	 {
		 return arrow_bt;
	 }

	 @FindBy(xpath = "//div[text()='Financial Ratios']")
	 private WebElement FinancialRatio;
	 public WebElement getFinancialRatio()
	 {
		 return FinancialRatio;
	 }

	 @FindBy(xpath = "//div[@data-baseweb='select']")
	 private WebElement StockTextfield;
	 public WebElement getStockTextfield()
	 {
		 return StockTextfield;
	 }
	 
	 @FindBy(xpath = "//p[text()='Predict']")
	 private WebElement Submit_bt;
	 public WebElement getSubmit_bt()
	 {
		 return Submit_bt;
	 }
	 
	 @FindBy(xpath = "//div/label[5]")
	 private WebElement swot_Rbt;
	 public WebElement getswot_Rbt()
	 {
		 return swot_Rbt;
	 }
	 
	 @FindBy(xpath = "//*[text()='Generate SWOT Analysis']")
	 private WebElement swot_submit;
	 public WebElement getswot_submit()
	 {
		 return swot_submit;
	 }
	 
	 public POM_Class(WebDriver driver)
	 {
	 	PageFactory.initElements(driver, this);
	 }
}
