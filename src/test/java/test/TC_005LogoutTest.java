package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HeaderPage;

public class TC_005LogoutTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup()
	{
		testName="Logout Test";
		testDescription="Testing the logout page";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}
	@Test
	public void logoutfunction() throws InterruptedException
	{
		HeaderPage hp=new HeaderPage(driver);
		hp.ClickLogin()
		.EnterLoginUserName("Jeyasri")
		.EnterLoginPassword("Jeya123")
		.LoginButton();
		Thread.sleep(5000);
		//HeaderPage hp1=new HeaderPage(driver);
		hp.clickOnLogout();
	}
	
	

}
