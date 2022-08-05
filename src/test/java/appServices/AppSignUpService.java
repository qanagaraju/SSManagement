package appServices;

import org.openqa.selenium.support.PageFactory;

import Config.BrowserDriver;
import appElements.AppSignUpObjects;

public class AppSignUpService  {
	
	static AppSignUpObjects signuppage;
	
	
	public void verifySignup() {
		
		
		
		signuppage = PageFactory.initElements(BrowserDriver.getCurrentDriver(), AppSignUpObjects.class);
		signuppage.clickSignup();
		
	}

}
