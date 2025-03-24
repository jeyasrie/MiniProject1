package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import utils.Handling;

public class PaymentPage extends ProjectSpecificationMethod {

	int total_productprice=0;
	
	 @FindBy(linkText = "Delete")
	    List<WebElement> delete;
	 
	 @FindBy(xpath = "//tr/td[3]")
	    List<WebElement> price;
	 @FindBy(xpath="//tr[1]/td[4]")
	 WebElement delete_First;
	 
	 @FindBy(id="totalp")
	 WebElement totalprice;
	 
	 @FindBy(xpath="//button[text()='Place Order']")
	 WebElement placeorder;

	
	@FindBy(id="name")
	WebElement Name;
	
	@FindBy(id="country")
	WebElement Country;
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="card")
	WebElement Card;
	
	@FindBy(id="month")
	WebElement Month;
	
	@FindBy(id="year")
	WebElement Year;
	 @FindBy(linkText ="Cart")
	    WebElement cart;
	 
	 
	@FindBy(xpath="//button[text()='Purchase']")
	WebElement Purchase;
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	WebElement ThankyouMessage;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement ConfirmButton;
	
	public PaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//click cart button
	 public PaymentPage clickOnCart() {
	    	cart.click();;
	        return this;
	    }
	 //remove the product from cart
	
	public PaymentPage remove_product()
	{ 
		 delete_First.click();
		 System.out.println("deleted successfully");
		 return this;
		}
	//get the product price
	public PaymentPage priceDtails()
	{
		Handling.explicitWait(driver, price.get(0));
		for(WebElement productprice:price)
		{
			int product = Integer.parseInt(productprice.getText());
			 total_productprice+=product;
			
          }
		 System.out.println("TotalproductPrice "+total_productprice);
	      return this;
	}
	//get the total price
	public PaymentPage actualtotal_price()
	{
		int actual_price=Integer.parseInt(totalprice.getText());
		System.out.println("Actual price :"+actual_price);
		return this;
	}
	
	public PaymentPage  ClinckOnPlaceOrder()
	{
		placeorder.click();
		return this;
	}
	
	//enter the value to the payment field
	public PaymentPage EnterName(String name,String country,String city, String card, String month, String year)
	{
		Name.sendKeys(name);
		Country.sendKeys(country);
		City.sendKeys(city);
		Card.sendKeys(card);
		Month.sendKeys(month);
		Year.sendKeys(year);
		Purchase.click();
		return this;
	}
	
//verify the payment field with positive and negative
		 public PaymentPage validatePayment(String Testtype,String expected)
			{
			 
				if (Testtype.equalsIgnoreCase("positive"))
				{
					String actualText="Thank you for your purchase!";
					Assert.assertEquals(actualText, expected);
					 ConfirmButton.click();				
				}
				else if(Testtype.equalsIgnoreCase("name  field empty"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					//Assert.assertEquals(actualText, expected);
					SoftAssert SAObj1=new SoftAssert();
					SAObj1.assertEquals(actualText, expected);
				    SAObj1.assertAll();
				    
					}
				else if(Testtype.equalsIgnoreCase("card field empty"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					SoftAssert SAObj2=new SoftAssert();
					SAObj2.assertEquals(actualText, expected);
				    SAObj2.assertAll();
				    
					}
				else if(Testtype.equalsIgnoreCase("all field empty"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					SoftAssert SAObj3=new SoftAssert();
					SAObj3.assertEquals(actualText, expected);
				    SAObj3.assertAll();
				    
					}
				
					return this;
	}
		/* public HeaderPage ClickConfirmbtn()
		 {
			 ConfirmButton.click();
			 return new HeaderPage(driver);
		 } */
		 
		 public String PurchaseCompleteMessage() {
		        Handling.explicitWait(driver, ThankyouMessage);
		        return ThankyouMessage.getText();
		    }

}
