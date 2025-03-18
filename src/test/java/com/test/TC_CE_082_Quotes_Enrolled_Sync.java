package com.test;

import java.text.SimpleDateFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import com.pages.CensusInfo;
//import com.pages.FindApplicationPage;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.CustomerEngageFunctionalityValidationsSync;
import com.pages.IncomeInfo;

import Common.Dateformatter;
import Common.Main;
import Utility.ExcelHelper;
public class TC_CE_082_Quotes_Enrolled_Sync extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void EG_TC_CE11(CensusInfo ApplicantInfo)
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidationsSync consumerpage = new CustomerEngageFunctionalityValidationsSync(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE11");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();   
	        ApplicantInfo.AddressLine1=tcTestData.getRow(1).getCell(11).getStringCellValue().toString();
	        ApplicantInfo.Phone=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.Firstname = tcTestData.getRow(1).getCell(6).getStringCellValue().toString();
	        ApplicantInfo.Lastname = tcTestData.getRow(1).getCell(8).getStringCellValue().toString();
	        ApplicantInfo.AddressLine1=tcTestData.getRow(1).getCell(11).getStringCellValue().toString(); 
	        ApplicantInfo.Earnings=tcTestData.getRow(1).getCell(13).getStringCellValue().toString(); 

		}

		System.out.println("******* TC_CE_082_Quotes_Enrolled_Sync ***************");
		
		consumerpage.login_CE_validations();
		consumerpage.health_enrollment_quotes_creation(ApplicantInfo);
		consumerpage.process_the_enrollment_steps(ApplicantInfo);
		consumerpage.process_the_income_and_deductions_steps(ApplicantInfo);
		consumerpage.health_enrollment_completion(ApplicantInfo);
		consumerpage.logout_from_BE_applicant();
		consumerpage.customer_engage_validation(ApplicantInfo);
		consumerpage.enrolled_quotes_sync_CE_validation();
	}

}
