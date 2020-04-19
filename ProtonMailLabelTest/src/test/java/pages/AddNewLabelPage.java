package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewLabelPage {
	
	WebDriver driver;
	String LabelName = null;
	
	By IDaddLabel  = By.xpath("//button[text()='Add label']");
	By IDName  = By.xpath("//input[@id='accountName']");
	By IDcolor = By.xpath("//li[@class='ColorSelector-item selected']//input[@name='paletteColor']");
	By IDButtonCancel = By.xpath("//button[contains(text(),'Cancel')]");
	By IDButtonSubmit = By.xpath("//button[contains(text(),'Submit')]");
	
	//Constructor to initialize object
		public AddNewLabelPage (WebDriver driver ) {		  
		      this.driver= driver;   
		}
		public void AddNewLabel (String LabelName) {
			this.ClickAddLabelButton();
		    this.AddLabelName(LabelName);
		    this.selectColorLabel ();
		    this.clickSubmit();
		
		System.out.println("enter AddNewLabelPage, New Label Name"+LabelName);
		}
		
		
		
		public void ClickAddLabelButton (){
			
			driver.findElement(IDaddLabel).click();
		}
		
		public void AddLabelName (String LabelName){
			
			driver.findElement(IDName).click();
			driver.findElement(IDName).clear();
			driver.findElement(IDName).sendKeys(LabelName);
			System.out.println("Label Name ajouter: "+LabelName);
		}
		public void selectColorLabel (){
			driver.findElement(IDcolor).click();
			System.out.println("color Label Name ajouter ");
		}
		public void clickSubmit() {
		    driver.findElement(IDButtonSubmit).click();
		}
		                
		public void clickCancel () {
			driver.findElement(IDButtonCancel).click();
		
		}

}
