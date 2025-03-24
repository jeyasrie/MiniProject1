 package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {

	public static  WebDriver driver; // remove static keyword for parallel execution
	public static Properties prop;
	public static String filepath;
	 protected Alert alert;
	 public WebDriverWait wait;
	 public  String sheetname;
	 public static ExtentReports extent;
		public static ExtentTest test;
		public String testName,testDescription,testCategory,testAuthor;
		
		
	public void  browser(String url,String browser)
	{
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
      else if (browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
}
		else 
		{
			driver=new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void Closebrowser()
	{
		driver.close();
	}
	
public static void readFromPropFile(String filepath) throws IOException {
		
		FileReader file = new FileReader(filepath);
		prop = new Properties();
		prop.load(file);
	}
public static String[][] readExcel(String sheetname) throws Exception {
	
	XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\srije\\eclipse-workspace\\DemoblazzProjects\\src\\test\\resources\\data\\DemoblazeProjectData.xlsx");
	XSSFSheet sheet = book.getSheet(sheetname);
	int rowcount = sheet.getLastRowNum();
	short columncount = sheet.getRow(0).getLastCellNum();
	
	String[][] data = new String[rowcount][columncount];
	for(int i = 1 ; i <= rowcount; i++) {
		
		XSSFRow row = sheet.getRow(i);
		
		for(int j = 0; j < columncount; j++) {
			
			
			XSSFCell cell = row.getCell(j);
			if(cell.getCellType()==CellType.BLANK)
			{
				data[i-1][j]="";
			}
			else
			{
			System.out.println(cell.getStringCellValue());
			data[i-1][j]=cell.getStringCellValue();
			}
		}
	}
	
	book.close();
	return data;
}
public static String screenshot(String name) throws IOException {
	
	String path="C:\\Users\\srije\\eclipse-workspace\\DemoblazzProjects\\src\\test\\resources\\Report\\Screenshot\\screenshot\\"+name+".png";
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File(path);
	FileUtils.copyFile(src, dest);
	return path;
}
public static WebElement explicitWait(WebDriver driver, WebElement ele)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	return wait.until(ExpectedConditions.visibilityOf(ele));
}

}