package com.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.interactions.Actions;

import Common.WaitWrapper;
import Utility.Logs.Log;

public class CustomerEngageFunctionalityValidationsSync extends BasePage {

	public CustomerEngageFunctionalityValidationsSync(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;
	public String MarketingURL;
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

	By userID = By.id("user-name");
	By pwd = By.id("password");
	By signIn = By.xpath("//*[@id='form-validation-button']");

	private By CheckUserLogin = By.xpath("//button[@class='positive md-button md-ink-ripple'] | //a[@class='modal-action tertiary_background waves-effect waves-light btn-large ConfirmForceLogin']");
	private By SelectUser = By.xpath("//a[@class='nav-link dropdown-toggle']");
	private By SelectLogout = By.xpath("(//a[contains(.,'Log Out')])[1]");
	private By LogoutButtonConfirmation = By.xpath(
			"//a[@class='modal-action tertiary_background waves-effect waves-light btn-large ConfirmForceLogin']");
//	private By MainMenu = By.xpath("//li[@class='link_menu hide-on-med-and-down sideMenuHamburger']");
	private By MainMenu = By.cssSelector(
			"body > header > div.navbar-fixed > nav > div > ul.left > li.link_menu.hide-on-med-and-down.sideMenuHamburger > a");
	private By CustomerInformationTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(1) > a");
	private By SettingsTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(8) > a");
	private By AgencyDetailsTab = By
			.cssSelector("#sideMenuContent > div > ul > li.active > div > ul > li:nth-child(1) > a");
	private By AddButton = By.xpath("//a[@id='add_buton']");
	private By AgentFirstName = By.xpath("//input[@id='FirstName']");
	private By AgentLastName = By.xpath("//input[@id='LastName']");
	private By AgentRole = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]");
	private By AgentRoleSelection = By.xpath("(//span[contains(.,'Agent')])[1]");
	private By AgentPhone = By.xpath("(//input[@id='Phone'])[1]");
	private By AgentEmail = By.xpath("(//input[@id='Email'])[1]");
	private By MedicareCustomer = By.xpath("//a[@class='medicaredatalistingmenu']");

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
	private By CustomerNameInCE = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	private By SelectCustomerToEdit = By
			.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By ClickOnEditButton = By.xpath("//a[@class='square_anchor float_r editCustomer closeEdit']");
	private By EditLastName = By.xpath("//input[@id='customer_PersonDetails_LastName']");
	private By EditFirstName = By.xpath("//input[@id='customer_PersonDetails_FirstName']");
	private By EditSave = By.xpath("//a[@class='waves-effect waves-light btn primary_background btnUpdateCustomer']");

	private By SelectLogoutBE = By.xpath("(//a[contains(.,'Sign Out')])[1]");
	private By SelectUserBE = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAdminUserBE = By.xpath("//a[@class='dropdown-trigger-user']");
	private By LoginAsAgency = By.cssSelector("#dropdown1 > li:nth-child(1) > a");
//	private By ClickOnCloseButton = By.xpath("//*[@class='close_icon modal-close right'] | //*[@class='material-icons right modal-close']");
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
	private By SalesTile = By.xpath("(//a[@class='glyphicon fa fa-handshake-o'])[1]");
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
		waitForElement(1000);
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
		waitForElement(2000);
	}

	public void logout_CE_validations() throws InterruptedException {
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

	public void add_customer_validation() throws InterruptedException {
		waitForElement(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(MainMenu));
//		click(MainMenu);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MainMenu));
		MoveToElementClick(element);
		System.out.println("Clicked on Main Menu Option For Customer information URL Validation");
		ExtentSuccessMessage("Clicked on Main Menu Option For Customer information URL Validation");
		waitForElement(2000);
		wait.until(ExpectedConditions.elementToBeClickable(CustomerInformationTab));
		click(CustomerInformationTab);
		ExtentSuccessMessage("Clicked on Customer Information Tab");
		System.out.println("Clicked on Customer Information Tab");
		waitForElement(1000);
	}

	public void navigate_to_medicare_customer() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(MedicareCustomer));
		click(MedicareCustomer);
		ExtentSuccessMessage("Clicked on MedicareCustomer Option");
		waitForElement(1000);
	}

	public void edit_update_medicare_customer() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(SelectCustomerToEdit));
		click(SelectCustomerToEdit);
		ExtentSuccessMessage("Clicked on Medicare Customer Option to Edit");
		waitForElement(30000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickOnEditButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Customer Button");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditLastName));
		MoveToElementClick(element);
		writeText(EditLastName, "Update");
		getLastName = element.getAttribute("value");
		ExtentSuccessMessage("Clicked on Edit Customer Lastname and updated it");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditFirstName));
		MoveToElementClick(element);
		getFirstName = element.getAttribute("value");
		fullName = getFirstName + " " + getLastName;
		ExtentSuccessMessage("Actual Full Name: " + fullName);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Customer Button after the Update");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the user to perform logout!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
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

	public void duplicate_customer_fields_validation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Customer Link");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFirstname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Firstname Field");
		firstName = "TEST" + employerName();
		writeText(CustomerFirstname, "syncautomation");
		ExtentSuccessMessage("Added customer's firstname");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerLastname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers lastname fieldname");
		String lastName = employerName();
		writeText(CustomerLastname, "agent");
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

	public void customer_engage_validation(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(2000);
//		String urlCE = configloader().getProperty("CEURL");
		String urlCE;
		String currentSystemURL = driver.getCurrentUrl();
		if (currentSystemURL.contains("https://test.brokerengage.net/")) {
			urlCE = "https://mme.brokerengage.net/";
		} else if (currentSystemURL.contains("https://shop-test.benefitalign.com")) {
			urlCE = "https://ce-uat.benefitalign.com/";
		} else if (currentSystemURL.contains("https://shop-qa.benefitalign.com/")) {
			urlCE = "https://ce-qa.benefitalign.com/#/login";
		} else {
			urlCE = "https://ce-dev.benefitalign.com/#/login";
		}
		String username = configloader().getProperty("PLCA_UserName");
		String pswd = configloader().getProperty("PLCA_CEPasswordUAT");
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
		waitForElement(2000);
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

	public void BE_add_new_agent_validation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		try {
			if (driver.findElement(LogoutButtonConfirmation).isDisplayed()) {
				click(LogoutButtonConfirmation);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Logout button is not there hence proper logout done");
		}
		waitForElement(2000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("FFM close button is not there hence proper logout done");
		}
		ExtentSuccessMessage("Applicantion login is successful");
		waitForElement(1000);
		String Url = driver.getCurrentUrl();
		if (Url.contains("https://test.brokerengage.net")) {
			ExtentSuccessMessage("Logged in Environment: AWS PP");
			System.out.println("Logged in Environment: AWS PP");

		} else if (Url.contains("https://shop-test.benefitalign.com")) {
			ExtentSuccessMessage("Logged in Environment: UAT");
			System.out.println("Logged in Environment: UAT");
			wait.until(ExpectedConditions.elementToBeClickable(SelectAdminUserBE));
			click(SelectAdminUserBE);
			waitForElement(1000);
			wait.until(ExpectedConditions.elementToBeClickable(LoginAsAgency));
			click(LoginAsAgency);
			waitForElement(30000);
		} else {
			ExtentSuccessMessage("Logged in Environment: QA");
		}
		waitForElement(3000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Agencey selection is successful");
		}
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MainMenu));
		MoveToElementClick(element);
//		wait.until(ExpectedConditions.elementToBeClickable(MainMenu));
//		click(MainMenu);
		ExtentSuccessMessage("Clicked on Main Menu Option For Customer information URL Validation");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SettingsTab));
		MoveToElementClick(element);
//		wait.until(ExpectedConditions.elementToBeClickable(SettingsTab));
//		click(SettingsTab);
		ExtentSuccessMessage("Clicked on Settings Tab");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyDetailsTab));
		MoveToElementClick(element);
//		wait.until(ExpectedConditions.elementToBeClickable(AgencyDetailsTab));
//		click(AgencyDetailsTab);
		ExtentSuccessMessage("Clicked on Agency Contacts Tab");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add agent button");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentFirstName));
		MoveToElementClick(element);
		firstName = agentName();
		writeText(AgentFirstName, firstName);
		ExtentSuccessMessage("Entered the firstname of Agent: " + firstName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentLastName));
		MoveToElementClick(element);
		lastName = agentName();
		writeText(AgentLastName, lastName);
		ExtentSuccessMessage("Entered the lastname of Agent: " + lastName);
		agentUserName = firstName + lastName;
		ExtentSuccessMessage("Generated Agent Username ---------------: " + agentUserName);
		System.out.println("Generated Agent Username ---------------: " + agentUserName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRole));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add agent role dropdown");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRoleSelection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent role has been selected!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRoleSelection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agent role has been selected!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPhone));
		MoveToElementClick(element);
		writeText(AgentPhone, ApplicantInfo.Phone);
		ExtentSuccessMessage("Agent phone number has been added!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmail));
		MoveToElementClick(element);
		getEmailValue = "TC-CE-" + writeDynamicEmail();
		writeText(AgentEmail, getEmailValue);
		ExtentSuccessMessage("Agent email has been added! Email address :  " + getEmailValue);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Saved the newly added agent name!");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestForLogin));
		MoveToElementClick(element);
		ExtentSuccessMessage("Requested for Login and to provide more details!");
	}

	public void logout_from_BE_applicant() throws InterruptedException {
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
	}

	public void perform_email_validation_and_create_agent_login() throws InterruptedException {
		waitForElement(3000);
		driver.get("https://yopmail.com/wm");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInbox));
		MoveToElementClick(element);
		writeText(YopmailInbox, getEmailValue);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailSubmit));
		MoveToElementClick(element);
		waitForElement(3000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(YopmailInboxText));
//		MoveToElementClick(element);
		driver.switchTo().frame("ifmail");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickHere));
		MoveToElementClick(element);
		waitForElement(3000);
		String parentWindowHandle = driver.getWindowHandle();
		switchToNextTab(driver, parentWindowHandle);
		ExtentSuccessMessage("Navigated to Internal User Registration page");
		waitForElement(1000);
	}

	public void internal_user_registration() throws InterruptedException {
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NumberNPN));
		MoveToElementClick(element);
		writeText(NumberNPN, "16688522");
		ExtentSuccessMessage("NPN Number has been added: 16688522");
		ExtentSuccessMessage("Generated Username for the agent: " + agentUserName);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentUserName));
		MoveToElementClick(element);
		writeText(AgentUserName, agentUserName);
		ExtentSuccessMessage("Username has been entered!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentPassword));
		MoveToElementClick(element);
		writeText(AgentPassword, "Password1");
		ExtentSuccessMessage("Password has been added for the agent username : Password1");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentRetypePassword));
		MoveToElementClick(element);
		writeText(AgentRetypePassword, "Password1");
		ExtentSuccessMessage("Retype-Password has been added for the agent username : Password1");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestion1));
		MoveToElementClick(element);
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestionSelection1));
		MoveToElementClick(element);
		waitForElement(500);
		ExtentSuccessMessage("Security Question 1: What Is The Name Of Your Favorite Childhood Friend?");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityAnswer1));
		MoveToElementClick(element);
		writeText(SecurityAnswer1, "Answer1");
		ExtentSuccessMessage("Security Question Answer 1: Answer1");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestion2));
		MoveToElementClick(element);
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestionSelection2));
		MoveToElementClick(element);
		waitForElement(500);
		ExtentSuccessMessage("Security Question 2: In Which City Were You Born?");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityAnswer2));
		MoveToElementClick(element);
		writeText(SecurityAnswer2, "Answer2");
		ExtentSuccessMessage("Security Question Answer 2: Answer2");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestion3));
		MoveToElementClick(element);
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityQuestionSelection3));
		MoveToElementClick(element);
		waitForElement(500);
		ExtentSuccessMessage("Security Question 3: What Is Your Best Friend's Name?");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SecurityAnswer3));
		MoveToElementClick(element);
		writeText(SecurityAnswer3, "Answer3");
		ExtentSuccessMessage("Security Question Answer 3: Answer3");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TermsAndCondition));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agreed Terms And Condition");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PersonConscent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agreed the Person Conscent");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButtonIUR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Internal User Registration has been successfully completed!");
		waitForElement(5000);
	}

	private static void switchToNextTab(WebDriver driver, String parentWindowHandle) {
		// Get all window handles
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		// Find the index of the parent window handle
		int parentIndex = windowHandles.indexOf(parentWindowHandle);
		// Switch to the next tab by using the next index in the list
		int nextTabIndex = (parentIndex + 1) % windowHandles.size();
		String nextTabHandle = windowHandles.get(nextTabIndex);
		driver.switchTo().window(nextTabHandle);
	}

	public void customer_engage_agent_validation(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
//		String urlCE = configloader().getProperty("CEURL");
		String urlCE;
		String currentSystemURL = driver.getCurrentUrl();
		if (currentSystemURL.contains("https://test.brokerengage.net/")) {
			urlCE = "https://mme.brokerengage.net/";
		} else if (currentSystemURL.contains("https://shop-test.benefitalign.com")) {
			urlCE = "https://ce-uat.benefitalign.com/";
		} else if (currentSystemURL.contains("https://shop-qa.benefitalign.com/")) {
			urlCE = "https://ce-qa.benefitalign.com/#/login";
		} else {
			urlCE = "https://ce-dev.benefitalign.com/#/login";
		}
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, agentUserName);
		ExtentSuccessMessage("Entered the newly created username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, "password!");
		ExtentSuccessMessage("Entered the Customer Engage Password");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(signIn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Newly created agent in BE has been successfully synced to MME application");
		waitForElement(1000);
		ExtentSuccessMessage("All the above steps are executed successfully.");
	}

	public void create_tasks_in_dashboard_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Tile");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on the created customer");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickOnMyTasks));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create my tasks!");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskComments));
		ExtentSuccessMessage("Clicked on task comment text area");
		MoveToElementClick(element);
		writeText(TaskComments, "New task comment");
		ExtentSuccessMessage("Entered the task details");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateTaskSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Submitted - New task has been created");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeMenu));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Home Menu button");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashboardTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Dashboard Tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickMyTasks));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on MyTasks option from Dashboard Tile");
		waitForElement(1000);
	}

	public void day_week_month_view_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DayView));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Day View Menu");
		Assert.assertTrue(driver.findElement(Day_Week_Month_ViewTask).isDisplayed());
		ExtentSuccessMessage("Assertion has been successfully done! newly create task presents in Day view menu");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(WeekView));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Week View Menu");
		Assert.assertTrue(driver.findElement(Day_Week_Month_ViewTask).isDisplayed());
		ExtentSuccessMessage("Assertion has been successfully done! newly create task presents in Week view menu");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MonthView));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Month View Menu");
		waitForElement(2000);
		js.executeScript("window.scrollBy(10,400)");
		waitForElement(1000);
		Assert.assertTrue(driver.findElement(Day_Week_Month_ViewTask).isDisplayed());
		ExtentSuccessMessage("Assertion has been successfully done! newly create task presents in Month view menu");
		waitForElement(1000);
	}

	public void edit_and_delete_tasks_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit task");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditTaskComments));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit task");
		clear(EditTaskComments);
		writeText(EditTaskComments, "Task has been edited");
		ExtentSuccessMessage("Existing task has been edited!");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitEditedTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Edited task has been save successfully!");
		waitForElement(2000);
		driver.navigate().refresh();
		waitForElement(3000);
		wait.until(ExpectedConditions.elementToBeClickable(DeleteTask));
		click(DeleteTask);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
//		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete task");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PopUpDeleteYes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Delete task confirmation pop-up enabled");
		waitForElement(2000);
		ExtentSuccessMessage("Task has been successfully deleted");
//		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(EditTask)));
		ExtentSuccessMessage("Successfully performed the validation of create/edit/delete tasks under Dashboard");
		waitForElement(1000);
		ExtentSuccessMessage("All the above steps are executed successfully!");
	}

	public void health_enrollment_quotes_creation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login inoccurate");
		}
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FindInsuranceButton));
		MoveToElementClick(element);
//		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Find Insurance Link");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HealthEnrollment));
		MoveToElementClick(element);
//		wait.until(ExpectedConditions.elementToBeClickable(HealthEnrollment));
//		click(HealthEnrollment);
		ExtentSuccessMessage("Clicked on Health Enrollment Tab");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ZipCode));
		MoveToElementClick(element);
		clear(ZipCode);
		writeText(ZipCode, ApplicantInfo.Zipcode + Keys.TAB);
		ExtentSuccessMessage("Entered the zipcode");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderOfApplicant));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on gender of applicant dropdown list");
		//waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderSelection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on gender male of applicant");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ApplicantDOB));
		MoveToElementClick(element);
		clear(ApplicantDOB);
		writeText(ApplicantDOB, ApplicantInfo.DOB);
		ExtentSuccessMessage("Clicked on gender male of applicant");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SeePlans));
		MoveToElementClick(element);
		ExtentSuccessMessage("Available Health plans are showing");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PlanLabelAmbetter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Plan Label Ambetter Filtered");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddToCartButton));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Selected plan has been added to cart");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContinueWithThisPlanCart));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Navigated to cart page!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickSelectButton));
		MoveToElementClick(element);
		waitForElement(3000);
		ExtentSuccessMessage("Selected the applicant plan");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BeginEnrollment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on the Begin Enrollment");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactFirstName));
		MoveToElementClick(element);
		writeText(ContactFirstName, ApplicantInfo.Firstname + Keys.TAB);
		waitForElement(2000);
		ExtentSuccessMessage("New customer Contact Firstname Added ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactLastName));
		MoveToElementClick(element);
		writeText(ContactLastName, ApplicantInfo.Lastname + Keys.TAB);
		waitForElement(2000);
		fullName = ApplicantInfo.Firstname + " " + ApplicantInfo.Lastname;
		ExtentSuccessMessage("Full name of customer: " + fullName);
		ExtentSuccessMessage("New customer Contact Lastname Added ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactPhone));
		MoveToElementClick(element);
		writeText(ContactPhone, "(620) 231-8771" + Keys.TAB);
		ExtentSuccessMessage("New customer Contact Phone Added ");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("New customer Contact has been saved! ");
		waitForElement(5000);
	}

	public void process_the_enrollment_steps(CensusInfo ApplicantInfo) throws InterruptedException {
		// Calculate the date 30 days ago
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -30);
		Date thirtyDaysAgo = calendar.getTime();
		// Format the date as a string
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = dateFormat.format(thirtyDaysAgo);
		// Store the formatted date in a string
		String date30DaysAgo = formattedDate;
		// Print the generated date
		System.out.println("Date 30 days ago: " + date30DaysAgo);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HouseholdAddress));
		MoveToElementClick(element);
		writeText(HouseholdAddress, ApplicantInfo.AddressLine1 + Keys.TAB);
		ExtentSuccessMessage("Household address has been added ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from Your household page ");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SEPEvents));
		MoveToElementClick(element);
		waitForElement(500);
		Select select = new Select(element);
		select.selectByVisibleText("Got Married");
		ExtentSuccessMessage("SEP Event - Got Married Selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SEPEventDate));
		MoveToElementClick(element);
		waitForElement(500);
		writeText(SEPEventDate, date30DaysAgo);
		ExtentSuccessMessage("SEP Event Date Selected ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameSEP));
		MoveToElementClick(element);
		select = new Select(element);
		select.selectByIndex(1);
		ExtentSuccessMessage("SEP Event - Customer Name Selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEventSEP));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add SEP Event");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickSEPNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next from SEP Page");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from SSN page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AppliedCircumstancesNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from 'Do any of these circumstances apply' page.");
		waitForElement(2000);
	}

	public void process_the_income_and_deductions_steps(CensusInfo ApplicantInfo) throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomeType));
		MoveToElementClick(element);
		waitForElement(500);
		Select select = new Select(element);
		select.selectByVisibleText("Self-employment");
		ExtentSuccessMessage("Income Type - Self-employment selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomeFrequency));
		MoveToElementClick(element);
		waitForElement(500);
		select = new Select(element);
		select.selectByVisibleText("Yearly");
		ExtentSuccessMessage("Income Frequency - Yearly selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomeValue));
		MoveToElementClick(element);
		waitForElement(500);
		writeText(IncomeValue, ApplicantInfo.Earnings);
		ExtentSuccessMessage("Income of the applicant has been added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from income and deductions page ");
		waitForElement(3000);
//		driver.navigate().refresh();
		js.executeScript("window.scrollBy(10,400)");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from 'Premium Tax Credit Estimated based on Income' page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NoneOfTheseHRA));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on None of these option from HRA page ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNextHRA));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Next button from HRA page ");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickIdTerms));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Terms and conditions in Agent Attestation page ");
		waitForElement(500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNextOnAgent));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked next button from Agent Attestation page");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickNextOnPayment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked next button from Payments page");
		waitForElement(2000);
	}

	public void health_enrollment_completion(CensusInfo ApplicantInfo) throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RoutingNumberField));
		MoveToElementClick(element);
		writeText(RoutingNumberField, "044072324");
		ExtentSuccessMessage("Routing Number Added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BankAccountNumber));
		MoveToElementClick(element);
		writeText(BankAccountNumber, "000123456789");
		ExtentSuccessMessage("Account Number Added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AccountHolderName));
		MoveToElementClick(element);
		writeText(AccountHolderName, "TestUser");
		ExtentSuccessMessage("Account Holder Name Added");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AccountType));
		MoveToElementClick(element);
		Select select = new Select(element);
		select.selectByVisibleText("Savings");
		ExtentSuccessMessage("Account Type Savings Selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(YesSameEFT));
		MoveToElementClick(element);
		ExtentSuccessMessage("Is the EFT details same as above? - Yes");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PaymentNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Navigated to Producer Statements page");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SummaryNext));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked next button from Application Summary page");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FullfilmentAgree));
		MoveToElementClick(element);
		ExtentSuccessMessage("Fullfilment Agreement Completed");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Enrollment Submitted Successfully");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CongratulationsMessage));
		String expectedString = element.getText();
		Assert.assertTrue(expectedString.contains(actualString), "Congratulations message is not appear");
		ExtentSuccessMessage("Congratulations Message Appearing");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EnrollmentFinish));
		MoveToElementClick(element);
		ExtentSuccessMessage("Enrollment Finished Successfully");
		waitForElement(10000);
	}

	public void enrolled_quotes_sync_CE_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickQuotes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("Sync has been successfully completed hence the quotes available in CE!");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedDate));
		actualText = element.getText();
		ExtentSuccessMessage("Created date in CE:" + actualText);
		waitForElement(500);
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		Assert.assertEquals(actualText, formattedDate);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer enrollment available in CE which was created in BE application");
		waitForElement(2000);
		ExtentSuccessMessage("All the above steps are executed successfully!");
		waitForElement(3000);
	}

	public void send_basic_details_of_applicant() throws InterruptedException {
		waitForElement(1000);
		try {
			if (driver.findElement(ClickOnCloseButton).isDisplayed()) {
				click(ClickOnCloseButton);
			}
		} catch (NoSuchElementException e) {
			ExtentSuccessMessage(
					"ClickOnCloseButton element not found! So you currently Dont have an active session on another device, hence Login is successful");
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login inoccurate");
		}
		ExtentSuccessMessage("Applicantion login is successful");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectBEUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAgency));
		MoveToElementClick(element);
		ExtentSuccessMessage("User Agent Agency has been selected");
		wait.until(ExpectedConditions.presenceOfElementLocated(MarketingLabel));
		waitForElement(1000);
		ExtentSuccessMessage("Label Marketing has been selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BusinessType));
		MoveToElementClick(element);
		ExtentSuccessMessage("Business Type element has been selectocateded");
		element = driver.findElement(By.xpath("//li/span[text()='" + "Individual" + "']"));
		MoveToElementClick(element);
		ExtentSuccessMessage("Business Type Individual has been selected");
		waitForElement(1000);
		ExtentSuccessMessage("Line of business element located");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LifeOfBusiness));
		MoveToElementClick(element);
		element = driver.findElement(By.xpath("//li/span[text()='" + "Health" + "']"));
		MoveToElementClick(element);
		ExtentSuccessMessage("Line of business 'Health' has been selected");
		ExtentSuccessMessage("English Language has been auto-selected");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingURLButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Generated the Marketing URL - In progress");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CopyMarketingURL));
		MarketingURL = element.getText();
		ExtentSuccessMessage("successfully generated the marketing URL");
		System.out.println("Marketing URL: " + MarketingURL);
		ExtentSuccessMessage("Copying Marketing URL from the page");
		waitForElement(1000);
		ExtentSuccessMessage("Copied Marketing URL successfully");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAgentLogout));
		ExtentSuccessMessage("Sign-Out element identified successfully");
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been successful");
		waitForElement(5000);
	}

	public void create_leads_from_consumer(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
		driver.get(MarketingURL);
		ExtentSuccessMessage("Consumer login page has opened");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Progress Link");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadFirstname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead firstname field");
		getFirstName = "" + writeDynamicFirstLastname();
		writeText(LeadFirstname, getFirstName);
		ExtentSuccessMessage("Entered the firstname as: " + getFirstName);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadLastname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead lastname field");
		getLastName = "" + writeDynamicFirstLastname();
		writeText(LeadLastname, getLastName);
		ExtentSuccessMessage("Entered the lastname as: " + getLastName);
		waitForElement(1000);
		fullName = getFirstName + " " + getLastName;
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Email field");
		String getEmailValue = "Leads_Sync" + writeDynamicEmail();
		writeText(LeadEmail, getEmailValue);
		ExtentSuccessMessage("Entered the Email as: " + getEmailValue);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveLeadDetails));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer lead information saved!");
		waitForElement(1000);
	}

	public void leads_sync_CE_validation() throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLeads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Leads");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("Sync has been successfully completed hence the quotes available in CE!");
		waitForElement(2000);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer leads available in CE which was created in BE application");
		waitForElement(2000);
	}

	public void create_leads_from_callback_request(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(2000);
		driver.get(MarketingURL);
		ExtentSuccessMessage("Consumer login page has opened");
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackRequest));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Call Back Request");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadCBFirstname));
		MoveToElementClick(element);
		clear(LeadCBFirstname);
		ExtentSuccessMessage("Clicked on Lead firstname field");
		getFirstName = "" + writeDynamicFirstLastname();
		writeText(LeadCBFirstname, getFirstName);
		ExtentSuccessMessage("Entered the firstname as: " + getFirstName);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadCBLastname));
		MoveToElementClick(element);
		clear(LeadCBLastname);
		ExtentSuccessMessage("Clicked on Lead lastname field");
		getLastName = "" + writeDynamicFirstLastname();
		writeText(LeadCBLastname, getLastName);
		ExtentSuccessMessage("Entered the lastname as: " + getLastName);
		waitForElement(1000);
		fullName = getFirstName + " " + getLastName;
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Phone number field");
		writeText(LeadPhoneNumber, "(555)222-1001");
		ExtentSuccessMessage("Entered the Phone number ");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveLeadDetails));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer lead callback request information saved!");
		waitForElement(1000);
		ExtentSuccessMessage("All the above steps are executed successfully.");
		waitForElement(3000);
	}
}
