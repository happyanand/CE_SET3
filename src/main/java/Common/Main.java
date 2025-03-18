package Common;


import java.io.File;
import java.time.Instant;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Utility.Log;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.HomePage;

import Utility.ReadProperty;
import Utility.TimeFinder;

public class Main {
	
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static String NewApplicantName;
    public static String NewClientName;
    public static String seglstnme;
    public static String EditedAgentName;
    public static String ReportFileName= System.getProperty("user.dir") +"/test-output/InshuraAutomationReport_"+Instant.now().getEpochSecond()+".html";
    @BeforeSuite
    public void setUp()
    {
        htmlReporter = new ExtentHtmlReporter(ReportFileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", "Mac Sierra");
        extent.setSystemInfo("Product Name", "Inshura");
        extent.setSystemInfo("Author", "Benefitalign");
         
        //((Object) htmlReporter.config()).setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("Inshura Automation Report");
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        String css = ".r-img {width: 20%;}";
        htmlReporter.config().setCSS(css);
        
    }
     
    @AfterMethod
    public void getResult(ITestResult result)
    {
    	String currentTestName = result.getName();
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(currentTestName+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
			
			  try {
	//		  WebDriver tdriver=LocalDriverManager.getDriver();
			  TakesScreenshot ts = (TakesScreenshot) driver; 
			  File source = ts.getScreenshotAs(OutputType.FILE);
	//		  String screenShotPath = Screenshot.capture(driver, "screenShotName");
			  //File target = new File("./Screenshots/" +currentTestName+TimeFinder.currentSystemTimeWithUnderscore() + ".png");
			  FileUtils.copyFile(source, new File("./Screenshots/" +currentTestName+TimeFinder.currentSystemTimeWithUnderscore() + ".png"));
			  System.out.println("Screenshot Taken Successfully...");
			  test.log(Status.FAIL, result.getThrowable());
	//		  test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
			  } catch (Exception e) {
			  System.out.println("Exception While Taking Screenshot... ERROR !!!" +
			  e.getMessage());
			  }
			 

        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(currentTestName+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(currentTestName+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

	
	
    public static WebDriver driver;
    public static HomePage  homepage;
    static Utility.ReadProperty readproperty = new ReadProperty();
    static String chromedriverPath = readproperty.loadProperty("chromepath");
    public static boolean loginStatus = false;

    public WebDriver getDriver() {
    	homepage = new HomePage(driver);
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        System.out.println("Test one");
        if(driver==null)
        driver = createInstance("chrome");
    }

    @BeforeMethod
    public void methodLevelSetup() {
    	homepage = new HomePage(driver);
    }

	/*
	 * @AfterClass public void teardown() { Log.info("Tests are ending!"); //
	 * driver.quit(); }
	 */
    public static WebDriver createInstance(String webBrowser) {
		int flag =0;
				
		if(webBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "" + chromedriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            flag=0;
            
			driver.manage().window().maximize();
			return driver;
		}
		
		else if(webBrowser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			flag=1;
			return driver;
		}
		
		else if(webBrowser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			flag=2;
			return driver;
		}
		
//		else if(webBrowser.equalsIgnoreCase("opera"))
//		{
//			driver = new OperaDriver();
//			flag=3;
//			return driver;
//		}
		
		else
		{
			System.out.println("INVALID BROWSER OPTED....!!!! ");
			return null;
		}
		
	}
	@AfterSuite
	public void sharingReport()
	{
		
		extent.flush();
		//driver.quit();
		if(readproperty.loadProperty("triggermail").equalsIgnoreCase("Yes"))
		{
			try {
				TriggerEmail.sendReport();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	
	}
}
