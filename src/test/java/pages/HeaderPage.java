package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import utils.Handling;

public class HeaderPage extends ProjectSpecificationMethod {
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
}

	   @FindBy(className ="navbar-brand")
	    WebElement logo_image;

	    @FindBy(xpath = "//a[text()='Home ']")
	    WebElement home;

	    @FindBy(linkText ="Contact")
	    WebElement contact;

	    @FindBy(linkText ="About us")
	    WebElement aboutus;

	   
	   
		
		@FindBy(id="login2")
		WebElement loginbutton;
		
		@FindBy(linkText="Welcome Jeyasri")
		WebElement welcomeuser;
	   

	    

	    @FindBy(linkText = "Sign up")
	    WebElement signupbutton;

	    @FindBy(linkText = "Log out")
	    WebElement logout;

	   
	    
	    public HomePage ClickHome()
            {
	    	home.click();
	    	return new  HomePage(driver);
	    	}
	    public SignUp ClickSignUP()
		{
			signupbutton.click();
			return new SignUp(driver);
		}
		public Login ClickLogin()
		{
			loginbutton.click();
			return new Login(driver);
		}
	   

	    public HeaderPage clickOnLogout() {
	    	logout.click();
	    	return this;
	    }

	   

	    public boolean isWelcomeUserDisplayed() {
	       Handling.explicitWait(driver, welcomeuser);
	        return welcomeuser.isDisplayed();
	    }
	  //Loginvalidation with positive test case and negative test case
		 public HeaderPage validateLogin(String Testtype,String expected)
			{
				if (Testtype.equalsIgnoreCase("valid user valid password"))
				{
					
					WebElement ele=Handling.explicitWait(driver, welcomeuser);
							
					String actualText=ele.getText();
					//hard asserstion
					Assert.assertEquals(actualText, expected);
				}
				else if(Testtype.equalsIgnoreCase("valid user Invalid password"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					SoftAssert SAObj=new SoftAssert();
					SAObj.assertEquals(actualText, expected);
				    SAObj.assertAll();
					}
				else if(Testtype.equalsIgnoreCase("Invalid user valid password"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					SoftAssert SAObj=new SoftAssert();
					SAObj.assertEquals(actualText, expected);
				    SAObj.assertAll();
					}
				else if(Testtype.equalsIgnoreCase("invalid user Invalid password"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					SoftAssert SAObj=new SoftAssert();
					SAObj.assertEquals(actualText, expected);
				    SAObj.assertAll();
					}
			else if(Testtype.equalsIgnoreCase("login with empty field"))
				{
			
					String actualText=Handling.handleAlert(driver, alert);
					SoftAssert SAObj=new SoftAssert();
					SAObj.assertEquals(actualText, expected);
				    SAObj.assertAll();
					} 
					
				
				return this;
			}

}
