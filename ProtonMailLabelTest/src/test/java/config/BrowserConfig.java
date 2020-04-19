package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig {
	
	static WebDriver driver;
	
	public static WebDriver setupBrowser (String browsername, String url) {
						
			
			System.out.println("Browser name is :"+browsername);
			
			if (browsername.equalsIgnoreCase("chrome") ) {

			    WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			else if (browsername.equalsIgnoreCase("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver =new FirefoxDriver();   
			}
			
			else if (browsername.equalsIgnoreCase("safari")) {
				driver=new SafariDriver();   		
			}
			
			else if (browsername.equalsIgnoreCase("ie")) {		
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();   
			}
			else if (browsername.equalsIgnoreCase("edgedriver")) {				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();   
			}
			
			driver.get(url);
			
			return driver;
			
		}
	

}
