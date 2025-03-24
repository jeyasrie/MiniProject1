package test;

import java.io.IOException;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;

import pages.HeaderPage;


public class Tc_002LoginTest extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup()
	{
		sheetname="logindata";
		testName="Login Test";
		testDescription="Testing the login functionality with positive and negative cases";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing"; 
	}
	
	
	
	@Test(dataProvider="readdata")
	public void login(String name,String password,String testType,String Expected) 
	{
		HeaderPage hp=new HeaderPage(driver);
		hp.ClickLogin()
		.EnterLoginUserName(name)
		.EnterLoginPassword(password)
		.LoginButton()
		.validateLogin(testType, Expected);
	
		
	
	
		
		
		
		
		
		

		
		
		
		


		
		
		
		
		
		

		
		
	
		

	    
	
	    
		
		
		
	}
}
