package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	By IDnotNowPopup  = By.xpath("//button[text()='Not now']");
	By IDfolderLabels = By.xpath("//span[@id='tour-label-settings']");
	
	//Constructor to initialize object
	public HomePage (WebDriver driver) {
	      this.driver= driver;
	}

	public void homepageSelectLabel() {
	      this.clickNotNow ();
	      this.clickLabel ();   
	}
	
	public void clickNotNow (){
		driver.findElement(IDnotNowPopup).click();
	}
	
	public void clickLabel (){
		driver.findElement(IDfolderLabels).click();
	
	}
}


