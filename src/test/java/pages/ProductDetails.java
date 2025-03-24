package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;
import utils.Handling;

public class ProductDetails extends ProjectSpecificationMethod {

    @FindBy(className = "name")
    WebElement ProductName;

    @FindBy(xpath = "//a[text()='Home ']")
    WebElement home;

	@FindBy(className="btn-success")
	WebElement addtocartproduct;
	
	public ProductDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ProductDetails addproduct() {
		addtocartproduct.click();
		String actualText=Handling.handleAlert(driver, alert);
		Assert.assertEquals(actualText, "Product added.");
		return this;
	}
	 
    public HomePage ClickHome()
        {
    	home.click();
    	return new  HomePage(driver);
    	}
	
	  public String getProductTagName()
	  { 
		  return ProductName.getText();
	  }
	}

