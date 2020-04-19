package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LabelPage {
	
	WebDriver driver;
	By IDaddLabel  = By.xpath("//button[text()='Add label']");
	By IDeditLigne3 = By.xpath("//tr[3]//td[4]//div[1]//button[1]");
	By IDselectArrowLigne3 = By.xpath("//body/div/div/div/div/div/div/main/div/section/table/tbody/tr[3]/td[4]/div[1]/button[2]/span[1]//*[local-name()='svg']");
	By IDdeleteLigne3 = By.xpath("//div[10]//button[1]");
	By IDconfirmdelete = By.xpath("//button[contains(text(),'Confirm')]");
	By IDselectArrowUser = By.xpath("//span[@class='dropDown-logout-text center']");
	By IDLogout = By.xpath("//button[contains(text(),'Logout')]");
	By IDMailbox = By.xpath("//span[contains(text(),'Mailbox')]");
	//Constructor to initialize object
		public LabelPage (WebDriver driver) {
		      this.driver= driver;
		}
			
		public void ClickAddLabelButton (){
			System.out.println("enter ClickAddLabelSelection");
			driver.findElement(IDaddLabel).click();
		}
		
		public void editLabelLigne3 (){
			driver.findElement(IDeditLigne3).click();
		}
		
		public void deleteLabelLigne3 () throws Exception {
			driver.findElement(IDselectArrowLigne3).click();
			Thread.sleep(3000);
			driver.findElement(IDdeleteLigne3).click();
			driver.findElement(IDconfirmdelete).click();
			Thread.sleep(3000);
		}
		
		public void gotoMailbox () throws Exception {
			driver.findElement (IDMailbox).click();
			Thread.sleep(3000);
		}
				
		public void logoutProtonMail () throws Exception {
			driver.findElement(IDselectArrowUser).click();
			Thread.sleep(3000);
			driver.findElement(IDLogout).click();
		}
		
}
