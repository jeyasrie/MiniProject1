package test;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HeaderPage;
import pages.HomePage;

public class TC_001SignupTest extends ProjectSpecificationMethod {

	@BeforeSuite
public void setup() throws IOException {
	filepath="C:\\Users\\srije\\eclipse-workspace\\DemoblazzProjects\\src\\test\\resources\\data\\Signupdata.properties";
	readFromPropFile(filepath);
		testName="Logout Test";
		testDescription="Testing the signup page with positive and negative testcase";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}

	
	@Test(priority=1)
	public void RegisterTest() throws InterruptedException {
	HeaderPage head=new HeaderPage(driver);

	 head.ClickSignUP()
	.EnterUserName(prop.getProperty("name"))
	.EnterPassword(prop.getProperty("password"))
	.signupClick();
 }
	@Test(priority=2)
	public void existinguser() throws InterruptedException
	{
		HeaderPage head1=new HeaderPage(driver);
		head1.ClickSignUP()
		.EnterUserName(prop.getProperty("ename"))
		.EnterPassword(prop.getProperty("epassword"))
		.signupClick();
	}
	@Test(priority=3)
	public void  Emptyfield() throws InterruptedException
	{
		HeaderPage head2=new HeaderPage(driver);
				head2.ClickSignUP()
				.EnterUserName(prop.getProperty("emname"))
				.EnterPassword(prop.getProperty("empassword"))
				.signupClick();
	}
	
	}
