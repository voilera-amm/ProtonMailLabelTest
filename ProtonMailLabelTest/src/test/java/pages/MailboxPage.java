package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailboxPage {
	
	WebDriver driver;
	By IDSecondEmail  = By.xpath("//body/div/div/div/div/div/div/div/section/div[2]/div[1]");
	By IDLabelLogo = By.xpath("//body/div/div/div/div/div/nav/div[4]/div[1]/div[1]/button[1]");
	By IDCheckFirstlabel = By.xpath("//div[@id='tour-label-dropdown']//div//div//form//ul//li//label//div//span");
	By IDApply = By.xpath("//div[@id='tour-label-dropdown']//div//div//button[contains(text(),'Apply')]");
	By IDselectArrowUser = By.xpath("//body[@id='secured-inbox-element']/div[@id='body']/div/div/header/div/div/ul/li[@id='tour-support']/div/button[1]");
	By IDLogout = By.xpath("//a[contains(text(),'Logout')]");
	
	//Constructor to initialize object
	public MailboxPage (WebDriver driver) {
	      this.driver= driver;
	}

	public void AssignLabelToEmail() {
          this.selectSecondEmail ();  
	      this.clickOnlabelLogo ();
	      this.selectLabeltoAssign ();
	      this.applyButton ();
	}
	
	public void RemoveAssignLabel() {
		this.selectSecondEmail (); 
		this.clickOnlabelLogo ();
		this.selectLabeltoAssign ();
		this.applyButton ();
	}
	
	public void clickOnlabelLogo (){
		driver.findElement(IDLabelLogo).click();
	}
	
	public void selectSecondEmail (){
		driver.findElement(IDSecondEmail).click();
	}
	
	public void selectLabeltoAssign () {
		driver.findElement (IDCheckFirstlabel).click();	
	}
	
	public void applyButton () {
		driver.findElement (IDApply).click();	
	}
	
	public void logoutProtonMail2 () throws Exception {
		driver.findElement(IDselectArrowUser).click();
		Thread.sleep(3000);
		driver.findElement(IDLogout).click();
	}
	
}
		
	
	


