package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is contains a wait method that will wait until "please wait" is loaded. 
 * @author arun.chettur
 *
 */
public class WaitWrapper {
	WebDriver driver;
	
			
	public  static void waiter(int sleepTime,String comment , WebDriver driver)
	{
		try {
			
			do {

				Thread.sleep(sleepTime);
				System.out.println(comment);
			}	
			//while (driver.findElement(By.cssSelector(".metro.inner_wrapper.ng-scope.ovh")).isDisplayed());
			while (driver.findElement(By.cssSelector(".metro.inner_wrapper.ng-scope.page-loading")).isDisplayed());
			
		} catch (Exception e1) {
			
		}
	}
	
	
	
}
