package appUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {
	
	
	static WebDriver driver;
	
	public static String getScreenshot(WebDriver driver) throws IOException {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File file = element.getScreenshotAs(OutputType.FILE);
		
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		File dest = new File("./appScreens/"+datename+".png");
		
		String destpath = dest.getAbsolutePath();
		
		
		try {
			
			FileUtils.copyFile(file, dest);
			
		}catch(IOException e) {
			System.out.println("capture image"+e.getMessage());
		}
			
			
		return destpath;
		
		
		//byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destpath));
		
		
		//return Base64.getEncoder().encodeToString(imageBytes);
		
		
		
		
	}
	
	

}
