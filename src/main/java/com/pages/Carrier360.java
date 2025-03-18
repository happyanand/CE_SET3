package com.pages;




import java.awt.AWTException;
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

import com.BasePackage.Base_Class;

import Utility.ExcelHelper;

public class Carrier360  extends BasePage {

	public Carrier360(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String AgentText;
	public String NoteText;
	public String Primary_Contact_Number;
	public String doctors_Network;
	public String  Email1;
	public String  Get_Carier_Name;
	public String Get_Websiteurl;
	public String CD_Adress;
	public String ProductCategory;
	public String Customer_Fname;
	public String Customer_Lname;
	public String Customer_Name;
	public String carrier_Name;
	public String Premium_Date;
	public String Carriergroup;
	public String Agency_Name;
	public String Agency_State;
	public String status;
	public String Carriersname;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;

	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");

	Base_Class Base_Class =new Base_Class();

	By ClicKCarrier = By.xpath("(//div[@class='ngCellText ng-scope'])[1]/a");
	By AgencyTile = By.xpath("//a[@class='glyphicon fa fa-building']");
	By AgencyAgent= By.xpath("(//a[contains(.,'Agents')])[1]");
	By AgencyCarrier = By.xpath("(//a[contains(.,'Carriers')])[2]");
	By Carrier_Name = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[1]");
	By Product_Category = By.xpath("//label[normalize-space()='Product Category:']");
	By Contact_Name = By.xpath("//label[normalize-space()='Primary Contact Name:']");
	By Phone = By.xpath("//label[normalize-space()='Phone:']");
	By Status = By.xpath("//label[normalize-space()='Status:']");
	By Comments = By.xpath("//label[normalize-space()='Comments:']");
	By State_Of_Operation = By.xpath("//label[normalize-space()='State of Operation:']");
	By Website_Url = By.xpath("//label[normalize-space()='Website Url:']");
	By Adress = By.xpath("//label[normalize-space()='Address:']");
	By Email = By.xpath("//label[normalize-space()='Email:']");
	By Carriers_Groups= By.xpath("//label[normalize-space()='Carrier Groups:']");
	By Doctors_Network = By.xpath("(//label[normalize-space()=\"Doctor's Network:\"])[1]");
	By Basic_Information = By.xpath("//a[normalize-space()='Basic Information']");
	By Contacts= By.xpath("(//a[normalize-space()='Contacts'])[1]");
	By Quotes= By.xpath("//a[contains(text(),'Quotes')]");
	By Policies= By.xpath("(//a[@role='tab'][normalize-space()='Policies'])[1]");
	By Agent_Appointments= By.xpath("//a[normalize-space()='Agent Appointments']");
	By Comissions= By.xpath("//a[contains(text(),'Commissions')]");
	By Agency = By.xpath("//span[normalize-space()='Agency']");
	By Agency_menu = By.xpath(" //a[@id='menu_Agency']");
	By CD_Websiteurl = By.xpath("//input[@name='WebSiteURL']");

	By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	By Carriers = By.xpath("//a[@href='#/agency/carrier']");
	By Carriers_submenu = By.xpath("//a[@id='submenu_agencycarrier']");
	By Carrierspage = By.xpath("//span[normalize-space()='All Carriers']");
	By Newcarrierbtn = By.xpath("//button[@id='newCarrierBtn']");
	By ham_icon = By.xpath("//i[@aria-label='Grid Menu']");
	By carriername = By.xpath("//md-select[@name='CarrierName'][@aria-expanded='false']");
	By seach_carrier = By.xpath("//input[@type='search'][@placeholder='Search Carrier Name']");
	By save_btn = By.xpath("//button[@id='saveCarrierDetailsBtn']");
	By edit_icon = By.xpath("//i[@class='fa fa-pencil white']");
	By email = By.xpath("//input[@name='Email']/..");
	By Email2 = By.xpath("//input[@name='Email']");
	By save = By.xpath("//button[normalize-space()='Save']");
	By primary_name = By.xpath("//input[@name='PrimaryContactName']");
	By Doctors_Nw = By.xpath("//input[@name='DoctorsNetwork']");
	By carrier_group_dd = By.xpath("//md-select[@name='CarrierGroup']");
	By productcategory = By.xpath("(//span[@class='md-select-icon'])[3]");

	By Customers = By.xpath("(//span[normalize-space()='Customers'])[1] | //a[@id='menu_customers']");
	// By AgencyAgent= By.xpath("(//a[contains(.,'Agents')])[1]");
	By Agencydrop_down = By.xpath("//a[@id='menu_Agency']");
	By NewAgentButton=By.id("createNewAgentBtn");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	By AgentPrefix= By.xpath("//md-select[@name='Prefix']");
	By AgentPrefixOption = By.xpath("//div[text()='Mr.']");
	By NewAgentFirstName = By.name("FirstName");
	By NewAgentLastName = By.name("LastName");
	By ContactInfo = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");
	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By SalesButton  = By.xpath("//a[@id='menu_Sales']");
	By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");
	By PrincipalAdress = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
	By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By SalesOpportunities =By.xpath("//a[@id='submenu_salesopportunities']");
	By Customerdropdown = By.xpath("//a[@id='menu_customers']");

	// By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	//By PolicyActive = By.xpath("(//div[@class='md-text'][normalize-space()='Active'])[3]");
	//By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	//By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	//By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	//By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	//By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	//By AorOk = By.xpath("//button[text()='OK']");
	By PolicySubmit = By.xpath("//button[@ng-show=\"accountType !=='Group'\"]");
	By ProductCategory1 = By.xpath("(//md-select[@id='CRMProductCategory'])[1]");
	By AccidentLOB = By.xpath("(//md-option[@value='Medical'])[2]"); 
	By Carrier = By.xpath("//md-select[@id='Carrier']");
	By SelectCarrier = By.xpath("(//md-option[@value='NLG'])[2] | (//md-option[@value='Humana'])[2] | (//md-option[@value='Aetna'])[2]");
	By SalesType = By.xpath("//md-select[@id='salesType']");
	By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
	By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	By PolicyActive = By.xpath("(//div[@class='md-text'][normalize-space()='Active'])[3]");
	By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	By AorOk = By.xpath("//button[text()='OK']");
	By emailclass = By.xpath("//*[@class='ng-pristine ng-untouched md-input ng-empty ng-valid ng-valid-required ng-valid-email']");
	By Select_Carriergroup = By.xpath("(//md-option[contains(@ng-if,'fieldVal.variableCode ==')][contains(@ng-if,'CarrierGroup')])[1]");
	By getcarrier = By.xpath("//md-select[@name='CarrierGroup']//div[@class='md-text ng-binding']");
	
	By New_Agent_Appointment = By.xpath("//button[@id='newAgentAppointmentBtn']");
	By Agency_name = By.xpath("//md-select[@name='AgentName']");
	By select_agencyname = By.xpath("(//md-select-menu[@class='_md md-overflow']//md-option[@ng-value='opt']//div[@class='md-text ng-binding'])[1]");
	By state = By.xpath("//md-select[@name='State']");
	By select_state = By.xpath("(//*[@class='md-select-menu-container dropDown md-active md-clickable']//md-select-menu[@class='_md md-overflow']//md-option[@ng-value='opt'])[1]");
	By Agent_status = By.xpath("//md-select[@name='AgentStatus']");
	By get_agencyname = By.xpath("(//md-select-value[@class='md-select-value']//div[@class='md-text ng-binding'])[1]");
	By get_agencystate = By.xpath("(//md-select-value[@class='md-select-value']//div[@class='md-text ng-binding'])[2]");
	By save_agentAppointment = By.xpath("//button[@id='saveAgentAppointmentBtn']");
	By Agent_Appointment = By.xpath("//a[normalize-space()='Agent Appointments']");
	By edit_agentAppoinment = By.xpath("//i[@title='Edit Agent Appointment']");
	By update_agentAppointment = By.xpath("//button[@id='updateAgentAppointmentBtn']");
	By download = By.xpath("//i[@class='fa fa-download']");
	By success_msg = By.xpath("//div[@id='divSuccesss']");
	By Agency_carrier = By.xpath("//a[normalize-space()='Agency - Carriers']");
	By recent_carrier_groups = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[1]");
	By Created_today = By.xpath("//md-radio-button[@value='Created Today']");
	By reset = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
	By Select_carrier_group = By.xpath("(//div[@ng-class=\"{'ui-grid-row-selected': row.isSelected}\"])[1]");
	By Delete_carrier_group = By.xpath("(//i[@title='Delete Carrier Group'])[1]");
	By okay = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	By Advance_search = By.xpath("//button[@id='advancedSearchBtn']");
	By created_date = By.id("CreatedStartDate");
	By search = By.xpath("//button[@id='applyadvancedSearchBtn']");
	
	private By CarrierGroupButton = By.xpath("(//button[@class='btn btn-default pull-right btn-yellow'])[2]");
	private By NewCarrierGroupButton = By.xpath("//button[contains(.,'New Carrier Group')]");
	private By CarrierGroupNameField = By.xpath("//input[@class='full-width ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required']");
	private By CarrierOption1= By.xpath("//label[@class='container-check group-number ng-binding ng-scope'][1]");
	private By CarrierOption2= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[5]");
	private By CarrierOption3= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[8]");
	private By CarrierOption4= By.xpath("(//label[@class='container-check group-number ng-binding ng-scope'])[4]");
	private By EditCarrierGroup = By.xpath("//i[@title='Edit Carrier Group']");
	private By SelectedCarrierToRightButton = By.xpath("//a[@class='fa fa-angle-right']");
	private By CarrierGroupSubmitButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
	
	
	
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

	public String writeDynamicEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
		String email = "";
		String emailDomain = "";
		String temp = RandomStringUtils.random(25, allowedChars);
		emailDomain = temp.substring(0, temp.length() - 15);
		email = temp.substring(0, temp.length() - 9) + "@" + "yopmail.com";
		return email;		
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
	public static String generatePhoneNumber() {
		Random random = new Random();


		int areaCode = random.nextInt(900) + 100;      // 100-999
		int centralOfficeCode = random.nextInt(900) + 100; // 100-999
		int lineNumber = random.nextInt(10000);        // 0-9999
		String formattedLineNumber = String.format("%04d", lineNumber);


		return String.format("(%03d) %03d-%s", areaCode, centralOfficeCode, formattedLineNumber);
	}


	public void carrier_details_validation() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Carrier has been clicked");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carrier name");
		waitForElement(8000);
		By Carrier_details = By.xpath("(//span[normalize-space()='Carrier Details'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier_details));
		ExtentSuccessMessage("Navigated to carrier details page");

		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier_Name));
		ExtentSuccessMessage("Carrier Name  has been Displayed");



	}
	
	public void agency_CreateNewCarrierGroup() throws InterruptedException
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency_carrier));
		MoveToElementClick(element);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier Group Button has been clicked");
		waitForElement(2000);
		Assert.assertTrue(driver.findElement(NewCarrierGroupButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCarrierGroupButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Carrier Group Button has been clicked");
		waitVisibility(CarrierGroupNameField);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupNameField));
		MoveToElementClick(element);
		String CarrierGroupName = "AutoCarrierGroup"+ getRandomNumber();
		writeText(CarrierGroupNameField,CarrierGroupName + Keys.ENTER );
		ExtentSuccessMessage("Carrier Name has been Entered");
		waitForElement(2000);
		if(ElementDisplayed(CarrierOption1)) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption1));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption2));
			MoveToElementClick(element);
			waitForElement(700);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption3));
			MoveToElementClick(element);
			waitForElement(700);
			ExtentSuccessMessage("Carrier Has been Selected");
			//waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectedCarrierToRightButton));
			MoveToElementClick(element);
			waitForElement(700);
			ExtentSuccessMessage("Carrier has been moved to right");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupSubmitButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier has been Created");	
		} else {
			RefreshPage();
			waitForElement(9000);
			ClickOnMinimizeCallwindow();
			waitVisibility(NewCarrierGroupButton);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCarrierGroupButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("New Carrier Group Button has been clicked");
			waitVisibility(CarrierGroupNameField);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupNameField));
			MoveToElementClick(element);
			writeText(CarrierGroupNameField,CarrierGroupName + Keys.ENTER );
			ExtentSuccessMessage("Carrier Name has been Entered");
			waitVisibility(CarrierOption1);
			if(ElementDisplayed(CarrierOption1)) {
				element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption1));
				MoveToElementClick(element);
				waitForElement(700);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption2));
				MoveToElementClick(element);
				waitForElement(700);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption3));
				MoveToElementClick(element);
				waitForElement(700);
				ExtentSuccessMessage("Carrier Has been Selected");
				//waitForElement(2000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectedCarrierToRightButton));
				MoveToElementClick(element);
				waitForElement(700);
				ExtentSuccessMessage("Carrier has been moved to right");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupSubmitButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Carrier has been Created");	
			}
		}
		Thread.sleep(5000);
		driver.navigate().refresh();

		Thread.sleep(12000);
		//waitVisibility(recent_carrier_groups);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(recent_carrier_groups));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Carrier Group");
		//waitVisibility(Created_today);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Created_today));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created Today");
		By carriergroup = By.xpath("//a[@title='"+CarrierGroupName+"']");
		waitVisibility(carriergroup);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(carriergroup));
		Assert.assertTrue(ElementDisplayed(carriergroup));
		ExtentSuccessMessage("carriergroup is displayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(reset));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Reset");
		waitForElement(2000);
		By Search = By.xpath("//input[@aria-label='Search your text']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		writeText(Search,CarrierGroupName + Keys.ENTER);
		ExtentSuccessMessage("Searched with Carrier GroupName ");
		waitForElement(2000);
		waitVisibility(Select_carrier_group);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_carrier_group));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Carrier group Checkbox");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditCarrierGroup));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Carrier group");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOption4));
		MoveToElementClick(element);
		waitForElement(700);
		ExtentSuccessMessage("Carrier has been Added");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectedCarrierToRightButton));
		MoveToElementClick(element);
		waitForElement(700);
		ExtentSuccessMessage("Carrier has been moved to right");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierGroupSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier has been Created");	
		waitForElement(1000);
		waitVisibility(Advance_search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Advance_search));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance_search");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(created_date));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on created_date");
		String currentdate = Currentdate1();
		writeText(created_date, currentdate);
		Base_Class.KeyOperation("ENTER");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search");
		waitVisibility(download);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(download));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on download");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(success_msg));
		Assert.assertTrue(ElementDisplayed(success_msg));
		waitForElement(2000);
		waitVisibility(Delete_carrier_group);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete_carrier_group));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete carrier group");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(okay));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Okay");
		waitForElement(2000);
		
	}
		

	public void existing_carriers_Tabs() throws InterruptedException
	{
		ExtentSuccessMessage("****Existing_Carrier_Validations****");
		waitForElement(5000);
		waitVisibility(AgencyTile);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");


		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Carrier has been clicked");
		waitForElement(10000);

		By getCarriername = By.xpath("(//*[@ng-click='grid.appScope.carrierDetails(row.entity)'])[1]");
		if(ElementDisplayed(getCarriername)) {
			Carriersname = GetElementText(getCarriername);
			By Search = By.xpath("/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[3]/div[1]/h1[1]/div[1]/div[3]/div[1]/form[1]/md-autocomplete[1]/md-autocomplete-wrap[1]/md-input-container[1]/input[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
			//String Carrier_Ext = "Ambetter";
			writeText(Search ,  Carriersname+ Keys.ENTER);
		}else {
			RefreshPage();
			waitVisibility(getCarriername);
			Carriersname = GetElementText(getCarriername);
			By Search = By.xpath("/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[3]/div[1]/h1[1]/div[1]/div[3]/div[1]/form[1]/md-autocomplete[1]/md-autocomplete-wrap[1]/md-input-container[1]/input[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
			writeText(Search ,  Carriersname+ Keys.ENTER);
		}


		waitForElement(3000);
		waitVisibility(ClicKCarrier);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		waitForElement(2000);
		
		By Carrier_details = By.xpath("(//span[normalize-space()='Carrier Details'])[1]");
		waitVisibility(Carrier_details);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier_details));
		ExtentSuccessMessage("Navigated to carrier details page");
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier_Name));
		String ExtName = element.getText();
		System.out.println(ExtName);
		Assert.assertTrue(ExtName.contains(Carriersname));
		ExtentSuccessMessage("Existing carrier is present in the grid");	
		
	}
	public void Tabs_Validation() throws InterruptedException
	{
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");
		waitForElement(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Carrier has been clicked");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carrier name");
		waitForElement(8000);



		element = wait.until(ExpectedConditions.presenceOfElementLocated(Basic_Information));
		ExtentSuccessMessage("Basic Information Tab has been clicked");
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Contacts));
		ExtentSuccessMessage("Contacts Tab has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotes));
		ExtentSuccessMessage("Quotes Tab has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
		ExtentSuccessMessage("Policies Tab has been clicked");
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Appointments));
		ExtentSuccessMessage("Agent Appointments Tab has been clicked");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Comissions));

		ExtentSuccessMessage("Comissions Tab has been clicked");


	}
	public void createnewcarrier() throws InterruptedException, AWTException
	{
		waitForElement(5000);
		ExtentSuccessMessage("****CA_TS_001_TC_001_Navigate_to_Carriers_Screen****");
		waitVisibility(Agency);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agency");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carriers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Carriers");
		waitForElement(5000);
		waitVisibility(Carrierspage);
		Assert.assertTrue(driver.findElement(Carrierspage).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");			
		ExtentSuccessMessage("****CA_TS_002_TC_001_Create_New_Carrier****");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Newcarrierbtn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Carriers Button");
		waitForElement(2000);
		waitVisibility(carriername);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(carriername));
		MoveToElementClick(element);
		waitForElement(4000);
		By elements = By.xpath("(((//md-select-menu)[9]//md-option)[1]//div[@class='md-text ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(elements));
		String value =element.getText();
		Get_Carier_Name = element.getText();
		System.out.println(Get_Carier_Name);
		MoveToElementClick(element);
		waitForElement(4000);
		//By elements = By.xpath("(((//md-select-menu)[9]//md-option)[1]//div[@class='md-text ng-binding'])[1]");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(productcategory));
		ProductCategory =element.getText();
		By Primary_Contact = By.xpath("//input[@name='PrimaryContactName']");
		Primary_Contact_Number = randomName();
		writeText(Primary_Contact , Primary_Contact_Number);
		doctors_Network= employerName();
		writeText(Doctors_Nw  ,doctors_Network );
		By Adress = By.xpath("//input[@name='Address']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Adress));
		CD_Adress = element.getText();
		//writeText(Adress  ,CD_Adress);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(email));
		MoveToElementClick(element);

		if(ElementDisplayed(emailclass)) {
			Email1 = writeDynamicEmail();
			System.out.println(Email1);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Email2));
			MoveToElementClick(element);
			writeText(Email2,Email1);
		} else {
			System.out.println("Before Cleared Email");
			clear(Email2);
			System.out.println("Cleared Email");
			Email1 = writeDynamicEmail();
			System.out.println(Email1);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Email2));
			MoveToElementClick(element);
			writeText(Email2,Email1);
		} 
				
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated( carrier_group_dd));
		MoveToElementClick(element);
		waitForElement(3000);
		//By option = By.xpath("//div[normalize-space()='Aetna']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_Carriergroup));
		MoveToElementClick(element);
		waitForElement(1000);
		Base_Class.RobotKeyOperation("Tab");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getcarrier));
		Carriergroup = element.getText();
		System.out.println(Carriergroup);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CD_Websiteurl));
		Get_Websiteurl = element.getText();

		element = wait.until(ExpectedConditions.presenceOfElementLocated(save_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage(value);
		waitForElement(8000);
		waitVisibility(download);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(download));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on download");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(success_msg));
		Assert.assertTrue(ElementDisplayed(success_msg));	

	}


	public void Carrier_Details_Validation() throws InterruptedException
	{
		
		By Search = By.xpath("//input[@aria-label='Search your text']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		writeText(Search,Email1 + Keys.ENTER);
		ExtentSuccessMessage("Searched with email id ");
		waitForElement(5000);
		waitVisibility(ClicKCarrier);
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carrier name");
		waitForElement(3000);
		waitVisibility(Basic_Information);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Basic_Information));
		ExtentSuccessMessage("Basic Information Tab has been displayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Contacts));
		ExtentSuccessMessage("Contacts Tab has been displayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotes));
		ExtentSuccessMessage("Quotes Tab has been displayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
		ExtentSuccessMessage("Policies Tab has been displayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Appointments));
		ExtentSuccessMessage("Agent Appointments Tab has been displayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Comissions));
		ExtentSuccessMessage("Comissions Tab has been displayed");
		waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier_Name));
		ExtentSuccessMessage("Carrier Name  has been Displayed");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Product_Category));
		System.out.println("*-----------------------------Product category----------------------------*");
		ExtentSuccessMessage("Product category is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Contact_Name));
		ExtentSuccessMessage("Contact name field is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Phone));
		ExtentSuccessMessage("Phone field is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Status));
		ExtentSuccessMessage("Status field is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Comments));
		ExtentSuccessMessage("Comments field is validated");
		// waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( State_Of_Operation ));
		ExtentSuccessMessage("State of operation field is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Website_Url ));
		ExtentSuccessMessage("Website url is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Adress ));
		ExtentSuccessMessage("Adress field is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email ));
		ExtentSuccessMessage("Email field is validated");
		//waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Carriers_Groups));
		ExtentSuccessMessage("Carriers group is validated");
		//waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated( Doctors_Network));
		ExtentSuccessMessage("Doctors network is validated");
		System.out.println("*-----------------------------Doctor network----------------------------*");
		waitForElement(3000);
		//Data 
		By CarrierName_Data  = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated( CarrierName_Data));
		String Carrier_Data = element.getText();
		System.out.println("-------------------------------------"+Carrier_Data+"-----------------------------------------");
		Assert.assertTrue(Carrier_Data.contains(Get_Carier_Name));
		ExtentSuccessMessage("CarrierName data is validated");

		//Product category

		By Productcategory_Data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated( Productcategory_Data));
		String Product_Data = element.getText();
		System.out.println("-------------------------------------"+Product_Data+"-----------------------------------------");
		Assert.assertTrue(Product_Data.contains(ProductCategory));
		ExtentSuccessMessage("Product category data is validated");

		//Primary contact 
		By Primarycontact_data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Primarycontact_data));
		String Pmcontact_Data = element.getText();
		System.out.println("-------------------------------------"+Pmcontact_Data+"-----------------------------------------");
		Assert.assertTrue(Pmcontact_Data.contains(Primary_Contact_Number));
		ExtentSuccessMessage("Primary contact  data is validated");

		//Status

		By Status_data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[7]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status_data));
		String St_Data = element.getText();
		System.out.println("-------------------------------------"+ St_Data+"-----------------------------------------");
		Assert.assertTrue(St_Data.contains("Active"));
		ExtentSuccessMessage("Status  data is validated");
		
		//adress

		By Adress_data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Adress_data));
		String Ad_Data = element.getText();
		System.out.println("-------------------------------------"+ Ad_Data+"-----------------------------------------");
		Assert.assertTrue(Ad_Data.contains(CD_Adress));
		ExtentSuccessMessage("Adress  data is validated");

		//email	

		By Email_data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[6]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email_data));
		String EM_Data = element.getText();
		System.out.println("-------------------------------------"+ EM_Data+"-----------------------------------------");
		Assert.assertTrue(EM_Data.contains(Email1));
		ExtentSuccessMessage("Email data is validated");

		//Carrier groups

		By CarierGrp_data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[8]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarierGrp_data));
		String CG_Data = element.getText();
		System.out.println("-------------------------------------"+ CG_Data+"-----------------------------------------");
		System.out.println(Carriergroup);
		Assert.assertTrue(CG_Data.contains(Carriergroup));
		ExtentSuccessMessage("Carrier Groups data is validated");

		//Doctors network

		By Doctorsnw_data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[10]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Doctorsnw_data));
		String DN_Data = element.getText();
		System.out.println("-------------------------------------"+ DN_Data+"-----------------------------------------");
		Assert.assertTrue(DN_Data.contains(doctors_Network));
		ExtentSuccessMessage("Doctors network data is validated");
	}
	
	public void Contacts_validation() throws InterruptedException
	{
		
		//Contacts
		ExtentSuccessMessage("****Contacts Validations****");
		//waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Contacts));
		MoveToElementClick(element);
		ExtentSuccessMessage("Contacts Tab has been clicked");
		waitForElement(1000);

		//add contacts
		By AddContact = By.xpath("//button[@id='AddContactsBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddContact));
		MoveToElementClick(element);
		ExtentSuccessMessage("Add Contacts has been clicked");
		waitForElement(1000);

		By First_Name = By.xpath("//input[@name='FirstName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(First_Name));
		MoveToElementClick(element);
		ExtentSuccessMessage("First Name has been clicked");

		String FName = "Test";
		writeText(First_Name,FName);
		waitForElement(1000);

		By Second_Name = By.xpath("//input[@name='LastName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Second_Name));
		MoveToElementClick(element);
		ExtentSuccessMessage("First Name has been clicked");

		String SName = employerName();
		writeText(Second_Name,SName);
		waitForElement(1000);

		String FullName = FName + " " + SName;
		System.out.println(FullName);

		By Cell_Number = By.xpath("//input[@name='CellPhone']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cell_Number));
		MoveToElementClick(element);
		String CellNo = generatePhoneNumber() ;
		writeText(Cell_Number,CellNo);
		ExtentSuccessMessage("Phone number entered");

		//Office phone

		By Office_Number = By.xpath("//input[@name='OfficePhone']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Office_Number));
		MoveToElementClick(element);
		String ofcNo =generatePhoneNumber() ;
		writeText(Office_Number,ofcNo);
		ExtentSuccessMessage(" Office Phone number entered");

		//Email

		By Contact_mail = By.xpath("//input[@name='Email']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Contact_mail));
		MoveToElementClick(element);
		String Mail ="Test@yopmail.com";
		writeText(Contact_mail,Mail);
		ExtentSuccessMessage(" MAil has been entered");

		//Category

		By Category = By.xpath("//md-select[@name='CRMProductCategory']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Category));
		MoveToElementClick(element);
		By categorydrop = By.xpath("//div[@class='md-text ng-binding'][text()='Accident']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(categorydrop));
		String Category_Type = element.getText();
		System.out.println(Category_Type);
		MoveToElementClick(element);

		//Save

		By Save_Button = By.xpath("//button[@id='saveAgentContactButton']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Save_Button));
		MoveToElementClick(element);

		//Validations
		//By Carriername = By.xpath("//a[@title='"+value+"']");
		By Name_Field = By.xpath("(//div[@title='"+ FullName+"'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Name_Field));
		ExtentSuccessMessage("Name is displayed");

		////cti-call-btn[normalize-space()='(923) 221-2110']

		By Pno_Field = By.xpath("//cti-call-btn[normalize-space()='"+ CellNo +"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Pno_Field));
		ExtentSuccessMessage(" phone number is displayed");

		By Email_field = By.xpath("//div[@title='Test@yopmail.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email_field));
		ExtentSuccessMessage(" Email is displayed");


		By State_field= By.xpath("(//div[@title='All'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State_field));
		ExtentSuccessMessage(" State is displayed");

		By Type = By.xpath("//div[@title='Accident']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Type));
		ExtentSuccessMessage("Type is displayed");
		
		By Delete = By.xpath("//i[@title='Delete Contact']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on delete Contact");
		
		By Ok = By.xpath("//span[normalize-space()='Ok']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Ok));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Ok");
		ExtentSuccessMessage("Contact has been Deleted");
		

	}

	public void Agent_Appointment() throws InterruptedException
	{
		//Agent_Appointment
		ExtentSuccessMessage("****Agent_Appointment Validations****");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(New_Agent_Appointment));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Agent Appointment has been clicked");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency_name));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agency Name");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(select_agencyname));
		MoveToElementClick(element);
		Base_Class.KeyOperation("ENTER");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(state));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on State");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(select_state));
		MoveToElementClick(element);
		Base_Class.KeyOperation("ENTER");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_status));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agent_status");
		status = "Active";
		By Active = By.xpath("//md-option[@value='"+status+"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Active));
		MoveToElementClick(element);
		Base_Class.KeyOperation("ENTER");
		ExtentSuccessMessage("Clicked on Active_status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(get_agencyname));
		Agency_Name = element.getText();
		System.out.println(Agency_Name);
		ExtentSuccessMessage("Agency_Name "+Agency_Name);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(get_agencystate));
		Agency_State = element.getText();
		System.out.println(Agency_State);
		ExtentSuccessMessage("Agency_State "+Agency_State);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(save_agentAppointment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Agent Appointment");
		waitForElement(5000);
		waitVisibility(Agent_Appointment);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Appointment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agent Appointment Tab");
		waitForElement(3000);
//		By agency = By.xpath("//div[contains(@title,'"+Agency_Name+"')]");
//		waitVisibility(agency);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(agency));
//		Assert.assertTrue(ElementDisplayed(agency));
		ExtentSuccessMessage("Agency_Name Assertion Passed");
		By state = By.xpath("//div[@title='"+Agency_State+"']");
		waitVisibility(state);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(state));
		Assert.assertTrue(ElementDisplayed(state));
		ExtentSuccessMessage("Agency_State Assertion Passed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(edit_agentAppoinment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on edit_agentAppoinmentnt_status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_status));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agent_status");
		status = "Appointed";
		By Appointed = By.xpath("//md-option[@value='"+status+"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Appointed));
		MoveToElementClick(element);
		Base_Class.KeyOperation("TAB");
		ExtentSuccessMessage("Clicked on Appointed_status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(update_agentAppointment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on update_agentAppointment");
		waitForElement(2000);
		waitVisibility(Agent_Appointment);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Appointment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agent Appointment Tab");
		waitForElement(2000);
		By Status = By.xpath("//div[@title='"+status+"']");
		waitVisibility(Status);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		Assert.assertTrue(ElementDisplayed(Status));
		ExtentSuccessMessage("Agency_State Assertion Passed");
		
	}
	
	public void Filter_Validation() throws InterruptedException
	{
		waitForElement(12000);
		//waitVisibility(Agency_menu);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency_menu));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agency");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carriers_submenu));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Carriers");
		waitForElement(5000);
		waitVisibility(Carrierspage);
		Assert.assertTrue(driver.findElement(Carrierspage).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		waitForElement(2000);

		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		
		By Product_Category = By.xpath("(//i[contains(@role,'button')])[3]");
		//waitVisibility(Product_Category);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product_Category));
		MoveToElementClick(element);
		ExtentSuccessMessage("Product Category filter is availabe ");

		By State = By.xpath("(//i[@role='button'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State));
		MoveToElementClick(element);
		ExtentSuccessMessage("State Category filter is availabe ");

		By Carrier_Group = By.xpath("(//i[@role='button'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier_Group));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier_Group  filter is availabe ");

	}

	public void Apply_Filter () throws InterruptedException
	{

		waitForElement(20000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agency));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Agency");
		waitForElement(20000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carriers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Carriers");
		waitForElement(18000);
		Assert.assertTrue(driver.findElement(Carrierspage).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		waitForElement(8000);

		By Product_Category = By.xpath("(//i[contains(@role,'button')])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product_Category));
		MoveToElementClick(element);
		ExtentSuccessMessage("Product Category filter is availabe ");

		By Product_Drop_Down  = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product_Drop_Down));
		MoveToElementClick(element);

		By Option  = By.xpath("(//md-option[@value = \"Dental\"])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Option));
		MoveToElementClick(element);
		waitForElement(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carrier name");
		waitForElement(8000);
		By Productcategory_Data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated( Productcategory_Data));
		String Product_Data = element.getText();
		System.out.println("-------------------------------------"+Product_Data+"-----------------------------------------");
		Assert.assertTrue(Product_Data.contains("Dental"));
		ExtentSuccessMessage("Filter value is assertion has been done");

	}

	public void ApplyFilter() throws InterruptedException
	{

		ExtentSuccessMessage("****CA_TS_005_TC_001_002_Apply_Filter_Criteria****");
		
		By Product_Drop_Down  = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product_Drop_Down));
		MoveToElementClick(element);

		By Option  = By.xpath("(//md-option[@value = \"Dental\"])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Option));
		MoveToElementClick(element);
		waitForElement(5000); 
		
		By State_of_Operations  = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State_of_Operations));
		MoveToElementClick(element);
		waitForElement(2000);
		By State_Option  = By.xpath("//md-option[@value = 'AK']");
		waitVisibility(State_Option);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State_Option));
		MoveToElementClick(element);
		
		waitForElement(5000);

		waitVisibility(ClicKCarrier);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carrier name");
		waitForElement(4000);
		By Productcategory_Data = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[3]");
		By State_of_Operation = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[2]");
		waitVisibility(Productcategory_Data);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Productcategory_Data));
		String Product_Data = element.getText();
		System.out.println("-------------------------------------"+Product_Data+"-----------------------------------------");
		Assert.assertTrue(Product_Data.contains("Dental"));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State_of_Operation));
		String State_Operation = element.getText();
		System.out.println("-------------------------------------"+State_Operation+"-----------------------------------------");
		Assert.assertTrue(State_Operation.contains("AK"));
		ExtentSuccessMessage("Filter value is assertion has been done");	

	}

	public void ClickOnMinimizeCallwindow() throws InterruptedException {
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
	}

	public void Policy_Validation() throws InterruptedException
	{
		ExtentSuccessMessage("****CA_TS_003_TC_004_Policy_Validations****");
		//create a new customer
		waitForElement(10000);
		//waitVisibility(Customers);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(4000);
		waitVisibility(NewCustomer);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		Customer_Fname ="Rohith";
		waitForElement(2000);
		waitVisibility(CustFName);
		writeText(CustFName,Customer_Fname);
		Customer_Lname = randomName();
		waitForElement(2000);
		writeText(CustLName,Customer_Lname );
		Customer_Name = Customer_Fname +" "+ Customer_Lname;
		System.out.println(Customer_Name);

		waitForElement(2000);
		By dob = By.xpath("(//input[@id='LeadDob'])[1]");	
		if(ElementDisplayed(dob)) {
			writeText(dob,"12/12/2001" +Keys.ENTER);		 
			waitForElement(2000);
		}
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000);
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		writeText(CustMail,"lohi."+randomName()+"@yopmail.com");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1,"Testing");
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);
		writeText(PrincipalZipCode,"33233");
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(2000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Clicked on Submit");	
		//				WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Proceed with Customer creation')]"));
		//				
		//		        // Check if the element is displayed
		//		        if(element.isDisplayed()) {
		//		            // Click on the element
		//		element.click();
		//		        } else {
		//		            System.out.println("Element is not displayed, so cannot click.");
		//		        }

		//create a new policy
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		RefreshPage();
		waitForElement(10000);
		ClickOnMinimizeCallwindow();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
		MoveToElementClick(element);
		waitForElement(2000);
		ClickOnMinimizeCallwindow();

		By Create_Policy = By.xpath("//button[normalize-space()='Create Policy']");
		waitVisibility(Create_Policy);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Create_Policy));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Create Policy has been clicked");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory1));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AccidentLOB));
		MoveToElementClick(element);
		ExtentSuccessMessage("Medical has been selected");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		MoveToElementClick(element);	
		waitForElement(1000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier has been selected");
		waitForElement(3000);
		By CsText = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
		//By CrText = By.xpath("(//md-select-value[@class='md-select-value']//div[@class='md-text'])[2]");				
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CsText));
		String carriersName = element.getText();
		System.out.println("CarrierName: "+carriersName);

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		MoveToElementClick(element);	
		waitForElement(3000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("SalesType has been selected");
		waitForElement(2000);
		Premium_Date = "07/08/2024";
		writeText(PolicyEFDate,Premium_Date +Keys.ENTER);
		waitForElement(4000);
		waitVisibility(PolicyStatus);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
		MoveToElementClick(element);	
		waitForElement(2000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("PolicyStatus has been selected");
		waitForElement(3000);
		By Premium_Amount =  By.xpath("(//input[@name='TotalResAmount'])[1]");
		waitVisibility(Premium_Amount);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Premium_Amount));
		MoveToElementClick(element);
		String Amount = "2000";
		writeText(Premium_Amount,Amount);

		By AOR_Search = By.xpath("//button[@ng-click=\"$parent.aorSearchLookup('AgentName', 'CreateAssetForm')\"]//i[@class='glyphicon glyphicon-search']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		MoveToElementClick(element);
		waitForElement(4000);
		By AOR_Text = By.xpath("//input[@class='pull-right ng-pristine ng-untouched ng-valid ng-empty']");
		waitVisibility(AOR_Text);
		element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
		writeText(AOR_Text,"Auto");
		By AOR_Textsearch = By.xpath("(//i[@class='glyphicon glyphicon-search'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AOR_Textsearch));
		MoveToElementClick(element);
		waitForElement(4000);
		By Select_Agent = By.xpath("(//input[@name='selectedAgent'])[1] | //input[@class='ng-pristine ng-valid ng-empty ng-touched']");
		waitVisibility(Select_Agent);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_Agent));
		MoveToElementClick(element);
		waitForElement(1000);
		By Agenet = By.xpath("(//*[@ng-repeat='agentRecord in agentRecords']//label)[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agenet));
		String AgentN = element.getText();
		String Agentname[] =AgentN.split(",");
		System.out.println("AgentName ="+Agentname[0]);
		By click_ok = By.xpath("//button[normalize-space()='OK']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(click_ok));
		MoveToElementClick(element);

		ExtentSuccessMessage("AOR has been selected");			
		waitForElement(4000);
		waitVisibility(PolicySubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy submit");
//		By Success_msg = By.xpath("//div[@id='divSuccesss']");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
//		String msg =GetElementText(Success_msg);
//		Assert.assertEquals(msg, "Policy created successfully.");
		ExtentSuccessMessage("New policy has been created and validated the success message");

		//Asserting the policy 
		waitForElement(6000);
		By Agent_Top = By.xpath("//a[@id='menu_Agency']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Agent_Top));
		MoveToElementClick(element);

		By Drop_Carrier = By.xpath("//a[@id='submenu_agencycarrier']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Drop_Carrier));
		MoveToElementClick(element);
		waitForElement(1000);
		By Search = By.xpath("/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[3]/div[1]/h1[1]/div[1]/div[3]/div[1]/form[1]/md-autocomplete[1]/md-autocomplete-wrap[1]/md-input-container[1]/input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		String Atena_Phno = "(800) 872-3862";	
		String URL= driver.getCurrentUrl();
		System.out.println(URL);
		if(URL.contains("https://mme.brokerengage.net/mme/")) {
			Atena_Phno = "(000) 872-3862";
		}	
		if(carriersName.equals("Aetna")) {
			writeText(Search ,  Atena_Phno+ Keys.ENTER);
		}else {
			writeText(Search ,  carriersName+ Keys.ENTER);
		}
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClicKCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on carrier name");
		waitForElement(3000);
		waitVisibility(Policies);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Policies Tab has been clicked");
		waitForElement(4000);

		try {
			By Cust_Name = By.xpath("//a[normalize-space()='"+Customer_Name+"']");
			waitVisibility(Cust_Name);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Cust_Name));
			ExtentSuccessMessage("Customer name is validated in policies");

			By Carriername = By.xpath("(//*[normalize-space()='"+carriersName+"'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Carriername));
			ExtentSuccessMessage("Carrier name is validated in policies");

			By ProductCategory = By.xpath("(//div[@title='Medical'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
			ExtentSuccessMessage("Product Category is validated in policies");

			By AgentName = By.xpath("(//a[@class='edit-list-anchor ng-binding'][normalize-space()='"+Agentname[0]+"'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentName));
			ExtentSuccessMessage("Agent name is validated in policies");

			By Status = By.xpath("(//div[@title='Active'][normalize-space()='Active'])[2]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
			ExtentSuccessMessage("Status is validated in policies");

			By P_Amount = By.xpath("(//div[@title='$2000.00'][normalize-space()='$2000.00'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(P_Amount));
			ExtentSuccessMessage("Premium Amount  is validated in policies");

		} catch (NoSuchElementException e) {
			ExtentSuccessMessage("NoSuchElement Exception");
		}
		catch (Exception e) {
			ExtentSuccessMessage("Catch Exception");
		}
	}

}