package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import Utility.ExcelHelper;

public class Policy_Validations extends BasePage {

	public Policy_Validations(WebDriver driver) {
		super(driver);
	}

	public String AgentText;
	public String NoteText;

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


	By policies = By.xpath("//a[@id='submenu_salespolicies']");
	By createpolicy = By.xpath("//button[@class='btn btn-default pull-left btn-yellow']");
	By cstname_search = By.xpath("//button[@ng-click=\"$parent.customerSearchLookup('CustomerName', 'CreateAssetCustomer')\"]//i[@class='glyphicon glyphicon-search']");
	By customername = By.xpath("//input[@ng-model='searchText'][@type='text'][@aria-invalid='false']");
	By search_icon = By.xpath("//button[@title='Search Customer']//i[@class='glyphicon glyphicon-search']");
	By select_cust = By.xpath("(//input[@name='selCustomer'][@type='radio'])[1]");
	By Ok_btn = By.xpath("//button[normalize-space()='OK']");
	By ProductCategory = By.xpath("(//md-select[@id='CRMProductCategory'])[2]");
	By selectMedical = By.xpath("(//md-option[@value='Medical'])[3]"); 
	By carriers = By.xpath("(//md-select[@id='Carrier'])[1]");
	By selectcarrier = By.xpath("(//md-option[@value='NLG'])[2]|(//md-option[@value='Humana'])[2]|(//md-option[@value='Aetna'])[2]");
	By salestype = By.xpath("(//md-select[@id='salesType'])[1]");
	By salesnew = By.xpath("(//md-option[@value='New'])[2]");
	By policystatus = By.xpath("(//md-select[@id='AssetStatus'])[1]");
	By policyactive = By.xpath("(//div[@class='md-text'][normalize-space()='Active'])[4]");
	By effectivedate = By.xpath("(//input[@id='EffectiveDate'])[1]");
	By AORname = By.xpath("//button[@ng-click=\"$parent.aorSearchLookup('AgentName', 'CreateAssetForm')\"]//i[@class='glyphicon glyphicon-search']");
	By searchagent = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name'][@type='button']");
	By SelectAOR = By.xpath("(//input[@name='selectedAgent'])[1]");
	By submit = By.xpath("//button[@ng-show=\"customerInformationFormData.BusinessSegment && customerInformationFormData.BusinessSegment !=='Group'\"]");

	By Edit_icon = By.xpath("//i[contains(@class,'btn fa fa-pencil')]");
	By search = By.xpath("//input[@type='search'][@aria-label='Search your text']");
	By save = By.xpath("//button[normalize-space()='Save']");
	By plan_name = By.xpath("//input[@type='text'][@name='BusinessPackageId']");
	By original_rate = By.xpath("//input[@type='text'][@name='TotalPremium']");
	By premium_amount = By.xpath("//input[@type='text'][@name='TotalResAmount']");
	By Save_btn = By.xpath("//button[@ng-disabled='editFormObject.AssetForm.$invalid']");


	private By Agencymodule = By.xpath("//a[@id='menu_Agency']");
	private By AgentTab = By.xpath("//a[@id='submenu_agencyagents']");
	private By AddAgent = By.id("createNewAgentBtn");
	private By FirstName = By.name("FirstName");//*[@id='input_566']//parent::md-input-container
	private By LastName = By.name("LastName");
	private By AgencyTypeDropdown = By.name("AgencyType");
	private By LicenceNumber = By.name("StateLicenseNumber");
	private By Phonenumber = By.name("Phone");
	private By Agentsubmitbtn = By.id("saveAgentdetailsButton");
	private By Email = By.name("Email");
	private By Agentcontactinfo = By.xpath("(//h5[text()='Agent Contact Information']//parent::div//i)[1]");
	private By AgentStatus = By.xpath("(//md-select[@name='Status'])[3]");
	private By AgentStatusOption = By.xpath("(//md-option[@value='Active'])[3]");


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

	public static boolean ElementDisplayed(By locator) throws InterruptedException {

		Boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = element.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (flag) {
			ExtentSuccessMessage("Successfully System able to found the element :" + locator);
			return flag;
		} else {
			ExtentSuccessMessage("System not able to found the element :" + locator);
			flag = false;
		}
		return flag;
	}

	public String writenameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;  
		int columnIndex = 6;
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(columnIndex);
		cell.setCellValue(nameText);  
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		return null;		
	}

	public void ClickOnAgentTab() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(Agencymodule)) {
			ExtentSuccessMessage("Successfully user able to See 'AgentTab ' ");
			click(Agencymodule);
			waitForElement(1000);
			click(AgentTab);
			ExtentSuccessMessage("Successfully user Clicked on 'AgentTab' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'AgentTab ' Not visible");
		}
	}

	public void ClickOnAddAgent() throws InterruptedException {
		Thread.sleep(2000);
		click(AddAgent);
		ExtentSuccessMessage("Successfully user Clicked on 'AddAgent' ");
		Thread.sleep(5000);
	}
	public void EnterFirstName(String value) throws InterruptedException {		
		if (ElementDisplayed(FirstName)) {
			ExtentSuccessMessage("Successfully user able to See 'FirstName ' ");
			writeText(FirstName,value+Keys.ENTER);
			ExtentSuccessMessage("Successfully user entered the 'FirstName in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'FirstName' Not visible");
		}
	}
	public void EnterLastName(String value) throws InterruptedException {		
		if (ElementDisplayed(LastName)) {
			ExtentSuccessMessage("Successfully user able to See 'LastName ' ");
			writeText(LastName,value+Keys.ENTER);
			ExtentSuccessMessage("Successfully user entered the 'LastName in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'LastName' Not visible");
		}
	}

	public void EnterLicenceNumber(String value) throws InterruptedException {		
		if (ElementDisplayed(LicenceNumber)) {
			ExtentSuccessMessage("Successfully user able to See 'LicenceNumber ' ");
			writeText(LicenceNumber,value);
			ExtentSuccessMessage("Successfully user entered the 'LicenceNumber in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'LicenceNumber' Not visible");
		}
	}
	public void EnterPhonenumber(String value) throws InterruptedException {		
		if (ElementDisplayed(Phonenumber)) {
			ExtentSuccessMessage("Successfully user able to See 'Phonenumber ' ");
			writeText(Phonenumber,value);
			ExtentSuccessMessage("Successfully user entered the 'Phonenumber in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Phonenumber' Not visible");
		}
	}
	public void EnterEmail(String value) throws InterruptedException {		
		if (ElementDisplayed(Email)) {
			ExtentSuccessMessage("Successfully user able to See 'Email ' ");
			writeText(Email,value);
			ExtentSuccessMessage("Successfully user entered the 'Email in text field' "+value);
		} else {
			ExtentErrorMessage("Unsuccessfully 'Email' Not visible");
		}
	}

	public void ClickOnAgentcontactinfo() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(Agentcontactinfo)) {
			ExtentSuccessMessage("Successfully user able to See 'Agentcontactinfo ' ");
			click(Agentcontactinfo);
			ExtentSuccessMessage("Successfully user Clicked on 'Agentcontactinfo' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Agentcontactinfo ' Not visible");
		}
	}
	public void ClickOnAgentsubmitbtn() throws InterruptedException {
		Thread.sleep(3000);
		if (ElementDisplayed(Agentsubmitbtn)) {
			ExtentSuccessMessage("Successfully user able to See 'Agentsubmitbtn ' ");
			click(Agentsubmitbtn);
			ExtentSuccessMessage("Successfully user Clicked on 'Agentsubmitbtn' ");
		} else {
			ExtentErrorMessage("Unsuccessfully 'Agentsubmitbtn ' Not visible");
		}
	}


	public void SelectActiveDropdown (By by, String value) throws InterruptedException {

		if(ElementDisplayed(by)) {

			click(by);

			By options = By.xpath("//*[contains(@class,'dropDown md-active md-clickable')]//*[@value='"+value+"']");

			if(ElementDisplayed(options)) {

				click(options);

				ExtentSuccessMessage("Successfully user found and clicked on the "+value+" value inside the dropdown ");

			}

		}else {

			ExtentErrorMessage("UnSuccessfully user not found and clicked on the "+value+" value inside the dropdown ");

		}

	}


	public String CreateAgent() throws InterruptedException, AWTException {
		waitForElement(8000);
		ClickOnAddAgent();
		String FirstName ="First"+randomName();
		EnterFirstName(FirstName);
		String LastName ="AutomationQA"+randomName();
		EnterLastName(LastName);
		String Fullname=FirstName+" "+LastName;
		SelectActiveDropdown(AgencyTypeDropdown,"Agent");
		String LicenceNo = "76"+generatePhoneNumber();
		EnterLicenceNumber(LicenceNo);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatus));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentStatusOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency type has been selected");
		ClickOnAgentcontactinfo();
		String phonenumbe = generatePhoneNumber();
		EnterPhonenumber(phonenumbe);
		String email =FirstName+LastName+"@yopmail.com";
		EnterEmail(email);
		ClickOnAgentsubmitbtn();		
		System.out.println("Fullname:- "+Fullname);
		return Fullname;
	}


	public void validate_Policy_details() throws InterruptedException, AWTException
	{
		waitForElement(4000);
		waitVisibility(Customers);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
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
//		waitForElement(6000);
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
		waitForElement(3000);
		String ph_no = generatePhoneNumber();
		writeText(Cellphone,ph_no);
		waitForElement(3000);
		String Mail = "CEuser."+generateNumber()+"@yopmail.com";
		writeText(CustMail,Mail);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(3000);
		String Zipcode = "33233";
		writeText(PrincipalZipCode, Zipcode);
		waitForElement(3000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(3000);	 
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
		waitForElement(3000);
		waitVisibility(CustcreateOpp);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(8000);
		waitVisibility(CustOppSubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New opportunity has been created and validated the success message");

		ExtentSuccessMessage("Agent Creation");
		waitForElement(8000);
		ClickOnAgentTab();	
		CreateAgent();		

		waitForElement(3000);
		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(5000);
		waitVisibility(OpportunityQuote);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(5000);
		String Effectivedate = "12/12/2024";
		waitVisibility(OpportunityEffectiveDate);
		writeText(OpportunityEffectiveDate, Effectivedate + Keys.ENTER);
		waitForElement(4000);
		waitVisibility(OptZipCode);
		writeText(OptZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
		MoveToElementClick(element);
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the status");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Quote has been created");	

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Click on Sales");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(policies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Click on Policies");
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(createpolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Click on Create Policies");
		waitForElement(4000);
		waitVisibility(cstname_search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(cstname_search));
		MoveToElementClick(element);
		ExtentSuccessMessage("Click on Customer Name Search");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(customername));
		writeText(customername, Full_Name);
		ExtentSuccessMessage("Enter Customer Name Search");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search_icon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(select_cust));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select Customer");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Ok_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on OK Button");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Product Category");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(selectMedical));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select Medical");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(carriers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carriers");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(selectcarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select carriers");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(salestype));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Type");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(salesnew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select Sales Type as New");
		waitForElement(1000);			
		element = wait.until(ExpectedConditions.presenceOfElementLocated(policystatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy Status");
		waitForElement(1000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(policyactive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select Policy Status Active");
		waitForElement(2000);	
		String effectiveDate = "10/10/2024";
		element = wait.until(ExpectedConditions.presenceOfElementLocated(effectivedate));
		writeText(effectivedate, effectiveDate + Keys.ENTER);
		ExtentSuccessMessage("Enter Effectivedate");
		waitForElement(2000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AORname));
		MoveToElementClick(element);
		waitForElement(2000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAOR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select AOR");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Ok_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on OK button");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, ph_no + Keys.ENTER);
		ExtentSuccessMessage("Enter Phone Number Search");
		waitForElement(12000);
		By cstname = By.xpath("//a[@title='"+Full_Name+"']");
		waitVisibility(cstname);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(cstname));
		MoveToElementClick(element);	
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit_icon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Icon");
		waitForElement(8000);
		String effectivedate = "12/12/2024";
		waitVisibility(OpportunityEffectiveDate);
		clear(OpportunityEffectiveDate);
		writeText(OpportunityEffectiveDate, effectivedate + Keys.ENTER);
		ExtentSuccessMessage("Entered the Effectivedate");
		waitForElement(2000);
		String Planname = "MedicalPlan"; 
		writeText(plan_name, Planname);
		ExtentSuccessMessage("Entered the Plan Name");
		waitForElement(1000);
		String Originalrate = "500"; 
		writeText(original_rate, Originalrate);
		ExtentSuccessMessage("Entered the Originalrate");
		waitForElement(1000);
		String Premiumamount = "300"; 
		writeText(premium_amount , Premiumamount);
		ExtentSuccessMessage("Entered the Premiumamount");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Save_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Save Button has been clicked");
		waitForElement(17000);
		By Neweffectivedate = By.xpath("//span[@class='ng-binding ng-scope'][normalize-space()='"+effectivedate+"']");
		Assert.assertTrue(driver.findElement(Neweffectivedate).isDisplayed());
		ExtentSuccessMessage("Neweffectivedate Assertion has been done");
		waitForElement(1000);
		By Plan_name = By.xpath("//span[normalize-space()='"+Planname+"']");
		Assert.assertTrue(driver.findElement(Plan_name).isDisplayed());
		ExtentSuccessMessage("Plan name Assertion has been done");
		waitForElement(1000);
		By Original_rate = By.xpath("//span[@class='ng-binding ng-scope'][normalize-space()='$"+Originalrate+".00']");
		Assert.assertTrue(driver.findElement(Original_rate).isDisplayed());
		ExtentSuccessMessage("Original rate Assertion has been done");
		waitForElement(1000);
		By Premium_amount = By.xpath("//span[@class='ng-binding ng-scope'][normalize-space()='$"+Premiumamount+".00']");
		Assert.assertTrue(driver.findElement(Premium_amount).isDisplayed());
		ExtentSuccessMessage("Premium Amount Assertion has been done");		
	}
} 



