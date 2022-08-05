
	
	package appUtils;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	public class PropertyLoader {
		
		public static File file = new File("src\\test\\resources\\appFiles\\login.properties");
		public Properties prop;
		
		public PropertyLoader() {
			
			
	try {
				
				FileInputStream fis = new FileInputStream(file);
				 prop = new Properties();
				prop.load(fis);
				
				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException s) {
				s.printStackTrace();
			}finally {
				
				if(file.exists()) {
					System.out.println("File connected successfully");
				}else
				{
					System.out.println("Does not connected");
				}
				
			}
			
		}
		
		
//Methods for properties
		public String getbrowsername() {
			return prop.getProperty("browsername");
		}
		
		public String getappurl() {
			return prop.getProperty("appurl");
		}
		
		
		public String getusername() {
			return prop.getProperty("username");
		}
		
		public String getpassword() {
			return prop.getProperty("password");
		}
		
		
		public String getInvalidpassword() {
			return prop.getProperty("invalidpassword");
		}
		
		
		
		
		
		
		
		
}
