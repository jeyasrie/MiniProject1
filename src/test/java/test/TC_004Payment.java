package test;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HeaderPage;
import pages.HomePage;
import pages.PaymentPage;

public class TC_004Payment extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup()
	{
		sheetname="Payment";
		testName="payment Test";
		testDescription="Testing the payment functionality with positive and negative cases";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing"; 
}
	@Test(dataProvider="readdata")
	public void PurchasePayment(String name,String pwd,String CustomerName,String CusCountry,String CusCity,String crditCard,String Cardmonth,String CardYear,String testtype,String ExpectedResult) throws InterruptedException
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
		
		
		PaymentPage pp=new PaymentPage(driver);
		pp.clickOnCart();
		pp.remove_product();
		pp.actualtotal_price();
		pp.priceDtails();
		pp.ClinckOnPlaceOrder();
		pp.EnterName(CustomerName, CusCountry, CusCity, crditCard, Cardmonth, CardYear);
		pp.validatePayment(testtype, ExpectedResult);
	//	pp.ClickConfirmbtn();
	
		
	}
}
