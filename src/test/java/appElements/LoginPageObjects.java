package appElements;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Config.BrowserDriver;
import appUtils.ScreenCapture;

public class LoginPageObjects {
	
	
	@FindBy(name="user")WebElement username;
	public LoginPageObjects insertUserName(String un) throws IOException {
		username.sendKeys(un);
		//ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"username");
		return this;
		
	}
	
	
	@FindBy(name="pass")WebElement password;
	public LoginPageObjects insertPassword(String pw) throws IOException {
		password.sendKeys(pw);
		//ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"passwordscreen");
		return this;
	}
	
	@FindBy(name="btnSubmit")WebElement submit;
	@FindBy(id="right_col_top_err")WebElement errormessage;
	public LoginPageObjects clickSubmit() throws IOException {
		
		submit.click();
		// ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"Submit");
		try {
			
			if(errormessage.isDisplayed()) {
				System.out.println("Login Fail"+errormessage.getText());
			}
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return this;
	}
	
	@FindBy(linkText="Logout")WebElement logout;
	public LoginPageObjects clicklogout() throws IOException {
		
		try {
			
			if(logout.isEnabled()) {
				logout.click();
				System.out.println("Login success");
				// ScreenCapture.getScreenshot(BrowserDriver.getCurrentDriver(),"logout");
				Assert.assertTrue(true);
				
			}else
			{
				Assert.assertFalse(false);
			}
			
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		
		
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
}
