package appServices;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Config.BrowserDriver;
import appBase.BaseClass;
import appElements.LoginPageObjects;

public class LoginService extends BaseClass  {
	
	//static WebDriver driver;
	static LoginPageObjects loginpage;
	
	
	
	
	@Test(priority=0,description="Valid Login Test")
	public void verifyValidLogin() throws IOException {
		
		test = extent.createTest("Valid Login Test");
		
		loginpage = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPageObjects.class);
		loginpage.insertUserName(prop.getusername()).insertPassword(prop.getpassword()).clickSubmit().clicklogout();
		
		
		
	}
	
	@Test(priority=1,description="InValid Login Test")
	public void verifyInvalidLogin() throws IOException {
		
		test = extent.createTest("InValid Login Test");
		loginpage = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPageObjects.class);
		loginpage.insertUserName(prop.getusername()).insertPassword(prop.getInvalidpassword()).clickSubmit();
		
	}
	
	
	
	
	

}
