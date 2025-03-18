package com.pages;

import java.util.Random;

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

import Utility.ExcelHelper;

public class Quotes_Validations extends BasePage {

	public Quotes_Validations(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");

	By Customers = By.xpath("(//span[normalize-space()='Customers'])[1]");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	By SelectCustmer = By.xpath("//input[@ng-model='data.selectedCustomer']");
	By CustomerOk = By.xpath("//button[text()='OK']");
	By ProductCategory = By.xpath("(//md-select[@id='CRMProductCategory'])[1]");
	By AccidentLOB = By.xpath("(//md-option[@value='Medical'])[2]"); 
	By ContactInfo = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");
	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By SalesButton  = By.xpath("//a[@id='menu_Sales']");
	By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");
	By OpportunityQuote = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By OpportunityEffectiveDate = By.xpath("//input[@name='EffectiveDate']");
	By OptZipCode = By.xpath("//input[@name='Zip']");
	By OPtStatus = By.xpath("//md-select[@name='CRMNewQuoteStatus']");
	By OptSubStaus = By.xpath("//md-option[@value='Created']");
	By Optsubmit = By.xpath("(//button[@class='btn btn-default green'])[3]"); 
	By Optqualify = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[3]");
	By Optsubmit2 = By.xpath("//button[text()='Submit']");
	By Success_msg = By.xpath("//div[@id='divSuccesss']");
	By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");

	By PrincipalAdress = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
	By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By SalesOpportunities =By.xpath("//a[@id='submenu_salesopportunities']");
	By Customerdropdown = By.xpath("//a[@id='menu_customers']");

	By Quotes = By.xpath("//a[@id='submenu_salesquotes']");
	By Census = By.xpath("//md-tab-item[@role='tab']//span[@class='ng-scope'][normalize-space()='Census']");
	By Customerinfo = By.xpath("//a[normalize-space()='Customer Information']");
	By Gender = By.xpath("(//*[@id='LeadGender'])[1]");
	By SSN = By.xpath("(//input[@name='Ssn'])[1]");
	By Edit_icon = By.xpath("//i[contains(@class,'btn fa fa-pencil')]");
	By search = By.xpath("//input[@type='search'][@aria-label='Search your text']");
	By Recent_Quotes = By.xpath("//div[@id='filter-by']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//i[1]");
	By CreatedToday = By.xpath("//md-radio-button[@aria-label='Created Today']//div[@class='md-off']");
	By Reset = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
	By save = By.xpath("//button[normalize-space()='Save']");
	By plan_name = By.xpath("//input[@type='text'][@name='BusinessPackageId']");
	By original_rate = By.xpath("//input[@type='text'][@name='TotalPremium']");
	By premium_amount = By.xpath("//input[@type='text'][@name='TotalResAmount']");
	
	

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public String employerName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	public String randomName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public static String generatessnNumber() {
		Random rand = new Random();
		String SSN_num = "7"; 
		for (int i = 0; i < 9; i++)
		{
			SSN_num += rand.nextInt(10); 
		}
		return SSN_num;
	}



	public void validate_Quote_details() throws InterruptedException
	{
		waitForElement(2000);
		waitVisibility(Customers);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");

		waitForElement(5000);
		waitVisibility(NewCustomer);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		Thread.sleep(3000);
		String First_name = "Rohith";
		String Last_name = randomName();
		waitVisibility(CustFName);
		writeText(CustFName,First_name);
		waitForElement(4000);
		writeText(CustLName,Last_name);	
		String Full_Name  = First_name+ " " + Last_name;
		waitForElement(6000);
		By dob = By.xpath("(//input[@id='LeadDob'])[1]");
		String Dob = "12/12/2001";
		writeText(dob, Dob +Keys.ENTER); 
		waitForElement(2000);
//
//		String ssn = generatessnNumber();
//		writeText(SSN,ssn);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);			
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000);
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String Mail = "lohi."+generateNumber()+"@yopmail.com";
		writeText(CustMail,Mail);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);
		String Zipcode = "33233";
		writeText(PrincipalZipCode, Zipcode);
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(2000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on Submit");	
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
		waitForElement(5000);	 
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(4000);
		waitVisibility(CustcreateOpp);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New opportunity has been created and validated the success message");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(4000);
		waitVisibility(CustcreateOpp);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(4000);
		waitVisibility(OpportunityQuote);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(6000);
		String Effectivedate = "12/12/2024";
		writeText(OpportunityEffectiveDate, Effectivedate + Keys.ENTER);
		waitForElement(5000);
		writeText(OptZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Quote has been created");			

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(1000);
		waitVisibility(Quotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotes));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Lead has been clicked");
		waitForElement(6000);
		By name = By.xpath("//a[normalize-space()='"+Full_Name+"']");
		waitVisibility(name);
		Assert.assertTrue(driver.findElement(name).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		By email = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+Mail+"']");
		waitVisibility(email);
		Assert.assertTrue(driver.findElement(email).isDisplayed());
		ExtentSuccessMessage("Mail Assertion has been done");
		waitForElement(2000);

		//By Dob_cust = By.xpath("//div[@title='"+Dob+"']");
		//Assert.assertTrue(driver.findElement(Dob_cust).isDisplayed());
		//ExtentSuccessMessage("DOB Assertion has been done");			
		waitForElement(2000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerinfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customerinformation Tab has been clicked");
		waitForElement(5000);
		By cust_name = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+Full_Name+"']");
		waitVisibility(cust_name);
		Assert.assertTrue(driver.findElement(cust_name).isDisplayed());
		ExtentSuccessMessage("Name Assertion has been done");		

		waitForElement(2000);
//		Assert.assertTrue(driver.findElement(DOB).isDisplayed());
//		ExtentSuccessMessage("DOB Assertion has been done");			
		Assert.assertTrue(driver.findElement(email).isDisplayed());
		ExtentSuccessMessage("Emai Assertion has been done");
	}
	
	public void Edit_Quote_Details() throws InterruptedException 
	{
		waitForElement(2000);
		waitVisibility(Customers);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(5000);
		waitVisibility(NewCustomer);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		waitForElement(2000);
		String First_name = "Rohith";
		String Last_name = randomName();
		waitVisibility(CustFName);
		writeText(CustFName,First_name);
		waitForElement(2000);
		writeText(CustLName,Last_name);	
		String Full_Name  = First_name+ " " + Last_name;
//		By dob = By.xpath("(//input[@id='LeadDob'])[1]");
//		String Dob = "12/12/2001";
//		writeText(dob, Dob +Keys.ENTER); 
//		waitForElement(2000);
//		String ssn = generatessnNumber();
//		writeText(SSN,ssn);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);			
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000);
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String Mail = "lohi."+generateNumber()+"@yopmail.com";
		writeText(CustMail,Mail);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);
		String Zipcode = "33233";
		writeText(PrincipalZipCode, Zipcode);
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(2000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on Submit");	
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
		waitForElement(5000);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(2000);
		waitVisibility(CustcreateOpp);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New opportunity has been created and validated the success message");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(3000);
		waitVisibility(SalesOpportunities);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Search Icon  Clicked");	
		waitForElement(3000);
		By records = By.xpath("//a[@title='"+Full_Name+"']");
		waitVisibility(records);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(3000);
		waitVisibility(OpportunityQuote);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(4000);
		String Effectivedate = "12/12/2024";
		waitVisibility(OpportunityEffectiveDate);
		writeText(OpportunityEffectiveDate, Effectivedate + Keys.ENTER);
		waitForElement(3000);
		writeText(OptZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the status");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Quote has been created");			

		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitVisibility(Quotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotes));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Search Icon  Clicked");	
		waitForElement(3000);
		By record = By.xpath("//a[@title='"+Full_Name+"']");
		waitVisibility(record);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Lead has been clicked");
		waitForElement(8000);
		By name = By.xpath("//a[normalize-space()='"+Full_Name+"']");
		waitVisibility(name);
		Assert.assertTrue(driver.findElement(name).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		By email = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+Mail+"']");
		waitForElement(2000);
		waitVisibility(email);
		Assert.assertTrue(driver.findElement(email).isDisplayed());
		ExtentSuccessMessage("Mail Assertion has been done");
//		waitForElement(2000);
//		By DOB = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+Dob+"']");
//		Assert.assertTrue(driver.findElement(DOB).isDisplayed());
//		ExtentSuccessMessage("DOB Assertion has been done");
		
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit_icon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Edit Icon has been clicked");
		waitForElement(5000);
		String effectivedate = "10/10/2024";
		clear(OpportunityEffectiveDate);
		writeText(OpportunityEffectiveDate, effectivedate + Keys.ENTER);
		ExtentSuccessMessage("Entered the Effectivedate");
		String Planname = "MedicalPlan"; 
		writeText(plan_name, Planname);
		ExtentSuccessMessage("Entered the Plan Name");
		String Originalrate = "500"; 
		writeText(original_rate, Originalrate);
		ExtentSuccessMessage("Entered the Originalrate");
		String Premiumamount = "300"; 
		writeText(premium_amount , Premiumamount);
		ExtentSuccessMessage("Entered the Premiumamount");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(save));
		MoveToElementClick(element);
		ExtentSuccessMessage("Save Button has been clicked");
		waitForElement(5000);
		By Neweffectivedate = By.xpath("//span[normalize-space()='"+effectivedate+"']");
		Assert.assertTrue(driver.findElement(Neweffectivedate).isDisplayed());
		ExtentSuccessMessage("Neweffectivedate Assertion has been done");
		waitForElement(2000);
		By Plan_name = By.xpath("//span[normalize-space()='"+Planname+"']");
		Assert.assertTrue(driver.findElement(Plan_name).isDisplayed());
		ExtentSuccessMessage("Plan name Assertion has been done");
		By Original_rate = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='$"+Originalrate+".00']");
		Assert.assertTrue(driver.findElement(Original_rate).isDisplayed());
		ExtentSuccessMessage("Original rate Assertion has been done");
		By Premium_amount = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='$"+Premiumamount+".00']");
		Assert.assertTrue(driver.findElement(Premium_amount).isDisplayed());
		ExtentSuccessMessage("Premium Amount Assertion has been done");
	}
	
	public void Reset_filter() throws InterruptedException 
	{
		waitForElement(2000);
		waitVisibility(Customers);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(2000);
		waitVisibility(NewCustomer);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		Thread.sleep(2000);
		ExtentSuccessMessage("Clicked on New Customers");
		String First_name = "Rohith";
		String Last_name = randomName();
		waitVisibility(CustFName);
		writeText(CustFName,First_name);
		waitForElement(3000);
		writeText(CustLName,Last_name);	
		String Full_Name  = First_name+ " " + Last_name;
		//waitForElement(2000);
//		By dob = By.xpath("(//input[@id='LeadDob'])[1]");
//		String Dob = "12/12/2001";
//		writeText(dob, Dob +Keys.ENTER); 
		waitForElement(2000);
//		String ssn = generatessnNumber();
//		writeText(SSN,ssn);
		waitForElement(2000);
		String ssn = generatessnNumber(); 
		writeText(SSN,ssn);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);			
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000);
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String Mail = "lohi."+generateNumber()+"@yopmail.com";
		writeText(CustMail,Mail);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);
		String Zipcode = "33233";
		writeText(PrincipalZipCode, Zipcode);
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(2000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Clicked on Submit");	
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
		waitForElement(5000);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(2000);
		waitVisibility(CustcreateOpp);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New opportunity has been created and validated the success message");

		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitVisibility(SalesOpportunities);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(2000);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(2000);
		waitVisibility(OpportunityQuote);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(4000);
		String Effectivedate = "12/12/2024";
		waitVisibility(OpportunityEffectiveDate);
		writeText(OpportunityEffectiveDate, Effectivedate + Keys.ENTER);
		waitForElement(3000);
		writeText(OptZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
		MoveToElementClick(element);
		waitForElement(5000);
		waitVisibility(OptSubStaus);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the status");
		waitForElement(6000);
		waitVisibility(Optsubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Quote has been created");			

		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Button Clicked");			
		waitVisibility(Quotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Quotes Button Clicked");	
		waitForElement(5000);
		waitVisibility(Recent_Quotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Recent_Quotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Recent Quotes Clicked");	
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Created Today Button  Clicked");	
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Search Icon  Clicked");	
		waitForElement(3000);
		By records = By.xpath("//a[@title='"+Full_Name+"']");
		waitVisibility(records);
		Assert.assertTrue(driver.findElement(records).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Reset));
		MoveToElementClick(element);
		ExtentSuccessMessage("Reset Button  Clicked");	
		waitForElement(8000);
		waitVisibility(Recent_Quotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Recent_Quotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Recent Quotes Clicked");	
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		Assert.assertFalse(element.isSelected());
		ExtentSuccessMessage("Assertion has been done for Reset filters"); 
	}
		
	public void Search_records() throws InterruptedException 
	{
		waitForElement(2000);
		waitVisibility(Customers);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(5000);
		waitVisibility(NewCustomer);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		String First_name = "Rohith";
		String Last_name = randomName();
		waitVisibility(CustFName);
		writeText(CustFName,First_name);
		ExtentSuccessMessage("Entered First Name");
		waitForElement(2000);
		writeText(CustLName,Last_name);	
		ExtentSuccessMessage("Entered Last Name");
		String Full_Name  = First_name+ " " + Last_name;
		//waitForElement(6000);
//		By dob = By.xpath("(//input[@id='LeadDob'])[1]");
//		String Dob = "12/12/2001";
//		writeText(dob, Dob +Keys.ENTER); 
//		waitForElement(2000);
//		String ssn = generatessnNumber();
//		writeText(SSN,ssn);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);			
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000);
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String Mail = "lohi."+generateNumber()+"@yopmail.com";
		writeText(CustMail,Mail);
		ExtentSuccessMessage("Entered Mail");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);
		String Zipcode = "33233";
		writeText(PrincipalZipCode, Zipcode);
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(2000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Clicked on Submit");	
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

		waitForElement(5000);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(3000);
		waitVisibility(CustcreateOpp);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New opportunity has been created and validated the success message");

		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitVisibility(SalesOpportunities);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(4000);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(2000);
		waitVisibility(OpportunityQuote);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(4000);
		String Effectivedate = "12/12/2024";
		waitVisibility(OpportunityEffectiveDate);
		writeText(OpportunityEffectiveDate, Effectivedate + Keys.ENTER);
		waitForElement(3000);
		writeText(OptZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
		MoveToElementClick(element);
		waitForElement(4000);
		waitVisibility(OptSubStaus);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the status");
		waitForElement(5000);
		waitVisibility(Optsubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Quote has been created");			

		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Button");
		waitVisibility(Quotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes Button");
		waitForElement(3000);
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(18000);
		By records = By.xpath("//a[@title='"+Full_Name+"']");
		waitVisibility(records);
		Assert.assertTrue(driver.findElement(records).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
	}

}
