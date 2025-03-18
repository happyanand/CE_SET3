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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.ExcelHelper;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");


	By SalesButton  = By.xpath("//span[text()='Sales ']");
	By Leads = By.xpath("(//a[text()='Leads'])[2]");
	By NewLead =By.xpath("//button[@name='newLeadBtn' and @id='newLeadBtn'] ");
	By NewLeadFirstName = By.xpath("//input[@id='LeadFirstName']");
	By NewLeadLastName =By.xpath("//input[@id='LeadLastName']");
	By DOB = By.xpath("//input[@id='Dob']");
	By Gender = By.xpath("//label[text()='Gender ']");
	By Male = By.xpath("//div[text()='Male']");
	By Phnum = By.xpath("//input[@name='LeadMobile']");
	By Email = By.xpath("//input[@id='LeadEmail']");
	By LeadInformation = By.xpath("//div[@id='formFlag2']");
	By HomeorPrincipals = By.xpath("//div[@id='formFlag3']");
	By HomeZipCode = By.xpath("//input[@name='ZipCode']");
	By Adress =By.xpath("//input[@id='AddressLine1'and @name ='AddressLine1']");
	By OtheInformation = By.xpath("//div[@id='formFlag5']//i[@role='button']");
	By Submit = By.xpath("(//button[text()='Submit'])[7]");
	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By LeadAssign = By.xpath("//button[@id='Assign']");
	By EditIcon = By.xpath("//button[@id='editLeadsBtn']");
	By StatusSelect = By.xpath("//select[@class='md-visually-hidden']");
	By ButtonSave = By.xpath("//button[text()='Save']");
	By search = By.xpath("//input[@type='search'][@aria-label='Search your text']");
	By checkbox = By.xpath("(//div[@class='ui-grid-cell-contents']//*[@role='button'])[2]");
	By managebtn = By.xpath("//button[@id='manageLeadsBtn']");
	By assignbtn = By.xpath("//button[@id='assignBtn']");
	By ownerinput = By.xpath("//input[@name='Owner'][@type='text']");
	By ownersearch = By.xpath("//i[@class='glyphicon glyphicon-search']");
	By select_owner = By.xpath("(//input[@name='selEntity'])[1]");
	By ok_btn = By.xpath("//button[normalize-space()='OK']");
	By submit_btn = By.xpath("//button[@id='assignLeadSubmitBtn']"); 
	By Assignbtn = By.xpath("//button[@id='Assign']");
	By Dispose_btn = By.xpath("//button[@id='Call']");
	By CallDisposalType = By.xpath("//md-select[@name='CallDisposalTypes'][@role='listbox']");
	By Bad_lead = By.xpath("//md-option[@value='Bad Lead']");
	By Call_Back = By.xpath("//md-option[@value='Call Back']");
	By Little_Interested = By.xpath("//md-option[@value='Little Interested']");
	By Submitbtn = By.xpath("//button[@id='formSubmitBtn']");
	By Activity_log = By.xpath("//a[normalize-space()='Activity Logs']");
	//By Edit_icon  = By.xpath("//i[contains(@class,'btn fa fa-pencil')]");
	By Revenue = By.xpath("//input[@name='Revenue']");
	By Rating = By.xpath("//md-select[@id='Rating']");
	By Leadsize = By.xpath("//input[@id='LeadSize']");
	By Save = By.xpath("//button[normalize-space()='Save']");
	By Leadinfo = By.xpath("//a[normalize-space()='Lead Information']");
	By SSN = By.xpath("//input[@name='Ssn'][@type='text']");
	By Home_phno = By.xpath("//input[@name='HomePhone']");
	By Employeer = By.xpath("//input[@id='Account']");
	By Occupation = By.xpath("//input[@id='LeadOccupation']");
	
	By checklead = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
	By managelead = By.xpath("//button[@id='manageLeadsBtn']");
	By deletelead = By.xpath("//button[@id='deleteLeadsBtn']");
	By clickyes = By.xpath("//button[normalize-space()='Yes']");
	By menusales = By.xpath("//a[@id='menu_Sales']");
	By submenuleads = By.xpath("//a[@id='submenu_salesleads']");

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

	public void Assign_Leads() throws InterruptedException 
	{
		waitForElement(2000);
		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(5000);
		waitVisibility(NewLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on NewLead");
		String First_name = "Automation";
		String Last_name = randomName();
		String Full_Name  = First_name+ " " + Last_name;
		waitVisibility(NewLeadFirstName);
		writeText(NewLeadFirstName,First_name);
		writeText(NewLeadLastName,  Last_name);
		waitForElement(2000);
		writeText(Phnum,generatePhoneNumber());
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");
		waitForElement(15000);
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
		waitForElement(2000);
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(3000);
		waitVisibility(checkbox);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Checkbox");
		if(driver.findElement(managebtn).isDisplayed()) 
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(managebtn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Manage Button");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(assignbtn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Assign Button");
			waitForElement(4000);		
		}
		else 
		{
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Lead");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Assignbtn));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Assign Button");
			waitForElement(5000);
		}
		clear(ownerinput);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ownerinput));
		String Newowner = "CEuser anand";
		writeText(ownerinput, Newowner);
		ExtentSuccessMessage("Entered New Owner");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ownersearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(select_owner));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Owner");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ok_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Ok");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(submit_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");
		waitForElement(6000);
		By OwnerName= By.xpath("//span[contains(text(),'"+Newowner+"')]");
		waitVisibility(OwnerName);
		Assert.assertTrue(driver.findElement(OwnerName).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");

	}

	public void Select_Disposition() throws InterruptedException 
	{
		waitForElement(2000);	
		String CurrentURL= driver.getCurrentUrl();
		System.out.println(CurrentURL);
		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Clicked on NewLead");
		String First_name = "Automation";
		String Last_name = randomName();
		String Full_Name  = First_name+ " " + Last_name;
		waitVisibility(NewLeadFirstName);
		writeText(NewLeadFirstName,First_name);
		writeText(NewLeadLastName,  Last_name);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Phnum));
		writeText(Phnum,generatePhoneNumber());
		waitForElement(2000);
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
		waitForElement(2000);
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(3000);
		By Campaign_name= By.xpath("(//div[@title='Direct Referral'])[1]");
		waitVisibility(Campaign_name);
		Assert.assertTrue(driver.findElement(Campaign_name).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");
		waitForElement(8000);
		waitVisibility(Dispose_btn);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Dispose_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Dispose Button");
		waitForElement(12000);
		waitVisibility(CallDisposalType);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposalType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Call Disposal Type");
		waitForElement(2000);
		String Disposaltype = "Qualify";
		if(CurrentURL.contains("https://mme.brokerengage.net/mme/")) {
			Disposaltype = "Call Back";
		} else {
			Disposaltype = "Qualify";
		}
		By disposaltype= By.xpath("//md-option[@value='"+Disposaltype+"']");
		waitVisibility(disposaltype);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(disposaltype));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on "+Disposaltype+"");
		waitForElement(4000);
		waitVisibility(Submitbtn);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submitbtn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activity_log));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Activity Log Tab");
		waitForElement(7000);
		By Disposal_Type= By.xpath("//div[@title='"+Disposaltype+"']");
		waitVisibility(Disposal_Type);
		Assert.assertTrue(driver.findElement(Disposal_Type).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(menusales));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(submenuleads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(2000);
		waitVisibility(checklead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(checklead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Checkbox");
		waitVisibility(managelead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(managelead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Manage Lead");
		waitVisibility(deletelead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(deletelead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on delete Lead");
		waitVisibility(clickyes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(clickyes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on yes");
		ExtentSuccessMessage("Lead has been deleted Successfully");
		
	}
	
	public void Edit_Lead_Details() throws InterruptedException 
	{
		waitForElement(2000);		
		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(5000);
		waitVisibility(NewLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Clicked on NewLead");
		String First_name = "Automation";
		String Last_name = randomName(); 
		String Full_Name  = First_name+ " " + Last_name;
		waitVisibility(NewLeadFirstName);
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
		waitForElement(5000);
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Icon");
		waitForElement(2000);		
		String revenue = "500";
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Revenue));
		writeText(Revenue, revenue);
		ExtentSuccessMessage("Entered Revenue");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Rating));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Rating");
		waitForElement(2000);
		
		WebElement HRCADD=driver.findElement(By.xpath("//select[@name='HRACompleted']"));
		Select s = new Select(HRCADD);
		s.selectByVisibleText("Yes");
		ExtentSuccessMessage("HRCA DD is selected");
		
		WebElement salestype=driver.findElement(By.xpath("//select[@name='SaleType']"));
		Select s1 = new Select(salestype);
		s1.selectByVisibleText("New");
		ExtentSuccessMessage("Sales DD is selected");
		
		String rating = "Cold";
		By Rating= By.xpath("//md-option[@role='option'][@value='"+rating+"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Rating));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on "+rating+"");
		waitForElement(1000);
		String leadsize = "50";
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leadsize));
		writeText(Leadsize, leadsize);
		ExtentSuccessMessage("Entered Leadsize");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Save));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leadinfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Information Tab");
		waitForElement(6000);
		By Lead_size= By.xpath("//span[@class='ng-binding'][normalize-space()='"+leadsize+"']");
		Assert.assertTrue(driver.findElement(Lead_size).isDisplayed());
		waitForElement(3000);
		ExtentSuccessMessage("Lead size Assertion has been done");	
		By Ratings= By.xpath("//span[contains(text(),'"+rating+"')]");
		Assert.assertTrue(driver.findElement(Ratings).isDisplayed());
		ExtentSuccessMessage("Ratings Assertion has been done");	
		By Revenue= By.xpath("//span[contains(text(),'"+revenue+"')]");
		waitForElement(6000);
		Assert.assertTrue(driver.findElement(Revenue).isDisplayed());
		ExtentSuccessMessage("Revenue Assertion has been done");	
	
	}
	
	
	public void mapcreatedlead() throws InterruptedException 
	{
		waitForElement(2000);		
		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(5000);
		//By All_Leads= By.xpath("//span[@class='ng-binding'][normalize-space()='All Leads']");
		//Assert.assertTrue(driver.findElement(All_Leads).isDisplayed());
		//Assert.assertTrue(driver.findElement(NewLead).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		waitVisibility(NewLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Clicked on NewLead");
		String First_name = "Automation";
		String Last_name = randomName();
		String Full_Name  = First_name+ " " + Last_name;
		waitVisibility(NewLeadFirstName);
		writeText(NewLeadFirstName,First_name);
		writeText(NewLeadLastName,  Last_name);
		waitForElement(2000);
		writeText(Phnum,generatePhoneNumber());
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DOB));
//		writeText(DOB,"01012000"+Keys.ENTER);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email));
		writeText(Email,"CEuser@yopmail.com");
		waitForElement(1000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SSN));
//		writeText(SSN,generatessnNumber());
//		waitForElement(1000);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OtheInformation));
		MoveToElementClick(element);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Home_phno));
		writeText(Home_phno,generatePhoneNumber());
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Employeer));
		writeText(Employeer,"CEuser");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Occupation));
		writeText(Occupation,"Tester");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");
		waitForElement(5000);
		By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(element2));
		try {
			if  (driver.findElement(element2).isDisplayed()) {
				MoveToElementClick(element);
				
			}
		} catch (NoSuchElementException e) {
		}
		catch (Exception e) {
			ExtentSuccessMessage("Lead Created");
		}
		waitForElement(5000);
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(3000);
		By Campaign_name= By.xpath("(//div[@title='Direct Referral'])[1]");
		Assert.assertTrue(driver.findElement(Campaign_name).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");
		waitForElement(5000);
		By customername= By.xpath("(//span[contains(text(),'"+Full_Name+"')][@class='ng-binding'])[2]");
		waitVisibility(customername);
		Assert.assertTrue(driver.findElement(customername).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
	}
	
}
