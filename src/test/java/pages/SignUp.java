package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethod;
import utils.Handling;

public class SignUp extends ProjectSpecificationMethod {
	
	@FindBy(id="sign-username")
	WebElement SigninUsername;
	
	@FindBy(id="sign-password")
	WebElement SigninPassword;
	
	@FindBy(css="button[onclick='register()']")
	WebElement SignUp;
	
	

	public SignUp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public SignUp EnterUserName(String Name)
	{
		SigninUsername.sendKeys(Name);
		return this;
		
	}
	public SignUp EnterPassword(String Password)
	{
		SigninPassword.sendKeys(Password);
		return this;
		
	}

	public  HeaderPage signupClick() throws InterruptedException
	{
		SignUp.click();
		String actualText=Handling.handleAlert(driver, alert);
		if(actualText.equalsIgnoreCase("Sign up successful."))
		{
			System.out.println("successfully signup");
		}
		else if(actualText.equalsIgnoreCase("This user already exist."))
		{
			System.out.println("user already exist.");
		}
		else if(actualText.equalsIgnoreCase("Please fill out Username and Password."))
		{
			System.out.println("Please fill out Username and Password");
		}
		return new HeaderPage(driver);
	}
	
	}
	


