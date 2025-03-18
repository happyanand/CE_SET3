package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionClasss {
	WebDriver driver;
	
	
	public static void movetoElementandClick(WebElement element , WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click();
		action.build().perform();
	}
	
	public static void click(WebElement element , WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.click(element);
		action.build().perform();
	}
	public static void movetoElementandsendKeys(WebElement element , WebDriver driver , String charseq)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.sendKeys(element, charseq);
		action.build().perform();
	}
	
	public static void movetoElementandDoubleClick(WebElement element , WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.doubleClick(element);
		action.build().perform();
			
	}
	
	//Added by Prabhleen
	public static void movetoElement(WebElement element , WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.build().perform();
	}
	
	public void dragAndDrop(WebElement Sourcelocator,WebElement Destinationlocator)
	
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
	}
	public static void ScrollToView(WebElement Locatortobeviewed,WebDriver driver)
	
	{
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].scrollIntoView(true);",Locatortobeviewed);
		 System.out.println("Scroll to view");
	}
	public static void JavascriptClick(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", element);
	}

	public static void JavascriptClick(WebElement element, WebDriver driver, String String) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", element);
		
	}

	public static void movetoElementandClick(WebElement element, WebDriver driver, String String) {
		// TODO Auto-generated method stub
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click();
		action.build().perform();
	}

	
}
