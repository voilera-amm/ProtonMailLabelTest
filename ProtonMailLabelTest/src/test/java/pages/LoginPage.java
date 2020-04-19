package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {	
	
	WebDriver driver;
	By IDusername = By.id("username");
	By IDpassword = By.id("password");
	By IDSubmit   = By.id("login_btn");


	//Constructor to initialize object
	public LoginPage(WebDriver driver) {
	      this.driver = driver;
	}
	
	public void loginToSite(String Username, String Password) {
	      this.enterUsername(Username);
	      this.enterPasssword(Password);
	      this.clickSubmit();
	}
	public void enterUsername(String Username){
	      driver.findElement(IDusername).sendKeys(Username);
	}
	public void enterPasssword(String Password)
	{
	     driver.findElement(IDpassword).sendKeys(Password);
	}
	public void clickSubmit()
	{
	     driver.findElement(IDSubmit).click();
	}
}
	


