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
import com.pages.IncomeInfo;

import Common.Dateformatter;
import Common.Main;
import Utility.ExcelHelper;
public class TS_SMS_Campaign_ScheduleLater extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void EG_TC_SMS_Campaign_ScheduleLater(CensusInfo ApplicantInfo)
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE2");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString(); 
	        ApplicantInfo.ListName = tcTestData.getRow(1).getCell(4).getStringCellValue().toString();
	        ApplicantInfo.TemplateName = tcTestData.getRow(1).getCell(10).getStringCellValue().toString(); 
	        ApplicantInfo.CustomListName = tcTestData.getRow(1).getCell(6).getStringCellValue().toString();  

 
 
		}

		System.out.println("******* Customer Engage MarketingSMS ScheduleLater ***************");		  
		consumerpage.login_CE_validations();
		consumerpage.cti_Minimize();
		consumerpage.validate_Schedule_SMSCamapign(ApplicantInfo);
		consumerpage.logout_CE_validations();
	}

}
