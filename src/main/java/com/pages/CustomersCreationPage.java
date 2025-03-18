package com.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Utility.ExcelHelper;

public class CustomersCreationPage extends BasePage {
	public CustomersCreationPage(WebDriver driver) {
		super(driver);}
 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");
		
        By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
        By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
        By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
        By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
        By ContactInfo = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
        By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
        By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
        By ClickLead = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
        By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
        By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
        By Opportunities = By.xpath("//a[@role='tab'][normalize-space()='Opportunities']");
        By Edit_icon = By.xpath("//i[@class='fa fa-pencil white']");
        By submit_btn = By.xpath("//button[normalize-space()='Save']");
        By Dob  = By.xpath("(//*[@id='LeadDob'])[1]");
 
		By SalesButton  = By.xpath("//span[text()='Sales ']");
		By Leads = By.xpath("(//a[text()='Leads'])[2]");
		By NewLead =By.xpath("//button[@name='newLeadBtn' and @id='newLeadBtn'] ");
        By NewLeadFirstName = By.xpath("//input[@id='LeadFirstName']");
		By NewLeadLastName =By.xpath("//input[@id='LeadLastName']");
		By DOB = By.xpath("//input[@id='Dob']");
		By Gender = By.xpath("//label[text()='Gender ']");
		By Male = By.xpath("//div[text()='Male']");
		By Phnum = By.xpath("//input[@name='LeadMobile']");
		By LeadInformation = By.xpath("//div[@id='formFlag2']");
		By Submit = By.xpath("(//button[text()='Submit'])[7]");
		
		By LeadQualify = By.xpath("//button[@id='Qualify']");
		By Submit_btn = By.xpath("//button[@id='formSubmitBtn']");
		By convert = By.xpath("//i[@class='fa fa-refresh yellow']");
		By customers = By.xpath("//a[@id='menu_customers']");
		
		
        
		public void waitForElement(int time) throws InterruptedException {
			Thread.sleep(time);
		}
		
		public String randomName() {
			String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String ssn = "";
			String temp = RandomStringUtils.random(10, allowedChars);
			ssn = temp.substring(0, temp.length() - 5);
			return ssn;
		}
		
		public void validateCustomerdetails() throws InterruptedException 
		{	
			waitForElement(5000);			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
			MoveToElementClick(element);
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
			MoveToElementClick(element);
			ExtentSuccessMessage("Sales Lead has been clicked");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
			MoveToElementClick(element);
			waitForElement(8000);
			ExtentSuccessMessage("Clicked on NewLead");
			String First_name = "Automation";
			String Last_name = randomName();
			String Full_Name  = First_name+ " " + Last_name;
			writeText(NewLeadFirstName,First_name);
			writeText(NewLeadLastName,  Last_name);
			waitForElement(3000);
			writeText(Phnum,generatePhoneNumber());
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");
			try {
				if  (driver.findElement(element2).isDisplayed()) {
					click(element2);
					
				}
			} catch (NoSuchElementException e) {
			}
			catch (Exception e) {
				ExtentSuccessMessage("Lead Created");
			}
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(8000);
			click(LeadQualify);
			ExtentSuccessMessage("Clicked on Qualify");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(convert));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on convert button");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(customers));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on customers menu");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(3000);
			By name= By.xpath("//span[contains(text(),'"+Full_Name+"')]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(name));
			String Full_name  = element.getText();
			ExtentSuccessMessage("-----------"+ Full_name +"------------");
			Assert.assertEquals(Full_Name, Full_name);
			ExtentSuccessMessage("Assertion has been done");

		}
		
		public void validate_opportunity_records() throws InterruptedException 
		{	
			waitForElement(5000);			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
			MoveToElementClick(element);
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
			MoveToElementClick(element);
			ExtentSuccessMessage("Sales Lead has been clicked");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
			MoveToElementClick(element);
			waitForElement(8000);
			ExtentSuccessMessage("Clicked on NewLead");
			String First_name = "Automation";
			String Last_name = randomName();
			String Full_Name  = First_name+ " " + Last_name;
			writeText(NewLeadFirstName,First_name);
			writeText(NewLeadLastName,  Last_name);
			waitForElement(3000);
			writeText(Phnum,generatePhoneNumber());
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");
			try {
				if  (driver.findElement(element2).isDisplayed()) {
					click(element2);
					
				}
			} catch (NoSuchElementException e) {
			}
			catch (Exception e) {
				ExtentSuccessMessage("Lead Created");
			}
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(10000);
			click(LeadQualify);
			ExtentSuccessMessage("Clicked on Qualify");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(convert));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on convert button");
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(customers));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on customers menu");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(3000);
			By name= By.xpath("//span[contains(text(),'"+Full_Name+"')]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(name));
			String Full_name  = element.getText();
			ExtentSuccessMessage("-----------"+ Full_name +"------------");
			Assert.assertEquals(Full_Name, Full_name);
			ExtentSuccessMessage("Assertion has been done");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on create opportunity");
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on submit");
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Opportunities));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Opportunities");
			waitForElement(2000);
			List<WebElement> links = driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']"));
			if(links!=null) {
				System.out.println(links.size());
				for(int i=0; i< links.size(); i++)
				{
					ExtentSuccessMessage(links.get(i).getText());
				}
			}
		}		
		
		public void validate_Edit_Customer_details() throws InterruptedException 
		{	
			waitForElement(3000);			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
			MoveToElementClick(element);
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
			MoveToElementClick(element);
			ExtentSuccessMessage("Sales Lead has been clicked");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
			MoveToElementClick(element);
			waitForElement(8000);
			ExtentSuccessMessage("Clicked on NewLead");
			String First_name = "Automation";
			String Last_name = randomName();
			String Full_Name  = First_name+ " " + Last_name;
			writeText(NewLeadFirstName,First_name);
			writeText(NewLeadLastName,  Last_name);
			waitForElement(3000);
			writeText(Phnum,generatePhoneNumber());
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");
			try {
				if  (driver.findElement(element2).isDisplayed()) {
					click(element2);
					
				}
			} catch (NoSuchElementException e) {
			}
			catch (Exception e) {
				ExtentSuccessMessage("Lead Created");
			}
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(8000);
			click(LeadQualify);
			ExtentSuccessMessage("Clicked on Qualify");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(convert));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on convert button");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Submit button");
			waitForElement(5000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(customers));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on customers menu");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(3000);
			By name= By.xpath("//span[contains(text(),'"+Full_Name+"')]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(name));
			String Full_name  = element.getText();
			ExtentSuccessMessage("-----------"+ Full_name +"------------");
			Assert.assertEquals(Full_Name, Full_name);
			ExtentSuccessMessage("Assertion has been done");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit_icon));
			MoveToElementClick(element);
			waitForElement(6000);
			String New_Fname = "Test";
			String New_Lname = randomName();
			clear(CustFName);
			writeText(CustFName,New_Fname);
			waitForElement(2000);
			clear(CustLName);
			writeText(CustLName,New_Lname);		
			waitForElement(2000);
			waitForElement(2000);	
			String DOB = "02051995";
			writeText(Dob, DOB + Keys.TAB);
			waitForElement(2000);	
			element = wait.until(ExpectedConditions.presenceOfElementLocated(submit_btn));
			MoveToElementClick(element);
			waitForElement(3000);
			String Fullname = New_Fname + " " + New_Lname;
			System.out.println(Fullname);
			By Name= By.xpath("//span[contains(text(),'"+Fullname+"')]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Name));
			String FullName  = element.getText();
			ExtentSuccessMessage("-----------"+ FullName +"------------");
			Assert.assertEquals(Fullname, FullName);
			ExtentSuccessMessage("Assertion has been done");
		}
}


