package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.Carrier360;
import com.pages.Carrier_360_Grid_Page;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.CustomersCreationPage;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration extends AllScenarios_EG_TC {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void Carrier_Details_Validation()
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		Carrier360 Carrier360 = new Carrier360(driver);
		Carrier_360_Grid_Page Carrier_360_Grid = new Carrier_360_Grid_Page(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* Carrier Details Validatiom CA_TS_001_TC_001_002_003_004_Carrier_Create_Edit_validate_Grid_Contact_Collabration ***************");  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize();
		Carrier360.createnewcarrier();
		//Carrier_360_Grid.Carrier_gridfields();
		Carrier360.Carrier_Details_Validation();
		Carrier_360_Grid.edit_Carrier_details();
		Carrier360.Contacts_validation();
		Carrier_360_Grid.add_colobration_details(); 
		Carrier360.Agent_Appointment();
		//Carrier_360_Grid.add_colobration_details();
		consumerpage.logout_CE_validations();
	
	}
}
