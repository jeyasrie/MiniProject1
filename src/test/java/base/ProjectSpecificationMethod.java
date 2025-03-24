package base;





import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility{
	
	@BeforeSuite
	public void reportIniatialization() {
		
	// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\srije\\eclipse-workspace\\DemoblazzProjects\\src\\test\\resources\\Report\\Demoblazz.html");
		reporter.config().setReportName("Demoblazz report");
		
		// to capture the test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	} 
	
	@BeforeClass
	public void testDetails() {
		
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);

	} 
	
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void launchingbrowserandloadingURL(String url,String browser) {
		browser(url,browser);
	}
	
	public void closeBrowser() {
		Closebrowser();
	}
	@DataProvider(name="readdata")
	public String[][] readExcelData() throws Exception
	
	{
		String[][]data=readExcel(sheetname);
		return data;
	}
	@AfterSuite
	public void reportClose() {
		
		extent.flush();  // mandatory to close the report
	} 
	
}
