package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Utility.ExcelHelper;

public class SalesLeadPage extends BasePage {
	public SalesLeadPage(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
	public String fullname;
	public String NoteText;
	public String name;

	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");

	private By ActionEmailIcon = By.xpath("(//i[@class='fa fa-envelope'])");
	private By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
//	private By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
	private By EmailConfirmationButton = By
			.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionAttachment = By.xpath("(//i[@class='fa fa-paperclip'])[1]");
	private By DocumentDD = By
			.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[1] | //*[@id=\"filter-by\"]/div[1]/form/div[1]/select\\");
	private By DocumentDDOption = By.xpath("//option[text()='Other']");
	private By DocumentAttachFileButton = By
			.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
	private By AttachmentConfirmationButton = By
			.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionTask = By.xpath("(//i[@class='fa fa-calendar'])[1]");
	private By ActivityDD = By
			.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	private By PriorityDD = By
			.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.w-47.custom-label > select");
	private By CommentTextArea = By.xpath(
			"//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
	private By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
	private By AgentEmailInc = By.cssSelector("#fixed > ul > li");
	By NotesSection = By.xpath(
			"//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	By Lead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By SalesButton = By.xpath("//span[text()='Sales ']");
	By Leads = By.xpath("(//a[text()='Leads'])[2]");
	By NewLead = By.xpath("//button[@name='newLeadBtn' and @id='newLeadBtn'] ");
	By NewLeadFirstName = By.xpath("//input[@id='LeadFirstName']");
	By NewLeadLastName = By.xpath("//input[@id='LeadLastName']");
	By DOB = By.xpath("//input[@id='Dob']");
	By Gender = By.xpath("//label[text()='Gender ']");
	By Male = By.xpath("//div[text()='Male']");
	By Phnum = By.xpath("//input[@name='LeadMobile']");
	By Email = By.xpath("//input[@id='LeadEmail']");
	By LeadInformation = By.xpath("//div[@id='formFlag2']");
	By HomeorPrincipals = By.xpath("//div[@id='formFlag3']");
	By HomeZipCode = By.xpath("//input[@name='ZipCode']");
	By Adress = By.xpath("//input[@id='AddressLine1'and @name ='AddressLine1']");
	By OtheInformation = By.xpath("//div[@id='formFlag5']");
	By submit = By.xpath("(//button[text()='Submit'])[7]");
	By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By LeadAssign = By.xpath("//button[@id='Assign']");
	By EditIcon = By.xpath("//button[@id='editLeadsBtn']");
	By StatusSelect = By.xpath("//select[@class='md-visually-hidden']");
	By ButtonSave = By.xpath("//button[text()='Save']");

	By LeadQualify = By.xpath("//button[@id='Qualify']");
	By LeadReject = By.xpath("//button[@id='Reject']");
	By LeadDispose = By.xpath("//button[@id='Call']");
	By Convert = By.xpath("//button[@id='Convert']");
	By MedicalDropdown = By.xpath("//md-select[@id='select_331']");
	By Medical = By.xpath("(//div[text()='Medical']/parent::md-option)[2]");
	By ConvertSubmit = By.xpath("//button[text()='Submit']");
	By SalesLeadNotes = By.xpath("//textarea[@name='desc']");
	By SaveNote = By.xpath("//button[@type='submit']/child::i");
	By SalesEmail = By.xpath("//i[@class='fa fa-envelope']/parent::a");
	// By SalesEmailID = By.xpath("//input[@placeholder='Add email address']");

	By SalesEmailID = By.xpath("//md-chips[@placeholder='Add email address']");
	By EmailSubject = By.xpath("//input[@placeholder='Add a subject']");
	By SaveEmail = By.xpath("//i[@class='fa fa-check yellow green']/parent::button");
	By SalesTask = By.xpath("//i[@class='fa fa-calendar']/parent::a");
	By TaskSave = By.xpath("//i[@class='fa fa-check yellow green']");
	By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
	By AttachFile = By.xpath("//i[@class='fa fa-paperclip']/parent::a");
	By AttachDropDown = By.xpath("//div[@class='form-group ng-isolate-scope']/child::select");
	By AddressSave = By.xpath("//i[@class='fa fa-check yellow green']");
	By StatusLead = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[7]");
	By StausUnqualified = By.xpath("//span[text()='Unqualified']");
	By StatusAccepted = By.xpath("//span[text()='Accepted']");
	By StatusConverted = By.xpath("//span[text()='Converted']");
	By StatusQualified = By.xpath("//span[text()='Qualified']");
	By AdvancedSearch = By.xpath("//button[@id='advancedSearchBtn']");
	By AdvancedLeadStatus = By.xpath("//md-select[@id='LeadStatus']");
	By SelectAccepted = By.xpath("//md-option[@value='Accepted']");
	By SelectUnqualified = By.xpath("//md-option[@value='Unqualified']");
	By SelectConverted = By.xpath("//md-option[@value='Converted']");
	By SelectQualified = By.xpath("//md-option[@value='Qualified']");
	By SelectReject = By.xpath("//md-option[@value='Rejected']");
	By AdvanceSubmit = By.xpath("//button[@id='advancedSearchSubmitBtn']");
	By SalesOpportunities = By.xpath("(//a[text()='Opportunities'])[2]");
	By NewOpportunity = By.xpath("//button[@id='newOpportunityBtn']");
	By OpportunityName = By.xpath("(//input[@name='CustomerName'])[2]");
	By SalesSearchIcon = By.xpath("(//button[@class='btn btn-default green'])[4]");
	By RadioButtonSelect = By.xpath("//input[@type='radio']");
	By ButtonOk = By.xpath("//button[text()='OK']");
	By SubmitOk = By.xpath("(//button[contains(text(),'Submit')])[5]");
	By OpportunityQuote = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By OpportunityEffectiveDate = By.xpath("//input[@name='EffectiveDate']");
	By OptZipCode = By.xpath("//input[@name='Zip']");
	By OPtStatus = By.xpath("//md-select[@name='CRMNewQuoteStatus']");
	By OptSubStaus = By.xpath("//md-option[@value='Created']");
	By Optsubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By Optqualify = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[3]");
	By Optsubmit2 = By.xpath("//button[text()='Submit']");
	By CloseDeal = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[1]");
	By CloseDealStatus = By.xpath("//md-select[@name='CloseDealStatus']");
	By CloseOption = By.xpath("//md-option[@value='Close as Won']");
	By OpportunityStatus = By.xpath("//md-select[@id='CRMOpportunityStatus']");
	By OpportunityOpen = By.xpath("//md-option[@value='Open']");
	By OpportunityCloseAsLost = By.xpath("//md-option[@value='Closed as Lost']");
	By OpportunityCloseWon = By.xpath("//md-option[@value='Closed as Won']");
	By OppQualify = By.xpath("//md-option[@value='Qualified']");
	By OppRenewal = By.xpath("//md-option[@value='Renewed']");
	By OppCancel = By.xpath("//md-option[@value='Cancelled']");
	By OppSearch = By.xpath("//button[@id='applyadvancedSearchBtn']");
	By Oppstatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By OppCancel2 = By.xpath("//md-checkbox[@value='Cancelled']");
	By OppCloseW = By.xpath("//md-checkbox[@value='Closed as Lost']");
	By OppOpen = By.xpath("//md-checkbox[@value='Open']");
	By OppQualified = By.xpath("//md-checkbox[@value='Qualified']");
	By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");
	By InstallPolicy = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[1]");
	By AorSearch = By.xpath("//button[@class='btn btn-default green']");
	By AorText = By.xpath("//input[@ng-model='searchText']");
	By SearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By AorRadioButton = By.xpath("//input[@name='selectedAgent']");
	By Okbutton = By.xpath("//button[text()='OK']");
	By SubmitQuote = By.xpath("//button[text()='Submit']");
	//By CancelQuote = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[2] | //button[normalize-space()='Cancel/Expire Quote']");
	By CancelQuote = By.xpath("//button[normalize-space()='Cancel/Expire Quote']");
	By SelectStatus = By.xpath("//md-select[@name='TerminateQuoteStatus']");
	By SelectCancel = By.xpath("//md-option[@value='Terminated']");
	By ActualRevenu = By.xpath("//input[@name='ActualRevenue']");
	By Textarea = By.xpath("//textarea[@name='Reason']");
	By Submit = By.xpath("//button[text()='Submit'] | //button[@class='btn btn-default green pull-right']");
	By Termination_Date = By.xpath("//input[@name='TerminationDate']");
	By QuoteStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By Quotestatus = By.xpath(
			"//body//div[@id='sticky']//div[@class='ng-scope']//div[@class='ng-scope']//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//i[1]");
	By QuoteCancel = By.xpath("//md-checkbox[@value='Cancelled']");
	By QuoteCreated = By.xpath("//md-checkbox[@value='Created']");
	By QuoteDeclined = By.xpath("//md-checkbox[@value='Declined']");
	By QuoteExpire = By.xpath("//md-checkbox[@value='Expired']");
	By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
	By SalesEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	By AttachmentInc = By.cssSelector("#fixed > ul > li");
	By Edit_icon = By.xpath("//i[contains(@class,'btn fa fa-pencil')]");
	By search = By.xpath("//input[@type='search'][@aria-label='Search your text']");
	By Recent_Quotes = By.xpath("//div[@id='filter-by']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//i[1]");
	By CreatedToday = By.xpath("//md-radio-button[@aria-label='Created Today']//div[@class='md-off']");
	By Reset = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
	By save = By.xpath("//button[normalize-space()='Save']");
	By plan_name = By.xpath("//input[@type='text'][@name='BusinessPackageId']");
	By original_rate = By.xpath("//input[@type='text'][@name='TotalPremium']");
	By premium_amount = By.xpath("//input[@type='text'][@name='TotalResAmount']");

	By QuoteInprogress = By.xpath("//md-checkbox[@value='In Progress']");
	By QuoteInactive = By.xpath("//md-checkbox[@value='Inactive']");
	By QuoteInstallinprogress = By.xpath("//md-checkbox[@value='Install In Progress']");
	By QuoteInstall = By.xpath("//md-checkbox[@value='Installed']");
	By QuoteTerminated = By.xpath("//md-checkbox[@value='Terminated']");
	By QuoteAdStatusDD = By.xpath("//md-select[@name='QuoteStatus']");
	By QuoteAdCancel = By.xpath("//md-option[@value='Cancelled']");
	By QuoteAdCreated = By.xpath("//md-option[@value='Created']");
	By QuoteAdDeclined = By.xpath("//md-option[@value='Declined']");
	By QuoteAdExpired = By.xpath("//md-option[@value='Expired']");
	By QuoteAdInActive = By.xpath("//md-option[@value='Inactive']");
	By QuoteAdInProgress = By.xpath("//md-option[@value='In Progress']");
	By QuoteAdInstalled = By.xpath("//md-option[@value='Installed']");
	By QuoteAdInstallInProgress = By.xpath("//md-option[@value='Install In Progress']");
	By QuoteAdTerminated = By.xpath("//md-option[@value='Terminated']");
	By QuoteAdSearch = By.xpath("//button[@id='applyadvancedSearchBtn']");
	By SalesPolicy = By.xpath("(//a[text()='Policies'])[2]");
	By CreatePolicy = By.xpath("//button[@class='btn btn-default pull-left btn-yellow']");
	By PolicySearchIcon = By.xpath("//i[@class='glyphicon glyphicon-search']");
	By PolicySearchText = By.xpath("//input[@ng-model='searchText']");
	By PolicyCustmerSearchIcon = By.xpath("//button[@title='Search Customer']");
	By SelectCustmer = By.xpath("//input[@ng-model='data.selectedCustomer']");
	By CustomerOk = By.xpath("//button[text()='OK']");
	By ProductCategory = By.xpath("(//md-select[@id='CRMProductCategory'])[2]");
	By MedicalLOB = By.xpath("(//md-option[@value='Medical'])[3]");
	By Carrier = By.xpath("//md-select[@id='Carrier']");
	By SelectCarrier = By.xpath("(//md-option[@value='Aetna'])[2]");
	By SalesType = By.xpath("//md-select[@id='salesType']");
	By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
	By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	By PolicyActive = By.xpath("(//md-option[@value='Active'])[4]");
	By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	By AorOk = By.xpath("//button[text()='OK']");
	By PolicySubmit = By.xpath("(//button[text()='Submit'])[5]");
	By PolicyCancel = By.xpath("//button[@class='btn btn-default pull-right ng-binding ng-scope']");
	By PolicyCancelDD = By.xpath("//md-select[@name='TerminateAssetStatus']");
	By PolicyDDStatus = By.xpath("//md-option[@value='Terminated']");
	By PolicyCancelSubmit = By.xpath("//button[text()='Submit']");
	By PolicyFilterStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By PolicyStatusCancel = By.xpath("//md-checkbox[@value='Cancelled']");
	By PolicyStatusEnrolled = By.xpath("//md-checkbox[@value='Enrolled']");
	By PolicyEnrolledPlaylater = By.xpath("//md-checkbox[@value='Enrolled-Paylater']");
	By PolicyStatusFullfill = By.xpath("//md-checkbox[@value='Fulfilled']");
	By PolicyStatusInProgress = By.xpath("//md-checkbox[@value='In Progress']");
	By PolicyStatusInActive = By.xpath("//md-checkbox[@value='Inactive']");
	By PolicyInComplete = By.xpath("//md-checkbox[@value='Incomplete']");
	By PolicyLockEligibility = By.xpath("//md-checkbox[@value='Locked-Eligibility']");
	By PolicyLockPayment = By.xpath("//md-checkbox[@value='Locked-Payment']");
	By PolicyLockEnrollment = By.xpath("//md-checkbox[@value='Locked-Enrollment']");
	By PolicyLockFullfillment = By.xpath("//md-checkbox[@value='Locked-Fulfillment']");
	By PolicyNeedinfo = By.xpath("//md-checkbox[@value='Need-More-Information']");
	By PolicyPending = By.xpath("//md-checkbox[@value='Pending Cancellation']");
	By PendingDE = By.xpath("//md-checkbox[@value='Pending-DE-Automation']");
	By PremiumPaid = By.xpath("//md-checkbox[@value='PremiumPaid']");
	By PolicystatusSubmit = By.xpath("//md-checkbox[@value='Submitted']");
	By PolicyTerminated = By.xpath("//md-checkbox[@value='Terminated']");
	By PolicyADDropdown = By.xpath("//md-select[@id='CRMPolicyStatus']");
	By PolicyADCancel = By.xpath("//md-option[@value='Cancelled']");
	By PolicyTestMM = By.xpath("//md-option[@value='TestMM status']");
	By PolicyEnrolled = By.xpath("//md-option[@value='Enrolled']");
	By PolicyEnrollPaylater = By.xpath("//md-option[@value='Enrolled-Paylater']");
	By PolicyFullfill = By.xpath("//md-option[@value='Fulfilled']");
	By PolicyInProgress = By.xpath("//md-option[@value='In Progress']");
	By PolicyAdInActive = By.xpath("//md-option[@value='Inactive']");
	By PolicyAdIncomplete = By.xpath("//md-option[@value='Incomplete']");
	By PolicyLockedEligibility = By.xpath("//md-option[@value='Locked-Eligibility']");
	By PolicyAdLockedEnrollment = By.xpath("//md-option[@value='Locked-Enrollment']");
	By PolicyAdLockedFullfillment = By.xpath("//md-option[@value='Locked-Fulfillment']");
	By PolicyNeedmoreInfo = By.xpath("//md-option[@value='Need-More-Information']");
	By PolicyAdPending = By.xpath("//md-option[@value='Pending']");
	By PolicyAdPendeningCancellation = By.xpath("//md-option[@value='Pending Cancellation']");
	By PolicyAdPendingDEAutomation = By.xpath("//md-option[@value='Pending-DE-Automation']");
	By PolicyAdPremiumPaid = By.xpath("//md-option[@value='PremiumPaid']");
	By PolicyAdSubmitted = By.xpath("//md-option[@value='Submitted']");
	By PolicyAdTerminated = By.xpath("//md-option[@value='Terminated']");
	By ImportCustmerPolicies = By.xpath("//button[@class='btn btn-yellow dropdown-toggle pull-right']");
	By BulkImport = By.xpath("//button[@id='bulkImportBtn']");
	By SelectFile = By.xpath("(//div[text()='Select File'])[1]");
	By FileSubmit = By.xpath("//button[@id='importPolicySubmitBtn']");
	By FileSubmitOk = By.xpath("//button[text()='OK']");
	By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	// By ContactInfo = By.xpath("(//div[@class='accordion-container'])[2]");
	By ContactInfo = By
			.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");

	By PrincipalAdress = By
			.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
	By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By CreateServiceRequest = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[1]");
	By RequestType = By.xpath("//md-select[@name='SrType']");
	By RequestStatus = By.xpath("//md-option[@value='New Enrollment']");
	By RequestSubType = By.xpath("//md-select[@name='SRActivitySubType']");
	By RequestSubStatus = By.xpath("//md-option[@value='Referral']");
	By RequestSubmit = By.xpath("(//button[text()='Submit'])[5]");
	By CustomerFilterStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[4]");
	By CustomerFilActive = By.xpath("//md-checkbox[@value='Active']");
	By CustomerInActive = By.xpath("//md-checkbox[@value='Inactive']");
	By CustomerFilProspet = By.xpath("//md-checkbox[@value='Prospect']");
	By CustomerFilDecesed = By.xpath("//md-checkbox[@value='Deceased']");
	By CustomerADSearchDD = By.xpath("//md-select[@id='Status']");
	By CustomerAdActive = By.xpath("//md-option[@value='Active']");
	By CustomerAdInActive = By.xpath("//md-option[@value='Inactive']");
	By CustomerAdprospect = By.xpath("//md-option[@value='Prospect']");
	By CustomerAdDecesed = By.xpath("//md-option[@value='Deceased']");
	By CustomerImport = By.xpath("//button[@id='importCustomerPolicyBtn']");
	By CustomerBulkImport = By.xpath("//button[@name='bulkImportBtn']");
	By CustomerImportSubmit = By.xpath("//button[@id='uploadBobImportBtn']");
	By CustomerContact = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By CustomerSendContactCard = By.xpath("//button[@title='Send Contact Card']");
	By CustomerContactSend = By.xpath("//button[text()='Send']");
	By Service = By.xpath("//a[@class='glyphicon fa fa-fw fa-gears']");
	By NewServiceReq = By.xpath("//button[@id='createServiceRequestBtn']");
	By SearchTextCustomer = By.xpath("//input[@name='Customer']");
	By CustomerSearchIcon = By.xpath("//button[@class='btn btn-default green']/child::i");
	By SelectCustomer = By.xpath("//input[@name='selCustomer']");
	By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
	By ServiceCustomerOk = By.xpath("//button[text()='OK']");
	By ServiceRqtypeDD = By.xpath("//md-select[@name='SrType']");
	By SelectRq = By.xpath("(//md-option[@value='New Enrollment'])[3]");
	By ServiceRqSubtypeDD = By.xpath("//md-select[@name='SRActivitySubType']");
	By ServiceRqSubStstus = By.xpath("//md-option[@value='Referral']");
	By ServiceProductDD = By.xpath("(//md-select[@name='SRProduct'])[2]");
	By ServiceProductCE = By.xpath("(//md-option[@value='CE'])[2]");
	By ServiceActionByDD = By.xpath("//md-select[@name='SRActionedBy']");
	By SelectActionByQA = By.xpath("//md-option[@value='QA']");
	By SelectSubmit = By.xpath("(//button[text()='Submit'])[2]");
	By SelectService = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By AddActivity = By.xpath("//button[@name='AddActivity']");
	By ActivityTypeDD = By.xpath("//select[@class='ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']");
	By SaveAct = By.xpath("//button[text()='Save']");
	By ServiceFilter = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[4]");
	By ServiceNew = By.xpath("//md-checkbox[@value='New']");
	By ServiceAssigned = By.xpath("//md-checkbox[@value='Assigned']");
	By ServiceInProgress = By.xpath("//md-checkbox[@value='In Progress']");
	By Servicehold = By.xpath("//md-checkbox[@value='On Hold']");
	By ServiceReopen = By.xpath("//md-checkbox[@value='Re-open']");
	By ServiceRejected = By.xpath("//md-checkbox[@value='Rejected']");
	By ServiceClosed = By.xpath("//md-checkbox[@value='Closed']");
	By ServicePending = By.xpath("//md-checkbox[@value='Pending']");
	By ServiceADDD = By.xpath("//md-select[@name='SRStatus']");
	By ServiceADNew = By.xpath("//md-option[@value='New']");
	By ServiceADAssign = By.xpath("//md-option[@value='Assigned']");
	By ServiceADInProgress = By.xpath("//md-option[@value='In Progress']");
	By ServiceADInHold = By.xpath("//md-option[@value='On Hold']");
	By ServiceADReopen = By.xpath("//md-option[@value='Re-open']");
	By ServiceADReject = By.xpath("//md-option[@value='Rejected']");
	By ServiceADClose = By.xpath("//md-option[@value='Closed']");
	By ServiceADPending = By.xpath("//md-option[@value='Pending']");
	By ServiceExport = By.xpath("//button[@name='downlodDataBtn']");
	By ServieCloseSR = By.xpath("//button[@name='editServiceRequestBtn']");

	By checklead = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
	By managelead = By.xpath("//button[@id='manageLeadsBtn']");
	By deletelead = By.xpath("//button[@id='deleteLeadsBtn']");
	By clickyes = By.xpath("//button[normalize-space()='Yes']");
	By menusales = By.xpath("//a[@id='menu_Sales']");
	By submenuleads = By.xpath("//a[@id='submenu_salesleads']");
	By delete_task = By.xpath("//i[@ng-click='deleteTask(activity, false)']");
	By click_ok = By.xpath("//span[normalize-space()='Ok']");
	By sales_leads = By.xpath("//a[normalize-space()='Sales - Leads']");
	
	By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");

	Base_Class Base_Class = new Base_Class();

	public String randomName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void cttMinimize() throws InterruptedException {

		waitForElement(1000);
		WebElement CTIPad = null;

		try {

			CTIPad = driver.findElement(By.xpath("//div[@class='voice-call-dial-pad']"));

			if (CTIPad.isDisplayed()) {
				click(CTIMinimizeIcon);
				ExtentSuccessMessage("CTI Icon is Minimized");

			} else {
				ExtentSuccessMessage("User dont have CTI Login");

			}
		} catch (NoSuchElementException e) {
			ExtentSuccessMessage("User dont have CTI Login and login is succesfull");

		}

	}

	public void serviceClosingRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on close");
		waitForElement(8000);
		WebElement SelectSR = driver.findElement(By.xpath("//select[@ng-model='selectedsalesteam']"));
		Select select = new Select(SelectSR);
		// select.selectByVisibleText("TeamSR");

		select.selectByVisibleText("THIS IS TEST TEAM");
		waitForElement(8000);
		ExtentSuccessMessage("Selected THIS IS TEST TEAM");
		WebElement Ok = driver.findElement(By.xpath("//button[text()='OK']"));
		MoveToElementClick(Ok);
		ExtentSuccessMessage("Cliked on Ok");
		waitForElement(8000);
	}

	public void serviceExportRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Export");

	}

	public void serviceAdvancedSearch2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADAssign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Assign");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInHold));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InHold");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReopen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reopen");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReject));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reject");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADClose));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Close");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		/*
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000);
		 */
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Export");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseSR");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
	}

	public void serviceAdvancedSearch() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADAssign));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Assign");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInHold));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InHold");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReopen));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reopen");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReject));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reject");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADClose));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Close");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); /* waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000);
		 */
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Export");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected CloseSR");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 */
	}

	public void serviceFilter2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceFilter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceFilter");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Assigned");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Assigned");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Hold");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Reopen");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Rejected");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Closed");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Pending");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		MoveToElementClick(element);
		waitForElement(10000);

	}

	public void serviceFilter() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceFilter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceFilter");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Assigned");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Assigned");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Hold");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Reopen");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Rejected");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Closed");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Pending");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		 * MoveToElementClick(element); waitForElement(10000);
		 */

	}

	public void servicActions() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		driver.navigate().refresh();
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectService));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on SelectService");
		waitForElement(10000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);
		Thread.sleep(1000);

	}

	public void serviceAddActivity() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		driver.navigate().refresh();
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectService));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on SelectService");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddActivity));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on AddActivity");
		waitForElement(8000);
		WebElement SelectSR = driver.findElement(By.xpath("(//select[@ng-selected='item'])[1]"));
		Select select = new Select(SelectSR);
		select.selectByVisibleText("Others");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveAct));
		MoveToElementClick(element);
		waitForElement(9000);

	}

	public void serviceCreateNewService() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewServiceReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on NewServiceRequest");
		waitForElement(8000);
		writeText(SearchTextCustomer, "Automation");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerSearchIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Search Icon");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCustomer));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Selected the Customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceCustomerOk));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRqtypeDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectRq));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Selected the Request type");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRqSubtypeDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRqSubStstus));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Selected the Request sub type");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceProductDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceProductCE));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Selected the product");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceActionByDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectActionByQA));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Selected the To Be Action By");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		Thread.sleep(4000);
	}

	public void customerContactCard() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerSendContactCard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer Contact has been clicked");
		waitForElement(6000);
		// writeText(CustomerSendContactCard,);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerContactSend));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer send the contact");
		waitForElement(6000);
	}

	public void customerImportCustomerAndPolicies() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		// click(CustomerImport);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Customers and Policies");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerBulkImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import");
		waitForElement(6000);
		// element = wait.until(ExpectedConditions.elementToBeClickable(SelectFile));
		// MoveToElementClick(element);
		Base_Class.MouseClick(SelectFile);
		ExtentSuccessMessage("File has been selected");
		waitForElement(6000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerImportSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmitOk));
		MoveToElementClick(element);
		Thread.sleep(3000);

	}

	public void customerAdvancedSearch2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Active");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InActive");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdprospect));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Prospect");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdDecesed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Deceased");
		waitForElement(7000);
		click(OppSearch);

	}

	public void customerAdvancedSearch() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Active");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InActive");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdprospect));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Prospect");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdDecesed));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Deceased");
		 * waitForElement(7000); click(OppSearch);
		 */

	}

	public void customerFilter2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Filter Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Active Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the In Active Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Prospect Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Deceded Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		MoveToElementClick(element);
		waitForElement(6000);

	}

	public void customerFilter() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Filter Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Active Status");
		waitForElement(10000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		 * MoveToElementClick(element); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected the In Active Status"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		 * MoveToElementClick(element); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected the Prospect Status"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		 * MoveToElementClick(element); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected the Deceded Status"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		 * MoveToElementClick(element); waitForElement(6000);
		 */

	}

	public void customerActions() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		writeText(SalesLeadNotes, "abcdefghij");
		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com");
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);
		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);
		js.executeScript("arguments[0].dispatchEvent(new Event('change'))", dropdown);
		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(5000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);

	}

	public void customerCreateServiceRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateServiceRequest));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Service Request ");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestType));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubType));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Sub Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		waitForElement(6000);
	}

	public void customerCreateOpportunity() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(6000);

	}

	public void createNewCustomer() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		writeText(CustFName, "lohith");
		waitForElement(4000);
		writeText(CustLName, randomName());
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(6000);
		writeText(Cellphone, "9876789678");
		waitForElement(6000);
		writeText(CustMail, "lohi.11@yopmail.com");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on PrincipalAddress");
		writeText(PricipalAD1, "Testing");
		ExtentSuccessMessage("Entered the Address");
		waitForElement(6000);
		writeText(PrincipalZipCode, "33233");
		waitForElement(6000);
		ExtentSuccessMessage("Entered the ZipCode");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on Submit");
		WebElement element = driver
				.findElement(By.xpath("//button[contains(text(),'Proceed with Customer creation')]"));

		// Check if the element is displayed
		if (element.isDisplayed()) {
			// Click on the element
			element.click();
		} else {
			System.out.println("Element is not displayed, so cannot click.");
		}
		Thread.sleep(8000);
	}

	public void salespolicyImport() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ImportCustmerPolicies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Customers and Policies");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BulkImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import");
		waitForElement(6000);

		Base_Class.MouseClick(SelectFile);
		ExtentSuccessMessage("File has been selected");
		waitForElement(6000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmitOk));
		MoveToElementClick(element);
		Thread.sleep(3000);

	}

	public void salesPolicyCreateNewPolicy() throws InterruptedException, IOException, AWTException {

		waitForElement(3000);
		String URL= driver.getCurrentUrl();
		System.out.println(URL);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		String Firstname = "AutoPolicyCustomer"; 
		writeText(CustFName, Firstname);
		waitForElement(1000); 
		String Lastname = randomName();
		writeText(CustLName, Lastname); 
		 fullname = Firstname + " " + Lastname;
		writeCustomernameToExcel(fullname, "TC CE2");
		System.out.println(fullname);
		
		if(URL.contains("https://ce-qa.benefitalign.com/mme")) {
			By DOB = By.xpath("(//input[@id='LeadDob'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOB));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on DOB");
			writeText(DOB, "12/10/2001");
			Base_Class.KeyOperation("TAB");
		}
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000);
		writeText(Cellphone, generatePhoneNumber());
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");

		waitForElement(4000);
		By element2 = By.xpath("//button[contains(.,'Proceed with Customer creation')]");
		try {
			if (driver.findElement(element2).isDisplayed()) {
				click(element2);

			}
		} catch (NoSuchElementException e) { 
		} catch (Exception e) {
			ExtentSuccessMessage("Customer Created");
		}

		//change done in one place only
		Thread.sleep(8000);
		By SalesButton = By.xpath("//a[@id='menu_Sales']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales");

		By Policies = By.xpath("//a[@name='submenu_salespolicies']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policies Button");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatePolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Policy Button");

		waitForElement(4000);
		By SearchButton = By.xpath("(//button[@class='btn btn-default green'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Search Button");

		waitForElement(6000);
		By Title = By.xpath("//h5[@class='modal-title']"); 
		try {
			if (driver.findElement(Title).isDisplayed()) {
				By SearchFiled = By.xpath("//input[@class='pull-right ng-pristine ng-untouched ng-valid ng-empty']");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
				MoveToElementClick(element);
				writeText(SearchFiled, fullname);
				ExtentSuccessMessage("Searrched name on field");

				By SearchCustomer = By.xpath("//button[@title='Search Customer']");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchCustomer));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on Customer Search Button");

				Thread.sleep(3000);
				By Customer = By.xpath("//input[@name='selCustomer']");
				if(ElementDisplayed(Customer)) {
					element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
					MoveToElementClick(element);
					ExtentSuccessMessage("Clicked on Customer");
				} else {
					clear(SearchFiled);
					element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
					MoveToElementClick(element);
					writeText(SearchFiled, "Auto");
					ExtentSuccessMessage("Searrched name on field");
					element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchCustomer));
					MoveToElementClick(element);
					ExtentSuccessMessage("Clicked on Customer Search Button");
					Thread.sleep(3000);
					if(ElementDisplayed(Customer)) {
						element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
						MoveToElementClick(element);
						ExtentSuccessMessage("Clicked on Customer");
					}
				}
				By OKButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(OKButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on OK Button");
			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Customer Popup is not visible");
		}

		By ProductCategory = By.xpath("(//md-select[@name='CRMProductCategory'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);
		By Accident = By.xpath("(//md-option[@value='Accidental Insurance'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Accident));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Product Category");

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		String pc = element.getText();
		System.out.println(pc);

		By Carrier = By.xpath("(//md-select[@name='Carrier'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		MoveToElementClick(element);
		By AARP = By.xpath("(//md-option[@value='AARP MEDICARE SUPPLEMENT PLANS, INSURED BY UNITEDHEALTHCARE'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AARP));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Carrier");

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		String carrier = element.getText();
		System.out.println(carrier);

		By SalesType = By.xpath("(//md-select[@name='salesType'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		MoveToElementClick(element);
		By New = By.xpath("(//md-option[@value='New'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(New));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected SalesType");

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		String st = element.getText();
		System.out.println(st);

		By Status = By.xpath("(//md-select[@name='AssetStatus'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		By Approved = By.xpath("(//md-option[@value='Approved'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Approved));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Status");

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		String status = element.getText();
		System.out.println(status);

		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
		String formattedDate = today.format(formatter);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		calendar.add(Calendar.DATE, 1); // 17
		Date oneDayLater = calendar.getTime();
		String formattedDate1 = dateFormat.format(oneDayLater);

		Thread.sleep(15000);
		By EffectiveDate = By.xpath("(//input[@name='EffectiveDate'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EffectiveDate));
		MoveToElementClick(element);
		writeText(EffectiveDate, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Selected Date");

		
//		String currentSystemURL = driver.getCurrentUrl();
//		System.out.println(currentSystemURL);
//		
//		if(currentSystemURL.contains("https://ce-qa.benefitalign.com/"))
//		{
//		    By AorSearch = By.xpath("(//button[@class='btn btn-default green'])[7]");
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(AorSearch));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked On Aor Search");
//			waitForElement(5000);
//			By AorTitle = By.xpath("//h5[@class='modal-title']");
//			try {
//				if (driver.findElement(AorTitle).isDisplayed()) {
//					By SearchFiled = By.xpath("//input[@class='pull-right ng-pristine ng-untouched ng-valid ng-empty']");
//			        element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
//					clear(SearchFiled);
//					MoveToElementClick(element);
//					writeText(SearchFiled, "CEUser one");
//					ExtentSuccessMessage("Searrched name on field");
//
//					By SearchCustomer = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
//					element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchCustomer));
//					MoveToElementClick(element);
//					ExtentSuccessMessage("Clicked on Customer Search Button");
//					Thread.sleep(5000);
//					By Customer = By.xpath("//input[@name='selectedAgent']");
//					element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
//					MoveToElementClick(element);
//					ExtentSuccessMessage("Clicked on Customer");
//
//					By OKButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
//					element = wait.until(ExpectedConditions.presenceOfElementLocated(OKButton));
//					MoveToElementClick(element);
//					ExtentSuccessMessage("Clicked on OK Button");
//	}
//			} catch (NoSuchElementException e) {
//			} catch (Exception e) {
//				ExtentSuccessMessage("Agent Popup is not visible");
//			}
//		}
//		else {
//			ExtentSuccessMessage("Not a QA ENV");
//
//		}
		 
		
		By AorSearch = By.xpath("(//button[@class='btn btn-default green'])[7]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Aor Search");
		waitForElement(5000);
		By AorTitle = By.xpath("//h5[@class='modal-title']");
		try {
			if (driver.findElement(AorTitle).isDisplayed()) {
				//By SearchFiled = By.xpath("//input[@class='pull-right ng-pristine ng-untouched ng-valid ng-empty']");
				By SearchFiled = By.xpath("//input[@ng-model='searchText']");
		        element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
				clear(SearchFiled);
				MoveToElementClick(element);
				writeText(SearchFiled, "Auto");
				ExtentSuccessMessage("Searrched name on field");
				By SearchCustomer = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchCustomer));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on Customer Search Button");
				Thread.sleep(15000);
				By Customer = By.xpath("//input[@name='selectedAgent']");
				//waitVisibility(Customer);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on Customer");
				By OKButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(OKButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on OK Button");
			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Agent Popup is not visible");
		}	

	
		By Submit = By.xpath("(//button[@class='btn btn-default green'])[10]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");

		Thread.sleep(15000);

		By InputFiled = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InputFiled));
		MoveToElementClick(element);
		writeText(InputFiled, fullname + Keys.ENTER);
		ExtentSuccessMessage("Entered Customer Name");

		Thread.sleep(3000);
		By CSName = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CSName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Customer");

		Thread.sleep(3000);
		By CSNameAssertion = By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-6 col-lg-6'][1]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CSNameAssertion));
		String nameass = element.getText();
		System.out.println(nameass);

		Assert.assertEquals(nameass, fullname);
		ExtentSuccessMessage("Assertion for name is been done");

		By PCAssertion = By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-6 col-lg-6'][3]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PCAssertion));
		String pcass = element.getText();
		System.out.println(pcass);

		Assert.assertEquals(pcass, pc);
		ExtentSuccessMessage("Assertion for Product Category is been done");

		By CarrierAss = By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-6 col-lg-6'][4]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierAss));
		String carrierass = element.getText();
		System.out.println(carrierass);

		Assert.assertEquals(carrierass, carrier);
		ExtentSuccessMessage("Assertion for Carrier name is been done");

		Thread.sleep(2000);
		
		By EditPolicy = By.xpath("//i[@class='btn fa fa-pencil']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Edit Policy Button");
		
		By PloicyFees = By.xpath("//input[@name='processingFee']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PloicyFees));
		MoveToElementClick(element);
		String fees = "" +getRandomNumber1();
		System.out.println(fees);
		writeText(PloicyFees,fees);
		
		By SaveButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Save Button");
		
        Thread.sleep(10000);
        
        By ChangesLog = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(11) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(2) > div > ul > li:nth-child(7) > a");  
        waitVisibility(ChangesLog);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(ChangesLog));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Chnages Log");
		
		Thread.sleep(3000);
		
		By UpdateValue = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		waitVisibility(UpdateValue);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(UpdateValue));
        String value = element.getText();
        System.out.println(value);
        
        Assert.assertTrue(value.contains(fees));
		ExtentSuccessMessage("Assertion for Fess in done in ChangesLog");

		Thread.sleep(5000);
		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		Thread.sleep(10000);
		salesactions();
		
		By TerminatePolicy = By.xpath("//button[@class='btn btn-default pull-right ng-binding ng-scope'][1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TerminatePolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Terminate Policy Button");

		By PolicyStatus = By.xpath("//md-select[@name='TerminateAssetStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
		MoveToElementClick(element);
		By Terminate = By.xpath("//md-option[@value='Terminated']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminate));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Terminate");

		By TerminateDate = By.xpath("//input[@name='AssetTerminationDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TerminateDate));
		MoveToElementClick(element);
		writeText(TerminateDate, formattedDate1 + Keys.ENTER);
		ExtentSuccessMessage("Clicked On Terminate Date");

		By SubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");

		Thread.sleep(4000);
		By Terminated = By.xpath("//span[@class='unqualified ng-binding rejected']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminated));
		String terminate = element.getText();
		System.out.println(terminate);

		Thread.sleep(2000);
		Assert.assertEquals(terminate, "Terminated");
		ExtentSuccessMessage("Assertion for Terminate is done at TOP");

		By TerDate = By.xpath("//div[@class='form-group view-page plans'][4]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TerDate));
		String terminatedate = element.getText();
		System.out.println(terminatedate);

		Assert.assertEquals(terminatedate, formattedDate1);
		ExtentSuccessMessage("Assertion for Terminate Date is done at TOP");

		By Terminatedd = By.xpath("//div[@class='col-xs-12 col-sm-12 col-md-6 col-lg-6'][34]/span | //span[@label='$parent.assetInformationData.Status']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminatedd));
		String terminatedd = element.getText();
		System.out.println(terminatedd); 

		Assert.assertEquals(terminatedd, "Terminated");
		ExtentSuccessMessage("Assertion for Terminate is done in basic Information");

	}
	
	public void policy_Filter(CensusInfo ApplicantInfo) throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Tile");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy ");

		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}


		Thread.sleep(3000);
		driver.navigate().refresh();
		
		waitForElement(14000); 
		By RecentPolicies = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentPolicies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Policy ");

		waitForElement(9000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created Today");

		waitForElement(3000);
		By PolicyStatus = By.xpath("(//div[@class='accordion-container grid-style-height'])[3]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy Status");

		waitForElement(5000); 
		By Terminate = By.xpath("//md-checkbox[@name='Terminated']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminate));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Terminate Option");

		By PolicyName = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyName));
		String text = element.getText(); 
		System.out.println(text);
		System.out.println(ApplicantInfo.PolicyName);

		Assert.assertEquals(text, ApplicantInfo.PolicyName);
		ExtentSuccessMessage("Terminated Policy which is Created is been Visible after Applying Filter");

		By ExportPolicy = By.xpath("//button[@name='downlodDataBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ExportPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Export Policy Option");

		Thread.sleep(3000);
		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Search button");

		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
		String formattedDate = today.format(formatter);
		By EffectiveStartDate = By.xpath("//input[@name='EffectiveStartDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EffectiveStartDate));
		MoveToElementClick(element);
		writeText(EffectiveStartDate, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Advance Search button");

		By PolicyStatus1 = By.xpath("//md-select[@name='CRMPolicyStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus1));
		MoveToElementClick(element);
		By Terminate1 = By.xpath("//md-option[@value='Terminated']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminate1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy Status ");

		By SearchButton = By.xpath("//button[@name='applyadvancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");

		Thread.sleep(5000);
		By Policy = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policy));
		String policy = element.getText();
		System.out.println(policy);

//		Assert.assertEquals(policy, ApplicantInfo.PolicyName);
		ExtentSuccessMessage("Terminated Policy which is Created is been Visible after Applying Advance Search");

		By Customer = By.xpath("//a[@id='menu_customers']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Button");

		Thread.sleep(4000);
		By Input = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Input));
		MoveToElementClick(element);
		writeText(Input,ApplicantInfo.PolicyName + Keys.ENTER);
		ExtentSuccessMessage("Customer Searched on Input Field");

		
		Thread.sleep(5000);
		By LeadField = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadField));
		MoveToElementClick(element);
		
		By ManageCustomer = By.xpath("//button[@id='manageCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ManageCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Manage Customer Button");
		
		By Deletebutton = By.xpath("//button[@name='deleteCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Deletebutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");
		
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been Deleted");
		
		Thread.sleep(3000);
		
	}


	

	public String writeCustomernameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 5;
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

	public String writeQuotesnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 9;
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

	public String writePolicynameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 7;
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




	public void SalesQuotesFilters(CensusInfo ApplicantInfo) throws InterruptedException {

		waitForElement(3000);
		waitVisibility(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		
//		Thread.sleep(3000);   //Jenkins
//		driver.navigate().refresh();
//		Thread.sleep(8000);
//
//		By RecentLead = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentLead));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on RecentLead");
//
//		Thread.sleep(1000);
//		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Crated Today Lead");
//
//		Thread.sleep(15000);
//		if(ElementDisplayed(maximize))
//		{
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Maximize");
//		}
		
		
//		if(ElementDisplayed(maximize))
//		{
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Maximize");
//		}
//		waitForElement(33000);
//		By RecentQuotes = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
//		if(ElementDisplayed(RecentQuotes)) {
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentQuotes));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Recent Quotes Option");
//		} else {
//			RefreshPage();
//			ExtentSuccessMessage("Page Refresh");
//			waitForElement(30000);
//			waitVisibility(RecentQuotes);
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentQuotes));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Recent Quotes Option");
//		}	
//		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
//		waitVisibility(CreatedToday);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Created Today Option");
//		Thread.sleep(3000);
//		if(ElementDisplayed(maximize))
//		{
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Maximize");
//		}
//		Thread.sleep(5000);
//		By ProductCategory = By.xpath("(//div[@class='accordion-container grid-style-height'])[4]");
//		waitVisibility(ProductCategory);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Product Category Option");
//		
//		By Medical = By.xpath("//md-checkbox[@name='Medical']");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Medical));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Medical Option");
//		
//		Thread.sleep(15000);
//		if(ElementDisplayed(maximize))
//		{
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Maximize");
//		}
//		Thread.sleep(9000);
		
		
		waitForElement(38000); 
		By RecentQuotes = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		waitVisibility(RecentQuotes);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentQuotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Quotes Option");
		
		waitForElement(6000); 
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		waitVisibility(CreatedToday);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created Today Option");
		
		Thread.sleep(2000);
		By ProductCategory = By.xpath("(//div[@class='accordion-container grid-style-height'])[4]");
		waitVisibility(ProductCategory);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Product Category Option");
		
		By Medical = By.xpath("//md-checkbox[@name='Medical']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Medical));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Medical Option");
	
		By QuotesAss = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss));
		String quotes =element.getText();
		System.out.println(quotes);
		
		System.out.println(ApplicantInfo.Quotes);
		Assert.assertEquals(quotes, ApplicantInfo.Quotes);
		ExtentSuccessMessage("Quotes which is Created Today is Visible after using Filter");

		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");
		
		Thread.sleep(4000);
		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Search Button");
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
		String formattedDate = today.format(formatter);
		By CreatedToday1 = By.xpath("//input[@name='CreatedStartDate']");
		waitVisibility(CreatedToday1);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday1));
		MoveToElementClick(element);
		writeText(CreatedToday1,formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Entered Created Date of Quotes");
		
		By ProductCategory1 = By.xpath("//md-select[@name='ProductCategory']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory1));
		MoveToElementClick(element);
		By Medical1 = By.xpath("//md-option[@value='Medical']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Medical1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Product Category");
		
		By QuotesStaus = By.xpath("//md-select[@name='QuoteStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesStaus));
		MoveToElementClick(element);
		By Created = By.xpath("//md-option[@value='Created']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Created));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Quotes Status");
		
		
		By Search = By.name("applyadvancedSearchBtn");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");
		
		Thread.sleep(3000);
		By QuotesAss1 = By.xpath("//a[@title='" + ApplicantInfo.Quotes + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss1));
		String text = element.getText();
        System.out.println(text); 
        
//        Assert.assertEquals(text, ApplicantInfo.Quotes);
		ExtentSuccessMessage("Quotes which is Created Today is Visible after Advance Search");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote");
		
		Thread.sleep(5000);
		By CancelQuote = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div:nth-child(1) > div.col-xl-6.pad-rt > button:nth-child(2)");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelQuote));
		MoveToElementClick(element);
		Thread.sleep(2000);
		click(CancelQuote);
		ExtentSuccessMessage("Clicked on Cancel Quote Button");
		
		Thread.sleep(2000);
		By Status = By.xpath("//md-select[@name='TerminateQuoteStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By Terminated = By.xpath("//md-option[@value='Terminated']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Status as Terminated");
		
		LocalDate currentDate = LocalDate.now();

        LocalDate nextDate = currentDate.plusDays(1);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedNextDate = nextDate.format(formatter1);
        System.out.println(formattedNextDate);
        Base_Class.KeyOperation("ENTER");
		By CancelDate = By.xpath("//input[@name='TerminationDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelDate));
		MoveToElementClick(element);
		writeText(CancelDate,formattedNextDate + Keys.ENTER);
		ExtentSuccessMessage("Entered End Date For Termination");
		
		By Input = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Input));
		MoveToElementClick(element);
		String text1 = "These is Terminated VIA Automation";
        writeText(Input,text1);
		ExtentSuccessMessage("Entered Termination Reason");
		
		By Submit = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");
 
		By Terminated1 = By.xpath("//span[@class='ng-binding rejected']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminated1));
		String text2 = element.getText();
		System.out.println(text2);
		
		Assert.assertEquals(text2, "Terminated");
		ExtentSuccessMessage("Terminated is Visible at Top of Screen");
		
		By Sales = By.xpath("//a[@id='menu_Sales']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Button");
		
		By Leads = By.xpath("//a[@id='submenu_salesleads']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Leads Button");
		
		Thread.sleep(4000);
		By SearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField,ApplicantInfo.Quotes + Keys.ENTER);
		ExtentSuccessMessage("lead has been Searched");
		
		Thread.sleep(3000);
		By LeadField = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadField));
		MoveToElementClick(element);
		
		Thread.sleep(2000);
		By ManageLead = By.xpath("//button[@name='manageLeadsBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ManageLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On manage Lead");

		Thread.sleep(2000);
		By DeleteLead = By.xpath("//button[@id='deleteLeadsBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Delete Lead");
		
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On yes Lead");
		
		Thread.sleep(2000);
		

	}	
	public void SalesQuotesFilters2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");	
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");	
		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Quotestatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote status");	
		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Created status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Declined status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Expire status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected theIn progress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Inactive status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Install Inprogress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Install status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Terminated status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		MoveToElementClick(element);	
	}
	public void Sales_Quotes_QuotesActions() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");	
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");	
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");	
		waitForElement(8000);	
		waitForElement(2000);
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");
		
		waitForElement(6000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		 String NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion for note has been done");
		
	
	    waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		
		waitForElement(2000);
		By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
		element = wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		MoveToElementClick(element);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox,AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
		writeText(EmailSubject,  AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
	    ExtentSuccessMessage("Email has been added");
	
	    waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion for email is been done");
				
	   
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);
		
		waitForElement(6000);
		By DocumentDD1 =  By.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
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
		
	    Thread.sleep(9000);
		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
	
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		//element.click();
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByVisibleText("Send Email");
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
		
		waitForElement(8000);
		By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
	
	}	


	public void salesQuotesCreateQuoteFromOpportunity(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(6000);	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		 
		waitForElement(20000); 
		By RecentQuotes = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentQuotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Quotes Option");
		
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created Today Option");
		
		Thread.sleep(2000);
		By ProductCategory = By.xpath("(//div[@class='accordion-container grid-style-height'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Product Category Option");
		
		By Medical = By.xpath("//md-checkbox[@name='Medical']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Medical));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Medical Option");
		
		
		By QuotesAss = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss));
		String quotes =element.getText();
		System.out.println(quotes);
		
		System.out.println(ApplicantInfo.Quotes);
		Assert.assertEquals(quotes, ApplicantInfo.Quotes);
		ExtentSuccessMessage("Quotes which is Created Today is Visible after using Filter");

		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");
		
		Thread.sleep(4000);
		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Search Button");
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
		String formattedDate = today.format(formatter);
		By CreatedToday1 = By.xpath("//input[@name='CreatedStartDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday1));
		MoveToElementClick(element);
		writeText(CreatedToday1,formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Entered Created Date of Quotes");
		
		By ProductCategory1 = By.xpath("//md-select[@name='ProductCategory']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory1));
		MoveToElementClick(element);
		By Medical1 = By.xpath("//md-option[@value='Medical']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Medical1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Product Category");
		
		By QuotesStaus = By.xpath("//md-select[@name='QuoteStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesStaus));
		MoveToElementClick(element);
		By Created = By.xpath("//md-option[@value='Created']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Created));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Quotes Status");
		
		
		By Search = By.name("applyadvancedSearchBtn");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");
		
		Thread.sleep(3000);
		By QuotesAss1 = By.xpath("//a[@title='" + ApplicantInfo.Quotes + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss1));
		String text = element.getText();
        System.out.println(text); 
        
        Assert.assertEquals(text, ApplicantInfo.Quotes);
		ExtentSuccessMessage("Quotes which is Created Today is Visible after Advance Search");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote");
		
		Thread.sleep(5000);
		By CancelQuote = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div:nth-child(1) > div.col-xl-6.pad-rt > button:nth-child(2)");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Cancel Quote Button");
		
		Thread.sleep(2000);
		By Status = By.xpath("//md-select[@name='TerminateQuoteStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		By Terminated = By.xpath("//md-option[@value='Terminated']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Status as Terminated");
		
		LocalDate currentDate = LocalDate.now();

        LocalDate nextDate = currentDate.plusDays(1);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedNextDate = nextDate.format(formatter1);
        System.out.println(formattedNextDate);
		
		By CancelDate = By.xpath("//input[@name='TerminationDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelDate));
		MoveToElementClick(element);
		writeText(CancelDate,formattedNextDate + Keys.ENTER);
		ExtentSuccessMessage("Entered End Date For Termination");
		
		By Input = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Input));
		MoveToElementClick(element);
		String text1 = "These is Terminated VIA Automation";
        writeText(Input,text1);
		ExtentSuccessMessage("Entered Termination Reason");
		
		By Submit = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");
 
		By Terminated1 = By.xpath("//span[@class='ng-binding rejected']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Terminated1));
		String text2 = element.getText();
		System.out.println(text2);
		
		Assert.assertEquals(text2, "Terminated");
		ExtentSuccessMessage("Terminated is Visible at Top of Screen");

		 
	  
	}

	public void salesQuotesCreateOpportunityFromLead() throws InterruptedException, IOException, AWTException {
		waitForElement(6000);
		String URL= driver.getCurrentUrl();
		System.out.println(URL);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element); 
		waitForElement(1000); 
		By LeadFirstName = By.xpath("//input[@name='LeadFirstName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadFirstName));
		MoveToElementClick(element); 
		String FirstName = "Auto"; 
		writeText(LeadFirstName, FirstName); 
		ExtentSuccessMessage("First Name of Lead has been entered");
		waitForElement(1000);
		By LeadLastName = By.xpath("//input[@name='LeadLastName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadLastName));
		MoveToElementClick(element);
		String lastName = "Quotes" + getRandomNumber();
		writeText(LeadLastName, lastName);
		ExtentSuccessMessage("Last name of lead has been enterd");
		fullname = FirstName + " " + lastName;
		writeQuotesnameToExcel(fullname, "TC CE2");
		System.out.println(fullname);
		waitForElement(1000);
		By LeadPhoneNumber = By.xpath("//input[@name='LeadMobile']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		String LeadNumber = generatePhoneNumber();
		System.out.println(LeadNumber);
		writeText(LeadPhoneNumber, LeadNumber);
		ExtentSuccessMessage("Mobile Number of lead has been added");

		waitForElement(4000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);

		Thread.sleep(5000);
		try {

			By element2 = By.xpath("//h5[@class='modal-title']");
			if (driver.findElement(element2).isDisplayed()) {
				By Procedd = By.xpath("//button[@class='btn btn-default green ng-binding']");
				click(Procedd);
				ExtentSuccessMessage("Clicked on Proced Button");

			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Lead Created");
		}

		Thread.sleep(10000); 
		if(URL.contains("https://ce-qa.benefitalign.com/mme")) {
			ExtentSuccessMessage("Successfully Displayed Assign Lead");
			Thread.sleep(2000);
			try {

				By element2 = By.xpath("//h5[@class='modal-title ng-binding']");
				if (driver.findElement(element2).isDisplayed()) {
					By AssignOwner = By.xpath("(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[7] | //input[@type='radio']");
					click(AssignOwner);
					ExtentSuccessMessage("Clicked on Assign Owner");
					By OKButton = By.xpath("//button[@class='btn btn-default green pull-right ng-binding']");
					element = wait.until(ExpectedConditions.presenceOfElementLocated(OKButton));
					MoveToElementClick(element);
					ExtentSuccessMessage("Clicked On Ok button");

				}
			} catch (NoSuchElementException e) {
			} catch (Exception e) {
				ExtentSuccessMessage("Search Owner Popup is not Visible");
			}
		By SubmitButtonForOwner = By.xpath("//button[@id='formSubmitBtn'] | (//button[@type='submit'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButtonForOwner));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Submit button");
		}
		By SearchFiled = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		waitVisibility(SearchFiled);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
		MoveToElementClick(element);
		writeText(SearchFiled, fullname + Keys.ENTER);
		ExtentSuccessMessage("Lead Name has been Searched");

		Thread.sleep(8000);
		By Lead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");

		By LeadNameAssertion = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(1) > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadNameAssertion));
		String lead = element.getText();
		System.out.println(lead);

		Assert.assertEquals(lead, fullname);
		ExtentSuccessMessage("Assertion for Lead name has been Done");

		waitForElement(2000);
		By ConvertButton = By.xpath("//button[@name='Convert']");
		waitVisibility(ConvertButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Convert");

		waitForElement(2000);
		By ProductCategory = By.xpath("//md-select[@name='CRMProductCategory']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		String pc = element.getText();
		System.out.println(pc);

		By SubmitButton1 = By.xpath("//button[@name='formSubmitBtn']");
		waitVisibility(SubmitButton1);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Convert Submit Button");

		Thread.sleep(10000);
		By ConvertAssertion = By.xpath("//span[@class='unqualified converted']");
		waitVisibility(ConvertAssertion);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertAssertion));
		String cass = element.getText();
		System.out.println(cass);

		Assert.assertEquals(cass, "Converted");
		ExtentSuccessMessage("Assertion for convert is done at top");

		Thread.sleep(2000);
		By Sales = By.xpath("//a[@id='menu_Sales']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Button");

		By Opportunities = By.xpath("//a[@id='submenu_salesopportunities']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Opportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Opportunities Button");

		Thread.sleep(8000);
		By OppSearchField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppSearchField));
		MoveToElementClick(element);
		writeText(OppSearchField, fullname + Keys.ENTER);
		ExtentSuccessMessage("Converted Opportunity has been searched");

		By CustomerName = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		waitVisibility(CustomerName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer name");

		Thread.sleep(4000);
		By Product = By.xpath("(//span[@class='form-group view-page ng-scope'])[4]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product));
		String pc1 = element.getText();
		System.out.println(pc1);

		Assert.assertEquals(pc1, pc);
		ExtentSuccessMessage("Assertion for Product category is done in Opportunities Section");

		Thread.sleep(1000);
		By CreateQuote = By.xpath("//button[@class='btn btn-default pull-right ng-binding ng-scope'][2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Quote Button");

		Thread.sleep(2000);
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
		String formattedDate = today.format(formatter);
		By EffectiveDate = By.xpath("//input[@name='EffectiveDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EffectiveDate));
		MoveToElementClick(element);
		writeText(EffectiveDate, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Enetered Effective date");

		By Zip = By.xpath("//input[@name='Zip']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Zip));
		MoveToElementClick(element);
		writeText(Zip, "44444");
		ExtentSuccessMessage("Entered the zip code");

		Thread.sleep(3000);
		By Status = By.xpath("//md-select[@name='CRMNewQuoteStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		By Value = By.xpath("//md-option[@value='Created']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Value));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selecetd Status as Created");

		By SubmitButton3 = By.xpath("(//button[@class='btn btn-default green'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton3));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");

		Thread.sleep(12000);
		By Search = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		writeText(Search, fullname + Keys.ENTER);
		ExtentSuccessMessage("Quotes has been Searched");

		Thread.sleep(6000);
		By Cust1 = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		waitVisibility(Cust1);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cust1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes");

		Thread.sleep(3000);
		By Effectivedate = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > div.tile-custom-strcuture.ng-scope.ng-show > div > div.pull-left > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > div:nth-child(2) > div:nth-child(1) > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Effectivedate));
		String date = element.getText();
		System.out.println(date);

		Assert.assertEquals(date, formattedDate);
		ExtentSuccessMessage("Assertion for Date is done");

		//Editing for Quotes
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit_icon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Edit Icon has been clicked");
		waitForElement(5000);
		
		String Planname = "MedicalPlan";
		writeText(plan_name, Planname);
		ExtentSuccessMessage("Entered the Plan Name");
		String Originalrate = "500";
		writeText(original_rate, Originalrate);
		ExtentSuccessMessage("Entered the Originalrate");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(save));
		MoveToElementClick(element);
		ExtentSuccessMessage("Save Button has been clicked");
		waitForElement(5000);
		By Plan_name = By.xpath("//span[normalize-space()='" + Planname + "']");
		Assert.assertTrue(driver.findElement(Plan_name).isDisplayed());
		ExtentSuccessMessage("Plan name Assertion has been done");
		By Original_rate = By
				.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='$" + Originalrate + ".00']");
		Assert.assertTrue(driver.findElement(Original_rate).isDisplayed());
		ExtentSuccessMessage("Original rate Assertion has been done");
		Thread.sleep(10000);
		Quotesactions();
		
		
	} 

	public void salesOpportunityFilterOpportunity2() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Oppstatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status ");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Closed as won status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Open status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Qualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		MoveToElementClick(element);

	}
	
	public void serviceFilter(CensusInfo ApplicantInfo) throws InterruptedException {

		waitForElement(2000);
		By ServiceOption = By.xpath("//a[@id='menu_service']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Tile");
		
		waitForElement(5000);
		By RecentServiceReq = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentServiceReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Service Request Option");
		
		waitForElement(2000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']"); 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created today Option");
		
		waitForElement(4000);
		By CustomerName = By.xpath("//a[@class='edit-list-anchor ng-binding ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
        String name =element.getText();
        System.out.println(name);
        String nameString = StringUtils.substringAfter(name," ");
        System.out.println(nameString);
        System.out.println(ApplicantInfo.CustomerName);
        
		waitForElement(2000);
        Assert.assertTrue(ApplicantInfo.CustomerName.contains(nameString));
		ExtentSuccessMessage("Newly Created Service Request is Present in Created Today Filter");
 
		waitForElement(2000);   
        driver.navigate().refresh();   
		ExtentSuccessMessage("Page has been refreshed"); 
		
		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Option Button ");
		
		By Status = By.xpath("//md-select[@name='SRStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		MoveToElementClick(element);
		By Assigned = By.xpath("//md-option[@value='Assigned']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Assigned));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Dropdown ");

		
		By Requesttype = By.xpath("(//md-select[@name='RequestType'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Requesttype));
		MoveToElementClick(element);
		By New = By.xpath("(//md-option[@value='New Enrollment'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(New));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request Type Dropdown");
		
//		
		By Product = By.xpath("//md-select[@name='SRProduct']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product));
		MoveToElementClick(element);
		By CE = By.xpath("//md-option[@value='CE']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Product Dropdown");
//		
		Thread.sleep(2000);
		By SearchButton = By.xpath("//button[@name='applyadvancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");
		
		Thread.sleep(4000);
		By CustName = By.xpath("(//a[@class='edit-list-anchor ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustName));
		String custname = element.getText();
		System.out.println(custname); 
		
		String custnameString = StringUtils.substringAfter(name," ");
        System.out.println(custnameString);
        System.out.println(ApplicantInfo.CustomerName);
        
        Assert.assertTrue(ApplicantInfo.CustomerName.contains(custnameString));
		ExtentSuccessMessage("Newly Created SR is visible after advance Search");

		waitForElement(2000);
        driver.navigate().refresh();
		ExtentSuccessMessage("Page has been refreshed");
		
		waitForElement(4000);
		By ExportSRButton = By.xpath("//button[@name='downlodDataBtn']")	;
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ExportSRButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Export SR Button");
		 
		waitForElement(3000);
		By ExportPopup = By.xpath("//div[@id='divSuccess']");
//		Assert.assertTrue(driver.findElement(ExportPopup).isDisplayed());
		ExtentSuccessMessage("Export Popup is visible");
		
		By SearchText = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		String custnameString1 = StringUtils.substringAfter(ApplicantInfo.CustomerName," ");
		System.out.println(custnameString1);
		writeText(SearchText,custnameString1 + Keys.ENTER);
		ExtentSuccessMessage("Customer name has been Searched");

		waitForElement(3000);
		By ReqNumber = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReqNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On SR Number");
		
		
		waitForElement(3000);
		By Activities = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(3) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Acivities Section");
		
		waitForElement(4000);
		By EditAcivity = By.xpath("(//button[@title='Edit Activity'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditAcivity));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Edit Acivities Button");
		 
		waitForElement(6000);
        WebElement StatusDD=driver.findElement(By.xpath("(//select[@class='ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required'])[3]"));		
		Select s = new Select(StatusDD);
		s.selectByVisibleText("Closed");
		ExtentSuccessMessage("Status is been changed to close");
		
		By SaveButton = By.xpath("//button[@class='btn btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Save Acivities Button");
		
		waitForElement(8000);     
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Acivities Section");
		
		waitForElement(3000);
		By FirstStatus = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstStatus));
        String firststatus=element.getText();
		System.out.println(firststatus);
		
		Assert.assertEquals(firststatus, "Closed");
		ExtentSuccessMessage("Closed Status is visible in Grid");
		
		waitForElement(15000);
		cttMinimize();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditAcivity));
		MoveToElementClick(element);
//		wait.until(ExpectedConditions.elementToBeClickable(EditAcivity));
//		click(EditAcivity);
		ExtentSuccessMessage("Clicked On Edit Acivities Button");
		
		waitForElement(5000);
		WebElement StatusDD1=driver.findElement(By.xpath("(//select[@class='ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required'])[3]"));
		Select s1 = new Select(StatusDD1);
		s1.selectByVisibleText("Closed");
		ExtentSuccessMessage("Status is been changed to close");
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Save Acivities Button");
		
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Acivities Section");
		
		By SecondStatus = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[13]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecondStatus));
		String secondtext=element.getText();
		System.out.println(secondtext);
		
//		Assert.assertEquals(secondtext, "Closed");
		ExtentSuccessMessage("Status is been chamged to close for Second Activity");

		waitForElement(2000);
		By BasicInfo = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(2) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BasicInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Basic Info Section");
		

		waitForElement(3000);
        By EditButton = By.xpath("//button[@name='editServiceRequestBtn']");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(EditButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Edit Button");
		
		By SRStatus = By.xpath("(//md-select-value[@class='md-select-value'])[6]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SRStatus));
		MoveToElementClick(element);
		By ClosedStatus = By.xpath("//md-option[@value='Closed']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClosedStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked Staus as Close");

		By SRSaveButton = By.xpath("//button[@name='saveEditServiceRequestBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SRSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");

		waitForElement(8000);
		By StatusonTop = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(1) > div > h1 > ul > li:nth-child(3) > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusonTop));
        String status =element.getText();
        System.out.println(status);
        
		waitForElement(30000);
//        Assert.assertEquals(status, "Closed");
		ExtentSuccessMessage("Status has been changed to close on Top");
		
		
		By ServiceBreadCrumb = By.xpath("//a[@href='#/service']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceBreadCrumb));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceBreadCrumb");
		
		Thread.sleep(5000);
		
		
		By ServieReq = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Checkbox has been clicked");
		 
		Thread.sleep(3000);
		By ServiceButton = By.xpath("//button[@id='manageServicesBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Button");
		
		By Delete = By.xpath("//button[@id='deleteServiceRequestsBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete button");
		
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on yes button");
		
		Thread.sleep(2000);

		By Customer = By.xpath("//a[@id='menu_customers']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Button");

		Thread.sleep(4000);
		By Input1 = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Input1));
		MoveToElementClick(element);
		writeText(Input1,ApplicantInfo.CustomerName + Keys.ENTER);
		ExtentSuccessMessage("Customer Searched on Input Field");

		
		Thread.sleep(5000);
		By LeadField = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadField));
		MoveToElementClick(element);
		
		By ManageCustomer = By.xpath("//button[@id='manageCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ManageCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Manage Customer Button");
		
		By Deletebutton = By.xpath("//button[@name='deleteCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Deletebutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");
		
		By Yes1 = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been Deleted");
		
		Thread.sleep(3000);
		
		

		
		
		
		
		
	}

	public void salesOpportunityFilterOpportunity() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Oppstatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status ");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Closed as won status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Open status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Qualified status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		 * MoveToElementClick(element);
		 */

	}

	public void opportunityActions() throws InterruptedException, AWTException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		Thread.sleep(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);

	}

	public void opportunityChangeLeadStatus() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optqualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Qualify");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDeal));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDealStatus));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseDeal");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
	}

	public void createOpportunityQuote() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(6000);
		writeText(OpportunityEffectiveDate, "12/12/2024" + Keys.ENTER);
		waitForElement(6000);
		writeText(OptZipCode, "33233");
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

	}

	public void newOpportunity() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewOpportunity));
		MoveToElementClick(element);
		ExtentSuccessMessage("clicked on new New Opportunity");
		waitForElement(6000);
		writeText(OpportunityName, "siva");
		waitForElement(6000);
		ExtentSuccessMessage("Enter the custmer name");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesSearchIcon));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on search  ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RadioButtonSelect));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ButtonOk));
		MoveToElementClick(element);

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitOk));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit button");
	}

	public void leadAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAccepted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Accepted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUnqualified));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Unqualified");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectConverted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Converted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectQualified));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Qualified");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectReject));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reject");
		waitForElement(9000);
		click(AdvanceSubmit);

	}

	public void leadAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAccepted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Accepted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectUnqualified));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Unqualified");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectConverted));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Converted");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectQualified));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Qualified");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectReject));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reject");
		 * waitForElement(9000); click(AdvanceSubmit);
		 */

	}

	public void salesLeadFilterLead2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Lead");
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the UnQualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Accepted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Converted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Qualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		MoveToElementClick(element);

	}

	public void salesLeadFilterLead() throws InterruptedException {
		String URL= driver.getCurrentUrl();
		System.out.println(URL);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(1000);
		By LeadFirstName = By.xpath("//input[@name='LeadFirstName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadFirstName));
		MoveToElementClick(element);
		String FirstName = "Automation";
		writeText(LeadFirstName, FirstName);
		ExtentSuccessMessage("First Name of Lead has been entered");
		waitForElement(1000);
		By LeadLastName = By.xpath("//input[@name='LeadLastName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadLastName));
		MoveToElementClick(element);
		String lastName = "User" + getRandomNumber();
		writeText(LeadLastName, lastName);
		ExtentSuccessMessage("Last name of lead has been enterd");
		String fullname = FirstName + " " + lastName;

		System.out.println(fullname);
		waitForElement(1000);
		By LeadPhoneNumber = By.xpath("//input[@name='LeadMobile']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		String LeadNumber = generatePhoneNumber();
		System.out.println(LeadNumber);
		writeText(LeadPhoneNumber, LeadNumber);
		ExtentSuccessMessage("Mobile Number of lead has been added");

		waitForElement(1000);
		By LeadInfomation = By.cssSelector("#formFlag2 > i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadInfomation));
		MoveToElementClick(element);

//		waitForElement(1000);
//		By LeadRevenue = By.xpath("//input[@name='Revenue']");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadRevenue));
//		MoveToElementClick(element);
//		String Revenue1 = "1" + getRandomNumber1();
//		System.out.println(Revenue1);
//		writeText(LeadRevenue, Revenue1);
//		ExtentSuccessMessage("Revenue of lead has  been added");

		waitForElement(1000);
		By OtherInformation = By.xpath("(//div[@class='accordion-container home-principal-issue'])[3]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OtherInformation));
		MoveToElementClick(element);
 
		waitForElement(2000);
		By MaritialStatusDD = By.xpath("//md-select[@name='LeadMaritalStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MaritialStatusDD));
		MoveToElementClick(element);

		waitForElement(2000);
		By MarriedOption = By.xpath("//md-option[@value='Married']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarriedOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Maritial status has been selected");

		waitForElement(5000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);

		Thread.sleep(7000);
		try {

			By element2 = By.xpath("//h5[@class='modal-title']");
			if (driver.findElement(element2).isDisplayed()) {
				By Procedd = By.xpath("//button[@class='btn btn-default green ng-binding']");
				click(Procedd);
				ExtentSuccessMessage("Clicked on Proced Button");

			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Similar Record Found Popup not displayed");
		}

		Thread.sleep(12000);
		if(URL.contains("https://ce-qa.benefitalign.com/mme")) {
			ExtentSuccessMessage("Successfully Displayed Assign Lead");
			Thread.sleep(2000);
			try {

				By element2 = By.xpath("//h5[@class='modal-title ng-binding']");
				if (driver.findElement(element2).isDisplayed()) {
					By AssignOwner = By.xpath("(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[7] | //input[@type='radio']");
					click(AssignOwner);
					ExtentSuccessMessage("Clicked on Assign Owner");
					By OKButton = By.xpath("//button[@class='btn btn-default green pull-right ng-binding']");
					element = wait.until(ExpectedConditions.presenceOfElementLocated(OKButton));
					MoveToElementClick(element);
					ExtentSuccessMessage("Clicked On Ok button");

				}
			} catch (NoSuchElementException e) {
			} catch (Exception e) {
				ExtentSuccessMessage("Search Owner Popup is not Visible");
			}
		By SubmitButtonForOwner = By.xpath("//button[@id='formSubmitBtn'] | (//button[@type='submit'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButtonForOwner));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Submit button");
		}
		Thread.sleep(8000);
		By SearchFiled = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		waitVisibility(SearchFiled);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
		MoveToElementClick(element);
		writeText(SearchFiled, fullname + Keys.ENTER);
		ExtentSuccessMessage("Lead Name has been Searched");

		Thread.sleep(2000);
		By Lead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");
		Thread.sleep(2000);
		By LeadNameAssertion = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(1) > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadNameAssertion));
		String lead = element.getText();
		System.out.println(lead);
		Assert.assertEquals(lead, fullname);
		ExtentSuccessMessage("Assertion for Lead name has been Done");
		Thread.sleep(2000);
		By EditButton = By
				.xpath("//button[@class='btn btn-default pull-right icons red-color pull-right ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Lead Button");
		Thread.sleep(2000);
		String CurrentURL= driver.getCurrentUrl();
		System.out.println(CurrentURL);
		
		//if(CurrentURL.contains("https://ce-qa.benefitalign.com/") || CurrentURL.contains("https://ce-uat.benefitalign.com/"))
		if(CurrentURL.contains("https://ce-uat.benefitalign.com/"))
		{
			Thread.sleep(8000); 
			WebElement HRCADD = driver.findElement(By.xpath("//select[@name='HRACompleted']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HRCADD);
			Select s = new Select(HRCADD);
			s.selectByVisibleText("Yes");
			Thread.sleep(2000);
			String hrcadd = s.getFirstSelectedOption().getText();
			System.out.println(hrcadd);
			ExtentSuccessMessage("HRCA DD is selected");

			WebElement salestype = driver.findElement(By.xpath("//select[@name='SaleType']"));
			Select s1 = new Select(salestype);
			s1.selectByVisibleText("New");
			String st = s1.getFirstSelectedOption().getText();
			System.out.println(st); 
			ExtentSuccessMessage("Sales DD is selected");
		}
		

		Thread.sleep(1000);
		By ContactInformation = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInformation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Contact Information button");

		By Email = By.xpath("//input[@name='LeadEmail']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email));
		MoveToElementClick(element);
		String email = FirstName + lastName + "@yopmail.com";
		System.out.println(email);
		writeText(Email, email);
		ExtentSuccessMessage("Clicked on Contact Information button");

		By SaveButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save button");

		Thread.sleep(3000);

		By EmailAssertion = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(8) > span > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAssertion));
		String emaill = element.getText();
		System.out.println(emaill);

		Assert.assertEquals(emaill, email);
		ExtentSuccessMessage("Assertion for email is done");
		
		By ChangeLogs = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > ul > li:nth-child(6)");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ChangeLogs));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ChangesLogs");
				
		By UpdatedValue2 = By.xpath("//div[@title='"+ email +"']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UpdatedValue2));
		String email1 = element.getText();
		System.out.println(email1);
		 
		  
        Assert.assertEquals(email1, email);
		ExtentSuccessMessage("Assertion for Email is Done in Changes Log");
			
		Thread.sleep(4000);
		By RejectButton = By.xpath("//button[@id='Reject']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RejectButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Reject button");

		By AlwaysCovered = By.xpath("(//div[@class='md-container md-ink-ripple'])[1]/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AlwaysCovered));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Always Covered button");

		By SubmitButton2 = By.xpath("//button[@id='formSubmitBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Reject Submit button");

		Thread.sleep(6000);
		By Rejected = By.xpath("//span[@class='unqualified rejected']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Rejected));
		String rejected = element.getText();
		System.out.println(rejected);

		Assert.assertEquals(rejected, "Rejected");
		ExtentSuccessMessage("Assertion for Reject is done for top");

		By Reject = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(12) > span > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Reject));
		String reject = element.getText();
		System.out.println(reject);

		Assert.assertEquals(reject, "Rejected");
		ExtentSuccessMessage("Assertion for Reject is done for Basic Information");

		By SalesBreadCrumb = By
				.cssSelector("#page-wrapper > div > ui-view > div:nth-child(1) > div > ol > li:nth-child(2) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesBreadCrumb));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on BreadCrumb");

		Thread.sleep(3000);
		driver.navigate().refresh();

		Thread.sleep(8000);

		By RecentLead = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on RecentLead");

		Thread.sleep(1000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Crated Today Lead");
		Thread.sleep(15000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		Thread.sleep(9000);
		By LeadStatus = By.xpath("(//div[@class='accordion-container grid-style-height'])[7]/i");
		waitVisibility(LeadStatus);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Status");
		Thread.sleep(3000);
		By RejectedStatus = By.xpath("//span[contains(.,'Rejected')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RejectedStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Rejected Lead Status");
		Thread.sleep(3000);
		By User = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(User));
		String user = element.getText();
		System.out.println(user);

		Assert.assertEquals(user, fullname);
		ExtentSuccessMessage("Rejected Lead is visible after using Filter");

		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Search Button");

		Thread.sleep(2000);
		LocalDate today = LocalDate.now();

		// Format the date if needed (optional)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
		String formattedDate = today.format(formatter);

		By CreatedDate = By.xpath("//input[@name='CreatedStartDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedDate));
		MoveToElementClick(element);
		writeText(CreatedDate, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Entered today Date");

		By LeadStatusDD = By.xpath("//md-select[@name='LeadStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		MoveToElementClick(element);
		By RejectedOption = By.xpath("//md-option[@value='Rejected']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RejectedOption));
		MoveToElementClick(element);

		Thread.sleep(1000);
		By SearchButton = By.xpath("//button[@name='advancedSearchSubmitBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");

		Thread.sleep(4000);
		By User1 = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(User1));
		String user1 = element.getText();
		System.out.println(user1);

//		Assert.assertEquals(user1, fullname);
		ExtentSuccessMessage("Rejected Lead is visible after using Advance Search");
		
		

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
		ExtentSuccessMessage("Lead has been deleted Successfully");
		
	}
	
	public void serviceCreateNewService(CensusInfo ApplicantInfo) throws InterruptedException, IOException, AWTException {

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		String Firstname ="AutoServiceReq"; 
		writeText(CustFName,Firstname);
		waitForElement(1000); 
		String Lastname =randomName();
		writeText(CustLName,Lastname);
		 name = Firstname+" "+Lastname; 
		writeCustomernameToExcel(name,"TC CE2");
		System.out.println(name);
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000); 
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String email = Firstname+Lastname+"@yopmail.com";
		System.out.println(email);
		writeText(CustMail,email); 
		waitForElement(3000);
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
		waitForElement(3000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");	 

		waitForElement(14000);
		By ServiceOption = By.xpath("//a[@id='menu_service']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Tile");
		
	    waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewServiceReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on NewServiceRequest Button"); 
		
	    waitForElement(5000); 
		By SearchCustomer = By.xpath("//input[@name='Customer']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchCustomer));
		MoveToElementClick(element);
		String customer = Firstname + " "+Lastname ;
		System.out.println(customer);
		writeText(SearchCustomer,customer);
		ExtentSuccessMessage("Customer name has been entered"); 
		
		By SearchButton = By.xpath("(//i[@class='glyphicon glyphicon-search'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button"); 
		
	    waitForElement(5000);
		if(driver.findElement(By.xpath("//h5[@class='modal-title']")).isDisplayed())
		{
			By SelectOption = By.xpath("//input[@name='selCustomer']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectOption));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on customer after search"); 
			
			By OkButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(OkButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on OK Button"); 
			
		}
		else {	ExtentSuccessMessage("Customer is not available"); } 
		
		By RequestType = By.xpath("//md-select[@name='SrType'] | //md-select[@name='SrType']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Request Type Dropdown");
		By NewEnrollment = By.xpath("(//md-option[@value='New Enrollment'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewEnrollment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request Type as New Enrollment");
		
		By RequestSubType = By.xpath("//md-select[@name='SRActivitySubType']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Request SubType");
		By NewEnrollment1 = By.xpath("(//md-option[@value='New Enrollment'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewEnrollment1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request Type as New Enrollment");
		
		
		By Product = By.xpath("(//md-select[@name='SRProduct'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Product Dropdown");
		By CE = By.xpath("(//md-option[@value='CE'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on CE Option"); 
		
		By ActionedBy = By.xpath("//md-select[@name='SRActionedBy']");
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionedBy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Actioned By");
        By QA = By.xpath("//md-option[@value='QA']");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(QA));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on QA option");
		
		By TextArea = By.xpath("(//textarea[@class='form-control ng-pristine ng-untouched md-input ng-empty ng-valid ng-valid-required'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TextArea));
		MoveToElementClick(element);
		String text = "Hello ! These SR is created via Automation";
		writeText(TextArea,text);
		ExtentSuccessMessage("Eneterd the message in TextArea");
		
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");
		
	    waitForElement(35000);
	    By SearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField,customer + Keys.ENTER);
		ExtentSuccessMessage("Customer name has been serached");
		
		By CustomerName = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceReq after creating SR");
		
		
		
	    waitForElement(4000);
		By Requesttype = By.xpath("(//span[@class='form-group view-page ng-scope'])[3]/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Requesttype));
        String type =element.getText();
        System.out.println(type);
        Assert.assertEquals(type, "New Enrollment");
		ExtentSuccessMessage("Assertion for Request Type is done");

		By Email = By.xpath("//li[@class='nav-item user-details ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Email));
        String emailtext =element.getText();
        System.out.println(emailtext);
        Assert.assertEquals(emailtext, email);
		ExtentSuccessMessage("Assertion for email is done");
		
		By CustomerInformation = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(4) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInformation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Information Section");
		
		Thread.sleep(3000);
		By Namee = By.xpath("(//span[@class='form-group view-page ng-scope'])[1]/span/a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Namee));
        String namee = element.getText();
        System.out.println(namee);
        
        Assert.assertEquals(namee, name);
		ExtentSuccessMessage("Assertion for Custmer name is done in Customer Infromation Tab");

		 
	    waitForElement(2000);
		By AddActivity = By.xpath("//button[@id='AddActivity']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddActivity));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Activity Button");
		 
	    waitForElement(7000);
        if(driver.findElement(By.xpath("//h5[@class='modal-title']")).isDisplayed())
        {
        	WebElement SelectSR = driver.findElement(By.xpath("(//select[@ng-selected='item'])[1]"));
    		Select select = new Select(SelectSR);
    		select.selectByVisibleText("Others");
    		ExtentSuccessMessage("Selected Activity Type");

        	
        	By SaveButton = By.xpath("//button[@class='btn btn-default green']");
        	element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
    		MoveToElementClick(element); 
    		ExtentSuccessMessage("Clicked on Save Button");

        	
        }
        
        Thread.sleep(10000);
        By Activities = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(3) > a");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(Activities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Actitvities Section");
		
        Thread.sleep(20000);
		By ActivityGrid = By.xpath("//div[@class='ui-grid-row ng-scope']");
		Assert.assertTrue(driver.findElement(ActivityGrid).isDisplayed());
		ExtentSuccessMessage("Activity is been displayed in the grid");
		Thread.sleep(10000);
		serviceactions();	
		
		
	}
	

	public void leadConvert() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		click(Convert);
		ExtentSuccessMessage("Clicked on Convert button");
		// waitForElement(6000);
		// click(MedicalDropdown);
		waitForElement(8000);
		// click(Medical);
		// click(ConvertSubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Convert Submit");

	}

	public void salesLeadActions() throws InterruptedException, AWTException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		Thread.sleep(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		Thread.sleep(10000);

		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SalesLeadNotes));
		 * MoveToElementClick(element); String Note = "Rajeswari Automation";
		 * writeText(SalesLeadNotes, Note);
		 */
		// writeText(SalesLeadNotes,"abcdefghij");
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmailID));
		MoveToElementClick(element);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);
		// WebElement dropdown = driver.findElement(AttachDropDown);

		/*
		 * String optionValue = "string:Application";
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].value = arguments[1];", dropdown,
		 * optionValue);
		 * js.executeScript("arguments[0].dispatchEvent(new Event('change'))",
		 * dropdown); waitForElement(4000);
		 */

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachDropDown));
		wait.until(ExpectedConditions.elementToBeClickable(AttachDropDown));
		click(AttachDropDown);
		waitForElement(3000);
		By DocumentDDOption = By.xpath("//option[text()='Annual Income']");
		wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
		click(DocumentDDOption);

		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);

	}

	public void leadStatus() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		click(LeadAssign);
		waitForElement(6000);
		click(EditIcon);
		waitForElement(6000);
		// js.executeScript("window.scrollBy(0,500)");
		/*
		 * Actions actions = new Actions(driver);
		 * 
		 * // Scroll down using Actions class
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 */

		waitForElement(6000);
		/*
		 * WebElement StausSel = driver.findElement(StatusSelect); Select select = new
		 * Select(StausSel); select.selectByIndex(5);
		 */
		/*
		 * element = wait.until(ExpectedConditions. presenceOfElementLocated
		 * (StatusSelect)); MoveToElementClick(element); Select select = new
		 * Select(element); select.selectByVisibleText("Qualified");
		 * ExtentSuccessMessage("Qualified Selected"); //
		 * js.executeScript("window.scrollBy(0,300)");
		 * 
		 * 
		 * // Scroll down using Actions class //
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 * 
		 * click(ButtonSave);
		 */
		click(LeadQualify);
		ExtentSuccessMessage("Clicked on Qualify");
		waitForElement(6000);
		click(LeadReject);
		ExtentSuccessMessage("Clicked on Reject");
		waitForElement(6000);
		click(LeadDispose);
		ExtentSuccessMessage("Clicked on Lead Dispose");

	}

	public void salesLead() throws InterruptedException, AWTException {
		String URL= driver.getCurrentUrl();
		System.out.println(URL);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(1000);
		By LeadFirstName = By.xpath("//input[@name='LeadFirstName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadFirstName));
		MoveToElementClick(element);  
		String FirstName = "Automation";
		writeText(LeadFirstName, FirstName);
		ExtentSuccessMessage("First Name of Lead has been entered");
		waitForElement(1000);
		By LeadLastName = By.xpath("//input[@name='LeadLastName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadLastName));
		MoveToElementClick(element);
		String lastName = "User" + getRandomNumber();
		writeText(LeadLastName, lastName);
		ExtentSuccessMessage("Last name of lead has been enterd");
		fullname = FirstName + " " + lastName;
		System.out.println(fullname);
		waitForElement(1000);
		By LeadPhoneNumber = By.xpath("//input[@name='LeadMobile']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		String LeadNumber = generatePhoneNumber(); 
		System.out.println(LeadNumber);
		writeText(LeadPhoneNumber, LeadNumber);
		ExtentSuccessMessage("Mobile Number of lead has been added");

		waitForElement(1000);
		By LeadInfomation = By.cssSelector("#formFlag2 > i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadInfomation));
		MoveToElementClick(element);

//		waitForElement(1000);
//		By LeadRevenue = By.xpath("//input[@name='Revenue']");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadRevenue));
//		MoveToElementClick(element);
//		String Revenue1 = "1" + getRandomNumber1();
//		System.out.println(Revenue1);
//		writeText(LeadRevenue, Revenue1);
//		ExtentSuccessMessage("Revenue of lead has been added");

		waitForElement(4000);
		By LeadRevenue = By.xpath("//input[@name='Revenue']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadRevenue));
		MoveToElementClick(element);
		String Revenue1 = "1" + getRandomNumber1();
		System.out.println(Revenue1);
		writeText(LeadRevenue, Revenue1);
		ExtentSuccessMessage("Revenue of lead has been added"); 

		waitForElement(1000);
		By OtherInformation = By.xpath("(//div[@class='accordion-container home-principal-issue'])[3]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OtherInformation));
		MoveToElementClick(element);

		waitForElement(2000); 
		By MaritialStatusDD = By.xpath("//md-select[@name='LeadMaritalStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MaritialStatusDD));
		MoveToElementClick(element);

		waitForElement(1000);
		By MarriedOption = By.xpath("//md-option[@value='Married']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarriedOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Maritial status has been selected");

		waitForElement(4000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);

//		int value = driver.findElements(By.xpath("//button[@class='btn btn-default green']")).size();
//		System.out.println(value);
//		waitForElement(4000);
//		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])["+value+"] | //div[@class='col-md-6 pull-right button-wrap']//button[@type='submit'][normalize-space()='Submit']");
//		waitVisibility(SubmitButton);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
//		MoveToElementClick(element);
			
		Thread.sleep(5000);
		try {

			By element2 = By.xpath("//h5[@class='modal-title']");
			if (driver.findElement(element2).isDisplayed()) {
				By Procedd = By.xpath("//button[@class='btn btn-default green ng-binding']");
				click(Procedd);
				ExtentSuccessMessage("Clicked on Proced Button");

			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Lead Created");
		}
		Thread.sleep(8000);
		if(URL.contains("https://ce-qa.benefitalign.com/mme")) {
			ExtentSuccessMessage("Successfully Displayed Assign Lead");
		} else {
		By SearchFiled = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
		MoveToElementClick(element);
		writeText(SearchFiled, fullname + Keys.ENTER);
		ExtentSuccessMessage("Lead Name has been Searched");

		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");

		By LeadNameAssertion = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(1) > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadNameAssertion));
		String lead = element.getText();
		System.out.println(lead);

		Assert.assertEquals(lead, fullname);
		ExtentSuccessMessage("Assertion for Lead name has been Done");

		By AssignLead = By.xpath("//button[@name='Assign']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AssignLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Assign Lead Button");
		if(URL.contains("https://mme.brokerengage.net/")) {
			ExtentSuccessMessage("Successfully Displayed Assign Lead");
		} else {
			Thread.sleep(19000);
			By OwnerField = By.xpath("//input[@name='Owner']");
			waitVisibility(OwnerField);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(OwnerField));
			MoveToElementClick(element);
			element.clear();
			
			String Owner = "CEUser one";
			writeText(OwnerField, Owner);

			By SearchButton = By.xpath("(//button[@class='btn btn-default green'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked Search Button");
		}
		}
			Thread.sleep(5000);
			try {

				By element2 = By.xpath("//h5[@class='modal-title ng-binding']");
				if (driver.findElement(element2).isDisplayed()) {
					By AssignOwner = By.xpath("(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[7] | //input[@type='radio']");
					click(AssignOwner);
					ExtentSuccessMessage("Clicked on Assign Owner");
					By OKButton = By.xpath("//button[@class='btn btn-default green pull-right ng-binding']");
					element = wait.until(ExpectedConditions.presenceOfElementLocated(OKButton));
					MoveToElementClick(element);
					ExtentSuccessMessage("Clicked On Ok button");

				}
			} catch (NoSuchElementException e) {
			} catch (Exception e) {
				ExtentSuccessMessage("Search Owner Popup is not Visible");
			}
		
		By SubmitButtonForOwner = By.xpath("//button[@id='formSubmitBtn'] | (//button[@type='submit'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButtonForOwner));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Submit button");

		Thread.sleep(4000);
		if(URL.contains("https://ce-qa.benefitalign.com/mme")) {
			By SearchFiled = By.xpath(
					"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
			MoveToElementClick(element);
			writeText(SearchFiled, fullname + Keys.ENTER);
			ExtentSuccessMessage("Lead Name has been Searched");

			Thread.sleep(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Lead");
		} else {
			ExtentSuccessMessage("Successfully displayed Lead");
		}	
		
//		By clicklead = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(clicklead));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked On Lead");
		
		
		By OwnerAssertion = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(14) > span > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OwnerAssertion));
		String owner = element.getText();
		System.out.println(owner);
 
		//Assert.assertTrue(owner.equalsIgnoreCase(Owner));
		ExtentSuccessMessage("Assertion for owner name is done");

		// 3rd case
		By Qualify = By.xpath("//button[@name='Qualify']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Qualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Qualify button");

		Thread.sleep(2000);
		By SubmitButton1 = By.xpath("//button[@id='formSubmitBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Submit button");

		Thread.sleep(14000);
		By Qualified = By.xpath("//span[@class='unqualified qualified']");
		waitVisibility(Qualified);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Qualified));
		String qualify = element.getText();
		System.out.println(qualify);

		Assert.assertEquals(qualify, "Qualified");
		ExtentSuccessMessage("Assertion for Qualify is done on Top");

		By Status = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(1) > div > div > div > paint-ui > div > div > div:nth-child(12) > span > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		String status = element.getText();
		System.out.println(status);

		Assert.assertEquals(status, "Qualified");
		ExtentSuccessMessage("Assertion for Qualify is done in Basic Information");

		By ConvertButton = By.xpath("//button[@id='Convert']");
		waitVisibility(ConvertButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Convert Button");

		By Product = By
				.xpath("(//md-select[@class='ng-pristine ng-untouched ng-empty ng-valid ng-valid-required'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Product));
		String product = element.getText();
		System.out.println(product);

		By ConvertSubmitButton = By.xpath("//button[@id='formSubmitBtn']");
		waitVisibility(ConvertSubmitButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Convert Button Submit Button");

		Thread.sleep(7000);

		By Converetd = By.xpath("//span[@class='unqualified converted']");
		waitVisibility(Converetd);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Converetd));
		String convert = element.getText();
		System.out.println(convert);

		By Sales = By.xpath("//a[@id='menu_Sales']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Button");

		By Opportunities = By.xpath("//a[@id='submenu_salesopportunities']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Opportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Opportunities Button");

		By OppSearchField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		waitVisibility(OppSearchField);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppSearchField));
		MoveToElementClick(element);
		writeText(OppSearchField, fullname + Keys.ENTER);
		ExtentSuccessMessage("Converted Opportunity has been searched");

		Thread.sleep(8000);
		By ProductCategory = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		waitVisibility(ProductCategory);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		String pc = element.getText();
		System.out.println(pc);

		Assert.assertEquals(pc, product);
		ExtentSuccessMessage("Assertion for Product is done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Button");

		By Lead1 = By.xpath("//a[@name='submenu_salesleads']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Section");

		Thread.sleep(5000);
		waitVisibility(Lead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead");

		Thread.sleep(10000);
		leadsactions1();
		
		waitVisibility(sales_leads);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(sales_leads));
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
		ExtentSuccessMessage("Lead has been deleted Successfully");

	}

	public void serviceactions() throws InterruptedException, AWTException {


		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}

		waitForElement(2000);
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");
		
		waitForElement(8000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		 NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion has been done");
		
	
	    waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		
		waitForElement(4000);
		By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDD));
		MoveToElementClick(element);
		
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox,AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
		writeText(EmailSubject,  AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
	    ExtentSuccessMessage("Email has been added");
	
	    waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		Assert.assertTrue(driver.findElement(AgentEmailInc).isDisplayed());
	    ExtentSuccessMessage("Assertion for Email has been done");

		waitForElement(12000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);
		
		waitForElement(3000);
		By DocumentDD1 =  By.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
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
		
	    Thread.sleep(7000);
//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
//		ExtentSuccessMessage("Assertion has been done");
		

		
		waitForElement(4000); 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		//element.click();
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByVisibleText("Send Email");
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
		
		waitForElement(4000);
		
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		By NotesAndAttachmnets = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(2) > div.col-xl-9.col-lg-6.left-section.details > div > div > ul > li:nth-child(5)");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesAndAttachmnets));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Notes and Attachment");
		
		waitForElement(3000);
//		By DownloadAttachment = By.xpath("//span[@class='glyphicon glyphicon-download-alt']");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DownloadAttachment));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked On Download Button");
		
		
		By DashBoard = By.xpath("//a[@id='menu_Dashboard']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On DashBoard Option");
		
		By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My TaskOption Option");
		 
	/*	Thread.sleep(8000);
		By ServiceName = By.xpath("//span[contains(.,'"+ name +"')]");
		Assert.assertTrue(driver.findElement(ServiceName).isDisplayed());
		ExtentSuccessMessage("Assertion for ServiceReq is done Under My Task");
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceName));
        element.click();
		Thread.sleep(4000);
		
		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(3000);
		
		By DeleteTask = By.xpath("(//i[@class='fa fa-trash red-color pull-right ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Task Button");
		
		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been Deleted");	*/	
		

		
		
		
		
		

		 
		
		
		

	}

	public void leadsactions1() throws InterruptedException, AWTException {

		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitForElement(2000);
		waitVisibility(NotesSection);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		String NoteText = element.getText();
		System.out.println("-----------" + NoteText + "------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion for note has been done");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
 
		waitForElement(4000);
//		By EmailAddressDD = By.xpath("(//md-select[@role='listbox'])");
//		wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
//		click(EmailAddressDD);
//		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com']");
		By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
		By EmailAddress = By.xpath("(//md-select[@role='listbox'])[2] | //a[@role='tab']//i[@class='fa fa-envelope']");
		if(ElementDisplayed(EmailAddress)) {
			element = wait.until(ExpectedConditions.elementToBeClickable(EmailAddress));
			MoveToElementClick(element);
		}
		else if (ElementDisplayed(EmailAddressDD)) {
			element = wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
			MoveToElementClick(element);
		}
		waitForElement(2000);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);
		Base_Class.KeyOperation("ENTER");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox, AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
		writeText(EmailSubject, AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email has been added");


		waitForElement(8000);
		By AgentEmail = By.xpath("//u[normalize-space()='"+AgentEmailAction+"']");
		waitVisibility(AgentEmail);
		Assert.assertTrue(ElementDisplayed(AgentEmail));
//		waitVisibility(AgentEmailInc);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
//		String NoteText1 = element.getText();
//		System.out.println("-----------" + NoteText1 + "------------");
//		Assert.assertEquals(AgentEmailAction, NoteText1);
		ExtentSuccessMessage("Assertion for email is been done");

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);

		waitForElement(8000);
		By DocumentDD1 = By
				.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		waitVisibility(DocumentDD1);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
		waitForElement(1000);
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

//		Thread.sleep(5000);
//		waitVisibility(AttachmentInc);
//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
//		ExtentSuccessMessage("Assertion has been done");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		// element.click();
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByVisibleText("Send Email");
		Thread.sleep(1000);
		element.getText();

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PriorityDD));
		element.click();
		Thread.sleep(500);
		Select s = new Select(element);
		s.selectByVisibleText("Low");
		Thread.sleep(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommentTextArea));
		MoveToElementClick(element);
		writeText(CommentTextArea, "This Task is created VIA Automation");
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");

		waitForElement(9000);
		By TaskInc = By.cssSelector("#fixed > ul > li");
		waitVisibility(TaskInc);
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		By DashBoard = By.xpath("//a[@id='menu_Dashboard']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On DashBoard Option");
		
		By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My TaskOption Option");
		
//		By LeadsName = By.xpath("//span[contains(.,'" + fullname + "')]");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
//		String name =element.getText();
//		System.out.println(name);
//		
//		Assert.assertEquals(name, fullname);
//		ExtentSuccessMessage("Task is Visible under MY-Task Section");
//		Thread.sleep(6000);
//		waitVisibility(LeadsName);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked On My Task");
//		Thread.sleep(4000);
		
		
		System.out.println(fullname);
		waitForElement(7000);
		By task = By.xpath("//span[@class='ng-binding'][normalize-space()='"+fullname+"']");
		waitVisibility(task);
		Assert.assertTrue(driver.findElement(task).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");	
		
		waitForElement(4000);
		waitVisibility(task);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(task));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My Task");
		Thread.sleep(15000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
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
		ExtentSuccessMessage("Tesk has been deleted Successfully");
		
	}

	public void Quotesactions() throws InterruptedException, AWTException {

		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		String NoteText = element.getText();
		System.out.println("-----------" + NoteText + "------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion for note has been done");

		waitForElement(4000);
		By ActionEmailIcon = By.xpath("(//i[@class='fa fa-envelope'])");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);

		waitForElement(4000);
		By EmailAddressDD = By.xpath("//md-select[@placeholder='Sender Email Address']");
		wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		click(EmailAddressDD);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='customerservice@truecoverage.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox, AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
		writeText(EmailSubject, AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email has been added");
		
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		Assert.assertTrue(driver.findElement(AgentEmailInc).isDisplayed());
		ExtentSuccessMessage("Assertion for mail has been done");
	
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);

		waitForElement(8000);
		By DocumentDD1 = By
				.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
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

//		Thread.sleep(9000);
//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
//		ExtentSuccessMessage("Assertion has been done");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		// element.click();
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByVisibleText("Send Email");
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
		writeText(CommentTextArea, "This Task is created VIA Automation");
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");

		waitForElement(8000);
		By TaskInc = By.cssSelector("#fixed > ul > li");
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		By DashBoard = By.xpath("//a[@id='menu_Dashboard']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On DashBoard Option");
		
		By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My TaskOption Option");
		
		Thread.sleep(4000);
		//By LeadsName = By.xpath("//span[contains(.,'" + fullname + "')]");
		By LeadsName = By.xpath("//span[@class='ng-binding'][normalize-space()='" + fullname + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		String name =element.getText();
		System.out.println(name);
		
		Thread.sleep(4000);
		Assert.assertEquals(name, fullname);
		ExtentSuccessMessage("Task is Visible under MY-Task Section");
		
		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes task");
		
		Thread.sleep(13000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on My task");

		waitForElement(3000);
		
		By DeleteTask = By.xpath("(//i[@class='fa fa-trash red-color pull-right ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Task Button");
		
		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been Deleted");
		
	}
	
	public void salesactions() throws InterruptedException, AWTException {

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		String NoteText = element.getText();
		System.out.println("-----------" + NoteText + "------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion for note has been done");

		waitForElement(4000);
		By ActionEmailIcon = By.xpath("((//i[@class='fa fa-envelope']))[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);

		waitForElement(4000);
		By EmailAddressDD = By.xpath("//md-select[@placeholder='Sender Email Address']");
		wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		click(EmailAddressDD);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@healthcareenrollmentcenter.com'] | //md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
		MoveToElementClick(element);
		String AgentEmailAction = "leoagent@yopmail.com";
		writeText(AddEmailAddressCheckBox, AgentEmailAction + Keys.ENTER);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
		writeText(EmailSubject, AgentEmailSubject);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email has been added");

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		Assert.assertTrue(driver.findElement(AgentEmailInc).isDisplayed());
		ExtentSuccessMessage("Assertion for mail has been done");
	
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);

		waitForElement(8000);
		By DocumentDD1 = By
				.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
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
		
//		Thread.sleep(5000);
//		By AttachmnetName = By.cssSelector("#upload-file-info > ul > li > a");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmnetName));
//        String attachmnet = element.getText();
//        System.out.println(attachmnet);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Attachment has been added");
		
		Thread.sleep(7000);
//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
//		ExtentSuccessMessage("Assertion has been done");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
		// element.click();
		Thread.sleep(600);
		Select select = new Select(element);
		select.selectByVisibleText("Send Email");
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
		writeText(CommentTextArea, "This Task is created VIA Automation");
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been added");

		waitForElement(8000);
		By TaskInc = By.cssSelector("#fixed > ul > li");
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		By Documnets = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(11) > div.col-xl-9.col-lg-6.left-section.details > div:nth-child(2) > div > ul > li:nth-child(6) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Documnets));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Documents Sections");
		
		Thread.sleep(3000);
		By DocumnetGallery = By.xpath("//md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumnetGallery));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Documents Gallery Sections");
		
		Thread.sleep(3000);
//		By Attachmnet = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Attachmnet));
//		String attachmnet1 = element.getText();
//		System.out.println(attachmnet1);
//		 
//        Assert.assertEquals(attachmnet1, attachmnet);
//		ExtentSuccessMessage("Assertion for Attachment name is done in Documnet Gallery");

        Thread.sleep(2000);
		By DashBoard = By.xpath("//a[@id='menu_Dashboard']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On DashBoard Option");
		
		By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My TaskOption Option");
		
		Thread.sleep(4000);
		By LeadsName = By.xpath("//span[contains(.,'" + fullname + "')]");
		waitVisibility(LeadsName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		String name =element.getText();
		System.out.println(name);
		
		Assert.assertEquals(name, fullname);
		ExtentSuccessMessage("Task is Visible under MY-Task Section");
		waitVisibility(LeadsName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		MoveToElementClick(element);
		Thread.sleep(4000);
		 
		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		
		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(3000);
		
		By DeleteTask = By.xpath("(//i[@class='fa fa-trash red-color pull-right ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Task Button");
		
		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been Deleted");		
		

		
	}

	public int getRandomNumber1() {
		Random r = new Random();
		int ran = r.nextInt(100);
		return ran;
	}

	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(3000);
		return ran;
	}

	public void salesOpportunityAdvancedSearch2() throws InterruptedException {

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityOpen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseAsLost));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Opportunity Close As Lost");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseWon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Opportunity Close As Won");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Qualified");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppRenewal));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Renewal");
		waitForElement(9000);
		click(OppSearch);

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(OppSearch);

	}

	public void salesOpportunityAdvancedSearch() throws InterruptedException {

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityOpen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(5000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseAsLost
		 * )); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Opportunity Close As Lost");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseWon));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Opportunity Close As Won");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualify));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Qualified");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppRenewal));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Renewal");
		 * waitForElement(9000); click(OppSearch);
		 * 
		 * waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Cancel");
		 * waitForElement(9000); click(OppSearch);
		 */

	}

}
