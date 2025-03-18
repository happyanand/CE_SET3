package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Utility.ExcelHelper;

public class Carrier_360_Grid_Page extends BasePage {

	public Carrier_360_Grid_Page(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");

	public String carrier_name;

	By Agency = By.xpath("//span[normalize-space()='Agency']");
	By Carriers = By.xpath("//a[@href='#/agency/carrier']");
	By Carrierspage = By.xpath("//span[normalize-space()='All Carriers']");
	By Newcarrierbtn = By.xpath("//button[@id='newCarrierBtn']");
	By ham_icon = By.xpath("//i[@aria-label='Grid Menu']");
	By carriername = By.xpath("//md-select[@name='CarrierName'][@aria-expanded='false']");
	By seach_carrier = By.xpath("//input[@type='search'][@placeholder='Search Carrier Name']");
	By save_btn = By.xpath("//button[@id='saveCarrierDetailsBtn']");
	By edit_icon = By.xpath("//i[@class='fa fa-pencil white']");
	By email = By.xpath("//input[@name='Email']");
	By save = By.xpath("//button[normalize-space()='Save']");
	By primary_name = By.xpath("//input[@name='PrimaryContactName']");
	By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	By Dashboard = By.xpath("//a[@id='menu_Dashboard']");
	By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
	
	By CarrierNameSearchField = By.xpath("(//div[@class='ngCellText ng-scope'])[1]/a");
	By NotesSection = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	By ActionEmailIcon = By.xpath("//i[@class='fa fa-envelope']");
	By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
	By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
	By AgentEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	By DocumentAttachFileButton = By.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
	By AttachmentConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	By ActionTask = By.xpath("(//i[contains(@class,'fa fa-calendar')])[1]");
	By ActivityDD = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	By PriorityDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[5]/select");
	By CommentTextArea = By.xpath("//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
	By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
	By AttachmentInc = By.xpath("(//u[@class='ng-binding'])[1]");
	By RecentAgentIcon = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[1]");
	By CreatedTodayButton = By.xpath("//md-radio-button[@value='Created Today']");
	By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
	By EmailConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	By ActionAttachment = By.xpath("//a[@role='tab']//i[@class='fa fa-paperclip']");
	By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
	By Email_icon = By.xpath("//input[@placeholder='Add email address']");
	By Document_type = By.xpath("//select[@class='form-control ng-pristine ng-valid ng-not-empty ng-touched']");
	By select_value = By.xpath("//*[@id='filter-by']/div[1]/form/div[1]/select/option[25]");

	By delete_task = By.xpath("//i[@ng-click='deleteTask(activity, false)']");
	By click_ok = By.xpath("//span[normalize-space()='Ok']");
	By sales_leads = By.xpath("//a[normalize-space()='Sales - Leads']");
	
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

	public void validate_Carrier_details() throws InterruptedException, AWTException
	{
		ExtentSuccessMessage("****CA_TS_001_TC_001_Navigate_to_Carriers_Screen****");
		waitForElement(3000);
		waitVisibility(Agency);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agency");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carriers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Carriers");
		waitForElement(28000);
		waitVisibility(Carrierspage);
		Assert.assertTrue(driver.findElement(Carrierspage).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		waitVisibility(Newcarrierbtn);
		Assert.assertTrue(driver.findElement(Newcarrierbtn).isDisplayed());
		ExtentSuccessMessage("****CA_TS_002_TC_001_Create_New_Carrier****");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Newcarrierbtn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Carriers Button");
		waitForElement(8000);
		waitVisibility(carriername);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(carriername));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carriers Name Selected");
		waitForElement(10000);
		By elements = By.xpath("(((//md-select-menu)[9]//md-option)[1]//div[@class='md-text ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(elements));
		String value =element.getText();
		System.out.println(value);
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(save_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		ExtentSuccessMessage(value);
		waitForElement(15000);
		By CarrierSearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSearchField));
		MoveToElementClick(element);
		writeText(CarrierSearchField, value + Keys.ENTER);
		ExtentSuccessMessage("Carrier has been searched");
		waitForElement(5000);
		By Carriername = By.xpath("//a[@title='"+value+"']");
		waitVisibility(Carriername);
		Assert.assertTrue(driver.findElement(Carriername).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		ExtentSuccessMessage("****CA_TS_001_TC_002_Carrier_grid_Fields****");
		String values = ("Name,Website,Phone Number,Email Address,Product Category,Carrier Status,State");
		String[] ExpectedColnumname =values.split(",");
		for(int i=0;i<7;i++) {
			int j = i+1;
			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if (ActualColunmName.isBlank()) {
				System.out.println("Actual Column Name is blank.");
				Base_Class.ScrollUntilElementVisible(Elements);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
				Thread.sleep(3000);
				String ColunmName =element.getText();
				Assert.assertEquals(ExpectedColnumname[i], ColunmName);
				ExtentSuccessMessage("Successfully user found the expected colunm name");
			} else {
				System.out.println("Actual Column Name: " + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected colunm name");
			}
		}
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierNameSearchField));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier from list has been clicked");	
		
		ExtentSuccessMessage("****CA_TS_001_TC_005_Edit_Carrier_Details****");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(edit_icon));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(email));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Email");
		clear(email);
		String Email1 = "ceuser@yopmail.com";
		writeText(email,Email1);
		ExtentSuccessMessage("Email Entered Successfully");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(primary_name));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Primary Name");
		clear(primary_name);
		String contactname = "Sanjay";
		writeText(primary_name,contactname);	
		ExtentSuccessMessage("Primary Name Entered Successfully");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(save));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		waitForElement(12000);
		By Email = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+value+"']");
		By Primarycontactname = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+contactname+"']");
		Assert.assertTrue(driver.findElement(Email).isDisplayed());
		Assert.assertTrue(driver.findElement(Primarycontactname).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		ExtentSuccessMessage("****CA_TS_004_TC_001_Add_Collaboration_Details****");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "Automation Text";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");
		waitForElement(8000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		String NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion has been done");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		waitForElement(3000);
		By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
		element = wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		MoveToElementClick(element);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com'] | //md-option[@value='test']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.elementToBeClickable(Email_icon));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox,AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation";
		writeText(EmailSubject,  AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email has been added");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion has been done");		   
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);	
		waitForElement(8000);
		By DocumentDD1 =  By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[4]/div/div/div[2]/div/div[1]/form/div[1]/select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
		waitForElement(4000);
		wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
		click(DocumentAttachFileButton);	
		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\AgentAttachment.txt";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Attachment has been added");
		Thread.sleep(4000);
		waitVisibility(AttachmentInc);
		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");		
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);	
		waitForElement(4000);
		By ActivityDd = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[4]/div/div/div[2]/div/div[1]/form/div[2]/select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDd));
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByValue("string:Send Email"); 
		Thread.sleep(1000);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PriorityDD));
		element.click();
		Thread.sleep(500);
		Select s = new Select(element); 
		s.selectByVisibleText("Low");
		Thread.sleep(1000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommentTextArea));
		MoveToElementClick(element);
		writeText(CommentTextArea, "This Task is created VIA Automation" );
		Thread.sleep(1000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");			
		waitForElement(6000);
		waitVisibility(TaskInc);
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
	}		
	
	public void Carrier_gridfields() throws InterruptedException
	{
		ExtentSuccessMessage("****CA_TS_001_TC_002_Carrier_grid_Fields****");
		String values = ("Name,Website,Phone Number,Email Address,Product Category,Carrier Status,State");
		String[] ExpectedColnumname =values.split(",");
		for(int i=0;i<7;i++) {
			int j = i+1;
			Thread.sleep(2000);
			By Elements =By.xpath("(//*[@role='columnheader']//*[@ui-grid-one-bind-id-grid=\"col.uid + '-header-text'\"])["+j+"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
			String ActualColunmName =element.getText();
			if (ActualColunmName.isBlank()) { 
				System.out.println("Actual Column Name is blank.");
				Base_Class.ScrollUntilElementVisible(Elements);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Elements));
				Thread.sleep(3000);
				String ColunmName =element.getText();
				Assert.assertEquals(ExpectedColnumname[i], ColunmName);
				ExtentSuccessMessage("Successfully user found the expected colunm name");
			} else {
				System.out.println("Actual Column Name: " + ActualColunmName);
				System.out.println("ActualColunmName"+j+""+ActualColunmName);
				Assert.assertEquals(ExpectedColnumname[i], ActualColunmName);
				ExtentSuccessMessage("Successfully user found the expected colunm name");
			}
		}
		waitForElement(5000);	
	}
	
	public void edit_Carrier_details() throws InterruptedException
	{
		ExtentSuccessMessage("****CA_TS_001_TC_005_Edit_Carrier_Details****");
		waitForElement(3000);
		By elements = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(elements));
		carrier_name = element.getText();
		waitVisibility(edit_icon);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(edit_icon));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(email));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Email");
		clear(email);
		String Email1 = "ceuser@yopmail.com";
		writeText(email,Email1);
		ExtentSuccessMessage("Email Entered Successfully");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(primary_name));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Primary Name");
		clear(primary_name);
		String contactname = "Sanjay"; 
		writeText(primary_name,contactname);	
		ExtentSuccessMessage("Primary Name Entered Successfully");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(save));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		waitForElement(8000);
		By Email = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+Email1+"']");
		By Primarycontactname = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='"+contactname+"']");
		waitVisibility(Primarycontactname);
		Assert.assertTrue(driver.findElement(Email).isDisplayed());
		ExtentSuccessMessage("Email Assertion has been done");
		Assert.assertTrue(driver.findElement(Primarycontactname).isDisplayed());
		ExtentSuccessMessage("Primarycontactname Assertion has been done");
	
	}
	
	public void add_colobration_details() throws InterruptedException, AWTException
	{
		ExtentSuccessMessage("****CA_TS_004_TC_001_Add_Collaboration_Details****");
		waitForElement(10000);
		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "Automation Text";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");
		waitForElement(4000);
		waitVisibility(AgentActionNoteInc);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		String NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion has been done");
		waitForElement(2000);
		waitVisibility(ActionEmailIcon);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		waitForElement(4000);
		By EmailAddressDD = By.xpath("(//md-select[@role='listbox'])[5]");
		By EmailAddress = By.xpath("(//md-select[@role='listbox'])[2]");
		if(ElementDisplayed(EmailAddress)) {
			element = wait.until(ExpectedConditions.elementToBeClickable(EmailAddress));
			MoveToElementClick(element);
		}
		else if (ElementDisplayed(EmailAddressDD)) {
			element = wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
			MoveToElementClick(element);
		}
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com'] | //md-option[@value='test']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		waitForElement(1000);
		//Base_Class.KeyOperation("ENTER");
		//waitForElement(2000);
		element = wait.until(ExpectedConditions.elementToBeClickable(Email_icon));
		MoveToElementClick(element);
		String AgentEmailAction = "ceuser@yopmail.com";
		writeText(AddEmailAddressCheckBox,AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation";
		writeText(EmailSubject,  AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email has been added");
		waitForElement(5000);
		waitVisibility(AgentEmailInc);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion has been done");		   
		waitForElement(5000);
		waitVisibility(ActionAttachment);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);	
		waitForElement(10000);
		By DocumentDD1 =  By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[4]/div/div/div[2]/div/div[1]/form/div[1]/select");
		waitVisibility(DocumentDD1);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
		waitForElement(4000);
		wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
		click(DocumentAttachFileButton);	
		waitForElement(3000);
		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\AgentAttachment.txt";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);	
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Attachment has been added");
		waitForElement(6000);
//		waitVisibility(AttachmentInc);
//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
//		ExtentSuccessMessage("Assertion has been done");		
//		waitForElement(2000);
		waitVisibility(ActionTask);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);	
		waitForElement(4000);
		By ActivityDd = By.xpath("/html/body/div[3]/div[6]/div/ui-view/div[3]/div[4]/div/div/div[2]/div/div[1]/form/div[2]/select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDd));
		//element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		Thread.sleep(600);
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByValue("string:Send Email");
		Thread.sleep(1000);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PriorityDD));
		element.click();
		Thread.sleep(500);
		Select s = new Select(element); 
		s.selectByVisibleText("Low");
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommentTextArea));
		MoveToElementClick(element);
		writeText(CommentTextArea, "This Task is created VIA Automation" );
		Thread.sleep(1000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");			
		waitForElement(6000);
		waitVisibility(TaskInc);
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		waitForElement(35000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Dashboard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Dashboard");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on MyTask");
		System.out.println(carrier_name);
		waitForElement(6000);
		By task = By.xpath("//span[@class='ng-binding'][normalize-space()='"+carrier_name+"']");
		waitVisibility(task);
		Assert.assertTrue(driver.findElement(task).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
		
		waitForElement(7000);
		waitVisibility(task);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(task));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My Task");
		
		waitForElement(17000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitForElement(5000);
		
		waitVisibility(ActionTask);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Action Task");
		waitVisibility(delete_task);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(delete_task));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on delete Task");
		waitVisibility(click_ok);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(click_ok));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Ok");
		ExtentSuccessMessage("Task has been deleted Successfully");
		
	}
	
}
