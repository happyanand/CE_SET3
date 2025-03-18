package com.test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.pages.CensusInfo;

import Common.TriggerEmail;

public class AllScenarios_EG_TC extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	//	public static com.pages.HomePage homepage;
	// HomePage homepage;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	@Override
	public WebDriver getDriver() {
		//		homepage = new com.pages.HomePage(driver);
		return driver;
	}


	TC_CE_014_015_016_017_Sales_Lead_Create_Status_Convert_Actions TC_CE_014_015_016_017_Sales_Lead_Create_Status_Convert_Actions;
	TC_CE_018_019_Sales_Lead_Edit_Reject_Filter_AdvanceSearch TC_CE_018_019_Sales_Lead_Edit_Reject_Filter_AdvanceSearch;
	LD_TS_001_TC_011_CreateLead_MapCampaign_Select_Call_Disposition LD_TS_001_TC_011_CreateLead_MapCampaign_Select_Call_Disposition;
	TC_CE_082_Quotes_Enrolled_Sync TC_CE_082_Quotes_Enrolled_Sync;
	TC_CE_026_027_028_Sales_Quotes_CreateNewOpportunityFromLead_QuotesFromOpportunity_Actions TC_CE_026_027_028_Sales_Quotes_CreateNewOpportunityFromLead_QuotesFromOpportunity_Actions;
	TC_CE_029_030_Sales_Quotes_QuotesFilter_AdvanceSearch_TerminatePolicy TC_CE_029_030_Sales_Quotes_QuotesFilter_AdvanceSearch_TerminatePolicy;
	
	CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration;
	CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria;
	AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails;
	TC_CE_031_032_033_Sales_Policy_Create_Terminate_Actions TC_CE_031_032_033_Sales_Policy_Create_Terminate_Actions;
	TC_CE_034_035_Sales_Policy_PolicyFilter_Export_AdvanceSearch TC_CE_034_035_Sales_Policy_PolicyFilter_Export_AdvanceSearch;
	TC_CE_036_Sales_Policy_ImportPolicy TC_CE_036_Sales_Policy_ImportPolicy;
	TC_CE_004_Marketing_List TC_CE_004_Marketing_List;
	MS_TS_002_TC_001_To_007Custom_List_Template MS_TS_002_TC_001_To_007Custom_List_Template;
	TC_CE_005_SegmentedList TC_CE_005_SegmentedList;
	MS_SL_TS_006_TC_004_Income_Range MS_SL_TS_006_TC_004_Income_Range;
	TC_CE_006_Marketing_Template TC_CE_006_Marketing_Template;
	MS_TS_007_TC_001_To_015_018_019_022_023_Email_Campaign MS_TS_007_TC_001_To_015_018_019_022_023_Email_Campaign;
	MS_TS_007_TC_016_ScheduleLater_EmailCampaign MS_TS_007_TC_016_ScheduleLater_EmailCampaign;
	TC_CE_008_Marketing_CallCampaign TC_CE_008_Marketing_CallCampaign;
	TC_CE_009_Marketing_SMSCampaigns TC_CE_009_Marketing_SMSCampaigns;
	TS_SMS_Campaign_ScheduleLater TS_SMS_Campaign_ScheduleLater;
	TC_CE_076_Report_Live TC_CE_076_Report_Live;
	TC_CE_077_Report_Schedule TC_CE_077_Report_Schedule;
	TC_CE_079_Report_Pivot TC_CE_079_Report_Pivot;
	

	TC_CE_059_060_061_ServiceRequest_Activity_Actions TC_CE_059_060_061_ServiceRequest_Activity_Actions;
	TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest;
	
	
	
	By signInButtonClass = By.className("btnSignIn");
	By signout = By.xpath("//a[@class=\"dropdownMenu user-details-menuSection dropdownArrowMenu\"]");
	By signoutbtn = By.xpath("//*[@id='dropdownMenuListSec']//a[contains(text(),'Sign Out')]");
	By signoutInshura = By.xpath("//div[@class=\"signoutsec\"]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("PLCA");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
 
		
		TC_CE_014_015_016_017_Sales_Lead_Create_Status_Convert_Actions = new TC_CE_014_015_016_017_Sales_Lead_Create_Status_Convert_Actions();
		TC_CE_018_019_Sales_Lead_Edit_Reject_Filter_AdvanceSearch = new TC_CE_018_019_Sales_Lead_Edit_Reject_Filter_AdvanceSearch();
		LD_TS_001_TC_011_CreateLead_MapCampaign_Select_Call_Disposition = new LD_TS_001_TC_011_CreateLead_MapCampaign_Select_Call_Disposition();
		TC_CE_082_Quotes_Enrolled_Sync = new TC_CE_082_Quotes_Enrolled_Sync();
		TC_CE_026_027_028_Sales_Quotes_CreateNewOpportunityFromLead_QuotesFromOpportunity_Actions = new TC_CE_026_027_028_Sales_Quotes_CreateNewOpportunityFromLead_QuotesFromOpportunity_Actions();	
		TC_CE_029_030_Sales_Quotes_QuotesFilter_AdvanceSearch_TerminatePolicy = new TC_CE_029_030_Sales_Quotes_QuotesFilter_AdvanceSearch_TerminatePolicy();
		
        CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration = new CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration();
        CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria = new CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria();
        AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails = new AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails();
        TC_CE_031_032_033_Sales_Policy_Create_Terminate_Actions = new TC_CE_031_032_033_Sales_Policy_Create_Terminate_Actions();
        TC_CE_034_035_Sales_Policy_PolicyFilter_Export_AdvanceSearch = new TC_CE_034_035_Sales_Policy_PolicyFilter_Export_AdvanceSearch();
		
		TC_CE_036_Sales_Policy_ImportPolicy = new TC_CE_036_Sales_Policy_ImportPolicy();
        TC_CE_004_Marketing_List = new TC_CE_004_Marketing_List();
        MS_TS_002_TC_001_To_007Custom_List_Template = new MS_TS_002_TC_001_To_007Custom_List_Template();
        TC_CE_005_SegmentedList = new TC_CE_005_SegmentedList();
        MS_SL_TS_006_TC_004_Income_Range = new MS_SL_TS_006_TC_004_Income_Range();
        TC_CE_006_Marketing_Template = new TC_CE_006_Marketing_Template();
        MS_TS_007_TC_001_To_015_018_019_022_023_Email_Campaign = new MS_TS_007_TC_001_To_015_018_019_022_023_Email_Campaign();
        MS_TS_007_TC_016_ScheduleLater_EmailCampaign = new MS_TS_007_TC_016_ScheduleLater_EmailCampaign();
        TC_CE_008_Marketing_CallCampaign = new TC_CE_008_Marketing_CallCampaign();
        TC_CE_009_Marketing_SMSCampaigns = new TC_CE_009_Marketing_SMSCampaigns();
        TS_SMS_Campaign_ScheduleLater = new TS_SMS_Campaign_ScheduleLater();
        
        TC_CE_076_Report_Live = new TC_CE_076_Report_Live();
		TC_CE_077_Report_Schedule=  new TC_CE_077_Report_Schedule();
		TC_CE_079_Report_Pivot = new TC_CE_079_Report_Pivot();
        TC_CE_059_060_061_ServiceRequest_Activity_Actions = new TC_CE_059_060_061_ServiceRequest_Activity_Actions();
		TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest = new TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest();
		
	}
	
	public void LoginCEUserFiveCognito() throws InterruptedException {
        String ReferenceLogin = "PLCA";
        try {
               Base_Class.SetUpCEUserfiveCognito(ReferenceLogin);
               ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
               Log.info("Login successful !");
               // ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
               // Application URL ");
        } catch (IOException e) {
               e.printStackTrace();
        } catch (InterruptedException e) {
               e.printStackTrace();
        }
 }


	//	public void Login() throws InterruptedException {
	//		String ReferenceLogin = "PLCA";
	//		try {
	//			Base_Class.SetUp(ReferenceLogin);
	//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
	//			Log.info("Login successful !");
	//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
	//			// Application URL ");
	//			
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	public void LoginCustomerEngage() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegression(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void SetUpRegressionForCall() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCall(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void LoginCEUserFiveSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserfiveSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void LoginCEUserFive() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserfive(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void LoginSanity() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpSanity(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//	public void LoginBrokerEngage() throws InterruptedException {
	//		String ReferenceLogin = "PLCA";
	//		try {
	//			Base_Class.SetUpP2Regression(ReferenceLogin);
	//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
	//			Log.info("Login successful !");
	//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
	//			// Application URL ");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	//	public void AdminAgentLoginBE() throws InterruptedException {
	//		String ReferenceLogin = "PLCA";
	//		try {
	//			Base_Class.LoginAdminAgent(ReferenceLogin);
	//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
	//			Log.info("Login successful !");
	//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
	//			// Application URL ");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	public void Logout() throws InterruptedException, AWTException {

		driver.quit();

	}

	public void LoginBrokerEngage() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpP2Regression(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginBrokerEngageSync() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpBeCeSync(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void LoginCEUserTwo() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsertwo(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginCEUsersix() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsersix(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUsersixSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsersixSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserseven() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserseven(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUsersevenSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsersevenSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginCEUsereight() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsereight(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUsereightSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsereightSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LoginCEUserOne() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserone(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void LoginCEUser_1() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpUser1(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUser_1SSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpUser1SSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}




	public void AdminAgentLoginBE() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.LoginAdminAgent(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {

		CensusInfo ApplicantInfo = new CensusInfo();
		CensusInfo spCensusInfo = new CensusInfo();
		CensusInfo SpouseInfo = new CensusInfo();
		new CensusInfo();
		CensusInfo DependentsInfo = new CensusInfo();
		//		ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
		new CensusInfo();

		try {
			testdata.get("TestScenario").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");

				switch (testdata.get("TestScenario").toString()) {
					
				case "LD_TS_001_TC_011_CreateLead_MapCampaign_Select_Call_Disposition":
					context.setAttribute("fileName", "Login");
					//LoginCEUsereight();
					LoginCEUserFiveCognito();
					LD_TS_001_TC_011_CreateLead_MapCampaign_Select_Call_Disposition.EG_TC_slect_call_disposition();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
				case "TC_CE_014_015_016_017_Sales_Lead_Create_Status_Convert_Actions":
					context.setAttribute("fileName", "Login");
					//LoginCEUserTwo();					
					LoginCEUserFiveCognito();
					TC_CE_014_015_016_017_Sales_Lead_Create_Status_Convert_Actions.salesLead(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;		
					
						
				case "TC_CE_018_019_Sales_Lead_Edit_Reject_Filter_AdvanceSearch":
					context.setAttribute("fileName", "Login");
					//LoginCEUserTwo();
					LoginCEUserFiveCognito();
					TC_CE_018_019_Sales_Lead_Edit_Reject_Filter_AdvanceSearch.salesFilterStatus();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;


				case "TC_CE_082_Quotes_Enrolled_Sync":
					context.setAttribute("fileName", "Login");
					LoginBrokerEngage();
					TC_CE_082_Quotes_Enrolled_Sync.EG_TC_CE11(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "TC_CE_026_027_028_Sales_Quotes_CreateNewOpportunityFromLead_QuotesFromOpportunity_Actions":
					context.setAttribute("fileName", "Login");
					//LoginCEUserseven();
					LoginCEUserFiveCognito();
					TC_CE_026_027_028_Sales_Quotes_CreateNewOpportunityFromLead_QuotesFromOpportunity_Actions.Sales_Quotes_CreateNewOpportunityFromLead();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;		

			
				case "TC_CE_029_030_Sales_Quotes_QuotesFilter_AdvanceSearch_TerminatePolicy":
					context.setAttribute("fileName", "Login");
					//LoginCEUserseven();
					LoginCEUserFiveCognito();
					TC_CE_029_030_Sales_Quotes_QuotesFilter_AdvanceSearch_TerminatePolicy.salesQuotesFilter();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;		
					
				//CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration
				case "CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration":
					context.setAttribute("fileName", "Login");
					//LoginCEUser_1();
					LoginCEUserFiveCognito();
					CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration.Carrier_Details_Validation();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					//CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria
					
				case "CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria":
					context.setAttribute("fileName", "Login");
					//LoginCEUser_1();
					LoginCEUserFiveCognito();
					CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria.Policy_Validation();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
				case "AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails":
					context.setAttribute("fileName", "Login");
					LoginCEUserseven();
					AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails.EG_TC_Search_Edit_Policydetails();
					Logout();
					context.setAttribute("fileName", "Logout");
					break; 
					
				case "TC_CE_031_032_033_Sales_Policy_Create_Terminate_Actions":
					context.setAttribute("fileName", "Login");
					//LoginCEUserTwo();
					LoginCEUserFiveCognito();
					TC_CE_031_032_033_Sales_Policy_Create_Terminate_Actions.salesPolicyCreateNewPolicy();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
								
					 
								
				case "TC_CE_034_035_Sales_Policy_PolicyFilter_Export_AdvanceSearch":
					context.setAttribute("fileName", "Login");
					//LoginCEUserTwo();
					LoginCEUserFiveCognito();
					TC_CE_034_035_Sales_Policy_PolicyFilter_Export_AdvanceSearch.salesPolicyFilter();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
								
				
						
				case "TC_CE_036_Sales_Policy_ImportPolicy":
					context.setAttribute("fileName", "Login");
					LoginCEUserTwo();
					TC_CE_036_Sales_Policy_ImportPolicy.salesPolicyImport();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				
				
					
				case "TC_CE_004_Marketing_List":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_004_Marketing_List.EG_TC_CE4(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
						
				case "MS_TS_002_TC_001_To_007Custom_List_Template":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					MS_TS_002_TC_001_To_007Custom_List_Template.EG_TC_005_Custom_Template(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
		
				case "TC_CE_005_SegmentedList":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_005_SegmentedList.EG_TC_CE5(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
					
					
				case "MS_SL_TS_006_TC_004_Income_Range":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					MS_SL_TS_006_TC_004_Income_Range.EG_TC_004_SegmentedLsit_IncomeRange(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
					
					
				case "TC_CE_006_Marketing_Template":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_006_Marketing_Template.EG_TC_CE6(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
					
				case "MS_TS_007_TC_001_To_015_018_019_022_023_Email_Campaign":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					MS_TS_007_TC_001_To_015_018_019_022_023_Email_Campaign.EG_TC_001_to_015_018(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
						
				case "MS_TS_007_TC_016_ScheduleLater_EmailCampaign":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					MS_TS_007_TC_016_ScheduleLater_EmailCampaign.EG_TC_016_ScheduleLater_EmailCampaign(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
					
				case "TC_CE_008_Marketing_CallCampaign":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_008_Marketing_CallCampaign.EG_TC_CE8(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
					
					
				case "TC_CE_009_Marketing_SMSCampaigns":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_009_Marketing_SMSCampaigns.EG_TC_CE9(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
					
					
					 
				case "TS_SMS_Campaign_ScheduleLater":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TS_SMS_Campaign_ScheduleLater.EG_TC_SMS_Campaign_ScheduleLater(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "TC_CE_059_060_061_ServiceRequest_Activity_Actions":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_059_060_061_ServiceRequest_Activity_Actions.serviceCreateNewServiceRequest();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
							
			 
						
				case "TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_062_063_064_065_ServiceFilter_AdvanceSearch_Export_ClosingRequest.serviceFilter();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;
						
				case "TC_CE_076_Report_Live":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_076_Report_Live.EG_TC_CE76(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
				case "TC_CE_077_Report_Schedule":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_077_Report_Schedule.EG_TC_CE77(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					

					
				case "TC_CE_079_Report_Pivot":
					context.setAttribute("fileName", "Login");
					LoginCEUserFive();
					TC_CE_079_Report_Pivot.EG_TC_CE79(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					

				default:
					break;

				}

				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

		} catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
					+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if (driver != null)
				driver.quit();
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
	@AfterSuite
	public void sharingReport() throws IOException {

		//extent.flush();
		// driver.quit();
		if(	configloader().getProperty("triggermail").equalsIgnoreCase("Yes")){
			try {
				TriggerEmail.sendReport();
			} catch (Exception e) {
				// TODO Auto-generated catch blockdfghj
				e.printStackTrace();
			}

		}

	}
	public String writenameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;  
		int columnIndex = 8;
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
	public static String generateUsername() {
		int length = 6; // Set the desired length of the username
		String characters = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder username = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char randomChar = characters.charAt(random.nextInt(characters.length()));
			username.append(randomChar);
		}
		return username.toString();
	}


} 
