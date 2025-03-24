package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import utils.Handling;


public class HomePage extends ProjectSpecificationMethod {



	
	 @FindBy(linkText = "CATEGORIES")
	    WebElement categories;

	    @FindBy(linkText="Phones")
	    WebElement phones;

	    @FindBy(linkText="Laptops")
	    WebElement laptops;

	    @FindBy(linkText="Monitors")
	    WebElement monitors;

	    @FindBy(linkText="Samsung galaxy s6")
	    WebElement Samsunggalaxys6;

	    @FindBy(linkText ="Sony vaio i7")
	    WebElement sonyvaioi7;

	    @FindBy(linkText = "ASUS Full HD")
	    WebElement ASUSFullHD;

	    @FindBy(id = "next2")
	    WebElement nextpage;

	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	
	}
	   public HomePage clickOnCategories() {
	        categories.click();
	        return this;
	    }

	    public HomePage clickOnPhones() {
	    	
	        phones.click();
	   return new HomePage (driver);
	       
	    }
	  public ProductDetails SelectPhones() {
	    	Samsunggalaxys6.click();
	        return new  ProductDetails(driver);
	    }
	    public HomePage clickLaptop()
	    {
	    	laptops.click();
	    	return this;
	    }
	    
	   public ProductDetails selectLaptop() {
		   sonyvaioi7.click();
	        return new  ProductDetails(driver);
	    }
    
	      public HomePage clickMonitor()
	      {
	    	  monitors.click();
	    	  return this;
	      }
	
	    public ProductDetails selectMonitors() {
	        
	        ASUSFullHD.click();
	        return new  ProductDetails(driver);
	    }
	    public boolean SamsungGalaxyS6Exists() {
	       Handling.explicitWait(driver, Samsunggalaxys6);
	        return Samsunggalaxys6.isDisplayed();
	    }
	    

		public boolean  sonyvaio_i7Exists() {
			 Handling.explicitWait(driver, sonyvaioi7);
	        return  sonyvaioi7.isDisplayed();
	    }

	    public boolean ASUSFullHDExists() {
	    	Handling.explicitWait(driver, ASUSFullHD );
	        return ASUSFullHD.isDisplayed();
	    }

	  
	 
}
