package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Carrier360;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.CustomersCreationPage;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class CA_TS_003_005_TC_001_002_004_Existing_Carrier_Policy_Validations_Apply_Filter_Criteria extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();

	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	CensusInfo DependentInfo = new CensusInfo();
	public void Policy_Validation()
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		Carrier360 Carrier360 = new Carrier360(driver);
		CustomersCreationPage CustomersCreationPage = new CustomersCreationPage(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
			ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
			ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* CA_TS_003_005_TC_001_002_004_Policy_Validations_Apply_Filter_Criteria ***************");  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize();
		Carrier360.existing_carriers_Tabs();
		Carrier360.agency_CreateNewCarrierGroup();
		Carrier360.Policy_Validation();
		Carrier360.Filter_Validation();
		Carrier360.ApplyFilter();
		consumerpage.logout_CE_validations();
	}
}
