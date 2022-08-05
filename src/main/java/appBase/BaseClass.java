package appBase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.BrowserDriver;
import Config.BrowserFactory;
import appUtils.PropertyLoader;
import appUtils.ScreenCapture;

public class BaseClass {
	
	static String datename = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	//public BrowserFactory browser;
	public  WebDriver driver;
	public  PropertyLoader prop;
	
	public static ExtentHtmlReporter htmlReporter;
	//public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ScreenCapture capture;
	
	@BeforeSuite
	public void setupSuite() {
		
	//	browser = new BrowserFactory();
		prop = new PropertyLoader();
		
		capture = new ScreenCapture();
		
		htmlReporter = new ExtentHtmlReporter("Reports//extent-report.html");
		extent = new ExtentReports();
		//htmlReporter = new ExtentSparkReporter("Reports/index.html");
		
		extent.attachReporter(htmlReporter);
		
		
	}
	
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException  {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName()+datename+"  Test Case Failed", ExtentColor.RED));
			
			test.fail(result.getThrowable());
			
			String temp = ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver());
			test.fail(result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
			
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			
			String temp = ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver());
			
			test.pass(result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
			test.pass(MarkupHelper.createLabel(result.getName()+datename+"  Test Case Passed", ExtentColor.GREEN));
			test.pass("finished");
			
			
		} else
		{
			test.skip(MarkupHelper.createLabel(result.getName()+"  Test Case Skipped", ExtentColor.YELLOW));
			test.fail(result.getThrowable());
		}
		
	}
	
	
	
	@BeforeTest
	public void startBrowser() {
		
		//driver = browser.getBrowser(prop.getbrowsername(), prop.getappurl());
		BrowserDriver.getCurrentDriver(prop.getbrowsername()).get(prop.getappurl());
	
	}
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	
	
	@AfterTest
	public void closeTest() {
		BrowserDriver.getCurrentDriver().close();
	}
	
	
	
	
	

}
