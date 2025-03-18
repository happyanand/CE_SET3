package Common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.LogStatus;

/**
 * This class generates random string for different functions like name ,
 * address , ssnnumber generations.
 * 
 * @author arun.chettur
 *
 */
public class RandomGenerator {
	//static ExtentReports reportLogger = ExtentReports.get(RandomGenerator.class);
	WebDriver driver;
	
	public static ArrayList<String> allnames = new ArrayList<String>();
	public static ArrayList<String> groupNames = new ArrayList<String>();
	public static String nameGenerator(WebElement Name) throws Exception {
		
		Random r=  new Random();
		
		allnames.add("Johan");
		allnames.add("Edison");
		allnames.add("Sincere");
		allnames.add("Peter");
		allnames.add("Alan");
		allnames.add("Alex");
		allnames.add("David");
		allnames.add("Cefai");
		allnames.add("Randy");
		allnames.add("Watson");
		allnames.add("Nikolas");
		allnames.add("Quincy");
		allnames.add("Shepherd");
		allnames.add("Brycen");
		allnames.add("Marvin");
		allnames.add("Dariel");
		allnames.add("Axton");
		allnames.add("Donald");
		allnames.add("Bodie");
		allnames.add("Finnley");
		allnames.add("Onyx");
		allnames.add("Rayan");
		allnames.add("Brixton");
		allnames.add("Colby");
		allnames.add("Shiloh");
		allnames.add("Valentino");
		allnames.add("Layton");
		allnames.add("Trenton");
		allnames.add("Calaway");
		allnames.add("Landyn");		
		String name=allnames.get(r.nextInt(allnames.size()));
		
		return name;
	}

	public static void addressGenerator(WebElement contactno, WebElement address, WebElement countrybtn,
			WebElement countryvalue, WebElement citybtn, WebElement cityvalue, WebElement statebtn,
			WebElement statevalue, WebElement zipcode, String zip) throws Exception {

		String billingaddress = null;
		Random rng0a = new Random();
		billingaddress = generateString(rng0a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ123467890", 6).toUpperCase();

		zipcode.click();
		zipcode.sendKeys(zip);
		Thread.sleep(1000);

		contactno.click();
		contactno.sendKeys("2223333333");
		address.sendKeys(billingaddress);

		countrybtn.click();
		countryvalue.click();
		citybtn.click();
		cityvalue.click();
		statebtn.click();
		statevalue.click();
		//reportLogger.log(LogStatus.INFO, "Address		" + billingaddress + "zip code		" + zip);
	}

	public static String ssnGenerator(WebElement ssn, WebDriver driver, String type) {
		String ssnnumber = null;
		Random rng0ssn = new Random();
		ssnnumber = generateString(rng0ssn, "12345678", 9);
		System.out.println("ssnnumber " + ssnnumber);
		ActionClasss.movetoElementandsendKeys(ssn, driver, ssnnumber);
		/*
		 * Actions action = new Actions(driver); action.moveToElement(ssn);
		 * action.sendKeys(ssn, ssnnumber); action.build().perform();
		 */
	//	reportLogger.log(LogStatus.INFO, "" + type + "	SSN		" + ssnnumber);
		System.out.println("ssn number"+ssnnumber);
		return ssnnumber;

	}
	
	public static String randomNumberGenerator(WebDriver driver, String type) {
		String randomNum = null;
		Random rng0ssn = new Random();
		randomNum = generateString(rng0ssn, "12345678", 9);
		System.out.println("randomNumber: " + randomNum);
	
		/*
		 * Actions action = new Actions(driver); action.moveToElement(ssn);
		 * action.sendKeys(ssn, ssnnumber); action.build().perform();
		 */
	//	reportLogger.log(LogStatus.INFO, "" + type + "	SSN		" + ssnnumber);
		
		return randomNum;

	}

	// Method for generating random string to avoid duplication while inputting
	// First and last name
	private static String generateString(Random rng, String characters, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}
	
	
public static String nameGenerator( WebElement fstname, WebElement LstName) throws Exception {
		
		Random r=  new Random();
		
		allnames.add("Mark");
		allnames.add("Antony");
		allnames.add("Kevin");
		allnames.add("Peter");
		allnames.add("Alan");
		allnames.add("Alex");
		allnames.add("David");
		allnames.add("Cefai");
		allnames.add("Randy");
		allnames.add("Calaway");
		
		String firstName=allnames.get(r.nextInt(allnames.size()));
		Thread.sleep(300);
		String lastName=allnames.get(r.nextInt(allnames.size()));
		
		
		
		
		
		/*String firstName = null;
		Random rng0F = new Random();
		firstName = generateString(rng0F, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 10).toUpperCase();*/

		String middleName = null;
		Random rng0M = new Random();
		middleName = generateString(rng0M, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).toUpperCase();
/*
		String lastName = null;
		Random rng0L = new Random();
		lastName = generateString(rng0L, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 10).toUpperCase();*/
		
		try {
			
			
			fstname.sendKeys(firstName);
			//midName.sendKeys(middleName);
			LstName.sendKeys(lastName);
			
		} catch (Exception e) {

		}
		String employeeFullName=firstName+" "+middleName+" "+lastName;
		//reportLogger.log(LogStatus.INFO, "" + groupname + "		" + firstName + "	" + middleName + "	" + lastName);
		return employeeFullName;
	}
public static String nameGeneratorWithoutMiddleName( WebElement fstname, WebElement LstName) throws Exception {
	
	Random r=  new Random();
	
	allnames.add("Marks");
	allnames.add("Antonys");
	allnames.add("Kevins");
	allnames.add("Peters");
	allnames.add("Alans");
	allnames.add("Alexs");
	allnames.add("Davids");
	allnames.add("Cefais");
	allnames.add("Randys");
	allnames.add("Calaways");
	allnames.add("Mathew");
	allnames.add("John");
	allnames.add("Jolly");
	allnames.add("Joy");
	allnames.add("Susan");
	allnames.add("Theresa");
	allnames.add("Luois");
	allnames.add("Sara");
	allnames.add("Mike");
	allnames.add("Katherine");
	
	String firstName=allnames.get(r.nextInt(allnames.size()));
	Thread.sleep(300);
	String lastName=allnames.get(r.nextInt(allnames.size()));
	
	String middleName = null;
	Random rng0M = new Random();
	middleName = generateString(rng0M, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).toUpperCase();

	
	try {
		
		
		fstname.sendKeys(firstName);
		//midName.sendKeys(middleName);
		LstName.sendKeys(lastName);
		
	} catch (Exception e) {

	}
	String employeeFullName=firstName+" "+lastName;
	//reportLogger.log(LogStatus.INFO, "" + groupname + "		" + firstName + "	" + middleName + "	" + lastName);
	return employeeFullName;
}

public static String UniqueNameGenerator( By firstname2) throws Exception {
	
	Random r=  new Random();
	
	allnames.add("Marks");
	allnames.add("Antonys");
	allnames.add("Kevins");
	allnames.add("Peters");
	allnames.add("Alans");
	allnames.add("Alexs");
	allnames.add("Davids");
	allnames.add("Cefais");
	allnames.add("Randys");
	allnames.add("Calaways");
	allnames.add("Mathew");
	allnames.add("John");
	allnames.add("Jolly");
	allnames.add("Joy");
	allnames.add("Susan");
	allnames.add("Theresa");
	allnames.add("Luois");
	allnames.add("Sara");
	allnames.add("Mike");
	allnames.add("Katherine");
	allnames.add("Ajith");
	allnames.add("Johan");
	allnames.add("Edison");
	allnames.add("Sincere");
	allnames.add("Peter");
	allnames.add("Alan");
	allnames.add("Alex");
	allnames.add("David");
	allnames.add("Cefai");
	allnames.add("Randy");
	allnames.add("Watson");
	allnames.add("Nikolas");
	allnames.add("Quincy");
	allnames.add("Shepherd");
	allnames.add("Brycen");
	allnames.add("Marvin");
	allnames.add("Dariel");
	allnames.add("Axton");
	allnames.add("Donald");
	allnames.add("Bodie");
	allnames.add("Finnley");
	allnames.add("Onyx");
	allnames.add("Rayan");
	allnames.add("Brixton");
	allnames.add("Colby");
	allnames.add("Shiloh");
	allnames.add("Valentino");
	allnames.add("Layton");
	allnames.add("Trenton");
	allnames.add("Calaway");
	allnames.add("Landyn");
	
	String firstName=allnames.get(r.nextInt(allnames.size()));
	Thread.sleep(300);
	//String lastName=allnames.get(r.nextInt(allnames.size()));
	
	String middleName = null;
	Random rng0M = new Random();
	middleName = generateString(rng0M, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).toUpperCase();

	
	try {
		
		
		((WebElement) firstname2).sendKeys(firstName);
		//midName.sendKeys(middleName);
		//LstName.sendKeys(lastName);
		
	} catch (Exception e) {

	}
	String employeeFullName=firstName;
	//reportLogger.log(LogStatus.INFO, "" + groupname + "		" + firstName + "	" + middleName + "	" + lastName);
	return employeeFullName;
}


public static String rNameGenerator(WebElement fstName)
{
	String uuid = UUID.randomUUID().toString();
    String fName = "Test" + uuid;
    String lName = "Last Test" + uuid;
	
	return fName + lName;

}


public static String emailGenerator(WebElement email) 
{
	String emailGen = null;
	Random rng0a = new Random();
	emailGen = generateString(rng0a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ123467890", 20).toLowerCase()+"@gamail.com";
	email.clear();
	//ActionClasss.movetoElementandsendKeys(email, driver, emailGen);
   email.sendKeys(emailGen);
	return emailGen;
}

public static String emailGenerator(int size) 
{
	String emailGen = null;
	Random rng0a = new Random();
	emailGen = generateString(rng0a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ123467890", size).toLowerCase()+"@gamail.com";
	return emailGen;
}

public static String phoneNumGenerator(WebElement phoneNum) 
{
	String phno = null;
	Random rng0a = new Random();
	phno = generateString(rng0a, "2346789", 10);
	phoneNum.clear();
	phoneNum.sendKeys(phno);
	return phno;
}

public static String generateTimestampwithComment(WebElement ele , String message)
{
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	ele.clear();
	ele.sendKeys(message+"\t"+timeStamp);
	return timeStamp;
}
public static String generateTimestamp(WebElement ele)
{
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	ele.clear();
	ele.sendKeys(timeStamp);
	return timeStamp;
}

public static String generateTimestamp(WebElement ele, String formatforBE)
{
	String timeStamp = new SimpleDateFormat("yyyy MM dd HH mm ss").format(new java.util.Date());
	ele.clear();
	ele.sendKeys(timeStamp);
	return timeStamp;
}

public static String generateTimestamp()
{
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

	return timeStamp;
}

public static String alphanumbericGenerator(int size)
{
	String alphanum = null;
	Random rng0a = new Random();
	alphanum = generateString(rng0a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ123467890", size);
	return alphanum;
}

public static String alphabetGenerator(int size)
{
	String alphanum = null;
	Random rng0a = new Random();
	alphanum = generateString(rng0a, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", size);
	return alphanum;
}

public static String numberGenerator(int size)
{
	String number = null;
	Random rng0a = new Random();
	number = generateString(rng0a, "12346789", size);
	return number;
}

public static String ssnNumberGenerator()
{
	String number = null;
	Random rng0a = new Random();
	number = generateString(rng0a, "1234678", 9);
	return number;
}


}
