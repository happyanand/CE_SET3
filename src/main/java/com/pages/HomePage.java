package com.pages;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.WaitWrapper;
import Utility.ExcelHelper;
import Utility.Logs.Log;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");

	private	By signInButtonClass = By.className("btnSignIn");
	private	By signout = By.xpath("//a[@class=\"dropdownMenu user-details-menuSection dropdownArrowMenu\"]");
	private	By signoutbtn = By.xpath("//*[@id='dropdownMenuListSec']//a[contains(text(),'Sign Out')]");
	private	By signoutInshura = By.xpath("//div[@class=\"signoutsec\"]");


	public HomePage goToTC() {
		String TCURL = tcTestData.getRow(1).getCell(1).toString();
		Log.info("Opening Truecoverage Website.");
		driver.get(TCURL);
		return this;
	}

	public HomePage Logout() throws InterruptedException {
		Log.info("Logging out");
		WaitWrapper.waiter(3000, "Sign out", driver);
		click(signout);

		try {
			click(signoutbtn);

		} catch (Exception e) {
			click(signoutInshura);
		}
		WaitWrapper.waiter(3000, "Sign out", driver);
		driver.close();
		return this;
	}

	// Go to LoginPage
	public LoginPage goToLoginPage() {
		Log.info("Going to Login Page..");
		// click(signInButtonClass);
		// driver.findElement(By.xpath("//a[@id='login']")).click();// required for UAT
		// ture cov only
		return new LoginPage(driver);
	}

	public Object doQuotingFlow(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Quote and Enroll");
		Thread.sleep(2000);
		By QuoteandEnroll = By
				.xpath("/html/body/app-root/app-dashboard-router/div[1]/app-portal-header/div/div/ul/li[1]/a/label");
		By QuoteNow = By.xpath("//*[text()=\"Quote Now\"]");
		By Medical = By.xpath("//*[@id=\"dropdownMenuListSec\"]/div/div[1]/div/div[1]/div[1]/a/bdo");
		click(QuoteNow);
		click(Medical);
		Thread.sleep(4000);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doMarketplaceFlow_Inshra(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Marketplace");
		Thread.sleep(4000);
		By Marketplace = By.xpath("//div[@class='nav-wrapper']//span[contains(text(),'Marketplace')]");
		click(Marketplace);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doFindInsurance(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Quote and Enroll");
		Thread.sleep(4000);
		By QuoteNow = By.xpath("//a[contains(text(),'Find Insurance')]");
		By Medical = By.xpath("//div[@class='dropdownMenuList']//a[contains(text(),'Health')]");
		click(QuoteNow);
		click(QuoteNow);
		click(Medical);
		Thread.sleep(5000);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doMarketplaceFlow(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Marketplace");
		Thread.sleep(4000);
		By Marketplace = By.xpath("//div[@class='nav-wrapper']//span[contains(text(),'Marketplace')]");
		click(Marketplace);
		Thread.sleep(4000);
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public Object doBEMarketplaceFlow(String className) throws ClassNotFoundException, InterruptedException {
		Log.info("Going to Marketplace");
		Thread.sleep(4000);
		By Marketplace = By.xpath("//a[@class='AccessGoToFFMss']");	
		click(Marketplace);
		Thread.sleep(3000);
		Log.info("clicked Marketplace");
		return PageFactory.initElements(driver, Class.forName(className));
	}

	public static void main(String[] args) {
		// homepage.Logout();
	}

}