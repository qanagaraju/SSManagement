package appElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppSignUpObjects {
	
	
	@FindBy(linkText="Free Account Sign Up!")WebElement signup;
	public void clickSignup() {
		
			
		signup.click();
	}

}
