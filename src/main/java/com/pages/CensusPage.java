package com.pages;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.WaitWrapper;
import Utility.Logs.Log;

public class CensusPage extends BasePage{

	By Zipcode = By.xpath("//*[@id=\"ZipCode\"]"); 
	By PlansandPrices = By.xpath("//*[@class='waves-effect waves-light btn-large seeplans primary_background']"); 
	By Gender = By.xpath("//label[@for='CoveredMembers_0__Gender']/..//div[1]//input");
	By GenderSpouse = By.xpath("//label[@for='CoveredMembers_1__Gender']/..//div[1]//ul//li[3]");
	By GenderDep1 = By.xpath("//label[@for='CoveredMembers_2__Gender']/..//div[1]//ul//li[2]");
	By GenderDep2 = By.xpath("//label[@for='CoveredMembers_3__Gender']/..//div[1]//ul//li[3]");
	 By DOB1 = By.xpath("//*[@id=\"CoveredMembers_0__DateOfBirth\"]"); 
	 By TobaccoApplicant = By.xpath("//label[@for='CoveredMembers_0__TobaccoUsers']/..//div[1]//input");
	 By TobaccoYes1 = By.xpath("//label[@for='CoveredMembers_0__TobaccoUsers']/..//div[1]//ul//li[2]");
	 By TobaccoSpouse = By.xpath("//label[@for='CoveredMembers_1__TobaccoUsers']/..//div[1]//input");
	 By TobaccoYes2 = By.xpath("//label[@for='CoveredMembers_1__TobaccoUsers']/..//div[1]//ul//li[2]");
	 By IsPregnantApplicant = By.xpath("//*[@id='CoveredMembers_0_dv___Pregnant']/label/span");
	 By IsPregnantSpouse = By.xpath("//*[@id='CoveredMembers_1_dv___Pregnant']/label/span");
	 By DOB2 = By.xpath("//*[@id=\"CoveredMembers_1__DateOfBirth\"]");
	 By DOB3 = By.xpath("//*[@id=\"CoveredMembers_2__DateOfBirth\"]");
	 By DOB4 = By.xpath("//*[@id=\"CoveredMembers_3__DateOfBirth\"]");
	 By DOB5 = By.xpath("//*[@id=\"CoveredMembers_4__DateOfBirth\"]");
	 By AddSpousebtn = By.xpath("//*[@id=\"btn_spouse\"]"); 
	 By AddDependentbtn = By.xpath("//a[@id=\"btn_adddependents\"]"); 
	 By Text = By.xpath("//*[contains(text(),'If you want a child-only plan, make sure the applicant's age is less than 18 & the dependent's (if any) age is at least 18 or less.')]");
	By SkipforNow = By.xpath("//div[@class='modal-footer smallbuttons']//a[@id='stateLicenseSkip']");
	public CensusPage(WebDriver driver) {
        super(driver);
    }
	public void doFillCensusDetailsandGetPlan( CensusInfo ApplicantInfo, CensusInfo SpouseInfo, ArrayList<CensusInfo> DependentsInfo) throws InterruptedException, ParseException {
        Log.info("Going to Quote and Enroll");
        writeText(Zipcode, ApplicantInfo.Zipcode);
        WaitWrapper.waiter(3000, " ", driver);
        //driver.findElement(By.xpath("//span[contains(text(),'01/01/2023')]")).click();
        try {
			WebElement countymsg = driver.findElement(By.xpath("//span[@id='County-error']")); //find the text field
      
			if (countymsg.isDisplayed()) {
			    System.out.println("add county details");
			    driver.findElement(By.xpath("//label[@for='County']/..//div[1]//input")).click();
			    driver.findElement(By.xpath("//label[@for='County']/..//div[1]//ul//li[2]")).click();
				
			}
			else {
				System.out.println("no");
			}
			
		} catch (Exception e) {
			System.out.println("County element not found");
		}
        try {
			WebElement citymsg = driver.findElement(By.xpath("//span[@id='City-error']")); //find the text field
			if (citymsg.isDisplayed()) {
				 System.out.println("add city details");
				    driver.findElement(By.xpath("//label[@for='City']/..//div[1]//input")).click();
				    driver.findElement(By.xpath("//label[@for='City']/..//div[1]//ul//li[2]")).click();
			}
			else {
				System.out.println("no city found");
			}
		} catch (Exception e) {
			System.out.println("City element not found");
		}
        
       JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		 
        if(ApplicantInfo!=null&&ApplicantInfo.Gender!=null) {
        	driver.findElement(By.xpath("//label[@for='CoveredMembers_0__Gender']/..//div[1]//input")).click();
        	By GenderApplicant = By.xpath("//label[@for='CoveredMembers_0__Gender']/..//div[1]//ul");
        	select(GenderApplicant, ApplicantInfo.Gender);
        	
        	writeText(DOB1, ApplicantInfo.DOB);
        	
        	if(ApplicantInfo.Tobacco) {
        		click(TobaccoApplicant);
        		click(TobaccoYes1);
    			
    		}
    		if(ApplicantInfo.IsPregnant) {
    			click(IsPregnantApplicant);
        		
    		}
        }
        
        if(SpouseInfo!=null&&SpouseInfo.Gender!=null) {
        	click(AddSpousebtn);
        	WaitWrapper.waiter(3000, " ", driver);
        	
        	driver.findElement(By.xpath("//label[@for='CoveredMembers_1__Gender']/..//div[1]//input")).click();
        	String genderCode = (SpouseInfo.Gender.equalsIgnoreCase("Male"))?"2":"3";
        	By GenderSpouse = By.xpath("//label[@for='CoveredMembers_1__Gender']/..//div[1]//ul/li["+genderCode+"]");
        	waitVisibility(GenderSpouse).click();
        	writeText(DOB2, SpouseInfo.DOB);
        	if(SpouseInfo.Tobacco) {
        		click(TobaccoSpouse);
        		click(TobaccoYes1);
    			
    		}
    		if(SpouseInfo.IsPregnant) {
    			click(IsPregnantSpouse);
        		
    		}
			
        }
       if(DependentsInfo!=null) {
    	   for(int d=0;d<DependentsInfo.size();d++){
    		   WaitWrapper.waiter(3000, " ", driver);
           	click(AddDependentbtn);
           	js.executeScript("window.scrollBy(0,80)");
           	CensusInfo dep = DependentsInfo.get(d);
           	int icount= d+2;
           	WaitWrapper.waiter(3000, " ", driver);
    		driver.findElement(By.xpath("//label[@for='CoveredMembers_"+icount+"__Gender']/..//div[1]//input")).click();
           	String  genderCode = dep.Gender.equalsIgnoreCase("Male")?"2":"3";
           	By DepGender = By.xpath("//label[@for='CoveredMembers_"+icount+"__Gender']/..//div[1]//ul/li["+genderCode+"]");
           	waitVisibility(DepGender).click();
           	By DOBelement = By.xpath("//*[@id=\"CoveredMembers_"+icount+"__DateOfBirth\"]");
           	writeText(DOBelement, dep.DOB);
           	
    	   }
        }
        
        js.executeScript("window.scrollBy(0,600)");
        WaitWrapper.waiter(2000, " ", driver);
		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id='CoveredMemberFamilyCount']/..//div//input")).click(); By
		 * HouseholdSize = By.xpath("//*[@id='CoveredMemberFamilyCount']/..//div//ul");
		 * select(HouseholdSize, ApplicantInfo.HouseholdSize);
		 */
        click(PlansandPrices);
        
    }
//	public PlanListingPage FillCensusDetailsandGetPlans(CensusInfo ApplicantInfo,CensusInfo SpouseInfo,ArrayList<CensusInfo> DependentsInfo) throws InterruptedException, ParseException {		
//		doFillCensusDetailsandGetPlan(ApplicantInfo,SpouseInfo,DependentsInfo);	
//		return new PlanListingPage(driver);
//	}
	
}
