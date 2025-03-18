package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Common.ActionClasss;

public class CustomerEngageFunctionalityValidations extends BasePage {

	private static final String Annual = null;
	private static final String URL1 = null;

	public CustomerEngageFunctionalityValidations(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;
	public String ExpectedResult = "Applicants were excluded from the quote because they may be eligible for Medicaid/CHIP.";
	String imgSrc;
	String expectedText;
	String savingsAmount;
	String AddedApplicantExpected = "Zip: 33433, 3 Applicants, Income: $25,000";
	String actualText;
	public String fullName;
	public String firstName;
	public String lastName;
	public String getEmailValue;
	public String agentUserName;
	public String getLastName;
	public String getFirstName;
	public String actualString = "Congratulations! Your application has been submitted successfully";
	public String EmailText;
	public String AgentText;
	public String NoteText;
	public String CarrierText;
	public String Campaign;
	public String ValidEmailText;
	public String NumberOutput;
	public String NumberOutput1;
	public String LeadNumber;
	public String Revenue1;

	By userID = By.id("user-name");// ------//for userid at Login page
	By pwd = By.id("password");// -------for password at home page
	By signIn = By.xpath("//*[@id='form-validation-button']");// -------for button on home page

	private By CheckUserLogin = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By SelectUser = By.xpath("//a[@class='nav-link dropdown-toggle']");
	private By SelectLogout = By.xpath("(//a[contains(.,'Log Out')])[1]");
	private By LogoutButtonConfirmation = By.xpath(
			"//a[@class='modal-action tertiary_background waves-effect waves-light btn-large ConfirmForceLogin']");
	private By MainMenu = By.xpath("//li[@class='link_menu hide-on-med-and-down sideMenuHamburger']");
	private By CustomerInformationTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(1) > a");
	private By SettingsTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(8) > a");
	private By AgencyDetailsTab = By
			.cssSelector("#sideMenuContent > div > ul > li.active > div > ul > li:nth-child(1) > a");
	private By AddButton = By.xpath("//a[@id='add_buton']");
	private By HomeButton = By.id("menu_home");
	private By MarketingTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-bar-chart-o']");
	private By MarketingList = By.xpath("(//a[contains(.,'Lists')])[2]");
	private By ReportRunButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By ReportInc = By.xpath(
			"//div[@class='dx-datagrid-rowsview dx-datagrid-nowrap dx-scrollable dx-visibility-change-handler dx-scrollable-both dx-scrollable-simulated dx-scrollable-customizable-scrollbars']");

	private By ScheduleReport = By.xpath("//a[contains(.,'Scheduled Reports')]");
	private By CreateScheduleButton = By.xpath("//button[@name='createScheduleBtn']");
	private By ScheduleReportName = By.xpath("//input[@name='ScheduleName']");
	private By RecurrencePattern = By.xpath("//span[text()='Once']");
	private By EmailToField = By.xpath("//md-chips[@name='CRMEmailId']");
	private By ReportSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By PivotReport = By.xpath("//a[contains(.,'Pivot Reports')]");
	private By PivotStartDate = By
			.xpath("(//md-input-container[@class='md-block md-input-has-placeholder md-input-has-value'])[1]/input");
	private By RunPiviotReportButton = By.xpath("//button[@class='btn btn-default green pull-right']");

	private By ValidateListButton = By.id("createNewList");
	private By ListName = By.xpath("//input[@name='ListName']");
	private By SegmentedList = By.xpath("(//a[contains(.,'Segmented List')])[2]");
	private By NewSegmentedListButton = By.id("createNewDynamicBtn");
	private By MarketingTemplate = By.xpath("(//a[contains(.,'Templates')])[2]");
	private By NewTemplateButton = By.id("NewTemplateBtn");
	private By MarketingCampaign = By.xpath("//a[@href='#/marketing/campaigns']");
	private By CreateCampaign = By.id("createNewCamapign");
	private By PromotionalCampaign = By.id("PROMOTIONAL_CAMPAIGNS");

	private By SalesButton = By.xpath("//span[text()='Sales ']");
	private By Leads = By.xpath("(//a[text()='Leads'])[2]");
	private By NewLead = By.xpath("//button[@name='newLeadBtn' and @id='newLeadBtn'] ");

	private By CallCampaignName = By.name("CampaignName");
	private By CampaignCategory = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
	private By CallCampaignObjective = By.name("CampaignObjective");
	private By CallCampaignDetailsNextButton = By.xpath("(//button[contains(.,'Next')])[1]");
	private By CallListSearchField = By.xpath("//input[@ng-model='listSearchKey'] | //input[@type='search']");
	private By CallListCheckBox = By.xpath("(//span[@class='dx-checkbox-icon'])[2]");
	private By CallCampaignSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right ng-scope']");
	private By LaunchButton = By.xpath("(//a[@class='edit-list-icons'])[2]");

	private By ListDetailNextButton = By.xpath("(//button[@class='btn btn-default green'])[2]");
	private By ListDefaultTemplate = By.id("defaultTemplate");
	private By UploadListNextButton = By.xpath("//button[@class='btn btn-default green']");
	private By DOBDeleteIcon = By.xpath(
			"((//td[text()='Dob'])[1]/following-sibling::td)[3]/button[@class='btn btn-default green glyphicon glyphicon-trash']");
	private By AlertAcceptButton = By.xpath("//button[@ng-click='confirmModalCtrl.Confirm()']");
	private By DOBCheckList = By.xpath("//label[contains(.,'Dob ')]");
	private By AOREMmail = By.xpath("//label[contains(.,'AOR Email')]");
	private By MapButton = By.xpath("//button[@ng-click='add()']");
	private By MarketingListSaveButton = By.xpath("//button[contains(.,'Submit')]");
	private By SegmentedListName = By.xpath("//input[@id='SegmentedListName']");
	private By BuissnessObjectDD = By.id("businessObject0");
	private By SegmentedSelectField = By.xpath("//md-select[@name='parameter0']");
	private By ValueTextField = By.id("value0");
	private By AddNewFieldButton = By
			.xpath("//button[@class='btn btn-primary pull-left btn-yellow criteria-add-button']");
	private By SegmentedSelectField2 = By.id("parameter1");
	private By ValueTextField2 = By.name("value1");
	private By PrieviewDataButton = By.id("applycriteriaSearchBtn");
	private By SegmentedListSaveButton = By.xpath("(//button[@class='btn btn-default green'])[2]");
	private By TemplateDetailField = By.name("OfferName");
	// private By ExistingTemplate = By.xpath("(//span[contains(.,'My Existing
	// Templates')])[1]");
	private By DefaultTemplate = By.xpath("((//div[@class='col-md-12 margin-bottom-20 pad-lt pad-rt'])[1]/div/div)[1]");
	private By PreviewButton = By.xpath("(//button[contains(.,'Preview')])[11]");
	private By CloseButton = By.xpath("//button[@class='btn btn-primary btn-default grey']");
	private By DefaultTemplate1 = By
			.xpath("((//div[@class='col-md-12 margin-bottom-20 pad-lt pad-rt'])[1]/div/div)[1]");
	private By SelectButton = By.xpath("(//button[contains(.,'Select')])[11]");
	private By Frame = By.xpath("/html/body/div[3]/div[6]/div/ui-view//iframe");
	private By TemplateSubmitButton = By.xpath("(//button[text()='Submit'])[1]");
	private By CampaignName = By.name("CampaignName");
	private By CampaignObjective = By.name("CampaignObjective");
	private By CampaignDetailsNextButton = By.xpath("(//button[contains(.,'Next')])[1]");
	private By SearchField = By.xpath(
			"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By TemplateCheckBox = By.xpath("(//div[@role='button'])[1]");
	private By TemplateNextButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By ListSearchField = By.xpath("//input[@ng-model='listSearchKey'] | //input[@type='search']");
	private By ListCheckBox = By.xpath("(//span[@class='dx-checkbox-icon'])[2]");
	private By ListNextButton = By.xpath("//button[@class='btn btn-default green pull-right ng-scope']");
	private By EmailSendersName = By.xpath(
			"(//input[@class='full-width ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required'])[1]");
	private By EmailSubjectLine = By.xpath(
			"(//input[@class='full-width ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required'])[1]");
	private By EmailConfigButtonNextButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By TestAndPreviewEmailField = By.xpath("//input[@ng-model='senderEmailId']");
	private By TestEmailButton = By.xpath("//button[contains(.,'Test Email')]");
	private By CreateCampaignButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By ConfirmButton = By.xpath("(//div[@class='md-container md-ink-ripple'])[5]");
	private By SearchTextField = By.xpath(
			"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By EmailCampaignLaunchButton = By.xpath("(//a[@class='edit-list-icons'])[2]");

	private By SourceDropDown = By.xpath("//md-select[@name='ListSource']");
	private By AgentFirstName = By.xpath("//input[@id='FirstName']");
	private By AgentLastName = By.xpath("//input[@id='LastName']");
	private By AgentRole = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]");
	private By AgentRoleSelection = By.xpath("(//span[contains(.,'Agent')])[1]");
	private By AgentPhone = By.xpath("(//input[@id='Phone'])[1]");
	private By AgentEmail = By.xpath("(//input[@id='Email'])[1]");
	private By MedicareCustomer = By.xpath("//a[@class='medicaredatalistingmenu']");
	private By AgencyTile = By.xpath("//a[@class='glyphicon fa fa-building']");
	private By AgencyAgent = By.xpath("(//a[contains(.,'Agents')])[1]");
	private By NewAgentButton = By.id("createNewAgentBtn");
	private By AdminTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-black-tie']");
	private By AdminRolesAndPermission = By.xpath("(//a[contains(.,'Roles/Permissions')])[2]");
	private By AddRolesAndPermissionButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By ReportTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-file-text']");
	private By StartDate = By
			.xpath("(//md-input-container[@class='md-block md-input-has-placeholder md-input-has-value'])[1]/input");
	private By CarrierSelectionDD = By.xpath("(//md-select-value[@class='md-select-value'])[3]");

	private By LiveReport = By.xpath("//a[contains(.,'Live Reports')]");
	private By DashBoardTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-dashboard']");
	private By DashBoardMyTask = By.xpath("(//a[contains(.,'My Tasks')])[2]");
	private By DashBoardCalendar = By.xpath("(//div[@class='dx-button-content'])[2]");
	private By CommissionTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-usd']");
	private By CommissionSetup = By.xpath("(//a[contains(.,'Commission Setup')])[3]");
	private By CommissionSetupTitle = By.xpath("(//span[contains(.,'Commission Setup')])[2]");
	private By CTIIcon = By.xpath("(//i[@class='fa fa-phone'])[1]");
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By CTIDialPadIcon = By.xpath("//a[@class='fa fa-th voice-active']");
	private By CallBackNotificationIcon = By.xpath("//a[@title='Call back Notifications']");
	private By CallBackNitificationTitle = By.xpath("//strong[contains(.,'Callback Notifications')]");
	private By CallBackNitificationMinimizeIcon = By.xpath("//i[@class='fa fa-times']");
	private By MyProfileIcon = By.xpath("//a[contains(.,'My Profile')]");
	private By MyProfileSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");

	private By AddCustomer = By.xpath("//a[@id='btnAddCustomer']");
	private By CustomerFirstname = By.xpath("(//input[@id='PersonDetails_FirstName'])[1]");
	private By CustomerLastname = By.xpath("(//input[@id='PersonDetails_LastName'])[1]");
	private By CustomerGender = By.cssSelector(
			"#AddCustomer > fieldset > div:nth-child(4) > div:nth-child(2) > div > input , #AddCustomer > fieldset > div:nth-child(5) > div:nth-child(2) > div > input");
	private By GenderName = By.xpath("(//span[contains(.,'Male')])[1]");
	private By CustomerDOB = By.xpath("(//input[@id='PersonDetails_DateOfBirth'])[1]");
	private By CustomerAddressLine = By.xpath("(//input[@id='PersonDetails_Addresses_0__Address1'])[1]");
	private By CustomerZipcode = By.xpath("(//input[@id='PersonDetails_Addresses_0__Zip'])[1]");
	private By SameMailingAddress = By.xpath("(//input[@id='isMailAddressSame'])[1]");
	private By SaveButton = By.xpath("(//a[contains(.,'Save')])[1]");
	private By ContactSaveButton = By.xpath("(//a[contains(.,'Save')])[3]");
	private By SaveButtonIUR = By.xpath("//button[@id='btnUpdateProducer']");
	private By PhoneNumber = By.xpath("//input[@id='PersonDetails_Phone1']");
	private By CustomerFullName = By
			.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By CustomerTile = By.xpath("(//a[@class='glyphicon fa fa-users'])[1]");
	private By ImportCustomerPolicyButton = By.id("importCustomerPolicyBtn");

	private By CustomerNameInCE = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	private By SelectCustomerToEdit = By
			.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By ClickOnEditButton = By.xpath("//a[@class='square_anchor float_r editCustomer closeEdit']");
	private By EditLastName = By.xpath("//input[@id='customer_PersonDetails_LastName']");
	private By EditFirstName = By.xpath("//input[@id='customer_PersonDetails_FirstName']");
	private By EditSave = By.xpath("//a[@class='waves-effect waves-light btn primary_background btnUpdateCustomer']");
	private By ServiceTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-gears']");
	private By NewServiceRequestButton = By.id("createServiceRequestBtn");
	private By IVRManagementTile = By.xpath("//a[@class='glyphicon fa fa-sitemap']");
	private By IVRManagementPrompt = By.xpath("(//a[contains(.,'Prompts')])[2]");
	private By IVRNewPromptButton = By
			.xpath("//button[@class='btn btn-default pull-right btn-yellow ng-binding ng-scope']");
	private By SMSCampaignName = By.name("CampaignName");
	private By SMSCampaignCategory = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
	private By SMSCampaignObjective = By.name("CampaignObjective");
	private By SMSCampaignDetailsNextButton = By.xpath("(//button[contains(.,'Next')])[1]");
	private By MessageTextArea = By.xpath("//textarea[@class='form-control SMSTextBox']");
	private By CreateMessageNextButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By SMSListSearchField = By.xpath("//input[@ng-model='listSearchKey'] | //input[@type='search']");
	private By SMSListCheckBox = By.xpath("//td[@aria-label='Select all']");
	private By SMSListnextButton = By.xpath("//button[@class='btn btn-default green pull-right ng-scope']");
	private By SMSTestNumberField = By.xpath("	//input[@ng-model='senderNumber']");
	private By SMSTestNumberButton = By.xpath("(//button[@class='btn btn-default green pull-left'])[2]");
	private By SMSCreateCampaignButton = By.xpath("//button[@class='btn btn-default green pull-right']");
	private By SMSConfirmationButton = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By SMSLaunchButton = By.xpath("(//a[@class='edit-list-icons'])[2]");
	private By SMSconfirmationButton = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");

	// AgencyElemenet

	private By SelectLogoutBE = By.xpath("(//a[contains(.,'Sign Out')])[1]");
	private By SelectUserBE = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAdminUserBE = By.xpath("//a[@class='dropdown-trigger-user']");
	private By LoginAsAgency = By.cssSelector("#dropdown1 > li:nth-child(1) > a");
	private By ClickOnCloseButton = By.xpath("//*[@class='close_icon modal-close right']");
	private By RequestForLogin = By.xpath("//span[contains(.,'Request for Login')]");
	private By YopmailInbox = By.xpath("//input[@id='login']");
	private By YopmailSubmit = By.xpath("//button[@title='Check Inbox @yopmail.com']");
	private By ClickHere = By.cssSelector("#mail > div > p:nth-child(5) > a");
	private By NumberNPN = By.xpath("//input[@id='NationalProducerNumber']");
	private By AgentUserName = By.xpath("//input[@id='User_UserName']");
	private By AgentPassword = By.xpath("//input[@id='User_Password']");
	private By AgentRetypePassword = By.xpath("//input[@id='User_ReTypePassword']");
	private By SecurityQuestion1 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityQuestionSelection1 = By
			.xpath("(//span[contains(.,'What Is The Name Of Your Favorite Childhood Friend?')])[1]");
	private By SecurityQuestionSelection2 = By.xpath("(//span[contains(.,'In Which City Were You Born?')])[2]");
	private By SecurityQuestionSelection3 = By.xpath("(//span[contains(., \"What Is Your Best Friend's Name?\")])[3]");
	private By SecurityQuestion2 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityQuestion3 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityAnswer1 = By.xpath("//input[@id='User_SecurityAnswer1']");
	private By SecurityAnswer2 = By.xpath("//input[@id='User_SecurityAnswer2']");
	private By SecurityAnswer3 = By.xpath("//input[@id='User_SecurityAnswer3']");
	private By TermsAndCondition = By.xpath("//input[@id='User_EulaCheck']");
	private By PersonConscent = By.xpath("//input[@id='PersonConscent']");
	private By DashboardTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-dashboard']");
	private By ClickOnMyTasks = By.cssSelector(
			"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-lg-12.right-section-div.details.pad-lt.col-xl-3 > div > ul > li:nth-child(4) > a");
	private By ClickMyTasks = By.xpath("(//a[contains(.,'My Tasks')])[2]");
	private By TaskComments = By.cssSelector("#filter-by > div:nth-child(1) > form > div:nth-child(7) > textarea");
	private By CreateTaskSubmit = By
			.cssSelector("#filter-by > div:nth-child(1) > form > div:nth-child(7) > button:nth-child(3) > i");
	private By HomeMenu = By.xpath("//a[@id='menu_home']");
	private By DayView = By.xpath("(//div[@class='dx-item dx-tab'])[1]");
	private By WeekView = By.xpath("(//div[@class='dx-item dx-tab'])[1]");
	private By MonthView = By.xpath("(//div[@class='dx-item dx-tab'])[2]");
	private By Day_Week_Month_ViewTask = By.xpath("(//div[@class='appointment-preview'])[1]");
	private By EditTask = By
			.xpath("(//button[@class='btn btn-default pull-right edit-note-icon icons red-color ng-scope'])[1]");
	private By EditTaskComments = By.cssSelector(
			"#page-wrapper > div > ui-view > div.row.col-md-3.pad-rt.pad-lt.task-main-div.ng-scope > div.task-data > div > div.container-fluid.notes > form > div:nth-child(7) > textarea");
	private By SubmitEditedTask = By.cssSelector(
			"#page-wrapper > div > ui-view > div.row.col-md-3.pad-rt.pad-lt.task-main-div.ng-scope > div.task-data > div > div.container-fluid.notes > form > div:nth-child(7) > button:nth-child(3) > i");
	private By DeleteTask = By
			.xpath("(//button[@class='btn btn-default pull-right edit-note-icon icons red-color delete'])[1]");
	private By PopUpDeleteYes = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By FindInsuranceButton = By.xpath("//a[contains(.,'Find Insurance')]");
	private By HealthEnrollment = By.xpath("//a[@class='PopupClassDynamic no-padding' and @lob='Health']");
	private By ZipCode = By.xpath("//input[@id='ZipCode']");
	private By SeePlans = By.xpath("//button[contains(.,'See Plans')]");
	private By GenderOfApplicant = By.cssSelector(
			"body > main > div.container > div > div > div > form > fieldset > div:nth-child(12) > div.widget_content > div.row.margin_bottom_0px.censuslist.Applicantcensus.showncensus > div > div.col.s12.m3.l3 > div > div.select-wrapper > input");
	private By GenderSelection = By.xpath("(//span[contains(.,'Male')])[1]");
	private By ApplicantDOB = By.xpath("//input[@id='CoveredMembers_0__DateOfBirth']");
	private By PlanLabelAmbetter = By.xpath("(//input[@data-plantypename='Ambetter'])[1]");
	private By AddToCartButton = By.xpath("(//*[@id='mcmqAddToCart'])[1]");
	private By ContinueWithThisPlanCart = By.xpath("//a[contains(.,'Cart')]");
	private By ClickSelectButton = By.xpath("//a[contains(.,'Select')]");
	private By BeginEnrollment = By.xpath(
			"//a[@class='full_width_button waves-effect waves-light primary_background BeginEnrollmentAfterContactInformation toggleBeginEnrollmentForMedicare']");
	private By ContactFirstName = By.xpath("(//input[@id='ContactInformation_FirstName'])[5]");
	private By ContactLastName = By.xpath("(//input[@id='ContactInformation_LastName'])[5]");
	private By ContactPhone = By.xpath("(//input[@id='ContactInformation_PhoneNumber'])[4]");
	private By HouseholdAddress = By.xpath("//input[@id='Address_0__Address1']");
	private By ClickNext = By.xpath("//a[@id='yourNextPage']");
	private By SEPEvents = By.xpath("//select[@id='SepEvent_SepEventKey']");
	private By SEPEventDate = By.xpath("//input[@id='SepEvent_SepEventDate']");
	private By CustomerNameSEP = By.xpath("//select[@id='SepEvent_CustomerPersonId']");
	private By AddEventSEP = By.xpath("//button[@id='btnAddSEPEvent']");
	private By ClickSEPNext = By.xpath("//a[@id='citizenDocumentNextPage']");
	private By AppliedCircumstancesNext = By.xpath("//a[@id='AdditionalyourNextPage']");
	private By IncomeType = By.xpath("//select[@id='IncomeDetail_0__Type']");
	private By IncomeFrequency = By.xpath("//select[@id='IncomeDetail_0__AmountFrequency']");
	private By IncomeValue = By.xpath("//input[@id='IncomeDetail_0__Amount']");
	private By NoneOfTheseHRA = By.xpath("(//input[@name='IsQSEHRANoneOfThese'])[1]");
	private By ClickNextHRA = By.xpath("//a[@id='HRA_yourNextPage']");
	private By ClickIdTerms = By.xpath("//*[@id='Terms']");
	private By ClickNextOnAgent = By.xpath("//*[@class='round_btn summary_next']");
	private By ClickNextOnPayment = By.xpath("//*[@class='round_btn paymentselection_next']");
	private By RoutingNumberField = By.xpath("//*[@id='Quotes_0__PaymentProfile_RoutingNumber']");
	private By BankAccountNumber = By.xpath("//*[@id='Quotes_0__PaymentProfile_BankAccountNumber']");
	private By AccountHolderName = By.xpath("//*[@id='Quotes_0__PaymentProfile_EFTAccountHolderName']");
	private By AccountType = By.xpath("//*[@id='Quotes_0__PaymentProfile_AccountType']");
	private By YesSameEFT = By
			.xpath("//input[@id='Quotes_0__RecurringPaymentSameAsInitialPaymentIndForEFT' and @value='true']");
	private By PaymentNext = By.xpath("//a[@class='round_btn payment_next']");
	private By SummaryNext = By.xpath("//a[@class='round_btn applicationsummary_next']");
	private By FullfilmentAgree = By.xpath("//*[@id='Fulfillment_Iagree']");
	private By SubmitButton = By.xpath("//a[@class='round_btn confirmEnrollment_next']");
	private By CongratulationsMessage = By.xpath("//*[@class='relatively_fixed_label bigger ']");
	private By EnrollmentFinish = By.xpath("//*[@class='enrollmentfinish ']");
	private By SalesTile = By.xpath("//a[@class='glyphicon fa fa-handshake-o']");
	private By SalesLead = By.xpath("(//a[contains(.,'Leads')])[2]");
	private By NewLeadButton = By.id("newLeadBtn");
	private By ClickQuotes = By.xpath("(//a[contains(.,'Quotes')])[2]");
	private By ClickLeads = By.xpath("(//a[contains(.,'Leads')])[2]");
	private By CreatedDate = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[7]");
	private By SelectBEUser = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAgency = By.xpath("(//a[contains(.,'Agency Details')])[1]");
	private By BusinessType = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[5]");
	private By LifeOfBusiness = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[6]");
	private By MarketingURLButton = By.id("MarketingURL_button");
	private By CopyMarketingURL = By.cssSelector("#generate_url_id > ul > li.margin_bottom_0px > p");
	private By SelectAgentLogout = By.xpath("(//a[contains(.,'Sign Out')])[2]");
	private By MarketingLabel = By.xpath("//label[contains(.,' Marketing Details')]");
	private By SaveProgress = By.xpath("//a[@class='save_progress_click_submitm']");
	private By LeadFirstname = By.xpath("//input[@id='yourname']");
	private By LeadLastname = By.xpath("//input[@id='lastname']");
	private By LeadEmail = By.xpath("//input[@id='youremail']");
	private By SaveLeadDetails = By.xpath("(//a[contains(.,'Save')])[2]");
	private By CallBackRequest = By.xpath("//a[@class='callBackButton request_callback_click_submitm']");
	private By LeadCBFirstname = By.xpath("(//input[@id='yourName'])[1]");
	private By LeadCBLastname = By.xpath("(//input[@id='yourName'])[2]");
	private By LeadPhoneNumber = By.xpath("(//input[@id='phnNum'])[1]");
	private By LeadSubmitButton = By.xpath("//a[contains(.,'Submit')]");

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void login_CE_validations() throws InterruptedException {
		waitForElement(20000);
		WebElement checkUserLoginElement = null;

		try {
			checkUserLoginElement = driver.findElement(CheckUserLogin);

			if (checkUserLoginElement.isDisplayed()) {
				click(CheckUserLogin);
				ExtentSuccessMessage(
						"You currently have an active session on another device hence Deactivated the other session!");
			} else {
				ExtentSuccessMessage("Login is successful");
			}
		} catch (NoSuchElementException e) {
			ExtentSuccessMessage(
					"CheckUserLogin element not found! So you currently Dont have an active session on another device, hence Login is successful");
		} catch (Exception e) {
			ExtentSuccessMessage("Application login inaccurate. Details: " + e.getMessage());
			e.printStackTrace();
		}
		waitForElement(10000);
	}

	public void logout_CE_validations() throws InterruptedException {
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogout));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been performed!");
		waitForElement(1000);
		driver.manage().deleteAllCookies();
		waitForElement(3000);
	}

	public void cti_Minimize() throws InterruptedException {
		waitForElement(5000);
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
		Thread.sleep(3000);
	}

	public void report_PivotReport() throws InterruptedException, AWTException {
//		 element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
//		   MoveToElementClick(element);// 
//					
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Report Tile has been clicked");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotReport));
		MoveToElementClick(element);
		ExtentSuccessMessage("PivotReport has been clicked");

		String currentSystemURL = driver.getCurrentUrl();

		if (currentSystemURL.contains("https://mme.brokerengage.net/")) {
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			element.clear();
			writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			ExtentSuccessMessage("Start Date has been clicked");

			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
			MoveToElementClick(element);
			By Accident = By.xpath("//md-option[@value='Accident']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Accident));
			MoveToElementClick(element);
			Thread.sleep(1000);

			By Carriername = By.xpath(
					"/html/body/div[3]/div[6]/div/ui-view/div/div[4]/div[2]/form/div[1]/div[1]/div[2]/md-content/div/div/div[6]/span[2]/span/md-input-container/md-select/md-select-value");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Carriername));
			MoveToElementClick(element);
			By CarrierOPtion = By.xpath("//md-option[@value='Ambetter From Sunshine Health']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
			MoveToElementClick(element);

		} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {

			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			element.clear();
			writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			ExtentSuccessMessage("Start Date has been clicked");

			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
			MoveToElementClick(element);
			Thread.sleep(1000);
			By CarrierOPtion = By
					.xpath("//md-option[@value='(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
			MoveToElementClick(element);

		}

		else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {

			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			element.clear();
			Thread.sleep(1000);
			element.sendKeys("03/01/2024" + Keys.ENTER);
			// writeText(StartDate, "03/01/2024" + Keys.ENTER);
			writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			ExtentSuccessMessage("Start Date has been clicked");

			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
			MoveToElementClick(element);
			Thread.sleep(1000);
			By CarrierOPtion = By
					.xpath("//md-option[@value='(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
			MoveToElementClick(element);

		}

		else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {

			By PivotStartDate = By.xpath(
					"/html/body/div[3]/div[6]/div/ui-view/div/div[4]/div[2]/form/div[1]/div[1]/div[2]/md-content/div/div/div[3]/span[2]/span/md-input-container/input");
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			element.clear();
			Thread.sleep(1000);
			writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			ExtentSuccessMessage("Start Date has been clicked");

			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
			MoveToElementClick(element);
			Thread.sleep(1000);
			By CarrierOPtion = By.xpath("//md-option[@value='Ambetter From Sunshine Health']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
			MoveToElementClick(element);

		} else {

			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PivotStartDate));
			element.clear();
			writeText(PivotStartDate, "01/01/2024" + Keys.ENTER);
			ExtentSuccessMessage("Start Date has been clicked");

			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierSelectionDD));
			MoveToElementClick(element);
			Thread.sleep(1000);
			By CarrierOPtion = By
					.xpath("//md-option[@value='(ANTHEM) ANTHEM BLUE CROSS LIFE AND HEALTH INSURANCE COMPANY']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierOPtion));
			MoveToElementClick(element);

		}
		/*
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_DOWN);
		 * Thread.sleep(1000); robot.keyRelease(KeyEvent.VK_DOWN); Thread.sleep(1000);
		 * robot.keyPress(KeyEvent.VK_ENTER); Thread.sleep(1000);
		 * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(1000);
		 * ExtentSuccessMessage("Carrier has been selected");
		 */

		element = wait.until(ExpectedConditions.presenceOfElementLocated(RunPiviotReportButton));
		Assert.assertTrue(driver.findElement(RunPiviotReportButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		MoveToElementClick(element);
		ExtentSuccessMessage("RunPiviotReportButton has been selected");

	}

	public void report_ScheduleReport() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
	 	MoveToElementClick(element);
		ExtentSuccessMessage("Report Tile has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleReport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Schedule Report has been clicked");

		waitForElement(12000);
		if (ElementDisplayed(CreateScheduleButton)) {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateScheduleButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Schedule Report Button has been clicked");
		} else {
			RefreshPage();
			waitForElement(5000);
			ClickOnMinimizeCallwindow();
			waitVisibility(ScheduleReport);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleReport));
			MoveToElementClick(element);
			ExtentSuccessMessage("Schedule Report has been clicked");
			waitForElement(8000);
			waitVisibility(CreateScheduleButton);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateScheduleButton));
			MoveToElementClick(element);
			ExtentSuccessMessage("Schedule Report Button has been clicked");
			waitForElement(5000);
			ExtentSuccessMessage("Schedule Report Created Successfully");
		}

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleReportName));
		MoveToElementClick(element);
		String ScheduleName = "AutoReport" + getRandomNumber();
		writeText(ScheduleReportName, ScheduleName);

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecurrencePattern));
		MoveToElementClick(element);
		ExtentSuccessMessage("RecurrencePattern Report Button has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailToField));
		MoveToElementClick(element);
		writeText(EmailToField, "LeoAgent@yopmail.com" + Keys.ENTER);

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportSubmitButton));
		Assert.assertTrue(driver.findElement(ReportSubmitButton).isEnabled());
		MoveToElementClick(element);
		ExtentSuccessMessage("Submit Button has been clicked");

		waitForElement(15000);
		By name = By.xpath("//div[contains(text(),'" + ScheduleName + "')]");
		waitVisibility(name);
		Assert.assertTrue(ElementDisplayed(name));
		ExtentSuccessMessage("Assetion Done");

	}

	public void ClickOnMinimizeCallwindow() throws InterruptedException {
		if (ElementDisplayed(CTIMinimizeIcon)) {
			ExtentSuccessMessage("Successfully user able to See 'Minimize Icon' ");
			click(CTIMinimizeIcon);
			ExtentSuccessMessage("Successfully user Clicked on 'Minimize Icon' ");
		} else {
			ExtentSuccessMessage("Unsuccessfully 'Minimize' Not visible");
		}
		Thread.sleep(2000);
	}

	public void report_LiveReport(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {

				
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Report Tile has been clicked");
		
		Thread.sleep(4000);
		By EmailMarketing = By.xpath("(//div[@class='dx-treeview-toggle-item-visibility'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailMarketing));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Email Marketing Report");
		
		Thread.sleep(2000);
		By EmailCampaignSummary = By.cssSelector("#reportTreeGrid > div > div > div > div.dx-scrollable-content > ul > li:nth-child(3) > ul > li:nth-child(1) > div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailCampaignSummary));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Email Campaign Summary Report");
		
		Thread.sleep(4000);
		By ReportingDuration = By.xpath("(//md-select-value[@class='md-select-value'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportingDuration));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Reporting Duration DropDown");
		
		Thread.sleep(3000);
		By Today = By.xpath("//md-option[@value='Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Today));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Today Option");
		
		Thread.sleep(2000);
		By RunReport = By.xpath("//button[@id='runReportBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RunReport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on RunReport Button");
		
		Thread.sleep(4000);
		By EmailCampaignName = By.xpath("//tr[@class='dx-row dx-data-row dx-column-lines']/td[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailCampaignName));
		String text = element.getText();
        System.out.println(text);
        System.out.println(ApplicantInfo.EmailCampaign);
        
        
        
		

	}

	public void create_Lead(CensusInfo ApplicantInfo) throws InterruptedException {

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
		lastName = "User" + getRandomNumber();
		writeText(LeadLastName, lastName);
		ExtentSuccessMessage("Last name of lead has been enterd");

		waitForElement(1000);
		By LeadPhoneNumber = By.xpath("//input[@name='LeadMobile']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		LeadNumber = generatePhoneNumber();
		System.out.println(LeadNumber);
		writeText(LeadPhoneNumber, LeadNumber);
		ExtentSuccessMessage("Mobile Number of lead has been added");

		waitForElement(4000);
		By LeadInfomation = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[16]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadInfomation));
		MoveToElementClick(element);

		waitForElement(1000);
		By LeadRevenue = By.xpath("//input[@name='Revenue']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadRevenue));
		MoveToElementClick(element);
		Revenue1 = "1" + getRandomNumber1();
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

		waitForElement(3000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);

		waitForElement(4000);
		By HomeButton = By.xpath("//a[@name='menu_home']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);

	}

	public void validate_Revenue_SegmentedList() throws InterruptedException {

		waitForElement(6000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		waitForElement(4000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Segmented has been clicked");
		waitForElement(3000);

		waitForElement(4000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewSegmentedListButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("NewSegmentedList Button has been clicked");
		waitForElement(3000);

		waitForElement(4000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedListName));
		String SegmentdListName = "RevenueSegmentedList" + getRandomNumber();
		writeText(SegmentedListName, SegmentdListName);
		ExtentSuccessMessage("Segmented List name has been entered");

		Assert.assertTrue(driver.findElement(SegmentedListName).isEnabled());
		ExtentSuccessMessage("Assertion is done");

		waitForElement(4000);
		// For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessObjectDD));
		MoveToElementClick(element);
		waitForElement(2000);

		By Lead = By.xpath("//md-option[@value='Leads']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedSelectField));
		MoveToElementClick(element);

		Thread.sleep(2000);
		By Revenue = By.xpath("//md-option[@value='Estimated Revenue']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Revenue));
		MoveToElementClick(element);

		waitForElement(5000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValueTextField));
//		String ExpectedRevenue = "100";
		writeText(ValueTextField, Revenue1);
		ExtentSuccessMessage("Email has been Entered");
		Thread.sleep(2000);

		waitForElement(1000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrieviewDataButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("PreviewData Button has been selected");
		Thread.sleep(2000);

		waitForElement(3000); // For UAT NewSegmentedListButton
		By FirstUserNumber = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstUserNumber));
		String UserNumber = element.getText();
		System.out.println(UserNumber);

		By SegmnetdListData = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmnetdListData));
		Assert.assertTrue(driver.findElement(SegmnetdListData).isDisplayed());
		ExtentSuccessMessage("Data of Segmented list is available");

		waitForElement(3000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedListSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Save Button has been Clicked");
		Thread.sleep(2000);

		Thread.sleep(5000);

		By SerachText = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SerachText));
		MoveToElementClick(element);
		writeText(SerachText, SegmentdListName + Keys.ENTER);
		ExtentSuccessMessage("Segmented List has been Searched");

		Thread.sleep(5000);
		By Name = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Name));
		String name = element.getText();

		Assert.assertEquals(name, SegmentdListName);
		ExtentSuccessMessage("Assertion For segmented Name List is done");

		By DeletedIcon = By.xpath("//a[@class='edit-list-icons'][3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeletedIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Icon");

		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Segmented list deleted succesfully");

	}

	public void succesfull_CustomList_Upload(CensusInfo ApplicantInfo) throws InterruptedException {

		waitForElement(2000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing list has been clicked");

		waitForElement(1000);
		By ListInputField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(ListInputField, ApplicantInfo.CustomListName + Keys.ENTER);

		waitForElement(3000);
		By LoadingStatus = By.xpath("//div[@title='Loading Completed']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LoadingStatus));
		String LStatus = element.getText();
		System.out.println(LStatus);

		String ImportStatusMessage = "Loading Completed";

		waitForElement(1000);
		Assert.assertEquals(LStatus, ImportStatusMessage);
		ExtentSuccessMessage("Assertion for Import Status is done:-" + ImportStatusMessage);

		By Listmember = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000C']/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Listmember));
		String Member = element.getText();
		System.out.println(Member);

		String TotalMember = "3";
		waitForElement(1000);
		Assert.assertEquals(Member, TotalMember);
		ExtentSuccessMessage("Assertion for Total Number is done:-" + Member);

		By Status = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000D']/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		String StatusText = element.getText();
		System.out.println(StatusText);

		String ListStatus = "Active";
		Assert.assertEquals(StatusText, ListStatus);
		ExtentSuccessMessage("Assertion for ListStatus is done" + StatusText);

	}

	public void custom_Template(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException {

		waitForElement(6000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing list has been clicked");
		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValidateListButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create List Button has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListName));
		MoveToElementClick(element);
		String CustomMarketingListName = "AutoCustomLIST" + getRandomNumber();
		writeText(ListName, CustomMarketingListName);
		writeCustomListnameToExcel(CustomMarketingListName, "TC CE2");
		waitForElement(3000);
		ExtentSuccessMessage("List Name has been entered");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListDetailNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been entered");
		waitForElement(3000);

		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ListDefaultTemplate));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("ListDefaultTemplate has been downloaded");
		 * waitForElement(3000);
		 */

		Base_Class.MouseClick(By.xpath("//div[text()='Select File']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Custom Template.xlsx";
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

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(UploadListNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next Button has been Clicked");

		waitForElement(4000);
		By FileUploadpopup = By.xpath("//div[@id='divSuccesss']");
		Assert.assertTrue(driver.findElement(FileUploadpopup).isDisplayed());
		ExtentSuccessMessage("Assertion is done and list has been upload succesfully");

		waitForElement(4000);
		By AlternateEmailDeleteIcon = By.xpath(
				"((//td[text()='AlternateEmail'])[1]/following-sibling::td)[3]/button[@class='btn btn-default green glyphicon glyphicon-trash']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AlternateEmailDeleteIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Delete has been Clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AlertAcceptButton));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Alert popup has been Clicked");

		By AlternateEmailChecklist = By.xpath("//label[contains(.,'AlternateEmail ')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AlternateEmailChecklist));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Alternate Email has been Clicked");

		By Age = By.xpath("(//label[contains(.,'Age')])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Age));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Age has been Clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MapButton));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("MAP Button has been Clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingListSaveButton));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Save Button has been Clicked");

		waitForElement(30000);
		driver.navigate().refresh();

		By ListInputField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(ListInputField, CustomMarketingListName + Keys.ENTER);

		driver.navigate().refresh();
		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(ListInputField, CustomMarketingListName + Keys.ENTER);
		Thread.sleep(15000);

		By Listmember = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000C']/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Listmember));
		String Member = element.getText();
		System.out.println(Member);

		String TotalMember = "3";
		waitForElement(1000);
		Assert.assertEquals(Member, TotalMember);
		ExtentSuccessMessage("Assertion for Total Number is done:-" + Member);

		By Status = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000D']/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		String StatusText = element.getText();
		System.out.println(StatusText);

		String ListStatus = "Active";
		Assert.assertEquals(StatusText, ListStatus);
		ExtentSuccessMessage("Assertion for ListStatus is done:-" + StatusText);

		By ListName = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListName));
		MoveToElementClick(element);
		ExtentSuccessMessage("List name has been Clicked");

		Thread.sleep(5000);

		By ListMember = By.xpath("//div[@class='ui-grid-row ng-scope'][1]");
		Assert.assertTrue(driver.findElement(ListMember).isDisplayed());
		ExtentSuccessMessage("List Member Information is Displayed");

	}

	public String writeCustomListnameToExcel(String nameText, String sheetname) throws IOException {
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

	public void marketing_segmented_list() throws InterruptedException, AWTException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles SegmentedList

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		waitForElement(4000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Segmented has been clicked");
		waitForElement(3000);

		waitForElement(4000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewSegmentedListButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("NewSegmentedList Button has been clicked");
		waitForElement(3000);

		waitForElement(4000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedListName));
		String SegmentdListName = "AutoSegmentedList" + getRandomNumber();
		writeText(SegmentedListName, SegmentdListName);
		ExtentSuccessMessage("Segmented List name has been entered");

		Assert.assertTrue(driver.findElement(SegmentedListName).isEnabled());
		ExtentSuccessMessage("Assertion is done");

		waitForElement(4000);
		// For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessObjectDD));
		MoveToElementClick(element);
		waitForElement(2000);
		By List = By.xpath("//md-option[@value='Lists']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(List));
		MoveToElementClick(element);

		waitForElement(3000);
		Robot robot = new Robot();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedSelectField));
		MoveToElementClick(element);

		Thread.sleep(2000);
		By EmailOption = By.xpath("//md-option[@value='Email']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailOption));
		MoveToElementClick(element);

		Thread.sleep(1000);
		ExtentSuccessMessage("Email has been selected");

		waitForElement(5000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValueTextField));
		writeText(ValueTextField, "sunpreet.bhatiya@speridian.com");
		ExtentSuccessMessage("Email has been Entered");
		Thread.sleep(2000);

		waitForElement(1000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewFieldButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Add new Field Button has been Clicked");
		Thread.sleep(2000);

		waitForElement(1000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedSelectField2));
		MoveToElementClick(element);
		Thread.sleep(2000);
		By GenderValue = By.xpath("(//md-option[@value='Gender'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderValue));
		MoveToElementClick(element);
		ExtentSuccessMessage("Gender has been selected");

		waitForElement(1000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValueTextField2));
		MoveToElementClick(element);
		Thread.sleep(2000);
		By FemaleValue = By.xpath("//md-option[@value='Female']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FemaleValue));
		MoveToElementClick(element);

		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);

		ExtentSuccessMessage("Female has been selected");

		waitForElement(1000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrieviewDataButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("PreviewData Button has been selected");
		Thread.sleep(2000);

		Thread.sleep(15000);
		By Data = By.xpath("(//div[@class='ui-grid-viewport ng-isolate-scope'])[2]");
		Assert.assertTrue(driver.findElement(Data).isDisplayed());

		waitForElement(1000); // For UAT NewSegmentedListButton
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SegmentedListSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Save Button has been Clicked");
		Thread.sleep(5000);

		By SerachText = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SerachText));
		MoveToElementClick(element);
		writeText(SerachText, SegmentdListName + Keys.ENTER);
		ExtentSuccessMessage("Segmented List has been Searched");

		Thread.sleep(5000);
		By Name = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Name));
		String name = element.getText();

		Assert.assertEquals(name, SegmentdListName);
		ExtentSuccessMessage("Assertion For segmented Name List is done");

		By DeletedIcon = By.xpath("//a[@class='edit-list-icons'][3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeletedIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Icon");

		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Segmented list deleted succesfully");

	}

	public void marketing_Template(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException {

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTemplate));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Template has been clicked");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewTemplateButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Template has been clicked");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateDetailField));
		MoveToElementClick(element);
		String MarketingTemplateName = "Template" + getRandomNumber();
		writeText(TemplateDetailField, MarketingTemplateName);
		writeTemplatenameToExcel(MarketingTemplateName, "TC CE2");
		ExtentSuccessMessage("New Template name has been Entered");

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DefaultTemplate));
		ActionClasss.movetoElement(element, driver);
		// MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(PreviewButton));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Template has been Previewed");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Exisiting Template has been closed");

		waitForElement(11000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DefaultTemplate1));
		ActionClasss.movetoElement(element, driver);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectButton));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Template has been selected");

		String currentSystemURL = driver.getCurrentUrl();

		if (currentSystemURL.contains("https://mme.benefitalign.com/")) {
			waitForElement(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Frame));
			ExtentSuccessMessage("Frame has been changed");

			waitForElement(10000);
			WebElement text = driver.findElement(By.xpath("	//td[@id='it6cf']/div[3]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text);
			text.clear();
			text.sendKeys("This is automated Email Design");
			driver.switchTo().defaultContent();

		} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {

			waitForElement(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Frame));
			ExtentSuccessMessage("Frame has been changed");

			waitForElement(10000);
			WebElement text = driver.findElement(By.xpath(
					"/html/body/div[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/div[2]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text);
			text.clear();
			text.sendKeys("This is automated Email Design");

			waitForElement(8000);
			WebElement text1 = driver.findElement(By.xpath(
					"/html/body/div[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/div[2]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text1);
			text1.clear();
			text1.sendKeys("Automation Team");
			driver.switchTo().defaultContent();

		}

		else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {

			waitForElement(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Frame));
			ExtentSuccessMessage("Frame has been changed");

			waitForElement(10000);
			WebElement text = driver.findElement(By.xpath(
					"/html/body/div[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/div[2]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text);
			text.clear();
			text.sendKeys("This is automated Email Design");

			waitForElement(8000);
			WebElement text1 = driver.findElement(By.xpath(
					"/html/body/div[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/div[2]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text1);
			text1.clear();
			text1.sendKeys("Automation Team");
			driver.switchTo().defaultContent();

		} else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {

			waitForElement(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Frame));
			ExtentSuccessMessage("Frame has been changed");

			waitForElement(10000);
			WebElement text = driver.findElement(By.xpath(
					"/html/body/div[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/div[2]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text);
			text.clear();
			text.sendKeys("This is automated Email Design");

			waitForElement(8000);
			WebElement text1 = driver.findElement(By.xpath(
					"/html/body/div[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/div[2]"));
			js.executeScript("var evt = new MouseEvent('dblclick', { bubbles: true, cancelable: true, view: window });"
					+ "arguments[0].dispatchEvent(evt);", text1);
			text1.clear();
			text1.sendKeys("Automation Team");
			driver.switchTo().defaultContent();

		}

		else {
			System.out.println("Dev ENV");

		}

		// driver.switchTo().defaultContent();

		waitForElement(5000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Template has been saved");

		By SearchField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField, MarketingTemplateName + Keys.ENTER);
		ExtentSuccessMessage("Template name has been Searched");

		waitForElement(7000);
		By TemplateInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateInc));
		firstName = element.getText();
		System.out.println("-----------" + firstName + "------------");
		Assert.assertEquals(MarketingTemplateName, firstName);
		ExtentSuccessMessage("Assertion has been done");

	}

	public void marketing_List(CensusInfo ApplicantInfo) throws InterruptedException, IOException, AWTException {

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing list has been clicked");
		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValidateListButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create List Button has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListName));
		MoveToElementClick(element);
		String MarketingListName = "AutoLIST" + getRandomNumber();
		System.out.println(MarketingListName);
		writeText(ListName, MarketingListName);
		writeListnameToExcel(MarketingListName, "TC CE2");
		waitForElement(3000);
		ExtentSuccessMessage("List Name has been entered");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListDetailNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been entered");
		waitForElement(3000);

		Base_Class.MouseClick(By.xpath("//div[text()='Select File']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\ListTemplate.xlsx";
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

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(UploadListNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next Button has been Clicked");

		String currentSystemURL = driver.getCurrentUrl();

		if (currentSystemURL.contains("https://mme.brokerengage.net/#/login")) {
			waitForElement(7000);
			By DOBDeleteIcon = By.xpath("(//button[@class='btn btn-default green glyphicon glyphicon-trash'])[4]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOBDeleteIcon));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("Delete has been Clicked");

		} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {

			waitForElement(7000);
			By DOBDeleteIcon = By.xpath("((//td[text()='Dob'])[1]/following-sibling::td)/button");

			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOBDeleteIcon));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("Delete has been Clicked");

		}

		else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {

			waitForElement(7000);
			By DOBDeleteIcon = By.xpath("((//td[text()='Dob'])[1]/following-sibling::td)/button");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOBDeleteIcon));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("Delete has been Clicked");

		}

		else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {

			waitForElement(7000);
			By DOBDeleteIcon = By.xpath("((//td[text()='Dob'])[1]/following-sibling::td)/button");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOBDeleteIcon));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("Delete has been Clicked");
		}

		else {

			waitForElement(7000);
			By DOBDeleteIcon = By.xpath("((//td[text()='Dob'])[1]/following-sibling::td)/button");

			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOBDeleteIcon));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("Delete has been Clicked");

		}

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AlertAcceptButton));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Alert popup has been Clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(DOBCheckList));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("DOB has been Clicked");

		if (currentSystemURL.contains("https://ce-dev.benefitalign.com/")) {
			By AgencyEmail = By.xpath("//label[contains(.,'AgencyEmail')]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyEmail));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("AOR has been Clicked");

			Assert.assertTrue(driver.findElement(AgencyEmail).isEnabled());
			ExtentSuccessMessage("Assertion has been done");

		} else {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AOREMmail));
			MoveToElementClick(element);
			waitForElement(4000);
			ExtentSuccessMessage("AOR has been Clicked");

			Assert.assertTrue(driver.findElement(AOREMmail).isEnabled());
			ExtentSuccessMessage("Assertion has been done");

		}

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MapButton));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("MAP Button has been Clicked");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingListSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Save Button has been Clicked");

		waitForElement(40000);
		driver.navigate().refresh();

		By ListInputField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(ListInputField, MarketingListName + Keys.ENTER);

		driver.navigate().refresh();
		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(ListInputField, MarketingListName + Keys.ENTER);
		Thread.sleep(15000);

		By LoadingStatus = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LoadingStatus));
		String status = element.getText();
		System.out.println(status);

		Assert.assertEquals(status, "Loading Completed");
		ExtentSuccessMessage("Assertion for Loading Status is Done");

		By Listmember = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000C']/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Listmember));
		String Member = element.getText();
		System.out.println(Member);

		String TotalMember = "3";
		waitForElement(1000);
		Assert.assertEquals(Member, TotalMember);
		ExtentSuccessMessage("Assertion for Total Number is done:-" + Member);

		By Status = By.xpath("//div[@class='ui-grid-cell ng-scope ui-grid-coluiGrid-000D']/div");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		String StatusText = element.getText();
		System.out.println(StatusText);

		String ListStatus = "Active";
		Assert.assertEquals(StatusText, ListStatus);
		ExtentSuccessMessage("Assertion for ListStatus is done:-" + StatusText);

		By ListName = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListName));
		MoveToElementClick(element);
		ExtentSuccessMessage("List name has been Clicked");

		Thread.sleep(5000);

		By ListMember = By.xpath("//div[@class='ui-grid-row ng-scope'][1]");
		Assert.assertTrue(driver.findElement(ListMember).isDisplayed());
		ExtentSuccessMessage("List Member Information is Displayed");

	}

	public void validate_ScheduleLater_Email_Campaign(CensusInfo ApplicantInfo)
			throws InterruptedException, ParseException {

		waitForElement(6000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000);
//		if executing in UAT and Prod Please Comment Below line

//		By MarketingCampaign = By.xpath("(//a[contains(.,'Outbound Campaigns')])[2]");//For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create Campaign Button has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromotionalCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Promotional Campaign Button has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignName));
		MoveToElementClick(element);
		String campaignname = "ScheduledEmailCampaign" + getRandomNumber();
		writeText(CampaignName, campaignname);
		ExtentSuccessMessage("Campaign name has been entered");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignObjective));
		MoveToElementClick(element);
		writeText(CampaignObjective, "Hello! This is automated Campaign");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignDetailsNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been clicked");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField, ApplicantInfo.TemplateName + Keys.ENTER);

		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateCheckBox));
		click(TemplateCheckBox);
		ExtentSuccessMessage("Template has been clicked");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next Button has been clicked");

		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListSearchField));
		MoveToElementClick(element);
		waitForElement(3000);
//		String ListName = ApplicantInfo.ListName;
		String ListName = "AutoPermanentList";
		writeText(ListSearchField, ListName + Keys.ENTER);
		ExtentSuccessMessage("List has been searched");

		waitForElement(35000);

		By ValidEmailCount = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValidEmailCount));
		ValidEmailText = element.getText();
		System.out.println(ValidEmailText);

		wait.until(ExpectedConditions.elementToBeClickable(ListCheckBox));
		click(ListCheckBox);
		ExtentSuccessMessage("List Checkbox been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("ListNext has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSendersName));
		MoveToElementClick(element);
		String SenderName = "CEUserfive";
		writeText(EmailSendersName, SenderName);
		ExtentSuccessMessage("Name has been entered");

		By SenderEmailAddress = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[5]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/md-input-container/md-select");
		wait.until(ExpectedConditions.elementToBeClickable(SenderEmailAddress));
		click(SenderEmailAddress);
		By EmailOption = By.xpath("//md-option[@value='customerengage@benefitalign.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailOption));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubjectLine));
		MoveToElementClick(element);
		String EmailSubject = "This mail is generated via Automation";
		writeText(EmailSubjectLine, EmailSubject);
		ExtentSuccessMessage("Subject been entered");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfigButtonNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next Button has been clicked");

		waitForElement(3000);

		// By InputField = By.xpath("//md-input-container[@class='md-block md-icon-float
		// md-input-has-value']/input");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TestAndPreviewEmailField));
		element.click();
		element.clear();
		writeText(TestAndPreviewEmailField, "ceuserfive@yopmail.com");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TestEmailButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Test Email Button has been Clicked ");

		waitForElement(5000);
		By SuccessMessage = By.xpath("//div[@id='divSuccess']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SuccessMessage));
		Assert.assertTrue(driver.findElement(SuccessMessage).isDisplayed());
		ExtentSuccessMessage("Email has been send succesfully");

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		Date oneDayLater = calendar.getTime();
		// Format the date as a string
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = dateFormat.format(oneDayLater);
		// Store the formatted date in a string
		String date1DayLater = formattedDate;
		// Print the generated date
		System.out.println("Date 1 Day later: " + date1DayLater);
		waitForElement(1000);

		By ScheduleLaterOption = By.xpath("//md-radio-button[@value='laterSchedule']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleLaterOption));
		MoveToElementClick(element);

		waitForElement(4000);
		By ScheduleCalendar = By.xpath("//input[@class='md-datepicker-input md-input']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleCalendar));
		MoveToElementClick(element);
		element.clear();
		writeText(ScheduleCalendar, date1DayLater);

		By HourDD = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HourDD));
		MoveToElementClick(element);
		By HourOption = By.xpath("(//md-option[@value='10'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HourOption));
		MoveToElementClick(element);

		By MinuteDD = By.xpath("(//md-select-value[@class='md-select-value'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MinuteDD));
		MoveToElementClick(element);
		By MinuteOption = By.xpath("(//md-option[@value='00'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MinuteOption));
		MoveToElementClick(element);

		By AMPMDD = By.xpath("(//md-select-value[@class='md-select-value'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AMPMDD));
		MoveToElementClick(element);
		By AMOption = By.xpath("//md-option[@value='AM']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AMOption));
		MoveToElementClick(element);

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaignButton));
		Assert.assertTrue(driver.findElement(CreateCampaignButton).isDisplayed());
		MoveToElementClick(element);
		ExtentSuccessMessage("Create campaign Button has been clicked ");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Confirmation button has been clicked");

	}

	public String writeTemplatenameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 10;
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

	public void marketing_CallCampaign(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000);
//		if executing in UAT and Prod Please Comment Below line

//		By MarketingCampaign = By.xpath("(//a[contains(.,'Outbound Campaigns')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create Campaign Button has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromotionalCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Promotional Campaign Button has been clicked");

		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallCampaignName));
		MoveToElementClick(element);
		String Callcampaignname = "CallCampaign" + getRandomNumber();
		writeText(CampaignName, Callcampaignname);
		ExtentSuccessMessage("Campaign name has been entered");

		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignCategory));
		MoveToElementClick(element);
		Thread.sleep(4000);
		By CallOption = By.xpath("(//md-content[@class='_md'])[6]/md-option[contains(.,'Call')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallOption));
		MoveToElementClick(element);
		Robot robot = new Robot();

		ExtentSuccessMessage("Call has been selected");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallCampaignObjective));
		MoveToElementClick(element);
		writeText(CampaignObjective, "Hello! This is automated Campaign");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallCampaignDetailsNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been clicked");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallListSearchField));
		MoveToElementClick(element);
		waitForElement(3000);
//		String CallList =  ApplicantInfo.ListName;
		String CallList = "AutoPermanentList";
		writeText(ListSearchField, CallList + Keys.ENTER);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ExtentSuccessMessage("List name has been entered");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallListCheckBox));
		MoveToElementClick(element);
		ExtentSuccessMessage("List has been selected");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallCampaignSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been created");

		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		writeText(SearchTextField, Callcampaignname + Keys.ENTER);
		ExtentSuccessMessage("Campaign has been selected");

		waitForElement(7000);
		By CallCampaignInc = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallCampaignInc));
		firstName = element.getText();
		System.out.println("-----------" + firstName + "------------");
		Assert.assertEquals(Callcampaignname, firstName);
		ExtentSuccessMessage("Assertion has been done");

		waitForElement(5000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(LaunchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been launched");

		driver.navigate().refresh();

		Thread.sleep(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		writeText(SearchTextField, Callcampaignname + Keys.ENTER);
		ExtentSuccessMessage("Campaign has been selected");

		Thread.sleep(4000);
		By DeleteButton = By.xpath("//a[@class='edit-list-icons ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteButton));
		MoveToElementClick(element);

		Thread.sleep(4000);
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Call Campaign has been Deleted");

	}

	public void validate_Email_Campaign(CensusInfo ApplicantInfo)
			throws InterruptedException, AWTException, IOException {

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000);
//		if executing in UAT and Prod Please Comment Below line
//	By MarketingCampaign = By.xpath("(//a[contains(.,'Outbound Campaigns')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create Campaign Button has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromotionalCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Promotional Campaign Button has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignName));
		MoveToElementClick(element);
		String campaignname = "EmailCampaign" + getRandomNumber();
		writeText(CampaignName, campaignname);
		writeEmailToExcel(campaignname, "TC CE2");
		ExtentSuccessMessage("Campaign name has been entered");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignObjective));
		MoveToElementClick(element);
		writeText(CampaignObjective, "Hello! This is automated Campaign");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignDetailsNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been clicked");

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField, ApplicantInfo.TemplateName + Keys.ENTER);
		// writeText(SearchField, "" + Keys.ENTER);

		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateCheckBox));
		click(TemplateCheckBox);
		ExtentSuccessMessage("Template has been clicked");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next Button has been clicked");

		waitForElement(12000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListSearchField));
		MoveToElementClick(element);
		waitForElement(3000);
//	    String ListName = ApplicantInfo.ListName;
		String ListName = "AutoPermanentList";
		writeText(ListSearchField, ListName + Keys.ENTER);

		ExtentSuccessMessage("List has been searched");

		waitForElement(3000);

		By ValidEmailCount = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValidEmailCount));
		ValidEmailText = element.getText();
		System.out.println(ValidEmailText);

		wait.until(ExpectedConditions.elementToBeClickable(ListCheckBox));
		click(ListCheckBox);
		ExtentSuccessMessage("List Checkbox been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ListNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("ListNext has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSendersName));
		MoveToElementClick(element);
		String SenderName = "CEUserfive";
		writeText(EmailSendersName, SenderName);
		ExtentSuccessMessage("Name has been entered");

		By SenderEmailAddress = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[5]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/md-input-container/md-select");
		wait.until(ExpectedConditions.elementToBeClickable(SenderEmailAddress));
		click(SenderEmailAddress);
		By EmailOption = By.xpath("//md-option[@value='customerengage@benefitalign.com']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailOption));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubjectLine));
		MoveToElementClick(element);
		String EmailSubject = "This mail is generated via Automation";
		writeText(EmailSubjectLine, EmailSubject);
		ExtentSuccessMessage("Subject been entered");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfigButtonNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next Button has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(TestAndPreviewEmailField));
		MoveToElementClick(element);
		Assert.assertTrue(driver.findElement(TestAndPreviewEmailField).isDisplayed());
		writeText(TestAndPreviewEmailField, "abcdef");

		ExtentSuccessMessage("Test and Email Preview is available");
		// writeText(TestAndPreviewEmailField, "ceuserfive@yopmail.com");
		ExtentSuccessMessage("Email Has Been Entered");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TestEmailButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Test Email Button has been Clicked ");

		waitForElement(2000);
		By InvalidPopup = By.xpath("//div[@class='alert alert-danger myStyleHide']");
		Assert.assertTrue(driver.findElement(InvalidPopup).isDisplayed());
		ExtentSuccessMessage("Assertion for Invalid Email is done");

		// By InputField = By.xpath("//md-input-container[@class='md-block md-icon-float
		// md-input-has-value']/input");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TestAndPreviewEmailField));
		element.click();
		element.clear();
		writeText(TestAndPreviewEmailField, "ceuserfive@yopmail.com");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TestEmailButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Test Email Button has been Clicked ");

		waitForElement(5000);
		By SuccessMessage = By.xpath("//div[@id='divSuccess']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SuccessMessage));
		Assert.assertTrue(driver.findElement(SuccessMessage).isDisplayed());
		ExtentSuccessMessage("Email has been send succesfully");

		/*
		 * driver.switchTo().newWindow(WindowType.TAB); Thread.sleep(3000);
		 * 
		 * waitForElement(4000); driver.get("https://yopmail.com/wm");
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInbox));
		 * MoveToElementClick(element); String CEuserfiveMail =
		 * "ceuserfive@yopmail.com"; writeText(YopmailInbox, CEuserfiveMail);
		 * ExtentSuccessMessage("Navigated to mailbox"); waitForElement(1000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(YopmailSubmit));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Navigated to inbox of agent email");
		 * waitForElement(15000); // element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInboxText)); //
		 * MoveToElementClick(element); driver.switchTo().frame("ifmail");
		 * waitForElement(1000);
		 * 
		 * 
		 * By MailSubjectValidation = By.xpath("//div[@class='ellipsis nw b f18']");
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(MailSubjectValidation)
		 * ); String Subject =element.getText(); System.out.println(Subject);
		 * 
		 * Thread.sleep(1000); Assert.assertEquals(Subject, EmailSubject);
		 * ExtentSuccessMessage("Assertion for Test Review Email is done");
		 * 
		 * ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		 * System.out.println(Tabs.size()); driver.switchTo().window(Tabs.get(0));
		 * ExtentSuccessMessage("Tab Switched from child to parent");
		 */

		waitForElement(2000);
		By CampaignInformationOnTestAndReview = By
				.xpath("(//span[@class='form-group view-page ng-scope']/span[@class='ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignInformationOnTestAndReview));
		String EmailCampaignNameonTestandReview = element.getText();
		System.out.println(EmailCampaignNameonTestandReview);
		Assert.assertEquals(EmailCampaignNameonTestandReview, campaignname);
		ExtentSuccessMessage("Assertion for campaign name has been done on Test and Review Page");

		waitForElement(2000);
		By TemplateInformationOnTestAndReview = By
				.xpath("(//span[@class='form-group view-page ng-scope']/span[@class='ng-binding'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateInformationOnTestAndReview));
		String TemplateName = element.getText();
		Assert.assertEquals(ApplicantInfo.TemplateName, TemplateName);
		ExtentSuccessMessage("Assertion for Template name has been done on Test and Review Page");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Confirmation button has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaignButton));
		Assert.assertTrue(driver.findElement(CreateCampaignButton).isDisplayed());
		MoveToElementClick(element);
		ExtentSuccessMessage("Create campaign Button has been clicked ");

		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Yes Button");
		Thread.sleep(4000);

		By EmailCampaignInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailCampaignInc));
		EmailText = element.getText();
		System.out.println("-----------" + EmailText + "------------");
		Assert.assertEquals(campaignname, EmailText);
		ExtentSuccessMessage("Assertion has been done");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		writeText(SearchTextField, campaignname + Keys.ENTER);
		ExtentSuccessMessage("Campaign Name has been Searched for Editing ");

		waitForElement(4000);
		By EditCampaign = By.xpath("//i[@title='Edit campaign']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on edit Campaign Button");

		waitForElement(10000);
		By EmailConfiguration = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfiguration));
		MoveToElementClick(element);

		waitForElement(18000);
		By SubjectLine = By.xpath(
				"(//input[@class='full-width ng-pristine ng-untouched md-input ng-not-empty ng-valid ng-valid-required'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubjectLine));
		MoveToElementClick(element);
		element.clear();

		waitForElement(7000);
		By Subjectlineforedit = By.xpath(
				"//input[@class='full-width md-input ng-empty ng-dirty ng-valid-parse ng-invalid ng-invalid-required ng-touched']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Subjectlineforedit));
		MoveToElementClick(element);
		String NewSubject = "Hello these is created via automation !!! Hope you are doing well";
		writeText(Subjectlineforedit, NewSubject);

		By SaveButton = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailCampaignLaunchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been launched");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");

		waitForElement(70000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(8000); // For UAT
		By CampaignStatus = By.xpath("//span[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignStatus));
		String Status = element.getText();
		System.out.println(Status);

		waitForElement(3000);
		Assert.assertEquals(Status, "Completed");
		ExtentSuccessMessage("Assertion for Campaign Status is Done:- " + Status);

		waitForElement(2000);
		By EmailCampaignName = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailCampaignName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email Campaign has been clicked");

		waitForElement(4000);
		By CampaignResponse = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[4]/div/div[2]/div[8]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignResponse));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign Response has been clicked");

		waitForElement(2000);
		By CampaignResponseTableInc = By
				.xpath("(//tr[@class='dx-row dx-data-row dx-column-lines']//td[@aria-colindex='2'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignResponseTableInc));
		String Campaign = element.getText();
		System.out.println("-----------" + Campaign + "------------");
		Assert.assertTrue(Campaign.contains(ValidEmailText));
		ExtentSuccessMessage("Assertion has been done");

		waitForElement(3000);
		By DownloadCampaignResponse = By.xpath("(//a[@class='dx-link glyphicon fa fa-file-excel-o'])[1]");
		wait.until(ExpectedConditions.elementToBeClickable(DownloadCampaignResponse));
		click(DownloadCampaignResponse);

		waitForElement(3000);
		By DowmloadResponsePopup = By.xpath("//div[@id='divSuccesss']");
		Assert.assertTrue(driver.findElement(DowmloadResponsePopup).isDisplayed());
		ExtentSuccessMessage("Response has been downloaded");

		By BackButton = By.xpath("//button[@class='btn btn-default grey pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BackButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Return Button");

		/*Thread.sleep(4000);
		By DeleteButton = By.xpath("//a[@class='edit-list-icons ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");

		Thread.sleep(2000);
		By Yes1 = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Yes Button");

		Thread.sleep(4000);
//		Assert.assertFalse(driver.findElement(EmailCampaignName).isDisplayed());
		ExtentSuccessMessage("Assertion for Campaign Delete is done");*/

	}

	public void validate_Schedule_SMSCamapign(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000);
//		if executing in UAT and Prod Please Comment Below line

//		By MarketingCampaign = By.xpath("(//a[contains(.,'Outbound Campaigns')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create Campaign Button has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromotionalCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Promotional Campaign Button has been clicked");
		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignName));
		MoveToElementClick(element);
		String SMScampaignname = "ScheduledSMSCampaign" + getRandomNumber();
		writeText(CampaignName, SMScampaignname);
		ExtentSuccessMessage("Campaign name has been entered");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignCategory));
		MoveToElementClick(element);
		Thread.sleep(4000);

		By SMSOPtion = By.xpath("(//md-content[@class='_md'])[6]/md-option[contains(.,'SMS')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSOPtion));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS has been clicked");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignObjective));
		MoveToElementClick(element);
		writeText(CampaignObjective, "Hello! This is automated Campaign");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignDetailsNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been clicked");

		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
		MoveToElementClick(element);
		writeText(MessageTextArea, "Hello!These message is created via automation");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateMessageNextButton));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSListSearchField));
		MoveToElementClick(element);
		waitForElement(3000);
//		String SMSList = ApplicantInfo.ListName;
		Robot robot = new Robot();
		String SMSList = "AutoPermanentList";
		writeText(ListSearchField, SMSList);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ExtentSuccessMessage("List name has been entered");

		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(SMSListCheckBox));
		click(ListCheckBox);
		ExtentSuccessMessage("List has been selected");
		waitForElement(5000);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSListnextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been launched");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSTestNumberField));
		MoveToElementClick(element);
		writeText(SMSTestNumberField, "(938) 222-3276");
		ExtentSuccessMessage("Number has been entered");

		waitForElement(5000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSTestNumberButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Number has been tested");

		waitForElement(3000);
		By SuccessPopup = By.xpath("//div[@id='divSuccess']");
		Assert.assertTrue(driver.findElement(SuccessPopup).isDisplayed());

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		Date oneDayLater = calendar.getTime();
		// Format the date as a string
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = dateFormat.format(oneDayLater);
		// Store the formatted date in a string
		String date1DayLater = formattedDate;
		// Print the generated date
		System.out.println("Date 1 Day later: " + date1DayLater);
		waitForElement(1000);

		By ScheduleLaterOption = By.xpath("//md-radio-button[@value='laterSchedule']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleLaterOption));
		MoveToElementClick(element);

		waitForElement(4000);
		By ScheduleCalendar = By.xpath("//input[@class='md-datepicker-input md-input']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ScheduleCalendar));
		MoveToElementClick(element);
		element.clear();
		writeText(ScheduleCalendar, date1DayLater);

		By HourDD = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HourDD));
		MoveToElementClick(element);
		By HourOption = By.xpath("(//md-option[@value='10'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HourOption));
		MoveToElementClick(element);

		By MinuteDD = By.xpath("(//md-select-value[@class='md-select-value'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MinuteDD));
		MoveToElementClick(element);
		By MinuteOption = By.xpath("(//md-option[@value='00'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MinuteOption));
		MoveToElementClick(element);

		By AMPMDD = By.xpath("(//md-select-value[@class='md-select-value'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AMPMDD));
		MoveToElementClick(element);
		By AMOption = By.xpath("//md-option[@value='AM']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AMOption));
		MoveToElementClick(element);

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaignButton));
		Assert.assertTrue(driver.findElement(CreateCampaignButton).isDisplayed());
		MoveToElementClick(element);
		ExtentSuccessMessage("Create campaign Button has been clicked ");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSConfirmationButton));
		MoveToElementClick(element);
		waitForElement(5000);

		By SMSCampaignInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignInc));
		firstName = element.getText();
		System.out.println("-----------" + firstName + "------------");
		Assert.assertEquals(SMScampaignname, firstName);
		ExtentSuccessMessage("Assertion has been done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		writeText(SearchTextField, SMScampaignname + Keys.ENTER);
		ExtentSuccessMessage("Campaign has been selected");

		waitForElement(6000);
		By ScheduleButtonLogo = By.xpath("//i[@title='Scheduled campaign']");
		Assert.assertTrue(driver.findElement(ScheduleButtonLogo).isDisplayed());

/*		By Marketing = By.xpath("//a[@id='menu_Marketing']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Marketing));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Marketing section");

		By List = By.xpath("//a[@id='submenu_marketinglists']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(List));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on List section");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		System.out.println(SMSList);
		writeText(SearchTextField, SMSList + Keys.ENTER);
		ExtentSuccessMessage("Campaign has been selected");

		Thread.sleep(15000);
		By Delete = By.xpath("//a[@class='edit-list-icons ng-scope'][3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on List Delete Button");

		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on yes button for delete List");
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		System.out.println(ApplicantInfo.CustomListName);
		writeText(SearchTextField, ApplicantInfo.CustomListName + Keys.ENTER);
		ExtentSuccessMessage("List has been selected");

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on List Delete Button");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on yes button for delete Custom List");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Marketing));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Marketing section");

		By Template = By.xpath("//a[@id='submenu_marketingtemplates']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Template));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Template section");

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		System.out.println(ApplicantInfo.TemplateName);
		writeText(SearchTextField, ApplicantInfo.TemplateName + Keys.ENTER);
		ExtentSuccessMessage("Campaign has been selected");

		By Deletetemplate = By.xpath("//a[@class='edit-list-icons'][1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Deletetemplate));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete button");

		Thread.sleep(3000);
		By TemplateYes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateYes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Yes button");

		Thread.sleep(3000);*/

	}

	public String writeListnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 4;
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
	
	public String writeEmailToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 3;
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

	public void add_customer_validation() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(MainMenu));
		click(MainMenu);
		ExtentSuccessMessage("Clicked on Main Menu Option For Customer information URL Validation");
		waitForElement(500);
		wait.until(ExpectedConditions.elementToBeClickable(CustomerInformationTab));
		click(CustomerInformationTab);
		ExtentSuccessMessage("Clicked on Customer Information Tab");
		waitForElement(1000);
	}

	public String employerName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public String agentName() {
		String allowedChars = "AEIOU" + "bcdfghjklmnpqrstvwxyz";
		String ssn = "";
		String temp = RandomStringUtils.random(12, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}

	public void customer_fields_validation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Customer Link");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFirstname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Firstname Field");
		firstName = "TEST" + employerName();
		writeText(CustomerFirstname, firstName);
		ExtentSuccessMessage("Added customer's firstname");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerLastname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers lastname fieldname");
		String lastName = employerName();
		writeText(CustomerLastname, lastName);
		ExtentSuccessMessage("Added customer's lastname");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerGender));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers gender");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Added gender of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerDOB));
		MoveToElementClick(element);
		writeText(CustomerDOB, "01/01/1990");
		ExtentSuccessMessage("Added DOB of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAddressLine));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers address line field");
		writeText(CustomerAddressLine, ApplicantInfo.AddressLine1);
		ExtentSuccessMessage("Added Address Line 1 of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerZipcode));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers zipcode field");
		writeText(CustomerZipcode, ApplicantInfo.Zipcode + Keys.TAB);
		ExtentSuccessMessage("Added Zipcode of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SameMailingAddress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Checkbox clicked - Is Mailing address same as Home address!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PhoneNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers phone number field");
		writeText(PhoneNumber, ApplicantInfo.Phone);
		ExtentSuccessMessage("Added Phone number of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		waitForElement(10000);
		driver.navigate().refresh();
		waitForElement(1000);
		fullName = firstName + " " + lastName;
		ExtentSuccessMessage("Actual Full Name: " + fullName);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFullName));
//		actualText = element.getText();
//		ExtentSuccessMessage("Actual Expected Name: " + actualText);
//		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("New customer has been added successfully!");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the user to perform logout!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
	}

	public void landing_page_validations_MarketingTile() throws InterruptedException// ----------->DONE
	{
		waitForElement(2000);
		waitForElement(6000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing list has been clicked");

//		waitForElement(7000);
		// Assert.assertTrue(driver.findElement(ValidateListButton).isDisplayed());
//		ExtentSuccessMessage("Assertion has been successful");
//		waitForElement(5000);
//		
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");

	}

	public void landing_page_validations_SaleTile() throws InterruptedException// ------------>Done
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);// clicking on tiles
		ExtentSuccessMessage("Sales Tile has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");

		waitForElement(8000); // for UAT
		Assert.assertTrue(driver.findElement(NewLeadButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);
	}

	public void marketing_SMSCampaign(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles

		waitForElement(9000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000);
//			if executing in UAT and Prod Please Comment Below line

//			By MarketingCampaign = By.xpath("(//a[contains(.,'Outbound Campaigns')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Create Campaign Button has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromotionalCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Promotional Campaign Button has been clicked");
		waitForElement(4000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignName));
		MoveToElementClick(element);
		String SMScampaignname = "SMSCampaign" + getRandomNumber();
		writeText(CampaignName, SMScampaignname);
		ExtentSuccessMessage("Campaign name has been entered");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignCategory));
		MoveToElementClick(element);
		Thread.sleep(4000);
		Robot robot = new Robot();

		By SMSOPtion = By.xpath("(//md-content[@class='_md'])[6]/md-option[contains(.,'SMS')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSOPtion));
		MoveToElementClick(element);
		ExtentSuccessMessage("SMS has been clicked");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignObjective));
		MoveToElementClick(element);
		writeText(CampaignObjective, "Hello! This is automated Campaign");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignDetailsNextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button has been clicked");

		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MessageTextArea));
		MoveToElementClick(element);
		writeText(MessageTextArea, "Hello!This Message is created via Automation Sript");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateMessageNextButton));
		MoveToElementClick(element);

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSListSearchField));
		MoveToElementClick(element);
		waitForElement(3000);
//        String SMSList =   ApplicantInfo.ListName;
		String SMSList = "AutoPermanentList";
		writeText(ListSearchField, SMSList);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ExtentSuccessMessage("List name has been entered");

		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(SMSListCheckBox));
		click(ListCheckBox);
		ExtentSuccessMessage("List has been selected");
		waitForElement(9000);

		By ValidNumber = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ValidNumber));
		String number = element.getText();
		System.out.println(number);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSListnextButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been launched");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSTestNumberField));
		MoveToElementClick(element);
		writeText(SMSTestNumberField, "(938) 222-3276");
		ExtentSuccessMessage("Number has been entered");

		waitForElement(5000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSTestNumberButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Number has been tested");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCreateCampaignButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been created");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSConfirmationButton));
		MoveToElementClick(element);
		waitForElement(5000);

		By SMSCampaignInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignInc));
		firstName = element.getText();
		System.out.println("-----------" + firstName + "------------");
		Assert.assertEquals(SMScampaignname, firstName);
		ExtentSuccessMessage("Assertion has been done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchTextField));
		MoveToElementClick(element);
		writeText(SearchTextField, SMScampaignname);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ExtentSuccessMessage("Campaign has been selected");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSLaunchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign has been launched");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSconfirmationButton));
		MoveToElementClick(element);

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");

		waitForElement(25000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		waitForElement(4000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingCampaign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Campaign has been clicked");

		waitForElement(2000);
		By SMSCampaignName = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSCampaignName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Email Campaign has been clicked");

		waitForElement(4000);
		By CampaignResponse = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[4]/div/div[2]/div[8]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CampaignResponse));
		MoveToElementClick(element);
		ExtentSuccessMessage("Campaign Response has been clicked");

		By SMSSend = By.xpath("(//tr[@class='dx-row dx-data-row dx-column-lines']/td)[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SMSSend));
		MoveToElementClick(element);
		String sms = element.getText();
		System.out.println(sms);

		Assert.assertTrue(sms.contains(number));
		ExtentSuccessMessage("Assertion has been done for response section");

		By ReturnButton = By.xpath("//button[@class='btn btn-default grey pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReturnButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on return button");

		Thread.sleep(4000);
		By Delete = By.xpath("//a[@class='edit-list-icons ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sms Campaign name has been deleted");

		Thread.sleep(2000);
		By Yes1 = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Yes Button");

	}

	public int getRandomNumber1() {
		Random r = new Random();
		int ran = r.nextInt(3000);
		return ran;
	}

	public void landing_page_validations_CustomerTile() throws InterruptedException// ---------->Done
	{
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);// clicking on customer tiles
		ExtentSuccessMessage("Customer Tile has been clicked");
		waitForElement(6000);

		Assert.assertTrue(driver.findElement(ImportCustomerPolicyButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_AgencyTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		MoveToElementClick(element);// clicking on Agent tiles AgencyAgent
		ExtentSuccessMessage("Agency Tile has been clicked");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
		MoveToElementClick(element);// clicking on Agent tiles NewAgentButton
		ExtentSuccessMessage("Agency Agent has been clicked");
		// waitForElement(5000); //For AWSPP
		waitForElement(9000); // for UAT

		Assert.assertTrue(driver.findElement(NewAgentButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_ServiceTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceTile));
		MoveToElementClick(element);// clicking on Service tiles
		ExtentSuccessMessage("Service Tile has been clicked");

		// waitForElement(3000);//for AWSPP
		waitForElement(7000);
		Assert.assertTrue(driver.findElement(NewServiceRequestButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_IVR_ManagementTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IVRManagementTile));
		MoveToElementClick(element);// clicking on Service tiles
		ExtentSuccessMessage("IVR Management Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IVRManagementPrompt));
		MoveToElementClick(element);// clicking on IVR tiles
		ExtentSuccessMessage("Prompt has been clicked");

		waitForElement(3000);
		Assert.assertTrue(driver.findElement(IVRNewPromptButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_AdminTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);// clicking on Admin tiles
		ExtentSuccessMessage("Admin Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminRolesAndPermission));
		MoveToElementClick(element);// clicking on IVR tiles
		ExtentSuccessMessage("Roles And Permission has been clicked");

		waitForElement(3000);
		Assert.assertTrue(driver.findElement(AddRolesAndPermissionButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_ReportTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		MoveToElementClick(element);// clicking on Report tiles
		ExtentSuccessMessage("Report Tile has been clicked");

		// waitForElement(3000); //for AWSPP
		waitForElement(8000); // for UAT
		Assert.assertTrue(driver.findElement(LiveReport).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_DashBoardTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoardTile));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("DashBoard Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoardMyTask));
		MoveToElementClick(element);// clicking on My TAsk tiles
		ExtentSuccessMessage("Report Tile has been clicked");

		// waitForElement(3000); //for awspp and uat
		waitForElement(7000); // for QA
		Assert.assertTrue(driver.findElement(DashBoardCalendar).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_CommissionTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionTile));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("Commision Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionSetup));
		MoveToElementClick(element);// clicking on My TAsk tiles
		ExtentSuccessMessage("Report Setup has been clicked");

		waitForElement(3000);
		Assert.assertTrue(driver.findElement(CommissionSetupTitle).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_IconValidation_CTIIcon() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("CTI Icon has been clicked");

		waitForElement(4000);
		Assert.assertTrue(driver.findElement(CTIDialPadIcon).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("CTI Icon has been clicked");

	}

	public void landing_page_IconValidation_CallBackNotification() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackNotificationIcon));
		MoveToElementClick(element);// clicking on CTIICON tiles CallBackNitificationTitle
		ExtentSuccessMessage("CTI Icon has been clicked");

		waitForElement(4000);
		Assert.assertTrue(driver.findElement(CallBackNitificationTitle).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackNitificationMinimizeIcon));
		MoveToElementClick(element);// clicking on CTIICON tiles
		ExtentSuccessMessage("Minimize Icon has been clicked");

	}

	public void landing_page_IconValidation_MyProfileIcon() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(3000);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyProfileIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("My Profile Icon has been selected");
		waitForElement(3000);

		waitForElement(4000);
		Assert.assertTrue(driver.findElement(MyProfileSubmitButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

	}

	public void customer_engage_validation(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
		String urlCE = configloader().getProperty("CEURL");
		String username = configloader().getProperty("PLCA_UserName");
		String pswd = configloader().getProperty("PLCA_Password");
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, username);
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, pswd);
		ExtentSuccessMessage("Entered the Customer Engage Password");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(signIn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer Engage Application Sign-In Done");
		waitForElement(3000);
		try {
			if (driver.findElement(CheckUserLogin).isDisplayed()) {
				click(CheckUserLogin);
				ExtentSuccessMessage(
						"You currently have an active session on another device hence Deactivated the other session!");
			} else {
				ExtentSuccessMessage("Login has been successful");
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login successful");
		}
		waitForElement(1000);
	}

	public void customer_tile_information_validation() throws InterruptedException, IOException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customer tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer available in CE which was created in BE application");
		waitForElement(2000);
	}

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

}
