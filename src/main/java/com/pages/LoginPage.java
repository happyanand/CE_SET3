package com.pages;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Common.Main;
import Common.WaitWrapper;
import Utility.Logs.Log;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By userID = By.id("Item2_UserName");
	By pwd = By.id("Item2_Password");
	By captcha = By.xpath("//label[@id='recaptcha-anchor-label']/..");
	By signIn = By.xpath("//a[@id='SignIn']");
	By btnYesSessionPopUp = By
			.xpath("//*[@Class='modal-close waves-effect waves-light btn primary_background ConfirmForceLogin']");
	By errorMessageUsernameXpath = By.xpath("//*[@id=\"passwordHelp\"]");
	By ConfirmMsg = By.xpath("//*[@id=\"//*[@id=\"forceLogoutConfirm\"]/div[2]/a[2]\"]");
	// label[@id='recaptcha-anchor-label']/..//li//span

	public LoginPage loginToInshura(String username, String password, ExtentTest extentreport) throws InterruptedException {
		Log.info("Trying to login the N11.");
		writeText(userID, username);
		writeText(pwd, password);
		// click(captcha);
		WaitWrapper.waiter(4000, "SignIn", driver);
		click(signIn);
		WaitWrapper.waiter(10000, " ", driver);
		try {
			// Actions action = new Actions(driver);
			// action.moveToElement(btnYesSessionPopUp).click();
			click(btnYesSessionPopUp);
			extentreport.log(Status.PASS, "Logged in Successfully");
			Main.loginStatus = true;
			System.out.println("Logged In successfully");
			Main.test.log(Status.PASS, "Logged in successfully");
			WaitWrapper.waiter(5000, "Application loading..", driver);

		} catch (Exception e) {
			System.out.println("Session Pop Up Not Appeared This Time");
			extentreport.log(Status.INFO, "Session Pop Up Not Appeared This Time");
		}

		return this;
	}

	public LoginPage loginToBE(String username, String password, ExtentTest extentreport) throws InterruptedException {
		Log.info("Trying to login the N11.");
		writeText(userID, username);
		writeText(pwd, password);
		WaitWrapper.waiter(4000, "SignIn", driver);
		click(signIn);
		WaitWrapper.waiter(7000, "signed In", driver);
		Thread.sleep(3000);
		try {
			By Confirmpopup = By.xpath("//*[@id=\"forceLogoutConfirm\"]//a[2]");
			click(Confirmpopup);
			WaitWrapper.waiter(9000, "Confirm message pop up appeared", driver);
			extentreport.log(Status.PASS, "Logged in Successfully");
			Main.loginStatus = true;
			System.out.println("Logged In successfully");
			Main.test.log(Status.PASS, "Logged in successfully");
			WaitWrapper.waiter(9000, "Application loading..", driver);
			// driver.switchTo().Window(driver.Win.Last());
		} catch (Exception e) {
			System.out.println("Session Pop Up Not Appeared This Time");
			extentreport.log(Status.INFO, "Session Pop Up Not Appeared This Time");
		}

		return this;
	}

	// Verify login Condition
	public LoginPage verifyLoginUserName(String expectedText) {
		Log.info("Verifying login username.");
		waitVisibility(errorMessageUsernameXpath);
		assertEquals(readText(errorMessageUsernameXpath), expectedText);
		return this;
	}

}