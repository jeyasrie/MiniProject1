package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HeaderPage;
import pages.HomePage;
import pages.ProductDetails;

public class TC_003CartTest extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup()
	{
		testName="cart functionality Test";
		testDescription="Testing the cart function";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}

	@Test
	public void pdoductfunctionality() throws InterruptedException
	{
		HeaderPage hp=new HeaderPage(driver);
		hp.ClickLogin()
		.EnterLoginUserName("Jeyasri")
		.EnterLoginPassword("Jeya123")
		.LoginButton();
		Thread.sleep(5000);
		HomePage hp1=new HomePage(driver);
		
		hp1.clickOnPhones();
		hp1.SelectPhones()
		.addproduct()
		.ClickHome();
		hp1.clickLaptop()
		.selectLaptop()
		.addproduct()
		.ClickHome();
		
	
		
	
		
		
		
	}
}