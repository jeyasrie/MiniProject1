package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;
import utils.Handling;

public class Login extends ProjectSpecificationMethod {
	
	@FindBy(id="loginusername")
	WebElement logUsername;
	
	@FindBy(id="loginpassword")
	WebElement logPassword;
	
	@FindBy(css="button[onclick='logIn()']")
	WebElement loginButton;
	
	
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public Login  EnterLoginUserName(String Name)
	{
		logUsername.sendKeys(Name);
		return this;
		}
	
	public Login EnterLoginPassword(String pwd)
	{
		logPassword.sendKeys(pwd);
		return this;
	}
 public HeaderPage LoginButton()
 {
	 loginButton.click();
	 return new HeaderPage(driver);
 }

}
