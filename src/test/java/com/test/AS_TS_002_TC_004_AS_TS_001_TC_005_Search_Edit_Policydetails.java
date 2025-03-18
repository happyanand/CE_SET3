package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.CustomersCreationPage;
import com.pages.Policy_Validations;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class AS_TS_002_TC_004_AS_TS_001_TC_005_Search_Edit_Policydetails extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void EG_TC_Search_Edit_Policydetails()
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		Policy_Validations Policy_Validations =new Policy_Validations(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* Customer Engage Search and Edit Records Validations AS_TS_002_TC_004_AS_TS_001_TC_005 ***************");  
		consumerpage.login_CE_validations();
		//SalesLeadPage.cttMinimize();
		Policy_Validations.validate_Policy_details();
		consumerpage.logout_CE_validations();
		
	} 

	}
 
