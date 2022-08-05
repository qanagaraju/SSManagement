package appServices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.BrowserDriver;
import appUtils.PropertyLoader;
import appUtils.ScreenCapture;

public class SampleAssert {
	
	
public  PropertyLoader prop;
	static WebDriver driver;
	public  ScreenCapture screen;
	
	public static ExtentHtmlReporter htmlReporter;
	//public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	
	
	@BeforeSuite
	public void setupSuite() {
		
	//	browser = new BrowserFactory();
		prop = new PropertyLoader();
		screen = new ScreenCapture();
		
		htmlReporter = new ExtentHtmlReporter("Reports//extent-report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
  @BeforeTest
  public void f() {
	  
	  BrowserDriver.getCurrentDriver(prop.getbrowsername()).get(prop.getappurl());
	  
  }
  
  //TestReports
  //console report,html report,Assertion,Screen capture,Extent reports with screen shot
  
  @Test
  public void verifyLogin() throws InterruptedException, IOException {
	  
	 
	  test = extent.createTest("Login Test Report");
	  
	  
	  BrowserDriver.getCurrentDriver().findElement(By.name("user")).sendKeys("qatrainer");
	 // ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"username");
	  test.log(Status.INFO, "verify username");
	  
	  BrowserDriver.getCurrentDriver().findElement(By.name("pass")).sendKeys("admin123");
	  //ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"passwordscreen");
	  test.log(Status.INFO, "verify password");
	  
	  BrowserDriver.getCurrentDriver().findElement(By.name("btnSubmit")).click();
	//  ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"Submit");
	  test.log(Status.INFO, "verify submit");
	  Thread.sleep(3000);
	  
	  BrowserDriver.getCurrentDriver().findElement(By.linkText("Logout")).click();
	 // ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"logout");
	  test.log(Status.INFO, "verify logout");
	  BrowserDriver.getCurrentDriver().close();
	  
	  
	  
  }
  
  @AfterMethod
  public void GenerateReport() {
	  extent.flush();
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
  
}
