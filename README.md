# ProtonMail Label Test
> Test automation framework to test the label function of ProtonMail

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Framework](#framework)
* [TestCases](#testcases)
* [MultiplesBrowser](#multiplesbrowser)
* [Reporting](#reporting)
* [Status](#status)
* [Contact](#contact)


## General info
The framework used will be a page Object Framework.
Page-objects (or classes) are defined for each page, where a page contains the html locator information and also the methods that can operate on those page elements.


## Technologies
* Java
* Eclipse (Maven, TestNG)
* Selenium WebDriver


## Framework
Object Framework : 4 Package create under on maven project

Config: Under this, we put the codes that need to be called again and again in our test cases like Browser launch, PropertiesFile. The user can add more classes under it based on the project need.
Pages: Under this, classes are created for each page in the web application and can add more page classes based on the number of pages in the application.
Test cases: Under this, we write the login test case and can add more test cases as required to test the whole application.
Util: Under this, we write the codes on screenshot and ExtendReport section.


## TestCases

  * Test1 : this is a test to create a new label (AddNewLabel)
  * Test2 : this is a test to begin to create a new label but finally press cancel (CancelAddNewLabel)
  * Test3 : this is a test to modify the label name  (ModifyLabelName)
  * Test4 : this is a test to delete a label name (DeleteLabel)
  * Test5 : this is a test to assign a label to an email and remove it (AssignLabelToEmail)


## MultiplesBrowser 

All this test can be run through different browser via a parameter add in the testNG file.


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite" >
 
   <test  name="Test chrome">
   		<parameter name="browser" value="chrome"></parameter>
   		<classes>
     	<class name="testCases.ExecuteTest"/>
   		 </classes>
   </test>
    <test  name="Test firefox ">
   		<parameter name="browser" value="firefox"></parameter>
    	<classes>
      	<class name="testCases.ExecuteTest"/>
    	</classes>
    </test>
   	<test  name="Test safari ">
   		<parameter name="browser" value="safari"></parameter>
    	<classes>
      	<class name="testCases.ExecuteTest"/>
    	</classes>
    </test> 
</suite> 



## Reporting

Two reports available after running the test, one with testNG ( ProtonMailLabelTest/test-output/index.html) and one with extent Reports  (ProtonMailLabelTest/extentReports.html#!).
Some ScreenShot can also be lookk in theScreenShot folder


## Status

Project is: in progress
Missing : handle Headless browser and  the handle of the exception and retry test


## Contact
Created by Agnes.menthon@wanadoo.fr
