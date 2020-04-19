package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.Test;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.BrowserConfig;
import config.PropertiesFile;
import pages.LoginPage;
import pages.MailboxPage;
import util.CaptureScreenShot;
import pages.HomePage;
import pages.LabelPage;
import pages.AddNewLabelPage;



public class ExecuteTest {

	// variable declare, value in config.properties file
	public static String url = null;
	public static String username = null;
	public static String password = null;
	
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	 // Pages: Under this, classes are created for each page in the web application
	 LoginPage loginpage;
	 HomePage  homepage;
	 LabelPage labelpage;
	 AddNewLabelPage addNewlabel;
	 MailboxPage mailboxpage;
	
	 
	 
	 @BeforeSuite
	 public void setUpReport() {
			//start reporters
			htmlReporter = new ExtentHtmlReporter("extentReports.html");		
			// create ExtentReports and attach reporter(s)
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
	 
	 
	 
	 // browser parameter given via the testng.xml script
	 @BeforeTest
	 @Parameters ("browser")
     public void browserlaunch(String browser) throws Exception {
  		
		  System.out.println("Browser name is :"+browser);
  		 
		  // Getting value for  url, username and password
    	  PropertiesFile.getProperties();
    	  
    	  // configuration  Browser Setting and go to protonMailBetasite 
    	  driver = BrowserConfig.setupBrowser(browser,url);
    	  
    	  // adding a timeout for slow browser
    	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       	  
    	  // maximize screen size
    	  driver.manage().window().maximize();          
          
       	  loginpage = new LoginPage(driver);
          homepage = new HomePage(driver);  
          
          // Login in ProtonMail side and going under the page label
          loginpage.loginToSite(username, password);
          homepage.homepageSelectLabel();
          Thread.sleep(3000);
      }
	 
     
     @Test(priority=1)
     public void AddNewLabel () throws Exception {
    	 // creates a toggle for the given test, adds all log events under it    
         ExtentTest test1 = extent.createTest(" Add new Label ", "this is a test to create a new label");
         
         Thread.sleep(3000);
         labelpage = new LabelPage (driver);
    	 addNewlabel = new AddNewLabelPage (driver);
    	 
    	 String NewLabelName = ("label"+driver);
    	 
    	 labelpage.ClickAddLabelButton();
    	 
    	 Thread.sleep(3000);
    	 
    	 addNewlabel.AddLabelName(NewLabelName);
    	 addNewlabel.selectColorLabel();
    	 addNewlabel.clickSubmit();
    	 System.out.println("Add AddNewLabel :"+ NewLabelName);
    	 
    	// log with snapshot
         test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
         
    	 
    	 
     }
     @Test(priority=2)
     public void CancelAddNewLabel () throws Exception {
    	 
    	// creates a toggle for the given test, adds all log events under it    
         ExtentTest test2 = extent.createTest(" CancelAddNewLabel ", "this is a test to begin to create a new label but finally press cancel");
         
    	 Thread.sleep(3000);  		 
    	 labelpage = new LabelPage (driver);
    	 addNewlabel = new AddNewLabelPage (driver);
    	 
    	 labelpage.ClickAddLabelButton();
    	 Thread.sleep(3000);
    	 
    	 addNewlabel.AddLabelName("Label2");
    	 addNewlabel.selectColorLabel();
    	 addNewlabel.clickCancel();
    	 System.out.println("cancel select AddNewLabel ");
    	 
    	 // pass(details)
         test2.pass("Test2 : begin to create a new label but finnally press cancel was Successfull");
     }
     
     @Test(priority=3)
     public void ModifyLabel () throws Exception {
    	// creates a toggle for the given test, adds all log events under it    
         ExtentTest test3 = extent.createTest(" ModifyLabelName ", "this is a test to modify the label name");
    	 
         System.out.println("Modify Label ");
    	 driver.manage().timeouts().implicitlyWait(16,TimeUnit.SECONDS);
    	
    	 labelpage = new LabelPage (driver);
    	 addNewlabel = new AddNewLabelPage (driver);
    	 
    	 labelpage.editLabelLigne3(); 
    	 Thread.sleep(3000);
    	 
    	 addNewlabel.AddLabelName("Label0");
    	 addNewlabel.selectColorLabel();
    	 addNewlabel.clickSubmit();
    	 System.out.println("Modify Name ");
    	 driver.manage().timeouts().implicitlyWait(16,TimeUnit.SECONDS);
         
    	// pass(details)
         test3.pass("Test3 : Modify label name was Successfull");
  
         
     }
     
     
     @Test(priority=4)
     public void DeleteLabel () throws Exception {
    	 System.out.println("delete Label ");
    	
    	 // creates a toggle for the given test, adds all log events under it    
         ExtentTest test4 = extent.createTest(" DeleteLabelName ", "this is a test to delete a label name");
         
         driver.manage().timeouts().implicitlyWait(16,TimeUnit.SECONDS);
    	 
    	 labelpage = new LabelPage (driver);
    	 
    	 labelpage.deleteLabelLigne3();
    	 
    	 Thread.sleep(3000);
    	 System.out.println("Delete label");
    	// log with snapshot
         test4.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
    	 
     }
     @Test(priority=5)
     public void AssignLabelToEmail () throws Exception {
    	 ExtentTest test5 = extent.createTest(" AssignLabelToEmail ", "this is a test to assign a label to an email and remove it");
       	 Thread.sleep(3000);
    	 
    	 labelpage = new LabelPage (driver);
    	 mailboxpage = new MailboxPage (driver);
    	 
    	 labelpage.gotoMailbox();
    	 Thread.sleep(3000);
    	 mailboxpage.AssignLabelToEmail();
    	 test5.pass("Test5 : Assign a label to an email");
    	 
    	 Thread.sleep(4000);
    	 mailboxpage.RemoveAssignLabel();
    	 test5.pass("Test5 : Remove a label to an email");
    	    	 
     }
  
     @AfterTest
     public void closeBrowser() throws Exception	{
		mailboxpage = new MailboxPage (driver);
	 	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 	
	  	mailboxpage.logoutProtonMail2();
	 	
        driver.close();
	}   
	
     
     @AfterMethod
	@AfterSuite
     public void tearDown() {
		// calling flush writes everything to the log file
        extent.flush();
		
	}
} 
     
	
	
	

    	
    	
    	
    	
